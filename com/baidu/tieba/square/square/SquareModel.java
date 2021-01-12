package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long iFS;
    private long iFT;
    private long iFU;
    private long iFV;
    private long mTimeStamp;
    private b njm;
    private h njn;
    private a njo;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, String str, h hVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.njm = null;
        this.njn = null;
        this.njo = null;
        this.iFS = 0L;
        this.iFT = 0L;
        this.iFU = 0L;
        this.iFV = 0L;
        this.njn = new h();
    }

    public long cvo() {
        return this.iFV;
    }

    public long cvp() {
        return this.iFT;
    }

    public long cvq() {
        return this.iFU;
    }

    public long cvr() {
        return this.iFS;
    }

    public h dJY() {
        return this.njn;
    }

    public void a(a aVar) {
        this.njo = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.njm != null) {
            this.njm.cancel();
            return false;
        }
        return false;
    }

    public boolean dJZ() {
        return IW(1);
    }

    public boolean dKa() {
        return IW(0);
    }

    public boolean IW(int i) {
        if (this.njm != null) {
            return false;
        }
        this.njm = new b(i);
        this.njm.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, h, h> {
        private int njq;
        private com.baidu.tieba.square.a.a njp = null;
        private l<String> njr = null;

        public b(int i) {
            this.njq = 1;
            this.njq = i;
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
            this.njp = new com.baidu.tieba.square.a.a();
            this.njr = com.baidu.tbadk.core.c.a.bpZ().Ab("tb.square");
            if (this.njq == 0) {
                str = this.njr.get("square_cache_key");
                if (str == null) {
                    return null;
                }
                hVar = new h();
                hVar.parserJson(str);
                SquareModel.this.mTimeStamp = hVar.getTimeStamp();
                if (hVar.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!hVar.dJS()) {
                    this.njq = 1;
                } else {
                    return hVar;
                }
            } else {
                hVar = null;
                str = null;
            }
            if (this.njq == 1) {
                SquareModel.this.iFS = System.currentTimeMillis();
                this.njp.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.njp.dJv();
                SquareModel.this.iFT = this.njp.dJw();
                SquareModel.this.iFU = this.njp.dJx();
                SquareModel.this.iFV = System.currentTimeMillis();
            }
            String str2 = str;
            if (this.njp.isRequestSuccess()) {
                h hVar3 = new h();
                hVar3.parserJson(str2);
                Long valueOf = Long.valueOf(hVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.njr.set("square_cache_key", str2, 86400000L);
                    hVar2 = hVar3;
                } else {
                    String str3 = this.njr.get("square_cache_key");
                    if (str3 != null) {
                        h hVar4 = new h();
                        hVar4.parserJson(str3);
                        hVar4.bf(hVar3.dJV());
                        hVar4.setTimeStamp(valueOf.longValue());
                        this.njr.set("square_cache_key", hVar4.dJW(), 86400000L);
                        hVar2 = hVar4;
                    } else {
                        this.njr.set("square_cache_key", str2, 86400000L);
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
            if (this.njp != null) {
                this.njp.cancel();
            }
            SquareModel.this.njm = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(h hVar) {
            SquareModel.this.njm = null;
            SquareModel.this.njn = hVar;
            if (SquareModel.this.njo != null) {
                if (this.njq == 0 || this.njp.isRequestSuccess()) {
                    SquareModel.this.njo.a(true, null, hVar);
                    return;
                }
                SquareModel.this.njo.a(false, this.njp.bkz(), hVar);
            }
        }
    }
}
