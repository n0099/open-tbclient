package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes25.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a ncl;
    private InterfaceC0857a ncm;
    private InterfaceC0857a ncn = new InterfaceC0857a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0857a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.ncl = aVar;
            if (a.this.ncm != null) {
                a.this.ncm.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0857a
        public void aR(Object obj) {
            if (a.this.ncm != null) {
                a.this.ncm.aR(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0857a
        public void dLv() {
            a.this.ncl = null;
            if (a.this.ncm != null) {
                a.this.ncm.dLv();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> nco = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.ncm != null) {
                    a.this.ncm.dLv();
                }
            } else if (a.this.ncm != null) {
                a.this.ncm.aR(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.ncm != null) {
                a.this.ncm.dLv();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0857a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aR(Object obj);

        void dLv();
    }

    public void dLz() {
        b bVar = new b(this.ncn);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dLA() {
        if (this.ncl == null || y.isEmpty(this.ncl.nci)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.ncl.nci) {
            if (bVar != null && bVar.dLy() && bVar.eDz == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dLB() {
        com.baidu.tieba.tbadvert.a.b dLA = dLA();
        if (dLA != null && !TextUtils.isEmpty(dLA.nck)) {
            o(dLA.showType, dLA.nck, true);
        } else if (this.ncm != null) {
            this.ncm.dLv();
        }
    }

    public void dLC() {
        if (this.ncl != null && !y.isEmpty(this.ncl.nci)) {
            com.baidu.tieba.tbadvert.a.b dLA = dLA();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.ncl.nci) {
                if (bVar != null && bVar != dLA && bVar.dLy() && bVar.eDz != 4) {
                    o(bVar.showType, bVar.nck, false);
                }
            }
        }
    }

    private void o(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.mS().a(str, 10, this.nco, null);
            } else {
                c.mS().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0857a interfaceC0857a) {
        this.ncm = interfaceC0857a;
    }

    /* loaded from: classes25.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0857a ncm;

        public b(InterfaceC0857a interfaceC0857a) {
            this.ncm = interfaceC0857a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = aaVar.postNetData();
            if (!aaVar.bqa().bqI().isRequestSuccess() || SU(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.ncm != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.ncm.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.ncm.dLv();
                }
            }
        }

        private boolean SU(String str) {
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
