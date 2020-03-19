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
    private b kbd;
    private h kbe;
    private a kbf;
    private c kbg;
    private String mAuthSid;

    /* loaded from: classes11.dex */
    public interface a {
        void Db(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.kbd = null;
        this.kbe = null;
        this.kbf = null;
        this.kbe = new h();
    }

    public void a(a aVar) {
        this.kbf = aVar;
    }

    public void d(c cVar) {
        this.kbg = cVar;
    }

    public c cJz() {
        return this.kbg;
    }

    private String cJA() {
        ArrayList<d> cIV = this.kbg.cIV();
        if (cIV == null) {
            return "";
        }
        if (!this.kbg.cIW()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = cIV.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.cJf() < this.kbg.getLevel()) {
                    arrayList.add(next);
                }
            }
            cIV.removeAll(arrayList);
        }
        int size = cIV.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = cIV.get(i);
            if (dVar.cJi()) {
                if (!dVar.cJj()) {
                    dVar.sH(true);
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
        if (this.kbd != null) {
            return false;
        }
        String str = null;
        this.kbd = new b();
        boolean cIL = this.kbg.cIL();
        if (!cIL) {
            str = cJA();
        }
        this.kbd.sJ(cIL);
        this.kbd.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kbd != null) {
            this.kbd.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e kbh = null;
        private boolean kbi = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void sJ(boolean z) {
            this.kbi = z;
        }

        public boolean cJB() {
            return this.kbi;
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
            if (!cJB() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cJB()) {
                this.kbh = new e();
                this.kbh.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cJC();
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
                    this.kbh = new e();
                    this.kbh.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        IL(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.kbe;
        }

        private h cJC() {
            String cJn = this.kbh.cJn();
            if (this.kbh.isRequestSuccess()) {
                SignAllForumModel.this.kbe.parserJson(cJn);
                return SignAllForumModel.this.kbe;
            }
            SignAllForumModel.this.kbe = null;
            this.tokenData = AuthTokenData.parse(cJn);
            return null;
        }

        private h IL(String str) {
            String II = this.kbh.II(str);
            if (this.kbh.isRequestSuccess()) {
                SignAllForumModel.this.kbe.parserJson(II);
                return SignAllForumModel.this.kbe;
            }
            SignAllForumModel.this.kbe = null;
            this.tokenData = AuthTokenData.parse(II);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.kbh.cancel();
            this.kbh = null;
            SignAllForumModel.this.kbd = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.kbd = null;
            if (SignAllForumModel.this.kbf != null) {
                if (SignAllForumModel.this.kbe != null) {
                    SignAllForumModel.this.kbf.b(SignAllForumModel.this.kbe);
                } else {
                    SignAllForumModel.this.kbf.Db(this.kbh != null ? this.kbh.azP() : null);
                }
            }
        }
    }
}
