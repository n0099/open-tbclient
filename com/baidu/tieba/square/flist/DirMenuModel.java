package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.e.d.l;
import d.a.n0.b3.j.d;
/* loaded from: classes5.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f20606e;

    /* renamed from: f  reason: collision with root package name */
    public c f20607f;

    /* renamed from: g  reason: collision with root package name */
    public String f20608g;

    /* renamed from: h  reason: collision with root package name */
    public String f20609h;

    /* renamed from: i  reason: collision with root package name */
    public String f20610i;
    public boolean j;
    public boolean k;

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, Integer, d.a.n0.b3.j.c> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20611a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.n0.b3.j.c f20612b;

        public b() {
            this.f20611a = null;
            this.f20612b = new d.a.n0.b3.j.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.a.n0.b3.j.c doInBackground(Object... objArr) {
            String str;
            String postNetData;
            l<String> g2 = d.a.m0.r.r.a.f().g("tb.my_posts");
            if (g2 != null) {
                str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.f20608g + "_dir");
            } else {
                str = null;
            }
            if (str != null) {
                this.f20612b.e(str);
                DirMenuModel.this.k = true;
                publishProgress(new Integer[0]);
            }
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.f20611a = netWork;
                netWork.addPostData("menu_name", DirMenuModel.this.f20608g);
                this.f20611a.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.f20609h);
                this.f20611a.addPostData("menu_id", DirMenuModel.this.f20610i);
                postNetData = this.f20611a.postNetData();
            } catch (Exception e2) {
                this.f20612b.g(e2.getMessage());
                BdLog.detailException(e2);
            }
            if (postNetData == null) {
                return this.f20612b;
            }
            if (this.f20611a.getNetContext().getResponse().isRequestSuccess()) {
                this.f20612b.e(postNetData);
                DirMenuModel.this.j = true;
                if (g2 != null) {
                    g2.e(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.f20608g + "_dir", postNetData, 86400000L);
                }
            } else {
                this.f20612b.g(this.f20611a.getErrorString());
                DirMenuModel.this.j = false;
            }
            return this.f20612b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.a.n0.b3.j.c cVar) {
            if (!DirMenuModel.this.j) {
                DirMenuModel.this.f20607f.a(false, -1, null, cVar.b(), DirMenuModel.this.k);
            } else if (cVar.h() != null) {
                DirMenuModel.this.f20607f.a(true, cVar.a(), cVar.h(), cVar.b(), DirMenuModel.this.k);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f20611a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f20611a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.f20612b != null) {
                DirMenuModel.this.f20607f.a(true, this.f20612b.a(), this.f20612b.h(), this.f20612b.b(), DirMenuModel.this.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(boolean z, int i2, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.j = false;
        this.k = false;
        this.f20608g = str;
        this.f20609h = str2;
        this.f20610i = str3;
    }

    public void A(c cVar) {
        this.f20607f = cVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        b bVar = new b();
        this.f20606e = bVar;
        bVar.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f20606e;
        if (bVar != null) {
            bVar.cancel();
            return false;
        }
        return false;
    }
}
