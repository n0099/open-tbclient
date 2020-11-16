package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes23.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private String mAuthSid;
    private b mPJ;
    private h mPK;
    private a mPL;
    private c mPM;

    /* loaded from: classes23.dex */
    public interface a {
        void Mm(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPJ = null;
        this.mPK = null;
        this.mPL = null;
        this.mPK = new h();
    }

    public void a(a aVar) {
        this.mPL = aVar;
    }

    public void d(c cVar) {
        this.mPM = cVar;
    }

    public c dHz() {
        return this.mPM;
    }

    private String dHA() {
        ArrayList<d> dGV = this.mPM.dGV();
        if (dGV == null) {
            return "";
        }
        if (!this.mPM.dGW()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dGV.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.dHf() < this.mPM.getLevel()) {
                    arrayList.add(next);
                }
            }
            dGV.removeAll(arrayList);
        }
        int size = dGV.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dGV.get(i);
            if (dVar.dHi()) {
                if (!dVar.dHj()) {
                    dVar.xj(true);
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
        if (this.mPJ != null) {
            return false;
        }
        String str = null;
        this.mPJ = new b();
        boolean dGL = this.mPM.dGL();
        if (!dGL) {
            str = dHA();
        }
        this.mPJ.xl(dGL);
        this.mPJ.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mPJ != null) {
            this.mPJ.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes23.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e mPN = null;
        private boolean mPO = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void xl(boolean z) {
            this.mPO = z;
        }

        public boolean dHB() {
            return this.mPO;
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
        /* renamed from: U */
        public h doInBackground(String... strArr) {
            if (!dHB() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dHB()) {
                this.mPN = new e();
                this.mPN.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dHC();
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
                    this.mPN = new e();
                    this.mPN.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        RR(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.mPK;
        }

        private h dHC() {
            String dHn = this.mPN.dHn();
            if (this.mPN.isRequestSuccess()) {
                SignAllForumModel.this.mPK.parserJson(dHn);
                return SignAllForumModel.this.mPK;
            }
            SignAllForumModel.this.mPK = null;
            this.tokenData = AuthTokenData.parse(dHn);
            return null;
        }

        private h RR(String str) {
            String RO = this.mPN.RO(str);
            if (this.mPN.isRequestSuccess()) {
                SignAllForumModel.this.mPK.parserJson(RO);
                return SignAllForumModel.this.mPK;
            }
            SignAllForumModel.this.mPK = null;
            this.tokenData = AuthTokenData.parse(RO);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.mPN.cancel();
            this.mPN = null;
            SignAllForumModel.this.mPJ = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.mPJ = null;
            if (SignAllForumModel.this.mPL != null) {
                if (SignAllForumModel.this.mPK != null) {
                    SignAllForumModel.this.mPL.b(SignAllForumModel.this.mPK);
                } else {
                    SignAllForumModel.this.mPL.Mm(this.mPN != null ? this.mPN.biJ() : null);
                }
            }
        }
    }
}
