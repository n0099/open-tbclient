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

    public c aQt() {
        return this.ekd;
    }

    private String aQu() {
        ArrayList<e> aPR = this.ekd.aPR();
        if (aPR == null) {
            return "";
        }
        if (!this.ekd.aPS()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = aPR.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.getUserLevel() < this.ekd.getLevel()) {
                    arrayList.add(next);
                }
            }
            aPR.removeAll(arrayList);
        }
        int size = aPR.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = aPR.get(i);
            if (eVar.aQe()) {
                if (!eVar.aQf()) {
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
        boolean aPH = this.ekd.aPH();
        if (!aPH) {
            str = aQu();
        }
        this.eka.jo(aPH);
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

        public boolean aQv() {
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
            if (!aQv() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (aQv()) {
                this.eke = new h();
                if (com.baidu.adp.lib.util.i.fq()) {
                    aQw();
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

        private u aQw() {
            String aQj = this.eke.aQj();
            if (this.eke.nZ()) {
                w.this.ekb.parserJson(aQj);
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
