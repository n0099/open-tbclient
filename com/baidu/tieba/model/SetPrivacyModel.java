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
    private static final String kRn = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private aa bVi;
    private boolean isRunning;
    private CardPersonDynamicThreadData kRo;
    private b kRp;
    private a kRq;

    /* loaded from: classes24.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(com.baidu.adp.base.e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.kRo = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.kRq = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.kRp != null) {
            return false;
        }
        this.kRp = new b();
        this.kRp.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.kRp.execute(this.kRo);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kRp != null) {
            this.kRp.cancel();
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
                SetPrivacyModel.this.bVi = new aa(SetPrivacyModel.kRn);
                SetPrivacyModel.this.bVi.bon().boT().mIsNeedTbs = true;
                SetPrivacyModel.this.bVi.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.bVi.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.bVi.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.bVi.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.bVi.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.bVi.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.bVi.bon().boU().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.bVi != null) {
                SetPrivacyModel.this.bVi.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kRp = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kRp = null;
            if (SetPrivacyModel.this.kRq != null && SetPrivacyModel.this.bVi != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.kRq.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.kRq.onError(SetPrivacyModel.this.bVi.getErrorString());
                }
            }
        }
    }
}
