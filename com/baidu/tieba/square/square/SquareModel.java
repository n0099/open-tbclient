package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes22.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long inr;

    /* renamed from: int  reason: not valid java name */
    private long f7int;
    private long inu;
    private long inv;
    private long mTimeStamp;
    private b mUl;
    private h mUm;
    private a mUn;

    /* loaded from: classes22.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.mUl = null;
        this.mUm = null;
        this.mUn = null;
        this.inr = 0L;
        this.f7int = 0L;
        this.inu = 0L;
        this.inv = 0L;
        this.mUm = new h();
    }

    public long crW() {
        return this.inv;
    }

    public long crX() {
        return this.f7int;
    }

    public long crY() {
        return this.inu;
    }

    public long crZ() {
        return this.inr;
    }

    public h dIG() {
        return this.mUm;
    }

    public void a(a aVar) {
        this.mUn = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mUl != null) {
            this.mUl.cancel();
            return false;
        }
        return false;
    }

    public boolean dIH() {
        return JS(1);
    }

    public boolean dII() {
        return JS(0);
    }

    public boolean JS(int i) {
        if (this.mUl != null) {
            return false;
        }
        this.mUl = new b(i);
        this.mUl.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int mUp;
        private com.baidu.tieba.square.b.a mUo = null;
        private l<String> mUq = null;

        public b(int i) {
            this.mUp = 1;
            this.mUp = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.mUo = new com.baidu.tieba.square.b.a();
            this.mUq = com.baidu.tbadk.core.c.a.bob().AH("tb.square");
            if (this.mUp == 0) {
                String str2 = this.mUq.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dIA()) {
                    this.mUp = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.mUp == 1) {
                SquareModel.this.inr = System.currentTimeMillis();
                this.mUo.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.mUo.dId();
                SquareModel.this.f7int = this.mUo.dIe();
                SquareModel.this.inu = this.mUo.dIf();
                SquareModel.this.inv = System.currentTimeMillis();
            }
            if (this.mUo.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.mUq.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.mUq.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.bi(hVar3.dID());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.mUq.set("square_cache_key", hVar4.dIE(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.mUq.set("square_cache_key", str, 86400000L);
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
            if (this.mUo != null) {
                this.mUo.cancel();
            }
            SquareModel.this.mUl = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.mUl = null;
            SquareModel.this.mUm = hVar;
            if (SquareModel.this.mUn != null) {
                if (this.mUp == 0 || this.mUo.isRequestSuccess()) {
                    SquareModel.this.mUn.a(true, null, hVar);
                    return;
                }
                SquareModel.this.mUn.a(false, this.mUo.biJ(), hVar);
            }
        }
    }
}
