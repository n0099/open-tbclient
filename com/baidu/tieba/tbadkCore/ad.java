package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ad {
    private String mFrom = BarDetailForDirSwitch.BAR_DETAIL_DIR;
    private a mdX;

    /* loaded from: classes2.dex */
    public interface a {
        void y(String str, long j);

        void z(String str, long j);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a aVar) {
        this.mdX = aVar;
    }

    public void K(String str, long j) {
        new b(str, j, this.mFrom, this.mdX, this, null).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String authSid;
        private int errorCode;
        private String errorMsg;
        private long mForumId;
        private String mForumName;
        private String mFrom;
        private com.baidu.tbadk.core.util.aa mNetwork = null;
        private WeakReference<a> mdY;
        private WeakReference<ad> mdZ;
        private AuthTokenData tokenData;

        public b(String str, long j, String str2, a aVar, ad adVar, String str3) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.mdY = null;
            this.mdZ = new WeakReference<>(adVar);
            this.mForumName = str;
            this.mForumId = j;
            this.mdY = new WeakReference<>(aVar);
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
                    this.mNetwork = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.addPostData("fid", String.valueOf(this.mForumId));
                    this.mNetwork.addPostData("kw", this.mForumName);
                    this.mNetwork.addPostData("favo_type", "1");
                    this.mNetwork.addPostData("st_type", this.mFrom);
                    this.mNetwork.addPostData("authsid", this.authSid);
                    this.mNetwork.biQ().bjv().mIsNeedTbs = true;
                    String postNetData = this.mNetwork.postNetData();
                    if (!at.isEmpty(postNetData) && (jSONObject = new JSONObject(postNetData)) != null) {
                        this.errorCode = jSONObject.optInt("error_code");
                        this.errorMsg = jSONObject.optString("error_msg");
                        this.tokenData = AuthTokenData.parse(jSONObject);
                    }
                    if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
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
            if (this.mdY != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.mdY.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.biQ().bjw().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.mForumName);
                        aVar2.y(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            String errorString = this.mNetwork.isNetSuccess() ? this.mNetwork.getErrorString() : this.mNetwork.biR();
                            aVar.errorMessage = errorString;
                            aVar2.z(errorString, this.errorCode);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM, aVar));
                }
            }
        }
    }
}
