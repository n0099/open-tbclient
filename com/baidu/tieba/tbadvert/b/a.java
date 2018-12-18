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
    private com.baidu.tieba.tbadvert.a.a hpg;
    private InterfaceC0320a hph;
    private InterfaceC0320a hpi = new InterfaceC0320a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.hpg = aVar;
            if (a.this.hph != null) {
                a.this.hph.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void ak(Object obj) {
            if (a.this.hph != null) {
                a.this.hph.ak(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void bEK() {
            a.this.hpg = null;
            if (a.this.hph != null) {
                a.this.hph.bEK();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hpj = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.op() == null) {
                if (a.this.hph != null) {
                    a.this.hph.bEK();
                }
            } else if (a.this.hph != null) {
                a.this.hph.ak(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.hph != null) {
                a.this.hph.bEK();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0320a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void ak(Object obj);

        void bEK();
    }

    public void bEO() {
        b bVar = new b(this.hpi);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b bEP() {
        if (this.hpg == null || v.I(this.hpg.hpd)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.hpg.hpd) {
            if (bVar != null && bVar.bEN() && bVar.auk == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void bEQ() {
        com.baidu.tieba.tbadvert.a.b bEP = bEP();
        if (bEP != null && !TextUtils.isEmpty(bEP.hpf)) {
            h(bEP.showType, bEP.hpf, true);
        } else if (this.hph != null) {
            this.hph.bEK();
        }
    }

    public void bER() {
        if (this.hpg != null && !v.I(this.hpg.hpd)) {
            com.baidu.tieba.tbadvert.a.b bEP = bEP();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.hpg.hpd) {
                if (bVar != null && bVar != bEP && bVar.bEN() && bVar.auk != 4) {
                    h(bVar.showType, bVar.hpf, false);
                }
            }
        }
    }

    private void h(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.jA().a(str, 10, this.hpj, null);
            } else {
                c.jA().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0320a interfaceC0320a) {
        this.hph = interfaceC0320a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0320a hph;

        public b(InterfaceC0320a interfaceC0320a) {
            this.hph = interfaceC0320a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String CL = xVar.CL();
            if (!xVar.Dj().Ei().isRequestSuccess() || wb(CL)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.wa(CL);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.hph != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.hph.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.hph.bEK();
                }
            }
        }

        private boolean wb(String str) {
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
