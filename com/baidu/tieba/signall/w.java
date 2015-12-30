package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b dym;
    private u dyn;
    private a dyo;
    private c dyp;
    public boolean pZ;

    /* loaded from: classes.dex */
    public interface a {
        void b(u uVar);

        void iz(String str);
    }

    public w(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.dym = null;
        this.dyn = null;
        this.dyo = null;
        this.dyn = new u();
    }

    public void a(a aVar) {
        this.dyo = aVar;
    }

    public void d(c cVar) {
        this.dyp = cVar;
    }

    public c aCf() {
        return this.dyp;
    }

    private String aCg() {
        ArrayList<e> aBE = this.dyp.aBE();
        if (aBE == null) {
            return "";
        }
        if (!this.dyp.aBF()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = aBE.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.Sa() < this.dyp.getLevel()) {
                    arrayList.add(next);
                }
            }
            aBE.removeAll(arrayList);
        }
        int size = aBE.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = aBE.get(i);
            if (eVar.aBR()) {
                if (!eVar.aBS()) {
                    eVar.hj(true);
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
        if (this.dym != null) {
            return false;
        }
        String aCg = aCg();
        this.dym = new b();
        this.dym.execute(aCg);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.dym != null) {
            this.dym.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, u> {
        private h dyq = null;

        public b() {
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            w.this.pZ = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
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
                this.dyq = new h();
                if (com.baidu.adp.lib.util.i.iQ()) {
                    lZ(sb.toString());
                }
            }
            return w.this.dyn;
        }

        private u lZ(String str) {
            String lW = this.dyq.lW(str);
            if (this.dyq.qO()) {
                w.this.dyn.parserJson(lW);
                return w.this.dyn;
            }
            w.this.dyn = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.dyq.cancel();
            this.dyq = null;
            w.this.dym = null;
            w.this.pZ = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(u uVar) {
            w.this.pZ = false;
            w.this.dym = null;
            if (w.this.dyo != null) {
                if (w.this.dyn != null) {
                    w.this.dyo.b(w.this.dyn);
                } else {
                    w.this.dyo.iz(this.dyq != null ? this.dyq.qP() : null);
                }
            }
        }
    }
}
