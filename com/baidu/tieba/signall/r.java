package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b cBh;
    private p cBi;
    private a cBj;
    private c cBk;
    public boolean pY;

    /* loaded from: classes.dex */
    public interface a {
        void b(p pVar);

        void hD(String str);
    }

    public r(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.cBh = null;
        this.cBi = null;
        this.cBj = null;
        this.cBi = new p();
    }

    public void a(a aVar) {
        this.cBj = aVar;
    }

    public void c(c cVar) {
        this.cBk = cVar;
    }

    public c anq() {
        return this.cBk;
    }

    private String anr() {
        ArrayList<e> amQ = this.cBk.amQ();
        if (amQ == null) {
            return "";
        }
        if (!this.cBk.amR()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = amQ.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.ana() < this.cBk.getLevel()) {
                    arrayList.add(next);
                }
            }
            amQ.removeAll(arrayList);
        }
        int size = amQ.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = amQ.get(i);
            if (eVar.ane()) {
                if (!eVar.anf()) {
                    eVar.fm(true);
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
        if (this.cBh != null) {
            return false;
        }
        String anr = anr();
        this.cBh = new b();
        this.cBh.execute(anr);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cBh != null) {
            this.cBh.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, p> {
        private h cBl = null;

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
                this.cBl = new h();
                if (com.baidu.adp.lib.util.i.iO()) {
                    ke(sb.toString());
                }
            }
            return r.this.cBi;
        }

        private p ke(String str) {
            String kb = this.cBl.kb(str);
            if (this.cBl.rb()) {
                r.this.cBi.parserJson(kb);
                return r.this.cBi;
            }
            r.this.cBi = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.cBl.cancel();
            this.cBl = null;
            r.this.cBh = null;
            r.this.pY = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            r.this.pY = false;
            r.this.cBh = null;
            if (r.this.cBj != null) {
                if (r.this.cBi != null) {
                    r.this.cBj.b(r.this.cBi);
                } else {
                    r.this.cBj.hD(this.cBl != null ? this.cBl.rc() : null);
                }
            }
        }
    }
}
