package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gUF;
    private h gUG;
    private a gUH;
    private c gUI;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void py(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gUF = null;
        this.gUG = null;
        this.gUH = null;
        this.gUG = new h();
    }

    public void a(a aVar) {
        this.gUH = aVar;
    }

    public void d(c cVar) {
        this.gUI = cVar;
    }

    public c byP() {
        return this.gUI;
    }

    private String byQ() {
        ArrayList<d> byl = this.gUI.byl();
        if (byl == null) {
            return "";
        }
        if (!this.gUI.bym()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = byl.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.byv() < this.gUI.getLevel()) {
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
        if (this.gUF != null) {
            return false;
        }
        String str = null;
        this.gUF = new b();
        boolean byb = this.gUI.byb();
        if (!byb) {
            str = byQ();
        }
        this.gUF.mW(byb);
        this.gUF.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gUF != null) {
            this.gUF.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gUJ = null;
        private boolean gUK = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void mW(boolean z) {
            this.gUK = z;
        }

        public boolean byR() {
            return this.gUK;
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
                this.gUJ = new e();
                this.gUJ.setAuthSid(SignAllForumModel.this.mAuthSid);
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
                    this.gUJ = new e();
                    this.gUJ.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kX()) {
                        uF(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gUG;
        }

        private h byS() {
            String byD = this.gUJ.byD();
            if (this.gUJ.isRequestSuccess()) {
                SignAllForumModel.this.gUG.parserJson(byD);
                return SignAllForumModel.this.gUG;
            }
            SignAllForumModel.this.gUG = null;
            this.tokenData = AuthTokenData.parse(byD);
            return null;
        }

        private h uF(String str) {
            String uC = this.gUJ.uC(str);
            if (this.gUJ.isRequestSuccess()) {
                SignAllForumModel.this.gUG.parserJson(uC);
                return SignAllForumModel.this.gUG;
            }
            SignAllForumModel.this.gUG = null;
            this.tokenData = AuthTokenData.parse(uC);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gUJ.cancel();
            this.gUJ = null;
            SignAllForumModel.this.gUF = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gUF = null;
            if (SignAllForumModel.this.gUH != null) {
                if (SignAllForumModel.this.gUG != null) {
                    SignAllForumModel.this.gUH.b(SignAllForumModel.this.gUG);
                } else {
                    SignAllForumModel.this.gUH.py(this.gUJ != null ? this.gUJ.wq() : null);
                }
            }
        }
    }
}
