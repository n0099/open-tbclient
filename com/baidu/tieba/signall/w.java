package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b dOq;
    private u dOr;
    private a dOs;
    private c dOt;
    public boolean qc;

    /* loaded from: classes.dex */
    public interface a {
        void b(u uVar);

        void iB(String str);
    }

    public w(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.dOq = null;
        this.dOr = null;
        this.dOs = null;
        this.dOr = new u();
    }

    public void a(a aVar) {
        this.dOs = aVar;
    }

    public void d(c cVar) {
        this.dOt = cVar;
    }

    public c aJm() {
        return this.dOt;
    }

    private String aJn() {
        ArrayList<e> aIL = this.dOt.aIL();
        if (aIL == null) {
            return "";
        }
        if (!this.dOt.aIM()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = aIL.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.getUserLevel() < this.dOt.getLevel()) {
                    arrayList.add(next);
                }
            }
            aIL.removeAll(arrayList);
        }
        int size = aIL.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = aIL.get(i);
            if (eVar.aIY()) {
                if (!eVar.aIZ()) {
                    eVar.hJ(true);
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
        if (this.dOq != null) {
            return false;
        }
        String aJn = aJn();
        this.dOq = new b();
        this.dOq.execute(aJn);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.dOq != null) {
            this.dOq.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, u> {
        private h dOu = null;

        public b() {
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            w.this.qc = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
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
                this.dOu = new h();
                if (com.baidu.adp.lib.util.i.iZ()) {
                    mq(sb.toString());
                }
            }
            return w.this.dOr;
        }

        private u mq(String str) {
            String mn = this.dOu.mn(str);
            if (this.dOu.rl()) {
                w.this.dOr.parserJson(mn);
                return w.this.dOr;
            }
            w.this.dOr = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.dOu.cancel();
            this.dOu = null;
            w.this.dOq = null;
            w.this.qc = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(u uVar) {
            w.this.qc = false;
            w.this.dOq = null;
            if (w.this.dOs != null) {
                if (w.this.dOr != null) {
                    w.this.dOs.b(w.this.dOr);
                } else {
                    w.this.dOs.iB(this.dOu != null ? this.dOu.rm() : null);
                }
            }
        }
    }
}
