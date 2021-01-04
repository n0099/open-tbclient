package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long iKA;
    private long iKB;
    private long iKC;
    private long iKz;
    private long mTimeStamp;
    private b nnR;
    private h nnS;
    private a nnT;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.nnR = null;
        this.nnS = null;
        this.nnT = null;
        this.iKz = 0L;
        this.iKA = 0L;
        this.iKB = 0L;
        this.iKC = 0L;
        this.nnS = new h();
    }

    public long czf() {
        return this.iKC;
    }

    public long czg() {
        return this.iKA;
    }

    public long czh() {
        return this.iKB;
    }

    public long czi() {
        return this.iKz;
    }

    public h dNP() {
        return this.nnS;
    }

    public void a(a aVar) {
        this.nnT = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nnR != null) {
            this.nnR.cancel();
            return false;
        }
        return false;
    }

    public boolean dNQ() {
        return KD(1);
    }

    public boolean dNR() {
        return KD(0);
    }

    public boolean KD(int i) {
        if (this.nnR != null) {
            return false;
        }
        this.nnR = new b(i);
        this.nnR.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int nnV;
        private com.baidu.tieba.square.a.a nnU = null;
        private l<String> nnW = null;

        public b(int i) {
            this.nnV = 1;
            this.nnV = i;
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
            this.nnU = new com.baidu.tieba.square.a.a();
            this.nnW = com.baidu.tbadk.core.c.a.btS().Bn("tb.square");
            if (this.nnV == 0) {
                str = this.nnW.get("square_cache_key");
                if (str == null) {
                    return null;
                }
                hVar = new h();
                hVar.parserJson(str);
                SquareModel.this.mTimeStamp = hVar.getTimeStamp();
                if (hVar.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar.dNJ()) {
                    this.nnV = 1;
                } else {
                    return hVar;
                }
            } else {
                hVar = null;
                str = null;
            }
            if (this.nnV == 1) {
                SquareModel.this.iKz = System.currentTimeMillis();
                this.nnU.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.nnU.dNm();
                SquareModel.this.iKA = this.nnU.dNn();
                SquareModel.this.iKB = this.nnU.dNo();
                SquareModel.this.iKC = System.currentTimeMillis();
            }
            String str2 = str;
            if (this.nnU.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str2);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.nnW.set("square_cache_key", str2, 86400000L);
                    hVar2 = hVar3;
                } else {
                    String str3 = this.nnW.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.bk(hVar3.dNM());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.nnW.set("square_cache_key", hVar4.dNN(), 86400000L);
                        hVar2 = hVar4;
                    } else {
                        this.nnW.set("square_cache_key", str2, 86400000L);
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
            if (this.nnU != null) {
                this.nnU.cancel();
            }
            SquareModel.this.nnR = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.nnR = null;
            SquareModel.this.nnS = hVar;
            if (SquareModel.this.nnT != null) {
                if (this.nnV == 0 || this.nnU.isRequestSuccess()) {
                    SquareModel.this.nnT.a(true, null, hVar);
                    return;
                }
                SquareModel.this.nnT.a(false, this.nnU.bos(), hVar);
            }
        }
    }
}
