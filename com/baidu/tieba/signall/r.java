package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b cQZ;
    private p cRa;
    private a cRb;
    private c cRc;
    public boolean pY;

    /* loaded from: classes.dex */
    public interface a {
        void b(p pVar);

        void hQ(String str);
    }

    public r(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.cQZ = null;
        this.cRa = null;
        this.cRb = null;
        this.cRa = new p();
    }

    public void a(a aVar) {
        this.cRb = aVar;
    }

    public void c(c cVar) {
        this.cRc = cVar;
    }

    public c atP() {
        return this.cRc;
    }

    private String atQ() {
        ArrayList<e> atp = this.cRc.atp();
        if (atp == null) {
            return "";
        }
        if (!this.cRc.atq()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = atp.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.atz() < this.cRc.getLevel()) {
                    arrayList.add(next);
                }
            }
            atp.removeAll(arrayList);
        }
        int size = atp.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = atp.get(i);
            if (eVar.atD()) {
                if (!eVar.atE()) {
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
        if (this.cQZ != null) {
            return false;
        }
        String atQ = atQ();
        this.cQZ = new b();
        this.cQZ.execute(atQ);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cQZ != null) {
            this.cQZ.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, p> {
        private h cRd = null;

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
                this.cRd = new h();
                if (com.baidu.adp.lib.util.i.iM()) {
                    lk(sb.toString());
                }
            }
            return r.this.cRa;
        }

        private p lk(String str) {
            String lh = this.cRd.lh(str);
            if (this.cRd.qS()) {
                r.this.cRa.parserJson(lh);
                return r.this.cRa;
            }
            r.this.cRa = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.cRd.cancel();
            this.cRd = null;
            r.this.cQZ = null;
            r.this.pY = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            r.this.pY = false;
            r.this.cQZ = null;
            if (r.this.cRb != null) {
                if (r.this.cRa != null) {
                    r.this.cRb.b(r.this.cRa);
                } else {
                    r.this.cRb.hQ(this.cRd != null ? this.cRd.qT() : null);
                }
            }
        }
    }
}
