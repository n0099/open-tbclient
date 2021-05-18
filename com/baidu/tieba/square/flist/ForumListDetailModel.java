package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.square.flist.ForumListModel;
import d.a.c.e.d.l;
/* loaded from: classes5.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<ForumListActivity> f20712e;

    /* renamed from: f  reason: collision with root package name */
    public ForumListModel.RequestParams f20713f;

    /* renamed from: g  reason: collision with root package name */
    public b f20714g;

    /* renamed from: h  reason: collision with root package name */
    public c f20715h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20716i;
    public boolean j;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i2, ForumListModel forumListModel, String str, boolean z2);
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {

        /* renamed from: a  reason: collision with root package name */
        public ForumListModel f20717a;

        public c() {
            this.f20717a = new ForumListModel(ForumListDetailModel.this.f20712e);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            String str;
            try {
                if (ForumListDetailModel.this.f20716i) {
                    l<String> g2 = d.a.j0.r.r.a.f().g("tb.my_posts");
                    if (g2 != null) {
                        str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + ForumListDetailModel.this.f20713f.menu_name + ForumListModel.KEY);
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        ForumListModel forumListModel = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        this.f20717a = forumListModel;
                        if (forumListModel != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.j = true;
                    }
                }
                ForumListDetailModel.this.f20716i = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.f20713f);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumListModel forumListModel) {
            if (forumListModel != null && forumListModel.isOk()) {
                ForumListDetailModel.this.f20714g.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.j);
            } else {
                ForumListDetailModel.this.f20714g.a(false, 0, forumListModel, ForumListDetailModel.this.f20712e.getString(R.string.neterror), ForumListDetailModel.this.j);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.f20717a != null) {
                b bVar = ForumListDetailModel.this.f20714g;
                int errorCode = this.f20717a.getErrorCode();
                ForumListModel forumListModel = this.f20717a;
                bVar.a(true, errorCode, forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.j);
            }
        }
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.f20716i = true;
        this.j = false;
        this.f20712e = tbPageContext;
        this.f20713f = requestParams;
    }

    public void A(ForumListModel.RequestParams requestParams) {
        this.f20713f = requestParams;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        c cVar = new c();
        this.f20715h = cVar;
        cVar.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        c cVar = this.f20715h;
        if (cVar == null) {
            return false;
        }
        cVar.cancel();
        return true;
    }

    public void z(b bVar) {
        this.f20714g = bVar;
    }
}
