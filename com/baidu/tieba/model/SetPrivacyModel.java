package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes24.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String lkW = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private aa cfI;
    private boolean isRunning;
    private CardPersonDynamicThreadData lkX;
    private b lkY;
    private a lkZ;

    /* loaded from: classes24.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(com.baidu.adp.base.e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.lkX = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.lkZ = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lkY != null) {
            return false;
        }
        this.lkY = new b();
        this.lkY.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.lkY.execute(this.lkX);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lkY != null) {
            this.lkY.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes24.dex */
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
                SetPrivacyModel.this.cfI = new aa(SetPrivacyModel.lkW);
                SetPrivacyModel.this.cfI.btv().bue().mIsNeedTbs = true;
                SetPrivacyModel.this.cfI.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.cfI.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.cfI.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.cfI.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.cfI.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.cfI.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.cfI.btv().buf().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.cfI != null) {
                SetPrivacyModel.this.cfI.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.lkY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.lkY = null;
            if (SetPrivacyModel.this.lkZ != null && SetPrivacyModel.this.cfI != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.lkZ.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.lkZ.onError(SetPrivacyModel.this.cfI.getErrorString());
                }
            }
        }
    }
}
