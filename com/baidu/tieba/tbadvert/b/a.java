package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a nwn;
    private InterfaceC0889a nwo;
    private InterfaceC0889a nwp = new InterfaceC0889a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0889a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.nwn = aVar;
            if (a.this.nwo != null) {
                a.this.nwo.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0889a
        public void aS(Object obj) {
            if (a.this.nwo != null) {
                a.this.nwo.aS(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0889a
        public void dRa() {
            a.this.nwn = null;
            if (a.this.nwo != null) {
                a.this.nwo.dRa();
            }
        }
    };
    private c<com.baidu.adp.widget.ImageView.a> nwq = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.nwo != null) {
                    a.this.nwo.dRa();
                }
            } else if (a.this.nwo != null) {
                a.this.nwo.aS(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.nwo != null) {
                a.this.nwo.dRa();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0889a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aS(Object obj);

        void dRa();
    }

    public void dRe() {
        b bVar = new b(this.nwp);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dRf() {
        if (this.nwn == null || x.isEmpty(this.nwn.nwk)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.nwn.nwk) {
            if (bVar != null && bVar.dRd() && bVar.eUv == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dRg() {
        com.baidu.tieba.tbadvert.a.b dRf = dRf();
        if (dRf != null && !TextUtils.isEmpty(dRf.nwm)) {
            p(dRf.showType, dRf.nwm, true);
        } else if (this.nwo != null) {
            this.nwo.dRa();
        }
    }

    public void dRh() {
        if (this.nwn != null && !x.isEmpty(this.nwn.nwk)) {
            com.baidu.tieba.tbadvert.a.b dRf = dRf();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.nwn.nwk) {
                if (bVar != null && bVar != dRf && bVar.dRd() && bVar.eUv != 4) {
                    p(bVar.showType, bVar.nwm, false);
                }
            }
        }
    }

    private void p(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                d.mx().a(str, 10, this.nwq, null);
            } else {
                d.mx().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0889a interfaceC0889a) {
        this.nwo = interfaceC0889a;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0889a nwo;

        public b(InterfaceC0889a interfaceC0889a) {
            this.nwo = interfaceC0889a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            z zVar = new z(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = zVar.postNetData();
            if (!zVar.bvR().bwB().isRequestSuccess() || TV(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.nwo != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.nwo.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.nwo.dRa();
                }
            }
        }

        private boolean TV(String str) {
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
