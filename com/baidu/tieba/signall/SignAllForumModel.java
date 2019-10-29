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
    private b jbb;
    private h jbc;
    private a jbd;
    private c jbe;
    private String mAuthSid;

    /* loaded from: classes6.dex */
    public interface a {
        void b(h hVar);

        void xR(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.jbb = null;
        this.jbc = null;
        this.jbd = null;
        this.jbc = new h();
    }

    public void a(a aVar) {
        this.jbd = aVar;
    }

    public void d(c cVar) {
        this.jbe = cVar;
    }

    public c cmk() {
        return this.jbe;
    }

    private String cml() {
        ArrayList<d> clG = this.jbe.clG();
        if (clG == null) {
            return "";
        }
        if (!this.jbe.clH()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = clG.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.clQ() < this.jbe.getLevel()) {
                    arrayList.add(next);
                }
            }
            clG.removeAll(arrayList);
        }
        int size = clG.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = clG.get(i);
            if (dVar.clT()) {
                if (!dVar.clU()) {
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
        if (this.jbb != null) {
            return false;
        }
        String str = null;
        this.jbb = new b();
        boolean clw = this.jbe.clw();
        if (!clw) {
            str = cml();
        }
        this.jbb.qF(clw);
        this.jbb.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jbb != null) {
            this.jbb.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e jbf = null;
        private boolean jbg = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void qF(boolean z) {
            this.jbg = z;
        }

        public boolean cmm() {
            return this.jbg;
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
            if (!cmm() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (cmm()) {
                this.jbf = new e();
                this.jbf.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    cmn();
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
                    this.jbf = new e();
                    this.jbf.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        Dz(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.jbc;
        }

        private h cmn() {
            String clY = this.jbf.clY();
            if (this.jbf.isRequestSuccess()) {
                SignAllForumModel.this.jbc.parserJson(clY);
                return SignAllForumModel.this.jbc;
            }
            SignAllForumModel.this.jbc = null;
            this.tokenData = AuthTokenData.parse(clY);
            return null;
        }

        private h Dz(String str) {
            String Dw = this.jbf.Dw(str);
            if (this.jbf.isRequestSuccess()) {
                SignAllForumModel.this.jbc.parserJson(Dw);
                return SignAllForumModel.this.jbc;
            }
            SignAllForumModel.this.jbc = null;
            this.tokenData = AuthTokenData.parse(Dw);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.jbf.cancel();
            this.jbf = null;
            SignAllForumModel.this.jbb = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.jbb = null;
            if (SignAllForumModel.this.jbd != null) {
                if (SignAllForumModel.this.jbc != null) {
                    SignAllForumModel.this.jbd.b(SignAllForumModel.this.jbc);
                } else {
                    SignAllForumModel.this.jbd.xR(this.jbf != null ? this.jbf.ago() : null);
                }
            }
        }
    }
}
