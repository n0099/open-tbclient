package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private b jYn;
    private h jYo;
    private a jYp;
    private c jYq;
    private String mAuthSid;

    /* loaded from: classes9.dex */
    public interface a {
        void CK(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.jYn = null;
        this.jYo = null;
        this.jYp = null;
        this.jYo = new h();
    }

    public void a(a aVar) {
        this.jYp = aVar;
    }

    public void d(c cVar) {
        this.jYq = cVar;
    }

    public c cHy() {
        return this.jYq;
    }

    private String cHz() {
        ArrayList<d> cGU = this.jYq.cGU();
        if (cGU == null) {
            return "";
        }
        if (!this.jYq.cGV()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cGU.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cHe() < this.jYq.getLevel()) {
                    arrayList.add(next);
                }
            }
            cGU.removeAll(arrayList);
        }
        int size = cGU.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cGU.get(i);
            if (dVar.cHh()) {
                if (!dVar.cHi()) {
                    dVar.sx(true);
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
        if (this.jYn != null) {
            return false;
        }
        String str = null;
        this.jYn = new b();
        boolean cGK = this.jYq.cGK();
        if (!cGK) {
            str = cHz();
        }
        this.jYn.sz(cGK);
        this.jYn.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jYn != null) {
            this.jYn.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e jYr = null;
        private boolean jYs = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void sz(boolean z) {
            this.jYs = z;
        }

        public boolean cHA() {
            return this.jYs;
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
        /* renamed from: O */
        public h doInBackground(String... strArr) {
            if (!cHA() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cHA()) {
                this.jYr = new e();
                this.jYr.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cHB();
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
                    this.jYr = new e();
                    this.jYr.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Iw(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.jYo;
        }

        private h cHB() {
            String cHm = this.jYr.cHm();
            if (this.jYr.isRequestSuccess()) {
                SignAllForumModel.this.jYo.parserJson(cHm);
                return SignAllForumModel.this.jYo;
            }
            SignAllForumModel.this.jYo = null;
            this.tokenData = AuthTokenData.parse(cHm);
            return null;
        }

        private h Iw(String str) {
            String It = this.jYr.It(str);
            if (this.jYr.isRequestSuccess()) {
                SignAllForumModel.this.jYo.parserJson(It);
                return SignAllForumModel.this.jYo;
            }
            SignAllForumModel.this.jYo = null;
            this.tokenData = AuthTokenData.parse(It);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.jYr.cancel();
            this.jYr = null;
            SignAllForumModel.this.jYn = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.jYn = null;
            if (SignAllForumModel.this.jYp != null) {
                if (SignAllForumModel.this.jYo != null) {
                    SignAllForumModel.this.jYp.b(SignAllForumModel.this.jYo);
                } else {
                    SignAllForumModel.this.jYp.CK(this.jYr != null ? this.jYr.axw() : null);
                }
            }
        }
    }
}
