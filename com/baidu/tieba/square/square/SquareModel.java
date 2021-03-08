package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long iNA;
    private long iNB;
    private long iNy;
    private long iNz;
    private long mTimeStamp;
    private h nvA;
    private a nvB;
    private b nvz;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.nvz = null;
        this.nvA = null;
        this.nvB = null;
        this.iNy = 0L;
        this.iNz = 0L;
        this.iNA = 0L;
        this.iNB = 0L;
        this.nvA = new h();
    }

    public long cwN() {
        return this.iNB;
    }

    public long cwO() {
        return this.iNz;
    }

    public long cwP() {
        return this.iNA;
    }

    public long cwQ() {
        return this.iNy;
    }

    public h dMz() {
        return this.nvA;
    }

    public void a(a aVar) {
        this.nvB = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nvz != null) {
            this.nvz.cancel();
            return false;
        }
        return false;
    }

    public boolean dMA() {
        return Ju(1);
    }

    public boolean dMB() {
        return Ju(0);
    }

    public boolean Ju(int i) {
        if (this.nvz != null) {
            return false;
        }
        this.nvz = new b(i);
        this.nvz.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int nvD;
        private com.baidu.tieba.square.a.a nvC = null;
        private l<String> nvE = null;

        public b(int i) {
            this.nvD = 1;
            this.nvD = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str;
            h hVar2;
            this.nvC = new com.baidu.tieba.square.a.a();
            this.nvE = com.baidu.tbadk.core.c.a.bqt().Az("tb.square");
            if (this.nvD == 0) {
                str = this.nvE.get("square_cache_key");
                if (str == null) {
                    return null;
                }
                hVar = new h();
                hVar.parserJson(str);
                SquareModel.this.mTimeStamp = hVar.getTimeStamp();
                if (hVar.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar.dMt()) {
                    this.nvD = 1;
                } else {
                    return hVar;
                }
            } else {
                hVar = null;
                str = null;
            }
            if (this.nvD == 1) {
                SquareModel.this.iNy = System.currentTimeMillis();
                this.nvC.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.nvC.dLW();
                SquareModel.this.iNz = this.nvC.dLX();
                SquareModel.this.iNA = this.nvC.dLY();
                SquareModel.this.iNB = System.currentTimeMillis();
            }
            String str2 = str;
            if (this.nvC.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str2);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.nvE.set("square_cache_key", str2, 86400000L);
                    hVar2 = hVar3;
                } else {
                    String str3 = this.nvE.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.be(hVar3.dMw());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.nvE.set("square_cache_key", hVar4.dMx(), 86400000L);
                        hVar2 = hVar4;
                    } else {
                        this.nvE.set("square_cache_key", str2, 86400000L);
                        hVar2 = hVar3;
                    }
                }
                SquareModel.this.mTimeStamp = valueOf.longValue();
            } else {
                hVar2 = hVar;
            }
            return hVar2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.nvC != null) {
                this.nvC.cancel();
            }
            SquareModel.this.nvz = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.nvz = null;
            SquareModel.this.nvA = hVar;
            if (SquareModel.this.nvB != null) {
                if (this.nvD == 0 || this.nvC.isRequestSuccess()) {
                    SquareModel.this.nvB.a(true, null, hVar);
                    return;
                }
                SquareModel.this.nvB.a(false, this.nvC.bkT(), hVar);
            }
        }
    }
}
