package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.square.flist.ForumListModel;
import d.b.b.e.d.l;
/* loaded from: classes5.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<ForumListActivity> f21208e;

    /* renamed from: f  reason: collision with root package name */
    public ForumListModel.RequestParams f21209f;

    /* renamed from: g  reason: collision with root package name */
    public b f21210g;

    /* renamed from: h  reason: collision with root package name */
    public c f21211h;
    public boolean i;
    public boolean j;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {

        /* renamed from: a  reason: collision with root package name */
        public ForumListModel f21212a;

        public c() {
            this.f21212a = new ForumListModel(ForumListDetailModel.this.f21208e);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            String str;
            try {
                if (ForumListDetailModel.this.i) {
                    l<String> g2 = d.b.h0.r.r.a.f().g("tb.my_posts");
                    if (g2 != null) {
                        str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + ForumListDetailModel.this.f21209f.menu_name + ForumListModel.KEY);
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        ForumListModel forumListModel = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        this.f21212a = forumListModel;
                        if (forumListModel != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.j = true;
                    }
                }
                ForumListDetailModel.this.i = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.f21209f);
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
                ForumListDetailModel.this.f21210g.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.j);
            } else {
                ForumListDetailModel.this.f21210g.a(false, 0, forumListModel, ForumListDetailModel.this.f21208e.getString(R.string.neterror), ForumListDetailModel.this.j);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.f21212a != null) {
                b bVar = ForumListDetailModel.this.f21210g;
                int errorCode = this.f21212a.getErrorCode();
                ForumListModel forumListModel = this.f21212a;
                bVar.a(true, errorCode, forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.j);
            }
        }
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.i = true;
        this.j = false;
        this.f21208e = tbPageContext;
        this.f21209f = requestParams;
    }

    public void A(ForumListModel.RequestParams requestParams) {
        this.f21209f = requestParams;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        c cVar = new c();
        this.f21211h = cVar;
        cVar.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        c cVar = this.f21211h;
        if (cVar == null) {
            return false;
        }
        cVar.cancel();
        return true;
    }

    public void z(b bVar) {
        this.f21210g = bVar;
    }
}
