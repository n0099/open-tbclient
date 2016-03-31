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
public class ah extends com.baidu.adp.base.e {
    private a eot;
    private String mForumId;
    private String mForumName;

    public ah(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.eot = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aQp() {
        if (this.eot != null) {
            this.eot.cancel();
            this.eot = null;
        }
    }

    public void bB(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.eot == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.eot = new a(this, null);
            this.eot.setPriority(2);
            this.eot.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.ab aiW;

        private a() {
            this.aiW = null;
        }

        /* synthetic */ a(ah ahVar, a aVar) {
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
        /* renamed from: w */
        public SignData doInBackground(Object... objArr) {
            Object obj;
            Exception e;
            String vw;
            JSONObject jSONObject;
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            Object obj2 = null;
            try {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
                this.aiW = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.aiW.p("kw", ah.this.mForumName);
                this.aiW.p("fid", ah.this.mForumId);
                this.aiW.vU().wO().mIsNeedTbs = true;
                vw = this.aiW.vw();
            } catch (Exception e2) {
                obj = obj2;
                e = e2;
            }
            if (this.aiW.vX()) {
                obj = this.aiW.vU().wP().qC();
                try {
                    if (obj != 0) {
                        SignData signData = new SignData();
                        signData.parserJson(vw);
                        obj = signData;
                    } else if (!ay.isEmpty(vw) && (jSONObject = new JSONObject(vw)) != null && "199901".equals(jSONObject.optString(SocialConstants.PARAM_ERROR_CODE))) {
                        SignData signData2 = new SignData();
                        signData2.parserJson(vw);
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
            if (this.aiW != null) {
                this.aiW.gX();
            }
            ah.this.eot = null;
            super.cancel(true);
            ah.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            ah.this.eot = null;
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            if (signData == null && this.aiW != null) {
                ah.this.mErrorCode = this.aiW.vY();
                ah.this.mErrorString = this.aiW.getErrorString();
            }
            ah.this.mLoadDataCallBack.d(signData);
        }
    }
}
