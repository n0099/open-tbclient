package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai extends com.baidu.adp.base.e {
    private a erK;
    private String mForumId;
    private String mForumName;

    public ai(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.erK = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aQI() {
        if (this.erK != null) {
            this.erK.cancel();
            this.erK = null;
        }
    }

    public void bG(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.erK == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.erK = new a(this, null);
            this.erK.setPriority(2);
            this.erK.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.ab aeI;

        private a() {
            this.aeI = null;
        }

        /* synthetic */ a(ai aiVar, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x00d7 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x00a6 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:? */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v23, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r0v31 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tbadk.core.data.SignData] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public SignData doInBackground(Object... objArr) {
            Object obj;
            Exception e;
            String tc;
            JSONObject jSONObject;
            TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            Object obj2 = null;
            try {
                TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
                this.aeI = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.aeI.n("kw", ai.this.mForumName);
                this.aeI.n("fid", ai.this.mForumId);
                this.aeI.tA().uu().mIsNeedTbs = true;
                tc = this.aeI.tc();
            } catch (Exception e2) {
                obj = obj2;
                e = e2;
            }
            if (this.aeI.tD()) {
                obj = this.aeI.tA().uv().nZ();
                try {
                    if (obj != 0) {
                        SignData signData = new SignData();
                        signData.parserJson(tc);
                        obj = signData;
                    } else if (!ay.isEmpty(tc) && (jSONObject = new JSONObject(tc)) != null && "199901".equals(jSONObject.optString(SocialConstants.PARAM_ERROR_CODE))) {
                        SignData signData2 = new SignData();
                        signData2.parserJson(tc);
                        signData2.setIsSigned(1);
                        signData2.setCountSignNum(1);
                        obj2 = null;
                        signData2.setBonusPoint(0);
                        obj = signData2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return obj;
                }
                return obj;
            }
            obj = 0;
            return obj;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aeI != null) {
                this.aeI.dl();
            }
            ai.this.erK = null;
            super.cancel(true);
            ai.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            ai.this.erK = null;
            TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            if (signData == null && this.aeI != null) {
                ai.this.mErrorCode = this.aeI.tE();
                ai.this.mErrorString = this.aeI.getErrorString();
            }
            ai.this.mLoadDataCallBack.d(signData);
        }
    }
}
