package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private b kKs;
    private h kKt;
    private a kKu;
    private c kKv;
    private String mAuthSid;

    /* loaded from: classes11.dex */
    public interface a {
        void EJ(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.kKs = null;
        this.kKt = null;
        this.kKu = null;
        this.kKt = new h();
    }

    public void a(a aVar) {
        this.kKu = aVar;
    }

    public void d(c cVar) {
        this.kKv = cVar;
    }

    public c cUd() {
        return this.kKv;
    }

    private String cUe() {
        ArrayList<d> cTy = this.kKv.cTy();
        if (cTy == null) {
            return "";
        }
        if (!this.kKv.cTz()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cTy.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cTI() < this.kKv.getLevel()) {
                    arrayList.add(next);
                }
            }
            cTy.removeAll(arrayList);
        }
        int size = cTy.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cTy.get(i);
            if (dVar.cTL()) {
                if (!dVar.cTM()) {
                    dVar.tI(true);
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
        if (this.kKs != null) {
            return false;
        }
        String str = null;
        this.kKs = new b();
        boolean cTo = this.kKv.cTo();
        if (!cTo) {
            str = cUe();
        }
        this.kKs.tK(cTo);
        this.kKs.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kKs != null) {
            this.kKs.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e kKw = null;
        private boolean kKx = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void tK(boolean z) {
            this.kKx = z;
        }

        public boolean cUf() {
            return this.kKx;
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
        /* renamed from: P */
        public h doInBackground(String... strArr) {
            if (!cUf() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cUf()) {
                this.kKw = new e();
                this.kKw.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cUg();
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
                    this.kKw = new e();
                    this.kKw.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Ko(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.kKt;
        }

        private h cUg() {
            String cTR = this.kKw.cTR();
            if (this.kKw.isRequestSuccess()) {
                SignAllForumModel.this.kKt.parserJson(cTR);
                return SignAllForumModel.this.kKt;
            }
            SignAllForumModel.this.kKt = null;
            this.tokenData = AuthTokenData.parse(cTR);
            return null;
        }

        private h Ko(String str) {
            String Kl = this.kKw.Kl(str);
            if (this.kKw.isRequestSuccess()) {
                SignAllForumModel.this.kKt.parserJson(Kl);
                return SignAllForumModel.this.kKt;
            }
            SignAllForumModel.this.kKt = null;
            this.tokenData = AuthTokenData.parse(Kl);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.kKw.cancel();
            this.kKw = null;
            SignAllForumModel.this.kKs = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.kKs = null;
            if (SignAllForumModel.this.kKu != null) {
                if (SignAllForumModel.this.kKt != null) {
                    SignAllForumModel.this.kKu.b(SignAllForumModel.this.kKt);
                } else {
                    SignAllForumModel.this.kKu.EJ(this.kKw != null ? this.kKw.aIc() : null);
                }
            }
        }
    }
}
