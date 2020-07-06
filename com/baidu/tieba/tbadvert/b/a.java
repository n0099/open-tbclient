package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes13.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a lKh;
    private InterfaceC0748a lKi;
    private InterfaceC0748a lKj = new InterfaceC0748a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0748a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.lKh = aVar;
            if (a.this.lKi != null) {
                a.this.lKi.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0748a
        public void aI(Object obj) {
            if (a.this.lKi != null) {
                a.this.lKi.aI(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0748a
        public void djy() {
            a.this.lKh = null;
            if (a.this.lKi != null) {
                a.this.lKi.djy();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> lKk = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.lKi != null) {
                    a.this.lKi.djy();
                }
            } else if (a.this.lKi != null) {
                a.this.lKi.aI(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.lKi != null) {
                a.this.lKi.djy();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0748a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aI(Object obj);

        void djy();
    }

    public void djC() {
        b bVar = new b(this.lKj);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b djD() {
        if (this.lKh == null || w.isEmpty(this.lKh.lKe)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.lKh.lKe) {
            if (bVar != null && bVar.djB() && bVar.dMR == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void djE() {
        com.baidu.tieba.tbadvert.a.b djD = djD();
        if (djD != null && !TextUtils.isEmpty(djD.lKg)) {
            n(djD.showType, djD.lKg, true);
        } else if (this.lKi != null) {
            this.lKi.djy();
        }
    }

    public void djF() {
        if (this.lKh != null && !w.isEmpty(this.lKh.lKe)) {
            com.baidu.tieba.tbadvert.a.b djD = djD();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.lKh.lKe) {
                if (bVar != null && bVar != djD && bVar.djB() && bVar.dMR != 4) {
                    n(bVar.showType, bVar.lKg, false);
                }
            }
        }
    }

    private void n(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.ln().a(str, 10, this.lKk, null);
            } else {
                c.ln().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0748a interfaceC0748a) {
        this.lKi = interfaceC0748a;
    }

    /* loaded from: classes13.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0748a lKi;

        public b(InterfaceC0748a interfaceC0748a) {
            this.lKi = interfaceC0748a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            y yVar = new y(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = yVar.postNetData();
            if (!yVar.aWu().aWW().isRequestSuccess() || Nz(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.lKi != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.lKi.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.lKi.djy();
                }
            }
        }

        private boolean Nz(String str) {
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
