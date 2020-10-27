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
    private com.baidu.tieba.tbadvert.a.a mVo;
    private InterfaceC0840a mVp;
    private InterfaceC0840a mVq = new InterfaceC0840a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0840a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            a.this.mVo = aVar;
            if (a.this.mVp != null) {
                a.this.mVp.a(aVar);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0840a
        public void aQ(Object obj) {
            if (a.this.mVp != null) {
                a.this.mVp.aQ(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0840a
        public void dIU() {
            a.this.mVo = null;
            if (a.this.mVp != null) {
                a.this.mVp.dIU();
            }
        }
    };
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> mVr = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.mVp != null) {
                    a.this.mVp.dIU();
                }
            } else if (a.this.mVp != null) {
                a.this.mVp.aQ(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.mVp != null) {
                a.this.mVp.dIU();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0840a {
        void a(com.baidu.tieba.tbadvert.a.a aVar);

        void aQ(Object obj);

        void dIU();
    }

    public void dIY() {
        b bVar = new b(this.mVq);
        bVar.setSelfExecute(true);
        bVar.execute(new String[0]);
    }

    public com.baidu.tieba.tbadvert.a.b dIZ() {
        if (this.mVo == null || y.isEmpty(this.mVo.mVl)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.mVo.mVl) {
            if (bVar != null && bVar.dIX() && bVar.ezs == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void dJa() {
        com.baidu.tieba.tbadvert.a.b dIZ = dIZ();
        if (dIZ != null && !TextUtils.isEmpty(dIZ.mVn)) {
            o(dIZ.showType, dIZ.mVn, true);
        } else if (this.mVp != null) {
            this.mVp.dIU();
        }
    }

    public void dJb() {
        if (this.mVo != null && !y.isEmpty(this.mVo.mVl)) {
            com.baidu.tieba.tbadvert.a.b dIZ = dIZ();
            for (com.baidu.tieba.tbadvert.a.b bVar : this.mVo.mVl) {
                if (bVar != null && bVar != dIZ && bVar.dIX() && bVar.ezs != 4) {
                    o(bVar.showType, bVar.mVn, false);
                }
            }
        }
    }

    private void o(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                c.mS().a(str, 10, this.mVr, null);
            } else {
                c.mS().a(str, 10, null, null);
            }
        }
    }

    public void a(InterfaceC0840a interfaceC0840a) {
        this.mVp = interfaceC0840a;
    }

    /* loaded from: classes26.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private InterfaceC0840a mVp;

        public b(InterfaceC0840a interfaceC0840a) {
            this.mVp = interfaceC0840a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = aaVar.postNetData();
            if (!aaVar.bon().boU().isRequestSuccess() || SS(postNetData)) {
                return null;
            }
            com.baidu.tieba.tbadvert.a.a aVar = new com.baidu.tieba.tbadvert.a.a();
            aVar.parserJsonStr(postNetData);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (this.mVp != null) {
                if (obj instanceof com.baidu.tieba.tbadvert.a.a) {
                    this.mVp.a((com.baidu.tieba.tbadvert.a.a) obj);
                } else {
                    this.mVp.dIU();
                }
            }
        }

        private boolean SS(String str) {
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
