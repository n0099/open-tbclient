package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.b.b.e.d.l;
import d.b.i0.z2.j.d;
/* loaded from: classes5.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f21183e;

    /* renamed from: f  reason: collision with root package name */
    public c f21184f;

    /* renamed from: g  reason: collision with root package name */
    public String f21185g;

    /* renamed from: h  reason: collision with root package name */
    public String f21186h;
    public String i;
    public boolean j;
    public boolean k;

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, Integer, d.b.i0.z2.j.c> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f21187a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.i0.z2.j.c f21188b;

        public b() {
            this.f21187a = null;
            this.f21188b = new d.b.i0.z2.j.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.b.i0.z2.j.c doInBackground(Object... objArr) {
            String str;
            String postNetData;
            l<String> g2 = d.b.h0.r.r.a.f().g("tb.my_posts");
            if (g2 != null) {
                str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.f21185g + "_dir");
            } else {
                str = null;
            }
            if (str != null) {
                this.f21188b.e(str);
                DirMenuModel.this.k = true;
                publishProgress(new Integer[0]);
            }
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.f21187a = netWork;
                netWork.addPostData("menu_name", DirMenuModel.this.f21185g);
                this.f21187a.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.f21186h);
                this.f21187a.addPostData("menu_id", DirMenuModel.this.i);
                postNetData = this.f21187a.postNetData();
            } catch (Exception e2) {
                this.f21188b.g(e2.getMessage());
                BdLog.detailException(e2);
            }
            if (postNetData == null) {
                return this.f21188b;
            }
            if (this.f21187a.getNetContext().getResponse().isRequestSuccess()) {
                this.f21188b.e(postNetData);
                DirMenuModel.this.j = true;
                if (g2 != null) {
                    g2.e(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.f21185g + "_dir", postNetData, 86400000L);
                }
            } else {
                this.f21188b.g(this.f21187a.getErrorString());
                DirMenuModel.this.j = false;
            }
            return this.f21188b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.b.i0.z2.j.c cVar) {
            if (!DirMenuModel.this.j) {
                DirMenuModel.this.f21184f.a(false, -1, null, cVar.b(), DirMenuModel.this.k);
            } else if (cVar.h() != null) {
                DirMenuModel.this.f21184f.a(true, cVar.a(), cVar.h(), cVar.b(), DirMenuModel.this.k);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f21187a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f21187a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.f21188b != null) {
                DirMenuModel.this.f21184f.a(true, this.f21188b.a(), this.f21188b.h(), this.f21188b.b(), DirMenuModel.this.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.j = false;
        this.k = false;
        this.f21185g = str;
        this.f21186h = str2;
        this.i = str3;
    }

    public void A(c cVar) {
        this.f21184f = cVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        b bVar = new b();
        this.f21183e = bVar;
        bVar.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f21183e;
        if (bVar != null) {
            bVar.cancel();
            return false;
        }
        return false;
    }
}
