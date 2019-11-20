package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes6.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String hvT = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x bUY;
    private CardPersonDynamicThreadData hvU;
    private b hvV;
    private a hvW;
    private boolean isRunning;

    /* loaded from: classes6.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.hvU = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.hvW = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hvV != null) {
            return false;
        }
        this.hvV = new b();
        this.hvV.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.hvV.execute(this.hvU);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.hvV != null) {
            this.hvV.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
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
                SetPrivacyModel.this.bUY = new x(SetPrivacyModel.hvT);
                SetPrivacyModel.this.bUY.amp().amP().mIsNeedTbs = true;
                SetPrivacyModel.this.bUY.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.bUY.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.bUY.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.bUY.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.bUY.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.bUY.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.bUY.amp().amQ().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.bUY != null) {
                SetPrivacyModel.this.bUY.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.hvV = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.hvV = null;
            if (SetPrivacyModel.this.hvW != null && SetPrivacyModel.this.bUY != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.hvW.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.hvW.onError(SetPrivacyModel.this.bUY.getErrorString());
                }
            }
        }
    }
}
