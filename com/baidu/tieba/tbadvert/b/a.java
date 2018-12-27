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
    private com.baidu.tieba.tbadvert.a.a hss;
    private InterfaceC0320a hst;
    private InterfaceC0320a hsu = new InterfaceC0320a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.hss = aVar;
            if (a.this.hst != null) {
                a.this.hst.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void ak(Object obj) {
            if (a.this.hst != null) {
                a.this.hst.ak(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void bFC() {
            a.this.hss = null;
            if (a.this.hst != null) {
                a.this.hst.bFC();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hsv = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.op() == null) {
                if (a.this.hst != null) {
                    a.this.hst.bFC();
                }
            } else if (a.this.hst != null) {
                a.this.hst.ak(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.hst != null) {
                a.this.hst.bFC();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0320a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void ak(Object obj);

        void bFC();
    }

    public void bFG() {
        b bVar = new b(this.hsu);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b bFH() {
        if (this.hss == null || v.I(this.hss.hsp)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.hss.hsp) {
            if (bVar != null && bVar.bFF() && bVar.auk == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void bFI() {
        com.baidu.tieba.tbadvert.a.b bFH = bFH();
        if (bFH != null && !TextUtils.isEmpty(bFH.hsr)) {
            h(bFH.showType, bFH.hsr, true);
        } else if (this.hst != null) {
            this.hst.bFC();
        }
    }

    public void bFJ() {
        if (this.hss != null && !v.I(this.hss.hsp)) {
            com.baidu.tieba.tbadvert.a.b bFH = bFH();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.hss.hsp) {
                if (bVar != null && bVar != bFH && bVar.bFF() && bVar.auk != 4) {
                    h(bVar.showType, bVar.hsr, false);
                }
            }
        }
    }

    private void h(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.jA().a(str, 10, this.hsv, null);
            } else {
                c.jA().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0320a interfaceC0320a) {
        this.hst = interfaceC0320a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0320a hst;

        public b(InterfaceC0320a interfaceC0320a) {
            this.hst = interfaceC0320a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String CL = xVar.CL();
            if (!xVar.Dj().Ei().isRequestSuccess() || we(CL)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.wd(CL);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.hst != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.hst.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.hst.bFC();
                }
            }
        }

        private boolean we(String str) {
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
