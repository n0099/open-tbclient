package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gUE;
    private h gUF;
    private a gUG;
    private c gUH;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void py(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gUE = null;
        this.gUF = null;
        this.gUG = null;
        this.gUF = new h();
    }

    public void a(a aVar) {
        this.gUG = aVar;
    }

    public void d(c cVar) {
        this.gUH = cVar;
    }

    public c byP() {
        return this.gUH;
    }

    private String byQ() {
        ArrayList<d> byl = this.gUH.byl();
        if (byl == null) {
            return "";
        }
        if (!this.gUH.bym()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = byl.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.byv() < this.gUH.getLevel()) {
                    arrayList.add(next);
                }
            }
            byl.removeAll(arrayList);
        }
        int size = byl.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = byl.get(i);
            if (dVar.byy()) {
                if (!dVar.byz()) {
                    dVar.mU(true);
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
        if (this.gUE != null) {
            return false;
        }
        String str = null;
        this.gUE = new b();
        boolean byb = this.gUH.byb();
        if (!byb) {
            str = byQ();
        }
        this.gUE.mW(byb);
        this.gUE.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gUE != null) {
            this.gUE.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gUI = null;
        private boolean gUJ = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void mW(boolean z) {
            this.gUJ = z;
        }

        public boolean byR() {
            return this.gUJ;
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
            if (!byR() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (byR()) {
                this.gUI = new e();
                this.gUI.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kX()) {
                    byS();
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
                    this.gUI = new e();
                    this.gUI.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kX()) {
                        uF(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gUF;
        }

        private h byS() {
            String byD = this.gUI.byD();
            if (this.gUI.isRequestSuccess()) {
                SignAllForumModel.this.gUF.parserJson(byD);
                return SignAllForumModel.this.gUF;
            }
            SignAllForumModel.this.gUF = null;
            this.tokenData = AuthTokenData.parse(byD);
            return null;
        }

        private h uF(String str) {
            String uC = this.gUI.uC(str);
            if (this.gUI.isRequestSuccess()) {
                SignAllForumModel.this.gUF.parserJson(uC);
                return SignAllForumModel.this.gUF;
            }
            SignAllForumModel.this.gUF = null;
            this.tokenData = AuthTokenData.parse(uC);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gUI.cancel();
            this.gUI = null;
            SignAllForumModel.this.gUE = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gUE = null;
            if (SignAllForumModel.this.gUG != null) {
                if (SignAllForumModel.this.gUF != null) {
                    SignAllForumModel.this.gUG.b(SignAllForumModel.this.gUF);
                } else {
                    SignAllForumModel.this.gUG.py(this.gUI != null ? this.gUI.wq() : null);
                }
            }
        }
    }
}
