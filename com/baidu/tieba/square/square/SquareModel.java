package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long fXo;
    private long fXp;
    private long fXq;
    private long fXr;
    private b keW;
    private h keX;
    private a keY;
    private long mTimeStamp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.keW = null;
        this.keX = null;
        this.keY = null;
        this.fXo = 0L;
        this.fXp = 0L;
        this.fXq = 0L;
        this.fXr = 0L;
        this.keX = new h();
    }

    public long byT() {
        return this.fXr;
    }

    public long byU() {
        return this.fXp;
    }

    public long byV() {
        return this.fXq;
    }

    public long byW() {
        return this.fXo;
    }

    public h cKn() {
        return this.keX;
    }

    public void a(a aVar) {
        this.keY = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.keW != null) {
            this.keW.cancel();
            return false;
        }
        return false;
    }

    public boolean cKo() {
        return Ct(1);
    }

    public boolean cKp() {
        return Ct(0);
    }

    public boolean Ct(int i) {
        if (this.keW != null) {
            return false;
        }
        this.keW = new b(i);
        this.keW.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int kfa;
        private com.baidu.tieba.square.a.a keZ = null;
        private l<String> kfb = null;

        public b(int i) {
            this.kfa = 1;
            this.kfa = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.keZ = new com.baidu.tieba.square.a.a();
            this.kfb = com.baidu.tbadk.core.c.a.aEF().sP("tb.square");
            if (this.kfa == 0) {
                String str2 = this.kfb.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.cKh()) {
                    this.kfa = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.kfa == 1) {
                SquareModel.this.fXo = System.currentTimeMillis();
                this.keZ.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.keZ.cJL();
                SquareModel.this.fXp = this.keZ.cJM();
                SquareModel.this.fXq = this.keZ.cJN();
                SquareModel.this.fXr = System.currentTimeMillis();
            }
            if (this.keZ.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.kfb.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.kfb.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aR(hVar3.cKk());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.kfb.set("square_cache_key", hVar4.cKl(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.kfb.set("square_cache_key", str, 86400000L);
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
            if (this.keZ != null) {
                this.keZ.cancel();
            }
            SquareModel.this.keW = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.keW = null;
            SquareModel.this.keX = hVar;
            if (SquareModel.this.keY != null) {
                if (this.kfa == 0 || this.keZ.isRequestSuccess()) {
                    SquareModel.this.keY.a(true, null, hVar);
                    return;
                }
                SquareModel.this.keY.a(false, this.keZ.azP(), hVar);
            }
        }
    }
}
