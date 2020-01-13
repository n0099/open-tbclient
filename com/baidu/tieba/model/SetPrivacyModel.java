package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes9.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String inB = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x cHA;
    private CardPersonDynamicThreadData inC;
    private b inD;
    private a inE;
    private boolean isRunning;

    /* loaded from: classes9.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.inC = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.inE = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.inD != null) {
            return false;
        }
        this.inD = new b();
        this.inD.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.inD.execute(this.inC);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.inD != null) {
            this.inD.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes9.dex */
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
                SetPrivacyModel.this.cHA = new x(SetPrivacyModel.inB);
                SetPrivacyModel.this.cHA.aDU().aEu().mIsNeedTbs = true;
                SetPrivacyModel.this.cHA.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.cHA.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.cHA.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.cHA.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.cHA.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.cHA.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.cHA.aDU().aEv().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.cHA != null) {
                SetPrivacyModel.this.cHA.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.inD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.inD = null;
            if (SetPrivacyModel.this.inE != null && SetPrivacyModel.this.cHA != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.inE.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.inE.onError(SetPrivacyModel.this.cHA.getErrorString());
                }
            }
        }
    }
}
