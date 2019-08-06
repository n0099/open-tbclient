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
    private com.baidu.tieba.tbadvert.a.a jko;
    private InterfaceC0417a jkp;
    private InterfaceC0417a jkq = new InterfaceC0417a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0417a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.jko = aVar;
            if (a.this.jkp != null) {
                a.this.jkp.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0417a
        public void ay(Object obj) {
            if (a.this.jkp != null) {
                a.this.jkp.ay(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0417a
        public void cre() {
            a.this.jko = null;
            if (a.this.jkp != null) {
                a.this.jkp.cre();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jkr = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.nK() == null) {
                if (a.this.jkp != null) {
                    a.this.jkp.cre();
                }
            } else if (a.this.jkp != null) {
                a.this.jkp.ay(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.jkp != null) {
                a.this.jkp.cre();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0417a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void ay(Object obj);

        void cre();
    }

    public void cri() {
        b bVar = new b(this.jkq);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b crj() {
        if (this.jko == null || v.aa(this.jko.jkl)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.jko.jkl) {
            if (bVar != null && bVar.crh() && bVar.bKG == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void crk() {
        com.baidu.tieba.tbadvert.a.b crj = crj();
        if (crj != null && !TextUtils.isEmpty(crj.jkn)) {
            j(crj.showType, crj.jkn, true);
        } else if (this.jkp != null) {
            this.jkp.cre();
        }
    }

    public void crl() {
        if (this.jko != null && !v.aa(this.jko.jkl)) {
            com.baidu.tieba.tbadvert.a.b crj = crj();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.jko.jkl) {
                if (bVar != null && bVar != crj && bVar.crh() && bVar.bKG != 4) {
                    j(bVar.showType, bVar.jkn, false);
                }
            }
        }
    }

    private void j(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.iE().a(str, 10, this.jkr, null);
            } else {
                c.iE().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0417a interfaceC0417a) {
        this.jkp = interfaceC0417a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0417a jkp;

        public b(InterfaceC0417a interfaceC0417a) {
            this.jkp = interfaceC0417a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String aii = xVar.aii();
            if (!xVar.aiG().ajH().isRequestSuccess() || Fh(aii)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.Fg(aii);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.jkp != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.jkp.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.jkp.cre();
                }
            }
        }

        private boolean Fh(String str) {
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
