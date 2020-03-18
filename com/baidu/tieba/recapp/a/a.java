package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class a extends com.baidu.tbadk.b.a {
    private String mKey;

    public a(String str) {
        this.mKey = str;
    }

    @Override // com.baidu.tbadk.b.a
    public String key() {
        Uri parse = Uri.parse(this.mKey);
        return parse != null ? parse.getAuthority() + parse.getPath() : "";
    }

    @Override // com.baidu.tbadk.b.a, com.baidu.tbadk.b.f
    public void a(Object obj, HashMap<String, String> hashMap, String str, d dVar) {
        if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("url")) {
            String str2 = hashMap.get("url");
            if (!TextUtils.isEmpty(str2)) {
                C0596a c0596a = new C0596a(str, str2, hashMap, dVar);
                c0596a.setPriority(2);
                c0596a.execute(new Object[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class C0596a extends BdAsyncTask<Object, Integer, h> {
        private String cKc;
        private HashMap<String, String> hYp;
        private d hYq;
        private volatile x mNetwork = null;
        private String postUrl;

        public C0596a(String str, String str2, HashMap<String, String> hashMap, d dVar) {
            this.cKc = str;
            this.postUrl = str2;
            this.hYp = hashMap;
            this.hYq = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new x(this.postUrl);
                Set<String> keySet = this.hYp.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.addPostData(str, this.hYp.get(str));
                        }
                    }
                }
                this.mNetwork.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.aGk().aGL().mIsNeedTbs = true;
                String postNetData = this.mNetwork.postNetData();
                if (!this.mNetwork.aGk().aGM().isNetSuccess()) {
                    hVar.errorCode = this.mNetwork.getNetErrorCode();
                    hVar.errorString = this.mNetwork.getNetString();
                } else {
                    hVar.errorCode = this.mNetwork.getServerErrorCode();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.aGk().aGM().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            hVar.result = true;
                            hVar.cKc = this.cKc;
                            return hVar;
                        }
                        String str2 = "";
                        if (jSONObject.has("msg")) {
                            str2 = jSONObject.optString("msg", "");
                        }
                        hVar.result = false;
                        hVar.cKc = this.cKc;
                        hVar.errorString = str2;
                        return hVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.result = false;
            hVar.cKc = this.cKc;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.hYq != null) {
                this.hYq.callback(hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.hYq != null) {
                this.hYq.callback(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.hYq != null) {
                this.hYq.callback(null);
            }
        }
    }
}
