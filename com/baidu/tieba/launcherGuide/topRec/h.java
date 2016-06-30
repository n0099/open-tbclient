package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e<TopRecActivity> {
    private boolean btY;
    a dkF;
    b dkG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Boolean bool, TRForumListData tRForumListData, int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TopRecActivity topRecActivity) {
        super(topRecActivity.getPageContext());
        this.btY = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.dkF = new a(this, null);
        this.dkF.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.dkF != null) {
            this.dkF.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.dkG = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, TRForumListData> {
        private ab afj;
        TRForumListData dkd;

        private a() {
            this.afj = null;
            this.dkd = new TRForumListData();
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public TRForumListData doInBackground(Object... objArr) {
            String ta;
            try {
                this.afj = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
                this.afj.n(LegoListActivityConfig.RN, "100");
                ta = this.afj.ta();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (ta == null) {
                return null;
            }
            if (!this.afj.ty().uv().nU()) {
                h.this.btY = false;
            } else {
                this.dkd = (TRForumListData) i.objectWithJsonStr(ta, TRForumListData.class);
                h.this.btY = true;
            }
            return this.dkd;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(TRForumListData tRForumListData) {
            super.onPostExecute(tRForumListData);
            if (tRForumListData != null) {
                if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                    h.this.dkG.a(Boolean.valueOf(h.this.btY), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                } else {
                    h.this.dkG.a(Boolean.valueOf(h.this.btY), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
                }
            }
        }
    }
}
