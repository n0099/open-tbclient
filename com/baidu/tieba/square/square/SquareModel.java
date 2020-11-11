package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes23.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long imD;
    private long imE;
    private long imF;
    private long imG;
    private long mTimeStamp;
    private b mTr;
    private h mTs;
    private a mTt;

    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.mTr = null;
        this.mTs = null;
        this.mTt = null;
        this.imD = 0L;
        this.imE = 0L;
        this.imF = 0L;
        this.imG = 0L;
        this.mTs = new h();
    }

    public long cst() {
        return this.imG;
    }

    public long csu() {
        return this.imE;
    }

    public long csv() {
        return this.imF;
    }

    public long csw() {
        return this.imD;
    }

    public h dIP() {
        return this.mTs;
    }

    public void a(a aVar) {
        this.mTt = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mTr != null) {
            this.mTr.cancel();
            return false;
        }
        return false;
    }

    public boolean dIQ() {
        return Jq(1);
    }

    public boolean dIR() {
        return Jq(0);
    }

    public boolean Jq(int i) {
        if (this.mTr != null) {
            return false;
        }
        this.mTr = new b(i);
        this.mTr.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int mTv;
        private com.baidu.tieba.square.b.a mTu = null;
        private l<String> mTw = null;

        public b(int i) {
            this.mTv = 1;
            this.mTv = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.mTu = new com.baidu.tieba.square.b.a();
            this.mTw = com.baidu.tbadk.core.c.a.boX().Bm("tb.square");
            if (this.mTv == 0) {
                String str2 = this.mTw.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dIJ()) {
                    this.mTv = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.mTv == 1) {
                SquareModel.this.imD = System.currentTimeMillis();
                this.mTu.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.mTu.dIm();
                SquareModel.this.imE = this.mTu.dIn();
                SquareModel.this.imF = this.mTu.dIo();
                SquareModel.this.imG = System.currentTimeMillis();
            }
            if (this.mTu.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.mTw.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.mTw.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.bh(hVar3.dIM());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.mTw.set("square_cache_key", hVar4.dIN(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.mTw.set("square_cache_key", str, 86400000L);
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
            if (this.mTu != null) {
                this.mTu.cancel();
            }
            SquareModel.this.mTr = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.mTr = null;
            SquareModel.this.mTs = hVar;
            if (SquareModel.this.mTt != null) {
                if (this.mTv == 0 || this.mTu.isRequestSuccess()) {
                    SquareModel.this.mTt.a(true, null, hVar);
                    return;
                }
                SquareModel.this.mTt.a(false, this.mTu.bjF(), hVar);
            }
        }
    }
}
