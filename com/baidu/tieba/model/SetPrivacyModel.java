package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes18.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String khe = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private aa bEb;
    private boolean isRunning;
    private CardPersonDynamicThreadData khf;
    private b khg;
    private a khh;

    /* loaded from: classes18.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(com.baidu.adp.base.e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.khf = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.khh = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.khg != null) {
            return false;
        }
        this.khg = new b();
        this.khg.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.khg.execute(this.khf);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.khg != null) {
            this.khg.cancel();
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
                SetPrivacyModel.this.bEb = new aa(SetPrivacyModel.khe);
                SetPrivacyModel.this.bEb.biQ().bjv().mIsNeedTbs = true;
                SetPrivacyModel.this.bEb.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.bEb.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.bEb.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.bEb.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.bEb.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.bEb.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.bEb.biQ().bjw().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.bEb != null) {
                SetPrivacyModel.this.bEb.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.khg = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.khg = null;
            if (SetPrivacyModel.this.khh != null && SetPrivacyModel.this.bEb != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.khh.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.khh.onError(SetPrivacyModel.this.bEb.getErrorString());
                }
            }
        }
    }
}
