package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gnY;
    private h gnZ;
    private a goa;
    private c gob;
    public boolean isRunning;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void nv(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gnY = null;
        this.gnZ = null;
        this.goa = null;
        this.gnZ = new h();
    }

    public void a(a aVar) {
        this.goa = aVar;
    }

    public void d(c cVar) {
        this.gob = cVar;
    }

    public c boS() {
        return this.gob;
    }

    private String boT() {
        ArrayList<d> bop = this.gob.bop();
        if (bop == null) {
            return "";
        }
        if (!this.gob.boq()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = bop.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.boz() < this.gob.getLevel()) {
                    arrayList.add(next);
                }
            }
            bop.removeAll(arrayList);
        }
        int size = bop.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = bop.get(i);
            if (dVar.boC()) {
                if (!dVar.boD()) {
                    dVar.mc(true);
                }
            }
            if (i > 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(dVar.getForumId());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.gnY != null) {
            return false;
        }
        String str = null;
        this.gnY = new b();
        boolean bof = this.gob.bof();
        if (!bof) {
            str = boT();
        }
        this.gnY.me(bof);
        this.gnY.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gnY != null) {
            this.gnY.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e goc = null;
        private boolean goe = false;

        public b() {
            setPriority(3);
        }

        public void me(boolean z) {
            this.goe = z;
        }

        public boolean boU() {
            return this.goe;
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
            if (!boU() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (boU()) {
                this.goc = new e();
                if (com.baidu.adp.lib.util.j.gP()) {
                    boV();
                }
            } else {
                String[] split = strArr[0].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int ceil = (int) Math.ceil(split.length / 50.0f);
                for (int i = 0; i < ceil; i++) {
                    int i2 = i * 50;
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 50 && i2 + i3 < split.length; i3++) {
                        if (i2 + i3 == split.length - 1) {
                            sb.append(split[i2 + i3]);
                        } else {
                            sb.append(split[i2 + i3] + Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    this.goc = new e();
                    if (com.baidu.adp.lib.util.j.gP()) {
                        sB(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gnZ;
        }

        private h boV() {
            String boH = this.goc.boH();
            if (this.goc.isRequestSuccess()) {
                SignAllForumModel.this.gnZ.parserJson(boH);
                return SignAllForumModel.this.gnZ;
            }
            SignAllForumModel.this.gnZ = null;
            return null;
        }

        private h sB(String str) {
            String sy = this.goc.sy(str);
            if (this.goc.isRequestSuccess()) {
                SignAllForumModel.this.gnZ.parserJson(sy);
                return SignAllForumModel.this.gnZ;
            }
            SignAllForumModel.this.gnZ = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.goc.cancel();
            this.goc = null;
            SignAllForumModel.this.gnY = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gnY = null;
            if (SignAllForumModel.this.goa != null) {
                if (SignAllForumModel.this.gnZ != null) {
                    SignAllForumModel.this.goa.b(SignAllForumModel.this.gnZ);
                } else {
                    SignAllForumModel.this.goa.nv(this.goc != null ? this.goc.pW() : null);
                }
            }
        }
    }
}
