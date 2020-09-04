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
    private com.baidu.tieba.tbadvert.a.a mjx;
    private InterfaceC0810a mjy;
    private InterfaceC0810a mjz = new InterfaceC0810a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.mjx = aVar;
            if (a.this.mjy != null) {
                a.this.mjy.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void aK(Object obj) {
            if (a.this.mjy != null) {
                a.this.mjy.aK(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void dyh() {
            a.this.mjx = null;
            if (a.this.mjy != null) {
                a.this.mjy.dyh();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> mjA = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.mjy != null) {
                    a.this.mjy.dyh();
                }
            } else if (a.this.mjy != null) {
                a.this.mjy.aK(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.mjy != null) {
                a.this.mjy.dyh();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0810a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aK(Object obj);

        void dyh();
    }

    public void dyl() {
        b bVar = new b(this.mjz);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dym() {
        if (this.mjx == null || y.isEmpty(this.mjx.mju)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.mjx.mju) {
            if (bVar != null && bVar.dyk() && bVar.ecC == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dyn() {
        com.baidu.tieba.tbadvert.a.b dym = dym();
        if (dym != null && !TextUtils.isEmpty(dym.mjw)) {
            m(dym.showType, dym.mjw, true);
        } else if (this.mjy != null) {
            this.mjy.dyh();
        }
    }

    public void dyo() {
        if (this.mjx != null && !y.isEmpty(this.mjx.mju)) {
            com.baidu.tieba.tbadvert.a.b dym = dym();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.mjx.mju) {
                if (bVar != null && bVar != dym && bVar.dyk() && bVar.ecC != 4) {
                    m(bVar.showType, bVar.mjw, false);
                }
            }
        }
    }

    private void m(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.mM().a(str, 10, this.mjA, null);
            } else {
                c.mM().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0810a interfaceC0810a) {
        this.mjy = interfaceC0810a;
    }

    /* loaded from: classes20.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0810a mjy;

        public b(InterfaceC0810a interfaceC0810a) {
            this.mjy = interfaceC0810a;
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
            if (this.mjy != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.mjy.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.mjy.dyh();
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
