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
    private b nnQ;
    private h nnR;
    private a nnS;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.nnQ = null;
        this.nnR = null;
        this.nnS = null;
        this.iKz = 0L;
        this.iKA = 0L;
        this.iKB = 0L;
        this.iKC = 0L;
        this.nnR = new h();
    }

    public long czg() {
        return this.iKC;
    }

    public long czh() {
        return this.iKA;
    }

    public long czi() {
        return this.iKB;
    }

    public long czj() {
        return this.iKz;
    }

    public h dNQ() {
        return this.nnR;
    }

    public void a(a aVar) {
        this.nnS = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nnQ != null) {
            this.nnQ.cancel();
            return false;
        }
        return false;
    }

    public boolean dNR() {
        return KD(1);
    }

    public boolean dNS() {
        return KD(0);
    }

    public boolean KD(int i) {
        if (this.nnQ != null) {
            return false;
        }
        this.nnQ = new b(i);
        this.nnQ.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int nnU;
        private com.baidu.tieba.square.a.a nnT = null;
        private l<String> nnV = null;

        public b(int i) {
            this.nnU = 1;
            this.nnU = i;
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
            this.nnT = new com.baidu.tieba.square.a.a();
            this.nnV = com.baidu.tbadk.core.c.a.btT().Bm("tb.square");
            if (this.nnU == 0) {
                str = this.nnV.get("square_cache_key");
                if (str == null) {
                    return null;
                }
                hVar = new h();
                hVar.parserJson(str);
                SquareModel.this.mTimeStamp = hVar.getTimeStamp();
                if (hVar.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar.dNK()) {
                    this.nnU = 1;
                } else {
                    return hVar;
                }
            } else {
                hVar = null;
                str = null;
            }
            if (this.nnU == 1) {
                SquareModel.this.iKz = System.currentTimeMillis();
                this.nnT.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.nnT.dNn();
                SquareModel.this.iKA = this.nnT.dNo();
                SquareModel.this.iKB = this.nnT.dNp();
                SquareModel.this.iKC = System.currentTimeMillis();
            }
            String str2 = str;
            if (this.nnT.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str2);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.nnV.set("square_cache_key", str2, 86400000L);
                    hVar2 = hVar3;
                } else {
                    String str3 = this.nnV.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.bk(hVar3.dNN());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.nnV.set("square_cache_key", hVar4.dNO(), 86400000L);
                        hVar2 = hVar4;
                    } else {
                        this.nnV.set("square_cache_key", str2, 86400000L);
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
            if (this.nnT != null) {
                this.nnT.cancel();
            }
            SquareModel.this.nnQ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.nnQ = null;
            SquareModel.this.nnR = hVar;
            if (SquareModel.this.nnS != null) {
                if (this.nnU == 0 || this.nnT.isRequestSuccess()) {
                    SquareModel.this.nnS.a(true, null, hVar);
                    return;
                }
                SquareModel.this.nnS.a(false, this.nnT.bot(), hVar);
            }
        }
    }
}
