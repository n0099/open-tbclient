package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long iLP;
    private long iLQ;
    private long iLR;
    private long iLS;
    private long mTimeStamp;
    private b ntu;
    private h ntv;
    private a ntw;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.ntu = null;
        this.ntv = null;
        this.ntw = null;
        this.iLP = 0L;
        this.iLQ = 0L;
        this.iLR = 0L;
        this.iLS = 0L;
        this.ntv = new h();
    }

    public long cwH() {
        return this.iLS;
    }

    public long cwI() {
        return this.iLQ;
    }

    public long cwJ() {
        return this.iLR;
    }

    public long cwK() {
        return this.iLP;
    }

    public h dMr() {
        return this.ntv;
    }

    public void a(a aVar) {
        this.ntw = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ntu != null) {
            this.ntu.cancel();
            return false;
        }
        return false;
    }

    public boolean dMs() {
        return Jq(1);
    }

    public boolean dMt() {
        return Jq(0);
    }

    public boolean Jq(int i) {
        if (this.ntu != null) {
            return false;
        }
        this.ntu = new b(i);
        this.ntu.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int nty;
        private com.baidu.tieba.square.a.a ntx = null;
        private l<String> ntz = null;

        public b(int i) {
            this.nty = 1;
            this.nty = i;
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
            this.ntx = new com.baidu.tieba.square.a.a();
            this.ntz = com.baidu.tbadk.core.c.a.bqr().As("tb.square");
            if (this.nty == 0) {
                str = this.ntz.get("square_cache_key");
                if (str == null) {
                    return null;
                }
                hVar = new h();
                hVar.parserJson(str);
                SquareModel.this.mTimeStamp = hVar.getTimeStamp();
                if (hVar.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar.dMl()) {
                    this.nty = 1;
                } else {
                    return hVar;
                }
            } else {
                hVar = null;
                str = null;
            }
            if (this.nty == 1) {
                SquareModel.this.iLP = System.currentTimeMillis();
                this.ntx.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.ntx.dLO();
                SquareModel.this.iLQ = this.ntx.dLP();
                SquareModel.this.iLR = this.ntx.dLQ();
                SquareModel.this.iLS = System.currentTimeMillis();
            }
            String str2 = str;
            if (this.ntx.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str2);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.ntz.set("square_cache_key", str2, 86400000L);
                    hVar2 = hVar3;
                } else {
                    String str3 = this.ntz.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.be(hVar3.dMo());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.ntz.set("square_cache_key", hVar4.dMp(), 86400000L);
                        hVar2 = hVar4;
                    } else {
                        this.ntz.set("square_cache_key", str2, 86400000L);
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
            if (this.ntx != null) {
                this.ntx.cancel();
            }
            SquareModel.this.ntu = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.ntu = null;
            SquareModel.this.ntv = hVar;
            if (SquareModel.this.ntw != null) {
                if (this.nty == 0 || this.ntx.isRequestSuccess()) {
                    SquareModel.this.ntw.a(true, null, hVar);
                    return;
                }
                SquareModel.this.ntw.a(false, this.ntx.bkR(), hVar);
            }
        }
    }
}
