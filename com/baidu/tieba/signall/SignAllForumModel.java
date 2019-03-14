package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private b iyP;
    private h iyQ;
    private a iyR;
    private c iyS;
    private String mAuthSid;

    /* loaded from: classes6.dex */
    public interface a {
        void b(h hVar);

        void wY(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.iyP = null;
        this.iyQ = null;
        this.iyR = null;
        this.iyQ = new h();
    }

    public void a(a aVar) {
        this.iyR = aVar;
    }

    public void d(c cVar) {
        this.iyS = cVar;
    }

    public c ccu() {
        return this.iyS;
    }

    private String ccv() {
        ArrayList<d> cbQ = this.iyS.cbQ();
        if (cbQ == null) {
            return "";
        }
        if (!this.iyS.cbR()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cbQ.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cca() < this.iyS.getLevel()) {
                    arrayList.add(next);
                }
            }
            cbQ.removeAll(arrayList);
        }
        int size = cbQ.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cbQ.get(i);
            if (dVar.ccd()) {
                if (!dVar.cce()) {
                    dVar.pL(true);
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
        if (this.iyP != null) {
            return false;
        }
        String str = null;
        this.iyP = new b();
        boolean cbG = this.iyS.cbG();
        if (!cbG) {
            str = ccv();
        }
        this.iyP.pN(cbG);
        this.iyP.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iyP != null) {
            this.iyP.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e iyT = null;
        private boolean iyU = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void pN(boolean z) {
            this.iyU = z;
        }

        public boolean ccw() {
            return this.iyU;
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
        /* renamed from: F */
        public h doInBackground(String... strArr) {
            if (!ccw() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (ccw()) {
                this.iyT = new e();
                this.iyT.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kY()) {
                    ccx();
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
                    this.iyT = new e();
                    this.iyT.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kY()) {
                        Cj(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.iyQ;
        }

        private h ccx() {
            String cci = this.iyT.cci();
            if (this.iyT.isRequestSuccess()) {
                SignAllForumModel.this.iyQ.parserJson(cci);
                return SignAllForumModel.this.iyQ;
            }
            SignAllForumModel.this.iyQ = null;
            this.tokenData = AuthTokenData.parse(cci);
            return null;
        }

        private h Cj(String str) {
            String Cg = this.iyT.Cg(str);
            if (this.iyT.isRequestSuccess()) {
                SignAllForumModel.this.iyQ.parserJson(Cg);
                return SignAllForumModel.this.iyQ;
            }
            SignAllForumModel.this.iyQ = null;
            this.tokenData = AuthTokenData.parse(Cg);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.iyT.cancel();
            this.iyT = null;
            SignAllForumModel.this.iyP = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.iyP = null;
            if (SignAllForumModel.this.iyR != null) {
                if (SignAllForumModel.this.iyQ != null) {
                    SignAllForumModel.this.iyR.b(SignAllForumModel.this.iyQ);
                } else {
                    SignAllForumModel.this.iyR.wY(this.iyT != null ? this.iyT.Ww() : null);
                }
            }
        }
    }
}
