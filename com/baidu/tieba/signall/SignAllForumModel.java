package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gSS;
    private h gST;
    private a gSU;
    private c gSV;
    public boolean isRunning;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void nr(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gSS = null;
        this.gST = null;
        this.gSU = null;
        this.gST = new h();
    }

    public void a(a aVar) {
        this.gSU = aVar;
    }

    public void d(c cVar) {
        this.gSV = cVar;
    }

    public c btJ() {
        return this.gSV;
    }

    private String btK() {
        ArrayList<d> btg = this.gSV.btg();
        if (btg == null) {
            return "";
        }
        if (!this.gSV.bth()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = btg.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.btq() < this.gSV.getLevel()) {
                    arrayList.add(next);
                }
            }
            btg.removeAll(arrayList);
        }
        int size = btg.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = btg.get(i);
            if (dVar.btt()) {
                if (!dVar.btu()) {
                    dVar.mB(true);
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
        if (this.gSS != null) {
            return false;
        }
        String str = null;
        this.gSS = new b();
        boolean bsW = this.gSV.bsW();
        if (!bsW) {
            str = btK();
        }
        this.gSS.mD(bsW);
        this.gSS.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gSS != null) {
            this.gSS.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gSW = null;
        private boolean gSX = false;

        public b() {
            setPriority(3);
        }

        public void mD(boolean z) {
            this.gSX = z;
        }

        public boolean btL() {
            return this.gSX;
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
            if (!btL() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (btL()) {
                this.gSW = new e();
                if (com.baidu.adp.lib.util.j.oJ()) {
                    btM();
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
                    this.gSW = new e();
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        su(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gST;
        }

        private h btM() {
            String bty = this.gSW.bty();
            if (this.gSW.isRequestSuccess()) {
                SignAllForumModel.this.gST.parserJson(bty);
                return SignAllForumModel.this.gST;
            }
            SignAllForumModel.this.gST = null;
            return null;
        }

        private h su(String str) {
            String sq = this.gSW.sq(str);
            if (this.gSW.isRequestSuccess()) {
                SignAllForumModel.this.gST.parserJson(sq);
                return SignAllForumModel.this.gST;
            }
            SignAllForumModel.this.gST = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gSW.cancel();
            this.gSW = null;
            SignAllForumModel.this.gSS = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gSS = null;
            if (SignAllForumModel.this.gSU != null) {
                if (SignAllForumModel.this.gST != null) {
                    SignAllForumModel.this.gSU.b(SignAllForumModel.this.gST);
                } else {
                    SignAllForumModel.this.gSU.nr(this.gSW != null ? this.gSW.xm() : null);
                }
            }
        }
    }
}
