package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes17.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long hyc;
    private long hyd;
    private long hye;
    private long hyf;
    private long mTimeStamp;
    private b mbo;
    private h mbp;
    private a mbq;

    /* loaded from: classes17.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.mbo = null;
        this.mbp = null;
        this.mbq = null;
        this.hyc = 0L;
        this.hyd = 0L;
        this.hye = 0L;
        this.hyf = 0L;
        this.mbp = new h();
    }

    public long cfX() {
        return this.hyf;
    }

    public long cfY() {
        return this.hyd;
    }

    public long cfZ() {
        return this.hye;
    }

    public long cga() {
        return this.hyc;
    }

    public h dvw() {
        return this.mbp;
    }

    public void a(a aVar) {
        this.mbq = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mbo != null) {
            this.mbo.cancel();
            return false;
        }
        return false;
    }

    public boolean dvx() {
        return HC(1);
    }

    public boolean dvy() {
        return HC(0);
    }

    public boolean HC(int i) {
        if (this.mbo != null) {
            return false;
        }
        this.mbo = new b(i);
        this.mbo.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int mbs;
        private com.baidu.tieba.square.b.a mbr = null;
        private l<String> mbt = null;

        public b(int i) {
            this.mbs = 1;
            this.mbs = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.mbr = new com.baidu.tieba.square.b.a();
            this.mbt = com.baidu.tbadk.core.c.a.bhb().zx("tb.square");
            if (this.mbs == 0) {
                String str2 = this.mbt.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dvq()) {
                    this.mbs = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.mbs == 1) {
                SquareModel.this.hyc = System.currentTimeMillis();
                this.mbr.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.mbr.duT();
                SquareModel.this.hyd = this.mbr.duU();
                SquareModel.this.hye = this.mbr.duV();
                SquareModel.this.hyf = System.currentTimeMillis();
            }
            if (this.mbr.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.mbt.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.mbt.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.bc(hVar3.dvt());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.mbt.set("square_cache_key", hVar4.dvu(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.mbt.set("square_cache_key", str, 86400000L);
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
            if (this.mbr != null) {
                this.mbr.cancel();
            }
            SquareModel.this.mbo = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.mbo = null;
            SquareModel.this.mbp = hVar;
            if (SquareModel.this.mbq != null) {
                if (this.mbs == 0 || this.mbr.isRequestSuccess()) {
                    SquareModel.this.mbq.a(true, null, hVar);
                    return;
                }
                SquareModel.this.mbq.a(false, this.mbr.bbK(), hVar);
            }
        }
    }
}
