package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes6.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String hwK = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x bVP;
    private CardPersonDynamicThreadData hwL;
    private b hwM;
    private a hwN;
    private boolean isRunning;

    /* loaded from: classes6.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.hwL = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.hwN = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hwM != null) {
            return false;
        }
        this.hwM = new b();
        this.hwM.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.hwM.execute(this.hwL);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.hwM != null) {
            this.hwM.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<CardPersonDynamicThreadData, Integer, Integer> {
        public b() {
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            SetPrivacyModel.this.isRunning = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Integer doInBackground(CardPersonDynamicThreadData... cardPersonDynamicThreadDataArr) {
            if (cardPersonDynamicThreadDataArr == null || cardPersonDynamicThreadDataArr.length == 0 || cardPersonDynamicThreadDataArr[0] == null) {
                return null;
            }
            CardPersonDynamicThreadData cardPersonDynamicThreadData = cardPersonDynamicThreadDataArr[0];
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                SetPrivacyModel.this.bVP = new x(SetPrivacyModel.hwK);
                SetPrivacyModel.this.bVP.amr().amR().mIsNeedTbs = true;
                SetPrivacyModel.this.bVP.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.bVP.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.bVP.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.bVP.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.bVP.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.bVP.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.bVP.amr().amS().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.bVP != null) {
                SetPrivacyModel.this.bVP.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.hwM = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.hwM = null;
            if (SetPrivacyModel.this.hwN != null && SetPrivacyModel.this.bVP != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.hwN.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.hwN.onError(SetPrivacyModel.this.bVP.getErrorString());
                }
            }
        }
    }
}
