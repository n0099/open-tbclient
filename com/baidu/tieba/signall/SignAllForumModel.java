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
    private b jZA;
    private h jZB;
    private a jZC;
    private c jZD;
    private String mAuthSid;

    /* loaded from: classes11.dex */
    public interface a {
        void Db(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.jZA = null;
        this.jZB = null;
        this.jZC = null;
        this.jZB = new h();
    }

    public void a(a aVar) {
        this.jZC = aVar;
    }

    public void d(c cVar) {
        this.jZD = cVar;
    }

    public c cJf() {
        return this.jZD;
    }

    private String cJg() {
        ArrayList<d> cIB = this.jZD.cIB();
        if (cIB == null) {
            return "";
        }
        if (!this.jZD.cIC()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cIB.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cIL() < this.jZD.getLevel()) {
                    arrayList.add(next);
                }
            }
            cIB.removeAll(arrayList);
        }
        int size = cIB.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cIB.get(i);
            if (dVar.cIO()) {
                if (!dVar.cIP()) {
                    dVar.sB(true);
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
        if (this.jZA != null) {
            return false;
        }
        String str = null;
        this.jZA = new b();
        boolean cIr = this.jZD.cIr();
        if (!cIr) {
            str = cJg();
        }
        this.jZA.sD(cIr);
        this.jZA.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jZA != null) {
            this.jZA.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e jZE = null;
        private boolean jZF = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void sD(boolean z) {
            this.jZF = z;
        }

        public boolean cJh() {
            return this.jZF;
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
            if (!cJh() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cJh()) {
                this.jZE = new e();
                this.jZE.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cJi();
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
                    this.jZE = new e();
                    this.jZE.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        IL(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.jZB;
        }

        private h cJi() {
            String cIT = this.jZE.cIT();
            if (this.jZE.isRequestSuccess()) {
                SignAllForumModel.this.jZB.parserJson(cIT);
                return SignAllForumModel.this.jZB;
            }
            SignAllForumModel.this.jZB = null;
            this.tokenData = AuthTokenData.parse(cIT);
            return null;
        }

        private h IL(String str) {
            String II = this.jZE.II(str);
            if (this.jZE.isRequestSuccess()) {
                SignAllForumModel.this.jZB.parserJson(II);
                return SignAllForumModel.this.jZB;
            }
            SignAllForumModel.this.jZB = null;
            this.tokenData = AuthTokenData.parse(II);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.jZE.cancel();
            this.jZE = null;
            SignAllForumModel.this.jZA = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.jZA = null;
            if (SignAllForumModel.this.jZC != null) {
                if (SignAllForumModel.this.jZB != null) {
                    SignAllForumModel.this.jZC.b(SignAllForumModel.this.jZB);
                } else {
                    SignAllForumModel.this.jZC.Db(this.jZE != null ? this.jZE.azM() : null);
                }
            }
        }
    }
}
