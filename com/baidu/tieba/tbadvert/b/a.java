package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes20.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a lRx;
    private InterfaceC0758a lRy;
    private InterfaceC0758a lRz = new InterfaceC0758a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0758a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.lRx = aVar;
            if (a.this.lRy != null) {
                a.this.lRy.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0758a
        public void aI(Object obj) {
            if (a.this.lRy != null) {
                a.this.lRy.aI(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0758a
        public void dmH() {
            a.this.lRx = null;
            if (a.this.lRy != null) {
                a.this.lRy.dmH();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> lRA = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.lRy != null) {
                    a.this.lRy.dmH();
                }
            } else if (a.this.lRy != null) {
                a.this.lRy.aI(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.lRy != null) {
                a.this.lRy.dmH();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0758a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aI(Object obj);

        void dmH();
    }

    public void dmL() {
        b bVar = new b(this.lRz);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dmM() {
        if (this.lRx == null || x.isEmpty(this.lRx.lRu)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.lRx.lRu) {
            if (bVar != null && bVar.dmK() && bVar.dTc == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dmN() {
        com.baidu.tieba.tbadvert.a.b dmM = dmM();
        if (dmM != null && !TextUtils.isEmpty(dmM.lRw)) {
            n(dmM.showType, dmM.lRw, true);
        } else if (this.lRy != null) {
            this.lRy.dmH();
        }
    }

    public void dmO() {
        if (this.lRx != null && !x.isEmpty(this.lRx.lRu)) {
            com.baidu.tieba.tbadvert.a.b dmM = dmM();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.lRx.lRu) {
                if (bVar != null && bVar != dmM && bVar.dmK() && bVar.dTc != 4) {
                    n(bVar.showType, bVar.lRw, false);
                }
            }
        }
    }

    private void n(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.ln().a(str, 10, this.lRA, null);
            } else {
                c.ln().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0758a interfaceC0758a) {
        this.lRy = interfaceC0758a;
    }

    /* loaded from: classes20.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0758a lRy;

        public b(InterfaceC0758a interfaceC0758a) {
            this.lRy = interfaceC0758a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            z zVar = new z(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = zVar.postNetData();
            if (!zVar.bav().baX().isRequestSuccess() || Oh(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.lRy != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.lRy.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.lRy.dmH();
                }
            }
        }

        private boolean Oh(String str) {
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
