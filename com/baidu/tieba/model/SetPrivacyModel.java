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
    private static final String hxW = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private CardPersonDynamicThreadData hxX;
    private b hxY;
    private a hxZ;
    private boolean isRunning;
    private x mNetWork;

    /* loaded from: classes6.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.hxX = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.hxZ = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hxY != null) {
            return false;
        }
        this.hxY = new b();
        this.hxY.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.hxY.execute(this.hxX);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.hxY != null) {
            this.hxY.cancel();
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
                SetPrivacyModel.this.mNetWork = new x(SetPrivacyModel.hxW);
                SetPrivacyModel.this.mNetWork.aiK().ajM().mIsNeedTbs = true;
                SetPrivacyModel.this.mNetWork.o("user_id", currentAccount);
                SetPrivacyModel.this.mNetWork.o("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.mNetWork.o("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.mNetWork.o("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.mNetWork.o("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.mNetWork.aim();
                return Integer.valueOf(SetPrivacyModel.this.mNetWork.aiK().ajN().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.mNetWork != null) {
                SetPrivacyModel.this.mNetWork.ik();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.hxY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.hxY = null;
            if (SetPrivacyModel.this.hxZ != null && SetPrivacyModel.this.mNetWork != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.hxZ.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.hxZ.onError(SetPrivacyModel.this.mNetWork.getErrorString());
                }
            }
        }
    }
}
