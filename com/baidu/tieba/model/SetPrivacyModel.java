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
    private static final String jbv = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x blK;
    private boolean isRunning;
    private CardPersonDynamicThreadData jbw;
    private b jbx;
    private a jby;

    /* loaded from: classes11.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.jbw = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.jby = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.jbx != null) {
            return false;
        }
        this.jbx = new b();
        this.jbx.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.jbx.execute(this.jbw);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jbx != null) {
            this.jbx.cancel();
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
                SetPrivacyModel.this.blK = new x(SetPrivacyModel.jbv);
                SetPrivacyModel.this.blK.aOw().aOW().mIsNeedTbs = true;
                SetPrivacyModel.this.blK.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.blK.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.blK.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.blK.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.blK.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.blK.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.blK.aOw().aOX().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.blK != null) {
                SetPrivacyModel.this.blK.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.jbx = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.jbx = null;
            if (SetPrivacyModel.this.jby != null && SetPrivacyModel.this.blK != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.jby.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.jby.onError(SetPrivacyModel.this.blK.getErrorString());
                }
            }
        }
    }
}
