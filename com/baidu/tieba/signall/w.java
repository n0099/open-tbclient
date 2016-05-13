package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b eka;
    private u ekb;
    private a ekc;
    private c ekd;
    public boolean fU;

    /* loaded from: classes.dex */
    public interface a {
        void b(u uVar);

        void jm(String str);
    }

    public w(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.eka = null;
        this.ekb = null;
        this.ekc = null;
        this.ekb = new u();
    }

    public void a(a aVar) {
        this.ekc = aVar;
    }

    public void d(c cVar) {
        this.ekd = cVar;
    }

    public c aQw() {
        return this.ekd;
    }

    private String aQx() {
        ArrayList<e> aPU = this.ekd.aPU();
        if (aPU == null) {
            return "";
        }
        if (!this.ekd.aPV()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = aPU.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.getUserLevel() < this.ekd.getLevel()) {
                    arrayList.add(next);
                }
            }
            aPU.removeAll(arrayList);
        }
        int size = aPU.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = aPU.get(i);
            if (eVar.aQh()) {
                if (!eVar.aQi()) {
                    eVar.jm(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(eVar.getForumId());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.eka != null) {
            return false;
        }
        String str = null;
        this.eka = new b();
        boolean aPK = this.ekd.aPK();
        if (!aPK) {
            str = aQx();
        }
        this.eka.jo(aPK);
        this.eka.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.eka != null) {
            this.eka.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, u> {
        private h eke = null;
        private boolean ekf = false;

        public b() {
            setPriority(3);
        }

        public void jo(boolean z) {
            this.ekf = z;
        }

        public boolean aQy() {
            return this.ekf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            w.this.fU = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public u doInBackground(String... strArr) {
            if (!aQy() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (aQy()) {
                this.eke = new h();
                if (com.baidu.adp.lib.util.i.fq()) {
                    aQz();
                }
            } else {
                String[] split = strArr[0].split(",");
                int ceil = (int) Math.ceil(split.length / 50.0f);
                for (int i = 0; i < ceil; i++) {
                    int i2 = i * 50;
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 50 && i2 + i3 < split.length; i3++) {
                        if (i2 + i3 == split.length - 1) {
                            sb.append(split[i2 + i3]);
                        } else {
                            sb.append(String.valueOf(split[i2 + i3]) + ",");
                        }
                    }
                    this.eke = new h();
                    if (com.baidu.adp.lib.util.i.fq()) {
                        nA(sb.toString());
                    }
                }
            }
            return w.this.ekb;
        }

        private u aQz() {
            String aQm = this.eke.aQm();
            if (this.eke.nZ()) {
                w.this.ekb.parserJson(aQm);
                return w.this.ekb;
            }
            w.this.ekb = null;
            return null;
        }

        private u nA(String str) {
            String nx = this.eke.nx(str);
            if (this.eke.nZ()) {
                w.this.ekb.parserJson(nx);
                return w.this.ekb;
            }
            w.this.ekb = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.eke.cancel();
            this.eke = null;
            w.this.eka = null;
            w.this.fU = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(u uVar) {
            w.this.fU = false;
            w.this.eka = null;
            if (w.this.ekc != null) {
                if (w.this.ekb != null) {
                    w.this.ekc.b(w.this.ekb);
                } else {
                    w.this.ekc.jm(this.eke != null ? this.eke.oa() : null);
                }
            }
        }
    }
}
