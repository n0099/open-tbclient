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
    private String id;
    private a jag;
    private String stType;

    public ForumRankModel(Bundle bundle) {
        super(null);
        this.id = null;
        this.jag = null;
        this.stType = null;
        this.id = bundle.getString("id");
        this.stType = bundle.getString("st_type");
    }

    public ForumRankModel(Intent intent) {
        super(null);
        this.id = null;
        this.jag = null;
        this.stType = null;
        this.id = intent.getStringExtra("id");
        this.stType = intent.getStringExtra("st_type");
    }

    public void ab(Bundle bundle) {
        bundle.putString("id", this.id);
        bundle.putString("st_type", this.stType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.id == null) {
            return false;
        }
        if (this.jag == null) {
            this.jag = new a();
            this.jag.execute(new Void[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jag != null) {
            this.jag.cancel();
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
            l<String> mL = com.baidu.tbadk.core.d.a.agF().mL("tb.forum_rank");
            String str = mL != null ? mL.get("forum_rank_cache_key_" + ForumRankModel.this.id) : null;
            if (!StringUtils.isNull(str) && (forumRankData = (ForumRankData) OrmObject.objectWithJsonStr(str, ForumRankData.class)) != null) {
                publishProgress(forumRankData);
            }
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/forumsquarelist");
            xVar.o("list_id", ForumRankModel.this.id);
            xVar.o("st_type", ForumRankModel.this.stType);
            String aig = xVar.aig();
            if (StringUtils.isNull(aig)) {
                return null;
            }
            if (mL != null) {
                mL.a("forum_rank_cache_key_" + ForumRankModel.this.id, aig, 86400000L);
            }
            return (ForumRankData) OrmObject.objectWithJsonStr(aig, ForumRankData.class);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            ForumRankModel.this.jag = null;
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
            ForumRankModel.this.jag = null;
            if (ForumRankModel.this.mLoadDataCallBack != null) {
                ForumRankModel.this.mLoadDataCallBack.m(forumRankData);
            }
        }
    }
}
