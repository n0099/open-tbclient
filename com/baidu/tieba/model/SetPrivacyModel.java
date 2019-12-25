package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes8.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    private static final String ijV = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    private x cHo;
    private CardPersonDynamicThreadData ijW;
    private b ijX;
    private a ijY;
    private boolean isRunning;

    /* loaded from: classes8.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    public SetPrivacyModel(e eVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(eVar);
        this.ijW = cardPersonDynamicThreadData;
    }

    public void a(a aVar) {
        this.ijY = aVar;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.ijX != null) {
            return false;
        }
        this.ijX = new b();
        this.ijX.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.ijX.execute(this.ijW);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ijX != null) {
            this.ijX.cancel();
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
                SetPrivacyModel.this.cHo = new x(SetPrivacyModel.ijV);
                SetPrivacyModel.this.cHo.aDB().aEb().mIsNeedTbs = true;
                SetPrivacyModel.this.cHo.addPostData("user_id", currentAccount);
                SetPrivacyModel.this.cHo.addPostData("forum_id", cardPersonDynamicThreadData.forumId);
                SetPrivacyModel.this.cHo.addPostData("thread_id", cardPersonDynamicThreadData.threadId);
                SetPrivacyModel.this.cHo.addPostData("post_id", cardPersonDynamicThreadData.postId);
                SetPrivacyModel.this.cHo.addPostData("is_hide", String.valueOf(cardPersonDynamicThreadData.isPrivacy ? 0 : 1));
                SetPrivacyModel.this.cHo.postNetData();
                return Integer.valueOf(SetPrivacyModel.this.cHo.aDB().aEc().isRequestSuccess() ? 1 : 0);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.cHo != null) {
                SetPrivacyModel.this.cHo.cancelNetConnect();
            }
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.ijX = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.isRunning = false;
            SetPrivacyModel.this.ijX = null;
            if (SetPrivacyModel.this.ijY != null && SetPrivacyModel.this.cHo != null) {
                if (num.intValue() == 1) {
                    SetPrivacyModel.this.ijY.onSuccess();
                } else if (num.intValue() == 0) {
                    SetPrivacyModel.this.ijY.onError(SetPrivacyModel.this.cHo.getErrorString());
                }
            }
        }
    }
}
