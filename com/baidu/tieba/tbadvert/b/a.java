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
    private com.baidu.tieba.tbadvert.a.a nwo;
    private InterfaceC0856a nwp;
    private InterfaceC0856a nwq = new InterfaceC0856a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0856a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.nwo = aVar;
            if (a.this.nwp != null) {
                a.this.nwp.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0856a
        public void aS(Object obj) {
            if (a.this.nwp != null) {
                a.this.nwp.aS(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0856a
        public void dQZ() {
            a.this.nwo = null;
            if (a.this.nwp != null) {
                a.this.nwp.dQZ();
            }
        }
    };
    private c<com.baidu.adp.widget.ImageView.a> nwr = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.nwp != null) {
                    a.this.nwp.dQZ();
                }
            } else if (a.this.nwp != null) {
                a.this.nwp.aS(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.nwp != null) {
                a.this.nwp.dQZ();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0856a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aS(Object obj);

        void dQZ();
    }

    public void dRd() {
        b bVar = new b(this.nwq);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dRe() {
        if (this.nwo == null || x.isEmpty(this.nwo.nwl)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.nwo.nwl) {
            if (bVar != null && bVar.dRc() && bVar.eUv == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dRf() {
        com.baidu.tieba.tbadvert.a.b dRe = dRe();
        if (dRe != null && !TextUtils.isEmpty(dRe.nwn)) {
            p(dRe.showType, dRe.nwn, true);
        } else if (this.nwp != null) {
            this.nwp.dQZ();
        }
    }

    public void dRg() {
        if (this.nwo != null && !x.isEmpty(this.nwo.nwl)) {
            com.baidu.tieba.tbadvert.a.b dRe = dRe();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.nwo.nwl) {
                if (bVar != null && bVar != dRe && bVar.dRc() && bVar.eUv != 4) {
                    p(bVar.showType, bVar.nwn, false);
                }
            }
        }
    }

    private void p(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                d.mx().a(str, 10, this.nwr, null);
            } else {
                d.mx().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0856a interfaceC0856a) {
        this.nwp = interfaceC0856a;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0856a nwp;

        public b(InterfaceC0856a interfaceC0856a) {
            this.nwp = interfaceC0856a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            z zVar = new z(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = zVar.postNetData();
            if (!zVar.bvQ().bwA().isRequestSuccess() || TW(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.nwp != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.nwp.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.nwp.dQZ();
                }
            }
        }

        private boolean TW(String str) {
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
