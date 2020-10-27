package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes23.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long igF;
    private long igG;
    private long igH;
    private long igI;
    private b mNo;
    private h mNp;
    private a mNq;
    private long mTimeStamp;

    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.mNo = null;
        this.mNp = null;
        this.mNq = null;
        this.igF = 0L;
        this.igG = 0L;
        this.igH = 0L;
        this.igI = 0L;
        this.mNp = new h();
    }

    public long cpS() {
        return this.igI;
    }

    public long cpT() {
        return this.igG;
    }

    public long cpU() {
        return this.igH;
    }

    public long cpV() {
        return this.igF;
    }

    public h dGn() {
        return this.mNp;
    }

    public void a(a aVar) {
        this.mNq = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mNo != null) {
            this.mNo.cancel();
            return false;
        }
        return false;
    }

    public boolean dGo() {
        return Jd(1);
    }

    public boolean dGp() {
        return Jd(0);
    }

    public boolean Jd(int i) {
        if (this.mNo != null) {
            return false;
        }
        this.mNo = new b(i);
        this.mNo.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int mNs;
        private com.baidu.tieba.square.b.a mNr = null;
        private l<String> mNt = null;

        public b(int i) {
            this.mNs = 1;
            this.mNs = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.mNr = new com.baidu.tieba.square.b.a();
            this.mNt = com.baidu.tbadk.core.c.a.bmx().AY("tb.square");
            if (this.mNs == 0) {
                String str2 = this.mNt.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dGh()) {
                    this.mNs = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.mNs == 1) {
                SquareModel.this.igF = System.currentTimeMillis();
                this.mNr.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.mNr.dFK();
                SquareModel.this.igG = this.mNr.dFL();
                SquareModel.this.igH = this.mNr.dFM();
                SquareModel.this.igI = System.currentTimeMillis();
            }
            if (this.mNr.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.mNt.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.mNt.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.bh(hVar3.dGk());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.mNt.set("square_cache_key", hVar4.dGl(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.mNt.set("square_cache_key", str, 86400000L);
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
            if (this.mNr != null) {
                this.mNr.cancel();
            }
            SquareModel.this.mNo = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.mNo = null;
            SquareModel.this.mNp = hVar;
            if (SquareModel.this.mNq != null) {
                if (this.mNs == 0 || this.mNr.isRequestSuccess()) {
                    SquareModel.this.mNq.a(true, null, hVar);
                    return;
                }
                SquareModel.this.mNq.a(false, this.mNr.bhf(), hVar);
            }
        }
    }
}
