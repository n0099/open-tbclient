package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes13.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a kkT;
    private InterfaceC0615a kkU;
    private InterfaceC0615a kkV = new InterfaceC0615a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.kkT = aVar;
            if (a.this.kkU != null) {
                a.this.kkU.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void aB(Object obj) {
            if (a.this.kkU != null) {
                a.this.kkU.aB(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void cMu() {
            a.this.kkT = null;
            if (a.this.kkU != null) {
                a.this.kkU.cMu();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kkW = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.kkU != null) {
                    a.this.kkU.cMu();
                }
            } else if (a.this.kkU != null) {
                a.this.kkU.aB(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.kkU != null) {
                a.this.kkU.cMu();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0615a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aB(Object obj);

        void cMu();
    }

    public void cMy() {
        b bVar = new b(this.kkV);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cMz() {
        if (this.kkT == null || v.isEmpty(this.kkT.kkQ)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.kkT.kkQ) {
            if (bVar != null && bVar.cMx() && bVar.cSL == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cMA() {
        com.baidu.tieba.tbadvert.a.b cMz = cMz();
        if (cMz != null && !TextUtils.isEmpty(cMz.kkS)) {
            m(cMz.showType, cMz.kkS, true);
        } else if (this.kkU != null) {
            this.kkU.cMu();
        }
    }

    public void cMB() {
        if (this.kkT != null && !v.isEmpty(this.kkT.kkQ)) {
            com.baidu.tieba.tbadvert.a.b cMz = cMz();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.kkT.kkQ) {
                if (bVar != null && bVar != cMz && bVar.cMx() && bVar.cSL != 4) {
                    m(bVar.showType, bVar.kkS, false);
                }
            }
        }
    }

    private void m(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.gr().a(str, 10, this.kkW, null);
            } else {
                c.gr().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0615a interfaceC0615a) {
        this.kkU = interfaceC0615a;
    }

    /* loaded from: classes13.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0615a kkU;

        public b(InterfaceC0615a interfaceC0615a) {
            this.kkU = interfaceC0615a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.aGg().aGI().isRequestSuccess() || Jx(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.kkU != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.kkU.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.kkU.cMu();
                }
            }
        }

        private boolean Jx(String str) {
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
