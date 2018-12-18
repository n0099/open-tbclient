package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b hcW;
    private h hcX;
    private a hcY;
    private c hcZ;
    public boolean isRunning;
    private String mAuthSid;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void qb(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.hcW = null;
        this.hcX = null;
        this.hcY = null;
        this.hcX = new h();
    }

    public void a(a aVar) {
        this.hcY = aVar;
    }

    public void d(c cVar) {
        this.hcZ = cVar;
    }

    public c bAe() {
        return this.hcZ;
    }

    private String bAf() {
        ArrayList<d> bzA = this.hcZ.bzA();
        if (bzA == null) {
            return "";
        }
        if (!this.hcZ.bzB()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = bzA.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bzK() < this.hcZ.getLevel()) {
                    arrayList.add(next);
                }
            }
            bzA.removeAll(arrayList);
        }
        int size = bzA.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = bzA.get(i);
            if (dVar.bzN()) {
                if (!dVar.bzO()) {
                    dVar.nh(true);
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
        if (this.hcW != null) {
            return false;
        }
        String str = null;
        this.hcW = new b();
        boolean bzq = this.hcZ.bzq();
        if (!bzq) {
            str = bAf();
        }
        this.hcW.nj(bzq);
        this.hcW.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.hcW != null) {
            this.hcW.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e hda = null;
        private boolean hdb = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void nj(boolean z) {
            this.hdb = z;
        }

        public boolean bAg() {
            return this.hdb;
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
            if (!bAg() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (bAg()) {
                this.hda = new e();
                this.hda.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.kV()) {
                    bAh();
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
                    this.hda = new e();
                    this.hda.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        vk(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.hcX;
        }

        private h bAh() {
            String bzS = this.hda.bzS();
            if (this.hda.isRequestSuccess()) {
                SignAllForumModel.this.hcX.parserJson(bzS);
                return SignAllForumModel.this.hcX;
            }
            SignAllForumModel.this.hcX = null;
            this.tokenData = AuthTokenData.parse(bzS);
            return null;
        }

        private h vk(String str) {
            String vh = this.hda.vh(str);
            if (this.hda.isRequestSuccess()) {
                SignAllForumModel.this.hcX.parserJson(vh);
                return SignAllForumModel.this.hcX;
            }
            SignAllForumModel.this.hcX = null;
            this.tokenData = AuthTokenData.parse(vh);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.hda.cancel();
            this.hda = null;
            SignAllForumModel.this.hcW = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.hcW = null;
            if (SignAllForumModel.this.hcY != null) {
                if (SignAllForumModel.this.hcX != null) {
                    SignAllForumModel.this.hcY.b(SignAllForumModel.this.hcX);
                } else {
                    SignAllForumModel.this.hcY.qb(this.hda != null ? this.hda.xC() : null);
                }
            }
        }
    }
}
