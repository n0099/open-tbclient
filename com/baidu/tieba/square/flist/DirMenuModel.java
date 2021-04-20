package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.b.c.e.d.l;
import d.b.i0.a3.j.d;
/* loaded from: classes4.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f20869e;

    /* renamed from: f  reason: collision with root package name */
    public c f20870f;

    /* renamed from: g  reason: collision with root package name */
    public String f20871g;

    /* renamed from: h  reason: collision with root package name */
    public String f20872h;
    public String i;
    public boolean j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, Integer, d.b.i0.a3.j.c> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20873a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.i0.a3.j.c f20874b;

        public b() {
            this.f20873a = null;
            this.f20874b = new d.b.i0.a3.j.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.b.i0.a3.j.c doInBackground(Object... objArr) {
            String str;
            String postNetData;
            l<String> g2 = d.b.h0.r.r.a.f().g("tb.my_posts");
            if (g2 != null) {
                str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.f20871g + "_dir");
            } else {
                str = null;
            }
            if (str != null) {
                this.f20874b.e(str);
                DirMenuModel.this.k = true;
                publishProgress(new Integer[0]);
            }
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.f20873a = netWork;
                netWork.addPostData("menu_name", DirMenuModel.this.f20871g);
                this.f20873a.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.f20872h);
                this.f20873a.addPostData("menu_id", DirMenuModel.this.i);
                postNetData = this.f20873a.postNetData();
            } catch (Exception e2) {
                this.f20874b.g(e2.getMessage());
                BdLog.detailException(e2);
            }
            if (postNetData == null) {
                return this.f20874b;
            }
            if (this.f20873a.getNetContext().getResponse().isRequestSuccess()) {
                this.f20874b.e(postNetData);
                DirMenuModel.this.j = true;
                if (g2 != null) {
                    g2.e(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.f20871g + "_dir", postNetData, 86400000L);
                }
            } else {
                this.f20874b.g(this.f20873a.getErrorString());
                DirMenuModel.this.j = false;
            }
            return this.f20874b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.b.i0.a3.j.c cVar) {
            if (!DirMenuModel.this.j) {
                DirMenuModel.this.f20870f.a(false, -1, null, cVar.b(), DirMenuModel.this.k);
            } else if (cVar.h() != null) {
                DirMenuModel.this.f20870f.a(true, cVar.a(), cVar.h(), cVar.b(), DirMenuModel.this.k);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f20873a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f20873a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.f20874b != null) {
                DirMenuModel.this.f20870f.a(true, this.f20874b.a(), this.f20874b.h(), this.f20874b.b(), DirMenuModel.this.k);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.j = false;
        this.k = false;
        this.f20871g = str;
        this.f20872h = str2;
        this.i = str3;
    }

    public void A(c cVar) {
        this.f20870f = cVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        b bVar = new b();
        this.f20869e = bVar;
        bVar.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f20869e;
        if (bVar != null) {
            bVar.cancel();
            return false;
        }
        return false;
    }
}
