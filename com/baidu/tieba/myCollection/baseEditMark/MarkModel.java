package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.NetWork;
import d.a.i0.h.a;
import d.a.j0.w1.g.c;
/* loaded from: classes3.dex */
public class MarkModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f19219e;

    /* renamed from: f  reason: collision with root package name */
    public MarkData f19220f;

    /* renamed from: g  reason: collision with root package name */
    public a f19221g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC1039a f19222h;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f19223a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f19224b;

        /* renamed from: c  reason: collision with root package name */
        public c f19225c;

        public a(boolean z) {
            this.f19224b = true;
            this.f19225c = null;
            this.f19224b = z;
            this.f19225c = new c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            if (this.f19224b) {
                this.f19223a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                d.a.j0.w1.g.a aVar = new d.a.j0.w1.g.a();
                aVar.j(MarkModel.this.f19220f);
                this.f19223a.addPostData("data", aVar.E(0, 1));
            } else {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.f19223a = netWork;
                netWork.addPostData("user_id", MarkModel.this.f19220f.getAccount());
                this.f19223a.addPostData("tid", MarkModel.this.f19220f.getId());
                this.f19223a.addPostData("fid", MarkModel.this.f19220f.getForumId());
            }
            this.f19225c.c(this.f19223a.postNetData());
            boolean z = this.f19225c.a() == 0;
            if (this.f19223a.getNetContext().getResponse().isRequestSuccess() && z) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f19223a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            MarkModel.this.f19221g = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.f19225c != null) {
                    d.a.i0.r.z.a.a("collection", 0L, 0, "add_collection_thread", this.f19225c.a(), this.f19225c.b(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.f19222h != null) {
                        MarkModel.this.f19222h.a(true, this.f19224b, null);
                    }
                } else if (MarkModel.this.f19222h != null) {
                    if (this.f19223a == null || this.f19223a.getNetContext().getResponse().isRequestSuccess()) {
                        MarkModel.this.f19222h.a(false, this.f19224b, this.f19225c.b());
                    } else {
                        MarkModel.this.f19222h.a(false, this.f19224b, this.f19223a.getErrorString());
                    }
                }
                MarkModel.this.f19221g = null;
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
        }
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f19219e = false;
        this.f19220f = null;
        this.f19221g = null;
        this.f19222h = null;
        this.f19220f = new MarkData();
    }

    public void A(boolean z) {
        this.f19219e = z;
    }

    public void B(MarkData markData) {
        this.f19220f = markData;
    }

    public void C(a.InterfaceC1039a interfaceC1039a) {
        this.f19222h = interfaceC1039a;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f19221g;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void v() {
        a aVar = this.f19221g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(true);
        this.f19221g = aVar2;
        aVar2.setPriority(3);
        this.f19221g.execute(new Boolean[0]);
    }

    public void w() {
        a aVar = this.f19221g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(false);
        this.f19221g = aVar2;
        aVar2.setPriority(3);
        this.f19221g.execute(new Boolean[0]);
    }

    public boolean x() {
        return this.f19219e;
    }

    public MarkData y() {
        return this.f19220f;
    }

    public String z() {
        MarkData markData = this.f19220f;
        if (markData != null) {
            return markData.getPostId();
        }
        return null;
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f19219e = false;
        this.f19220f = null;
        this.f19221g = null;
        this.f19222h = null;
        this.f19220f = new MarkData();
    }
}
