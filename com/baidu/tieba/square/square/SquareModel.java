package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long hfB;
    private long hfC;
    private long hfD;
    private long hfE;
    private b lCo;
    private h lCp;
    private a lCq;
    private long mTimeStamp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.lCo = null;
        this.lCp = null;
        this.lCq = null;
        this.hfB = 0L;
        this.hfC = 0L;
        this.hfD = 0L;
        this.hfE = 0L;
        this.lCp = new h();
    }

    public long bSt() {
        return this.hfE;
    }

    public long bSu() {
        return this.hfC;
    }

    public long bSv() {
        return this.hfD;
    }

    public long bSw() {
        return this.hfB;
    }

    public h dgQ() {
        return this.lCp;
    }

    public void a(a aVar) {
        this.lCq = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lCo != null) {
            this.lCo.cancel();
            return false;
        }
        return false;
    }

    public boolean dgR() {
        return EJ(1);
    }

    public boolean dgS() {
        return EJ(0);
    }

    public boolean EJ(int i) {
        if (this.lCo != null) {
            return false;
        }
        this.lCo = new b(i);
        this.lCo.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int lCs;
        private com.baidu.tieba.square.b.a lCr = null;
        private l<String> lCt = null;

        public b(int i) {
            this.lCs = 1;
            this.lCs = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.lCr = new com.baidu.tieba.square.b.a();
            this.lCt = com.baidu.tbadk.core.c.a.aUM().wc("tb.square");
            if (this.lCs == 0) {
                String str2 = this.lCt.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dgK()) {
                    this.lCs = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.lCs == 1) {
                SquareModel.this.hfB = System.currentTimeMillis();
                this.lCr.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.lCr.dgn();
                SquareModel.this.hfC = this.lCr.dgo();
                SquareModel.this.hfD = this.lCr.dgp();
                SquareModel.this.hfE = System.currentTimeMillis();
            }
            if (this.lCr.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.lCt.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.lCt.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aV(hVar3.dgN());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.lCt.set("square_cache_key", hVar4.dgO(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.lCt.set("square_cache_key", str, 86400000L);
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
            if (this.lCr != null) {
                this.lCr.cancel();
            }
            SquareModel.this.lCo = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.lCo = null;
            SquareModel.this.lCp = hVar;
            if (SquareModel.this.lCq != null) {
                if (this.lCs == 0 || this.lCr.isRequestSuccess()) {
                    SquareModel.this.lCq.a(true, null, hVar);
                    return;
                }
                SquareModel.this.lCq.a(false, this.lCr.aPy(), hVar);
            }
        }
    }
}
