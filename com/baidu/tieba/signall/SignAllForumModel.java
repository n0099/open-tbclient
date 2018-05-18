package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gpb;
    private h gpc;
    private a gpd;
    private c gpe;
    public boolean isRunning;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void ny(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gpb = null;
        this.gpc = null;
        this.gpd = null;
        this.gpc = new h();
    }

    public void a(a aVar) {
        this.gpd = aVar;
    }

    public void d(c cVar) {
        this.gpe = cVar;
    }

    public c boQ() {
        return this.gpe;
    }

    private String boR() {
        ArrayList<d> bon = this.gpe.bon();
        if (bon == null) {
            return "";
        }
        if (!this.gpe.boo()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = bon.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.box() < this.gpe.getLevel()) {
                    arrayList.add(next);
                }
            }
            bon.removeAll(arrayList);
        }
        int size = bon.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = bon.get(i);
            if (dVar.boA()) {
                if (!dVar.boB()) {
                    dVar.md(true);
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
        if (this.gpb != null) {
            return false;
        }
        String str = null;
        this.gpb = new b();
        boolean bod = this.gpe.bod();
        if (!bod) {
            str = boR();
        }
        this.gpb.mf(bod);
        this.gpb.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gpb != null) {
            this.gpb.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gpf = null;
        private boolean gpg = false;

        public b() {
            setPriority(3);
        }

        public void mf(boolean z) {
            this.gpg = z;
        }

        public boolean boS() {
            return this.gpg;
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
            if (!boS() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (boS()) {
                this.gpf = new e();
                if (com.baidu.adp.lib.util.j.gP()) {
                    boT();
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
                    this.gpf = new e();
                    if (com.baidu.adp.lib.util.j.gP()) {
                        sE(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gpc;
        }

        private h boT() {
            String boF = this.gpf.boF();
            if (this.gpf.isRequestSuccess()) {
                SignAllForumModel.this.gpc.parserJson(boF);
                return SignAllForumModel.this.gpc;
            }
            SignAllForumModel.this.gpc = null;
            return null;
        }

        private h sE(String str) {
            String sB = this.gpf.sB(str);
            if (this.gpf.isRequestSuccess()) {
                SignAllForumModel.this.gpc.parserJson(sB);
                return SignAllForumModel.this.gpc;
            }
            SignAllForumModel.this.gpc = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gpf.cancel();
            this.gpf = null;
            SignAllForumModel.this.gpb = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gpb = null;
            if (SignAllForumModel.this.gpd != null) {
                if (SignAllForumModel.this.gpc != null) {
                    SignAllForumModel.this.gpd.b(SignAllForumModel.this.gpc);
                } else {
                    SignAllForumModel.this.gpd.ny(this.gpf != null ? this.gpf.pV() : null);
                }
            }
        }
    }
}
