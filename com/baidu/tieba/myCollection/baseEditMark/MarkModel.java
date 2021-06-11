package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.NetWork;
import d.a.m0.h.a;
import d.a.n0.x1.g.c;
/* loaded from: classes4.dex */
public class MarkModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f18496e;

    /* renamed from: f  reason: collision with root package name */
    public MarkData f18497f;

    /* renamed from: g  reason: collision with root package name */
    public a f18498g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC1180a f18499h;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f18500a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f18501b;

        /* renamed from: c  reason: collision with root package name */
        public c f18502c;

        public a(boolean z) {
            this.f18501b = true;
            this.f18502c = null;
            this.f18501b = z;
            this.f18502c = new c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            if (this.f18501b) {
                this.f18500a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                d.a.n0.x1.g.a aVar = new d.a.n0.x1.g.a();
                aVar.j(MarkModel.this.f18497f);
                this.f18500a.addPostData("data", aVar.E(0, 1));
            } else {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.f18500a = netWork;
                netWork.addPostData("user_id", MarkModel.this.f18497f.getAccount());
                this.f18500a.addPostData("tid", MarkModel.this.f18497f.getId());
                this.f18500a.addPostData("fid", MarkModel.this.f18497f.getForumId());
            }
            this.f18502c.c(this.f18500a.postNetData());
            boolean z = this.f18502c.a() == 0;
            if (this.f18500a.getNetContext().getResponse().isRequestSuccess() && z) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f18500a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            MarkModel.this.f18498g = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.f18502c != null) {
                    d.a.m0.r.z.a.a("collection", 0L, 0, "add_collection_thread", this.f18502c.a(), this.f18502c.b(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.f18499h != null) {
                        MarkModel.this.f18499h.a(true, this.f18501b, null);
                    }
                } else if (MarkModel.this.f18499h != null) {
                    if (this.f18500a == null || this.f18500a.getNetContext().getResponse().isRequestSuccess()) {
                        MarkModel.this.f18499h.a(false, this.f18501b, this.f18502c.b());
                    } else {
                        MarkModel.this.f18499h.a(false, this.f18501b, this.f18500a.getErrorString());
                    }
                }
                MarkModel.this.f18498g = null;
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
        }
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f18496e = false;
        this.f18497f = null;
        this.f18498g = null;
        this.f18499h = null;
        this.f18497f = new MarkData();
    }

    public void A() {
        a aVar = this.f18498g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(false);
        this.f18498g = aVar2;
        aVar2.setPriority(3);
        this.f18498g.execute(new Boolean[0]);
    }

    public boolean B() {
        return this.f18496e;
    }

    public MarkData C() {
        return this.f18497f;
    }

    public String D() {
        MarkData markData = this.f18497f;
        if (markData != null) {
            return markData.getPostId();
        }
        return null;
    }

    public void E(boolean z) {
        this.f18496e = z;
    }

    public void F(MarkData markData) {
        this.f18497f = markData;
    }

    public void G(a.InterfaceC1180a interfaceC1180a) {
        this.f18499h = interfaceC1180a;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f18498g;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void z() {
        a aVar = this.f18498g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(true);
        this.f18498g = aVar2;
        aVar2.setPriority(3);
        this.f18498g.execute(new Boolean[0]);
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f18496e = false;
        this.f18497f = null;
        this.f18498g = null;
        this.f18499h = null;
        this.f18497f = new MarkData();
    }
}
