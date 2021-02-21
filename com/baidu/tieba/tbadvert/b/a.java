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
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a nBR;
    private InterfaceC0877a nBS;
    private InterfaceC0877a nBT = new InterfaceC0877a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0877a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.nBR = aVar;
            if (a.this.nBS != null) {
                a.this.nBS.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0877a
        public void aS(Object obj) {
            if (a.this.nBS != null) {
                a.this.nBS.aS(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0877a
        public void dPB() {
            a.this.nBR = null;
            if (a.this.nBS != null) {
                a.this.nBS.dPB();
            }
        }
    };
    private c<com.baidu.adp.widget.ImageView.a> nBU = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.nBS != null) {
                    a.this.nBS.dPB();
                }
            } else if (a.this.nBS != null) {
                a.this.nBS.aS(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.nBS != null) {
                a.this.nBS.dPB();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0877a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aS(Object obj);

        void dPB();
    }

    public void dPF() {
        b bVar = new b(this.nBT);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dPG() {
        if (this.nBR == null || y.isEmpty(this.nBR.nBO)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.nBR.nBO) {
            if (bVar != null && bVar.dPE() && bVar.eRW == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dPH() {
        com.baidu.tieba.tbadvert.a.b dPG = dPG();
        if (dPG != null && !TextUtils.isEmpty(dPG.nBQ)) {
            o(dPG.showType, dPG.nBQ, true);
        } else if (this.nBS != null) {
            this.nBS.dPB();
        }
    }

    public void dPI() {
        if (this.nBR != null && !y.isEmpty(this.nBR.nBO)) {
            com.baidu.tieba.tbadvert.a.b dPG = dPG();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.nBR.nBO) {
                if (bVar != null && bVar != dPG && bVar.dPE() && bVar.eRW != 4) {
                    o(bVar.showType, bVar.nBQ, false);
                }
            }
        }
    }

    private void o(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                d.mw().a(str, 10, this.nBU, null);
            } else {
                d.mw().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0877a interfaceC0877a) {
        this.nBS = interfaceC0877a;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0877a nBS;

        public b(InterfaceC0877a interfaceC0877a) {
            this.nBS = interfaceC0877a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = aaVar.postNetData();
            if (!aaVar.bsr().btb().isRequestSuccess() || TX(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.nBS != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.nBS.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.nBS.dPB();
                }
            }
        }

        private boolean TX(String str) {
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
