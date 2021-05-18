package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.NetWork;
import d.a.j0.h.a;
import d.a.k0.w1.g.c;
/* loaded from: classes3.dex */
public class MarkModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f18507e;

    /* renamed from: f  reason: collision with root package name */
    public MarkData f18508f;

    /* renamed from: g  reason: collision with root package name */
    public a f18509g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC1115a f18510h;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f18511a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f18512b;

        /* renamed from: c  reason: collision with root package name */
        public c f18513c;

        public a(boolean z) {
            this.f18512b = true;
            this.f18513c = null;
            this.f18512b = z;
            this.f18513c = new c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            if (this.f18512b) {
                this.f18511a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                d.a.k0.w1.g.a aVar = new d.a.k0.w1.g.a();
                aVar.j(MarkModel.this.f18508f);
                this.f18511a.addPostData("data", aVar.E(0, 1));
            } else {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.f18511a = netWork;
                netWork.addPostData("user_id", MarkModel.this.f18508f.getAccount());
                this.f18511a.addPostData("tid", MarkModel.this.f18508f.getId());
                this.f18511a.addPostData("fid", MarkModel.this.f18508f.getForumId());
            }
            this.f18513c.c(this.f18511a.postNetData());
            boolean z = this.f18513c.a() == 0;
            if (this.f18511a.getNetContext().getResponse().isRequestSuccess() && z) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f18511a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            MarkModel.this.f18509g = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.f18513c != null) {
                    d.a.j0.r.z.a.a("collection", 0L, 0, "add_collection_thread", this.f18513c.a(), this.f18513c.b(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.f18510h != null) {
                        MarkModel.this.f18510h.a(true, this.f18512b, null);
                    }
                } else if (MarkModel.this.f18510h != null) {
                    if (this.f18511a == null || this.f18511a.getNetContext().getResponse().isRequestSuccess()) {
                        MarkModel.this.f18510h.a(false, this.f18512b, this.f18513c.b());
                    } else {
                        MarkModel.this.f18510h.a(false, this.f18512b, this.f18511a.getErrorString());
                    }
                }
                MarkModel.this.f18509g = null;
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
        }
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f18507e = false;
        this.f18508f = null;
        this.f18509g = null;
        this.f18510h = null;
        this.f18508f = new MarkData();
    }

    public void A(boolean z) {
        this.f18507e = z;
    }

    public void B(MarkData markData) {
        this.f18508f = markData;
    }

    public void C(a.InterfaceC1115a interfaceC1115a) {
        this.f18510h = interfaceC1115a;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f18509g;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void v() {
        a aVar = this.f18509g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(true);
        this.f18509g = aVar2;
        aVar2.setPriority(3);
        this.f18509g.execute(new Boolean[0]);
    }

    public void w() {
        a aVar = this.f18509g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(false);
        this.f18509g = aVar2;
        aVar2.setPriority(3);
        this.f18509g.execute(new Boolean[0]);
    }

    public boolean x() {
        return this.f18507e;
    }

    public MarkData y() {
        return this.f18508f;
    }

    public String z() {
        MarkData markData = this.f18508f;
        if (markData != null) {
            return markData.getPostId();
        }
        return null;
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f18507e = false;
        this.f18508f = null;
        this.f18509g = null;
        this.f18510h = null;
        this.f18508f = new MarkData();
    }
}
