package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e<TopRecActivity> {
    private boolean aMu;
    a bTt;
    b bTu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Boolean bool, TRForumListData tRForumListData, int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TopRecActivity topRecActivity) {
        super(topRecActivity.getPageContext());
        this.aMu = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.bTt = new a(this, null);
        this.bTt.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bTt != null) {
            this.bTt.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.bTu = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, TRForumListData> {
        private w afh;
        TRForumListData bSP;

        private a() {
            this.afh = null;
            this.bSP = new TRForumListData();
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public TRForumListData doInBackground(Object... objArr) {
            String tG;
            try {
                this.afh = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
                this.afh.o("rn", "100");
                tG = this.afh.tG();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (tG == null) {
                return null;
            }
            if (!this.afh.uh().uZ().qV()) {
                h.this.aMu = false;
            } else {
                this.bSP = (TRForumListData) i.objectWithJsonStr(tG, TRForumListData.class);
                h.this.aMu = true;
            }
            return this.bSP;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(TRForumListData tRForumListData) {
            super.onPostExecute(tRForumListData);
            if (tRForumListData != null) {
                if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                    h.this.bTu.a(Boolean.valueOf(h.this.aMu), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                } else {
                    h.this.bTu.a(Boolean.valueOf(h.this.aMu), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
                }
            }
        }
    }
}
