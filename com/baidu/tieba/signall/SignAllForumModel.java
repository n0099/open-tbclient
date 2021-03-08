package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private String mAuthSid;
    private b nrd;
    private h nre;
    private a nrf;
    private c nrg;

    /* loaded from: classes7.dex */
    public interface a {
        void Nb(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.nrd = null;
        this.nre = null;
        this.nrf = null;
        this.nre = new h();
    }

    public void a(a aVar) {
        this.nrf = aVar;
    }

    public void d(c cVar) {
        this.nrg = cVar;
    }

    public c dLs() {
        return this.nrg;
    }

    private String dLt() {
        ArrayList<d> dKP = this.nrg.dKP();
        if (dKP == null) {
            return "";
        }
        if (!this.nrg.dKQ()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dKP.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bKG() < this.nrg.getLevel()) {
                    arrayList.add(next);
                }
            }
            dKP.removeAll(arrayList);
        }
        int size = dKP.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dKP.get(i);
            if (dVar.dLb()) {
                if (!dVar.dLc()) {
                    dVar.ye(true);
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
        if (this.nrd != null) {
            return false;
        }
        String str = null;
        this.nrd = new b();
        boolean dKF = this.nrg.dKF();
        if (!dKF) {
            str = dLt();
        }
        this.nrd.yg(dKF);
        this.nrd.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nrd != null) {
            this.nrd.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes7.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e nrh = null;
        private boolean nri = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void yg(boolean z) {
            this.nri = z;
        }

        public boolean dLu() {
            return this.nri;
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
        /* renamed from: aa */
        public h doInBackground(String... strArr) {
            if (!dLu() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dLu()) {
                this.nrh = new e();
                this.nrh.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dLv();
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
                    this.nrh = new e();
                    this.nrh.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SV(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.nre;
        }

        private h dLv() {
            String dLg = this.nrh.dLg();
            if (this.nrh.isRequestSuccess()) {
                SignAllForumModel.this.nre.parserJson(dLg);
                return SignAllForumModel.this.nre;
            }
            SignAllForumModel.this.nre = null;
            this.tokenData = AuthTokenData.parse(dLg);
            return null;
        }

        private h SV(String str) {
            String SS = this.nrh.SS(str);
            if (this.nrh.isRequestSuccess()) {
                SignAllForumModel.this.nre.parserJson(SS);
                return SignAllForumModel.this.nre;
            }
            SignAllForumModel.this.nre = null;
            this.tokenData = AuthTokenData.parse(SS);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.nrh.cancel();
            this.nrh = null;
            SignAllForumModel.this.nrd = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.nrd = null;
            if (SignAllForumModel.this.nrf != null) {
                if (SignAllForumModel.this.nre != null) {
                    SignAllForumModel.this.nrf.b(SignAllForumModel.this.nre);
                } else {
                    SignAllForumModel.this.nrf.Nb(this.nrh != null ? this.nrh.bkT() : null);
                }
            }
        }
    }
}
