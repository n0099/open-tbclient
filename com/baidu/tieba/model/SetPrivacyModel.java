package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes11.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String jrE = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x bth;
    private boolean isRunning;
    private CardPersonDynamicThreadData jrF;
    private b jrG;
    private a jrH;

    /* loaded from: classes11.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.jrF = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.jrH = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.jrG != null) {
            return false;
        }
        this.jrG = new b();
        this.jrG.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.jrG.execute(this.jrF);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jrG != null) {
            this.jrG.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
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
                SetPrivacyModel.this.bth = new x(SetPrivacyModel.jrE);
                SetPrivacyModel.this.bth.aUA().aVb().mIsNeedTbs = true;
                SetPrivacyModel.this.bth.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.bth.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.bth.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.bth.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.bth.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.bth.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.bth.aUA().aVc().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.bth != null) {
                SetPrivacyModel.this.bth.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.jrG = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.jrG = null;
            if (SetPrivacyModel.this.jrH != null && SetPrivacyModel.this.bth != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.jrH.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.jrH.onError(SetPrivacyModel.this.bth.getErrorString());
                }
            }
        }
    }
}
