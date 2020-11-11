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
    private com.baidu.tieba.tbadvert.a.a nbk;
    private InterfaceC0855a nbl;
    private InterfaceC0855a nbm = new InterfaceC0855a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0855a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.nbk = aVar;
            if (a.this.nbl != null) {
                a.this.nbl.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0855a
        public void aQ(Object obj) {
            if (a.this.nbl != null) {
                a.this.nbl.aQ(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0855a
        public void dLw() {
            a.this.nbk = null;
            if (a.this.nbl != null) {
                a.this.nbl.dLw();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> nbn = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.nbl != null) {
                    a.this.nbl.dLw();
                }
            } else if (a.this.nbl != null) {
                a.this.nbl.aQ(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.nbl != null) {
                a.this.nbl.dLw();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0855a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aQ(Object obj);

        void dLw();
    }

    public void dLA() {
        b bVar = new b(this.nbm);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dLB() {
        if (this.nbk == null || y.isEmpty(this.nbk.nbh)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.nbk.nbh) {
            if (bVar != null && bVar.dLz() && bVar.eFh == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dLC() {
        com.baidu.tieba.tbadvert.a.b dLB = dLB();
        if (dLB != null && !TextUtils.isEmpty(dLB.nbj)) {
            o(dLB.showType, dLB.nbj, true);
        } else if (this.nbl != null) {
            this.nbl.dLw();
        }
    }

    public void dLD() {
        if (this.nbk != null && !y.isEmpty(this.nbk.nbh)) {
            com.baidu.tieba.tbadvert.a.b dLB = dLB();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.nbk.nbh) {
                if (bVar != null && bVar != dLB && bVar.dLz() && bVar.eFh != 4) {
                    o(bVar.showType, bVar.nbj, false);
                }
            }
        }
    }

    private void o(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.mS().a(str, 10, this.nbn, null);
            } else {
                c.mS().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0855a interfaceC0855a) {
        this.nbl = interfaceC0855a;
    }

    /* loaded from: classes26.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0855a nbl;

        public b(InterfaceC0855a interfaceC0855a) {
            this.nbl = interfaceC0855a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = aaVar.postNetData();
            if (!aaVar.bqN().bru().isRequestSuccess() || Tj(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.nbl != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.nbl.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.nbl.dLw();
                }
            }
        }

        private boolean Tj(String str) {
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
