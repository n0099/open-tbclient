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
    private b lWQ;
    private h lWR;
    private a lWS;
    private c lWT;
    private String mAuthSid;

    /* loaded from: classes18.dex */
    public interface a {
        void KE(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.lWQ = null;
        this.lWR = null;
        this.lWS = null;
        this.lWR = new h();
    }

    public void a(a aVar) {
        this.lWS = aVar;
    }

    public void d(c cVar) {
        this.lWT = cVar;
    }

    public c dup() {
        return this.lWT;
    }

    private String duq() {
        ArrayList<d> dtL = this.lWT.dtL();
        if (dtL == null) {
            return "";
        }
        if (!this.lWT.dtM()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dtL.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.dtV() < this.lWT.getLevel()) {
                    arrayList.add(next);
                }
            }
            dtL.removeAll(arrayList);
        }
        int size = dtL.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dtL.get(i);
            if (dVar.dtY()) {
                if (!dVar.dtZ()) {
                    dVar.vO(true);
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
        if (this.lWQ != null) {
            return false;
        }
        String str = null;
        this.lWQ = new b();
        boolean dtB = this.lWT.dtB();
        if (!dtB) {
            str = duq();
        }
        this.lWQ.vQ(dtB);
        this.lWQ.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lWQ != null) {
            this.lWQ.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes18.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e lWU = null;
        private boolean lWV = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void vQ(boolean z) {
            this.lWV = z;
        }

        public boolean dur() {
            return this.lWV;
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
            if (!dur() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dur()) {
                this.lWU = new e();
                this.lWU.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dus();
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
                    this.lWU = new e();
                    this.lWU.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Qm(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.lWR;
        }

        private h dus() {
            String dud = this.lWU.dud();
            if (this.lWU.isRequestSuccess()) {
                SignAllForumModel.this.lWR.parserJson(dud);
                return SignAllForumModel.this.lWR;
            }
            SignAllForumModel.this.lWR = null;
            this.tokenData = AuthTokenData.parse(dud);
            return null;
        }

        private h Qm(String str) {
            String Qj = this.lWU.Qj(str);
            if (this.lWU.isRequestSuccess()) {
                SignAllForumModel.this.lWR.parserJson(Qj);
                return SignAllForumModel.this.lWR;
            }
            SignAllForumModel.this.lWR = null;
            this.tokenData = AuthTokenData.parse(Qj);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.lWU.cancel();
            this.lWU = null;
            SignAllForumModel.this.lWQ = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.lWQ = null;
            if (SignAllForumModel.this.lWS != null) {
                if (SignAllForumModel.this.lWR != null) {
                    SignAllForumModel.this.lWS.b(SignAllForumModel.this.lWR);
                } else {
                    SignAllForumModel.this.lWS.KE(this.lWU != null ? this.lWU.bbK() : null);
                }
            }
        }
    }
}
