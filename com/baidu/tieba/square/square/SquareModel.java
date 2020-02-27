package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long fWr;
    private long fWs;
    private long fWt;
    private long fWu;
    private b kdf;
    private h kdg;
    private a kdh;
    private long mTimeStamp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.kdf = null;
        this.kdg = null;
        this.kdh = null;
        this.fWr = 0L;
        this.fWs = 0L;
        this.fWt = 0L;
        this.fWu = 0L;
        this.kdg = new h();
    }

    public long byK() {
        return this.fWu;
    }

    public long byL() {
        return this.fWs;
    }

    public long byM() {
        return this.fWt;
    }

    public long byN() {
        return this.fWr;
    }

    public h cJQ() {
        return this.kdg;
    }

    public void a(a aVar) {
        this.kdh = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kdf != null) {
            this.kdf.cancel();
            return false;
        }
        return false;
    }

    public boolean cJR() {
        return Cl(1);
    }

    public boolean cJS() {
        return Cl(0);
    }

    public boolean Cl(int i) {
        if (this.kdf != null) {
            return false;
        }
        this.kdf = new b(i);
        this.kdf.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int kdj;
        private com.baidu.tieba.square.a.a kdi = null;
        private l<String> kdk = null;

        public b(int i) {
            this.kdj = 1;
            this.kdj = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.kdi = new com.baidu.tieba.square.a.a();
            this.kdk = com.baidu.tbadk.core.c.a.aEz().sQ("tb.square");
            if (this.kdj == 0) {
                String str2 = this.kdk.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.cJK()) {
                    this.kdj = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.kdj == 1) {
                SquareModel.this.fWr = System.currentTimeMillis();
                this.kdi.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.kdi.cJo();
                SquareModel.this.fWs = this.kdi.cJp();
                SquareModel.this.fWt = this.kdi.cJq();
                SquareModel.this.fWu = System.currentTimeMillis();
            }
            if (this.kdi.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.kdk.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.kdk.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aR(hVar3.cJN());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.kdk.set("square_cache_key", hVar4.cJO(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.kdk.set("square_cache_key", str, 86400000L);
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
            if (this.kdi != null) {
                this.kdi.cancel();
            }
            SquareModel.this.kdf = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.kdf = null;
            SquareModel.this.kdg = hVar;
            if (SquareModel.this.kdh != null) {
                if (this.kdj == 0 || this.kdi.isRequestSuccess()) {
                    SquareModel.this.kdh.a(true, null, hVar);
                    return;
                }
                SquareModel.this.kdh.a(false, this.kdi.azK(), hVar);
            }
        }
    }
}
