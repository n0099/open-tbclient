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
    private b jbj;
    private h jbk;
    private a jbl;
    private c jbm;
    private String mAuthSid;

    /* loaded from: classes6.dex */
    public interface a {
        void b(h hVar);

        void zz(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.jbj = null;
        this.jbk = null;
        this.jbl = null;
        this.jbk = new h();
    }

    public void a(a aVar) {
        this.jbl = aVar;
    }

    public void d(c cVar) {
        this.jbm = cVar;
    }

    public c cou() {
        return this.jbm;
    }

    private String cov() {
        ArrayList<d> cnQ = this.jbm.cnQ();
        if (cnQ == null) {
            return "";
        }
        if (!this.jbm.cnR()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cnQ.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.coa() < this.jbm.getLevel()) {
                    arrayList.add(next);
                }
            }
            cnQ.removeAll(arrayList);
        }
        int size = cnQ.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cnQ.get(i);
            if (dVar.cod()) {
                if (!dVar.coe()) {
                    dVar.qU(true);
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
        if (this.jbj != null) {
            return false;
        }
        String str = null;
        this.jbj = new b();
        boolean cnG = this.jbm.cnG();
        if (!cnG) {
            str = cov();
        }
        this.jbj.qW(cnG);
        this.jbj.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jbj != null) {
            this.jbj.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e jbn = null;
        private boolean jbo = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void qW(boolean z) {
            this.jbo = z;
        }

        public boolean cow() {
            return this.jbo;
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
        /* renamed from: E */
        public h doInBackground(String... strArr) {
            if (!cow() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cow()) {
                this.jbn = new e();
                this.jbn.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kc()) {
                    cox();
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
                    this.jbn = new e();
                    this.jbn.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kc()) {
                        EU(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.jbk;
        }

        private h cox() {
            String coi = this.jbn.coi();
            if (this.jbn.isRequestSuccess()) {
                SignAllForumModel.this.jbk.parserJson(coi);
                return SignAllForumModel.this.jbk;
            }
            SignAllForumModel.this.jbk = null;
            this.tokenData = AuthTokenData.parse(coi);
            return null;
        }

        private h EU(String str) {
            String ER = this.jbn.ER(str);
            if (this.jbn.isRequestSuccess()) {
                SignAllForumModel.this.jbk.parserJson(ER);
                return SignAllForumModel.this.jbk;
            }
            SignAllForumModel.this.jbk = null;
            this.tokenData = AuthTokenData.parse(ER);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.jbn.cancel();
            this.jbn = null;
            SignAllForumModel.this.jbj = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.jbj = null;
            if (SignAllForumModel.this.jbl != null) {
                if (SignAllForumModel.this.jbk != null) {
                    SignAllForumModel.this.jbl.b(SignAllForumModel.this.jbk);
                } else {
                    SignAllForumModel.this.jbl.zz(this.jbn != null ? this.jbn.acc() : null);
                }
            }
        }
    }
}
