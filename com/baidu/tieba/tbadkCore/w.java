package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private a gUJ;
    private String mFrom = "bar_detail";

    /* loaded from: classes.dex */
    public interface a {
        void o(String str, long j);

        void p(String str, long j);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a aVar) {
        this.gUJ = aVar;
    }

    public void v(String str, long j) {
        new b(str, j, this.mFrom, this.gUJ, this, null).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String authSid;
        private int errorCode;
        private String errorMsg;
        private WeakReference<a> gUK;
        private WeakReference<w> gUL;
        private long mForumId;
        private String mForumName;
        private String mFrom;
        private x mNetwork = null;
        private AuthTokenData tokenData;

        public b(String str, long j, String str2, a aVar, w wVar, String str3) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.gUK = null;
            this.gUL = new WeakReference<>(wVar);
            this.mForumName = str;
            this.mForumId = j;
            this.gUK = new WeakReference<>(aVar);
            this.mFrom = str2;
            this.authSid = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public Integer doInBackground(Integer... numArr) {
            JSONObject jSONObject;
            try {
                if (this.mForumId != 0 && this.mForumName != null) {
                    this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.u(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                    this.mNetwork.u("kw", this.mForumName);
                    this.mNetwork.u("favo_type", "1");
                    this.mNetwork.u("st_type", this.mFrom);
                    this.mNetwork.u("authsid", this.authSid);
                    this.mNetwork.zR().AP().mIsNeedTbs = true;
                    String zt = this.mNetwork.zt();
                    if (!ao.isEmpty(zt) && (jSONObject = new JSONObject(zt)) != null) {
                        this.errorCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
                        this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                        this.tokenData = AuthTokenData.parse(jSONObject);
                    }
                    if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                        return 1;
                    }
                }
                return 0;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            if (this.gUK != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.gUK.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.zR().AQ().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.mForumName);
                        aVar2.o(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            String errorString = this.mNetwork.zU() ? this.mNetwork.getErrorString() : this.mNetwork.zX();
                            aVar.errorMessage = errorString;
                            aVar2.p(errorString, this.errorCode);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, aVar));
                }
            }
        }
    }
}
