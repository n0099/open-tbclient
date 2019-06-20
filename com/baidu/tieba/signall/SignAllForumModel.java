package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b iRt;
    private h iRu;
    private a iRv;
    private c iRw;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes6.dex */
    public interface a {
        void b(h hVar);

        void yo(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.iRt = null;
        this.iRu = null;
        this.iRv = null;
        this.iRu = new h();
    }

    public void a(a aVar) {
        this.iRv = aVar;
    }

    public void d(c cVar) {
        this.iRw = cVar;
    }

    public c cky() {
        return this.iRw;
    }

    private String ckz() {
        ArrayList<d> cjU = this.iRw.cjU();
        if (cjU == null) {
            return "";
        }
        if (!this.iRw.cjV()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cjU.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cke() < this.iRw.getLevel()) {
                    arrayList.add(next);
                }
            }
            cjU.removeAll(arrayList);
        }
        int size = cjU.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cjU.get(i);
            if (dVar.ckh()) {
                if (!dVar.cki()) {
                    dVar.qB(true);
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
        if (this.iRt != null) {
            return false;
        }
        String str = null;
        this.iRt = new b();
        boolean cjK = this.iRw.cjK();
        if (!cjK) {
            str = ckz();
        }
        this.iRt.qD(cjK);
        this.iRt.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iRt != null) {
            this.iRt.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e iRx = null;
        private boolean iRy = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void qD(boolean z) {
            this.iRy = z;
        }

        public boolean ckA() {
            return this.iRy;
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
            if (!ckA() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (ckA()) {
                this.iRx = new e();
                this.iRx.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.jS()) {
                    ckB();
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
                    this.iRx = new e();
                    this.iRx.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.jS()) {
                        DG(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.iRu;
        }

        private h ckB() {
            String ckm = this.iRx.ckm();
            if (this.iRx.isRequestSuccess()) {
                SignAllForumModel.this.iRu.parserJson(ckm);
                return SignAllForumModel.this.iRu;
            }
            SignAllForumModel.this.iRu = null;
            this.tokenData = AuthTokenData.parse(ckm);
            return null;
        }

        private h DG(String str) {
            String DD = this.iRx.DD(str);
            if (this.iRx.isRequestSuccess()) {
                SignAllForumModel.this.iRu.parserJson(DD);
                return SignAllForumModel.this.iRu;
            }
            SignAllForumModel.this.iRu = null;
            this.tokenData = AuthTokenData.parse(DD);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.iRx.cancel();
            this.iRx = null;
            SignAllForumModel.this.iRt = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.iRt = null;
            if (SignAllForumModel.this.iRv != null) {
                if (SignAllForumModel.this.iRu != null) {
                    SignAllForumModel.this.iRv.b(SignAllForumModel.this.iRu);
                } else {
                    SignAllForumModel.this.iRv.yo(this.iRx != null ? this.iRx.aaZ() : null);
                }
            }
        }
    }
}
