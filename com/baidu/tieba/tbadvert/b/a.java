package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes25.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a msW;
    private InterfaceC0807a msX;
    private InterfaceC0807a msY = new InterfaceC0807a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0807a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.msW = aVar;
            if (a.this.msX != null) {
                a.this.msX.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0807a
        public void aM(Object obj) {
            if (a.this.msX != null) {
                a.this.msX.aM(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0807a
        public void dCa() {
            a.this.msW = null;
            if (a.this.msX != null) {
                a.this.msX.dCa();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> msZ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.msX != null) {
                    a.this.msX.dCa();
                }
            } else if (a.this.msX != null) {
                a.this.msX.aM(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.msX != null) {
                a.this.msX.dCa();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0807a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aM(Object obj);

        void dCa();
    }

    public void dCe() {
        b bVar = new b(this.msY);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dCf() {
        if (this.msW == null || y.isEmpty(this.msW.msT)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.msW.msT) {
            if (bVar != null && bVar.dCd() && bVar.eeM == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dCg() {
        com.baidu.tieba.tbadvert.a.b dCf = dCf();
        if (dCf != null && !TextUtils.isEmpty(dCf.msV)) {
            m(dCf.showType, dCf.msV, true);
        } else if (this.msX != null) {
            this.msX.dCa();
        }
    }

    public void dCh() {
        if (this.msW != null && !y.isEmpty(this.msW.msT)) {
            com.baidu.tieba.tbadvert.a.b dCf = dCf();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.msW.msT) {
                if (bVar != null && bVar != dCf && bVar.dCd() && bVar.eeM != 4) {
                    m(bVar.showType, bVar.msV, false);
                }
            }
        }
    }

    private void m(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.mR().a(str, 10, this.msZ, null);
            } else {
                c.mR().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0807a interfaceC0807a) {
        this.msX = interfaceC0807a;
    }

    /* loaded from: classes25.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0807a msX;

        public b(InterfaceC0807a interfaceC0807a) {
            this.msX = interfaceC0807a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = aaVar.postNetData();
            if (!aaVar.bjL().bkr().isRequestSuccess() || RF(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.msX != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.msX.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.msX.dCa();
                }
            }
        }

        private boolean RF(String str) {
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
