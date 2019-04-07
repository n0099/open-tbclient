package com.baidu.tieba.square.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes5.dex */
public class ForumRankModel extends BdBaseModel {
    private a iAU;
    private String id;
    private String stType;

    public ForumRankModel(Bundle bundle) {
        super(null);
        this.id = null;
        this.iAU = null;
        this.stType = null;
        this.id = bundle.getString("id");
        this.stType = bundle.getString("st_type");
    }

    public ForumRankModel(Intent intent) {
        super(null);
        this.id = null;
        this.iAU = null;
        this.stType = null;
        this.id = intent.getStringExtra("id");
        this.stType = intent.getStringExtra("st_type");
    }

    public void aa(Bundle bundle) {
        bundle.putString("id", this.id);
        bundle.putString("st_type", this.stType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.id == null) {
            return false;
        }
        if (this.iAU == null) {
            this.iAU = new a();
            this.iAU.execute(new Void[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iAU != null) {
            this.iAU.cancel();
            return false;
        }
        return false;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Void, ForumRankData, ForumRankData> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumRankData doInBackground(Void... voidArr) {
            ForumRankData forumRankData;
            l<String> lw = com.baidu.tbadk.core.c.a.aaT().lw("tb.forum_rank");
            String str = lw != null ? lw.get("forum_rank_cache_key_" + ForumRankModel.this.id) : null;
            if (!StringUtils.isNull(str) && (forumRankData = (ForumRankData) OrmObject.objectWithJsonStr(str, ForumRankData.class)) != null) {
                publishProgress(forumRankData);
            }
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/forumsquarelist");
            xVar.x("list_id", ForumRankModel.this.id);
            xVar.x("st_type", ForumRankModel.this.stType);
            String acg = xVar.acg();
            if (StringUtils.isNull(acg)) {
                return null;
            }
            if (lw != null) {
                lw.a("forum_rank_cache_key_" + ForumRankModel.this.id, acg, 86400000L);
            }
            return (ForumRankData) OrmObject.objectWithJsonStr(acg, ForumRankData.class);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            ForumRankModel.this.iAU = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ForumRankData... forumRankDataArr) {
            super.onProgressUpdate(forumRankDataArr);
            if (ForumRankModel.this.mLoadDataCallBack != null && forumRankDataArr != null && forumRankDataArr.length > 0) {
                ForumRankModel.this.mLoadDataCallBack.m(forumRankDataArr[0]);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ForumRankData forumRankData) {
            ForumRankModel.this.iAU = null;
            if (ForumRankModel.this.mLoadDataCallBack != null) {
                ForumRankModel.this.mLoadDataCallBack.m(forumRankData);
            }
        }
    }
}
