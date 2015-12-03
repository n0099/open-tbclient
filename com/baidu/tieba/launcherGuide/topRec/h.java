package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e<TopRecActivity> {
    private boolean aRl;
    a ckc;
    b ckd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Boolean bool, TRForumListData tRForumListData, int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TopRecActivity topRecActivity) {
        super(topRecActivity.getPageContext());
        this.aRl = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.ckc = new a(this, null);
        this.ckc.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.ckc != null) {
            this.ckc.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.ckd = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, TRForumListData> {
        private ab agS;
        TRForumListData cjy;

        private a() {
            this.agS = null;
            this.cjy = new TRForumListData();
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public TRForumListData doInBackground(Object... objArr) {
            String ul;
            try {
                this.agS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
                this.agS.o("rn", "100");
                ul = this.agS.ul();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (ul == null) {
                return null;
            }
            if (!this.agS.uM().vG().rf()) {
                h.this.aRl = false;
            } else {
                this.cjy = (TRForumListData) i.objectWithJsonStr(ul, TRForumListData.class);
                h.this.aRl = true;
            }
            return this.cjy;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(TRForumListData tRForumListData) {
            super.onPostExecute(tRForumListData);
            if (tRForumListData != null) {
                if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                    h.this.ckd.a(Boolean.valueOf(h.this.aRl), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                } else {
                    h.this.ckd.a(Boolean.valueOf(h.this.aRl), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
                }
            }
        }
    }
}
