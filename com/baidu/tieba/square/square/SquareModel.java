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
    private b kcg;
    private h kch;
    private a kci;
    private long mTimeStamp;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.kcg = null;
        this.kch = null;
        this.kci = null;
        this.fTZ = 0L;
        this.fUa = 0L;
        this.fUb = 0L;
        this.fUc = 0L;
        this.kch = new h();
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

    public h cIm() {
        return this.kch;
    }

    public void a(a aVar) {
        this.kci = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kcg != null) {
            this.kcg.cancel();
            return false;
        }
        return false;
    }

    public boolean cIn() {
        return Ce(1);
    }

    public boolean cIo() {
        return Ce(0);
    }

    public boolean Ce(int i) {
        if (this.kcg != null) {
            return false;
        }
        this.kcg = new b(i);
        this.kcg.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int kck;
        private com.baidu.tieba.square.a.a kcj = null;
        private l<String> kcl = null;

        public b(int i) {
            this.kck = 1;
            this.kck = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.kcj = new com.baidu.tieba.square.a.a();
            this.kcl = com.baidu.tbadk.core.c.a.aCo().sA("tb.square");
            if (this.kck == 0) {
                String str2 = this.kcl.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.cIg()) {
                    this.kck = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.kck == 1) {
                SquareModel.this.fTZ = System.currentTimeMillis();
                this.kcj.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.kcj.cHK();
                SquareModel.this.fUa = this.kcj.cHL();
                SquareModel.this.fUb = this.kcj.cHM();
                SquareModel.this.fUc = System.currentTimeMillis();
            }
            if (this.kcj.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.kcl.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.kcl.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aS(hVar3.cIj());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.kcl.set("square_cache_key", hVar4.cIk(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.kcl.set("square_cache_key", str, 86400000L);
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
            if (this.kcj != null) {
                this.kcj.cancel();
            }
            SquareModel.this.kcg = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.kcg = null;
            SquareModel.this.kch = hVar;
            if (SquareModel.this.kci != null) {
                if (this.kck == 0 || this.kcj.isRequestSuccess()) {
                    SquareModel.this.kci.a(true, null, hVar);
                    return;
                }
                SquareModel.this.kci.a(false, this.kcj.axw(), hVar);
            }
        }
    }
}
