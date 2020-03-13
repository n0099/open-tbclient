package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long fWG;
    private long fWH;
    private long fWI;
    private long fWJ;
    private b kdt;
    private h kdu;
    private a kdv;
    private long mTimeStamp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.kdt = null;
        this.kdu = null;
        this.kdv = null;
        this.fWG = 0L;
        this.fWH = 0L;
        this.fWI = 0L;
        this.fWJ = 0L;
        this.kdu = new h();
    }

    public long byN() {
        return this.fWJ;
    }

    public long byO() {
        return this.fWH;
    }

    public long byP() {
        return this.fWI;
    }

    public long byQ() {
        return this.fWG;
    }

    public h cJT() {
        return this.kdu;
    }

    public void a(a aVar) {
        this.kdv = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kdt != null) {
            this.kdt.cancel();
            return false;
        }
        return false;
    }

    public boolean cJU() {
        return Cl(1);
    }

    public boolean cJV() {
        return Cl(0);
    }

    public boolean Cl(int i) {
        if (this.kdt != null) {
            return false;
        }
        this.kdt = new b(i);
        this.kdt.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int kdx;
        private com.baidu.tieba.square.a.a kdw = null;
        private l<String> kdy = null;

        public b(int i) {
            this.kdx = 1;
            this.kdx = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.kdw = new com.baidu.tieba.square.a.a();
            this.kdy = com.baidu.tbadk.core.c.a.aEB().sQ("tb.square");
            if (this.kdx == 0) {
                String str2 = this.kdy.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.cJN()) {
                    this.kdx = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.kdx == 1) {
                SquareModel.this.fWG = System.currentTimeMillis();
                this.kdw.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.kdw.cJr();
                SquareModel.this.fWH = this.kdw.cJs();
                SquareModel.this.fWI = this.kdw.cJt();
                SquareModel.this.fWJ = System.currentTimeMillis();
            }
            if (this.kdw.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.kdy.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.kdy.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aR(hVar3.cJQ());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.kdy.set("square_cache_key", hVar4.cJR(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.kdy.set("square_cache_key", str, 86400000L);
                        hVar = hVar3;
                    }
                }
                SquareModel.this.mTimeStamp = valueOf.longValue();
            }
            return hVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.kdw != null) {
                this.kdw.cancel();
            }
            SquareModel.this.kdt = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.kdt = null;
            SquareModel.this.kdu = hVar;
            if (SquareModel.this.kdv != null) {
                if (this.kdx == 0 || this.kdw.isRequestSuccess()) {
                    SquareModel.this.kdv.a(true, null, hVar);
                    return;
                }
                SquareModel.this.kdv.a(false, this.kdw.azM(), hVar);
            }
        }
    }
}
