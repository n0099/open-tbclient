package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long bck;
    private long eYA;
    private long eYx;
    private long eYy;
    private long eYz;
    private b jbN;
    private f jbO;
    private a jbP;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.jbN = null;
        this.jbO = null;
        this.jbP = null;
        this.eYx = 0L;
        this.eYy = 0L;
        this.eYz = 0L;
        this.eYA = 0L;
        this.jbO = new f();
    }

    public long bgj() {
        return this.eYA;
    }

    public long bgk() {
        return this.eYy;
    }

    public long bgl() {
        return this.eYz;
    }

    public long bgm() {
        return this.eYx;
    }

    public f cog() {
        return this.jbO;
    }

    public void a(a aVar) {
        this.jbP = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jbN != null) {
            this.jbN.cancel();
            return false;
        }
        return false;
    }

    public boolean coh() {
        return AR(1);
    }

    public boolean coi() {
        return AR(0);
    }

    public boolean AR(int i) {
        if (this.jbN != null) {
            return false;
        }
        this.jbN = new b(i);
        this.jbN.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int jbR;
        private com.baidu.tieba.square.a.a jbQ = null;
        private l<String> jbS = null;

        public b(int i) {
            this.jbR = 1;
            this.jbR = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.jbQ = new com.baidu.tieba.square.a.a();
            this.jbS = com.baidu.tbadk.core.d.a.agF().mL("tb.square");
            if (this.jbR == 0) {
                String str2 = this.jbS.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.bck = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.bck = 0L;
                }
                if (!fVar2.cob()) {
                    this.jbR = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.jbR == 1) {
                SquareModel.this.eYx = System.currentTimeMillis();
                this.jbQ.o("prevtime", SquareModel.this.bck + "");
                str = this.jbQ.cnC();
                SquareModel.this.eYy = this.jbQ.cnD();
                SquareModel.this.eYz = this.jbQ.cnE();
                SquareModel.this.eYA = System.currentTimeMillis();
            }
            if (this.jbQ.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.bck) {
                    this.jbS.a("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.jbS.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aE(fVar3.coe());
                        fVar4.ew(valueOf.longValue());
                        this.jbS.a("square_cache_key", fVar4.aQD(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.jbS.a("square_cache_key", str, 86400000L);
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
            if (this.jbQ != null) {
                this.jbQ.cancel();
            }
            SquareModel.this.jbN = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.jbN = null;
            SquareModel.this.jbO = fVar;
            if (SquareModel.this.jbP != null) {
                if (this.jbR == 0 || this.jbQ.isRequestSuccess()) {
                    SquareModel.this.jbP.a(true, null, fVar);
                    return;
                }
                SquareModel.this.jbP.a(false, this.jbQ.abY(), fVar);
            }
        }
    }
}
