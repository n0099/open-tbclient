package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long gSH;
    private long gSI;
    private long gSJ;
    private long gSK;
    private b lhj;
    private h lhk;
    private a lhl;
    private long mTimeStamp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.lhj = null;
        this.lhk = null;
        this.lhl = null;
        this.gSH = 0L;
        this.gSI = 0L;
        this.gSJ = 0L;
        this.gSK = 0L;
        this.lhk = new h();
    }

    public long bPn() {
        return this.gSK;
    }

    public long bPo() {
        return this.gSI;
    }

    public long bPp() {
        return this.gSJ;
    }

    public long bPq() {
        return this.gSH;
    }

    public h dcl() {
        return this.lhk;
    }

    public void a(a aVar) {
        this.lhl = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lhj != null) {
            this.lhj.cancel();
            return false;
        }
        return false;
    }

    public boolean dcm() {
        return DF(1);
    }

    public boolean dcn() {
        return DF(0);
    }

    public boolean DF(int i) {
        if (this.lhj != null) {
            return false;
        }
        this.lhj = new b(i);
        this.lhj.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int lhn;
        private com.baidu.tieba.square.b.a lhm = null;
        private l<String> lho = null;

        public b(int i) {
            this.lhn = 1;
            this.lhn = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.lhm = new com.baidu.tieba.square.b.a();
            this.lho = com.baidu.tbadk.core.c.a.aSS().vM("tb.square");
            if (this.lhn == 0) {
                String str2 = this.lho.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dcf()) {
                    this.lhn = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.lhn == 1) {
                SquareModel.this.gSH = System.currentTimeMillis();
                this.lhm.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.lhm.dbI();
                SquareModel.this.gSI = this.lhm.dbJ();
                SquareModel.this.gSJ = this.lhm.dbK();
                SquareModel.this.gSK = System.currentTimeMillis();
            }
            if (this.lhm.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.lho.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.lho.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aU(hVar3.dci());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.lho.set("square_cache_key", hVar4.dcj(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.lho.set("square_cache_key", str, 86400000L);
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
            if (this.lhm != null) {
                this.lhm.cancel();
            }
            SquareModel.this.lhj = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.lhj = null;
            SquareModel.this.lhk = hVar;
            if (SquareModel.this.lhl != null) {
                if (this.lhn == 0 || this.lhm.isRequestSuccess()) {
                    SquareModel.this.lhl.a(true, null, hVar);
                    return;
                }
                SquareModel.this.lhl.a(false, this.lhm.aNO(), hVar);
            }
        }
    }
}
