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
    private com.baidu.tieba.tbadvert.a.a kWF;
    private InterfaceC0678a kWG;
    private InterfaceC0678a kWH = new InterfaceC0678a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0678a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.kWF = aVar;
            if (a.this.kWG != null) {
                a.this.kWG.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0678a
        public void aE(Object obj) {
            if (a.this.kWG != null) {
                a.this.kWG.aE(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0678a
        public void cXI() {
            a.this.kWF = null;
            if (a.this.kWG != null) {
                a.this.kWG.cXI();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kWI = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.kWG != null) {
                    a.this.kWG.cXI();
                }
            } else if (a.this.kWG != null) {
                a.this.kWG.aE(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.kWG != null) {
                a.this.kWG.cXI();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0678a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aE(Object obj);

        void cXI();
    }

    public void cXM() {
        b bVar = new b(this.kWH);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cXN() {
        if (this.kWF == null || v.isEmpty(this.kWF.kWC)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.kWF.kWC) {
            if (bVar != null && bVar.cXL() && bVar.dsl == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cXO() {
        com.baidu.tieba.tbadvert.a.b cXN = cXN();
        if (cXN != null && !TextUtils.isEmpty(cXN.kWE)) {
            n(cXN.showType, cXN.kWE, true);
        } else if (this.kWG != null) {
            this.kWG.cXI();
        }
    }

    public void cXP() {
        if (this.kWF != null && !v.isEmpty(this.kWF.kWC)) {
            com.baidu.tieba.tbadvert.a.b cXN = cXN();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.kWF.kWC) {
                if (bVar != null && bVar != cXN && bVar.cXL() && bVar.dsl != 4) {
                    n(bVar.showType, bVar.kWE, false);
                }
            }
        }
    }

    private void n(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.kV().a(str, 10, this.kWI, null);
            } else {
                c.kV().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0678a interfaceC0678a) {
        this.kWG = interfaceC0678a;
    }

    /* loaded from: classes13.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0678a kWG;

        public b(InterfaceC0678a interfaceC0678a) {
            this.kWG = interfaceC0678a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.aOw().aOX().isRequestSuccess() || Lj(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.kWG != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.kWG.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.kWG.cXI();
                }
            }
        }

        private boolean Lj(String str) {
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
