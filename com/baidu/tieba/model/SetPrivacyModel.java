package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import d.a.c.a.f;
/* loaded from: classes3.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
    public static final String j = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;

    /* renamed from: e  reason: collision with root package name */
    public CardPersonDynamicThreadData f19151e;

    /* renamed from: f  reason: collision with root package name */
    public b f19152f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19153g;

    /* renamed from: h  reason: collision with root package name */
    public NetWork f19154h;

    /* renamed from: i  reason: collision with root package name */
    public a f19155i;

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
            SetPrivacyModel.this.f19154h = new NetWork(SetPrivacyModel.j);
            SetPrivacyModel.this.f19154h.getNetContext().getRequest().mIsNeedTbs = true;
            SetPrivacyModel.this.f19154h.addPostData("user_id", currentAccount);
            SetPrivacyModel.this.f19154h.addPostData("forum_id", cardPersonDynamicThreadData.f15057e);
            SetPrivacyModel.this.f19154h.addPostData("thread_id", cardPersonDynamicThreadData.f15058f);
            SetPrivacyModel.this.f19154h.addPostData("post_id", cardPersonDynamicThreadData.f15059g);
            SetPrivacyModel.this.f19154h.addPostData("is_hide", String.valueOf(!cardPersonDynamicThreadData.q ? 1 : 0));
            SetPrivacyModel.this.f19154h.postNetData();
            return Integer.valueOf(SetPrivacyModel.this.f19154h.getNetContext().getResponse().isRequestSuccess() ? 1 : 0);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (SetPrivacyModel.this.f19154h != null) {
                SetPrivacyModel.this.f19154h.cancelNetConnect();
            }
            SetPrivacyModel.this.f19153g = false;
            SetPrivacyModel.this.f19152f = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            SetPrivacyModel.this.f19153g = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            SetPrivacyModel.this.f19153g = false;
            SetPrivacyModel.this.f19152f = null;
            if (SetPrivacyModel.this.f19155i == null || SetPrivacyModel.this.f19154h == null) {
                return;
            }
            if (num.intValue() == 1) {
                SetPrivacyModel.this.f19155i.onSuccess();
            } else if (num.intValue() == 0) {
                SetPrivacyModel.this.f19155i.onError(SetPrivacyModel.this.f19154h.getErrorString());
            }
        }
    }

    public SetPrivacyModel(f fVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(fVar);
        this.f19151e = cardPersonDynamicThreadData;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f19152f != null) {
            return false;
        }
        b bVar = new b();
        this.f19152f = bVar;
        bVar.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
        this.f19152f.execute(this.f19151e);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f19152f;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return false;
    }

    public boolean y() {
        return this.f19153g;
    }

    public void z(a aVar) {
        this.f19155i = aVar;
    }
}
