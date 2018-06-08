package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private h gAA;
    private a gAB;
    private c gAC;
    private b gAz;
    public boolean isRunning;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void ol(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gAz = null;
        this.gAA = null;
        this.gAB = null;
        this.gAA = new h();
    }

    public void a(a aVar) {
        this.gAB = aVar;
    }

    public void d(c cVar) {
        this.gAC = cVar;
    }

    public c btQ() {
        return this.gAC;
    }

    private String btR() {
        ArrayList<d> btn = this.gAC.btn();
        if (btn == null) {
            return "";
        }
        if (!this.gAC.bto()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = btn.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.btx() < this.gAC.getLevel()) {
                    arrayList.add(next);
                }
            }
            btn.removeAll(arrayList);
        }
        int size = btn.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = btn.get(i);
            if (dVar.btA()) {
                if (!dVar.btB()) {
                    dVar.mj(true);
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
        if (this.gAz != null) {
            return false;
        }
        String str = null;
        this.gAz = new b();
        boolean btd = this.gAC.btd();
        if (!btd) {
            str = btR();
        }
        this.gAz.ml(btd);
        this.gAz.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gAz != null) {
            this.gAz.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gAD = null;
        private boolean gAE = false;

        public b() {
            setPriority(3);
        }

        public void ml(boolean z) {
            this.gAE = z;
        }

        public boolean btS() {
            return this.gAE;
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
            if (!btS() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (btS()) {
                this.gAD = new e();
                if (com.baidu.adp.lib.util.j.jD()) {
                    btT();
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
                    this.gAD = new e();
                    if (com.baidu.adp.lib.util.j.jD()) {
                        tv(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gAA;
        }

        private h btT() {
            String btF = this.gAD.btF();
            if (this.gAD.isRequestSuccess()) {
                SignAllForumModel.this.gAA.parserJson(btF);
                return SignAllForumModel.this.gAA;
            }
            SignAllForumModel.this.gAA = null;
            return null;
        }

        private h tv(String str) {
            String ts = this.gAD.ts(str);
            if (this.gAD.isRequestSuccess()) {
                SignAllForumModel.this.gAA.parserJson(ts);
                return SignAllForumModel.this.gAA;
            }
            SignAllForumModel.this.gAA = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gAD.cancel();
            this.gAD = null;
            SignAllForumModel.this.gAz = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gAz = null;
            if (SignAllForumModel.this.gAB != null) {
                if (SignAllForumModel.this.gAA != null) {
                    SignAllForumModel.this.gAB.b(SignAllForumModel.this.gAA);
                } else {
                    SignAllForumModel.this.gAB.ol(this.gAD != null ? this.gAD.tr() : null);
                }
            }
        }
    }
}
