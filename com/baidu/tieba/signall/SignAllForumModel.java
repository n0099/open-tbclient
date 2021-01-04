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
    private b njw;
    private h njx;
    private a njy;
    private c njz;

    /* loaded from: classes8.dex */
    public interface a {
        void No(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.njw = null;
        this.njx = null;
        this.njy = null;
        this.njx = new h();
    }

    public void a(a aVar) {
        this.njy = aVar;
    }

    public void d(c cVar) {
        this.njz = cVar;
    }

    public c dMI() {
        return this.njz;
    }

    private String dMJ() {
        ArrayList<d> dMf = this.njz.dMf();
        if (dMf == null) {
            return "";
        }
        if (!this.njz.dMg()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dMf.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bNU() < this.njz.getLevel()) {
                    arrayList.add(next);
                }
            }
            dMf.removeAll(arrayList);
        }
        int size = dMf.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dMf.get(i);
            if (dVar.dMr()) {
                if (!dVar.dMs()) {
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
        if (this.njw != null) {
            return false;
        }
        String str = null;
        this.njw = new b();
        boolean dLV = this.njz.dLV();
        if (!dLV) {
            str = dMJ();
        }
        this.njw.xR(dLV);
        this.njw.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.njw != null) {
            this.njw.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e njA = null;
        private boolean njB = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void xR(boolean z) {
            this.njB = z;
        }

        public boolean dMK() {
            return this.njB;
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
            if (!dMK() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dMK()) {
                this.njA = new e();
                this.njA.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dML();
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
                    this.njA = new e();
                    this.njA.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SO(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.njx;
        }

        private h dML() {
            String dMw = this.njA.dMw();
            if (this.njA.isRequestSuccess()) {
                SignAllForumModel.this.njx.parserJson(dMw);
                return SignAllForumModel.this.njx;
            }
            SignAllForumModel.this.njx = null;
            this.tokenData = AuthTokenData.parse(dMw);
            return null;
        }

        private h SO(String str) {
            String SL = this.njA.SL(str);
            if (this.njA.isRequestSuccess()) {
                SignAllForumModel.this.njx.parserJson(SL);
                return SignAllForumModel.this.njx;
            }
            SignAllForumModel.this.njx = null;
            this.tokenData = AuthTokenData.parse(SL);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.njA.cancel();
            this.njA = null;
            SignAllForumModel.this.njw = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.njw = null;
            if (SignAllForumModel.this.njy != null) {
                if (SignAllForumModel.this.njx != null) {
                    SignAllForumModel.this.njy.b(SignAllForumModel.this.njx);
                } else {
                    SignAllForumModel.this.njy.No(this.njA != null ? this.njA.bos() : null);
                }
            }
        }
    }
}
