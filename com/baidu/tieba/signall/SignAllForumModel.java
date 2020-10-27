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
    private b mIT;
    private h mIU;
    private a mIV;
    private c mIW;

    /* loaded from: classes24.dex */
    public interface a {
        void Mu(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mIT = null;
        this.mIU = null;
        this.mIV = null;
        this.mIU = new h();
    }

    public void a(a aVar) {
        this.mIV = aVar;
    }

    public void d(c cVar) {
        this.mIW = cVar;
    }

    public c dFg() {
        return this.mIW;
    }

    private String dFh() {
        ArrayList<d> dEC = this.mIW.dEC();
        if (dEC == null) {
            return "";
        }
        if (!this.mIW.dED()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dEC.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.dEM() < this.mIW.getLevel()) {
                    arrayList.add(next);
                }
            }
            dEC.removeAll(arrayList);
        }
        int size = dEC.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dEC.get(i);
            if (dVar.dEP()) {
                if (!dVar.dEQ()) {
                    dVar.wW(true);
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
        if (this.mIT != null) {
            return false;
        }
        String str = null;
        this.mIT = new b();
        boolean dEs = this.mIW.dEs();
        if (!dEs) {
            str = dFh();
        }
        this.mIT.wY(dEs);
        this.mIT.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mIT != null) {
            this.mIT.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes24.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e mIX = null;
        private boolean mIY = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void wY(boolean z) {
            this.mIY = z;
        }

        public boolean dFi() {
            return this.mIY;
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
        /* renamed from: T */
        public h doInBackground(String... strArr) {
            if (!dFi() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dFi()) {
                this.mIX = new e();
                this.mIX.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dFj();
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
                    this.mIX = new e();
                    this.mIX.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        RZ(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.mIU;
        }

        private h dFj() {
            String dEU = this.mIX.dEU();
            if (this.mIX.isRequestSuccess()) {
                SignAllForumModel.this.mIU.parserJson(dEU);
                return SignAllForumModel.this.mIU;
            }
            SignAllForumModel.this.mIU = null;
            this.tokenData = AuthTokenData.parse(dEU);
            return null;
        }

        private h RZ(String str) {
            String RW = this.mIX.RW(str);
            if (this.mIX.isRequestSuccess()) {
                SignAllForumModel.this.mIU.parserJson(RW);
                return SignAllForumModel.this.mIU;
            }
            SignAllForumModel.this.mIU = null;
            this.tokenData = AuthTokenData.parse(RW);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.mIX.cancel();
            this.mIX = null;
            SignAllForumModel.this.mIT = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.mIT = null;
            if (SignAllForumModel.this.mIV != null) {
                if (SignAllForumModel.this.mIU != null) {
                    SignAllForumModel.this.mIV.b(SignAllForumModel.this.mIU);
                } else {
                    SignAllForumModel.this.mIV.Mu(this.mIX != null ? this.mIX.bhf() : null);
                }
            }
        }
    }
}
