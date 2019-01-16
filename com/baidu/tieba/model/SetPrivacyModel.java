package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes3.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String fHC = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private CardPersonDynamicThreadData fHD;
    private b fHE;
    private a fHF;
    private boolean isRunning;
    private x mNetWork;

    /* loaded from: classes3.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.fHD = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.fHF = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fHE != null) {
            return false;
        }
        this.fHE = new b();
        this.fHE.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.fHE.execute(this.fHD);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.fHE != null) {
            this.fHE.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
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
                SetPrivacyModel.this.mNetWork = new x(SetPrivacyModel.fHC);
                SetPrivacyModel.this.mNetWork.Dw().Eu().mIsNeedTbs = true;
                SetPrivacyModel.this.mNetWork.x("user_id", currentAccount);
                SetPrivacyModel.this.mNetWork.x("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.mNetWork.x("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.mNetWork.x("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.mNetWork.x("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.mNetWork.CY();
                return Integer.valueOf(SetPrivacyModel.this.mNetWork.Dw().Ev().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.mNetWork != null) {
                SetPrivacyModel.this.mNetWork.jg();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.fHE = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.fHE = null;
            if (SetPrivacyModel.this.fHF != null && SetPrivacyModel.this.mNetWork != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.fHF.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.fHF.onError(SetPrivacyModel.this.mNetWork.getErrorString());
                }
            }
        }
    }
}
