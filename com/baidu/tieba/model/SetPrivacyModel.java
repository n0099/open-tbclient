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
    private static final String kEQ = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private aa bML;
    private boolean isRunning;
    private CardPersonDynamicThreadData kER;
    private b kES;
    private a kET;

    /* loaded from: classes24.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(com.baidu.adp.base.e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.kER = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.kET = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.kES != null) {
            return false;
        }
        this.kES = new b();
        this.kES.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.kES.execute(this.kER);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kES != null) {
            this.kES.cancel();
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
                SetPrivacyModel.this.bML = new aa(SetPrivacyModel.kEQ);
                SetPrivacyModel.this.bML.bmu().bna().mIsNeedTbs = true;
                SetPrivacyModel.this.bML.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.bML.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.bML.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.bML.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.bML.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.bML.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.bML.bmu().bnb().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.bML != null) {
                SetPrivacyModel.this.bML.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kES = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kES = null;
            if (SetPrivacyModel.this.kET != null && SetPrivacyModel.this.bML != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.kET.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.kET.onError(SetPrivacyModel.this.bML.getErrorString());
                }
            }
        }
    }
}
