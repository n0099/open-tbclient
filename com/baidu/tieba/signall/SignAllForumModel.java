package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes24.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private String mAuthSid;
    private b mwj;
    private h mwk;
    private a mwl;
    private c mwm;

    /* loaded from: classes24.dex */
    public interface a {
        void LW(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mwj = null;
        this.mwk = null;
        this.mwl = null;
        this.mwk = new h();
    }

    public void a(a aVar) {
        this.mwl = aVar;
    }

    public void d(c cVar) {
        this.mwm = cVar;
    }

    public c dBY() {
        return this.mwm;
    }

    private String dBZ() {
        ArrayList<d> dBu = this.mwm.dBu();
        if (dBu == null) {
            return "";
        }
        if (!this.mwm.dBv()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dBu.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.dBE() < this.mwm.getLevel()) {
                    arrayList.add(next);
                }
            }
            dBu.removeAll(arrayList);
        }
        int size = dBu.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dBu.get(i);
            if (dVar.dBH()) {
                if (!dVar.dBI()) {
                    dVar.wF(true);
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
        if (this.mwj != null) {
            return false;
        }
        String str = null;
        this.mwj = new b();
        boolean dBk = this.mwm.dBk();
        if (!dBk) {
            str = dBZ();
        }
        this.mwj.wH(dBk);
        this.mwj.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mwj != null) {
            this.mwj.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes24.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e mwn = null;
        private boolean mwo = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void wH(boolean z) {
            this.mwo = z;
        }

        public boolean dCa() {
            return this.mwo;
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
        /* renamed from: S */
        public h doInBackground(String... strArr) {
            if (!dCa() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dCa()) {
                this.mwn = new e();
                this.mwn.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dCb();
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
                    this.mwn = new e();
                    this.mwn.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        RA(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.mwk;
        }

        private h dCb() {
            String dBM = this.mwn.dBM();
            if (this.mwn.isRequestSuccess()) {
                SignAllForumModel.this.mwk.parserJson(dBM);
                return SignAllForumModel.this.mwk;
            }
            SignAllForumModel.this.mwk = null;
            this.tokenData = AuthTokenData.parse(dBM);
            return null;
        }

        private h RA(String str) {
            String Rx = this.mwn.Rx(str);
            if (this.mwn.isRequestSuccess()) {
                SignAllForumModel.this.mwk.parserJson(Rx);
                return SignAllForumModel.this.mwk;
            }
            SignAllForumModel.this.mwk = null;
            this.tokenData = AuthTokenData.parse(Rx);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.mwn.cancel();
            this.mwn = null;
            SignAllForumModel.this.mwj = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.mwj = null;
            if (SignAllForumModel.this.mwl != null) {
                if (SignAllForumModel.this.mwk != null) {
                    SignAllForumModel.this.mwl.b(SignAllForumModel.this.mwk);
                } else {
                    SignAllForumModel.this.mwl.LW(this.mwn != null ? this.mwn.bfm() : null);
                }
            }
        }
    }
}
