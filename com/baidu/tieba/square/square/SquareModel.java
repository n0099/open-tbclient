package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes23.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long hUf;
    private long hUg;
    private long hUh;
    private long hUi;
    private b mAE;
    private h mAF;
    private a mAG;
    private long mTimeStamp;

    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.mAE = null;
        this.mAF = null;
        this.mAG = null;
        this.hUf = 0L;
        this.hUg = 0L;
        this.hUh = 0L;
        this.hUi = 0L;
        this.mAF = new h();
    }

    public long cmL() {
        return this.hUi;
    }

    public long cmM() {
        return this.hUg;
    }

    public long cmN() {
        return this.hUh;
    }

    public long cmO() {
        return this.hUf;
    }

    public h dDf() {
        return this.mAF;
    }

    public void a(a aVar) {
        this.mAG = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mAE != null) {
            this.mAE.cancel();
            return false;
        }
        return false;
    }

    public boolean dDg() {
        return IL(1);
    }

    public boolean dDh() {
        return IL(0);
    }

    public boolean IL(int i) {
        if (this.mAE != null) {
            return false;
        }
        this.mAE = new b(i);
        this.mAE.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int mAI;
        private com.baidu.tieba.square.b.a mAH = null;
        private l<String> mAJ = null;

        public b(int i) {
            this.mAI = 1;
            this.mAI = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.mAH = new com.baidu.tieba.square.b.a();
            this.mAJ = com.baidu.tbadk.core.c.a.bkE().AF("tb.square");
            if (this.mAI == 0) {
                String str2 = this.mAJ.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dCZ()) {
                    this.mAI = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.mAI == 1) {
                SquareModel.this.hUf = System.currentTimeMillis();
                this.mAH.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.mAH.dCC();
                SquareModel.this.hUg = this.mAH.dCD();
                SquareModel.this.hUh = this.mAH.dCE();
                SquareModel.this.hUi = System.currentTimeMillis();
            }
            if (this.mAH.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.mAJ.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.mAJ.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.be(hVar3.dDc());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.mAJ.set("square_cache_key", hVar4.dDd(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.mAJ.set("square_cache_key", str, 86400000L);
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
            if (this.mAH != null) {
                this.mAH.cancel();
            }
            SquareModel.this.mAE = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.mAE = null;
            SquareModel.this.mAF = hVar;
            if (SquareModel.this.mAG != null) {
                if (this.mAI == 0 || this.mAH.isRequestSuccess()) {
                    SquareModel.this.mAG.a(true, null, hVar);
                    return;
                }
                SquareModel.this.mAG.a(false, this.mAH.bfm(), hVar);
            }
        }
    }
}
