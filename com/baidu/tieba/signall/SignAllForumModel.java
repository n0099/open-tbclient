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
    private b lcM;
    private h lcN;
    private a lcO;
    private c lcP;
    private String mAuthSid;

    /* loaded from: classes11.dex */
    public interface a {
        void Gv(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.lcM = null;
        this.lcN = null;
        this.lcO = null;
        this.lcN = new h();
    }

    public void a(a aVar) {
        this.lcO = aVar;
    }

    public void d(c cVar) {
        this.lcP = cVar;
    }

    public c dbf() {
        return this.lcP;
    }

    private String dbg() {
        ArrayList<d> daA = this.lcP.daA();
        if (daA == null) {
            return "";
        }
        if (!this.lcP.daB()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = daA.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.daK() < this.lcP.getLevel()) {
                    arrayList.add(next);
                }
            }
            daA.removeAll(arrayList);
        }
        int size = daA.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = daA.get(i);
            if (dVar.daN()) {
                if (!dVar.daO()) {
                    dVar.ug(true);
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
        if (this.lcM != null) {
            return false;
        }
        String str = null;
        this.lcM = new b();
        boolean daq = this.lcP.daq();
        if (!daq) {
            str = dbg();
        }
        this.lcM.ui(daq);
        this.lcM.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lcM != null) {
            this.lcM.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e lcQ = null;
        private boolean lcR = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void ui(boolean z) {
            this.lcR = z;
        }

        public boolean dbh() {
            return this.lcR;
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
        /* renamed from: S */
        public h doInBackground(String... strArr) {
            if (!dbh() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dbh()) {
                this.lcQ = new e();
                this.lcQ.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dbi();
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
                    this.lcQ = new e();
                    this.lcQ.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Md(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.lcN;
        }

        private h dbi() {
            String daT = this.lcQ.daT();
            if (this.lcQ.isRequestSuccess()) {
                SignAllForumModel.this.lcN.parserJson(daT);
                return SignAllForumModel.this.lcN;
            }
            SignAllForumModel.this.lcN = null;
            this.tokenData = AuthTokenData.parse(daT);
            return null;
        }

        private h Md(String str) {
            String Ma = this.lcQ.Ma(str);
            if (this.lcQ.isRequestSuccess()) {
                SignAllForumModel.this.lcN.parserJson(Ma);
                return SignAllForumModel.this.lcN;
            }
            SignAllForumModel.this.lcN = null;
            this.tokenData = AuthTokenData.parse(Ma);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.lcQ.cancel();
            this.lcQ = null;
            SignAllForumModel.this.lcM = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.lcM = null;
            if (SignAllForumModel.this.lcO != null) {
                if (SignAllForumModel.this.lcN != null) {
                    SignAllForumModel.this.lcO.b(SignAllForumModel.this.lcN);
                } else {
                    SignAllForumModel.this.lcO.Gv(this.lcQ != null ? this.lcQ.aNO() : null);
                }
            }
        }
    }
}
