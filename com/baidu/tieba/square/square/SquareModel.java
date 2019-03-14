package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long aYH;
    private long eDP;
    private long eDQ;
    private long eDR;
    private long eDS;
    private b iCS;
    private f iCT;
    private a iCU;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.iCS = null;
        this.iCT = null;
        this.iCU = null;
        this.eDP = 0L;
        this.eDQ = 0L;
        this.eDR = 0L;
        this.eDS = 0L;
        this.iCT = new f();
    }

    public long aWR() {
        return this.eDS;
    }

    public long aWS() {
        return this.eDQ;
    }

    public long aWT() {
        return this.eDR;
    }

    public long aWU() {
        return this.eDP;
    }

    public f cdl() {
        return this.iCT;
    }

    public void a(a aVar) {
        this.iCU = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iCS != null) {
            this.iCS.cancel();
            return false;
        }
        return false;
    }

    public boolean cdm() {
        return zh(1);
    }

    public boolean cdn() {
        return zh(0);
    }

    public boolean zh(int i) {
        if (this.iCS != null) {
            return false;
        }
        this.iCS = new b(i);
        this.iCS.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int iCW;
        private com.baidu.tieba.square.a.a iCV = null;
        private l<String> iCX = null;

        public b(int i) {
            this.iCW = 1;
            this.iCW = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.iCV = new com.baidu.tieba.square.a.a();
            this.iCX = com.baidu.tbadk.core.c.a.aaW().lv("tb.square");
            if (this.iCW == 0) {
                String str2 = this.iCX.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.aYH = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.aYH = 0L;
                }
                if (!fVar2.cdg()) {
                    this.iCW = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.iCW == 1) {
                SquareModel.this.eDP = System.currentTimeMillis();
                this.iCV.x("prevtime", SquareModel.this.aYH + "");
                str = this.iCV.ccH();
                SquareModel.this.eDQ = this.iCV.ccI();
                SquareModel.this.eDR = this.iCV.ccJ();
                SquareModel.this.eDS = System.currentTimeMillis();
            }
            if (this.iCV.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.aYH) {
                    this.iCX.a("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.iCX.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aA(fVar3.cdj());
                        fVar4.dO(valueOf.longValue());
                        this.iCX.a("square_cache_key", fVar4.aIQ(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.iCX.a("square_cache_key", str, 86400000L);
                        fVar = fVar3;
                    }
                }
                SquareModel.this.aYH = valueOf.longValue();
            }
            return fVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.iCV != null) {
                this.iCV.cancel();
            }
            SquareModel.this.iCS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.iCS = null;
            SquareModel.this.iCT = fVar;
            if (SquareModel.this.iCU != null) {
                if (this.iCW == 0 || this.iCV.isRequestSuccess()) {
                    SquareModel.this.iCU.a(true, null, fVar);
                    return;
                }
                SquareModel.this.iCU.a(false, this.iCV.Ww(), fVar);
            }
        }
    }
}
