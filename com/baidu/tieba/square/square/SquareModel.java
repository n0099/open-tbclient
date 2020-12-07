package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes23.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long iyk;
    private long iyl;
    private long iym;
    private long iyn;
    private long mTimeStamp;
    private b nik;
    private h nil;
    private a nim;

    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.nik = null;
        this.nil = null;
        this.nim = null;
        this.iyk = 0L;
        this.iyl = 0L;
        this.iym = 0L;
        this.iyn = 0L;
        this.nil = new h();
    }

    public long cwl() {
        return this.iyn;
    }

    public long cwm() {
        return this.iyl;
    }

    public long cwn() {
        return this.iym;
    }

    public long cwo() {
        return this.iyk;
    }

    public h dNW() {
        return this.nil;
    }

    public void a(a aVar) {
        this.nim = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nik != null) {
            this.nik.cancel();
            return false;
        }
        return false;
    }

    public boolean dNX() {
        return KI(1);
    }

    public boolean dNY() {
        return KI(0);
    }

    public boolean KI(int i) {
        if (this.nik != null) {
            return false;
        }
        this.nik = new b(i);
        this.nik.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int nio;
        private com.baidu.tieba.square.b.a nin = null;
        private l<String> nip = null;

        public b(int i) {
            this.nio = 1;
            this.nio = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.nin = new com.baidu.tieba.square.b.a();
            this.nip = com.baidu.tbadk.core.c.a.brq().Bo("tb.square");
            if (this.nio == 0) {
                String str2 = this.nip.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dNQ()) {
                    this.nio = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.nio == 1) {
                SquareModel.this.iyk = System.currentTimeMillis();
                this.nin.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.nin.dNt();
                SquareModel.this.iyl = this.nin.dNu();
                SquareModel.this.iym = this.nin.dNv();
                SquareModel.this.iyn = System.currentTimeMillis();
            }
            if (this.nin.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.nip.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.nip.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.bk(hVar3.dNT());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.nip.set("square_cache_key", hVar4.dNU(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.nip.set("square_cache_key", str, 86400000L);
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
            if (this.nin != null) {
                this.nin.cancel();
            }
            SquareModel.this.nik = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.nik = null;
            SquareModel.this.nil = hVar;
            if (SquareModel.this.nim != null) {
                if (this.nio == 0 || this.nin.isRequestSuccess()) {
                    SquareModel.this.nim.a(true, null, hVar);
                    return;
                }
                SquareModel.this.nim.a(false, this.nin.blT(), hVar);
            }
        }
    }
}
