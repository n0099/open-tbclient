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
    private com.baidu.tieba.tbadvert.a.a iKd;
    private InterfaceC0393a iKe;
    private InterfaceC0393a iKf = new InterfaceC0393a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.iKd = aVar;
            if (a.this.iKe != null) {
                a.this.iKe.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void aA(Object obj) {
            if (a.this.iKe != null) {
                a.this.iKe.aA(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void cfM() {
            a.this.iKd = null;
            if (a.this.iKe != null) {
                a.this.iKe.cfM();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> iKg = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.oy() == null) {
                if (a.this.iKe != null) {
                    a.this.iKe.cfM();
                }
            } else if (a.this.iKe != null) {
                a.this.iKe.aA(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.iKe != null) {
                a.this.iKe.cfM();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0393a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aA(Object obj);

        void cfM();
    }

    public void cfQ() {
        b bVar = new b(this.iKf);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cfR() {
        if (this.iKd == null || v.T(this.iKd.iKa)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.iKd.iKa) {
            if (bVar != null && bVar.cfP() && bVar.bCg == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cfS() {
        com.baidu.tieba.tbadvert.a.b cfR = cfR();
        if (cfR != null && !TextUtils.isEmpty(cfR.iKc)) {
            h(cfR.showType, cfR.iKc, true);
        } else if (this.iKe != null) {
            this.iKe.cfM();
        }
    }

    public void cfT() {
        if (this.iKd != null && !v.T(this.iKd.iKa)) {
            com.baidu.tieba.tbadvert.a.b cfR = cfR();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.iKd.iKa) {
                if (bVar != null && bVar != cfR && bVar.cfP() && bVar.bCg != 4) {
                    h(bVar.showType, bVar.iKc, false);
                }
            }
        }
    }

    private void h(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.jB().a(str, 10, this.iKg, null);
            } else {
                c.jB().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0393a interfaceC0393a) {
        this.iKe = interfaceC0393a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0393a iKe;

        public b(InterfaceC0393a interfaceC0393a) {
            this.iKe = interfaceC0393a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String acj = xVar.acj();
            if (!xVar.acH().adG().isRequestSuccess() || CV(acj)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.CU(acj);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.iKe != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.iKe.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.iKe.cfM();
                }
            }
        }

        private boolean CV(String str) {
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
