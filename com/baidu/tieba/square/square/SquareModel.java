package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    private long fcl;
    private long fcm;
    private long fcn;
    private long fco;
    private b jem;
    private f jen;
    private a jeo;
    private long mTimeStamp;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.jem = null;
        this.jen = null;
        this.jeo = null;
        this.fcl = 0L;
        this.fcm = 0L;
        this.fcn = 0L;
        this.fco = 0L;
        this.jen = new f();
    }

    public long beJ() {
        return this.fco;
    }

    public long beK() {
        return this.fcm;
    }

    public long beL() {
        return this.fcn;
    }

    public long beM() {
        return this.fcl;
    }

    public f cna() {
        return this.jen;
    }

    public void a(a aVar) {
        this.jeo = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jem != null) {
            this.jem.cancel();
            return false;
        }
        return false;
    }

    public boolean cnb() {
        return zD(1);
    }

    public boolean cnc() {
        return zD(0);
    }

    public boolean zD(int i) {
        if (this.jem != null) {
            return false;
        }
        this.jem = new b(i);
        this.jem.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        private int jeq;
        private com.baidu.tieba.square.a.a jep = null;
        private l<String> jer = null;

        public b(int i) {
            this.jeq = 1;
            this.jeq = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public f doInBackground(Object... objArr) {
            f fVar;
            String str = null;
            this.jep = new com.baidu.tieba.square.a.a();
            this.jer = com.baidu.tbadk.core.d.a.akL().nl("tb.square");
            if (this.jeq == 0) {
                String str2 = this.jer.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.parserJson(str2);
                SquareModel.this.mTimeStamp = fVar2.getTimeStamp();
                if (fVar2.isEmpty()) {
                    SquareModel.this.mTimeStamp = 0L;
                }
                if (!fVar2.cmU()) {
                    this.jeq = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    return fVar2;
                }
            } else {
                fVar = null;
            }
            if (this.jeq == 1) {
                SquareModel.this.fcl = System.currentTimeMillis();
                this.jep.addPostData("prevtime", SquareModel.this.mTimeStamp + "");
                str = this.jep.cmv();
                SquareModel.this.fcm = this.jep.cmw();
                SquareModel.this.fcn = this.jep.cmx();
                SquareModel.this.fco = System.currentTimeMillis();
            }
            if (this.jep.isRequestSuccess()) {
                f fVar3 = new f();
                fVar3.parserJson(str);
                Long valueOf = Long.valueOf(fVar3.getTimeStamp());
                if (valueOf.longValue() > SquareModel.this.mTimeStamp) {
                    this.jer.set("square_cache_key", str, 86400000L);
                    fVar = fVar3;
                } else {
                    String str3 = this.jer.get("square_cache_key");
                    if (str3 != null) {
                        f fVar4 = new f();
                        fVar4.parserJson(str3);
                        fVar4.aI(fVar3.cmX());
                        fVar4.setTimeStamp(valueOf.longValue());
                        this.jer.set("square_cache_key", fVar4.cmY(), 86400000L);
                        fVar = fVar4;
                    } else {
                        this.jer.set("square_cache_key", str, 86400000L);
                        fVar = fVar3;
                    }
                }
                SquareModel.this.mTimeStamp = valueOf.longValue();
            }
            return fVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.jep != null) {
                this.jep.cancel();
            }
            SquareModel.this.jem = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(f fVar) {
            SquareModel.this.jem = null;
            SquareModel.this.jen = fVar;
            if (SquareModel.this.jeo != null) {
                if (this.jeq == 0 || this.jep.isRequestSuccess()) {
                    SquareModel.this.jeo.a(true, null, fVar);
                    return;
                }
                SquareModel.this.jeo.a(false, this.jep.agm(), fVar);
            }
        }
    }
}
