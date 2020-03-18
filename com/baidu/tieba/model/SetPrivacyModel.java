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
    private static final String irp = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x cLQ;
    private CardPersonDynamicThreadData irq;
    private b irr;
    private a irs;
    private boolean isRunning;

    /* loaded from: classes11.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.irq = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.irs = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.irr != null) {
            return false;
        }
        this.irr = new b();
        this.irr.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.irr.execute(this.irq);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.irr != null) {
            this.irr.cancel();
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
                SetPrivacyModel.this.cLQ = new x(SetPrivacyModel.irp);
                SetPrivacyModel.this.cLQ.aGk().aGL().mIsNeedTbs = true;
                SetPrivacyModel.this.cLQ.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.cLQ.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.cLQ.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.cLQ.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.cLQ.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.cLQ.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.cLQ.aGk().aGM().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.cLQ != null) {
                SetPrivacyModel.this.cLQ.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.irr = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.irr = null;
            if (SetPrivacyModel.this.irs != null && SetPrivacyModel.this.cLQ != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.irs.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.irs.onError(SetPrivacyModel.this.cLQ.getErrorString());
                }
            }
        }
    }
}
