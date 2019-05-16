package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b iRn;
    private h iRo;
    private a iRp;
    private c iRq;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes6.dex */
    public interface a {
        void b(h hVar);

        void ym(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.iRn = null;
        this.iRo = null;
        this.iRp = null;
        this.iRo = new h();
    }

    public void a(a aVar) {
        this.iRp = aVar;
    }

    public void d(c cVar) {
        this.iRq = cVar;
    }

    public c ckv() {
        return this.iRq;
    }

    private String ckw() {
        ArrayList<d> cjR = this.iRq.cjR();
        if (cjR == null) {
            return "";
        }
        if (!this.iRq.cjS()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cjR.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.ckb() < this.iRq.getLevel()) {
                    arrayList.add(next);
                }
            }
            cjR.removeAll(arrayList);
        }
        int size = cjR.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cjR.get(i);
            if (dVar.cke()) {
                if (!dVar.ckf()) {
                    dVar.qA(true);
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
        if (this.iRn != null) {
            return false;
        }
        String str = null;
        this.iRn = new b();
        boolean cjH = this.iRq.cjH();
        if (!cjH) {
            str = ckw();
        }
        this.iRn.qC(cjH);
        this.iRn.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iRn != null) {
            this.iRn.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e iRr = null;
        private boolean iRs = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void qC(boolean z) {
            this.iRs = z;
        }

        public boolean ckx() {
            return this.iRs;
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
            if (!ckx() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (ckx()) {
                this.iRr = new e();
                this.iRr.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.jS()) {
                    cky();
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
                    this.iRr = new e();
                    this.iRr.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.jS()) {
                        DE(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.iRo;
        }

        private h cky() {
            String ckj = this.iRr.ckj();
            if (this.iRr.isRequestSuccess()) {
                SignAllForumModel.this.iRo.parserJson(ckj);
                return SignAllForumModel.this.iRo;
            }
            SignAllForumModel.this.iRo = null;
            this.tokenData = AuthTokenData.parse(ckj);
            return null;
        }

        private h DE(String str) {
            String DB = this.iRr.DB(str);
            if (this.iRr.isRequestSuccess()) {
                SignAllForumModel.this.iRo.parserJson(DB);
                return SignAllForumModel.this.iRo;
            }
            SignAllForumModel.this.iRo = null;
            this.tokenData = AuthTokenData.parse(DB);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.iRr.cancel();
            this.iRr = null;
            SignAllForumModel.this.iRn = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.iRn = null;
            if (SignAllForumModel.this.iRp != null) {
                if (SignAllForumModel.this.iRo != null) {
                    SignAllForumModel.this.iRp.b(SignAllForumModel.this.iRo);
                } else {
                    SignAllForumModel.this.iRp.ym(this.iRr != null ? this.iRr.aaZ() : null);
                }
            }
        }
    }
}
