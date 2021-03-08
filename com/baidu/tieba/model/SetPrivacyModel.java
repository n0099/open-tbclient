package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes7.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String lwt = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private aa cnM;
    private boolean isRunning;
    private CardPersonDynamicThreadData lwu;
    private b lwv;
    private a lww;

    /* loaded from: classes7.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(f fVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(fVar);
        this.lwu = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.lww = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lwv != null) {
            return false;
        }
        this.lwv = new b();
        this.lwv.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.lwv.execute(this.lwu);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lwv != null) {
            this.lwv.cancel();
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
                SetPrivacyModel.this.cnM = new aa(SetPrivacyModel.lwt);
                SetPrivacyModel.this.cnM.bsu().btd().mIsNeedTbs = true;
                SetPrivacyModel.this.cnM.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.cnM.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.cnM.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.cnM.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.cnM.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.cnM.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.cnM.bsu().bte().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.cnM != null) {
                SetPrivacyModel.this.cnM.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.lwv = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.lwv = null;
            if (SetPrivacyModel.this.lww != null && SetPrivacyModel.this.cnM != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.lww.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.lww.onError(SetPrivacyModel.this.cnM.getErrorString());
                }
            }
        }
    }
}
