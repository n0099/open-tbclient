package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long bck;
    private long eYL;
    private long eYM;
    private long eYN;
    private long eYO;
    private b jcR;
    private f jcS;
    private a jcT;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.jcR = null;
        this.jcS = null;
        this.jcT = null;
        this.eYL = 0L;
        this.eYM = 0L;
        this.eYN = 0L;
        this.eYO = 0L;
        this.jcS = new f();
    }

    public long bgm() {
        return this.eYO;
    }

    public long bgn() {
        return this.eYM;
    }

    public long bgo() {
        return this.eYN;
    }

    public long bgp() {
        return this.eYL;
    }

    public f coy() {
        return this.jcS;
    }

    public void a(a aVar) {
        this.jcT = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jcR != null) {
            this.jcR.cancel();
            return false;
        }
        return false;
    }

    public boolean coz() {
        return AT(1);
    }

    public boolean coA() {
        return AT(0);
    }

    public boolean AT(int i) {
        if (this.jcR != null) {
            return false;
        }
        this.jcR = new b(i);
        this.jcR.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int jcV;
        private com.baidu.tieba.square.a.a jcU = null;
        private l<String> jcW = null;

        public b(int i) {
            this.jcV = 1;
            this.jcV = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.jcU = new com.baidu.tieba.square.a.a();
            this.jcW = com.baidu.tbadk.core.d.a.agH().mL("tb.square");
            if (this.jcV == 0) {
                String str2 = this.jcW.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.bck = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.bck = 0L;
                }
                if (!fVar2.cot()) {
                    this.jcV = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.jcV == 1) {
                SquareModel.this.eYL = System.currentTimeMillis();
                this.jcU.o("prevtime", SquareModel.this.bck + "");
                str = this.jcU.cnU();
                SquareModel.this.eYM = this.jcU.cnV();
                SquareModel.this.eYN = this.jcU.cnW();
                SquareModel.this.eYO = System.currentTimeMillis();
            }
            if (this.jcU.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.bck) {
                    this.jcW.a("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.jcW.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aE(fVar3.cow());
                        fVar4.ew(valueOf.longValue());
                        this.jcW.a("square_cache_key", fVar4.aQF(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.jcW.a("square_cache_key", str, 86400000L);
                        fVar = fVar3;
                    }
                }
                SquareModel.this.bck = valueOf.longValue();
            }
            return fVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.jcU != null) {
                this.jcU.cancel();
            }
            SquareModel.this.jcR = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.jcR = null;
            SquareModel.this.jcS = fVar;
            if (SquareModel.this.jcT != null) {
                if (this.jcV == 0 || this.jcU.isRequestSuccess()) {
                    SquareModel.this.jcT.a(true, null, fVar);
                    return;
                }
                SquareModel.this.jcT.a(false, this.jcU.abY(), fVar);
            }
        }
    }
}
