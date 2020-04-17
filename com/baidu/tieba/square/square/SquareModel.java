package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long gDS;
    private long gDT;
    private long gDU;
    private long gDV;
    private b kOP;
    private h kOQ;
    private a kOR;
    private long mTimeStamp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.kOP = null;
        this.kOQ = null;
        this.kOR = null;
        this.gDS = 0L;
        this.gDT = 0L;
        this.gDU = 0L;
        this.gDV = 0L;
        this.kOQ = new h();
    }

    public long bIV() {
        return this.gDV;
    }

    public long bIW() {
        return this.gDT;
    }

    public long bIX() {
        return this.gDU;
    }

    public long bIY() {
        return this.gDS;
    }

    public h cVj() {
        return this.kOQ;
    }

    public void a(a aVar) {
        this.kOR = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kOP != null) {
            this.kOP.cancel();
            return false;
        }
        return false;
    }

    public boolean cVk() {
        return CV(1);
    }

    public boolean cVl() {
        return CV(0);
    }

    public boolean CV(int i) {
        if (this.kOP != null) {
            return false;
        }
        this.kOP = new b(i);
        this.kOP.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int kOT;
        private com.baidu.tieba.square.b.a kOS = null;
        private l<String> kOU = null;

        public b(int i) {
            this.kOT = 1;
            this.kOT = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.kOS = new com.baidu.tieba.square.b.a();
            this.kOU = com.baidu.tbadk.core.c.a.aMT().ud("tb.square");
            if (this.kOT == 0) {
                String str2 = this.kOU.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.cVd()) {
                    this.kOT = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.kOT == 1) {
                SquareModel.this.gDS = System.currentTimeMillis();
                this.kOS.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.kOS.cUG();
                SquareModel.this.gDT = this.kOS.cUH();
                SquareModel.this.gDU = this.kOS.cUI();
                SquareModel.this.gDV = System.currentTimeMillis();
            }
            if (this.kOS.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.kOU.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.kOU.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aT(hVar3.cVg());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.kOU.set("square_cache_key", hVar4.cVh(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.kOU.set("square_cache_key", str, 86400000L);
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
            if (this.kOS != null) {
                this.kOS.cancel();
            }
            SquareModel.this.kOP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.kOP = null;
            SquareModel.this.kOQ = hVar;
            if (SquareModel.this.kOR != null) {
                if (this.kOT == 0 || this.kOS.isRequestSuccess()) {
                    SquareModel.this.kOR.a(true, null, hVar);
                    return;
                }
                SquareModel.this.kOR.a(false, this.kOS.aIc(), hVar);
            }
        }
    }
}
