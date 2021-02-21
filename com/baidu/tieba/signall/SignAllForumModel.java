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
    private b noZ;
    private h npa;
    private a npb;
    private c npc;

    /* loaded from: classes8.dex */
    public interface a {
        void MV(String str);

        void b(h hVar);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.noZ = null;
        this.npa = null;
        this.npb = null;
        this.npa = new h();
    }

    public void a(a aVar) {
        this.npb = aVar;
    }

    public void d(c cVar) {
        this.npc = cVar;
    }

    public c dLk() {
        return this.npc;
    }

    private String dLl() {
        ArrayList<d> dKH = this.npc.dKH();
        if (dKH == null) {
            return "";
        }
        if (!this.npc.dKI()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = dKH.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bKC() < this.npc.getLevel()) {
                    arrayList.add(next);
                }
            }
            dKH.removeAll(arrayList);
        }
        int size = dKH.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = dKH.get(i);
            if (dVar.dKT()) {
                if (!dVar.dKU()) {
                    dVar.ye(true);
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
        if (this.noZ != null) {
            return false;
        }
        String str = null;
        this.noZ = new b();
        boolean dKx = this.npc.dKx();
        if (!dKx) {
            str = dLl();
        }
        this.noZ.yg(dKx);
        this.noZ.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.noZ != null) {
            this.noZ.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e npd = null;
        private boolean npe = false;
        private AuthTokenData tokenData;

        public b() {
            setPriority(3);
        }

        public void yg(boolean z) {
            this.npe = z;
        }

        public boolean dLm() {
            return this.npe;
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
            if (!dLm() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (dLm()) {
                this.npd = new e();
                this.npd.setAuthSid(SignAllForumModel.this.mAuthSid);
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    dLn();
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
                    this.npd = new e();
                    this.npd.setAuthSid(SignAllForumModel.this.mAuthSid);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SP(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.npa;
        }

        private h dLn() {
            String dKY = this.npd.dKY();
            if (this.npd.isRequestSuccess()) {
                SignAllForumModel.this.npa.parserJson(dKY);
                return SignAllForumModel.this.npa;
            }
            SignAllForumModel.this.npa = null;
            this.tokenData = AuthTokenData.parse(dKY);
            return null;
        }

        private h SP(String str) {
            String SM = this.npd.SM(str);
            if (this.npd.isRequestSuccess()) {
                SignAllForumModel.this.npa.parserJson(SM);
                return SignAllForumModel.this.npa;
            }
            SignAllForumModel.this.npa = null;
            this.tokenData = AuthTokenData.parse(SM);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.npd.cancel();
            this.npd = null;
            SignAllForumModel.this.noZ = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.noZ = null;
            if (SignAllForumModel.this.npb != null) {
                if (SignAllForumModel.this.npa != null) {
                    SignAllForumModel.this.npb.b(SignAllForumModel.this.npa);
                } else {
                    SignAllForumModel.this.npb.MV(this.npd != null ? this.npd.bkR() : null);
                }
            }
        }
    }
}
