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
    private static final String kXj = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private aa caS;
    private boolean isRunning;
    private CardPersonDynamicThreadData kXk;
    private b kXl;
    private a kXm;

    /* loaded from: classes24.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(com.baidu.adp.base.e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.kXk = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.kXm = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.kXl != null) {
            return false;
        }
        this.kXl = new b();
        this.kXl.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.kXl.execute(this.kXk);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kXl != null) {
            this.kXl.cancel();
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
                SetPrivacyModel.this.caS = new aa(SetPrivacyModel.kXj);
                SetPrivacyModel.this.caS.bqN().brt().mIsNeedTbs = true;
                SetPrivacyModel.this.caS.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.caS.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.caS.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.caS.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.caS.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.caS.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.caS.bqN().bru().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.caS != null) {
                SetPrivacyModel.this.caS.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kXl = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.kXl = null;
            if (SetPrivacyModel.this.kXm != null && SetPrivacyModel.this.caS != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.kXm.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.kXm.onError(SetPrivacyModel.this.caS.getErrorString());
                }
            }
        }
    }
}
