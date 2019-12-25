package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private b jUG;
    private h jUH;
    private a jUI;
    private c jUJ;
    private String mAuthSid;

    /* loaded from: classes8.dex */
    public interface a {
        void CA(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.jUG = null;
        this.jUH = null;
        this.jUI = null;
        this.jUH = new h();
    }

    public void a(a aVar) {
        this.jUI = aVar;
    }

    public void d(c cVar) {
        this.jUJ = cVar;
    }

    public c cGs() {
        return this.jUJ;
    }

    private String cGt() {
        ArrayList<d> cFO = this.jUJ.cFO();
        if (cFO == null) {
            return "";
        }
        if (!this.jUJ.cFP()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cFO.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cFY() < this.jUJ.getLevel()) {
                    arrayList.add(next);
                }
            }
            cFO.removeAll(arrayList);
        }
        int size = cFO.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cFO.get(i);
            if (dVar.cGb()) {
                if (!dVar.cGc()) {
                    dVar.sl(true);
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
        if (this.jUG != null) {
            return false;
        }
        String str = null;
        this.jUG = new b();
        boolean cFE = this.jUJ.cFE();
        if (!cFE) {
            str = cGt();
        }
        this.jUG.sn(cFE);
        this.jUG.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jUG != null) {
            this.jUG.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e jUK = null;
        private boolean jUL = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void sn(boolean z) {
            this.jUL = z;
        }

        public boolean cGu() {
            return this.jUL;
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
            if (!cGu() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cGu()) {
                this.jUK = new e();
                this.jUK.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cGv();
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
                    this.jUK = new e();
                    this.jUK.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Im(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.jUH;
        }

        private h cGv() {
            String cGg = this.jUK.cGg();
            if (this.jUK.isRequestSuccess()) {
                SignAllForumModel.this.jUH.parserJson(cGg);
                return SignAllForumModel.this.jUH;
            }
            SignAllForumModel.this.jUH = null;
            this.tokenData = AuthTokenData.parse(cGg);
            return null;
        }

        private h Im(String str) {
            String Ij = this.jUK.Ij(str);
            if (this.jUK.isRequestSuccess()) {
                SignAllForumModel.this.jUH.parserJson(Ij);
                return SignAllForumModel.this.jUH;
            }
            SignAllForumModel.this.jUH = null;
            this.tokenData = AuthTokenData.parse(Ij);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.jUK.cancel();
            this.jUK = null;
            SignAllForumModel.this.jUG = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.jUG = null;
            if (SignAllForumModel.this.jUI != null) {
                if (SignAllForumModel.this.jUH != null) {
                    SignAllForumModel.this.jUI.b(SignAllForumModel.this.jUH);
                } else {
                    SignAllForumModel.this.jUI.CA(this.jUK != null ? this.jUK.axd() : null);
                }
            }
        }
    }
}
