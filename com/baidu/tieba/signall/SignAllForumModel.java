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
    private b jYi;
    private h jYj;
    private a jYk;
    private c jYl;
    private String mAuthSid;

    /* loaded from: classes9.dex */
    public interface a {
        void CK(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.jYi = null;
        this.jYj = null;
        this.jYk = null;
        this.jYj = new h();
    }

    public void a(a aVar) {
        this.jYk = aVar;
    }

    public void d(c cVar) {
        this.jYl = cVar;
    }

    public c cHw() {
        return this.jYl;
    }

    private String cHx() {
        ArrayList<d> cGS = this.jYl.cGS();
        if (cGS == null) {
            return "";
        }
        if (!this.jYl.cGT()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cGS.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cHc() < this.jYl.getLevel()) {
                    arrayList.add(next);
                }
            }
            cGS.removeAll(arrayList);
        }
        int size = cGS.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cGS.get(i);
            if (dVar.cHf()) {
                if (!dVar.cHg()) {
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
        if (this.jYi != null) {
            return false;
        }
        String str = null;
        this.jYi = new b();
        boolean cGI = this.jYl.cGI();
        if (!cGI) {
            str = cHx();
        }
        this.jYi.sz(cGI);
        this.jYi.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jYi != null) {
            this.jYi.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e jYm = null;
        private boolean jYn = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void sz(boolean z) {
            this.jYn = z;
        }

        public boolean cHy() {
            return this.jYn;
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
            if (!cHy() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cHy()) {
                this.jYm = new e();
                this.jYm.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cHz();
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
                    this.jYm = new e();
                    this.jYm.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Iw(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.jYj;
        }

        private h cHz() {
            String cHk = this.jYm.cHk();
            if (this.jYm.isRequestSuccess()) {
                SignAllForumModel.this.jYj.parserJson(cHk);
                return SignAllForumModel.this.jYj;
            }
            SignAllForumModel.this.jYj = null;
            this.tokenData = AuthTokenData.parse(cHk);
            return null;
        }

        private h Iw(String str) {
            String It = this.jYm.It(str);
            if (this.jYm.isRequestSuccess()) {
                SignAllForumModel.this.jYj.parserJson(It);
                return SignAllForumModel.this.jYj;
            }
            SignAllForumModel.this.jYj = null;
            this.tokenData = AuthTokenData.parse(It);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.jYm.cancel();
            this.jYm = null;
            SignAllForumModel.this.jYi = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.jYi = null;
            if (SignAllForumModel.this.jYk != null) {
                if (SignAllForumModel.this.jYj != null) {
                    SignAllForumModel.this.jYk.b(SignAllForumModel.this.jYj);
                } else {
                    SignAllForumModel.this.jYk.CK(this.jYm != null ? this.jYm.axw() : null);
                }
            }
        }
    }
}
