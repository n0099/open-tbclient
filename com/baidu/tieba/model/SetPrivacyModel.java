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
    private static final String ipP = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x cLF;
    private CardPersonDynamicThreadData ipQ;
    private b ipR;
    private a ipS;
    private boolean isRunning;

    /* loaded from: classes11.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.ipQ = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.ipS = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.ipR != null) {
            return false;
        }
        this.ipR = new b();
        this.ipR.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.ipR.execute(this.ipQ);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ipR != null) {
            this.ipR.cancel();
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
                SetPrivacyModel.this.cLF = new x(SetPrivacyModel.ipP);
                SetPrivacyModel.this.cLF.aGg().aGH().mIsNeedTbs = true;
                SetPrivacyModel.this.cLF.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.cLF.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.cLF.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.cLF.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.cLF.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.cLF.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.cLF.aGg().aGI().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.cLF != null) {
                SetPrivacyModel.this.cLF.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.ipR = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.ipR = null;
            if (SetPrivacyModel.this.ipS != null && SetPrivacyModel.this.cLF != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.ipS.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.ipS.onError(SetPrivacyModel.this.cLF.getErrorString());
                }
            }
        }
    }
}
