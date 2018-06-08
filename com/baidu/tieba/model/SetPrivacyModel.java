package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes3.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String fcO = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private CardPersonDynamicThreadData fcP;
    private b fcQ;
    private a fcR;
    private boolean isRunning;
    private y mNetWork;

    /* loaded from: classes3.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.fcP = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.fcR = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fcQ != null) {
            return false;
        }
        this.fcQ = new b();
        this.fcQ.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.fcQ.execute(this.fcP);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.fcQ != null) {
            this.fcQ.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
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
                SetPrivacyModel.this.mNetWork = new y(SetPrivacyModel.fcO);
                SetPrivacyModel.this.mNetWork.yJ().zI().mIsNeedTbs = true;
                SetPrivacyModel.this.mNetWork.o("user_id", currentAccount);
                SetPrivacyModel.this.mNetWork.o("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.mNetWork.o("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.mNetWork.o("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.mNetWork.o("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.mNetWork.yl();
                return Integer.valueOf(SetPrivacyModel.this.mNetWork.yJ().zJ().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.mNetWork != null) {
                SetPrivacyModel.this.mNetWork.hN();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.fcQ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.fcQ = null;
            if (SetPrivacyModel.this.fcR != null && SetPrivacyModel.this.mNetWork != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.fcR.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.fcR.onError(SetPrivacyModel.this.mNetWork.getErrorString());
                }
            }
        }
    }
}
