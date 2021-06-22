package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import d.a.c.a.f;
/* loaded from: classes4.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    public static final String j = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;

    /* renamed from: e  reason: collision with root package name */
    public CardPersonDynamicThreadData f18507e;

    /* renamed from: f  reason: collision with root package name */
    public b f18508f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18509g;

    /* renamed from: h  reason: collision with root package name */
    public NetWork f18510h;

    /* renamed from: i  reason: collision with root package name */
    public a f18511i;

    /* loaded from: classes4.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<CardPersonDynamicThreadData, Integer, Integer> {
        public b() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(CardPersonDynamicThreadData... cardPersonDynamicThreadDataArr) {
            if (cardPersonDynamicThreadDataArr == null || cardPersonDynamicThreadDataArr.length == 0 || cardPersonDynamicThreadDataArr[0] == null) {
                return null;
            }
            CardPersonDynamicThreadData cardPersonDynamicThreadData = cardPersonDynamicThreadDataArr[0];
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return null;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            SetPrivacyModel.this.f18510h = new NetWork(SetPrivacyModel.j);
            SetPrivacyModel.this.f18510h.getNetContext().getRequest().mIsNeedTbs = true;
            SetPrivacyModel.this.f18510h.addPostData("user_id", currentAccount);
            SetPrivacyModel.this.f18510h.addPostData("forum_id", cardPersonDynamicThreadData.f14414e);
            SetPrivacyModel.this.f18510h.addPostData("thread_id", cardPersonDynamicThreadData.f14415f);
            SetPrivacyModel.this.f18510h.addPostData("post_id", cardPersonDynamicThreadData.f14416g);
            SetPrivacyModel.this.f18510h.addPostData("is_hide", String.valueOf(!cardPersonDynamicThreadData.q ? 1 : 0));
            SetPrivacyModel.this.f18510h.postNetData();
            return Integer.valueOf(SetPrivacyModel.this.f18510h.getNetContext().getResponse().isRequestSuccess() ? 1 : 0);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.f18510h != null) {
                SetPrivacyModel.this.f18510h.cancelNetConnect();
            }
            SetPrivacyModel.this.f18509g = false;
            SetPrivacyModel.this.f18508f = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            SetPrivacyModel.this.f18509g = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.f18509g = false;
            SetPrivacyModel.this.f18508f = null;
            if (SetPrivacyModel.this.f18511i == null || SetPrivacyModel.this.f18510h == null) {
                return;
            }
            if (num.intValue() == 1) {
                SetPrivacyModel.this.f18511i.onSuccess();
            } else if (num.intValue() == 0) {
                SetPrivacyModel.this.f18511i.onError(SetPrivacyModel.this.f18510h.getErrorString());
            }
        }
    }

    public SetPrivacyModel(f fVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(fVar);
        this.f18507e = cardPersonDynamicThreadData;
    }

    public boolean C() {
        return this.f18509g;
    }

    public void D(a aVar) {
        this.f18511i = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f18508f != null) {
            return false;
        }
        b bVar = new b();
        this.f18508f = bVar;
        bVar.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.f18508f.execute(this.f18507e);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f18508f;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return false;
    }
}
