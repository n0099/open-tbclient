package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private String mAuthSid;
    private h noA;
    private a noB;
    private c noC;
    private b noz;

    /* loaded from: classes8.dex */
    public interface a {
        void MU(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.noz = null;
        this.noA = null;
        this.noB = null;
        this.noA = new h();
    }

    public void a(a aVar) {
        this.noB = aVar;
    }

    public void d(c cVar) {
        this.noC = cVar;
    }

    public c dLc() {
        return this.noC;
    }

    private String dLd() {
        ArrayList<d> dKz = this.noC.dKz();
        if (dKz == null) {
            return "";
        }
        if (!this.noC.dKA()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dKz.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bKx() < this.noC.getLevel()) {
                    arrayList.add(next);
                }
            }
            dKz.removeAll(arrayList);
        }
        int size = dKz.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dKz.get(i);
            if (dVar.dKL()) {
                if (!dVar.dKM()) {
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
        if (this.noz != null) {
            return false;
        }
        String str = null;
        this.noz = new b();
        boolean dKp = this.noC.dKp();
        if (!dKp) {
            str = dLd();
        }
        this.noz.yg(dKp);
        this.noz.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.noz != null) {
            this.noz.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e noD = null;
        private boolean noE = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void yg(boolean z) {
            this.noE = z;
        }

        public boolean dLe() {
            return this.noE;
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
            if (!dLe() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dLe()) {
                this.noD = new e();
                this.noD.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dLf();
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
                    this.noD = new e();
                    this.noD.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SD(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.noA;
        }

        private h dLf() {
            String dKQ = this.noD.dKQ();
            if (this.noD.isRequestSuccess()) {
                SignAllForumModel.this.noA.parserJson(dKQ);
                return SignAllForumModel.this.noA;
            }
            SignAllForumModel.this.noA = null;
            this.tokenData = AuthTokenData.parse(dKQ);
            return null;
        }

        private h SD(String str) {
            String SA = this.noD.SA(str);
            if (this.noD.isRequestSuccess()) {
                SignAllForumModel.this.noA.parserJson(SA);
                return SignAllForumModel.this.noA;
            }
            SignAllForumModel.this.noA = null;
            this.tokenData = AuthTokenData.parse(SA);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.noD.cancel();
            this.noD = null;
            SignAllForumModel.this.noz = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.noz = null;
            if (SignAllForumModel.this.noB != null) {
                if (SignAllForumModel.this.noA != null) {
                    SignAllForumModel.this.noB.b(SignAllForumModel.this.noA);
                } else {
                    SignAllForumModel.this.noB.MU(this.noD != null ? this.noD.bkR() : null);
                }
            }
        }
    }
}
