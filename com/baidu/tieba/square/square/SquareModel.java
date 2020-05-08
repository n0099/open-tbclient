package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long gDY;
    private long gDZ;
    private long gEa;
    private long gEb;
    private b kOT;
    private h kOU;
    private a kOV;
    private long mTimeStamp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.kOT = null;
        this.kOU = null;
        this.kOV = null;
        this.gDY = 0L;
        this.gDZ = 0L;
        this.gEa = 0L;
        this.gEb = 0L;
        this.kOU = new h();
    }

    public long bIT() {
        return this.gEb;
    }

    public long bIU() {
        return this.gDZ;
    }

    public long bIV() {
        return this.gEa;
    }

    public long bIW() {
        return this.gDY;
    }

    public h cVg() {
        return this.kOU;
    }

    public void a(a aVar) {
        this.kOV = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kOT != null) {
            this.kOT.cancel();
            return false;
        }
        return false;
    }

    public boolean cVh() {
        return CV(1);
    }

    public boolean cVi() {
        return CV(0);
    }

    public boolean CV(int i) {
        if (this.kOT != null) {
            return false;
        }
        this.kOT = new b(i);
        this.kOT.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int kOX;
        private com.baidu.tieba.square.b.a kOW = null;
        private l<String> kOY = null;

        public b(int i) {
            this.kOX = 1;
            this.kOX = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.kOW = new com.baidu.tieba.square.b.a();
            this.kOY = com.baidu.tbadk.core.c.a.aMR().ug("tb.square");
            if (this.kOX == 0) {
                String str2 = this.kOY.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.cVa()) {
                    this.kOX = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.kOX == 1) {
                SquareModel.this.gDY = System.currentTimeMillis();
                this.kOW.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.kOW.cUD();
                SquareModel.this.gDZ = this.kOW.cUE();
                SquareModel.this.gEa = this.kOW.cUF();
                SquareModel.this.gEb = System.currentTimeMillis();
            }
            if (this.kOW.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.kOY.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.kOY.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aT(hVar3.cVd());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.kOY.set("square_cache_key", hVar4.cVe(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.kOY.set("square_cache_key", str, 86400000L);
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
            if (this.kOW != null) {
                this.kOW.cancel();
            }
            SquareModel.this.kOT = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.kOT = null;
            SquareModel.this.kOU = hVar;
            if (SquareModel.this.kOV != null) {
                if (this.kOX == 0 || this.kOW.isRequestSuccess()) {
                    SquareModel.this.kOV.a(true, null, hVar);
                    return;
                }
                SquareModel.this.kOV.a(false, this.kOW.aIa(), hVar);
            }
        }
    }
}
