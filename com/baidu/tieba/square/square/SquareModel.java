package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long gSS;
    private long gST;
    private long gSU;
    private long gSV;
    private b lis;
    private h lit;
    private a liu;
    private long mTimeStamp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.lis = null;
        this.lit = null;
        this.liu = null;
        this.gSS = 0L;
        this.gST = 0L;
        this.gSU = 0L;
        this.gSV = 0L;
        this.lit = new h();
    }

    public long bPp() {
        return this.gSV;
    }

    public long bPq() {
        return this.gST;
    }

    public long bPr() {
        return this.gSU;
    }

    public long bPs() {
        return this.gSS;
    }

    public h dcA() {
        return this.lit;
    }

    public void a(a aVar) {
        this.liu = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lis != null) {
            this.lis.cancel();
            return false;
        }
        return false;
    }

    public boolean dcB() {
        return DH(1);
    }

    public boolean dcC() {
        return DH(0);
    }

    public boolean DH(int i) {
        if (this.lis != null) {
            return false;
        }
        this.lis = new b(i);
        this.lis.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int liw;
        private com.baidu.tieba.square.b.a liv = null;
        private l<String> lix = null;

        public b(int i) {
            this.liw = 1;
            this.liw = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.liv = new com.baidu.tieba.square.b.a();
            this.lix = com.baidu.tbadk.core.c.a.aSS().vM("tb.square");
            if (this.liw == 0) {
                String str2 = this.lix.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dcu()) {
                    this.liw = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.liw == 1) {
                SquareModel.this.gSS = System.currentTimeMillis();
                this.liv.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.liv.dbX();
                SquareModel.this.gST = this.liv.dbY();
                SquareModel.this.gSU = this.liv.dbZ();
                SquareModel.this.gSV = System.currentTimeMillis();
            }
            if (this.liv.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.lix.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.lix.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.aU(hVar3.dcx());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.lix.set("square_cache_key", hVar4.dcy(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.lix.set("square_cache_key", str, 86400000L);
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
            if (this.liv != null) {
                this.liv.cancel();
            }
            SquareModel.this.lis = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.lis = null;
            SquareModel.this.lit = hVar;
            if (SquareModel.this.liu != null) {
                if (this.liw == 0 || this.liv.isRequestSuccess()) {
                    SquareModel.this.liu.a(true, null, hVar);
                    return;
                }
                SquareModel.this.liu.a(false, this.liv.aNO(), hVar);
            }
        }
    }
}
