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
    private com.baidu.tieba.tbadvert.a.a kkF;
    private InterfaceC0615a kkG;
    private InterfaceC0615a kkH = new InterfaceC0615a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.kkF = aVar;
            if (a.this.kkG != null) {
                a.this.kkG.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void aB(Object obj) {
            if (a.this.kkG != null) {
                a.this.kkG.aB(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void cMr() {
            a.this.kkF = null;
            if (a.this.kkG != null) {
                a.this.kkG.cMr();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kkI = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.kkG != null) {
                    a.this.kkG.cMr();
                }
            } else if (a.this.kkG != null) {
                a.this.kkG.aB(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.kkG != null) {
                a.this.kkG.cMr();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0615a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aB(Object obj);

        void cMr();
    }

    public void cMv() {
        b bVar = new b(this.kkH);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cMw() {
        if (this.kkF == null || v.isEmpty(this.kkF.kkC)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.kkF.kkC) {
            if (bVar != null && bVar.cMu() && bVar.cSJ == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cMx() {
        com.baidu.tieba.tbadvert.a.b cMw = cMw();
        if (cMw != null && !TextUtils.isEmpty(cMw.kkE)) {
            m(cMw.showType, cMw.kkE, true);
        } else if (this.kkG != null) {
            this.kkG.cMr();
        }
    }

    public void cMy() {
        if (this.kkF != null && !v.isEmpty(this.kkF.kkC)) {
            com.baidu.tieba.tbadvert.a.b cMw = cMw();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.kkF.kkC) {
                if (bVar != null && bVar != cMw && bVar.cMu() && bVar.cSJ != 4) {
                    m(bVar.showType, bVar.kkE, false);
                }
            }
        }
    }

    private void m(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.gr().a(str, 10, this.kkI, null);
            } else {
                c.gr().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0615a interfaceC0615a) {
        this.kkG = interfaceC0615a;
    }

    /* loaded from: classes13.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0615a kkG;

        public b(InterfaceC0615a interfaceC0615a) {
            this.kkG = interfaceC0615a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.aGe().aGG().isRequestSuccess() || Jw(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.kkG != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.kkG.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.kkG.cMr();
                }
            }
        }

        private boolean Jw(String str) {
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
