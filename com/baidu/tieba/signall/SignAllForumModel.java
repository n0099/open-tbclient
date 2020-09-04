package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes18.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private b lXf;
    private h lXg;
    private a lXh;
    private c lXi;
    private String mAuthSid;

    /* loaded from: classes18.dex */
    public interface a {
        void KF(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.lXf = null;
        this.lXg = null;
        this.lXh = null;
        this.lXg = new h();
    }

    public void a(a aVar) {
        this.lXh = aVar;
    }

    public void d(c cVar) {
        this.lXi = cVar;
    }

    public c duu() {
        return this.lXi;
    }

    private String duv() {
        ArrayList<d> dtQ = this.lXi.dtQ();
        if (dtQ == null) {
            return "";
        }
        if (!this.lXi.dtR()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dtQ.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.dua() < this.lXi.getLevel()) {
                    arrayList.add(next);
                }
            }
            dtQ.removeAll(arrayList);
        }
        int size = dtQ.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dtQ.get(i);
            if (dVar.dud()) {
                if (!dVar.due()) {
                    dVar.vQ(true);
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
        if (this.lXf != null) {
            return false;
        }
        String str = null;
        this.lXf = new b();
        boolean dtG = this.lXi.dtG();
        if (!dtG) {
            str = duv();
        }
        this.lXf.vS(dtG);
        this.lXf.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lXf != null) {
            this.lXf.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes18.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e lXj = null;
        private boolean lXk = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void vS(boolean z) {
            this.lXk = z;
        }

        public boolean duw() {
            return this.lXk;
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
            if (!duw() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (duw()) {
                this.lXj = new e();
                this.lXj.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dux();
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
                    this.lXj = new e();
                    this.lXj.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Qm(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.lXg;
        }

        private h dux() {
            String dui = this.lXj.dui();
            if (this.lXj.isRequestSuccess()) {
                SignAllForumModel.this.lXg.parserJson(dui);
                return SignAllForumModel.this.lXg;
            }
            SignAllForumModel.this.lXg = null;
            this.tokenData = AuthTokenData.parse(dui);
            return null;
        }

        private h Qm(String str) {
            String Qj = this.lXj.Qj(str);
            if (this.lXj.isRequestSuccess()) {
                SignAllForumModel.this.lXg.parserJson(Qj);
                return SignAllForumModel.this.lXg;
            }
            SignAllForumModel.this.lXg = null;
            this.tokenData = AuthTokenData.parse(Qj);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.lXj.cancel();
            this.lXj = null;
            SignAllForumModel.this.lXf = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.lXf = null;
            if (SignAllForumModel.this.lXh != null) {
                if (SignAllForumModel.this.lXg != null) {
                    SignAllForumModel.this.lXh.b(SignAllForumModel.this.lXg);
                } else {
                    SignAllForumModel.this.lXh.KF(this.lXj != null ? this.lXj.bbK() : null);
                }
            }
        }
    }
}
