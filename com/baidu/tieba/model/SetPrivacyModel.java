package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes7.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String llW = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private z chV;
    private boolean isRunning;
    private CardPersonDynamicThreadData llX;
    private b llY;
    private a llZ;

    /* loaded from: classes7.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(f fVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(fVar);
        this.llX = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.llZ = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.llY != null) {
            return false;
        }
        this.llY = new b();
        this.llY.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.llY.execute(this.llX);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.llY != null) {
            this.llY.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes7.dex */
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
                SetPrivacyModel.this.chV = new z(SetPrivacyModel.llW);
                SetPrivacyModel.this.chV.brX().bsG().mIsNeedTbs = true;
                SetPrivacyModel.this.chV.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.chV.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.chV.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.chV.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.chV.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.chV.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.chV.brX().bsH().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.chV != null) {
                SetPrivacyModel.this.chV.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.llY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.llY = null;
            if (SetPrivacyModel.this.llZ != null && SetPrivacyModel.this.chV != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.llZ.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.llZ.onError(SetPrivacyModel.this.chV.getErrorString());
                }
            }
        }
    }
}
