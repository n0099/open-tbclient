package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes20.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a mji;
    private InterfaceC0810a mjj;
    private InterfaceC0810a mjk = new InterfaceC0810a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.mji = aVar;
            if (a.this.mjj != null) {
                a.this.mjj.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void aK(Object obj) {
            if (a.this.mjj != null) {
                a.this.mjj.aK(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void dyc() {
            a.this.mji = null;
            if (a.this.mjj != null) {
                a.this.mjj.dyc();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> mjl = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.mjj != null) {
                    a.this.mjj.dyc();
                }
            } else if (a.this.mjj != null) {
                a.this.mjj.aK(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.mjj != null) {
                a.this.mjj.dyc();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0810a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aK(Object obj);

        void dyc();
    }

    public void dyg() {
        b bVar = new b(this.mjk);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dyh() {
        if (this.mji == null || y.isEmpty(this.mji.mjf)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.mji.mjf) {
            if (bVar != null && bVar.dyf() && bVar.ecy == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dyi() {
        com.baidu.tieba.tbadvert.a.b dyh = dyh();
        if (dyh != null && !TextUtils.isEmpty(dyh.mjh)) {
            m(dyh.showType, dyh.mjh, true);
        } else if (this.mjj != null) {
            this.mjj.dyc();
        }
    }

    public void dyj() {
        if (this.mji != null && !y.isEmpty(this.mji.mjf)) {
            com.baidu.tieba.tbadvert.a.b dyh = dyh();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.mji.mjf) {
                if (bVar != null && bVar != dyh && bVar.dyf() && bVar.ecy != 4) {
                    m(bVar.showType, bVar.mjh, false);
                }
            }
        }
    }

    private void m(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.mM().a(str, 10, this.mjl, null);
            } else {
                c.mM().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0810a interfaceC0810a) {
        this.mjj = interfaceC0810a;
    }

    /* loaded from: classes20.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0810a mjj;

        public b(InterfaceC0810a interfaceC0810a) {
            this.mjj = interfaceC0810a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = aaVar.postNetData();
            if (!aaVar.biQ().bjw().isRequestSuccess() || Rf(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.mjj != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.mjj.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.mjj.dyc();
                }
            }
        }

        private boolean Rf(String str) {
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
