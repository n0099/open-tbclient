package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b cSv;
    private p cSw;
    private a cSx;
    private c cSy;
    public boolean pY;

    /* loaded from: classes.dex */
    public interface a {
        void b(p pVar);

        void hS(String str);
    }

    public r(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.cSv = null;
        this.cSw = null;
        this.cSx = null;
        this.cSw = new p();
    }

    public void a(a aVar) {
        this.cSx = aVar;
    }

    public void c(c cVar) {
        this.cSy = cVar;
    }

    public c auv() {
        return this.cSy;
    }

    private String auw() {
        ArrayList<e> atV = this.cSy.atV();
        if (atV == null) {
            return "";
        }
        if (!this.cSy.atW()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = atV.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.auf() < this.cSy.getLevel()) {
                    arrayList.add(next);
                }
            }
            atV.removeAll(arrayList);
        }
        int size = atV.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = atV.get(i);
            if (eVar.auj()) {
                if (!eVar.auk()) {
                    eVar.gl(true);
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
        if (this.cSv != null) {
            return false;
        }
        String auw = auw();
        this.cSv = new b();
        this.cSv.execute(auw);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cSv != null) {
            this.cSv.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, p> {
        private h cSz = null;

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
                this.cSz = new h();
                if (com.baidu.adp.lib.util.i.iN()) {
                    lo(sb.toString());
                }
            }
            return r.this.cSw;
        }

        private p lo(String str) {
            String ll = this.cSz.ll(str);
            if (this.cSz.qT()) {
                r.this.cSw.parserJson(ll);
                return r.this.cSw;
            }
            r.this.cSw = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.cSz.cancel();
            this.cSz = null;
            r.this.cSv = null;
            r.this.pY = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            r.this.pY = false;
            r.this.cSv = null;
            if (r.this.cSx != null) {
                if (r.this.cSw != null) {
                    r.this.cSx.b(r.this.cSw);
                } else {
                    r.this.cSx.hS(this.cSz != null ? this.cSz.qU() : null);
                }
            }
        }
    }
}
