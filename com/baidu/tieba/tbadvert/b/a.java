package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a kgb;
    private InterfaceC0602a kgc;
    private InterfaceC0602a kgd = new InterfaceC0602a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0602a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.kgb = aVar;
            if (a.this.kgc != null) {
                a.this.kgc.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0602a
        public void az(Object obj) {
            if (a.this.kgc != null) {
                a.this.kgc.az(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0602a
        public void cJQ() {
            a.this.kgb = null;
            if (a.this.kgc != null) {
                a.this.kgc.cJQ();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kge = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.kgc != null) {
                    a.this.kgc.cJQ();
                }
            } else if (a.this.kgc != null) {
                a.this.kgc.az(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.kgc != null) {
                a.this.kgc.cJQ();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0602a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void az(Object obj);

        void cJQ();
    }

    public void cJU() {
        b bVar = new b(this.kgd);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cJV() {
        if (this.kgb == null || v.isEmpty(this.kgb.kfY)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.kgb.kfY) {
            if (bVar != null && bVar.cJT() && bVar.cOx == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cJW() {
        com.baidu.tieba.tbadvert.a.b cJV = cJV();
        if (cJV != null && !TextUtils.isEmpty(cJV.kga)) {
            m(cJV.showType, cJV.kga, true);
        } else if (this.kgc != null) {
            this.kgc.cJQ();
        }
    }

    public void cJX() {
        if (this.kgb != null && !v.isEmpty(this.kgb.kfY)) {
            com.baidu.tieba.tbadvert.a.b cJV = cJV();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.kgb.kfY) {
                if (bVar != null && bVar != cJV && bVar.cJT() && bVar.cOx != 4) {
                    m(bVar.showType, bVar.kga, false);
                }
            }
        }
    }

    private void m(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.gs().a(str, 10, this.kge, null);
            } else {
                c.gs().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0602a interfaceC0602a) {
        this.kgc = interfaceC0602a;
    }

    /* loaded from: classes10.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0602a kgc;

        public b(InterfaceC0602a interfaceC0602a) {
            this.kgc = interfaceC0602a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.aDB().aEc().isRequestSuccess() || IZ(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.kgc != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.kgc.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.kgc.cJQ();
                }
            }
        }

        private boolean IZ(String str) {
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
