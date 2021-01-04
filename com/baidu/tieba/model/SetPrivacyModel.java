package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes8.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String lqG = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private z cmJ;
    private boolean isRunning;
    private CardPersonDynamicThreadData lqH;
    private b lqI;
    private a lqJ;

    /* loaded from: classes8.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(f fVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(fVar);
        this.lqH = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.lqJ = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lqI != null) {
            return false;
        }
        this.lqI = new b();
        this.lqI.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.lqI.execute(this.lqH);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lqI != null) {
            this.lqI.cancel();
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
                SetPrivacyModel.this.cmJ = new z(SetPrivacyModel.lqG);
                SetPrivacyModel.this.cmJ.bvQ().bwz().mIsNeedTbs = true;
                SetPrivacyModel.this.cmJ.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.cmJ.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.cmJ.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.cmJ.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.cmJ.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.cmJ.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.cmJ.bvQ().bwA().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.cmJ != null) {
                SetPrivacyModel.this.cmJ.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.lqI = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.lqI = null;
            if (SetPrivacyModel.this.lqJ != null && SetPrivacyModel.this.cmJ != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.lqJ.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.lqJ.onError(SetPrivacyModel.this.cmJ.getErrorString());
                }
            }
        }
    }
}
