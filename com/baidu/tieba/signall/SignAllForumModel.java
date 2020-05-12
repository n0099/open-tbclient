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
    private b kKw;
    private h kKx;
    private a kKy;
    private c kKz;
    private String mAuthSid;

    /* loaded from: classes11.dex */
    public interface a {
        void EM(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.kKw = null;
        this.kKx = null;
        this.kKy = null;
        this.kKx = new h();
    }

    public void a(a aVar) {
        this.kKy = aVar;
    }

    public void d(c cVar) {
        this.kKz = cVar;
    }

    public c cUb() {
        return this.kKz;
    }

    private String cUc() {
        ArrayList<d> cTw = this.kKz.cTw();
        if (cTw == null) {
            return "";
        }
        if (!this.kKz.cTx()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cTw.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cTG() < this.kKz.getLevel()) {
                    arrayList.add(next);
                }
            }
            cTw.removeAll(arrayList);
        }
        int size = cTw.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cTw.get(i);
            if (dVar.cTJ()) {
                if (!dVar.cTK()) {
                    dVar.tI(true);
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
        if (this.kKw != null) {
            return false;
        }
        String str = null;
        this.kKw = new b();
        boolean cTm = this.kKz.cTm();
        if (!cTm) {
            str = cUc();
        }
        this.kKw.tK(cTm);
        this.kKw.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kKw != null) {
            this.kKw.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e kKA = null;
        private boolean kKB = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void tK(boolean z) {
            this.kKB = z;
        }

        public boolean cUd() {
            return this.kKB;
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
            if (!cUd() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cUd()) {
                this.kKA = new e();
                this.kKA.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cUe();
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
                    this.kKA = new e();
                    this.kKA.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Kr(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.kKx;
        }

        private h cUe() {
            String cTP = this.kKA.cTP();
            if (this.kKA.isRequestSuccess()) {
                SignAllForumModel.this.kKx.parserJson(cTP);
                return SignAllForumModel.this.kKx;
            }
            SignAllForumModel.this.kKx = null;
            this.tokenData = AuthTokenData.parse(cTP);
            return null;
        }

        private h Kr(String str) {
            String Ko = this.kKA.Ko(str);
            if (this.kKA.isRequestSuccess()) {
                SignAllForumModel.this.kKx.parserJson(Ko);
                return SignAllForumModel.this.kKx;
            }
            SignAllForumModel.this.kKx = null;
            this.tokenData = AuthTokenData.parse(Ko);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.kKA.cancel();
            this.kKA = null;
            SignAllForumModel.this.kKw = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.kKw = null;
            if (SignAllForumModel.this.kKy != null) {
                if (SignAllForumModel.this.kKx != null) {
                    SignAllForumModel.this.kKy.b(SignAllForumModel.this.kKx);
                } else {
                    SignAllForumModel.this.kKy.EM(this.kKA != null ? this.kKA.aIa() : null);
                }
            }
        }
    }
}
