package com.baidu.tieba.lego.a;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes2.dex */
public class e extends com.baidu.tbadk.b.a {
    @Override // com.baidu.tbadk.b.a
    public String key() {
        return "post";
    }

    @Override // com.baidu.tbadk.b.a, com.baidu.tbadk.b.f
    public void a(Object obj, HashMap<String, String> hashMap, String str, com.baidu.adp.base.d dVar) {
        if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("url")) {
            String str2 = hashMap.get("url");
            if (!TextUtils.isEmpty(str2)) {
                a aVar = new a(str, str2, hashMap, dVar);
                aVar.setPriority(2);
                aVar.execute(new Object[0]);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<Object, Integer, h> {
        private String bsH;
        private HashMap<String, String> gFu;
        private com.baidu.adp.base.d gFv;
        private volatile x mNetwork = null;
        private String postUrl;

        public a(String str, String str2, HashMap<String, String> hashMap, com.baidu.adp.base.d dVar) {
            this.bsH = str;
            this.postUrl = str2;
            this.gFu = hashMap;
            this.gFv = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.postUrl);
                Set<String> keySet = this.gFu.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.x(str, this.gFu.get(str));
                        }
                    }
                }
                this.mNetwork.x("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.x("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.acH().adF().mIsNeedTbs = true;
                String acj = this.mNetwork.acj();
                if (!this.mNetwork.acH().adG().acK()) {
                    hVar.errorCode = this.mNetwork.acM();
                    hVar.errorString = this.mNetwork.acl();
                } else {
                    hVar.errorCode = this.mNetwork.acL();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.acH().adG().isRequestSuccess() && acj != null) {
                    hVar.result = hVar.errorCode == 0;
                    hVar.bsH = this.bsH;
                    return hVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.result = false;
            hVar.bsH = this.bsH;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.gFv != null) {
                this.gFv.m(hVar);
            }
            com.baidu.tieba.lego.a.a.bzy().a(this.postUrl, this.gFu, hVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.gFv != null) {
                this.gFv.m(null);
            }
        }
    }
}
