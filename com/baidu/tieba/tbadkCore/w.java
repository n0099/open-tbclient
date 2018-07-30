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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private a gNe;
    private String mFrom = "bar_detail";

    /* loaded from: classes.dex */
    public interface a {
        void m(String str, long j);

        void n(String str, long j);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a aVar) {
        this.gNe = aVar;
    }

    public void t(String str, long j) {
        new b(str, j, this.mFrom, this.gNe).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private int errorCode;
        private String errorMsg;
        private WeakReference<a> gNf;
        private long mForumId;
        private String mForumName;
        private String mFrom;
        private y mNetwork = null;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.gNf = null;
            this.mForumName = str;
            this.mForumId = j;
            this.gNf = new WeakReference<>(aVar);
            this.mFrom = str2;
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
                    this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                    this.mNetwork.o("kw", this.mForumName);
                    this.mNetwork.o("favo_type", "1");
                    this.mNetwork.o("st_type", this.mFrom);
                    this.mNetwork.yO().zM().mIsNeedTbs = true;
                    String yq = this.mNetwork.yq();
                    if (!ap.isEmpty(yq) && (jSONObject = new JSONObject(yq)) != null) {
                        this.errorCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
                        this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                    }
                    if (this.mNetwork.yO().zN().isRequestSuccess()) {
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
            if (this.gNf != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.gNf.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.yO().zN().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.mForumName);
                        aVar2.m(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            String errorString = this.mNetwork.yR() ? this.mNetwork.getErrorString() : this.mNetwork.yU();
                            aVar.errorMessage = errorString;
                            aVar2.n(errorString, this.errorCode);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, aVar));
                }
            }
        }
    }
}
