package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private String mAuthSid;
    private b neQ;
    private h neR;
    private a neS;
    private c neT;

    /* loaded from: classes7.dex */
    public interface a {
        void Mf(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.neQ = null;
        this.neR = null;
        this.neS = null;
        this.neR = new h();
    }

    public void a(a aVar) {
        this.neS = aVar;
    }

    public void d(c cVar) {
        this.neT = cVar;
    }

    public c dIR() {
        return this.neT;
    }

    private String dIS() {
        ArrayList<d> dIo = this.neT.dIo();
        if (dIo == null) {
            return "";
        }
        if (!this.neT.dIp()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dIo.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bKd() < this.neT.getLevel()) {
                    arrayList.add(next);
                }
            }
            dIo.removeAll(arrayList);
        }
        int size = dIo.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dIo.get(i);
            if (dVar.dIA()) {
                if (!dVar.dIB()) {
                    dVar.xL(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(dVar.getForumId());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.neQ != null) {
            return false;
        }
        String str = null;
        this.neQ = new b();
        boolean dIe = this.neT.dIe();
        if (!dIe) {
            str = dIS();
        }
        this.neQ.xN(dIe);
        this.neQ.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.neQ != null) {
            this.neQ.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes7.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e neU = null;
        private boolean neV = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void xN(boolean z) {
            this.neV = z;
        }

        public boolean dIT() {
            return this.neV;
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
        /* renamed from: aa */
        public h doInBackground(String... strArr) {
            if (!dIT() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dIT()) {
                this.neU = new e();
                this.neU.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dIU();
                }
            } else {
                String[] split = strArr[0].split(",");
                int ceil = (int) Math.ceil(split.length / 50.0f);
                for (int i = 0; i < ceil; i++) {
                    int i2 = i * 50;
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 50 && i2 + i3 < split.length; i3++) {
                        if (i2 + i3 == split.length - 1) {
                            sb.append(split[i2 + i3]);
                        } else {
                            sb.append(split[i2 + i3] + ",");
                        }
                    }
                    this.neU = new e();
                    this.neU.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        RF(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.neR;
        }

        private h dIU() {
            String dIF = this.neU.dIF();
            if (this.neU.isRequestSuccess()) {
                SignAllForumModel.this.neR.parserJson(dIF);
                return SignAllForumModel.this.neR;
            }
            SignAllForumModel.this.neR = null;
            this.tokenData = AuthTokenData.parse(dIF);
            return null;
        }

        private h RF(String str) {
            String RC = this.neU.RC(str);
            if (this.neU.isRequestSuccess()) {
                SignAllForumModel.this.neR.parserJson(RC);
                return SignAllForumModel.this.neR;
            }
            SignAllForumModel.this.neR = null;
            this.tokenData = AuthTokenData.parse(RC);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.neU.cancel();
            this.neU = null;
            SignAllForumModel.this.neQ = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.neQ = null;
            if (SignAllForumModel.this.neS != null) {
                if (SignAllForumModel.this.neR != null) {
                    SignAllForumModel.this.neS.b(SignAllForumModel.this.neR);
                } else {
                    SignAllForumModel.this.neS.Mf(this.neU != null ? this.neU.bkz() : null);
                }
            }
        }
    }
}
