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
    private com.baidu.tieba.tbadvert.a.a iJP;
    private InterfaceC0393a iJQ;
    private InterfaceC0393a iJR = new InterfaceC0393a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.iJP = aVar;
            if (a.this.iJQ != null) {
                a.this.iJQ.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void aw(Object obj) {
            if (a.this.iJQ != null) {
                a.this.iJQ.aw(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void cfI() {
            a.this.iJP = null;
            if (a.this.iJQ != null) {
                a.this.iJQ.cfI();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> iJS = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.oy() == null) {
                if (a.this.iJQ != null) {
                    a.this.iJQ.cfI();
                }
            } else if (a.this.iJQ != null) {
                a.this.iJQ.aw(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.iJQ != null) {
                a.this.iJQ.cfI();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0393a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aw(Object obj);

        void cfI();
    }

    public void cfM() {
        b bVar = new b(this.iJR);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cfN() {
        if (this.iJP == null || v.T(this.iJP.iJM)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.iJP.iJM) {
            if (bVar != null && bVar.cfL() && bVar.bCk == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cfO() {
        com.baidu.tieba.tbadvert.a.b cfN = cfN();
        if (cfN != null && !TextUtils.isEmpty(cfN.iJO)) {
            h(cfN.showType, cfN.iJO, true);
        } else if (this.iJQ != null) {
            this.iJQ.cfI();
        }
    }

    public void cfP() {
        if (this.iJP != null && !v.T(this.iJP.iJM)) {
            com.baidu.tieba.tbadvert.a.b cfN = cfN();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.iJP.iJM) {
                if (bVar != null && bVar != cfN && bVar.cfL() && bVar.bCk != 4) {
                    h(bVar.showType, bVar.iJO, false);
                }
            }
        }
    }

    private void h(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.jB().a(str, 10, this.iJS, null);
            } else {
                c.jB().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0393a interfaceC0393a) {
        this.iJQ = interfaceC0393a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0393a iJQ;

        public b(InterfaceC0393a interfaceC0393a) {
            this.iJQ = interfaceC0393a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String acg = xVar.acg();
            if (!xVar.acE().adD().isRequestSuccess() || CU(acg)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.CT(acg);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.iJQ != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.iJQ.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.iJQ.cfI();
                }
            }
        }

        private boolean CU(String str) {
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
