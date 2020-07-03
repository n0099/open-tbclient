package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes11.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String jIV = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private y byb;
    private boolean isRunning;
    private CardPersonDynamicThreadData jIW;
    private b jIX;
    private a jIY;

    /* loaded from: classes11.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.jIW = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.jIY = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.jIX != null) {
            return false;
        }
        this.jIX = new b();
        this.jIX.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.jIX.execute(this.jIW);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jIX != null) {
            this.jIX.cancel();
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
                SetPrivacyModel.this.byb = new y(SetPrivacyModel.jIV);
                SetPrivacyModel.this.byb.aWu().aWV().mIsNeedTbs = true;
                SetPrivacyModel.this.byb.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.byb.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.byb.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.byb.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.byb.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.byb.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.byb.aWu().aWW().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.byb != null) {
                SetPrivacyModel.this.byb.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.jIX = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.jIX = null;
            if (SetPrivacyModel.this.jIY != null && SetPrivacyModel.this.byb != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.jIY.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.jIY.onError(SetPrivacyModel.this.byb.getErrorString());
                }
            }
        }
    }
}
