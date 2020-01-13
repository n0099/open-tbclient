package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long fTZ;
    private long fUa;
    private long fUb;
    private long fUc;
    private b kcb;
    private h kcc;
    private a kcd;
    private long mTimeStamp;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.kcb = null;
        this.kcc = null;
        this.kcd = null;
        this.fTZ = 0L;
        this.fUa = 0L;
        this.fUb = 0L;
        this.fUc = 0L;
        this.kcc = new h();
    }

    public long bxf() {
        return this.fUc;
    }

    public long bxg() {
        return this.fUa;
    }

    public long bxh() {
        return this.fUb;
    }

    public long bxi() {
        return this.fTZ;
    }

    public h cIk() {
        return this.kcc;
    }

    public void a(a aVar) {
        this.kcd = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kcb != null) {
            this.kcb.cancel();
            return false;
        }
        return false;
    }

    public boolean cIl() {
        return Ce(1);
    }

    public boolean cIm() {
        return Ce(0);
    }

    public boolean Ce(int i) {
        if (this.kcb != null) {
            return false;
        }
        this.kcb = new b(i);
        this.kcb.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int kcf;
        private com.baidu.tieba.square.a.a kce = null;
        private l<String> kcg = null;

        public b(int i) {
            this.kcf = 1;
            this.kcf = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.kce = new com.baidu.tieba.square.a.a();
            this.kcg = com.baidu.tbadk.core.c.a.aCo().sA("tb.square");
            if (this.kcf == 0) {
                String str2 = this.kcg.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.cIe()) {
                    this.kcf = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.kcf == 1) {
                SquareModel.this.fTZ = System.currentTimeMillis();
                this.kce.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.kce.cHI();
                SquareModel.this.fUa = this.kce.cHJ();
                SquareModel.this.fUb = this.kce.cHK();
                SquareModel.this.fUc = System.currentTimeMillis();
            }
            if (this.kce.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.kcg.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.kcg.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aS(hVar3.cIh());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.kcg.set("square_cache_key", hVar4.cIi(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.kcg.set("square_cache_key", str, 86400000L);
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
            if (this.kce != null) {
                this.kce.cancel();
            }
            SquareModel.this.kcb = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.kcb = null;
            SquareModel.this.kcc = hVar;
            if (SquareModel.this.kcd != null) {
                if (this.kcf == 0 || this.kce.isRequestSuccess()) {
                    SquareModel.this.kcd.a(true, null, hVar);
                    return;
                }
                SquareModel.this.kcd.a(false, this.kce.axw(), hVar);
            }
        }
    }
}
