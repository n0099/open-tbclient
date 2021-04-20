package com.baidu.tieba.square.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.b.c.e.d.l;
/* loaded from: classes4.dex */
public class ForumRankModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public String f20907e;

    /* renamed from: f  reason: collision with root package name */
    public b f20908f;

    /* renamed from: g  reason: collision with root package name */
    public String f20909g;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, ForumRankData, ForumRankData> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumRankData doInBackground(Void... voidArr) {
            String str;
            ForumRankData forumRankData;
            l<String> g2 = d.b.h0.r.r.a.f().g("tb.forum_rank");
            if (g2 != null) {
                str = g2.get("forum_rank_cache_key_" + ForumRankModel.this.f20907e);
            } else {
                str = null;
            }
            if (!StringUtils.isNull(str) && (forumRankData = (ForumRankData) OrmObject.objectWithJsonStr(str, ForumRankData.class)) != null) {
                publishProgress(forumRankData);
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumsquarelist");
            netWork.addPostData("list_id", ForumRankModel.this.f20907e);
            netWork.addPostData("st_type", ForumRankModel.this.f20909g);
            String postNetData = netWork.postNetData();
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            if (g2 != null) {
                g2.e("forum_rank_cache_key_" + ForumRankModel.this.f20907e, postNetData, 86400000L);
            }
            return (ForumRankData) OrmObject.objectWithJsonStr(postNetData, ForumRankData.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumRankData forumRankData) {
            ForumRankModel.this.f20908f = null;
            if (ForumRankModel.this.mLoadDataCallBack != null) {
                ForumRankModel.this.mLoadDataCallBack.c(forumRankData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            ForumRankModel.this.f20908f = null;
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
        this.f20907e = null;
        this.f20908f = null;
        this.f20909g = null;
        this.f20907e = bundle.getString("id");
        this.f20909g = bundle.getString("st_type");
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f20907e == null) {
            return false;
        }
        if (this.f20908f == null) {
            b bVar = new b();
            this.f20908f = bVar;
            bVar.execute(new Void[0]);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f20908f;
        if (bVar != null) {
            bVar.cancel();
            return false;
        }
        return false;
    }

    public void z(Bundle bundle) {
        bundle.putString("id", this.f20907e);
        bundle.putString("st_type", this.f20909g);
    }

    public ForumRankModel(Intent intent) {
        super(null);
        this.f20907e = null;
        this.f20908f = null;
        this.f20909g = null;
        this.f20907e = intent.getStringExtra("id");
        this.f20909g = intent.getStringExtra("st_type");
    }
}
