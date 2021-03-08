package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes7.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a nDW;
    private InterfaceC0883a nDX;
    private InterfaceC0883a nDY = new InterfaceC0883a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0883a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.nDW = aVar;
            if (a.this.nDX != null) {
                a.this.nDX.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0883a
        public void aU(Object obj) {
            if (a.this.nDX != null) {
                a.this.nDX.aU(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0883a
        public void dPK() {
            a.this.nDW = null;
            if (a.this.nDX != null) {
                a.this.nDX.dPK();
            }
        }
    };
    private c<com.baidu.adp.widget.ImageView.a> nDZ = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.nDX != null) {
                    a.this.nDX.dPK();
                }
            } else if (a.this.nDX != null) {
                a.this.nDX.aU(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.nDX != null) {
                a.this.nDX.dPK();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0883a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aU(Object obj);

        void dPK();
    }

    public void dPO() {
        b bVar = new b(this.nDY);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dPP() {
        if (this.nDW == null || y.isEmpty(this.nDW.nDT)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.nDW.nDT) {
            if (bVar != null && bVar.dPN() && bVar.eTx == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dPQ() {
        com.baidu.tieba.tbadvert.a.b dPP = dPP();
        if (dPP != null && !TextUtils.isEmpty(dPP.nDV)) {
            o(dPP.showType, dPP.nDV, true);
        } else if (this.nDX != null) {
            this.nDX.dPK();
        }
    }

    public void dPR() {
        if (this.nDW != null && !y.isEmpty(this.nDW.nDT)) {
            com.baidu.tieba.tbadvert.a.b dPP = dPP();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.nDW.nDT) {
                if (bVar != null && bVar != dPP && bVar.dPN() && bVar.eTx != 4) {
                    o(bVar.showType, bVar.nDV, false);
                }
            }
        }
    }

    private void o(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                d.mw().a(str, 10, this.nDZ, null);
            } else {
                d.mw().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0883a interfaceC0883a) {
        this.nDX = interfaceC0883a;
    }

    /* loaded from: classes7.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0883a nDX;

        public b(InterfaceC0883a interfaceC0883a) {
            this.nDX = interfaceC0883a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = aaVar.postNetData();
            if (!aaVar.bsu().bte().isRequestSuccess() || Ue(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.nDX != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.nDX.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.nDX.dPK();
                }
            }
        }

        private boolean Ue(String str) {
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
