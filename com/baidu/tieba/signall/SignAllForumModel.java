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
    private b ndN;
    private h ndO;
    private a ndP;
    private c ndQ;

    /* loaded from: classes24.dex */
    public interface a {
        void Nu(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.ndN = null;
        this.ndO = null;
        this.ndP = null;
        this.ndO = new h();
    }

    public void a(a aVar) {
        this.ndP = aVar;
    }

    public void d(c cVar) {
        this.ndQ = cVar;
    }

    public c dMP() {
        return this.ndQ;
    }

    private String dMQ() {
        ArrayList<d> dMm = this.ndQ.dMm();
        if (dMm == null) {
            return "";
        }
        if (!this.ndQ.dMn()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dMm.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bLB() < this.ndQ.getLevel()) {
                    arrayList.add(next);
                }
            }
            dMm.removeAll(arrayList);
        }
        int size = dMm.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dMm.get(i);
            if (dVar.dMy()) {
                if (!dVar.dMz()) {
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
        if (this.ndN != null) {
            return false;
        }
        String str = null;
        this.ndN = new b();
        boolean dMc = this.ndQ.dMc();
        if (!dMc) {
            str = dMQ();
        }
        this.ndN.xP(dMc);
        this.ndN.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ndN != null) {
            this.ndN.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes24.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e ndR = null;
        private boolean ndS = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void xP(boolean z) {
            this.ndS = z;
        }

        public boolean dMR() {
            return this.ndS;
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
            if (!dMR() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dMR()) {
                this.ndR = new e();
                this.ndR.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dMS();
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
                    this.ndR = new e();
                    this.ndR.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Tf(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.ndO;
        }

        private h dMS() {
            String dMD = this.ndR.dMD();
            if (this.ndR.isRequestSuccess()) {
                SignAllForumModel.this.ndO.parserJson(dMD);
                return SignAllForumModel.this.ndO;
            }
            SignAllForumModel.this.ndO = null;
            this.tokenData = AuthTokenData.parse(dMD);
            return null;
        }

        private h Tf(String str) {
            String Tc = this.ndR.Tc(str);
            if (this.ndR.isRequestSuccess()) {
                SignAllForumModel.this.ndO.parserJson(Tc);
                return SignAllForumModel.this.ndO;
            }
            SignAllForumModel.this.ndO = null;
            this.tokenData = AuthTokenData.parse(Tc);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.ndR.cancel();
            this.ndR = null;
            SignAllForumModel.this.ndN = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.ndN = null;
            if (SignAllForumModel.this.ndP != null) {
                if (SignAllForumModel.this.ndO != null) {
                    SignAllForumModel.this.ndP.b(SignAllForumModel.this.ndO);
                } else {
                    SignAllForumModel.this.ndP.Nu(this.ndR != null ? this.ndR.blT() : null);
                }
            }
        }
    }
}
