package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b iRp;
    private h iRq;
    private a iRr;
    private c iRs;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes6.dex */
    public interface a {
        void b(h hVar);

        void ym(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.iRp = null;
        this.iRq = null;
        this.iRr = null;
        this.iRq = new h();
    }

    public void a(a aVar) {
        this.iRr = aVar;
    }

    public void d(c cVar) {
        this.iRs = cVar;
    }

    public c ckx() {
        return this.iRs;
    }

    private String cky() {
        ArrayList<d> cjT = this.iRs.cjT();
        if (cjT == null) {
            return "";
        }
        if (!this.iRs.cjU()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cjT.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.ckd() < this.iRs.getLevel()) {
                    arrayList.add(next);
                }
            }
            cjT.removeAll(arrayList);
        }
        int size = cjT.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cjT.get(i);
            if (dVar.ckg()) {
                if (!dVar.ckh()) {
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
        if (this.iRp != null) {
            return false;
        }
        String str = null;
        this.iRp = new b();
        boolean cjJ = this.iRs.cjJ();
        if (!cjJ) {
            str = cky();
        }
        this.iRp.qC(cjJ);
        this.iRp.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iRp != null) {
            this.iRp.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e iRt = null;
        private boolean iRu = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void qC(boolean z) {
            this.iRu = z;
        }

        public boolean ckz() {
            return this.iRu;
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
            if (!ckz() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (ckz()) {
                this.iRt = new e();
                this.iRt.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.jS()) {
                    ckA();
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
                    this.iRt = new e();
                    this.iRt.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.jS()) {
                        DE(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.iRq;
        }

        private h ckA() {
            String ckl = this.iRt.ckl();
            if (this.iRt.isRequestSuccess()) {
                SignAllForumModel.this.iRq.parserJson(ckl);
                return SignAllForumModel.this.iRq;
            }
            SignAllForumModel.this.iRq = null;
            this.tokenData = AuthTokenData.parse(ckl);
            return null;
        }

        private h DE(String str) {
            String DB = this.iRt.DB(str);
            if (this.iRt.isRequestSuccess()) {
                SignAllForumModel.this.iRq.parserJson(DB);
                return SignAllForumModel.this.iRq;
            }
            SignAllForumModel.this.iRq = null;
            this.tokenData = AuthTokenData.parse(DB);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.iRt.cancel();
            this.iRt = null;
            SignAllForumModel.this.iRp = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.iRp = null;
            if (SignAllForumModel.this.iRr != null) {
                if (SignAllForumModel.this.iRq != null) {
                    SignAllForumModel.this.iRr.b(SignAllForumModel.this.iRq);
                } else {
                    SignAllForumModel.this.iRr.ym(this.iRt != null ? this.iRt.aaZ() : null);
                }
            }
        }
    }
}
