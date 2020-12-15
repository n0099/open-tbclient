package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes24.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private String mAuthSid;
    private b ndP;
    private h ndQ;
    private a ndR;
    private c ndS;

    /* loaded from: classes24.dex */
    public interface a {
        void Nu(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.ndP = null;
        this.ndQ = null;
        this.ndR = null;
        this.ndQ = new h();
    }

    public void a(a aVar) {
        this.ndR = aVar;
    }

    public void d(c cVar) {
        this.ndS = cVar;
    }

    public c dMQ() {
        return this.ndS;
    }

    private String dMR() {
        ArrayList<d> dMn = this.ndS.dMn();
        if (dMn == null) {
            return "";
        }
        if (!this.ndS.dMo()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dMn.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bLC() < this.ndS.getLevel()) {
                    arrayList.add(next);
                }
            }
            dMn.removeAll(arrayList);
        }
        int size = dMn.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dMn.get(i);
            if (dVar.dMz()) {
                if (!dVar.dMA()) {
                    dVar.xN(true);
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
        if (this.ndP != null) {
            return false;
        }
        String str = null;
        this.ndP = new b();
        boolean dMd = this.ndS.dMd();
        if (!dMd) {
            str = dMR();
        }
        this.ndP.xP(dMd);
        this.ndP.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ndP != null) {
            this.ndP.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes24.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e ndT = null;
        private boolean ndU = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void xP(boolean z) {
            this.ndU = z;
        }

        public boolean dMS() {
            return this.ndU;
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
        /* renamed from: U */
        public h doInBackground(String... strArr) {
            if (!dMS() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dMS()) {
                this.ndT = new e();
                this.ndT.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dMT();
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
                    this.ndT = new e();
                    this.ndT.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Tf(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.ndQ;
        }

        private h dMT() {
            String dME = this.ndT.dME();
            if (this.ndT.isRequestSuccess()) {
                SignAllForumModel.this.ndQ.parserJson(dME);
                return SignAllForumModel.this.ndQ;
            }
            SignAllForumModel.this.ndQ = null;
            this.tokenData = AuthTokenData.parse(dME);
            return null;
        }

        private h Tf(String str) {
            String Tc = this.ndT.Tc(str);
            if (this.ndT.isRequestSuccess()) {
                SignAllForumModel.this.ndQ.parserJson(Tc);
                return SignAllForumModel.this.ndQ;
            }
            SignAllForumModel.this.ndQ = null;
            this.tokenData = AuthTokenData.parse(Tc);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.ndT.cancel();
            this.ndT = null;
            SignAllForumModel.this.ndP = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.ndP = null;
            if (SignAllForumModel.this.ndR != null) {
                if (SignAllForumModel.this.ndQ != null) {
                    SignAllForumModel.this.ndR.b(SignAllForumModel.this.ndQ);
                } else {
                    SignAllForumModel.this.ndR.Nu(this.ndT != null ? this.ndT.blT() : null);
                }
            }
        }
    }
}
