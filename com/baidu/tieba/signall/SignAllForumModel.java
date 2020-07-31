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
    private b lFj;
    private h lFk;
    private a lFl;
    private c lFm;
    private String mAuthSid;

    /* loaded from: classes18.dex */
    public interface a {
        void HM(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.lFj = null;
        this.lFk = null;
        this.lFl = null;
        this.lFk = new h();
    }

    public void a(a aVar) {
        this.lFl = aVar;
    }

    public void d(c cVar) {
        this.lFm = cVar;
    }

    public c diU() {
        return this.lFm;
    }

    private String diV() {
        ArrayList<d> diq = this.lFm.diq();
        if (diq == null) {
            return "";
        }
        if (!this.lFm.dir()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = diq.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.diA() < this.lFm.getLevel()) {
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
        if (this.lFj != null) {
            return false;
        }
        String str = null;
        this.lFj = new b();
        boolean dig = this.lFm.dig();
        if (!dig) {
            str = diV();
        }
        this.lFj.vb(dig);
        this.lFj.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lFj != null) {
            this.lFj.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes18.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e lFn = null;
        private boolean lFo = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void vb(boolean z) {
            this.lFo = z;
        }

        public boolean diW() {
            return this.lFo;
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
                this.lFn = new e();
                this.lFn.setAuthSid(SignAllForumModel.this.mAuthSid);
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
                    this.lFn = new e();
                    this.lFn.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        No(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.lFk;
        }

        private h diX() {
            String diI = this.lFn.diI();
            if (this.lFn.isRequestSuccess()) {
                SignAllForumModel.this.lFk.parserJson(diI);
                return SignAllForumModel.this.lFk;
            }
            SignAllForumModel.this.lFk = null;
            this.tokenData = AuthTokenData.parse(diI);
            return null;
        }

        private h No(String str) {
            String Nl = this.lFn.Nl(str);
            if (this.lFn.isRequestSuccess()) {
                SignAllForumModel.this.lFk.parserJson(Nl);
                return SignAllForumModel.this.lFk;
            }
            SignAllForumModel.this.lFk = null;
            this.tokenData = AuthTokenData.parse(Nl);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.lFn.cancel();
            this.lFn = null;
            SignAllForumModel.this.lFj = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.lFj = null;
            if (SignAllForumModel.this.lFl != null) {
                if (SignAllForumModel.this.lFk != null) {
                    SignAllForumModel.this.lFl.b(SignAllForumModel.this.lFk);
                } else {
                    SignAllForumModel.this.lFl.HM(this.lFn != null ? this.lFn.aTt() : null);
                }
            }
        }
    }
}
