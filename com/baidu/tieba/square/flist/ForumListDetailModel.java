package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.square.flist.ForumListModel;
import d.b.c.e.d.l;
/* loaded from: classes4.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<ForumListActivity> f20901e;

    /* renamed from: f  reason: collision with root package name */
    public ForumListModel.RequestParams f20902f;

    /* renamed from: g  reason: collision with root package name */
    public b f20903g;

    /* renamed from: h  reason: collision with root package name */
    public c f20904h;
    public boolean i;
    public boolean j;

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {

        /* renamed from: a  reason: collision with root package name */
        public ForumListModel f20905a;

        public c() {
            this.f20905a = new ForumListModel(ForumListDetailModel.this.f20901e);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            String str;
            try {
                if (ForumListDetailModel.this.i) {
                    l<String> g2 = d.b.i0.r.r.a.f().g("tb.my_posts");
                    if (g2 != null) {
                        str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + ForumListDetailModel.this.f20902f.menu_name + ForumListModel.KEY);
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        ForumListModel forumListModel = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        this.f20905a = forumListModel;
                        if (forumListModel != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.j = true;
                    }
                }
                ForumListDetailModel.this.i = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.f20902f);
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
                ForumListDetailModel.this.f20903g.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.j);
            } else {
                ForumListDetailModel.this.f20903g.a(false, 0, forumListModel, ForumListDetailModel.this.f20901e.getString(R.string.neterror), ForumListDetailModel.this.j);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.f20905a != null) {
                b bVar = ForumListDetailModel.this.f20903g;
                int errorCode = this.f20905a.getErrorCode();
                ForumListModel forumListModel = this.f20905a;
                bVar.a(true, errorCode, forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.j);
            }
        }
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.i = true;
        this.j = false;
        this.f20901e = tbPageContext;
        this.f20902f = requestParams;
    }

    public void A(ForumListModel.RequestParams requestParams) {
        this.f20902f = requestParams;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        c cVar = new c();
        this.f20904h = cVar;
        cVar.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        c cVar = this.f20904h;
        if (cVar == null) {
            return false;
        }
        cVar.cancel();
        return true;
    }

    public void z(b bVar) {
        this.f20903g = bVar;
    }
}
