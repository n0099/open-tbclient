package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes11.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String ipB = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x cLD;
    private CardPersonDynamicThreadData ipC;
    private b ipD;
    private a ipE;
    private boolean isRunning;

    /* loaded from: classes11.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.ipC = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.ipE = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.ipD != null) {
            return false;
        }
        this.ipD = new b();
        this.ipD.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.ipD.execute(this.ipC);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ipD != null) {
            this.ipD.cancel();
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
                SetPrivacyModel.this.cLD = new x(SetPrivacyModel.ipB);
                SetPrivacyModel.this.cLD.aGe().aGF().mIsNeedTbs = true;
                SetPrivacyModel.this.cLD.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.cLD.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.cLD.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.cLD.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.cLD.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.cLD.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.cLD.aGe().aGG().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.cLD != null) {
                SetPrivacyModel.this.cLD.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.ipD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.ipD = null;
            if (SetPrivacyModel.this.ipE != null && SetPrivacyModel.this.cLD != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.ipE.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.ipE.onError(SetPrivacyModel.this.cLD.getErrorString());
                }
            }
        }
    }
}
