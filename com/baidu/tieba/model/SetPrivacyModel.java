package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes18.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String jRz = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private z byq;
    private boolean isRunning;
    private CardPersonDynamicThreadData jRA;
    private b jRB;
    private a jRC;

    /* loaded from: classes18.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.jRA = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.jRC = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.jRB != null) {
            return false;
        }
        this.jRB = new b();
        this.jRB.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.jRB.execute(this.jRA);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jRB != null) {
            this.jRB.cancel();
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
                SetPrivacyModel.this.byq = new z(SetPrivacyModel.jRz);
                SetPrivacyModel.this.byq.bav().baW().mIsNeedTbs = true;
                SetPrivacyModel.this.byq.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.byq.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.byq.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.byq.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.byq.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.byq.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.byq.bav().baX().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.byq != null) {
                SetPrivacyModel.this.byq.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.jRB = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.jRB = null;
            if (SetPrivacyModel.this.jRC != null && SetPrivacyModel.this.byq != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.jRC.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.jRC.onError(SetPrivacyModel.this.byq.getErrorString());
                }
            }
        }
    }
}
