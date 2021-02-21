package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes8.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String lur = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private aa cml;
    private boolean isRunning;
    private CardPersonDynamicThreadData lus;
    private b lut;
    private a luu;

    /* loaded from: classes8.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(f fVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(fVar);
        this.lus = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.luu = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lut != null) {
            return false;
        }
        this.lut = new b();
        this.lut.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.lut.execute(this.lus);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lut != null) {
            this.lut.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes8.dex */
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
                SetPrivacyModel.this.cml = new aa(SetPrivacyModel.lur);
                SetPrivacyModel.this.cml.bsr().bta().mIsNeedTbs = true;
                SetPrivacyModel.this.cml.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.cml.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.cml.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.cml.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.cml.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.cml.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.cml.bsr().btb().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.cml != null) {
                SetPrivacyModel.this.cml.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.lut = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.lut = null;
            if (SetPrivacyModel.this.luu != null && SetPrivacyModel.this.cml != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.luu.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.luu.onError(SetPrivacyModel.this.cml.getErrorString());
                }
            }
        }
    }
}
