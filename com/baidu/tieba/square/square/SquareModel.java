package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes17.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long hll;
    private long hlm;
    private long hln;
    private long hlo;
    private b lJD;
    private h lJE;
    private a lJF;
    private long mTimeStamp;

    /* loaded from: classes17.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.lJD = null;
        this.lJE = null;
        this.lJF = null;
        this.hll = 0L;
        this.hlm = 0L;
        this.hln = 0L;
        this.hlo = 0L;
        this.lJE = new h();
    }

    public long bVK() {
        return this.hlo;
    }

    public long bVL() {
        return this.hlm;
    }

    public long bVM() {
        return this.hln;
    }

    public long bVN() {
        return this.hll;
    }

    public h djZ() {
        return this.lJE;
    }

    public void a(a aVar) {
        this.lJF = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lJD != null) {
            this.lJD.cancel();
            return false;
        }
        return false;
    }

    public boolean dka() {
        return Ff(1);
    }

    public boolean dkb() {
        return Ff(0);
    }

    public boolean Ff(int i) {
        if (this.lJD != null) {
            return false;
        }
        this.lJD = new b(i);
        this.lJD.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int lJH;
        private com.baidu.tieba.square.b.a lJG = null;
        private l<String> lJI = null;

        public b(int i) {
            this.lJH = 1;
            this.lJH = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.lJG = new com.baidu.tieba.square.b.a();
            this.lJI = com.baidu.tbadk.core.c.a.aYG().xj("tb.square");
            if (this.lJH == 0) {
                String str2 = this.lJI.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.djT()) {
                    this.lJH = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.lJH == 1) {
                SquareModel.this.hll = System.currentTimeMillis();
                this.lJG.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.lJG.djw();
                SquareModel.this.hlm = this.lJG.djx();
                SquareModel.this.hln = this.lJG.djy();
                SquareModel.this.hlo = System.currentTimeMillis();
            }
            if (this.lJG.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.lJI.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.lJI.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aW(hVar3.djW());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.lJI.set("square_cache_key", hVar4.djX(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.lJI.set("square_cache_key", str, 86400000L);
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
            if (this.lJG != null) {
                this.lJG.cancel();
            }
            SquareModel.this.lJD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.lJD = null;
            SquareModel.this.lJE = hVar;
            if (SquareModel.this.lJF != null) {
                if (this.lJH == 0 || this.lJG.isRequestSuccess()) {
                    SquareModel.this.lJF.a(true, null, hVar);
                    return;
                }
                SquareModel.this.lJF.a(false, this.lJG.aTt(), hVar);
            }
        }
    }
}
