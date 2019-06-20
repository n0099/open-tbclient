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
    private com.baidu.tieba.tbadvert.a.a jcO;
    private InterfaceC0412a jcP;
    private InterfaceC0412a jcQ = new InterfaceC0412a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.jcO = aVar;
            if (a.this.jcP != null) {
                a.this.jcP.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void ay(Object obj) {
            if (a.this.jcP != null) {
                a.this.jcP.ay(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void cnP() {
            a.this.jcO = null;
            if (a.this.jcP != null) {
                a.this.jcP.cnP();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jcR = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.ns() == null) {
                if (a.this.jcP != null) {
                    a.this.jcP.cnP();
                }
            } else if (a.this.jcP != null) {
                a.this.jcP.ay(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.jcP != null) {
                a.this.jcP.cnP();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0412a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void ay(Object obj);

        void cnP();
    }

    public void cnT() {
        b bVar = new b(this.jcQ);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cnU() {
        if (this.jcO == null || v.aa(this.jcO.jcL)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.jcO.jcL) {
            if (bVar != null && bVar.cnS() && bVar.bJB == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cnV() {
        com.baidu.tieba.tbadvert.a.b cnU = cnU();
        if (cnU != null && !TextUtils.isEmpty(cnU.jcN)) {
            h(cnU.showType, cnU.jcN, true);
        } else if (this.jcP != null) {
            this.jcP.cnP();
        }
    }

    public void cnW() {
        if (this.jcO != null && !v.aa(this.jcO.jcL)) {
            com.baidu.tieba.tbadvert.a.b cnU = cnU();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.jcO.jcL) {
                if (bVar != null && bVar != cnU && bVar.cnS() && bVar.bJB != 4) {
                    h(bVar.showType, bVar.jcN, false);
                }
            }
        }
    }

    private void h(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.iv().a(str, 10, this.jcR, null);
            } else {
                c.iv().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0412a interfaceC0412a) {
        this.jcP = interfaceC0412a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0412a jcP;

        public b(InterfaceC0412a interfaceC0412a) {
            this.jcP = interfaceC0412a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String ahe = xVar.ahe();
            if (!xVar.ahC().aiC().isRequestSuccess() || Es(ahe)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.Er(ahe);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.jcP != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.jcP.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.jcP.cnP();
                }
            }
        }

        private boolean Es(String str) {
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
