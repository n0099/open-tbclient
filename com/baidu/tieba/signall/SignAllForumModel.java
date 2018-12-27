package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b hga;
    private h hgb;
    private a hgc;
    private c hgd;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void qe(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.hga = null;
        this.hgb = null;
        this.hgc = null;
        this.hgb = new h();
    }

    public void a(a aVar) {
        this.hgc = aVar;
    }

    public void d(c cVar) {
        this.hgd = cVar;
    }

    public c bAU() {
        return this.hgd;
    }

    private String bAV() {
        ArrayList<d> bAq = this.hgd.bAq();
        if (bAq == null) {
            return "";
        }
        if (!this.hgd.bAr()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = bAq.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bAA() < this.hgd.getLevel()) {
                    arrayList.add(next);
                }
            }
            bAq.removeAll(arrayList);
        }
        int size = bAq.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = bAq.get(i);
            if (dVar.bAD()) {
                if (!dVar.bAE()) {
                    dVar.nk(true);
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
        if (this.hga != null) {
            return false;
        }
        String str = null;
        this.hga = new b();
        boolean bAg = this.hgd.bAg();
        if (!bAg) {
            str = bAV();
        }
        this.hga.nm(bAg);
        this.hga.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.hga != null) {
            this.hga.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e hge = null;
        private boolean hgf = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void nm(boolean z) {
            this.hgf = z;
        }

        public boolean bAW() {
            return this.hgf;
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
        /* renamed from: G */
        public h doInBackground(String... strArr) {
            if (!bAW() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (bAW()) {
                this.hge = new e();
                this.hge.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kV()) {
                    bAX();
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
                    this.hge = new e();
                    this.hge.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        vn(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.hgb;
        }

        private h bAX() {
            String bAI = this.hge.bAI();
            if (this.hge.isRequestSuccess()) {
                SignAllForumModel.this.hgb.parserJson(bAI);
                return SignAllForumModel.this.hgb;
            }
            SignAllForumModel.this.hgb = null;
            this.tokenData = AuthTokenData.parse(bAI);
            return null;
        }

        private h vn(String str) {
            String vk = this.hge.vk(str);
            if (this.hge.isRequestSuccess()) {
                SignAllForumModel.this.hgb.parserJson(vk);
                return SignAllForumModel.this.hgb;
            }
            SignAllForumModel.this.hgb = null;
            this.tokenData = AuthTokenData.parse(vk);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.hge.cancel();
            this.hge = null;
            SignAllForumModel.this.hga = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.hga = null;
            if (SignAllForumModel.this.hgc != null) {
                if (SignAllForumModel.this.hgb != null) {
                    SignAllForumModel.this.hgc.b(SignAllForumModel.this.hgb);
                } else {
                    SignAllForumModel.this.hgc.qe(this.hge != null ? this.hge.xC() : null);
                }
            }
        }
    }
}
