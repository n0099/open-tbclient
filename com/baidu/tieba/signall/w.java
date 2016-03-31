package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b egP;
    private u egQ;
    private a egR;
    private c egS;
    public boolean qg;

    /* loaded from: classes.dex */
    public interface a {
        void b(u uVar);

        void jk(String str);
    }

    public w(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.egP = null;
        this.egQ = null;
        this.egR = null;
        this.egQ = new u();
    }

    public void a(a aVar) {
        this.egR = aVar;
    }

    public void d(c cVar) {
        this.egS = cVar;
    }

    public c aQc() {
        return this.egS;
    }

    private String aQd() {
        ArrayList<e> aPB = this.egS.aPB();
        if (aPB == null) {
            return "";
        }
        if (!this.egS.aPC()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = aPB.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.getUserLevel() < this.egS.getLevel()) {
                    arrayList.add(next);
                }
            }
            aPB.removeAll(arrayList);
        }
        int size = aPB.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = aPB.get(i);
            if (eVar.aPO()) {
                if (!eVar.aPP()) {
                    eVar.iy(true);
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
        if (this.egP != null) {
            return false;
        }
        String aQd = aQd();
        this.egP = new b();
        this.egP.execute(aQd);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.egP != null) {
            this.egP.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, u> {
        private h egT = null;

        public b() {
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            w.this.qg = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public u doInBackground(String... strArr) {
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
                this.egT = new h();
                if (com.baidu.adp.lib.util.i.jf()) {
                    nB(sb.toString());
                }
            }
            return w.this.egQ;
        }

        private u nB(String str) {
            String ny = this.egT.ny(str);
            if (this.egT.qC()) {
                w.this.egQ.parserJson(ny);
                return w.this.egQ;
            }
            w.this.egQ = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.egT.cancel();
            this.egT = null;
            w.this.egP = null;
            w.this.qg = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(u uVar) {
            w.this.qg = false;
            w.this.egP = null;
            if (w.this.egR != null) {
                if (w.this.egQ != null) {
                    w.this.egR.b(w.this.egQ);
                } else {
                    w.this.egR.jk(this.egT != null ? this.egT.qD() : null);
                }
            }
        }
    }
}
