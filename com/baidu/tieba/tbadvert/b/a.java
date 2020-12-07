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
    private com.baidu.tieba.tbadvert.a.a nqo;
    private InterfaceC0872a nqp;
    private InterfaceC0872a nqq = new InterfaceC0872a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.nqo = aVar;
            if (a.this.nqp != null) {
                a.this.nqp.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void aR(Object obj) {
            if (a.this.nqp != null) {
                a.this.nqp.aR(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void dQN() {
            a.this.nqo = null;
            if (a.this.nqp != null) {
                a.this.nqp.dQN();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> nqr = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.nqp != null) {
                    a.this.nqp.dQN();
                }
            } else if (a.this.nqp != null) {
                a.this.nqp.aR(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.nqp != null) {
                a.this.nqp.dQN();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0872a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aR(Object obj);

        void dQN();
    }

    public void dQR() {
        b bVar = new b(this.nqq);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dQS() {
        if (this.nqo == null || y.isEmpty(this.nqo.nql)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.nqo.nql) {
            if (bVar != null && bVar.dQQ() && bVar.eKB == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dQT() {
        com.baidu.tieba.tbadvert.a.b dQS = dQS();
        if (dQS != null && !TextUtils.isEmpty(dQS.nqn)) {
            p(dQS.showType, dQS.nqn, true);
        } else if (this.nqp != null) {
            this.nqp.dQN();
        }
    }

    public void dQU() {
        if (this.nqo != null && !y.isEmpty(this.nqo.nql)) {
            com.baidu.tieba.tbadvert.a.b dQS = dQS();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.nqo.nql) {
                if (bVar != null && bVar != dQS && bVar.dQQ() && bVar.eKB != 4) {
                    p(bVar.showType, bVar.nqn, false);
                }
            }
        }
    }

    private void p(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.mS().a(str, 10, this.nqr, null);
            } else {
                c.mS().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0872a interfaceC0872a) {
        this.nqp = interfaceC0872a;
    }

    /* loaded from: classes26.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0872a nqp;

        public b(InterfaceC0872a interfaceC0872a) {
            this.nqp = interfaceC0872a;
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
            if (this.nqp != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.nqp.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.nqp.dQN();
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
