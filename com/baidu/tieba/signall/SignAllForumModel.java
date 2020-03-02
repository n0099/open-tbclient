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
    private b jZo;
    private h jZp;
    private a jZq;
    private c jZr;
    private String mAuthSid;

    /* loaded from: classes11.dex */
    public interface a {
        void Da(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.jZo = null;
        this.jZp = null;
        this.jZq = null;
        this.jZp = new h();
    }

    public void a(a aVar) {
        this.jZq = aVar;
    }

    public void d(c cVar) {
        this.jZr = cVar;
    }

    public c cJe() {
        return this.jZr;
    }

    private String cJf() {
        ArrayList<d> cIA = this.jZr.cIA();
        if (cIA == null) {
            return "";
        }
        if (!this.jZr.cIB()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cIA.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cIK() < this.jZr.getLevel()) {
                    arrayList.add(next);
                }
            }
            cIA.removeAll(arrayList);
        }
        int size = cIA.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cIA.get(i);
            if (dVar.cIN()) {
                if (!dVar.cIO()) {
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
        if (this.jZo != null) {
            return false;
        }
        String str = null;
        this.jZo = new b();
        boolean cIq = this.jZr.cIq();
        if (!cIq) {
            str = cJf();
        }
        this.jZo.sD(cIq);
        this.jZo.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jZo != null) {
            this.jZo.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e jZs = null;
        private boolean jZt = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void sD(boolean z) {
            this.jZt = z;
        }

        public boolean cJg() {
            return this.jZt;
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
            if (!cJg() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cJg()) {
                this.jZs = new e();
                this.jZs.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cJh();
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
                    this.jZs = new e();
                    this.jZs.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        IK(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.jZp;
        }

        private h cJh() {
            String cIS = this.jZs.cIS();
            if (this.jZs.isRequestSuccess()) {
                SignAllForumModel.this.jZp.parserJson(cIS);
                return SignAllForumModel.this.jZp;
            }
            SignAllForumModel.this.jZp = null;
            this.tokenData = AuthTokenData.parse(cIS);
            return null;
        }

        private h IK(String str) {
            String IH = this.jZs.IH(str);
            if (this.jZs.isRequestSuccess()) {
                SignAllForumModel.this.jZp.parserJson(IH);
                return SignAllForumModel.this.jZp;
            }
            SignAllForumModel.this.jZp = null;
            this.tokenData = AuthTokenData.parse(IH);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.jZs.cancel();
            this.jZs = null;
            SignAllForumModel.this.jZo = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.jZo = null;
            if (SignAllForumModel.this.jZq != null) {
                if (SignAllForumModel.this.jZp != null) {
                    SignAllForumModel.this.jZq.b(SignAllForumModel.this.jZp);
                } else {
                    SignAllForumModel.this.jZq.Da(this.jZs != null ? this.jZs.azM() : null);
                }
            }
        }
    }
}
