package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e<TopRecActivity> {
    private boolean aMC;
    a bTO;
    b bTP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Boolean bool, TRForumListData tRForumListData, int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TopRecActivity topRecActivity) {
        super(topRecActivity.getPageContext());
        this.aMC = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.bTO = new a(this, null);
        this.bTO.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bTO != null) {
            this.bTO.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.bTP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, TRForumListData> {
        private w afm;
        TRForumListData bTk;

        private a() {
            this.afm = null;
            this.bTk = new TRForumListData();
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
                this.afm = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
                this.afm.o("rn", "100");
                tG = this.afm.tG();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (tG == null) {
                return null;
            }
            if (!this.afm.uh().va().qT()) {
                h.this.aMC = false;
            } else {
                this.bTk = (TRForumListData) i.objectWithJsonStr(tG, TRForumListData.class);
                h.this.aMC = true;
            }
            return this.bTk;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(TRForumListData tRForumListData) {
            super.onPostExecute(tRForumListData);
            if (tRForumListData != null) {
                if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                    h.this.bTP.a(Boolean.valueOf(h.this.aMC), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                } else {
                    h.this.bTP.a(Boolean.valueOf(h.this.aMC), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
                }
            }
        }
    }
}
