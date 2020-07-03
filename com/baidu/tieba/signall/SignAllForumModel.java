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
    private b lxS;
    private h lxT;
    private a lxU;
    private c lxV;
    private String mAuthSid;

    /* loaded from: classes11.dex */
    public interface a {
        void GX(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.lxS = null;
        this.lxT = null;
        this.lxU = null;
        this.lxT = new h();
    }

    public void a(a aVar) {
        this.lxU = aVar;
    }

    public void d(c cVar) {
        this.lxV = cVar;
    }

    public c dfK() {
        return this.lxV;
    }

    private String dfL() {
        ArrayList<d> dfg = this.lxV.dfg();
        if (dfg == null) {
            return "";
        }
        if (!this.lxV.dfh()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dfg.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.dfq() < this.lxV.getLevel()) {
                    arrayList.add(next);
                }
            }
            dfg.removeAll(arrayList);
        }
        int size = dfg.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dfg.get(i);
            if (dVar.dft()) {
                if (!dVar.dfu()) {
                    dVar.uv(true);
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
        if (this.lxS != null) {
            return false;
        }
        String str = null;
        this.lxS = new b();
        boolean deW = this.lxV.deW();
        if (!deW) {
            str = dfL();
        }
        this.lxS.ux(deW);
        this.lxS.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lxS != null) {
            this.lxS.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e lxW = null;
        private boolean lxX = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void ux(boolean z) {
            this.lxX = z;
        }

        public boolean dfM() {
            return this.lxX;
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
        /* renamed from: R */
        public h doInBackground(String... strArr) {
            if (!dfM() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dfM()) {
                this.lxW = new e();
                this.lxW.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dfN();
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
                    this.lxW = new e();
                    this.lxW.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        MG(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.lxT;
        }

        private h dfN() {
            String dfy = this.lxW.dfy();
            if (this.lxW.isRequestSuccess()) {
                SignAllForumModel.this.lxT.parserJson(dfy);
                return SignAllForumModel.this.lxT;
            }
            SignAllForumModel.this.lxT = null;
            this.tokenData = AuthTokenData.parse(dfy);
            return null;
        }

        private h MG(String str) {
            String MD = this.lxW.MD(str);
            if (this.lxW.isRequestSuccess()) {
                SignAllForumModel.this.lxT.parserJson(MD);
                return SignAllForumModel.this.lxT;
            }
            SignAllForumModel.this.lxT = null;
            this.tokenData = AuthTokenData.parse(MD);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.lxW.cancel();
            this.lxW = null;
            SignAllForumModel.this.lxS = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.lxS = null;
            if (SignAllForumModel.this.lxU != null) {
                if (SignAllForumModel.this.lxT != null) {
                    SignAllForumModel.this.lxU.b(SignAllForumModel.this.lxT);
                } else {
                    SignAllForumModel.this.lxU.GX(this.lxW != null ? this.lxW.aPy() : null);
                }
            }
        }
    }
}
