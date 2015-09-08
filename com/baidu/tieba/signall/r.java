package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b cJF;
    private p cJG;
    private a cJH;
    private c cJI;
    public boolean pY;

    /* loaded from: classes.dex */
    public interface a {
        void b(p pVar);

        void hM(String str);
    }

    public r(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.cJF = null;
        this.cJG = null;
        this.cJH = null;
        this.cJG = new p();
    }

    public void a(a aVar) {
        this.cJH = aVar;
    }

    public void c(c cVar) {
        this.cJI = cVar;
    }

    public c arz() {
        return this.cJI;
    }

    private String arA() {
        ArrayList<e> aqZ = this.cJI.aqZ();
        if (aqZ == null) {
            return "";
        }
        if (!this.cJI.ara()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = aqZ.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.arj() < this.cJI.getLevel()) {
                    arrayList.add(next);
                }
            }
            aqZ.removeAll(arrayList);
        }
        int size = aqZ.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = aqZ.get(i);
            if (eVar.arn()) {
                if (!eVar.aro()) {
                    eVar.fX(true);
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
        if (this.cJF != null) {
            return false;
        }
        String arA = arA();
        this.cJF = new b();
        this.cJF.execute(arA);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cJF != null) {
            this.cJF.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, p> {
        private h cJJ = null;

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
        /* renamed from: A */
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
                this.cJJ = new h();
                if (com.baidu.adp.lib.util.i.iL()) {
                    kJ(sb.toString());
                }
            }
            return r.this.cJG;
        }

        private p kJ(String str) {
            String kG = this.cJJ.kG(str);
            if (this.cJJ.qZ()) {
                r.this.cJG.parserJson(kG);
                return r.this.cJG;
            }
            r.this.cJG = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.cJJ.cancel();
            this.cJJ = null;
            r.this.cJF = null;
            r.this.pY = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            r.this.pY = false;
            r.this.cJF = null;
            if (r.this.cJH != null) {
                if (r.this.cJG != null) {
                    r.this.cJH.b(r.this.cJG);
                } else {
                    r.this.cJH.hM(this.cJJ != null ? this.cJJ.ra() : null);
                }
            }
        }
    }
}
