package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private a kaU;
    private String mFrom = BarDetailForDirSwitch.BAR_DETAIL_DIR;

    /* loaded from: classes.dex */
    public interface a {
        void C(String str, long j);

        void D(String str, long j);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a aVar) {
        this.kaU = aVar;
    }

    public void K(String str, long j) {
        new b(str, j, this.mFrom, this.kaU, this, null).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String authSid;
        private int errorCode;
        private String errorMsg;
        private WeakReference<a> kaV;
        private WeakReference<y> kaW;
        private long mForumId;
        private String mForumName;
        private String mFrom;
        private com.baidu.tbadk.core.util.x mNetwork = null;
        private AuthTokenData tokenData;

        public b(String str, long j, String str2, a aVar, y yVar, String str3) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.kaV = null;
            this.kaW = new WeakReference<>(yVar);
            this.mForumName = str;
            this.mForumId = j;
            this.kaV = new WeakReference<>(aVar);
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
                    this.mNetwork = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.addPostData("fid", String.valueOf(this.mForumId));
                    this.mNetwork.addPostData("kw", this.mForumName);
                    this.mNetwork.addPostData("favo_type", "1");
                    this.mNetwork.addPostData("st_type", this.mFrom);
                    this.mNetwork.addPostData("authsid", this.authSid);
                    this.mNetwork.aDB().aEb().mIsNeedTbs = true;
                    String postNetData = this.mNetwork.postNetData();
                    if (!aq.isEmpty(postNetData) && (jSONObject = new JSONObject(postNetData)) != null) {
                        this.errorCode = jSONObject.optInt("error_code");
                        this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                        this.tokenData = AuthTokenData.parse(jSONObject);
                    }
                    if (this.mNetwork.aDB().aEc().isRequestSuccess()) {
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
            if (this.kaV != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.kaV.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.aDB().aEc().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.mForumName);
                        aVar2.C(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            String errorString = this.mNetwork.isNetSuccess() ? this.mNetwork.getErrorString() : this.mNetwork.aDC();
                            aVar.errorMessage = errorString;
                            aVar2.D(errorString, this.errorCode);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM, aVar));
                }
            }
        }
    }
}
