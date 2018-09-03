package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    private b gFE;
    private h gFF;
    private a gFG;
    private c gFH;
    public boolean isRunning;

    /* loaded from: classes3.dex */
    public interface a {
        void b(h hVar);

        void or(String str);
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gFE = null;
        this.gFF = null;
        this.gFG = null;
        this.gFF = new h();
    }

    public void a(a aVar) {
        this.gFG = aVar;
    }

    public void d(c cVar) {
        this.gFH = cVar;
    }

    public c bsU() {
        return this.gFH;
    }

    private String bsV() {
        ArrayList<d> bsr = this.gFH.bsr();
        if (bsr == null) {
            return "";
        }
        if (!this.gFH.bss()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = bsr.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.bsB() < this.gFH.getLevel()) {
                    arrayList.add(next);
                }
            }
            bsr.removeAll(arrayList);
        }
        int size = bsr.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = bsr.get(i);
            if (dVar.bsE()) {
                if (!dVar.bsF()) {
                    dVar.mf(true);
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
        if (this.gFE != null) {
            return false;
        }
        String str = null;
        this.gFE = new b();
        boolean bsh = this.gFH.bsh();
        if (!bsh) {
            str = bsV();
        }
        this.gFE.mh(bsh);
        this.gFE.execute(str);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gFE != null) {
            this.gFE.cancel();
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Integer, h> {
        private e gFI = null;
        private boolean gFJ = false;

        public b() {
            setPriority(3);
        }

        public void mh(boolean z) {
            this.gFJ = z;
        }

        public boolean bsW() {
            return this.gFJ;
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
        /* renamed from: B */
        public h doInBackground(String... strArr) {
            if (!bsW() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                return null;
            }
            if (bsW()) {
                this.gFI = new e();
                if (com.baidu.adp.lib.util.j.jE()) {
                    bsX();
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
                    this.gFI = new e();
                    if (com.baidu.adp.lib.util.j.jE()) {
                        tw(sb.toString());
                    }
                }
            }
            return SignAllForumModel.this.gFF;
        }

        private h bsX() {
            String bsJ = this.gFI.bsJ();
            if (this.gFI.isRequestSuccess()) {
                SignAllForumModel.this.gFF.parserJson(bsJ);
                return SignAllForumModel.this.gFF;
            }
            SignAllForumModel.this.gFF = null;
            return null;
        }

        private h tw(String str) {
            String tt = this.gFI.tt(str);
            if (this.gFI.isRequestSuccess()) {
                SignAllForumModel.this.gFF.parserJson(tt);
                return SignAllForumModel.this.gFF;
            }
            SignAllForumModel.this.gFF = null;
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.gFI.cancel();
            this.gFI = null;
            SignAllForumModel.this.gFE = null;
            SignAllForumModel.this.isRunning = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            SignAllForumModel.this.isRunning = false;
            SignAllForumModel.this.gFE = null;
            if (SignAllForumModel.this.gFG != null) {
                if (SignAllForumModel.this.gFF != null) {
                    SignAllForumModel.this.gFG.b(SignAllForumModel.this.gFF);
                } else {
                    SignAllForumModel.this.gFG.or(this.gFI != null ? this.gFI.tb() : null);
                }
            }
        }
    }
}
