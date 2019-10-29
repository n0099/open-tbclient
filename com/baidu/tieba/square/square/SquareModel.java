package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long fdc;
    private long fdd;
    private long fde;
    private long fdf;
    private b jfd;
    private f jfe;
    private a jff;
    private long mTimeStamp;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.jfd = null;
        this.jfe = null;
        this.jff = null;
        this.fdc = 0L;
        this.fdd = 0L;
        this.fde = 0L;
        this.fdf = 0L;
        this.jfe = new f();
    }

    public long beL() {
        return this.fdf;
    }

    public long beM() {
        return this.fdd;
    }

    public long beN() {
        return this.fde;
    }

    public long beO() {
        return this.fdc;
    }

    public f cnc() {
        return this.jfe;
    }

    public void a(a aVar) {
        this.jff = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jfd != null) {
            this.jfd.cancel();
            return false;
        }
        return false;
    }

    public boolean cnd() {
        return zE(1);
    }

    public boolean cne() {
        return zE(0);
    }

    public boolean zE(int i) {
        if (this.jfd != null) {
            return false;
        }
        this.jfd = new b(i);
        this.jfd.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int jfh;
        private com.baidu.tieba.square.a.a jfg = null;
        private l<String> jfi = null;

        public b(int i) {
            this.jfh = 1;
            this.jfh = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.jfg = new com.baidu.tieba.square.a.a();
            this.jfi = com.baidu.tbadk.core.d.a.akN().nl("tb.square");
            if (this.jfh == 0) {
                String str2 = this.jfi.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!fVar2.cmW()) {
                    this.jfh = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.jfh == 1) {
                SquareModel.this.fdc = System.currentTimeMillis();
                this.jfg.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.jfg.cmx();
                SquareModel.this.fdd = this.jfg.cmy();
                SquareModel.this.fde = this.jfg.cmz();
                SquareModel.this.fdf = System.currentTimeMillis();
            }
            if (this.jfg.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.jfi.set("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.jfi.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aI(fVar3.cmZ());
                        fVar4.setTimeStamp(valueOf.longValue());
                        this.jfi.set("square_cache_key", fVar4.cna(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.jfi.set("square_cache_key", str, 86400000L);
                        fVar = fVar3;
                    }
                }
                SquareModel.this.mTimeStamp = valueOf.longValue();
            }
            return fVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.jfg != null) {
                this.jfg.cancel();
            }
            SquareModel.this.jfd = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.jfd = null;
            SquareModel.this.jfe = fVar;
            if (SquareModel.this.jff != null) {
                if (this.jfh == 0 || this.jfg.isRequestSuccess()) {
                    SquareModel.this.jff.a(true, null, fVar);
                    return;
                }
                SquareModel.this.jff.a(false, this.jfg.ago(), fVar);
            }
        }
    }
}
