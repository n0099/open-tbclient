package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
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
    private a hcf;
    private String mFrom = "bar_detail";

    /* loaded from: classes.dex */
    public interface a {
        void p(String str, long j);

        void q(String str, long j);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a aVar) {
        this.hcf = aVar;
    }

    public void w(String str, long j) {
        new b(str, j, this.mFrom, this.hcf, this, null).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String authSid;
        private int errorCode;
        private String errorMsg;
        private WeakReference<a> hcg;
        private WeakReference<w> hch;
        private long mForumId;
        private String mForumName;
        private String mFrom;
        private x mNetwork = null;
        private AuthTokenData tokenData;

        public b(String str, long j, String str2, a aVar, w wVar, String str3) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.hcg = null;
            this.hch = new WeakReference<>(wVar);
            this.mForumName = str;
            this.mForumId = j;
            this.hcg = new WeakReference<>(aVar);
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
                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                    this.mNetwork.x("kw", this.mForumName);
                    this.mNetwork.x("favo_type", "1");
                    this.mNetwork.x("st_type", this.mFrom);
                    this.mNetwork.x("authsid", this.authSid);
                    this.mNetwork.BY().CW().mIsNeedTbs = true;
                    String BA = this.mNetwork.BA();
                    if (!ao.isEmpty(BA) && (jSONObject = new JSONObject(BA)) != null) {
                        this.errorCode = jSONObject.optInt("error_code");
                        this.errorMsg = jSONObject.optString("error_msg");
                        this.tokenData = AuthTokenData.parse(jSONObject);
                    }
                    if (this.mNetwork.BY().CX().isRequestSuccess()) {
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
            if (this.hcg != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.hcg.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.BY().CX().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.mForumName);
                        aVar2.p(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            String errorString = this.mNetwork.Cb() ? this.mNetwork.getErrorString() : this.mNetwork.Ce();
                            aVar.errorMessage = errorString;
                            aVar2.q(errorString, this.errorCode);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, aVar));
                }
            }
        }
    }
}
