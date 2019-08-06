package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b iYO;
    private h iYP;
    private a iYQ;
    private c iYR;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes6.dex */
    public interface a {
        void b(h hVar);

        void za(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.iYO = null;
        this.iYP = null;
        this.iYQ = null;
        this.iYP = new h();
    }

    public void a(a aVar) {
        this.iYQ = aVar;
    }

    public void d(c cVar) {
        this.iYR = cVar;
    }

    public c cnH() {
        return this.iYR;
    }

    private String cnI() {
        ArrayList<d> cnd = this.iYR.cnd();
        if (cnd == null) {
            return "";
        }
        if (!this.iYR.cne()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cnd.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cnn() < this.iYR.getLevel()) {
                    arrayList.add(next);
                }
            }
            cnd.removeAll(arrayList);
        }
        int size = cnd.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cnd.get(i);
            if (dVar.cnq()) {
                if (!dVar.cnr()) {
                    dVar.qR(true);
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
        if (this.iYO != null) {
            return false;
        }
        String str = null;
        this.iYO = new b();
        boolean cmT = this.iYR.cmT();
        if (!cmT) {
            str = cnI();
        }
        this.iYO.qT(cmT);
        this.iYO.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iYO != null) {
            this.iYO.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e iYS = null;
        private boolean iYT = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void qT(boolean z) {
            this.iYT = z;
        }

        public boolean cnJ() {
            return this.iYT;
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
            if (!cnJ() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cnJ()) {
                this.iYS = new e();
                this.iYS.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kc()) {
                    cnK();
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
                    this.iYS = new e();
                    this.iYS.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kc()) {
                        Eu(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.iYP;
        }

        private h cnK() {
            String cnv = this.iYS.cnv();
            if (this.iYS.isRequestSuccess()) {
                SignAllForumModel.this.iYP.parserJson(cnv);
                return SignAllForumModel.this.iYP;
            }
            SignAllForumModel.this.iYP = null;
            this.tokenData = AuthTokenData.parse(cnv);
            return null;
        }

        private h Eu(String str) {
            String Er = this.iYS.Er(str);
            if (this.iYS.isRequestSuccess()) {
                SignAllForumModel.this.iYP.parserJson(Er);
                return SignAllForumModel.this.iYP;
            }
            SignAllForumModel.this.iYP = null;
            this.tokenData = AuthTokenData.parse(Er);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.iYS.cancel();
            this.iYS = null;
            SignAllForumModel.this.iYO = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.iYO = null;
            if (SignAllForumModel.this.iYQ != null) {
                if (SignAllForumModel.this.iYP != null) {
                    SignAllForumModel.this.iYQ.b(SignAllForumModel.this.iYP);
                } else {
                    SignAllForumModel.this.iYQ.za(this.iYS != null ? this.iYS.abY() : null);
                }
            }
        }
    }
}
