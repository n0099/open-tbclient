package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public boolean isRunning;
    private b jak;
    private h jal;
    private a jam;
    private c jan;
    private String mAuthSid;

    /* loaded from: classes6.dex */
    public interface a {
        void b(h hVar);

        void xR(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.jak = null;
        this.jal = null;
        this.jam = null;
        this.jal = new h();
    }

    public void a(a aVar) {
        this.jam = aVar;
    }

    public void d(c cVar) {
        this.jan = cVar;
    }

    public c cmi() {
        return this.jan;
    }

    private String cmj() {
        ArrayList<d> clE = this.jan.clE();
        if (clE == null) {
            return "";
        }
        if (!this.jan.clF()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = clE.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.clO() < this.jan.getLevel()) {
                    arrayList.add(next);
                }
            }
            clE.removeAll(arrayList);
        }
        int size = clE.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = clE.get(i);
            if (dVar.clR()) {
                if (!dVar.clS()) {
                    dVar.qD(true);
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
        if (this.jak != null) {
            return false;
        }
        String str = null;
        this.jak = new b();
        boolean clu = this.jan.clu();
        if (!clu) {
            str = cmj();
        }
        this.jak.qF(clu);
        this.jak.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jak != null) {
            this.jak.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e jao = null;
        private boolean jap = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void qF(boolean z) {
            this.jap = z;
        }

        public boolean cmk() {
            return this.jap;
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
        /* renamed from: F */
        public h doInBackground(String... strArr) {
            if (!cmk() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cmk()) {
                this.jao = new e();
                this.jao.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cml();
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
                    this.jao = new e();
                    this.jao.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Dz(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.jal;
        }

        private h cml() {
            String clW = this.jao.clW();
            if (this.jao.isRequestSuccess()) {
                SignAllForumModel.this.jal.parserJson(clW);
                return SignAllForumModel.this.jal;
            }
            SignAllForumModel.this.jal = null;
            this.tokenData = AuthTokenData.parse(clW);
            return null;
        }

        private h Dz(String str) {
            String Dw = this.jao.Dw(str);
            if (this.jao.isRequestSuccess()) {
                SignAllForumModel.this.jal.parserJson(Dw);
                return SignAllForumModel.this.jal;
            }
            SignAllForumModel.this.jal = null;
            this.tokenData = AuthTokenData.parse(Dw);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.jao.cancel();
            this.jao = null;
            SignAllForumModel.this.jak = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.jak = null;
            if (SignAllForumModel.this.jam != null) {
                if (SignAllForumModel.this.jal != null) {
                    SignAllForumModel.this.jam.b(SignAllForumModel.this.jal);
                } else {
                    SignAllForumModel.this.jam.xR(this.jao != null ? this.jao.agm() : null);
                }
            }
        }
    }
}
