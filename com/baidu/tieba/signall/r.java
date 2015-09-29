package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b cQA;
    private p cQB;
    private a cQC;
    private c cQD;
    public boolean pY;

    /* loaded from: classes.dex */
    public interface a {
        void b(p pVar);

        void hQ(String str);
    }

    public r(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.cQA = null;
        this.cQB = null;
        this.cQC = null;
        this.cQB = new p();
    }

    public void a(a aVar) {
        this.cQC = aVar;
    }

    public void c(c cVar) {
        this.cQD = cVar;
    }

    public c atN() {
        return this.cQD;
    }

    private String atO() {
        ArrayList<e> atn = this.cQD.atn();
        if (atn == null) {
            return "";
        }
        if (!this.cQD.ato()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = atn.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.atx() < this.cQD.getLevel()) {
                    arrayList.add(next);
                }
            }
            atn.removeAll(arrayList);
        }
        int size = atn.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = atn.get(i);
            if (eVar.atB()) {
                if (!eVar.atC()) {
                    eVar.gi(true);
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
        if (this.cQA != null) {
            return false;
        }
        String atO = atO();
        this.cQA = new b();
        this.cQA.execute(atO);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cQA != null) {
            this.cQA.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, p> {
        private h cQE = null;

        public b() {
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            r.this.pY = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public p doInBackground(String... strArr) {
            if (strArr[0] == null) {
                return null;
            }
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
                this.cQE = new h();
                if (com.baidu.adp.lib.util.i.iM()) {
                    lh(sb.toString());
                }
            }
            return r.this.cQB;
        }

        private p lh(String str) {
            String le = this.cQE.le(str);
            if (this.cQE.qV()) {
                r.this.cQB.parserJson(le);
                return r.this.cQB;
            }
            r.this.cQB = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.cQE.cancel();
            this.cQE = null;
            r.this.cQA = null;
            r.this.pY = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            r.this.pY = false;
            r.this.cQA = null;
            if (r.this.cQC != null) {
                if (r.this.cQB != null) {
                    r.this.cQC.b(r.this.cQB);
                } else {
                    r.this.cQC.hQ(this.cQE != null ? this.cQE.qW() : null);
                }
            }
        }
    }
}
