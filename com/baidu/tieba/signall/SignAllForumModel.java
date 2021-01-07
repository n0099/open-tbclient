package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private String mAuthSid;
    private b njv;
    private h njw;
    private a njx;
    private c njy;

    /* loaded from: classes8.dex */
    public interface a {
        void Nn(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.njv = null;
        this.njw = null;
        this.njx = null;
        this.njw = new h();
    }

    public void a(a aVar) {
        this.njx = aVar;
    }

    public void d(c cVar) {
        this.njy = cVar;
    }

    public c dMJ() {
        return this.njy;
    }

    private String dMK() {
        ArrayList<d> dMg = this.njy.dMg();
        if (dMg == null) {
            return "";
        }
        if (!this.njy.dMh()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dMg.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bNV() < this.njy.getLevel()) {
                    arrayList.add(next);
                }
            }
            dMg.removeAll(arrayList);
        }
        int size = dMg.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dMg.get(i);
            if (dVar.dMs()) {
                if (!dVar.dMt()) {
                    dVar.xP(true);
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
        if (this.njv != null) {
            return false;
        }
        String str = null;
        this.njv = new b();
        boolean dLW = this.njy.dLW();
        if (!dLW) {
            str = dMK();
        }
        this.njv.xR(dLW);
        this.njv.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.njv != null) {
            this.njv.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private AuthTokenData tokenData;
        private e njz = null;
        private boolean njA = false;

        public b() {
            setPriority(3);
        }

        public void xR(boolean z) {
            this.njA = z;
        }

        public boolean dML() {
            return this.njA;
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
            if (!dML() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dML()) {
                this.njz = new e();
                this.njz.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dMM();
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
                    this.njz = new e();
                    this.njz.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SN(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.njw;
        }

        private h dMM() {
            String dMx = this.njz.dMx();
            if (this.njz.isRequestSuccess()) {
                SignAllForumModel.this.njw.parserJson(dMx);
                return SignAllForumModel.this.njw;
            }
            SignAllForumModel.this.njw = null;
            this.tokenData = AuthTokenData.parse(dMx);
            return null;
        }

        private h SN(String str) {
            String SK = this.njz.SK(str);
            if (this.njz.isRequestSuccess()) {
                SignAllForumModel.this.njw.parserJson(SK);
                return SignAllForumModel.this.njw;
            }
            SignAllForumModel.this.njw = null;
            this.tokenData = AuthTokenData.parse(SK);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.njz.cancel();
            this.njz = null;
            SignAllForumModel.this.njv = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.njv = null;
            if (SignAllForumModel.this.njx != null) {
                if (SignAllForumModel.this.njw != null) {
                    SignAllForumModel.this.njx.b(SignAllForumModel.this.njw);
                } else {
                    SignAllForumModel.this.njx.Nn(this.njz != null ? this.njz.bot() : null);
                }
            }
        }
    }
}
