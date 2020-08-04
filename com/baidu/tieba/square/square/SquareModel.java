package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes17.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long hll;
    private long hlm;
    private long hln;
    private long hlo;
    private b lJF;
    private h lJG;
    private a lJH;
    private long mTimeStamp;

    /* loaded from: classes17.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.lJF = null;
        this.lJG = null;
        this.lJH = null;
        this.hll = 0L;
        this.hlm = 0L;
        this.hln = 0L;
        this.hlo = 0L;
        this.lJG = new h();
    }

    public long bVK() {
        return this.hlo;
    }

    public long bVL() {
        return this.hlm;
    }

    public long bVM() {
        return this.hln;
    }

    public long bVN() {
        return this.hll;
    }

    public h djZ() {
        return this.lJG;
    }

    public void a(a aVar) {
        this.lJH = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lJF != null) {
            this.lJF.cancel();
            return false;
        }
        return false;
    }

    public boolean dka() {
        return Ff(1);
    }

    public boolean dkb() {
        return Ff(0);
    }

    public boolean Ff(int i) {
        if (this.lJF != null) {
            return false;
        }
        this.lJF = new b(i);
        this.lJF.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int lJJ;
        private com.baidu.tieba.square.b.a lJI = null;
        private l<String> lJK = null;

        public b(int i) {
            this.lJJ = 1;
            this.lJJ = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.lJI = new com.baidu.tieba.square.b.a();
            this.lJK = com.baidu.tbadk.core.c.a.aYG().xj("tb.square");
            if (this.lJJ == 0) {
                String str2 = this.lJK.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.djT()) {
                    this.lJJ = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.lJJ == 1) {
                SquareModel.this.hll = System.currentTimeMillis();
                this.lJI.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.lJI.djw();
                SquareModel.this.hlm = this.lJI.djx();
                SquareModel.this.hln = this.lJI.djy();
                SquareModel.this.hlo = System.currentTimeMillis();
            }
            if (this.lJI.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.lJK.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.lJK.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aW(hVar3.djW());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.lJK.set("square_cache_key", hVar4.djX(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.lJK.set("square_cache_key", str, 86400000L);
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
            if (this.lJI != null) {
                this.lJI.cancel();
            }
            SquareModel.this.lJF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.lJF = null;
            SquareModel.this.lJG = hVar;
            if (SquareModel.this.lJH != null) {
                if (this.lJJ == 0 || this.lJI.isRequestSuccess()) {
                    SquareModel.this.lJH.a(true, null, hVar);
                    return;
                }
                SquareModel.this.lJH.a(false, this.lJI.aTt(), hVar);
            }
        }
    }
}
