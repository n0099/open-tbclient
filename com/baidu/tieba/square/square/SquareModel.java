package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long bbz;
    private long eTv;
    private long eTw;
    private long eTx;
    private long eTy;
    private b iVr;
    private f iVs;
    private a iVt;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.iVr = null;
        this.iVs = null;
        this.iVt = null;
        this.eTv = 0L;
        this.eTw = 0L;
        this.eTx = 0L;
        this.eTy = 0L;
        this.iVs = new f();
    }

    public long bed() {
        return this.eTy;
    }

    public long bee() {
        return this.eTw;
    }

    public long bef() {
        return this.eTx;
    }

    public long beg() {
        return this.eTv;
    }

    public f cll() {
        return this.iVs;
    }

    public void a(a aVar) {
        this.iVt = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iVr != null) {
            this.iVr.cancel();
            return false;
        }
        return false;
    }

    public boolean clm() {
        return Al(1);
    }

    public boolean cln() {
        return Al(0);
    }

    public boolean Al(int i) {
        if (this.iVr != null) {
            return false;
        }
        this.iVr = new b(i);
        this.iVr.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int iVv;
        private com.baidu.tieba.square.a.a iVu = null;
        private l<String> iVw = null;

        public b(int i) {
            this.iVv = 1;
            this.iVv = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.iVu = new com.baidu.tieba.square.a.a();
            this.iVw = com.baidu.tbadk.core.c.a.afD().mB("tb.square");
            if (this.iVv == 0) {
                String str2 = this.iVw.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.bbz = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.bbz = 0L;
                }
                if (!fVar2.clg()) {
                    this.iVv = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.iVv == 1) {
                SquareModel.this.eTv = System.currentTimeMillis();
                this.iVu.o("prevtime", SquareModel.this.bbz + "");
                str = this.iVu.ckH();
                SquareModel.this.eTw = this.iVu.ckI();
                SquareModel.this.eTx = this.iVu.ckJ();
                SquareModel.this.eTy = System.currentTimeMillis();
            }
            if (this.iVu.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.bbz) {
                    this.iVw.a("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.iVw.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aE(fVar3.clj());
                        fVar4.em(valueOf.longValue());
                        this.iVw.a("square_cache_key", fVar4.aOP(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.iVw.a("square_cache_key", str, 86400000L);
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
            if (this.iVu != null) {
                this.iVu.cancel();
            }
            SquareModel.this.iVr = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.iVr = null;
            SquareModel.this.iVs = fVar;
            if (SquareModel.this.iVt != null) {
                if (this.iVv == 0 || this.iVu.isRequestSuccess()) {
                    SquareModel.this.iVt.a(true, null, fVar);
                    return;
                }
                SquareModel.this.iVt.a(false, this.iVu.aaZ(), fVar);
            }
        }
    }
}
