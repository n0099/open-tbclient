package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a kjE;
    private InterfaceC0607a kjF;
    private InterfaceC0607a kjG = new InterfaceC0607a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.kjE = aVar;
            if (a.this.kjF != null) {
                a.this.kjF.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void az(Object obj) {
            if (a.this.kjF != null) {
                a.this.kjF.az(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void cKU() {
            a.this.kjE = null;
            if (a.this.kjF != null) {
                a.this.kjF.cKU();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kjH = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.kjF != null) {
                    a.this.kjF.cKU();
                }
            } else if (a.this.kjF != null) {
                a.this.kjF.az(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.kjF != null) {
                a.this.kjF.cKU();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0607a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void az(Object obj);

        void cKU();
    }

    public void cKY() {
        b bVar = new b(this.kjG);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cKZ() {
        if (this.kjE == null || v.isEmpty(this.kjE.kjB)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.kjE.kjB) {
            if (bVar != null && bVar.cKX() && bVar.cOH == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cLa() {
        com.baidu.tieba.tbadvert.a.b cKZ = cKZ();
        if (cKZ != null && !TextUtils.isEmpty(cKZ.kjD)) {
            m(cKZ.showType, cKZ.kjD, true);
        } else if (this.kjF != null) {
            this.kjF.cKU();
        }
    }

    public void cLb() {
        if (this.kjE != null && !v.isEmpty(this.kjE.kjB)) {
            com.baidu.tieba.tbadvert.a.b cKZ = cKZ();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.kjE.kjB) {
                if (bVar != null && bVar != cKZ && bVar.cKX() && bVar.cOH != 4) {
                    m(bVar.showType, bVar.kjD, false);
                }
            }
        }
    }

    private void m(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.gr().a(str, 10, this.kjH, null);
            } else {
                c.gr().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0607a interfaceC0607a) {
        this.kjF = interfaceC0607a;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0607a kjF;

        public b(InterfaceC0607a interfaceC0607a) {
            this.kjF = interfaceC0607a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.aDU().aEv().isRequestSuccess() || Jj(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.kjF != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.kjF.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.kjF.cKU();
                }
            }
        }

        private boolean Jj(String str) {
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
