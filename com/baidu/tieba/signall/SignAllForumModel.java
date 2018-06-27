package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gEs;
    private h gEt;
    private a gEu;
    private c gEv;
    public boolean isRunning;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void om(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gEs = null;
        this.gEt = null;
        this.gEu = null;
        this.gEt = new h();
    }

    public void a(a aVar) {
        this.gEu = aVar;
    }

    public void d(c cVar) {
        this.gEv = cVar;
    }

    public c buq() {
        return this.gEv;
    }

    private String bur() {
        ArrayList<d> btN = this.gEv.btN();
        if (btN == null) {
            return "";
        }
        if (!this.gEv.btO()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = btN.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.btX() < this.gEv.getLevel()) {
                    arrayList.add(next);
                }
            }
            btN.removeAll(arrayList);
        }
        int size = btN.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = btN.get(i);
            if (dVar.bua()) {
                if (!dVar.bub()) {
                    dVar.mu(true);
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
        if (this.gEs != null) {
            return false;
        }
        String str = null;
        this.gEs = new b();
        boolean btD = this.gEv.btD();
        if (!btD) {
            str = bur();
        }
        this.gEs.mw(btD);
        this.gEs.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gEs != null) {
            this.gEs.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gEw = null;
        private boolean gEx = false;

        public b() {
            setPriority(3);
        }

        public void mw(boolean z) {
            this.gEx = z;
        }

        public boolean bus() {
            return this.gEx;
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
        /* renamed from: D */
        public h doInBackground(String... strArr) {
            if (!bus() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (bus()) {
                this.gEw = new e();
                if (com.baidu.adp.lib.util.j.jD()) {
                    but();
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
                    this.gEw = new e();
                    if (com.baidu.adp.lib.util.j.jD()) {
                        tu(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gEt;
        }

        private h but() {
            String buf = this.gEw.buf();
            if (this.gEw.isRequestSuccess()) {
                SignAllForumModel.this.gEt.parserJson(buf);
                return SignAllForumModel.this.gEt;
            }
            SignAllForumModel.this.gEt = null;
            return null;
        }

        private h tu(String str) {
            String tr = this.gEw.tr(str);
            if (this.gEw.isRequestSuccess()) {
                SignAllForumModel.this.gEt.parserJson(tr);
                return SignAllForumModel.this.gEt;
            }
            SignAllForumModel.this.gEt = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gEw.cancel();
            this.gEw = null;
            SignAllForumModel.this.gEs = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gEs = null;
            if (SignAllForumModel.this.gEu != null) {
                if (SignAllForumModel.this.gEt != null) {
                    SignAllForumModel.this.gEu.b(SignAllForumModel.this.gEt);
                } else {
                    SignAllForumModel.this.gEu.om(this.gEw != null ? this.gEw.tr() : null);
                }
            }
        }
    }
}
