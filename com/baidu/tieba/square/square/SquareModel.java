package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes22.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long hFk;
    private long hFl;
    private long hFm;
    private long hFn;
    private long mTimeStamp;
    private b mld;
    private h mle;
    private a mlf;

    /* loaded from: classes22.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.mld = null;
        this.mle = null;
        this.mlf = null;
        this.hFk = 0L;
        this.hFl = 0L;
        this.hFm = 0L;
        this.hFn = 0L;
        this.mle = new h();
    }

    public long cjp() {
        return this.hFn;
    }

    public long cjq() {
        return this.hFl;
    }

    public long cjr() {
        return this.hFm;
    }

    public long cjs() {
        return this.hFk;
    }

    public h dzu() {
        return this.mle;
    }

    public void a(a aVar) {
        this.mlf = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mld != null) {
            this.mld.cancel();
            return false;
        }
        return false;
    }

    public boolean dzv() {
        return If(1);
    }

    public boolean dzw() {
        return If(0);
    }

    public boolean If(int i) {
        if (this.mld != null) {
            return false;
        }
        this.mld = new b(i);
        this.mld.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int mlh;
        private com.baidu.tieba.square.b.a mlg = null;
        private l<String> mli = null;

        public b(int i) {
            this.mlh = 1;
            this.mlh = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.mlg = new com.baidu.tieba.square.b.a();
            this.mli = com.baidu.tbadk.core.c.a.bhV().zT("tb.square");
            if (this.mlh == 0) {
                String str2 = this.mli.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dzo()) {
                    this.mlh = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.mlh == 1) {
                SquareModel.this.hFk = System.currentTimeMillis();
                this.mlg.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.mlg.dyR();
                SquareModel.this.hFl = this.mlg.dyS();
                SquareModel.this.hFm = this.mlg.dyT();
                SquareModel.this.hFn = System.currentTimeMillis();
            }
            if (this.mlg.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.mli.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.mli.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.be(hVar3.dzr());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.mli.set("square_cache_key", hVar4.dzs(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.mli.set("square_cache_key", str, 86400000L);
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
            if (this.mlg != null) {
                this.mlg.cancel();
            }
            SquareModel.this.mld = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.mld = null;
            SquareModel.this.mle = hVar;
            if (SquareModel.this.mlf != null) {
                if (this.mlh == 0 || this.mlg.isRequestSuccess()) {
                    SquareModel.this.mlf.a(true, null, hVar);
                    return;
                }
                SquareModel.this.mlf.a(false, this.mlg.bcE(), hVar);
            }
        }
    }
}
