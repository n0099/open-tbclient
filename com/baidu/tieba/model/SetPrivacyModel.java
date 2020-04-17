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
    private static final String jbr = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x blF;
    private boolean isRunning;
    private CardPersonDynamicThreadData jbs;
    private b jbt;
    private a jbu;

    /* loaded from: classes11.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.jbs = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.jbu = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.jbt != null) {
            return false;
        }
        this.jbt = new b();
        this.jbt.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.jbt.execute(this.jbs);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jbt != null) {
            this.jbt.cancel();
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
                SetPrivacyModel.this.blF = new x(SetPrivacyModel.jbr);
                SetPrivacyModel.this.blF.aOy().aOZ().mIsNeedTbs = true;
                SetPrivacyModel.this.blF.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.blF.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.blF.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.blF.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.blF.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.blF.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.blF.aOy().aPa().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.blF != null) {
                SetPrivacyModel.this.blF.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.jbt = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.jbt = null;
            if (SetPrivacyModel.this.jbu != null && SetPrivacyModel.this.blF != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.jbu.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.jbu.onError(SetPrivacyModel.this.blF.getErrorString());
                }
            }
        }
    }
}
