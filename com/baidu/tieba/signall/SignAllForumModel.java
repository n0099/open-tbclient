package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b iXK;
    private h iXL;
    private a iXM;
    private c iXN;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes6.dex */
    public interface a {
        void b(h hVar);

        void yZ(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.iXK = null;
        this.iXL = null;
        this.iXM = null;
        this.iXL = new h();
    }

    public void a(a aVar) {
        this.iXM = aVar;
    }

    public void d(c cVar) {
        this.iXN = cVar;
    }

    public c cnp() {
        return this.iXN;
    }

    private String cnq() {
        ArrayList<d> cmL = this.iXN.cmL();
        if (cmL == null) {
            return "";
        }
        if (!this.iXN.cmM()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cmL.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cmV() < this.iXN.getLevel()) {
                    arrayList.add(next);
                }
            }
            cmL.removeAll(arrayList);
        }
        int size = cmL.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cmL.get(i);
            if (dVar.cmY()) {
                if (!dVar.cmZ()) {
                    dVar.qQ(true);
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
        if (this.iXK != null) {
            return false;
        }
        String str = null;
        this.iXK = new b();
        boolean cmB = this.iXN.cmB();
        if (!cmB) {
            str = cnq();
        }
        this.iXK.qS(cmB);
        this.iXK.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iXK != null) {
            this.iXK.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e iXO = null;
        private boolean iXP = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void qS(boolean z) {
            this.iXP = z;
        }

        public boolean cnr() {
            return this.iXP;
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
            if (!cnr() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cnr()) {
                this.iXO = new e();
                this.iXO.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kc()) {
                    cns();
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
                    this.iXO = new e();
                    this.iXO.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kc()) {
                        Et(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.iXL;
        }

        private h cns() {
            String cnd = this.iXO.cnd();
            if (this.iXO.isRequestSuccess()) {
                SignAllForumModel.this.iXL.parserJson(cnd);
                return SignAllForumModel.this.iXL;
            }
            SignAllForumModel.this.iXL = null;
            this.tokenData = AuthTokenData.parse(cnd);
            return null;
        }

        private h Et(String str) {
            String Eq = this.iXO.Eq(str);
            if (this.iXO.isRequestSuccess()) {
                SignAllForumModel.this.iXL.parserJson(Eq);
                return SignAllForumModel.this.iXL;
            }
            SignAllForumModel.this.iXL = null;
            this.tokenData = AuthTokenData.parse(Eq);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.iXO.cancel();
            this.iXO = null;
            SignAllForumModel.this.iXK = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.iXK = null;
            if (SignAllForumModel.this.iXM != null) {
                if (SignAllForumModel.this.iXL != null) {
                    SignAllForumModel.this.iXM.b(SignAllForumModel.this.iXL);
                } else {
                    SignAllForumModel.this.iXM.yZ(this.iXO != null ? this.iXO.abY() : null);
                }
            }
        }
    }
}
