package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes13.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a lpn;
    private InterfaceC0731a lpo;
    private InterfaceC0731a lpp = new InterfaceC0731a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0731a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.lpn = aVar;
            if (a.this.lpo != null) {
                a.this.lpo.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0731a
        public void aH(Object obj) {
            if (a.this.lpo != null) {
                a.this.lpo.aH(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0731a
        public void deX() {
            a.this.lpn = null;
            if (a.this.lpo != null) {
                a.this.lpo.deX();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> lpq = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.lpo != null) {
                    a.this.lpo.deX();
                }
            } else if (a.this.lpo != null) {
                a.this.lpo.aH(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.lpo != null) {
                a.this.lpo.deX();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0731a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aH(Object obj);

        void deX();
    }

    public void dfb() {
        b bVar = new b(this.lpp);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dfc() {
        if (this.lpn == null || v.isEmpty(this.lpn.lpk)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.lpn.lpk) {
            if (bVar != null && bVar.dfa() && bVar.dGg == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dfd() {
        com.baidu.tieba.tbadvert.a.b dfc = dfc();
        if (dfc != null && !TextUtils.isEmpty(dfc.lpm)) {
            n(dfc.showType, dfc.lpm, true);
        } else if (this.lpo != null) {
            this.lpo.deX();
        }
    }

    public void dfe() {
        if (this.lpn != null && !v.isEmpty(this.lpn.lpk)) {
            com.baidu.tieba.tbadvert.a.b dfc = dfc();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.lpn.lpk) {
                if (bVar != null && bVar != dfc && bVar.dfa() && bVar.dGg != 4) {
                    n(bVar.showType, bVar.lpm, false);
                }
            }
        }
    }

    private void n(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.kX().a(str, 10, this.lpq, null);
            } else {
                c.kX().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0731a interfaceC0731a) {
        this.lpo = interfaceC0731a;
    }

    /* loaded from: classes13.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0731a lpo;

        public b(InterfaceC0731a interfaceC0731a) {
            this.lpo = interfaceC0731a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.aUA().aVb().isRequestSuccess() || MW(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.lpo != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.lpo.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.lpo.deX();
                }
            }
        }

        private boolean MW(String str) {
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
