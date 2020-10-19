package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes26.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a mIG;
    private InterfaceC0825a mIH;
    private InterfaceC0825a mII = new InterfaceC0825a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0825a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.mIG = aVar;
            if (a.this.mIH != null) {
                a.this.mIH.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0825a
        public void aP(Object obj) {
            if (a.this.mIH != null) {
                a.this.mIH.aP(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0825a
        public void dFM() {
            a.this.mIG = null;
            if (a.this.mIH != null) {
                a.this.mIH.dFM();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> mIJ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.mIH != null) {
                    a.this.mIH.dFM();
                }
            } else if (a.this.mIH != null) {
                a.this.mIH.aP(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.mIH != null) {
                a.this.mIH.dFM();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0825a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aP(Object obj);

        void dFM();
    }

    public void dFQ() {
        b bVar = new b(this.mII);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dFR() {
        if (this.mIG == null || y.isEmpty(this.mIG.mIC)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.mIG.mIC) {
            if (bVar != null && bVar.dFP() && bVar.eqR == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dFS() {
        com.baidu.tieba.tbadvert.a.b dFR = dFR();
        if (dFR != null && !TextUtils.isEmpty(dFR.mIF)) {
            o(dFR.showType, dFR.mIF, true);
        } else if (this.mIH != null) {
            this.mIH.dFM();
        }
    }

    public void dFT() {
        if (this.mIG != null && !y.isEmpty(this.mIG.mIC)) {
            com.baidu.tieba.tbadvert.a.b dFR = dFR();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.mIG.mIC) {
                if (bVar != null && bVar != dFR && bVar.dFP() && bVar.eqR != 4) {
                    o(bVar.showType, bVar.mIF, false);
                }
            }
        }
    }

    private void o(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.mS().a(str, 10, this.mIJ, null);
            } else {
                c.mS().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0825a interfaceC0825a) {
        this.mIH = interfaceC0825a;
    }

    /* loaded from: classes26.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0825a mIH;

        public b(InterfaceC0825a interfaceC0825a) {
            this.mIH = interfaceC0825a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = aaVar.postNetData();
            if (!aaVar.bmu().bnb().isRequestSuccess() || St(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.mIH != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.mIH.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.mIH.dFM();
                }
            }
        }

        private boolean St(String str) {
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
