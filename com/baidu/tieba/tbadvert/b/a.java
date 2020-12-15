package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes26.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a nqq;
    private InterfaceC0872a nqr;
    private InterfaceC0872a nqs = new InterfaceC0872a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.nqq = aVar;
            if (a.this.nqr != null) {
                a.this.nqr.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void aR(Object obj) {
            if (a.this.nqr != null) {
                a.this.nqr.aR(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void dQO() {
            a.this.nqq = null;
            if (a.this.nqr != null) {
                a.this.nqr.dQO();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> nqt = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.nqr != null) {
                    a.this.nqr.dQO();
                }
            } else if (a.this.nqr != null) {
                a.this.nqr.aR(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.nqr != null) {
                a.this.nqr.dQO();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0872a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aR(Object obj);

        void dQO();
    }

    public void dQS() {
        b bVar = new b(this.nqs);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dQT() {
        if (this.nqq == null || y.isEmpty(this.nqq.nqn)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.nqq.nqn) {
            if (bVar != null && bVar.dQR() && bVar.eKB == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dQU() {
        com.baidu.tieba.tbadvert.a.b dQT = dQT();
        if (dQT != null && !TextUtils.isEmpty(dQT.nqp)) {
            p(dQT.showType, dQT.nqp, true);
        } else if (this.nqr != null) {
            this.nqr.dQO();
        }
    }

    public void dQV() {
        if (this.nqq != null && !y.isEmpty(this.nqq.nqn)) {
            com.baidu.tieba.tbadvert.a.b dQT = dQT();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.nqq.nqn) {
                if (bVar != null && bVar != dQT && bVar.dQR() && bVar.eKB != 4) {
                    p(bVar.showType, bVar.nqp, false);
                }
            }
        }
    }

    private void p(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.mS().a(str, 10, this.nqt, null);
            } else {
                c.mS().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0872a interfaceC0872a) {
        this.nqr = interfaceC0872a;
    }

    /* loaded from: classes26.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0872a nqr;

        public b(InterfaceC0872a interfaceC0872a) {
            this.nqr = interfaceC0872a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = aaVar.postNetData();
            if (!aaVar.btv().buf().isRequestSuccess() || Uj(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.nqr != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.nqr.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.nqr.dQO();
                }
            }
        }

        private boolean Uj(String str) {
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
