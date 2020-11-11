package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes24.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private String mAuthSid;
    private b mOO;
    private h mOP;
    private a mOQ;
    private c mOR;

    /* loaded from: classes24.dex */
    public interface a {
        void ML(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mOO = null;
        this.mOP = null;
        this.mOQ = null;
        this.mOP = new h();
    }

    public void a(a aVar) {
        this.mOQ = aVar;
    }

    public void d(c cVar) {
        this.mOR = cVar;
    }

    public c dHI() {
        return this.mOR;
    }

    private String dHJ() {
        ArrayList<d> dHe = this.mOR.dHe();
        if (dHe == null) {
            return "";
        }
        if (!this.mOR.dHf()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dHe.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.dHo() < this.mOR.getLevel()) {
                    arrayList.add(next);
                }
            }
            dHe.removeAll(arrayList);
        }
        int size = dHe.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dHe.get(i);
            if (dVar.dHr()) {
                if (!dVar.dHs()) {
                    dVar.xf(true);
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
        if (this.mOO != null) {
            return false;
        }
        String str = null;
        this.mOO = new b();
        boolean dGU = this.mOR.dGU();
        if (!dGU) {
            str = dHJ();
        }
        this.mOO.xh(dGU);
        this.mOO.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mOO != null) {
            this.mOO.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes24.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e mOS = null;
        private boolean mOT = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void xh(boolean z) {
            this.mOT = z;
        }

        public boolean dHK() {
            return this.mOT;
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
        /* renamed from: T */
        public h doInBackground(String... strArr) {
            if (!dHK() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dHK()) {
                this.mOS = new e();
                this.mOS.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dHL();
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
                    this.mOS = new e();
                    this.mOS.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Sq(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.mOP;
        }

        private h dHL() {
            String dHw = this.mOS.dHw();
            if (this.mOS.isRequestSuccess()) {
                SignAllForumModel.this.mOP.parserJson(dHw);
                return SignAllForumModel.this.mOP;
            }
            SignAllForumModel.this.mOP = null;
            this.tokenData = AuthTokenData.parse(dHw);
            return null;
        }

        private h Sq(String str) {
            String Sn = this.mOS.Sn(str);
            if (this.mOS.isRequestSuccess()) {
                SignAllForumModel.this.mOP.parserJson(Sn);
                return SignAllForumModel.this.mOP;
            }
            SignAllForumModel.this.mOP = null;
            this.tokenData = AuthTokenData.parse(Sn);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.mOS.cancel();
            this.mOS = null;
            SignAllForumModel.this.mOO = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.mOO = null;
            if (SignAllForumModel.this.mOQ != null) {
                if (SignAllForumModel.this.mOP != null) {
                    SignAllForumModel.this.mOQ.b(SignAllForumModel.this.mOP);
                } else {
                    SignAllForumModel.this.mOQ.ML(this.mOS != null ? this.mOS.bjF() : null);
                }
            }
        }
    }
}
