package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.NetWork;
import d.b.i0.h.a;
import d.b.j0.w1.g.c;
/* loaded from: classes3.dex */
public class MarkModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f18783e;

    /* renamed from: f  reason: collision with root package name */
    public MarkData f18784f;

    /* renamed from: g  reason: collision with root package name */
    public a f18785g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC1100a f18786h;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f18787a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f18788b;

        /* renamed from: c  reason: collision with root package name */
        public c f18789c;

        public a(boolean z) {
            this.f18788b = true;
            this.f18789c = null;
            this.f18788b = z;
            this.f18789c = new c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            if (this.f18788b) {
                this.f18787a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                d.b.j0.w1.g.a aVar = new d.b.j0.w1.g.a();
                aVar.j(MarkModel.this.f18784f);
                this.f18787a.addPostData("data", aVar.E(0, 1));
            } else {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.f18787a = netWork;
                netWork.addPostData("user_id", MarkModel.this.f18784f.getAccount());
                this.f18787a.addPostData("tid", MarkModel.this.f18784f.getId());
                this.f18787a.addPostData("fid", MarkModel.this.f18784f.getForumId());
            }
            this.f18789c.c(this.f18787a.postNetData());
            boolean z = this.f18789c.a() == 0;
            if (this.f18787a.getNetContext().getResponse().isRequestSuccess() && z) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f18787a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            MarkModel.this.f18785g = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.f18789c != null) {
                    d.b.i0.r.z.a.a("collection", 0L, 0, "add_collection_thread", this.f18789c.a(), this.f18789c.b(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.f18786h != null) {
                        MarkModel.this.f18786h.a(true, this.f18788b, null);
                    }
                } else if (MarkModel.this.f18786h != null) {
                    if (this.f18787a == null || this.f18787a.getNetContext().getResponse().isRequestSuccess()) {
                        MarkModel.this.f18786h.a(false, this.f18788b, this.f18789c.b());
                    } else {
                        MarkModel.this.f18786h.a(false, this.f18788b, this.f18787a.getErrorString());
                    }
                }
                MarkModel.this.f18785g = null;
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
        }
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f18783e = false;
        this.f18784f = null;
        this.f18785g = null;
        this.f18786h = null;
        this.f18784f = new MarkData();
    }

    public void A(boolean z) {
        this.f18783e = z;
    }

    public void B(MarkData markData) {
        this.f18784f = markData;
    }

    public void C(a.InterfaceC1100a interfaceC1100a) {
        this.f18786h = interfaceC1100a;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f18785g;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void v() {
        a aVar = this.f18785g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(true);
        this.f18785g = aVar2;
        aVar2.setPriority(3);
        this.f18785g.execute(new Boolean[0]);
    }

    public void w() {
        a aVar = this.f18785g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(false);
        this.f18785g = aVar2;
        aVar2.setPriority(3);
        this.f18785g.execute(new Boolean[0]);
    }

    public boolean x() {
        return this.f18783e;
    }

    public MarkData y() {
        return this.f18784f;
    }

    public String z() {
        MarkData markData = this.f18784f;
        if (markData != null) {
            return markData.getPostId();
        }
        return null;
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f18783e = false;
        this.f18784f = null;
        this.f18785g = null;
        this.f18786h = null;
        this.f18784f = new MarkData();
    }
}
