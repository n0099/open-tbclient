package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes17.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long hyi;
    private long hyj;
    private long hyk;
    private long hyl;
    private long mTimeStamp;
    private b mbD;
    private h mbE;
    private a mbF;

    /* loaded from: classes17.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.mbD = null;
        this.mbE = null;
        this.mbF = null;
        this.hyi = 0L;
        this.hyj = 0L;
        this.hyk = 0L;
        this.hyl = 0L;
        this.mbE = new h();
    }

    public long cfY() {
        return this.hyl;
    }

    public long cfZ() {
        return this.hyj;
    }

    public long cga() {
        return this.hyk;
    }

    public long cgb() {
        return this.hyi;
    }

    public h dvB() {
        return this.mbE;
    }

    public void a(a aVar) {
        this.mbF = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mbD != null) {
            this.mbD.cancel();
            return false;
        }
        return false;
    }

    public boolean dvC() {
        return HC(1);
    }

    public boolean dvD() {
        return HC(0);
    }

    public boolean HC(int i) {
        if (this.mbD != null) {
            return false;
        }
        this.mbD = new b(i);
        this.mbD.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int mbH;
        private com.baidu.tieba.square.b.a mbG = null;
        private l<String> mbI = null;

        public b(int i) {
            this.mbH = 1;
            this.mbH = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public h doInBackground(Object... objArr) {
            h hVar;
            String str = null;
            this.mbG = new com.baidu.tieba.square.b.a();
            this.mbI = com.baidu.tbadk.core.c.a.bhb().zy("tb.square");
            if (this.mbH == 0) {
                String str2 = this.mbI.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                h hVar2 = new h();
                hVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = hVar2.getTimeStamp();
                if (hVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar2.dvv()) {
                    this.mbH = 1;
                    str = str2;
                    hVar = hVar2;
                } else {
                    return hVar2;
                }
            } else {
                hVar = null;
            }
            if (this.mbH == 1) {
                SquareModel.this.hyi = System.currentTimeMillis();
                this.mbG.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.mbG.duY();
                SquareModel.this.hyj = this.mbG.duZ();
                SquareModel.this.hyk = this.mbG.dva();
                SquareModel.this.hyl = System.currentTimeMillis();
            }
            if (this.mbG.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.mbI.set("square_cache_key", str, 86400000L);
                    hVar = hVar3;
                } else {
                    String str3 = this.mbI.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.bc(hVar3.dvy());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.mbI.set("square_cache_key", hVar4.dvz(), 86400000L);
                        hVar = hVar4;
                    } else {
                        this.mbI.set("square_cache_key", str, 86400000L);
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
            if (this.mbG != null) {
                this.mbG.cancel();
            }
            SquareModel.this.mbD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.mbD = null;
            SquareModel.this.mbE = hVar;
            if (SquareModel.this.mbF != null) {
                if (this.mbH == 0 || this.mbG.isRequestSuccess()) {
                    SquareModel.this.mbF.a(true, null, hVar);
                    return;
                }
                SquareModel.this.mbF.a(false, this.mbG.bbK(), hVar);
            }
        }
    }
}
