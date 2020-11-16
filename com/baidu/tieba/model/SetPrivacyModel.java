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
    private static final String kXB = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private aa bZh;
    private boolean isRunning;
    private CardPersonDynamicThreadData kXC;
    private b kXD;
    private a kXE;

    /* loaded from: classes23.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(com.baidu.adp.base.e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.kXC = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.kXE = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.kXD != null) {
            return false;
        }
        this.kXD = new b();
        this.kXD.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.kXD.execute(this.kXC);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kXD != null) {
            this.kXD.cancel();
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
                SetPrivacyModel.this.bZh = new aa(SetPrivacyModel.kXB);
                SetPrivacyModel.this.bZh.bqa().bqH().mIsNeedTbs = true;
                SetPrivacyModel.this.bZh.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.bZh.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.bZh.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.bZh.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.bZh.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.bZh.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.bZh.bqa().bqI().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.bZh != null) {
                SetPrivacyModel.this.bZh.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kXD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kXD = null;
            if (SetPrivacyModel.this.kXE != null && SetPrivacyModel.this.bZh != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.kXE.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.kXE.onError(SetPrivacyModel.this.bZh.getErrorString());
                }
            }
        }
    }
}
