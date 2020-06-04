package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private b ldV;
    private h ldW;
    private a ldX;
    private c ldY;
    private String mAuthSid;

    /* loaded from: classes11.dex */
    public interface a {
        void Gv(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.ldV = null;
        this.ldW = null;
        this.ldX = null;
        this.ldW = new h();
    }

    public void a(a aVar) {
        this.ldX = aVar;
    }

    public void d(c cVar) {
        this.ldY = cVar;
    }

    public c dbv() {
        return this.ldY;
    }

    private String dbw() {
        ArrayList<d> daQ = this.ldY.daQ();
        if (daQ == null) {
            return "";
        }
        if (!this.ldY.daR()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = daQ.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.dba() < this.ldY.getLevel()) {
                    arrayList.add(next);
                }
            }
            daQ.removeAll(arrayList);
        }
        int size = daQ.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = daQ.get(i);
            if (dVar.dbd()) {
                if (!dVar.dbe()) {
                    dVar.ug(true);
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
        if (this.ldV != null) {
            return false;
        }
        String str = null;
        this.ldV = new b();
        boolean daG = this.ldY.daG();
        if (!daG) {
            str = dbw();
        }
        this.ldV.ui(daG);
        this.ldV.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ldV != null) {
            this.ldV.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e ldZ = null;
        private boolean lea = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void ui(boolean z) {
            this.lea = z;
        }

        public boolean dbx() {
            return this.lea;
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
            if (!dbx() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dbx()) {
                this.ldZ = new e();
                this.ldZ.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dby();
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
                    this.ldZ = new e();
                    this.ldZ.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Me(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.ldW;
        }

        private h dby() {
            String dbj = this.ldZ.dbj();
            if (this.ldZ.isRequestSuccess()) {
                SignAllForumModel.this.ldW.parserJson(dbj);
                return SignAllForumModel.this.ldW;
            }
            SignAllForumModel.this.ldW = null;
            this.tokenData = AuthTokenData.parse(dbj);
            return null;
        }

        private h Me(String str) {
            String Mb = this.ldZ.Mb(str);
            if (this.ldZ.isRequestSuccess()) {
                SignAllForumModel.this.ldW.parserJson(Mb);
                return SignAllForumModel.this.ldW;
            }
            SignAllForumModel.this.ldW = null;
            this.tokenData = AuthTokenData.parse(Mb);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.ldZ.cancel();
            this.ldZ = null;
            SignAllForumModel.this.ldV = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.ldV = null;
            if (SignAllForumModel.this.ldX != null) {
                if (SignAllForumModel.this.ldW != null) {
                    SignAllForumModel.this.ldX.b(SignAllForumModel.this.ldW);
                } else {
                    SignAllForumModel.this.ldX.Gv(this.ldZ != null ? this.ldZ.aNO() : null);
                }
            }
        }
    }
}
