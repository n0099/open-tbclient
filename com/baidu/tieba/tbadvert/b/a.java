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
    private com.baidu.tieba.tbadvert.a.a jmF;
    private InterfaceC0523a jmG;
    private InterfaceC0523a jmH = new InterfaceC0523a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0523a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.jmF = aVar;
            if (a.this.jmG != null) {
                a.this.jmG.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0523a
        public void at(Object obj) {
            if (a.this.jmG != null) {
                a.this.jmG.at(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0523a
        public void cpO() {
            a.this.jmF = null;
            if (a.this.jmG != null) {
                a.this.jmG.cpO();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jmI = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.jmG != null) {
                    a.this.jmG.cpO();
                }
            } else if (a.this.jmG != null) {
                a.this.jmG.at(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.jmG != null) {
                a.this.jmG.cpO();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0523a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void at(Object obj);

        void cpO();
    }

    public void cpS() {
        b bVar = new b(this.jmH);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cpT() {
        if (this.jmF == null || v.isEmpty(this.jmF.jmC)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.jmF.jmC) {
            if (bVar != null && bVar.cpR() && bVar.ccN == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cpU() {
        com.baidu.tieba.tbadvert.a.b cpT = cpT();
        if (cpT != null && !TextUtils.isEmpty(cpT.jmE)) {
            j(cpT.showType, cpT.jmE, true);
        } else if (this.jmG != null) {
            this.jmG.cpO();
        }
    }

    public void cpV() {
        if (this.jmF != null && !v.isEmpty(this.jmF.jmC)) {
            com.baidu.tieba.tbadvert.a.b cpT = cpT();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.jmF.jmC) {
                if (bVar != null && bVar != cpT && bVar.cpR() && bVar.ccN != 4) {
                    j(bVar.showType, bVar.jmE, false);
                }
            }
        }
    }

    private void j(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.fT().a(str, 10, this.jmI, null);
            } else {
                c.fT().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0523a interfaceC0523a) {
        this.jmG = interfaceC0523a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0523a jmG;

        public b(InterfaceC0523a interfaceC0523a) {
            this.jmG = interfaceC0523a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.amr().amS().isRequestSuccess() || Ek(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.jmG != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.jmG.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.jmG.cpO();
                }
            }
        }

        private boolean Ek(String str) {
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
