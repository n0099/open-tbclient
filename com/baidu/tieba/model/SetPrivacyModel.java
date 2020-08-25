package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes18.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String kgX = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private aa bDY;
    private boolean isRunning;
    private CardPersonDynamicThreadData kgY;
    private b kgZ;
    private a kha;

    /* loaded from: classes18.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(com.baidu.adp.base.e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.kgY = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.kha = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.kgZ != null) {
            return false;
        }
        this.kgZ = new b();
        this.kgZ.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.kgZ.execute(this.kgY);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kgZ != null) {
            this.kgZ.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes18.dex */
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
                SetPrivacyModel.this.bDY = new aa(SetPrivacyModel.kgX);
                SetPrivacyModel.this.bDY.biQ().bjv().mIsNeedTbs = true;
                SetPrivacyModel.this.bDY.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.bDY.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.bDY.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.bDY.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.bDY.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.bDY.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.bDY.biQ().bjw().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.bDY != null) {
                SetPrivacyModel.this.bDY.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kgZ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kgZ = null;
            if (SetPrivacyModel.this.kha != null && SetPrivacyModel.this.bDY != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.kha.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.kha.onError(SetPrivacyModel.this.bDY.getErrorString());
                }
            }
        }
    }
}
