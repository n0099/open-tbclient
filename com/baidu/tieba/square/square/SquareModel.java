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
    private b iVt;
    private f iVu;
    private a iVv;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.iVt = null;
        this.iVu = null;
        this.iVv = null;
        this.eTw = 0L;
        this.eTx = 0L;
        this.eTy = 0L;
        this.eTz = 0L;
        this.iVu = new f();
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

    public f cln() {
        return this.iVu;
    }

    public void a(a aVar) {
        this.iVv = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iVt != null) {
            this.iVt.cancel();
            return false;
        }
        return false;
    }

    public boolean clo() {
        return Al(1);
    }

    public boolean clp() {
        return Al(0);
    }

    public boolean Al(int i) {
        if (this.iVt != null) {
            return false;
        }
        this.iVt = new b(i);
        this.iVt.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int iVx;
        private com.baidu.tieba.square.a.a iVw = null;
        private l<String> iVy = null;

        public b(int i) {
            this.iVx = 1;
            this.iVx = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.iVw = new com.baidu.tieba.square.a.a();
            this.iVy = com.baidu.tbadk.core.c.a.afD().mB("tb.square");
            if (this.iVx == 0) {
                String str2 = this.iVy.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.bbz = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.bbz = 0L;
                }
                if (!fVar2.cli()) {
                    this.iVx = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.iVx == 1) {
                SquareModel.this.eTw = System.currentTimeMillis();
                this.iVw.o("prevtime", SquareModel.this.bbz + "");
                str = this.iVw.ckJ();
                SquareModel.this.eTx = this.iVw.ckK();
                SquareModel.this.eTy = this.iVw.ckL();
                SquareModel.this.eTz = System.currentTimeMillis();
            }
            if (this.iVw.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.bbz) {
                    this.iVy.a("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.iVy.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aE(fVar3.cll());
                        fVar4.em(valueOf.longValue());
                        this.iVy.a("square_cache_key", fVar4.aOS(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.iVy.a("square_cache_key", str, 86400000L);
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
            if (this.iVw != null) {
                this.iVw.cancel();
            }
            SquareModel.this.iVt = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.iVt = null;
            SquareModel.this.iVu = fVar;
            if (SquareModel.this.iVv != null) {
                if (this.iVx == 0 || this.iVw.isRequestSuccess()) {
                    SquareModel.this.iVv.a(true, null, fVar);
                    return;
                }
                SquareModel.this.iVv.a(false, this.iVw.aaZ(), fVar);
            }
        }
    }
}
