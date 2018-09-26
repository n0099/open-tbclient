package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gNh;
    private h gNi;
    private a gNj;
    private c gNk;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void oW(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gNh = null;
        this.gNi = null;
        this.gNj = null;
        this.gNi = new h();
    }

    public void a(a aVar) {
        this.gNj = aVar;
    }

    public void d(c cVar) {
        this.gNk = cVar;
    }

    public c bvA() {
        return this.gNk;
    }

    private String bvB() {
        ArrayList<d> buW = this.gNk.buW();
        if (buW == null) {
            return "";
        }
        if (!this.gNk.buX()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = buW.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bvg() < this.gNk.getLevel()) {
                    arrayList.add(next);
                }
            }
            buW.removeAll(arrayList);
        }
        int size = buW.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = buW.get(i);
            if (dVar.bvj()) {
                if (!dVar.bvk()) {
                    dVar.mC(true);
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
        if (this.gNh != null) {
            return false;
        }
        String str = null;
        this.gNh = new b();
        boolean buM = this.gNk.buM();
        if (!buM) {
            str = bvB();
        }
        this.gNh.mE(buM);
        this.gNh.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gNh != null) {
            this.gNh.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gNl = null;
        private boolean gNm = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void mE(boolean z) {
            this.gNm = z;
        }

        public boolean bvC() {
            return this.gNm;
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
        /* renamed from: D */
        public h doInBackground(String... strArr) {
            if (!bvC() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (bvC()) {
                this.gNl = new e();
                this.gNl.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kK()) {
                    bvD();
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
                    this.gNl = new e();
                    this.gNl.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kK()) {
                        ud(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gNi;
        }

        private h bvD() {
            String bvo = this.gNl.bvo();
            if (this.gNl.isRequestSuccess()) {
                SignAllForumModel.this.gNi.parserJson(bvo);
                return SignAllForumModel.this.gNi;
            }
            SignAllForumModel.this.gNi = null;
            this.tokenData = AuthTokenData.parse(bvo);
            return null;
        }

        private h ud(String str) {
            String ua = this.gNl.ua(str);
            if (this.gNl.isRequestSuccess()) {
                SignAllForumModel.this.gNi.parserJson(ua);
                return SignAllForumModel.this.gNi;
            }
            SignAllForumModel.this.gNi = null;
            this.tokenData = AuthTokenData.parse(ua);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gNl.cancel();
            this.gNl = null;
            SignAllForumModel.this.gNh = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gNh = null;
            if (SignAllForumModel.this.gNj != null) {
                if (SignAllForumModel.this.gNi != null) {
                    SignAllForumModel.this.gNj.b(SignAllForumModel.this.gNi);
                } else {
                    SignAllForumModel.this.gNj.oW(this.gNl != null ? this.gNl.uh() : null);
                }
            }
        }
    }
}
