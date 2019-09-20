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
    private com.baidu.tieba.tbadvert.a.a jmK;
    private InterfaceC0428a jmL;
    private InterfaceC0428a jmM = new InterfaceC0428a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0428a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.jmK = aVar;
            if (a.this.jmL != null) {
                a.this.jmL.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0428a
        public void ay(Object obj) {
            if (a.this.jmL != null) {
                a.this.jmL.ay(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0428a
        public void crS() {
            a.this.jmK = null;
            if (a.this.jmL != null) {
                a.this.jmL.crS();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jmN = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.nK() == null) {
                if (a.this.jmL != null) {
                    a.this.jmL.crS();
                }
            } else if (a.this.jmL != null) {
                a.this.jmL.ay(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.jmL != null) {
                a.this.jmL.crS();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0428a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void ay(Object obj);

        void crS();
    }

    public void crW() {
        b bVar = new b(this.jmM);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b crX() {
        if (this.jmK == null || v.aa(this.jmK.jmH)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.jmK.jmH) {
            if (bVar != null && bVar.crV() && bVar.bLe == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void crY() {
        com.baidu.tieba.tbadvert.a.b crX = crX();
        if (crX != null && !TextUtils.isEmpty(crX.jmJ)) {
            j(crX.showType, crX.jmJ, true);
        } else if (this.jmL != null) {
            this.jmL.crS();
        }
    }

    public void crZ() {
        if (this.jmK != null && !v.aa(this.jmK.jmH)) {
            com.baidu.tieba.tbadvert.a.b crX = crX();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.jmK.jmH) {
                if (bVar != null && bVar != crX && bVar.crV() && bVar.bLe != 4) {
                    j(bVar.showType, bVar.jmJ, false);
                }
            }
        }
    }

    private void j(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.iE().a(str, 10, this.jmN, null);
            } else {
                c.iE().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0428a interfaceC0428a) {
        this.jmL = interfaceC0428a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0428a jmL;

        public b(InterfaceC0428a interfaceC0428a) {
            this.jmL = interfaceC0428a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String aim = xVar.aim();
            if (!xVar.aiK().ajN().isRequestSuccess() || FH(aim)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.FG(aim);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.jmL != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.jmL.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.jmL.crS();
                }
            }
        }

        private boolean FH(String str) {
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
