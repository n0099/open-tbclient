package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long aYK;
    private long eDA;
    private long eDB;
    private long eDC;
    private long eDD;
    private b iCC;
    private f iCD;
    private a iCE;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.iCC = null;
        this.iCD = null;
        this.iCE = null;
        this.eDA = 0L;
        this.eDB = 0L;
        this.eDC = 0L;
        this.eDD = 0L;
        this.iCD = new f();
    }

    public long aWP() {
        return this.eDD;
    }

    public long aWQ() {
        return this.eDB;
    }

    public long aWR() {
        return this.eDC;
    }

    public long aWS() {
        return this.eDA;
    }

    public f cdh() {
        return this.iCD;
    }

    public void a(a aVar) {
        this.iCE = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iCC != null) {
            this.iCC.cancel();
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
        if (this.iCC != null) {
            return false;
        }
        this.iCC = new b(i);
        this.iCC.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int iCG;
        private com.baidu.tieba.square.a.a iCF = null;
        private l<String> iCH = null;

        public b(int i) {
            this.iCG = 1;
            this.iCG = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.iCF = new com.baidu.tieba.square.a.a();
            this.iCH = com.baidu.tbadk.core.c.a.aaT().lw("tb.square");
            if (this.iCG == 0) {
                String str2 = this.iCH.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.aYK = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.aYK = 0L;
                }
                if (!fVar2.cdc()) {
                    this.iCG = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.iCG == 1) {
                SquareModel.this.eDA = System.currentTimeMillis();
                this.iCF.x("prevtime", SquareModel.this.aYK + "");
                str = this.iCF.ccD();
                SquareModel.this.eDB = this.iCF.ccE();
                SquareModel.this.eDC = this.iCF.ccF();
                SquareModel.this.eDD = System.currentTimeMillis();
            }
            if (this.iCF.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.aYK) {
                    this.iCH.a("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.iCH.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aA(fVar3.cdf());
                        fVar4.dO(valueOf.longValue());
                        this.iCH.a("square_cache_key", fVar4.aIF(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.iCH.a("square_cache_key", str, 86400000L);
                        fVar = fVar3;
                    }
                }
                SquareModel.this.aYK = valueOf.longValue();
            }
            return fVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.iCF != null) {
                this.iCF.cancel();
            }
            SquareModel.this.iCC = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.iCC = null;
            SquareModel.this.iCD = fVar;
            if (SquareModel.this.iCE != null) {
                if (this.iCG == 0 || this.iCF.isRequestSuccess()) {
                    SquareModel.this.iCE.a(true, null, fVar);
                    return;
                }
                SquareModel.this.iCE.a(false, this.iCF.Wt(), fVar);
            }
        }
    }
}
