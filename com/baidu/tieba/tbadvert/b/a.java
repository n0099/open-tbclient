package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a htB;
    private InterfaceC0319a htC;
    private InterfaceC0319a htD = new InterfaceC0319a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0319a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.htB = aVar;
            if (a.this.htC != null) {
                a.this.htC.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0319a
        public void ak(Object obj) {
            if (a.this.htC != null) {
                a.this.htC.ak(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0319a
        public void bGl() {
            a.this.htB = null;
            if (a.this.htC != null) {
                a.this.htC.bGl();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> htE = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.ot() == null) {
                if (a.this.htC != null) {
                    a.this.htC.bGl();
                }
            } else if (a.this.htC != null) {
                a.this.htC.ak(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.htC != null) {
                a.this.htC.bGl();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0319a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void ak(Object obj);

        void bGl();
    }

    public void bGp() {
        b bVar = new b(this.htD);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b bGq() {
        if (this.htB == null || v.I(this.htB.hty)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.htB.hty) {
            if (bVar != null && bVar.bGo() && bVar.auN == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void bGr() {
        com.baidu.tieba.tbadvert.a.b bGq = bGq();
        if (bGq != null && !TextUtils.isEmpty(bGq.htA)) {
            h(bGq.showType, bGq.htA, true);
        } else if (this.htC != null) {
            this.htC.bGl();
        }
    }

    public void bGs() {
        if (this.htB != null && !v.I(this.htB.hty)) {
            com.baidu.tieba.tbadvert.a.b bGq = bGq();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.htB.hty) {
                if (bVar != null && bVar != bGq && bVar.bGo() && bVar.auN != 4) {
                    h(bVar.showType, bVar.htA, false);
                }
            }
        }
    }

    private void h(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.jA().a(str, 10, this.htE, null);
            } else {
                c.jA().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0319a interfaceC0319a) {
        this.htC = interfaceC0319a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0319a htC;

        public b(InterfaceC0319a interfaceC0319a) {
            this.htC = interfaceC0319a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String CY = xVar.CY();
            if (!xVar.Dw().Ev().isRequestSuccess() || wu(CY)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.wt(CY);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.htC != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.htC.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.htC.bGl();
                }
            }
        }

        private boolean wu(String str) {
            if (str != null) {
                try {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(str);
                    return errorData.error_code != 0;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return true;
                }
            }
            return true;
        }
    }
}
