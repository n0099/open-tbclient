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
    private com.baidu.tieba.tbadvert.a.a lqw;
    private InterfaceC0732a lqx;
    private InterfaceC0732a lqy = new InterfaceC0732a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0732a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.lqw = aVar;
            if (a.this.lqx != null) {
                a.this.lqx.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0732a
        public void aH(Object obj) {
            if (a.this.lqx != null) {
                a.this.lqx.aH(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0732a
        public void dfm() {
            a.this.lqw = null;
            if (a.this.lqx != null) {
                a.this.lqx.dfm();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> lqz = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.lqx != null) {
                    a.this.lqx.dfm();
                }
            } else if (a.this.lqx != null) {
                a.this.lqx.aH(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.lqx != null) {
                a.this.lqx.dfm();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0732a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aH(Object obj);

        void dfm();
    }

    public void dfq() {
        b bVar = new b(this.lqy);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dfr() {
        if (this.lqw == null || v.isEmpty(this.lqw.lqt)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.lqw.lqt) {
            if (bVar != null && bVar.dfp() && bVar.dGg == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dfs() {
        com.baidu.tieba.tbadvert.a.b dfr = dfr();
        if (dfr != null && !TextUtils.isEmpty(dfr.lqv)) {
            n(dfr.showType, dfr.lqv, true);
        } else if (this.lqx != null) {
            this.lqx.dfm();
        }
    }

    public void dft() {
        if (this.lqw != null && !v.isEmpty(this.lqw.lqt)) {
            com.baidu.tieba.tbadvert.a.b dfr = dfr();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.lqw.lqt) {
                if (bVar != null && bVar != dfr && bVar.dfp() && bVar.dGg != 4) {
                    n(bVar.showType, bVar.lqv, false);
                }
            }
        }
    }

    private void n(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.kX().a(str, 10, this.lqz, null);
            } else {
                c.kX().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0732a interfaceC0732a) {
        this.lqx = interfaceC0732a;
    }

    /* loaded from: classes13.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0732a lqx;

        public b(InterfaceC0732a interfaceC0732a) {
            this.lqx = interfaceC0732a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = xVar.postNetData();
            if (!xVar.aUA().aVc().isRequestSuccess() || MX(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.lqx != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.lqx.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.lqx.dfm();
                }
            }
        }

        private boolean MX(String str) {
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
