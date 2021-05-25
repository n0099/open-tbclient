package com.baidu.tieba.square.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.e.d.l;
/* loaded from: classes5.dex */
public class ForumRankModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public String f20648e;

    /* renamed from: f  reason: collision with root package name */
    public b f20649f;

    /* renamed from: g  reason: collision with root package name */
    public String f20650g;

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, ForumRankData, ForumRankData> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumRankData doInBackground(Void... voidArr) {
            String str;
            ForumRankData forumRankData;
            l<String> g2 = d.a.m0.r.r.a.f().g("tb.forum_rank");
            if (g2 != null) {
                str = g2.get("forum_rank_cache_key_" + ForumRankModel.this.f20648e);
            } else {
                str = null;
            }
            if (!StringUtils.isNull(str) && (forumRankData = (ForumRankData) OrmObject.objectWithJsonStr(str, ForumRankData.class)) != null) {
                publishProgress(forumRankData);
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumsquarelist");
            netWork.addPostData("list_id", ForumRankModel.this.f20648e);
            netWork.addPostData("st_type", ForumRankModel.this.f20650g);
            String postNetData = netWork.postNetData();
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            if (g2 != null) {
                g2.e("forum_rank_cache_key_" + ForumRankModel.this.f20648e, postNetData, 86400000L);
            }
            return (ForumRankData) OrmObject.objectWithJsonStr(postNetData, ForumRankData.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumRankData forumRankData) {
            ForumRankModel.this.f20649f = null;
            if (ForumRankModel.this.mLoadDataCallBack != null) {
                ForumRankModel.this.mLoadDataCallBack.c(forumRankData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            ForumRankModel.this.f20649f = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(ForumRankData... forumRankDataArr) {
            super.onProgressUpdate(forumRankDataArr);
            if (ForumRankModel.this.mLoadDataCallBack == null || forumRankDataArr == null || forumRankDataArr.length <= 0) {
                return;
            }
            ForumRankModel.this.mLoadDataCallBack.c(forumRankDataArr[0]);
        }
    }

    public ForumRankModel(Bundle bundle) {
        super(null);
        this.f20648e = null;
        this.f20649f = null;
        this.f20650g = null;
        this.f20648e = bundle.getString("id");
        this.f20650g = bundle.getString("st_type");
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f20648e == null) {
            return false;
        }
        if (this.f20649f == null) {
            b bVar = new b();
            this.f20649f = bVar;
            bVar.execute(new Void[0]);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f20649f;
        if (bVar != null) {
            bVar.cancel();
            return false;
        }
        return false;
    }

    public void z(Bundle bundle) {
        bundle.putString("id", this.f20648e);
        bundle.putString("st_type", this.f20650g);
    }

    public ForumRankModel(Intent intent) {
        super(null);
        this.f20648e = null;
        this.f20649f = null;
        this.f20650g = null;
        this.f20648e = intent.getStringExtra("id");
        this.f20650g = intent.getStringExtra("st_type");
    }
}
