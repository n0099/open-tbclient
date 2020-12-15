package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private String mFrom = BarDetailForDirSwitch.BAR_DETAIL_DIR;
    private a nkU;

    /* loaded from: classes.dex */
    public interface a {
        void C(String str, long j);

        void D(String str, long j);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a aVar) {
        this.nkU = aVar;
    }

    public void O(String str, long j) {
        new b(str, j, this.mFrom, this.nkU, this, null).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String authSid;
        private int errorCode;
        private String errorMsg;
        private long mForumId;
        private String mForumName;
        private String mFrom;
        private com.baidu.tbadk.core.util.aa mNetwork = null;
        private WeakReference<a> nkV;
        private WeakReference<ae> nkW;
        private AuthTokenData tokenData;

        public b(String str, long j, String str2, a aVar, ae aeVar, String str3) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.nkV = null;
            this.nkW = new WeakReference<>(aeVar);
            this.mForumName = str;
            this.mForumId = j;
            this.nkV = new WeakReference<>(aVar);
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
                    this.mNetwork.btv().bue().mIsNeedTbs = true;
                    String postNetData = this.mNetwork.postNetData();
                    if (!au.isEmpty(postNetData) && (jSONObject = new JSONObject(postNetData)) != null) {
                        this.errorCode = jSONObject.optInt("error_code");
                        this.errorMsg = jSONObject.optString(AlaRecorderLog.KEY_ERROR_MSG);
                        this.tokenData = AuthTokenData.parse(jSONObject);
                    }
                    if (this.mNetwork.btv().buf().isRequestSuccess()) {
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
            if (this.nkV != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.nkV.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.btv().buf().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.mForumName);
                        aVar2.C(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            String errorString = this.mNetwork.isNetSuccess() ? this.mNetwork.getErrorString() : this.mNetwork.btw();
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
