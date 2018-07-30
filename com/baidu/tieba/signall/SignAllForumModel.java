package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gFB;
    private h gFC;
    private a gFD;
    private c gFE;
    public boolean isRunning;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void op(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gFB = null;
        this.gFC = null;
        this.gFD = null;
        this.gFC = new h();
    }

    public void a(a aVar) {
        this.gFD = aVar;
    }

    public void d(c cVar) {
        this.gFE = cVar;
    }

    public c bsT() {
        return this.gFE;
    }

    private String bsU() {
        ArrayList<d> bsq = this.gFE.bsq();
        if (bsq == null) {
            return "";
        }
        if (!this.gFE.bsr()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = bsq.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bsA() < this.gFE.getLevel()) {
                    arrayList.add(next);
                }
            }
            bsq.removeAll(arrayList);
        }
        int size = bsq.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = bsq.get(i);
            if (dVar.bsD()) {
                if (!dVar.bsE()) {
                    dVar.mf(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(dVar.getForumId());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.gFB != null) {
            return false;
        }
        String str = null;
        this.gFB = new b();
        boolean bsg = this.gFE.bsg();
        if (!bsg) {
            str = bsU();
        }
        this.gFB.mh(bsg);
        this.gFB.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gFB != null) {
            this.gFB.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gFF = null;
        private boolean gFG = false;

        public b() {
            setPriority(3);
        }

        public void mh(boolean z) {
            this.gFG = z;
        }

        public boolean bsV() {
            return this.gFG;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            SignAllForumModel.this.isRunning = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public h doInBackground(String... strArr) {
            if (!bsV() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (bsV()) {
                this.gFF = new e();
                if (com.baidu.adp.lib.util.j.jE()) {
                    bsW();
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
                            sb.append(split[i2 + i3] + ",");
                        }
                    }
                    this.gFF = new e();
                    if (com.baidu.adp.lib.util.j.jE()) {
                        ts(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gFC;
        }

        private h bsW() {
            String bsI = this.gFF.bsI();
            if (this.gFF.isRequestSuccess()) {
                SignAllForumModel.this.gFC.parserJson(bsI);
                return SignAllForumModel.this.gFC;
            }
            SignAllForumModel.this.gFC = null;
            return null;
        }

        private h ts(String str) {
            String tp = this.gFF.tp(str);
            if (this.gFF.isRequestSuccess()) {
                SignAllForumModel.this.gFC.parserJson(tp);
                return SignAllForumModel.this.gFC;
            }
            SignAllForumModel.this.gFC = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gFF.cancel();
            this.gFF = null;
            SignAllForumModel.this.gFB = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gFB = null;
            if (SignAllForumModel.this.gFD != null) {
                if (SignAllForumModel.this.gFC != null) {
                    SignAllForumModel.this.gFD.b(SignAllForumModel.this.gFC);
                } else {
                    SignAllForumModel.this.gFD.op(this.gFF != null ? this.gFF.tc() : null);
                }
            }
        }
    }
}
