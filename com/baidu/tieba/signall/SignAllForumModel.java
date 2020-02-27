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
    private b jZm;
    private h jZn;
    private a jZo;
    private c jZp;
    private String mAuthSid;

    /* loaded from: classes11.dex */
    public interface a {
        void Da(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.jZm = null;
        this.jZn = null;
        this.jZo = null;
        this.jZn = new h();
    }

    public void a(a aVar) {
        this.jZo = aVar;
    }

    public void d(c cVar) {
        this.jZp = cVar;
    }

    public c cJc() {
        return this.jZp;
    }

    private String cJd() {
        ArrayList<d> cIy = this.jZp.cIy();
        if (cIy == null) {
            return "";
        }
        if (!this.jZp.cIz()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cIy.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cII() < this.jZp.getLevel()) {
                    arrayList.add(next);
                }
            }
            cIy.removeAll(arrayList);
        }
        int size = cIy.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cIy.get(i);
            if (dVar.cIL()) {
                if (!dVar.cIM()) {
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
        if (this.jZm != null) {
            return false;
        }
        String str = null;
        this.jZm = new b();
        boolean cIo = this.jZp.cIo();
        if (!cIo) {
            str = cJd();
        }
        this.jZm.sD(cIo);
        this.jZm.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jZm != null) {
            this.jZm.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e jZq = null;
        private boolean jZr = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void sD(boolean z) {
            this.jZr = z;
        }

        public boolean cJe() {
            return this.jZr;
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
            if (!cJe() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cJe()) {
                this.jZq = new e();
                this.jZq.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cJf();
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
                    this.jZq = new e();
                    this.jZq.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        IK(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.jZn;
        }

        private h cJf() {
            String cIQ = this.jZq.cIQ();
            if (this.jZq.isRequestSuccess()) {
                SignAllForumModel.this.jZn.parserJson(cIQ);
                return SignAllForumModel.this.jZn;
            }
            SignAllForumModel.this.jZn = null;
            this.tokenData = AuthTokenData.parse(cIQ);
            return null;
        }

        private h IK(String str) {
            String IH = this.jZq.IH(str);
            if (this.jZq.isRequestSuccess()) {
                SignAllForumModel.this.jZn.parserJson(IH);
                return SignAllForumModel.this.jZn;
            }
            SignAllForumModel.this.jZn = null;
            this.tokenData = AuthTokenData.parse(IH);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.jZq.cancel();
            this.jZq = null;
            SignAllForumModel.this.jZm = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.jZm = null;
            if (SignAllForumModel.this.jZo != null) {
                if (SignAllForumModel.this.jZn != null) {
                    SignAllForumModel.this.jZo.b(SignAllForumModel.this.jZn);
                } else {
                    SignAllForumModel.this.jZo.Da(this.jZq != null ? this.jZq.azK() : null);
                }
            }
        }
    }
}
