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
    private b mgG;
    private h mgH;
    private a mgI;
    private c mgJ;

    /* loaded from: classes23.dex */
    public interface a {
        void Lh(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mgG = null;
        this.mgH = null;
        this.mgI = null;
        this.mgH = new h();
    }

    public void a(a aVar) {
        this.mgI = aVar;
    }

    public void d(c cVar) {
        this.mgJ = cVar;
    }

    public c dyn() {
        return this.mgJ;
    }

    private String dyo() {
        ArrayList<d> dxJ = this.mgJ.dxJ();
        if (dxJ == null) {
            return "";
        }
        if (!this.mgJ.dxK()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dxJ.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.dxT() < this.mgJ.getLevel()) {
                    arrayList.add(next);
                }
            }
            dxJ.removeAll(arrayList);
        }
        int size = dxJ.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dxJ.get(i);
            if (dVar.dxW()) {
                if (!dVar.dxX()) {
                    dVar.vY(true);
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
        if (this.mgG != null) {
            return false;
        }
        String str = null;
        this.mgG = new b();
        boolean dxz = this.mgJ.dxz();
        if (!dxz) {
            str = dyo();
        }
        this.mgG.wa(dxz);
        this.mgG.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mgG != null) {
            this.mgG.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes23.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e mgK = null;
        private boolean mgL = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void wa(boolean z) {
            this.mgL = z;
        }

        public boolean dyp() {
            return this.mgL;
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
            if (!dyp() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dyp()) {
                this.mgK = new e();
                this.mgK.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dyq();
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
                    this.mgK = new e();
                    this.mgK.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        QM(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.mgH;
        }

        private h dyq() {
            String dyb = this.mgK.dyb();
            if (this.mgK.isRequestSuccess()) {
                SignAllForumModel.this.mgH.parserJson(dyb);
                return SignAllForumModel.this.mgH;
            }
            SignAllForumModel.this.mgH = null;
            this.tokenData = AuthTokenData.parse(dyb);
            return null;
        }

        private h QM(String str) {
            String QJ = this.mgK.QJ(str);
            if (this.mgK.isRequestSuccess()) {
                SignAllForumModel.this.mgH.parserJson(QJ);
                return SignAllForumModel.this.mgH;
            }
            SignAllForumModel.this.mgH = null;
            this.tokenData = AuthTokenData.parse(QJ);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.mgK.cancel();
            this.mgK = null;
            SignAllForumModel.this.mgG = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.mgG = null;
            if (SignAllForumModel.this.mgI != null) {
                if (SignAllForumModel.this.mgH != null) {
                    SignAllForumModel.this.mgI.b(SignAllForumModel.this.mgH);
                } else {
                    SignAllForumModel.this.mgI.Lh(this.mgK != null ? this.mgK.bcE() : null);
                }
            }
        }
    }
}
