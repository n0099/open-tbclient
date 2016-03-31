package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e<TopRecActivity> {
    private boolean bbX;
    a cFo;
    b cFp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Boolean bool, TRForumListData tRForumListData, int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TopRecActivity topRecActivity) {
        super(topRecActivity.getPageContext());
        this.bbX = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.cFo = new a(this, null);
        this.cFo.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cFo != null) {
            this.cFo.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.cFp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, TRForumListData> {
        private ab aiW;
        TRForumListData cEL;

        private a() {
            this.aiW = null;
            this.cEL = new TRForumListData();
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public TRForumListData doInBackground(Object... objArr) {
            String vw;
            try {
                this.aiW = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
                this.aiW.p(LegoListActivityConfig.RN, "100");
                vw = this.aiW.vw();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (vw == null) {
                return null;
            }
            if (!this.aiW.vU().wP().qC()) {
                h.this.bbX = false;
            } else {
                this.cEL = (TRForumListData) i.objectWithJsonStr(vw, TRForumListData.class);
                h.this.bbX = true;
            }
            return this.cEL;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(TRForumListData tRForumListData) {
            super.onPostExecute(tRForumListData);
            if (tRForumListData != null) {
                if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                    h.this.cFp.a(Boolean.valueOf(h.this.bbX), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                } else {
                    h.this.cFp.a(Boolean.valueOf(h.this.bbX), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
                }
            }
        }
    }
}
