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
/* loaded from: classes3.dex */
public class MarkModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f18420e;

    /* renamed from: f  reason: collision with root package name */
    public MarkData f18421f;

    /* renamed from: g  reason: collision with root package name */
    public a f18422g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC1124a f18423h;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f18424a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f18425b;

        /* renamed from: c  reason: collision with root package name */
        public c f18426c;

        public a(boolean z) {
            this.f18425b = true;
            this.f18426c = null;
            this.f18425b = z;
            this.f18426c = new c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            if (this.f18425b) {
                this.f18424a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                d.a.n0.x1.g.a aVar = new d.a.n0.x1.g.a();
                aVar.j(MarkModel.this.f18421f);
                this.f18424a.addPostData("data", aVar.E(0, 1));
            } else {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.f18424a = netWork;
                netWork.addPostData("user_id", MarkModel.this.f18421f.getAccount());
                this.f18424a.addPostData("tid", MarkModel.this.f18421f.getId());
                this.f18424a.addPostData("fid", MarkModel.this.f18421f.getForumId());
            }
            this.f18426c.c(this.f18424a.postNetData());
            boolean z = this.f18426c.a() == 0;
            if (this.f18424a.getNetContext().getResponse().isRequestSuccess() && z) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f18424a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            MarkModel.this.f18422g = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.f18426c != null) {
                    d.a.m0.r.z.a.a("collection", 0L, 0, "add_collection_thread", this.f18426c.a(), this.f18426c.b(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.f18423h != null) {
                        MarkModel.this.f18423h.a(true, this.f18425b, null);
                    }
                } else if (MarkModel.this.f18423h != null) {
                    if (this.f18424a == null || this.f18424a.getNetContext().getResponse().isRequestSuccess()) {
                        MarkModel.this.f18423h.a(false, this.f18425b, this.f18426c.b());
                    } else {
                        MarkModel.this.f18423h.a(false, this.f18425b, this.f18424a.getErrorString());
                    }
                }
                MarkModel.this.f18422g = null;
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
        }
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f18420e = false;
        this.f18421f = null;
        this.f18422g = null;
        this.f18423h = null;
        this.f18421f = new MarkData();
    }

    public void A(boolean z) {
        this.f18420e = z;
    }

    public void B(MarkData markData) {
        this.f18421f = markData;
    }

    public void C(a.InterfaceC1124a interfaceC1124a) {
        this.f18423h = interfaceC1124a;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f18422g;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void v() {
        a aVar = this.f18422g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(true);
        this.f18422g = aVar2;
        aVar2.setPriority(3);
        this.f18422g.execute(new Boolean[0]);
    }

    public void w() {
        a aVar = this.f18422g;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(false);
        this.f18422g = aVar2;
        aVar2.setPriority(3);
        this.f18422g.execute(new Boolean[0]);
    }

    public boolean x() {
        return this.f18420e;
    }

    public MarkData y() {
        return this.f18421f;
    }

    public String z() {
        MarkData markData = this.f18421f;
        if (markData != null) {
            return markData.getPostId();
        }
        return null;
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f18420e = false;
        this.f18421f = null;
        this.f18422g = null;
        this.f18423h = null;
        this.f18421f = new MarkData();
    }
}
