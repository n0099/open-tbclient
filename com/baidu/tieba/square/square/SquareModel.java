package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long fWt;
    private long fWu;
    private long fWv;
    private long fWw;
    private b kdh;
    private h kdi;
    private a kdj;
    private long mTimeStamp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.kdh = null;
        this.kdi = null;
        this.kdj = null;
        this.fWt = 0L;
        this.fWu = 0L;
        this.fWv = 0L;
        this.fWw = 0L;
        this.kdi = new h();
    }

    public long byM() {
        return this.fWw;
    }

    public long byN() {
        return this.fWu;
    }

    public long byO() {
        return this.fWv;
    }

    public long byP() {
        return this.fWt;
    }

    public h cJS() {
        return this.kdi;
    }

    public void a(a aVar) {
        this.kdj = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kdh != null) {
            this.kdh.cancel();
            return false;
        }
        return false;
    }

    public boolean cJT() {
        return Cl(1);
    }

    public boolean cJU() {
        return Cl(0);
    }

    public boolean Cl(int i) {
        if (this.kdh != null) {
            return false;
        }
        this.kdh = new b(i);
        this.kdh.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int kdl;
        private com.baidu.tieba.square.a.a kdk = null;
        private l<String> kdm = null;

        public b(int i) {
            this.kdl = 1;
            this.kdl = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.kdk = new com.baidu.tieba.square.a.a();
            this.kdm = com.baidu.tbadk.core.c.a.aEB().sQ("tb.square");
            if (this.kdl == 0) {
                String str2 = this.kdm.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.cJM()) {
                    this.kdl = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.kdl == 1) {
                SquareModel.this.fWt = System.currentTimeMillis();
                this.kdk.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.kdk.cJq();
                SquareModel.this.fWu = this.kdk.cJr();
                SquareModel.this.fWv = this.kdk.cJs();
                SquareModel.this.fWw = System.currentTimeMillis();
            }
            if (this.kdk.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.kdm.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.kdm.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aR(hVar3.cJP());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.kdm.set("square_cache_key", hVar4.cJQ(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.kdm.set("square_cache_key", str, 86400000L);
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
            if (this.kdk != null) {
                this.kdk.cancel();
            }
            SquareModel.this.kdh = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.kdh = null;
            SquareModel.this.kdi = hVar;
            if (SquareModel.this.kdj != null) {
                if (this.kdl == 0 || this.kdk.isRequestSuccess()) {
                    SquareModel.this.kdj.a(true, null, hVar);
                    return;
                }
                SquareModel.this.kdj.a(false, this.kdk.azM(), hVar);
            }
        }
    }
}
