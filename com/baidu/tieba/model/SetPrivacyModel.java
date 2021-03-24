package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import d.b.b.a.f;
/* loaded from: classes3.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    public static final String j = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;

    /* renamed from: e  reason: collision with root package name */
    public CardPersonDynamicThreadData f19038e;

    /* renamed from: f  reason: collision with root package name */
    public b f19039f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19040g;

    /* renamed from: h  reason: collision with root package name */
    public NetWork f19041h;
    public a i;

    /* loaded from: classes3.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    /* loaded from: classes3.dex */
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
            SetPrivacyModel.this.f19041h = new NetWork(SetPrivacyModel.j);
            SetPrivacyModel.this.f19041h.getNetContext().getRequest().mIsNeedTbs = true;
            SetPrivacyModel.this.f19041h.addPostData("user_id", currentAccount);
            SetPrivacyModel.this.f19041h.addPostData("forum_id", cardPersonDynamicThreadData.f15274e);
            SetPrivacyModel.this.f19041h.addPostData("thread_id", cardPersonDynamicThreadData.f15275f);
            SetPrivacyModel.this.f19041h.addPostData("post_id", cardPersonDynamicThreadData.f15276g);
            SetPrivacyModel.this.f19041h.addPostData("is_hide", String.valueOf(!cardPersonDynamicThreadData.q ? 1 : 0));
            SetPrivacyModel.this.f19041h.postNetData();
            return Integer.valueOf(SetPrivacyModel.this.f19041h.getNetContext().getResponse().isRequestSuccess() ? 1 : 0);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.f19041h != null) {
                SetPrivacyModel.this.f19041h.cancelNetConnect();
            }
            SetPrivacyModel.this.f19040g = false;
            SetPrivacyModel.this.f19039f = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            SetPrivacyModel.this.f19040g = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.f19040g = false;
            SetPrivacyModel.this.f19039f = null;
            if (SetPrivacyModel.this.i == null || SetPrivacyModel.this.f19041h == null) {
                return;
            }
            if (num.intValue() == 1) {
                SetPrivacyModel.this.i.onSuccess();
            } else if (num.intValue() == 0) {
                SetPrivacyModel.this.i.onError(SetPrivacyModel.this.f19041h.getErrorString());
            }
        }
    }

    public SetPrivacyModel(f fVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(fVar);
        this.f19038e = cardPersonDynamicThreadData;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f19039f != null) {
            return false;
        }
        b bVar = new b();
        this.f19039f = bVar;
        bVar.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.f19039f.execute(this.f19038e);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f19039f;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return false;
    }

    public boolean y() {
        return this.f19040g;
    }

    public void z(a aVar) {
        this.i = aVar;
    }
}
