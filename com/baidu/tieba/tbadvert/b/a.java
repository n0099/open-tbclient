package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes7.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a nrI;
    private InterfaceC0872a nrJ;
    private InterfaceC0872a nrK = new InterfaceC0872a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.nrI = aVar;
            if (a.this.nrJ != null) {
                a.this.nrJ.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void aS(Object obj) {
            if (a.this.nrJ != null) {
                a.this.nrJ.aS(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void dNi() {
            a.this.nrI = null;
            if (a.this.nrJ != null) {
                a.this.nrJ.dNi();
            }
        }
    };
    private c<com.baidu.adp.widget.ImageView.a> nrL = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.nrJ != null) {
                    a.this.nrJ.dNi();
                }
            } else if (a.this.nrJ != null) {
                a.this.nrJ.aS(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.nrJ != null) {
                a.this.nrJ.dNi();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0872a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aS(Object obj);

        void dNi();
    }

    public void dNm() {
        b bVar = new b(this.nrK);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dNn() {
        if (this.nrI == null || x.isEmpty(this.nrI.nrF)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.nrI.nrF) {
            if (bVar != null && bVar.dNl() && bVar.ePK == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dNo() {
        com.baidu.tieba.tbadvert.a.b dNn = dNn();
        if (dNn != null && !TextUtils.isEmpty(dNn.nrH)) {
            p(dNn.showType, dNn.nrH, true);
        } else if (this.nrJ != null) {
            this.nrJ.dNi();
        }
    }

    public void dNp() {
        if (this.nrI != null && !x.isEmpty(this.nrI.nrF)) {
            com.baidu.tieba.tbadvert.a.b dNn = dNn();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.nrI.nrF) {
                if (bVar != null && bVar != dNn && bVar.dNl() && bVar.ePK != 4) {
                    p(bVar.showType, bVar.nrH, false);
                }
            }
        }
    }

    private void p(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                d.mx().a(str, 10, this.nrL, null);
            } else {
                d.mx().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0872a interfaceC0872a) {
        this.nrJ = interfaceC0872a;
    }

    /* loaded from: classes7.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0872a nrJ;

        public b(InterfaceC0872a interfaceC0872a) {
            this.nrJ = interfaceC0872a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            z zVar = new z(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = zVar.postNetData();
            if (!zVar.brX().bsH().isRequestSuccess() || SO(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.nrJ != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.nrJ.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.nrJ.dNi();
                }
            }
        }

        private boolean SO(String str) {
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
