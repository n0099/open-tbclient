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
    private com.baidu.tieba.tbadvert.a.a jcK;
    private InterfaceC0412a jcL;
    private InterfaceC0412a jcM = new InterfaceC0412a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.jcK = aVar;
            if (a.this.jcL != null) {
                a.this.jcL.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void ay(Object obj) {
            if (a.this.jcL != null) {
                a.this.jcL.ay(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void cnO() {
            a.this.jcK = null;
            if (a.this.jcL != null) {
                a.this.jcL.cnO();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jcN = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.ns() == null) {
                if (a.this.jcL != null) {
                    a.this.jcL.cnO();
                }
            } else if (a.this.jcL != null) {
                a.this.jcL.ay(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.jcL != null) {
                a.this.jcL.cnO();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0412a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void ay(Object obj);

        void cnO();
    }

    public void cnS() {
        b bVar = new b(this.jcM);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cnT() {
        if (this.jcK == null || v.aa(this.jcK.jcH)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.jcK.jcH) {
            if (bVar != null && bVar.cnR() && bVar.bJA == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cnU() {
        com.baidu.tieba.tbadvert.a.b cnT = cnT();
        if (cnT != null && !TextUtils.isEmpty(cnT.jcJ)) {
            h(cnT.showType, cnT.jcJ, true);
        } else if (this.jcL != null) {
            this.jcL.cnO();
        }
    }

    public void cnV() {
        if (this.jcK != null && !v.aa(this.jcK.jcH)) {
            com.baidu.tieba.tbadvert.a.b cnT = cnT();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.jcK.jcH) {
                if (bVar != null && bVar != cnT && bVar.cnR() && bVar.bJA != 4) {
                    h(bVar.showType, bVar.jcJ, false);
                }
            }
        }
    }

    private void h(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.iv().a(str, 10, this.jcN, null);
            } else {
                c.iv().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0412a interfaceC0412a) {
        this.jcL = interfaceC0412a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0412a jcL;

        public b(InterfaceC0412a interfaceC0412a) {
            this.jcL = interfaceC0412a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String ahe = xVar.ahe();
            if (!xVar.ahC().aiC().isRequestSuccess() || Eq(ahe)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.Ep(ahe);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.jcL != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.jcL.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.jcL.cnO();
                }
            }
        }

        private boolean Eq(String str) {
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
