package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long fQP;
    private long fQQ;
    private long fQR;
    private long fQS;
    private a jYA;
    private b jYy;
    private h jYz;
    private long mTimeStamp;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.jYy = null;
        this.jYz = null;
        this.jYA = null;
        this.fQP = 0L;
        this.fQQ = 0L;
        this.fQR = 0L;
        this.fQS = 0L;
        this.jYz = new h();
    }

    public long bwd() {
        return this.fQS;
    }

    public long bwe() {
        return this.fQQ;
    }

    public long bwf() {
        return this.fQR;
    }

    public long bwg() {
        return this.fQP;
    }

    public h cHg() {
        return this.jYz;
    }

    public void a(a aVar) {
        this.jYA = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jYy != null) {
            this.jYy.cancel();
            return false;
        }
        return false;
    }

    public boolean cHh() {
        return BZ(1);
    }

    public boolean cHi() {
        return BZ(0);
    }

    public boolean BZ(int i) {
        if (this.jYy != null) {
            return false;
        }
        this.jYy = new b(i);
        this.jYy.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int jYC;
        private com.baidu.tieba.square.a.a jYB = null;
        private l<String> jYD = null;

        public b(int i) {
            this.jYC = 1;
            this.jYC = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.jYB = new com.baidu.tieba.square.a.a();
            this.jYD = com.baidu.tbadk.core.c.a.aBV().sx("tb.square");
            if (this.jYC == 0) {
                String str2 = this.jYD.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.cHa()) {
                    this.jYC = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.jYC == 1) {
                SquareModel.this.fQP = System.currentTimeMillis();
                this.jYB.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.jYB.cGE();
                SquareModel.this.fQQ = this.jYB.cGF();
                SquareModel.this.fQR = this.jYB.cGG();
                SquareModel.this.fQS = System.currentTimeMillis();
            }
            if (this.jYB.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.jYD.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.jYD.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aS(hVar3.cHd());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.jYD.set("square_cache_key", hVar4.cHe(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.jYD.set("square_cache_key", str, 86400000L);
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
            if (this.jYB != null) {
                this.jYB.cancel();
            }
            SquareModel.this.jYy = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.jYy = null;
            SquareModel.this.jYz = hVar;
            if (SquareModel.this.jYA != null) {
                if (this.jYC == 0 || this.jYB.isRequestSuccess()) {
                    SquareModel.this.jYA.a(true, null, hVar);
                    return;
                }
                SquareModel.this.jYA.a(false, this.jYB.axd(), hVar);
            }
        }
    }
}
