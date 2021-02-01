package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long iLB;
    private long iLC;
    private long iLD;
    private long iLE;
    private long mTimeStamp;
    private b nsU;
    private h nsV;
    private a nsW;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.nsU = null;
        this.nsV = null;
        this.nsW = null;
        this.iLB = 0L;
        this.iLC = 0L;
        this.iLD = 0L;
        this.iLE = 0L;
        this.nsV = new h();
    }

    public long cwA() {
        return this.iLE;
    }

    public long cwB() {
        return this.iLC;
    }

    public long cwC() {
        return this.iLD;
    }

    public long cwD() {
        return this.iLB;
    }

    public h dMj() {
        return this.nsV;
    }

    public void a(a aVar) {
        this.nsW = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nsU != null) {
            this.nsU.cancel();
            return false;
        }
        return false;
    }

    public boolean dMk() {
        return Jq(1);
    }

    public boolean dMl() {
        return Jq(0);
    }

    public boolean Jq(int i) {
        if (this.nsU != null) {
            return false;
        }
        this.nsU = new b(i);
        this.nsU.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int nsY;
        private com.baidu.tieba.square.a.a nsX = null;
        private l<String> nsZ = null;

        public b(int i) {
            this.nsY = 1;
            this.nsY = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str;
            h hVar2;
            this.nsX = new com.baidu.tieba.square.a.a();
            this.nsZ = com.baidu.tbadk.core.c.a.bqr().As("tb.square");
            if (this.nsY == 0) {
                str = this.nsZ.get("square_cache_key");
                if (str == null) {
                    return null;
                }
                hVar = new h();
                hVar.parserJson(str);
                SquareModel.this.mTimeStamp = hVar.getTimeStamp();
                if (hVar.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar.dMd()) {
                    this.nsY = 1;
                } else {
                    return hVar;
                }
            } else {
                hVar = null;
                str = null;
            }
            if (this.nsY == 1) {
                SquareModel.this.iLB = System.currentTimeMillis();
                this.nsX.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.nsX.dLG();
                SquareModel.this.iLC = this.nsX.dLH();
                SquareModel.this.iLD = this.nsX.dLI();
                SquareModel.this.iLE = System.currentTimeMillis();
            }
            String str2 = str;
            if (this.nsX.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str2);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.nsZ.set("square_cache_key", str2, 86400000L);
                    hVar2 = hVar3;
                } else {
                    String str3 = this.nsZ.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.be(hVar3.dMg());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.nsZ.set("square_cache_key", hVar4.dMh(), 86400000L);
                        hVar2 = hVar4;
                    } else {
                        this.nsZ.set("square_cache_key", str2, 86400000L);
                        hVar2 = hVar3;
                    }
                }
                SquareModel.this.mTimeStamp = valueOf.longValue();
            } else {
                hVar2 = hVar;
            }
            return hVar2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.nsX != null) {
                this.nsX.cancel();
            }
            SquareModel.this.nsU = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.nsU = null;
            SquareModel.this.nsV = hVar;
            if (SquareModel.this.nsW != null) {
                if (this.nsY == 0 || this.nsX.isRequestSuccess()) {
                    SquareModel.this.nsW.a(true, null, hVar);
                    return;
                }
                SquareModel.this.nsW.a(false, this.nsX.bkR(), hVar);
            }
        }
    }
}
