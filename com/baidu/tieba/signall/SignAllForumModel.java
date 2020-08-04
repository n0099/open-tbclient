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
    private b lFl;
    private h lFm;
    private a lFn;
    private c lFo;
    private String mAuthSid;

    /* loaded from: classes18.dex */
    public interface a {
        void HM(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.lFl = null;
        this.lFm = null;
        this.lFn = null;
        this.lFm = new h();
    }

    public void a(a aVar) {
        this.lFn = aVar;
    }

    public void d(c cVar) {
        this.lFo = cVar;
    }

    public c diU() {
        return this.lFo;
    }

    private String diV() {
        ArrayList<d> diq = this.lFo.diq();
        if (diq == null) {
            return "";
        }
        if (!this.lFo.dir()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = diq.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.diA() < this.lFo.getLevel()) {
                    arrayList.add(next);
                }
            }
            diq.removeAll(arrayList);
        }
        int size = diq.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = diq.get(i);
            if (dVar.diD()) {
                if (!dVar.diE()) {
                    dVar.uZ(true);
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
        if (this.lFl != null) {
            return false;
        }
        String str = null;
        this.lFl = new b();
        boolean dig = this.lFo.dig();
        if (!dig) {
            str = diV();
        }
        this.lFl.vb(dig);
        this.lFl.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lFl != null) {
            this.lFl.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes18.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e lFp = null;
        private boolean lFq = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void vb(boolean z) {
            this.lFq = z;
        }

        public boolean diW() {
            return this.lFq;
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
            if (!diW() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (diW()) {
                this.lFp = new e();
                this.lFp.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    diX();
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
                    this.lFp = new e();
                    this.lFp.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        No(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.lFm;
        }

        private h diX() {
            String diI = this.lFp.diI();
            if (this.lFp.isRequestSuccess()) {
                SignAllForumModel.this.lFm.parserJson(diI);
                return SignAllForumModel.this.lFm;
            }
            SignAllForumModel.this.lFm = null;
            this.tokenData = AuthTokenData.parse(diI);
            return null;
        }

        private h No(String str) {
            String Nl = this.lFp.Nl(str);
            if (this.lFp.isRequestSuccess()) {
                SignAllForumModel.this.lFm.parserJson(Nl);
                return SignAllForumModel.this.lFm;
            }
            SignAllForumModel.this.lFm = null;
            this.tokenData = AuthTokenData.parse(Nl);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.lFp.cancel();
            this.lFp = null;
            SignAllForumModel.this.lFl = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.lFl = null;
            if (SignAllForumModel.this.lFn != null) {
                if (SignAllForumModel.this.lFm != null) {
                    SignAllForumModel.this.lFn.b(SignAllForumModel.this.lFm);
                } else {
                    SignAllForumModel.this.lFn.HM(this.lFp != null ? this.lFp.aTt() : null);
                }
            }
        }
    }
}
