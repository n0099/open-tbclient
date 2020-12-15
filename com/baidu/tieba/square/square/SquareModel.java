package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes23.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long iym;
    private long iyn;
    private long iyo;
    private long iyp;
    private long mTimeStamp;
    private b nim;
    private h nin;
    private a nio;

    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.nim = null;
        this.nin = null;
        this.nio = null;
        this.iym = 0L;
        this.iyn = 0L;
        this.iyo = 0L;
        this.iyp = 0L;
        this.nin = new h();
    }

    public long cwm() {
        return this.iyp;
    }

    public long cwn() {
        return this.iyn;
    }

    public long cwo() {
        return this.iyo;
    }

    public long cwp() {
        return this.iym;
    }

    public h dNX() {
        return this.nin;
    }

    public void a(a aVar) {
        this.nio = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nim != null) {
            this.nim.cancel();
            return false;
        }
        return false;
    }

    public boolean dNY() {
        return KI(1);
    }

    public boolean dNZ() {
        return KI(0);
    }

    public boolean KI(int i) {
        if (this.nim != null) {
            return false;
        }
        this.nim = new b(i);
        this.nim.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int niq;
        private com.baidu.tieba.square.b.a nip = null;
        private l<String> nir = null;

        public b(int i) {
            this.niq = 1;
            this.niq = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.nip = new com.baidu.tieba.square.b.a();
            this.nir = com.baidu.tbadk.core.c.a.brq().Bo("tb.square");
            if (this.niq == 0) {
                String str2 = this.nir.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dNR()) {
                    this.niq = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.niq == 1) {
                SquareModel.this.iym = System.currentTimeMillis();
                this.nip.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.nip.dNu();
                SquareModel.this.iyn = this.nip.dNv();
                SquareModel.this.iyo = this.nip.dNw();
                SquareModel.this.iyp = System.currentTimeMillis();
            }
            if (this.nip.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.nir.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.nir.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.bk(hVar3.dNU());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.nir.set("square_cache_key", hVar4.dNV(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.nir.set("square_cache_key", str, 86400000L);
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
            if (this.nip != null) {
                this.nip.cancel();
            }
            SquareModel.this.nim = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.nim = null;
            SquareModel.this.nin = hVar;
            if (SquareModel.this.nio != null) {
                if (this.niq == 0 || this.nip.isRequestSuccess()) {
                    SquareModel.this.nio.a(true, null, hVar);
                    return;
                }
                SquareModel.this.nio.a(false, this.nip.blT(), hVar);
            }
        }
    }
}
