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
    private com.baidu.tieba.tbadvert.a.a kWB;
    private InterfaceC0657a kWC;
    private InterfaceC0657a kWD = new InterfaceC0657a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0657a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.kWB = aVar;
            if (a.this.kWC != null) {
                a.this.kWC.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0657a
        public void aD(Object obj) {
            if (a.this.kWC != null) {
                a.this.kWC.aD(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0657a
        public void cXL() {
            a.this.kWB = null;
            if (a.this.kWC != null) {
                a.this.kWC.cXL();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kWE = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.kWC != null) {
                    a.this.kWC.cXL();
                }
            } else if (a.this.kWC != null) {
                a.this.kWC.aD(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.kWC != null) {
                a.this.kWC.cXL();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0657a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aD(Object obj);

        void cXL();
    }

    public void cXP() {
        b bVar = new b(this.kWD);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cXQ() {
        if (this.kWB == null || v.isEmpty(this.kWB.kWy)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.kWB.kWy) {
            if (bVar != null && bVar.cXO() && bVar.dsh == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cXR() {
        com.baidu.tieba.tbadvert.a.b cXQ = cXQ();
        if (cXQ != null && !TextUtils.isEmpty(cXQ.kWA)) {
            n(cXQ.showType, cXQ.kWA, true);
        } else if (this.kWC != null) {
            this.kWC.cXL();
        }
    }

    public void cXS() {
        if (this.kWB != null && !v.isEmpty(this.kWB.kWy)) {
            com.baidu.tieba.tbadvert.a.b cXQ = cXQ();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.kWB.kWy) {
                if (bVar != null && bVar != cXQ && bVar.cXO() && bVar.dsh != 4) {
                    n(bVar.showType, bVar.kWA, false);
                }
            }
        }
    }

    private void n(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.kV().a(str, 10, this.kWE, null);
            } else {
                c.kV().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0657a interfaceC0657a) {
        this.kWC = interfaceC0657a;
    }

    /* loaded from: classes13.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0657a kWC;

        public b(InterfaceC0657a interfaceC0657a) {
            this.kWC = interfaceC0657a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.aOy().aPa().isRequestSuccess() || Lg(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.kWC != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.kWC.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.kWC.cXL();
                }
            }
        }

        private boolean Lg(String str) {
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
