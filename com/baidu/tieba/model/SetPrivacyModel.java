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
    public CardPersonDynamicThreadData f18425e;

    /* renamed from: f  reason: collision with root package name */
    public b f18426f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18427g;

    /* renamed from: h  reason: collision with root package name */
    public NetWork f18428h;

    /* renamed from: i  reason: collision with root package name */
    public a f18429i;

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
            SetPrivacyModel.this.f18428h = new NetWork(SetPrivacyModel.j);
            SetPrivacyModel.this.f18428h.getNetContext().getRequest().mIsNeedTbs = true;
            SetPrivacyModel.this.f18428h.addPostData("user_id", currentAccount);
            SetPrivacyModel.this.f18428h.addPostData("forum_id", cardPersonDynamicThreadData.f14332e);
            SetPrivacyModel.this.f18428h.addPostData("thread_id", cardPersonDynamicThreadData.f14333f);
            SetPrivacyModel.this.f18428h.addPostData("post_id", cardPersonDynamicThreadData.f14334g);
            SetPrivacyModel.this.f18428h.addPostData("is_hide", String.valueOf(!cardPersonDynamicThreadData.q ? 1 : 0));
            SetPrivacyModel.this.f18428h.postNetData();
            return Integer.valueOf(SetPrivacyModel.this.f18428h.getNetContext().getResponse().isRequestSuccess() ? 1 : 0);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.f18428h != null) {
                SetPrivacyModel.this.f18428h.cancelNetConnect();
            }
            SetPrivacyModel.this.f18427g = false;
            SetPrivacyModel.this.f18426f = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            SetPrivacyModel.this.f18427g = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.f18427g = false;
            SetPrivacyModel.this.f18426f = null;
            if (SetPrivacyModel.this.f18429i == null || SetPrivacyModel.this.f18428h == null) {
                return;
            }
            if (num.intValue() == 1) {
                SetPrivacyModel.this.f18429i.onSuccess();
            } else if (num.intValue() == 0) {
                SetPrivacyModel.this.f18429i.onError(SetPrivacyModel.this.f18428h.getErrorString());
            }
        }
    }

    public SetPrivacyModel(f fVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(fVar);
        this.f18425e = cardPersonDynamicThreadData;
    }

    public boolean C() {
        return this.f18427g;
    }

    public void D(a aVar) {
        this.f18429i = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f18426f != null) {
            return false;
        }
        b bVar = new b();
        this.f18426f = bVar;
        bVar.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.f18426f.execute(this.f18425e);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f18426f;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return false;
    }
}
