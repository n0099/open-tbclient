package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long bcI;
    private long far;
    private long fas;
    private long fat;
    private long fau;
    private b jfm;
    private f jfn;
    private a jfo;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.jfm = null;
        this.jfn = null;
        this.jfo = null;
        this.far = 0L;
        this.fas = 0L;
        this.fat = 0L;
        this.fau = 0L;
        this.jfn = new f();
    }

    public long bgS() {
        return this.fau;
    }

    public long bgT() {
        return this.fas;
    }

    public long bgU() {
        return this.fat;
    }

    public long bgV() {
        return this.far;
    }

    public f cpl() {
        return this.jfn;
    }

    public void a(a aVar) {
        this.jfo = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jfm != null) {
            this.jfm.cancel();
            return false;
        }
        return false;
    }

    public boolean cpm() {
        return AW(1);
    }

    public boolean cpn() {
        return AW(0);
    }

    public boolean AW(int i) {
        if (this.jfm != null) {
            return false;
        }
        this.jfm = new b(i);
        this.jfm.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int jfq;
        private com.baidu.tieba.square.a.a jfp = null;
        private l<String> jfr = null;

        public b(int i) {
            this.jfq = 1;
            this.jfq = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.jfp = new com.baidu.tieba.square.a.a();
            this.jfr = com.baidu.tbadk.core.d.a.agL().mN("tb.square");
            if (this.jfq == 0) {
                String str2 = this.jfr.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.bcI = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.bcI = 0L;
                }
                if (!fVar2.cpg()) {
                    this.jfq = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.jfq == 1) {
                SquareModel.this.far = System.currentTimeMillis();
                this.jfp.o("prevtime", SquareModel.this.bcI + "");
                str = this.jfp.coH();
                SquareModel.this.fas = this.jfp.coI();
                SquareModel.this.fat = this.jfp.coJ();
                SquareModel.this.fau = System.currentTimeMillis();
            }
            if (this.jfp.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.bcI) {
                    this.jfr.a("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.jfr.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aE(fVar3.cpj());
                        fVar4.ez(valueOf.longValue());
                        this.jfr.a("square_cache_key", fVar4.aRj(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.jfr.a("square_cache_key", str, 86400000L);
                        fVar = fVar3;
                    }
                }
                SquareModel.this.bcI = valueOf.longValue();
            }
            return fVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.jfp != null) {
                this.jfp.cancel();
            }
            SquareModel.this.jfm = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.jfm = null;
            SquareModel.this.jfn = fVar;
            if (SquareModel.this.jfo != null) {
                if (this.jfq == 0 || this.jfp.isRequestSuccess()) {
                    SquareModel.this.jfo.a(true, null, fVar);
                    return;
                }
                SquareModel.this.jfo.a(false, this.jfp.acc(), fVar);
            }
        }
    }
}
