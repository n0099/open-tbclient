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
    private com.baidu.tieba.tbadvert.a.a iKl;
    private InterfaceC0312a iKm;
    private InterfaceC0312a iKn = new InterfaceC0312a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0312a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.iKl = aVar;
            if (a.this.iKm != null) {
                a.this.iKm.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0312a
        public void aA(Object obj) {
            if (a.this.iKm != null) {
                a.this.iKm.aA(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0312a
        public void cfK() {
            a.this.iKl = null;
            if (a.this.iKm != null) {
                a.this.iKm.cfK();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> iKo = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.oy() == null) {
                if (a.this.iKm != null) {
                    a.this.iKm.cfK();
                }
            } else if (a.this.iKm != null) {
                a.this.iKm.aA(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.iKm != null) {
                a.this.iKm.cfK();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0312a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aA(Object obj);

        void cfK();
    }

    public void cfO() {
        b bVar = new b(this.iKn);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cfP() {
        if (this.iKl == null || v.T(this.iKl.iKi)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.iKl.iKi) {
            if (bVar != null && bVar.cfN() && bVar.bCe == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cfQ() {
        com.baidu.tieba.tbadvert.a.b cfP = cfP();
        if (cfP != null && !TextUtils.isEmpty(cfP.iKk)) {
            h(cfP.showType, cfP.iKk, true);
        } else if (this.iKm != null) {
            this.iKm.cfK();
        }
    }

    public void cfR() {
        if (this.iKl != null && !v.T(this.iKl.iKi)) {
            com.baidu.tieba.tbadvert.a.b cfP = cfP();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.iKl.iKi) {
                if (bVar != null && bVar != cfP && bVar.cfN() && bVar.bCe != 4) {
                    h(bVar.showType, bVar.iKk, false);
                }
            }
        }
    }

    private void h(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.jB().a(str, 10, this.iKo, null);
            } else {
                c.jB().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0312a interfaceC0312a) {
        this.iKm = interfaceC0312a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0312a iKm;

        public b(InterfaceC0312a interfaceC0312a) {
            this.iKm = interfaceC0312a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String acj = xVar.acj();
            if (!xVar.acH().adG().isRequestSuccess() || CX(acj)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.CW(acj);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.iKm != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.iKm.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.iKm.cfK();
                }
            }
        }

        private boolean CX(String str) {
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
