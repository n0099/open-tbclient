package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b hhe;
    private h hhf;
    private a hhg;
    private c hhh;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void qu(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.hhe = null;
        this.hhf = null;
        this.hhg = null;
        this.hhf = new h();
    }

    public void a(a aVar) {
        this.hhg = aVar;
    }

    public void d(c cVar) {
        this.hhh = cVar;
    }

    public c bBD() {
        return this.hhh;
    }

    private String bBE() {
        ArrayList<d> bAZ = this.hhh.bAZ();
        if (bAZ == null) {
            return "";
        }
        if (!this.hhh.bBa()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = bAZ.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bBj() < this.hhh.getLevel()) {
                    arrayList.add(next);
                }
            }
            bAZ.removeAll(arrayList);
        }
        int size = bAZ.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = bAZ.get(i);
            if (dVar.bBm()) {
                if (!dVar.bBn()) {
                    dVar.nl(true);
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
        if (this.hhe != null) {
            return false;
        }
        String str = null;
        this.hhe = new b();
        boolean bAP = this.hhh.bAP();
        if (!bAP) {
            str = bBE();
        }
        this.hhe.nn(bAP);
        this.hhe.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.hhe != null) {
            this.hhe.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e hhi = null;
        private boolean hhj = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void nn(boolean z) {
            this.hhj = z;
        }

        public boolean bBF() {
            return this.hhj;
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
        /* renamed from: H */
        public h doInBackground(String... strArr) {
            if (!bBF() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (bBF()) {
                this.hhi = new e();
                this.hhi.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kV()) {
                    bBG();
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
                    this.hhi = new e();
                    this.hhi.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        vD(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.hhf;
        }

        private h bBG() {
            String bBr = this.hhi.bBr();
            if (this.hhi.isRequestSuccess()) {
                SignAllForumModel.this.hhf.parserJson(bBr);
                return SignAllForumModel.this.hhf;
            }
            SignAllForumModel.this.hhf = null;
            this.tokenData = AuthTokenData.parse(bBr);
            return null;
        }

        private h vD(String str) {
            String vA = this.hhi.vA(str);
            if (this.hhi.isRequestSuccess()) {
                SignAllForumModel.this.hhf.parserJson(vA);
                return SignAllForumModel.this.hhf;
            }
            SignAllForumModel.this.hhf = null;
            this.tokenData = AuthTokenData.parse(vA);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.hhi.cancel();
            this.hhi = null;
            SignAllForumModel.this.hhe = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.hhe = null;
            if (SignAllForumModel.this.hhg != null) {
                if (SignAllForumModel.this.hhf != null) {
                    SignAllForumModel.this.hhg.b(SignAllForumModel.this.hhf);
                } else {
                    SignAllForumModel.this.hhg.qu(this.hhi != null ? this.hhi.xP() : null);
                }
            }
        }
    }
}
