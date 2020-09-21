package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes23.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String kpE = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private aa bGb;
    private boolean isRunning;
    private CardPersonDynamicThreadData kpF;
    private b kpG;
    private a kpH;

    /* loaded from: classes23.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(com.baidu.adp.base.e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.kpF = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.kpH = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.kpG != null) {
            return false;
        }
        this.kpG = new b();
        this.kpG.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.kpG.execute(this.kpF);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kpG != null) {
            this.kpG.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes23.dex */
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
                SetPrivacyModel.this.bGb = new aa(SetPrivacyModel.kpE);
                SetPrivacyModel.this.bGb.bjL().bkq().mIsNeedTbs = true;
                SetPrivacyModel.this.bGb.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.bGb.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.bGb.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.bGb.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.bGb.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.bGb.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.bGb.bjL().bkr().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.bGb != null) {
                SetPrivacyModel.this.bGb.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kpG = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kpG = null;
            if (SetPrivacyModel.this.kpH != null && SetPrivacyModel.this.bGb != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.kpH.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.kpH.onError(SetPrivacyModel.this.bGb.getErrorString());
                }
            }
        }
    }
}
