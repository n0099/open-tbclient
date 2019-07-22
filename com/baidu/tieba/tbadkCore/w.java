package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private a jeh;
    private String mFrom = "bar_detail";

    /* loaded from: classes.dex */
    public interface a {
        void u(String str, long j);

        void v(String str, long j);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a aVar) {
        this.jeh = aVar;
    }

    public void C(String str, long j) {
        new b(str, j, this.mFrom, this.jeh, this, null).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String authSid;
        private int errorCode;
        private String errorMsg;
        private WeakReference<a> jei;
        private WeakReference<w> jej;
        private long mForumId;
        private String mForumName;
        private String mFrom;
        private x mNetwork = null;
        private AuthTokenData tokenData;

        public b(String str, long j, String str2, a aVar, w wVar, String str3) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.jei = null;
            this.jej = new WeakReference<>(wVar);
            this.mForumName = str;
            this.mForumId = j;
            this.jei = new WeakReference<>(aVar);
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
                    this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.o("fid", String.valueOf(this.mForumId));
                    this.mNetwork.o("kw", this.mForumName);
                    this.mNetwork.o("favo_type", "1");
                    this.mNetwork.o("st_type", this.mFrom);
                    this.mNetwork.o("authsid", this.authSid);
                    this.mNetwork.aiE().ajE().mIsNeedTbs = true;
                    String aig = this.mNetwork.aig();
                    if (!aq.isEmpty(aig) && (jSONObject = new JSONObject(aig)) != null) {
                        this.errorCode = jSONObject.optInt("error_code");
                        this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                        this.tokenData = AuthTokenData.parse(jSONObject);
                    }
                    if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
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
            if (this.jei != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.jei.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.aiE().ajF().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.mForumName);
                        aVar2.u(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            String errorString = this.mNetwork.aiH() ? this.mNetwork.getErrorString() : this.mNetwork.aiK();
                            aVar.errorMessage = errorString;
                            aVar2.v(errorString, this.errorCode);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, aVar));
                }
            }
        }
    }
}
