package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b dqS;
    private p dqT;
    private a dqU;
    private c dqV;
    public boolean pZ;

    /* loaded from: classes.dex */
    public interface a {
        void b(p pVar);

        void in(String str);
    }

    public r(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.dqS = null;
        this.dqT = null;
        this.dqU = null;
        this.dqT = new p();
    }

    public void a(a aVar) {
        this.dqU = aVar;
    }

    public void c(c cVar) {
        this.dqV = cVar;
    }

    public c azX() {
        return this.dqV;
    }

    private String azY() {
        ArrayList<e> azx = this.dqV.azx();
        if (azx == null) {
            return "";
        }
        if (!this.dqV.azy()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = azx.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.RI() < this.dqV.getLevel()) {
                    arrayList.add(next);
                }
            }
            azx.removeAll(arrayList);
        }
        int size = azx.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = azx.get(i);
            if (eVar.azK()) {
                if (!eVar.azL()) {
                    eVar.ha(true);
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
        if (this.dqS != null) {
            return false;
        }
        String azY = azY();
        this.dqS = new b();
        this.dqS.execute(azY);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.dqS != null) {
            this.dqS.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, p> {
        private h dqW = null;

        public b() {
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            r.this.pZ = true;
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
                this.dqW = new h();
                if (com.baidu.adp.lib.util.i.iP()) {
                    mc(sb.toString());
                }
            }
            return r.this.dqT;
        }

        private p mc(String str) {
            String lZ = this.dqW.lZ(str);
            if (this.dqW.rf()) {
                r.this.dqT.parserJson(lZ);
                return r.this.dqT;
            }
            r.this.dqT = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.dqW.cancel();
            this.dqW = null;
            r.this.dqS = null;
            r.this.pZ = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            r.this.pZ = false;
            r.this.dqS = null;
            if (r.this.dqU != null) {
                if (r.this.dqT != null) {
                    r.this.dqU.b(r.this.dqT);
                } else {
                    r.this.dqU.in(this.dqW != null ? this.dqW.rg() : null);
                }
            }
        }
    }
}
