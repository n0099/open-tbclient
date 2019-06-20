package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long bbz;
    private long eTw;
    private long eTx;
    private long eTy;
    private long eTz;
    private b iVx;
    private f iVy;
    private a iVz;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.iVx = null;
        this.iVy = null;
        this.iVz = null;
        this.eTw = 0L;
        this.eTx = 0L;
        this.eTy = 0L;
        this.eTz = 0L;
        this.iVy = new f();
    }

    public long beg() {
        return this.eTz;
    }

    public long beh() {
        return this.eTx;
    }

    public long bei() {
        return this.eTy;
    }

    public long bej() {
        return this.eTw;
    }

    public f clo() {
        return this.iVy;
    }

    public void a(a aVar) {
        this.iVz = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iVx != null) {
            this.iVx.cancel();
            return false;
        }
        return false;
    }

    public boolean clp() {
        return Al(1);
    }

    public boolean clq() {
        return Al(0);
    }

    public boolean Al(int i) {
        if (this.iVx != null) {
            return false;
        }
        this.iVx = new b(i);
        this.iVx.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int iVB;
        private com.baidu.tieba.square.a.a iVA = null;
        private l<String> iVC = null;

        public b(int i) {
            this.iVB = 1;
            this.iVB = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.iVA = new com.baidu.tieba.square.a.a();
            this.iVC = com.baidu.tbadk.core.c.a.afD().mA("tb.square");
            if (this.iVB == 0) {
                String str2 = this.iVC.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.bbz = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.bbz = 0L;
                }
                if (!fVar2.clj()) {
                    this.iVB = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.iVB == 1) {
                SquareModel.this.eTw = System.currentTimeMillis();
                this.iVA.o("prevtime", SquareModel.this.bbz + "");
                str = this.iVA.ckK();
                SquareModel.this.eTx = this.iVA.ckL();
                SquareModel.this.eTy = this.iVA.ckM();
                SquareModel.this.eTz = System.currentTimeMillis();
            }
            if (this.iVA.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.bbz) {
                    this.iVC.a("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.iVC.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aE(fVar3.clm());
                        fVar4.em(valueOf.longValue());
                        this.iVC.a("square_cache_key", fVar4.aOS(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.iVC.a("square_cache_key", str, 86400000L);
                        fVar = fVar3;
                    }
                }
                SquareModel.this.bbz = valueOf.longValue();
            }
            return fVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.iVA != null) {
                this.iVA.cancel();
            }
            SquareModel.this.iVx = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.iVx = null;
            SquareModel.this.iVy = fVar;
            if (SquareModel.this.iVz != null) {
                if (this.iVB == 0 || this.iVA.isRequestSuccess()) {
                    SquareModel.this.iVz.a(true, null, fVar);
                    return;
                }
                SquareModel.this.iVz.a(false, this.iVA.aaZ(), fVar);
            }
        }
    }
}
