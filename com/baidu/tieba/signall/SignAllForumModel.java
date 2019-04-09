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
    private b iyA;
    private h iyB;
    private a iyC;
    private c iyD;
    private String mAuthSid;

    /* loaded from: classes6.dex */
    public interface a {
        void b(h hVar);

        void wX(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.iyA = null;
        this.iyB = null;
        this.iyC = null;
        this.iyB = new h();
    }

    public void a(a aVar) {
        this.iyC = aVar;
    }

    public void d(c cVar) {
        this.iyD = cVar;
    }

    public c ccq() {
        return this.iyD;
    }

    private String ccr() {
        ArrayList<d> cbM = this.iyD.cbM();
        if (cbM == null) {
            return "";
        }
        if (!this.iyD.cbN()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cbM.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cbW() < this.iyD.getLevel()) {
                    arrayList.add(next);
                }
            }
            cbM.removeAll(arrayList);
        }
        int size = cbM.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cbM.get(i);
            if (dVar.cbZ()) {
                if (!dVar.cca()) {
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
        if (this.iyA != null) {
            return false;
        }
        String str = null;
        this.iyA = new b();
        boolean cbC = this.iyD.cbC();
        if (!cbC) {
            str = ccr();
        }
        this.iyA.pN(cbC);
        this.iyA.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iyA != null) {
            this.iyA.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e iyE = null;
        private boolean iyF = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void pN(boolean z) {
            this.iyF = z;
        }

        public boolean ccs() {
            return this.iyF;
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
            if (!ccs() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (ccs()) {
                this.iyE = new e();
                this.iyE.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kY()) {
                    cct();
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
                    this.iyE = new e();
                    this.iyE.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kY()) {
                        Ci(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.iyB;
        }

        private h cct() {
            String cce = this.iyE.cce();
            if (this.iyE.isRequestSuccess()) {
                SignAllForumModel.this.iyB.parserJson(cce);
                return SignAllForumModel.this.iyB;
            }
            SignAllForumModel.this.iyB = null;
            this.tokenData = AuthTokenData.parse(cce);
            return null;
        }

        private h Ci(String str) {
            String Cf = this.iyE.Cf(str);
            if (this.iyE.isRequestSuccess()) {
                SignAllForumModel.this.iyB.parserJson(Cf);
                return SignAllForumModel.this.iyB;
            }
            SignAllForumModel.this.iyB = null;
            this.tokenData = AuthTokenData.parse(Cf);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.iyE.cancel();
            this.iyE = null;
            SignAllForumModel.this.iyA = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.iyA = null;
            if (SignAllForumModel.this.iyC != null) {
                if (SignAllForumModel.this.iyB != null) {
                    SignAllForumModel.this.iyC.b(SignAllForumModel.this.iyB);
                } else {
                    SignAllForumModel.this.iyC.wX(this.iyE != null ? this.iyE.Wt() : null);
                }
            }
        }
    }
}
