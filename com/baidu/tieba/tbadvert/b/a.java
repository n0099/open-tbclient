package com.baidu.tieba.tbadvert.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a jjh;
    private InterfaceC0411a jji;
    private InterfaceC0411a jjj = new InterfaceC0411a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0411a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.jjh = aVar;
            if (a.this.jji != null) {
                a.this.jji.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0411a
        public void ay(Object obj) {
            if (a.this.jji != null) {
                a.this.jji.ay(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0411a
        public void cqI() {
            a.this.jjh = null;
            if (a.this.jji != null) {
                a.this.jji.cqI();
            }
        }
    };
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jjk = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.nK() == null) {
                if (a.this.jji != null) {
                    a.this.jji.cqI();
                }
            } else if (a.this.jji != null) {
                a.this.jji.ay(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.jji != null) {
                a.this.jji.cqI();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0411a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void ay(Object obj);

        void cqI();
    }

    public void cqM() {
        b bVar = new b(this.jjj);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b cqN() {
        if (this.jjh == null || v.aa(this.jjh.jje)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.jjh.jje) {
            if (bVar != null && bVar.cqL() && bVar.bKB == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void cqO() {
        com.baidu.tieba.tbadvert.a.b cqN = cqN();
        if (cqN != null && !TextUtils.isEmpty(cqN.jjg)) {
            j(cqN.showType, cqN.jjg, true);
        } else if (this.jji != null) {
            this.jji.cqI();
        }
    }

    public void cqP() {
        if (this.jjh != null && !v.aa(this.jjh.jje)) {
            com.baidu.tieba.tbadvert.a.b cqN = cqN();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.jjh.jje) {
                if (bVar != null && bVar != cqN && bVar.cqL() && bVar.bKB != 4) {
                    j(bVar.showType, bVar.jjg, false);
                }
            }
        }
    }

    private void j(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.iE().a(str, 10, this.jjk, null);
            } else {
                c.iE().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0411a interfaceC0411a) {
        this.jji = interfaceC0411a;
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0411a jji;

        public b(InterfaceC0411a interfaceC0411a) {
            this.jji = interfaceC0411a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String aig = xVar.aig();
            if (!xVar.aiE().ajF().isRequestSuccess() || Fg(aig)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.Ff(aig);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.jji != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.jji.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.jji.cqI();
                }
            }
        }

        private boolean Fg(String str) {
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
