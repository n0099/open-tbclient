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
    private com.baidu.tieba.tbadvert.a.a jcI;
    private InterfaceC0412a jcJ;
    private InterfaceC0412a jcK = new InterfaceC0412a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.jcI = aVar;
            if (a.this.jcJ != null) {
                a.this.jcJ.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void ay(Object obj) {
            if (a.this.jcJ != null) {
                a.this.jcJ.ay(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void cnM() {
            a.this.jcI = null;
            if (a.this.jcJ != null) {
                a.this.jcJ.cnM();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jcL = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.ns() == null) {
                if (a.this.jcJ != null) {
                    a.this.jcJ.cnM();
                }
            } else if (a.this.jcJ != null) {
                a.this.jcJ.ay(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.jcJ != null) {
                a.this.jcJ.cnM();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0412a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void ay(Object obj);

        void cnM();
    }

    public void cnQ() {
        b bVar = new b(this.jcK);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cnR() {
        if (this.jcI == null || v.aa(this.jcI.jcF)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.jcI.jcF) {
            if (bVar != null && bVar.cnP() && bVar.bJA == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cnS() {
        com.baidu.tieba.tbadvert.a.b cnR = cnR();
        if (cnR != null && !TextUtils.isEmpty(cnR.jcH)) {
            h(cnR.showType, cnR.jcH, true);
        } else if (this.jcJ != null) {
            this.jcJ.cnM();
        }
    }

    public void cnT() {
        if (this.jcI != null && !v.aa(this.jcI.jcF)) {
            com.baidu.tieba.tbadvert.a.b cnR = cnR();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.jcI.jcF) {
                if (bVar != null && bVar != cnR && bVar.cnP() && bVar.bJA != 4) {
                    h(bVar.showType, bVar.jcH, false);
                }
            }
        }
    }

    private void h(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.iv().a(str, 10, this.jcL, null);
            } else {
                c.iv().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0412a interfaceC0412a) {
        this.jcJ = interfaceC0412a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0412a jcJ;

        public b(InterfaceC0412a interfaceC0412a) {
            this.jcJ = interfaceC0412a;
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
            if (this.jcJ != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.jcJ.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.jcJ.cnM();
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
