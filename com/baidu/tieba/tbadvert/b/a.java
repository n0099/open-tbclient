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
    private com.baidu.tieba.tbadvert.a.a nBr;
    private InterfaceC0875a nBs;
    private InterfaceC0875a nBt = new InterfaceC0875a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0875a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.nBr = aVar;
            if (a.this.nBs != null) {
                a.this.nBs.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0875a
        public void aS(Object obj) {
            if (a.this.nBs != null) {
                a.this.nBs.aS(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0875a
        public void dPt() {
            a.this.nBr = null;
            if (a.this.nBs != null) {
                a.this.nBs.dPt();
            }
        }
    };
    private c<com.baidu.adp.widget.ImageView.a> nBu = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.nBs != null) {
                    a.this.nBs.dPt();
                }
            } else if (a.this.nBs != null) {
                a.this.nBs.aS(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.nBs != null) {
                a.this.nBs.dPt();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0875a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aS(Object obj);

        void dPt();
    }

    public void dPx() {
        b bVar = new b(this.nBt);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dPy() {
        if (this.nBr == null || y.isEmpty(this.nBr.nBo)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.nBr.nBo) {
            if (bVar != null && bVar.dPw() && bVar.eRW == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dPz() {
        com.baidu.tieba.tbadvert.a.b dPy = dPy();
        if (dPy != null && !TextUtils.isEmpty(dPy.nBq)) {
            o(dPy.showType, dPy.nBq, true);
        } else if (this.nBs != null) {
            this.nBs.dPt();
        }
    }

    public void dPA() {
        if (this.nBr != null && !y.isEmpty(this.nBr.nBo)) {
            com.baidu.tieba.tbadvert.a.b dPy = dPy();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.nBr.nBo) {
                if (bVar != null && bVar != dPy && bVar.dPw() && bVar.eRW != 4) {
                    o(bVar.showType, bVar.nBq, false);
                }
            }
        }
    }

    private void o(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                d.mw().a(str, 10, this.nBu, null);
            } else {
                d.mw().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0875a interfaceC0875a) {
        this.nBs = interfaceC0875a;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0875a nBs;

        public b(InterfaceC0875a interfaceC0875a) {
            this.nBs = interfaceC0875a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = aaVar.postNetData();
            if (!aaVar.bsr().btb().isRequestSuccess() || TL(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.nBs != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.nBs.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.nBs.dPt();
                }
            }
        }

        private boolean TL(String str) {
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
