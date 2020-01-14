package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a kjJ;
    private InterfaceC0607a kjK;
    private InterfaceC0607a kjL = new InterfaceC0607a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.kjJ = aVar;
            if (a.this.kjK != null) {
                a.this.kjK.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void az(Object obj) {
            if (a.this.kjK != null) {
                a.this.kjK.az(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void cKW() {
            a.this.kjJ = null;
            if (a.this.kjK != null) {
                a.this.kjK.cKW();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kjM = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.kjK != null) {
                    a.this.kjK.cKW();
                }
            } else if (a.this.kjK != null) {
                a.this.kjK.az(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.kjK != null) {
                a.this.kjK.cKW();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0607a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void az(Object obj);

        void cKW();
    }

    public void cLa() {
        b bVar = new b(this.kjL);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cLb() {
        if (this.kjJ == null || v.isEmpty(this.kjJ.kjG)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.kjJ.kjG) {
            if (bVar != null && bVar.cKZ() && bVar.cOH == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cLc() {
        com.baidu.tieba.tbadvert.a.b cLb = cLb();
        if (cLb != null && !TextUtils.isEmpty(cLb.kjI)) {
            m(cLb.showType, cLb.kjI, true);
        } else if (this.kjK != null) {
            this.kjK.cKW();
        }
    }

    public void cLd() {
        if (this.kjJ != null && !v.isEmpty(this.kjJ.kjG)) {
            com.baidu.tieba.tbadvert.a.b cLb = cLb();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.kjJ.kjG) {
                if (bVar != null && bVar != cLb && bVar.cKZ() && bVar.cOH != 4) {
                    m(bVar.showType, bVar.kjI, false);
                }
            }
        }
    }

    private void m(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.gr().a(str, 10, this.kjM, null);
            } else {
                c.gr().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0607a interfaceC0607a) {
        this.kjK = interfaceC0607a;
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0607a kjK;

        public b(InterfaceC0607a interfaceC0607a) {
            this.kjK = interfaceC0607a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.aDU().aEv().isRequestSuccess() || Jj(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.kjK != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.kjK.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.kjK.cKW();
                }
            }
        }

        private boolean Jj(String str) {
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
