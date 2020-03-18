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
    private com.baidu.tieba.tbadvert.a.a kmv;
    private InterfaceC0616a kmw;
    private InterfaceC0616a kmx = new InterfaceC0616a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0616a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.kmv = aVar;
            if (a.this.kmw != null) {
                a.this.kmw.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0616a
        public void aB(Object obj) {
            if (a.this.kmw != null) {
                a.this.kmw.aB(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0616a
        public void cMO() {
            a.this.kmv = null;
            if (a.this.kmw != null) {
                a.this.kmw.cMO();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kmy = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.kmw != null) {
                    a.this.kmw.cMO();
                }
            } else if (a.this.kmw != null) {
                a.this.kmw.aB(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.kmw != null) {
                a.this.kmw.cMO();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0616a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aB(Object obj);

        void cMO();
    }

    public void cMS() {
        b bVar = new b(this.kmx);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cMT() {
        if (this.kmv == null || v.isEmpty(this.kmv.kms)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.kmv.kms) {
            if (bVar != null && bVar.cMR() && bVar.cSY == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cMU() {
        com.baidu.tieba.tbadvert.a.b cMT = cMT();
        if (cMT != null && !TextUtils.isEmpty(cMT.kmu)) {
            m(cMT.showType, cMT.kmu, true);
        } else if (this.kmw != null) {
            this.kmw.cMO();
        }
    }

    public void cMV() {
        if (this.kmv != null && !v.isEmpty(this.kmv.kms)) {
            com.baidu.tieba.tbadvert.a.b cMT = cMT();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.kmv.kms) {
                if (bVar != null && bVar != cMT && bVar.cMR() && bVar.cSY != 4) {
                    m(bVar.showType, bVar.kmu, false);
                }
            }
        }
    }

    private void m(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.gr().a(str, 10, this.kmy, null);
            } else {
                c.gr().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0616a interfaceC0616a) {
        this.kmw = interfaceC0616a;
    }

    /* loaded from: classes13.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0616a kmw;

        public b(InterfaceC0616a interfaceC0616a) {
            this.kmw = interfaceC0616a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.aGk().aGM().isRequestSuccess() || Jw(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.kmw != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.kmw.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.kmw.cMO();
                }
            }
        }

        private boolean Jw(String str) {
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
