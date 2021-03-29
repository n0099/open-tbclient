package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.NetWork;
import d.b.h0.h.a;
import d.b.i0.v1.g.c;
/* loaded from: classes3.dex */
public class MarkModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f19098e;

    /* renamed from: f  reason: collision with root package name */
    public MarkData f19099f;

    /* renamed from: g  reason: collision with root package name */
    public a f19100g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC1065a f19101h;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f19102a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f19103b;

        /* renamed from: c  reason: collision with root package name */
        public c f19104c;

        public a(boolean z) {
            this.f19103b = true;
            this.f19104c = null;
            this.f19103b = z;
            this.f19104c = new c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            if (this.f19103b) {
                this.f19102a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                d.b.i0.v1.g.a aVar = new d.b.i0.v1.g.a();
                aVar.j(MarkModel.this.f19099f);
                this.f19102a.addPostData("data", aVar.E(0, 1));
            } else {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.f19102a = netWork;
                netWork.addPostData("user_id", MarkModel.this.f19099f.getAccount());
                this.f19102a.addPostData("tid", MarkModel.this.f19099f.getId());
                this.f19102a.addPostData("fid", MarkModel.this.f19099f.getForumId());
            }
            this.f19104c.c(this.f19102a.postNetData());
            boolean z = this.f19104c.a() == 0;
            if (this.f19102a.getNetContext().getResponse().isRequestSuccess() && z) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f19102a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            MarkModel.this.f19100g = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.f19104c != null) {
                    d.b.h0.r.z.a.a("collection", 0L, 0, "add_collection_thread", this.f19104c.a(), this.f19104c.b(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.f19101h != null) {
                        MarkModel.this.f19101h.a(true, this.f19103b, null);
                    }
                } else if (MarkModel.this.f19101h != null) {
                    if (this.f19102a == null || this.f19102a.getNetContext().getResponse().isRequestSuccess()) {
                        MarkModel.this.f19101h.a(false, this.f19103b, this.f19104c.b());
                    } else {
                        MarkModel.this.f19101h.a(false, this.f19103b, this.f19102a.getErrorString());
                    }
                }
                MarkModel.this.f19100g = null;
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
        }
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f19098e = false;
        this.f19099f = null;
        this.f19100g = null;
        this.f19101h = null;
        this.f19099f = new MarkData();
    }

    public void A(boolean z) {
        this.f19098e = z;
    }

    public void B(MarkData markData) {
        this.f19099f = markData;
    }

    public void C(a.InterfaceC1065a interfaceC1065a) {
        this.f19101h = interfaceC1065a;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f19100g;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void v() {
        a aVar = this.f19100g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(true);
        this.f19100g = aVar2;
        aVar2.setPriority(3);
        this.f19100g.execute(new Boolean[0]);
    }

    public void w() {
        a aVar = this.f19100g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(false);
        this.f19100g = aVar2;
        aVar2.setPriority(3);
        this.f19100g.execute(new Boolean[0]);
    }

    public boolean x() {
        return this.f19098e;
    }

    public MarkData y() {
        return this.f19099f;
    }

    public String z() {
        MarkData markData = this.f19099f;
        if (markData != null) {
            return markData.getPostId();
        }
        return null;
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f19098e = false;
        this.f19099f = null;
        this.f19100g = null;
        this.f19101h = null;
        this.f19099f = new MarkData();
    }
}
