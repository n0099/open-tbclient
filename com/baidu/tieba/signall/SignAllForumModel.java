package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gnV;
    private h gnW;
    private a gnX;
    private c gnY;
    public boolean isRunning;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void nv(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gnV = null;
        this.gnW = null;
        this.gnX = null;
        this.gnW = new h();
    }

    public void a(a aVar) {
        this.gnX = aVar;
    }

    public void d(c cVar) {
        this.gnY = cVar;
    }

    public c boS() {
        return this.gnY;
    }

    private String boT() {
        ArrayList<d> bop = this.gnY.bop();
        if (bop == null) {
            return "";
        }
        if (!this.gnY.boq()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = bop.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.boz() < this.gnY.getLevel()) {
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
        if (this.gnV != null) {
            return false;
        }
        String str = null;
        this.gnV = new b();
        boolean bof = this.gnY.bof();
        if (!bof) {
            str = boT();
        }
        this.gnV.me(bof);
        this.gnV.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gnV != null) {
            this.gnV.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gnZ = null;
        private boolean goa = false;

        public b() {
            setPriority(3);
        }

        public void me(boolean z) {
            this.goa = z;
        }

        public boolean boU() {
            return this.goa;
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
                this.gnZ = new e();
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
                    this.gnZ = new e();
                    if (com.baidu.adp.lib.util.j.gP()) {
                        sB(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gnW;
        }

        private h boV() {
            String boH = this.gnZ.boH();
            if (this.gnZ.isRequestSuccess()) {
                SignAllForumModel.this.gnW.parserJson(boH);
                return SignAllForumModel.this.gnW;
            }
            SignAllForumModel.this.gnW = null;
            return null;
        }

        private h sB(String str) {
            String sy = this.gnZ.sy(str);
            if (this.gnZ.isRequestSuccess()) {
                SignAllForumModel.this.gnW.parserJson(sy);
                return SignAllForumModel.this.gnW;
            }
            SignAllForumModel.this.gnW = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gnZ.cancel();
            this.gnZ = null;
            SignAllForumModel.this.gnV = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gnV = null;
            if (SignAllForumModel.this.gnX != null) {
                if (SignAllForumModel.this.gnW != null) {
                    SignAllForumModel.this.gnX.b(SignAllForumModel.this.gnW);
                } else {
                    SignAllForumModel.this.gnX.nv(this.gnZ != null ? this.gnZ.pW() : null);
                }
            }
        }
    }
}
