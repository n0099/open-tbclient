package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.NetWork;
import d.a.n0.h.a;
import d.a.o0.x1.g.c;
/* loaded from: classes4.dex */
public class MarkModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f18578e;

    /* renamed from: f  reason: collision with root package name */
    public MarkData f18579f;

    /* renamed from: g  reason: collision with root package name */
    public a f18580g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC1183a f18581h;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f18582a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f18583b;

        /* renamed from: c  reason: collision with root package name */
        public c f18584c;

        public a(boolean z) {
            this.f18583b = true;
            this.f18584c = null;
            this.f18583b = z;
            this.f18584c = new c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            if (this.f18583b) {
                this.f18582a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                d.a.o0.x1.g.a aVar = new d.a.o0.x1.g.a();
                aVar.j(MarkModel.this.f18579f);
                this.f18582a.addPostData("data", aVar.E(0, 1));
            } else {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.f18582a = netWork;
                netWork.addPostData("user_id", MarkModel.this.f18579f.getAccount());
                this.f18582a.addPostData("tid", MarkModel.this.f18579f.getId());
                this.f18582a.addPostData("fid", MarkModel.this.f18579f.getForumId());
            }
            this.f18584c.c(this.f18582a.postNetData());
            boolean z = this.f18584c.a() == 0;
            if (this.f18582a.getNetContext().getResponse().isRequestSuccess() && z) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f18582a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            MarkModel.this.f18580g = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.f18584c != null) {
                    d.a.n0.r.z.a.a("collection", 0L, 0, "add_collection_thread", this.f18584c.a(), this.f18584c.b(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.f18581h != null) {
                        MarkModel.this.f18581h.a(true, this.f18583b, null);
                    }
                } else if (MarkModel.this.f18581h != null) {
                    if (this.f18582a == null || this.f18582a.getNetContext().getResponse().isRequestSuccess()) {
                        MarkModel.this.f18581h.a(false, this.f18583b, this.f18584c.b());
                    } else {
                        MarkModel.this.f18581h.a(false, this.f18583b, this.f18582a.getErrorString());
                    }
                }
                MarkModel.this.f18580g = null;
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
        }
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f18578e = false;
        this.f18579f = null;
        this.f18580g = null;
        this.f18581h = null;
        this.f18579f = new MarkData();
    }

    public void A() {
        a aVar = this.f18580g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(false);
        this.f18580g = aVar2;
        aVar2.setPriority(3);
        this.f18580g.execute(new Boolean[0]);
    }

    public boolean B() {
        return this.f18578e;
    }

    public MarkData C() {
        return this.f18579f;
    }

    public String D() {
        MarkData markData = this.f18579f;
        if (markData != null) {
            return markData.getPostId();
        }
        return null;
    }

    public void E(boolean z) {
        this.f18578e = z;
    }

    public void F(MarkData markData) {
        this.f18579f = markData;
    }

    public void G(a.InterfaceC1183a interfaceC1183a) {
        this.f18581h = interfaceC1183a;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f18580g;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void z() {
        a aVar = this.f18580g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(true);
        this.f18580g = aVar2;
        aVar2.setPriority(3);
        this.f18580g.execute(new Boolean[0]);
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f18578e = false;
        this.f18579f = null;
        this.f18580g = null;
        this.f18581h = null;
        this.f18579f = new MarkData();
    }
}
