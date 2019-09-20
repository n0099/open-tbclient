package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private a jhJ;
    private String mFrom = "bar_detail";

    /* loaded from: classes.dex */
    public interface a {
        void w(String str, long j);

        void x(String str, long j);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a aVar) {
        this.jhJ = aVar;
    }

    public void E(String str, long j) {
        new b(str, j, this.mFrom, this.jhJ, this, null).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String authSid;
        private int errorCode;
        private String errorMsg;
        private WeakReference<a> jhK;
        private WeakReference<y> jhL;
        private long mForumId;
        private String mForumName;
        private String mFrom;
        private com.baidu.tbadk.core.util.x mNetwork = null;
        private AuthTokenData tokenData;

        public b(String str, long j, String str2, a aVar, y yVar, String str3) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.jhK = null;
            this.jhL = new WeakReference<>(yVar);
            this.mForumName = str;
            this.mForumId = j;
            this.jhK = new WeakReference<>(aVar);
            this.mFrom = str2;
            this.authSid = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public Integer doInBackground(Integer... numArr) {
            JSONObject jSONObject;
            try {
                if (this.mForumId != 0 && this.mForumName != null) {
                    this.mNetwork = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.o("fid", String.valueOf(this.mForumId));
                    this.mNetwork.o("kw", this.mForumName);
                    this.mNetwork.o("favo_type", "1");
                    this.mNetwork.o("st_type", this.mFrom);
                    this.mNetwork.o("authsid", this.authSid);
                    this.mNetwork.aiK().ajM().mIsNeedTbs = true;
                    String aim = this.mNetwork.aim();
                    if (!aq.isEmpty(aim) && (jSONObject = new JSONObject(aim)) != null) {
                        this.errorCode = jSONObject.optInt("error_code");
                        this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                        this.tokenData = AuthTokenData.parse(jSONObject);
                    }
                    if (this.mNetwork.aiK().ajN().isRequestSuccess()) {
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
            if (this.jhK != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.jhK.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.aiK().ajN().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.mForumName);
                        aVar2.w(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            String errorString = this.mNetwork.aiN() ? this.mNetwork.getErrorString() : this.mNetwork.aiQ();
                            aVar.errorMessage = errorString;
                            aVar2.x(errorString, this.errorCode);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, aVar));
                }
            }
        }
    }
}
