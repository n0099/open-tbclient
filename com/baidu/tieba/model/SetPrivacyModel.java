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
    private static final String ipD = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x cLE;
    private CardPersonDynamicThreadData ipE;
    private b ipF;
    private a ipG;
    private boolean isRunning;

    /* loaded from: classes11.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.ipE = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.ipG = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.ipF != null) {
            return false;
        }
        this.ipF = new b();
        this.ipF.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.ipF.execute(this.ipE);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ipF != null) {
            this.ipF.cancel();
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
                SetPrivacyModel.this.cLE = new x(SetPrivacyModel.ipD);
                SetPrivacyModel.this.cLE.aGg().aGH().mIsNeedTbs = true;
                SetPrivacyModel.this.cLE.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.cLE.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.cLE.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.cLE.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.cLE.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.cLE.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.cLE.aGg().aGI().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.cLE != null) {
                SetPrivacyModel.this.cLE.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.ipF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.ipF = null;
            if (SetPrivacyModel.this.ipG != null && SetPrivacyModel.this.cLE != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.ipG.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.ipG.onError(SetPrivacyModel.this.cLE.getErrorString());
                }
            }
        }
    }
}
