package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long aYL;
    private long eDB;
    private long eDC;
    private long eDD;
    private long eDE;
    private b iCD;
    private f iCE;
    private a iCF;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.iCD = null;
        this.iCE = null;
        this.iCF = null;
        this.eDB = 0L;
        this.eDC = 0L;
        this.eDD = 0L;
        this.eDE = 0L;
        this.iCE = new f();
    }

    public long aWP() {
        return this.eDE;
    }

    public long aWQ() {
        return this.eDC;
    }

    public long aWR() {
        return this.eDD;
    }

    public long aWS() {
        return this.eDB;
    }

    public f cdh() {
        return this.iCE;
    }

    public void a(a aVar) {
        this.iCF = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iCD != null) {
            this.iCD.cancel();
            return false;
        }
        return false;
    }

    public boolean cdi() {
        return zd(1);
    }

    public boolean cdj() {
        return zd(0);
    }

    public boolean zd(int i) {
        if (this.iCD != null) {
            return false;
        }
        this.iCD = new b(i);
        this.iCD.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int iCH;
        private com.baidu.tieba.square.a.a iCG = null;
        private l<String> iCI = null;

        public b(int i) {
            this.iCH = 1;
            this.iCH = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.iCG = new com.baidu.tieba.square.a.a();
            this.iCI = com.baidu.tbadk.core.c.a.aaT().lw("tb.square");
            if (this.iCH == 0) {
                String str2 = this.iCI.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.aYL = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.aYL = 0L;
                }
                if (!fVar2.cdc()) {
                    this.iCH = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.iCH == 1) {
                SquareModel.this.eDB = System.currentTimeMillis();
                this.iCG.x("prevtime", SquareModel.this.aYL + "");
                str = this.iCG.ccD();
                SquareModel.this.eDC = this.iCG.ccE();
                SquareModel.this.eDD = this.iCG.ccF();
                SquareModel.this.eDE = System.currentTimeMillis();
            }
            if (this.iCG.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.aYL) {
                    this.iCI.a("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.iCI.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aA(fVar3.cdf());
                        fVar4.dO(valueOf.longValue());
                        this.iCI.a("square_cache_key", fVar4.aIF(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.iCI.a("square_cache_key", str, 86400000L);
                        fVar = fVar3;
                    }
                }
                SquareModel.this.aYL = valueOf.longValue();
            }
            return fVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.iCG != null) {
                this.iCG.cancel();
            }
            SquareModel.this.iCD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.iCD = null;
            SquareModel.this.iCE = fVar;
            if (SquareModel.this.iCF != null) {
                if (this.iCH == 0 || this.iCG.isRequestSuccess()) {
                    SquareModel.this.iCF.a(true, null, fVar);
                    return;
                }
                SquareModel.this.iCF.a(false, this.iCG.Wt(), fVar);
            }
        }
    }
}
