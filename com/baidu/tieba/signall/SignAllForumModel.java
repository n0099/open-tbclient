package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gSC;
    private h gSD;
    private a gSE;
    private c gSF;
    public boolean isRunning;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void nr(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gSC = null;
        this.gSD = null;
        this.gSE = null;
        this.gSD = new h();
    }

    public void a(a aVar) {
        this.gSE = aVar;
    }

    public void d(c cVar) {
        this.gSF = cVar;
    }

    public c btI() {
        return this.gSF;
    }

    private String btJ() {
        ArrayList<d> btf = this.gSF.btf();
        if (btf == null) {
            return "";
        }
        if (!this.gSF.btg()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = btf.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.btp() < this.gSF.getLevel()) {
                    arrayList.add(next);
                }
            }
            btf.removeAll(arrayList);
        }
        int size = btf.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = btf.get(i);
            if (dVar.bts()) {
                if (!dVar.btt()) {
                    dVar.mw(true);
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
        if (this.gSC != null) {
            return false;
        }
        String str = null;
        this.gSC = new b();
        boolean bsV = this.gSF.bsV();
        if (!bsV) {
            str = btJ();
        }
        this.gSC.my(bsV);
        this.gSC.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gSC != null) {
            this.gSC.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gSG = null;
        private boolean gSH = false;

        public b() {
            setPriority(3);
        }

        public void my(boolean z) {
            this.gSH = z;
        }

        public boolean btK() {
            return this.gSH;
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
        /* renamed from: A */
        public h doInBackground(String... strArr) {
            if (!btK() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (btK()) {
                this.gSG = new e();
                if (com.baidu.adp.lib.util.j.oJ()) {
                    btL();
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
                    this.gSG = new e();
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        su(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gSD;
        }

        private h btL() {
            String btx = this.gSG.btx();
            if (this.gSG.isRequestSuccess()) {
                SignAllForumModel.this.gSD.parserJson(btx);
                return SignAllForumModel.this.gSD;
            }
            SignAllForumModel.this.gSD = null;
            return null;
        }

        private h su(String str) {
            String sq = this.gSG.sq(str);
            if (this.gSG.isRequestSuccess()) {
                SignAllForumModel.this.gSD.parserJson(sq);
                return SignAllForumModel.this.gSD;
            }
            SignAllForumModel.this.gSD = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gSG.cancel();
            this.gSG = null;
            SignAllForumModel.this.gSC = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gSC = null;
            if (SignAllForumModel.this.gSE != null) {
                if (SignAllForumModel.this.gSD != null) {
                    SignAllForumModel.this.gSE.b(SignAllForumModel.this.gSD);
                } else {
                    SignAllForumModel.this.gSE.nr(this.gSG != null ? this.gSG.xm() : null);
                }
            }
        }
    }
}
