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
    private com.baidu.tieba.tbadvert.a.a jlN;
    private InterfaceC0518a jlO;
    private InterfaceC0518a jlP = new InterfaceC0518a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0518a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.jlN = aVar;
            if (a.this.jlO != null) {
                a.this.jlO.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0518a
        public void at(Object obj) {
            if (a.this.jlO != null) {
                a.this.jlO.at(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0518a
        public void cpM() {
            a.this.jlN = null;
            if (a.this.jlO != null) {
                a.this.jlO.cpM();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jlQ = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.jlO != null) {
                    a.this.jlO.cpM();
                }
            } else if (a.this.jlO != null) {
                a.this.jlO.at(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.jlO != null) {
                a.this.jlO.cpM();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0518a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void at(Object obj);

        void cpM();
    }

    public void cpQ() {
        b bVar = new b(this.jlP);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cpR() {
        if (this.jlN == null || v.isEmpty(this.jlN.jlK)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.jlN.jlK) {
            if (bVar != null && bVar.cpP() && bVar.cbV == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cpS() {
        com.baidu.tieba.tbadvert.a.b cpR = cpR();
        if (cpR != null && !TextUtils.isEmpty(cpR.jlM)) {
            j(cpR.showType, cpR.jlM, true);
        } else if (this.jlO != null) {
            this.jlO.cpM();
        }
    }

    public void cpT() {
        if (this.jlN != null && !v.isEmpty(this.jlN.jlK)) {
            com.baidu.tieba.tbadvert.a.b cpR = cpR();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.jlN.jlK) {
                if (bVar != null && bVar != cpR && bVar.cpP() && bVar.cbV != 4) {
                    j(bVar.showType, bVar.jlM, false);
                }
            }
        }
    }

    private void j(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.fT().a(str, 10, this.jlQ, null);
            } else {
                c.fT().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0518a interfaceC0518a) {
        this.jlO = interfaceC0518a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0518a jlO;

        public b(InterfaceC0518a interfaceC0518a) {
            this.jlO = interfaceC0518a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.amp().amQ().isRequestSuccess() || Ek(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.jlO != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.jlO.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.jlO.cpM();
                }
            }
        }

        private boolean Ek(String str) {
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
