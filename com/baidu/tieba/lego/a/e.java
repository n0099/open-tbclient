package com.baidu.tieba.lego.a;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes8.dex */
public class e extends com.baidu.tbadk.b.a {
    @Override // com.baidu.tbadk.b.a
    public String key() {
        return "post";
    }

    @Override // com.baidu.tbadk.b.a, com.baidu.tbadk.b.f
    public void a(Object obj, HashMap<String, String> hashMap, String str, com.baidu.adp.base.e eVar) {
        if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("url")) {
            String str2 = hashMap.get("url");
            if (!TextUtils.isEmpty(str2)) {
                a aVar = new a(str, str2, hashMap, eVar);
                aVar.setPriority(2);
                aVar.execute(new Object[0]);
            }
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, Integer, h> {
        private String eEs;
        private HashMap<String, String> kSh;
        private com.baidu.adp.base.e kSi;
        private volatile z mNetwork = null;
        private String postUrl;

        public a(String str, String str2, HashMap<String, String> hashMap, com.baidu.adp.base.e eVar) {
            this.eEs = str;
            this.postUrl = str2;
            this.kSh = hashMap;
            this.kSi = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + this.postUrl);
                Set<String> keySet = this.kSh.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.addPostData(str, this.kSh.get(str));
                        }
                    }
                }
                this.mNetwork.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.brX().bsG().mIsNeedTbs = true;
                String postNetData = this.mNetwork.postNetData();
                if (!this.mNetwork.brX().bsH().isNetSuccess()) {
                    hVar.errorCode = this.mNetwork.getNetErrorCode();
                    hVar.errorString = this.mNetwork.getNetString();
                } else {
                    hVar.errorCode = this.mNetwork.getServerErrorCode();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.brX().bsH().isRequestSuccess() && postNetData != null) {
                    hVar.result = hVar.errorCode == 0;
                    hVar.eEs = this.eEs;
                    return hVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.result = false;
            hVar.eEs = this.eEs;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.kSi != null) {
                this.kSi.callback(hVar);
            }
            com.baidu.tieba.lego.a.a.cZk().a(this.postUrl, this.kSh, hVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.kSi != null) {
                this.kSi.callback(null);
            }
        }
    }
}
