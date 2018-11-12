package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gWe;
    private h gWf;
    private a gWg;
    private c gWh;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void pz(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gWe = null;
        this.gWf = null;
        this.gWg = null;
        this.gWf = new h();
    }

    public void a(a aVar) {
        this.gWg = aVar;
    }

    public void d(c cVar) {
        this.gWh = cVar;
    }

    public c byl() {
        return this.gWh;
    }

    private String bym() {
        ArrayList<d> bxH = this.gWh.bxH();
        if (bxH == null) {
            return "";
        }
        if (!this.gWh.bxI()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = bxH.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bxR() < this.gWh.getLevel()) {
                    arrayList.add(next);
                }
            }
            bxH.removeAll(arrayList);
        }
        int size = bxH.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = bxH.get(i);
            if (dVar.bxU()) {
                if (!dVar.bxV()) {
                    dVar.nf(true);
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
        if (this.gWe != null) {
            return false;
        }
        String str = null;
        this.gWe = new b();
        boolean bxx = this.gWh.bxx();
        if (!bxx) {
            str = bym();
        }
        this.gWe.nh(bxx);
        this.gWe.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gWe != null) {
            this.gWe.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gWi = null;
        private boolean gWj = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void nh(boolean z) {
            this.gWj = z;
        }

        public boolean byn() {
            return this.gWj;
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
        /* renamed from: G */
        public h doInBackground(String... strArr) {
            if (!byn() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (byn()) {
                this.gWi = new e();
                this.gWi.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kV()) {
                    byo();
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
                    this.gWi = new e();
                    this.gWi.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        uJ(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gWf;
        }

        private h byo() {
            String bxZ = this.gWi.bxZ();
            if (this.gWi.isRequestSuccess()) {
                SignAllForumModel.this.gWf.parserJson(bxZ);
                return SignAllForumModel.this.gWf;
            }
            SignAllForumModel.this.gWf = null;
            this.tokenData = AuthTokenData.parse(bxZ);
            return null;
        }

        private h uJ(String str) {
            String uG = this.gWi.uG(str);
            if (this.gWi.isRequestSuccess()) {
                SignAllForumModel.this.gWf.parserJson(uG);
                return SignAllForumModel.this.gWf;
            }
            SignAllForumModel.this.gWf = null;
            this.tokenData = AuthTokenData.parse(uG);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gWi.cancel();
            this.gWi = null;
            SignAllForumModel.this.gWe = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gWe = null;
            if (SignAllForumModel.this.gWg != null) {
                if (SignAllForumModel.this.gWf != null) {
                    SignAllForumModel.this.gWg.b(SignAllForumModel.this.gWf);
                } else {
                    SignAllForumModel.this.gWg.pz(this.gWi != null ? this.gWi.wy() : null);
                }
            }
        }
    }
}
