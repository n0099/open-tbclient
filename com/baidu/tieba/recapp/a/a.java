package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.a.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.a.a {
    private String mKey;

    public a(String str) {
        this.mKey = str;
    }

    @Override // com.baidu.tbadk.a.a
    public String key() {
        Uri parse = Uri.parse(this.mKey);
        return parse != null ? parse.getAuthority() + parse.getPath() : "";
    }

    @Override // com.baidu.tbadk.a.a, com.baidu.tbadk.a.f
    public void a(Object obj, HashMap<String, String> hashMap, String str, d dVar) {
        if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("url")) {
            String str2 = hashMap.get("url");
            if (!TextUtils.isEmpty(str2)) {
                C0205a c0205a = new C0205a(str, str2, hashMap, dVar);
                c0205a.setPriority(2);
                c0205a.execute(new Object[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0205a extends BdAsyncTask<Object, Integer, h> {
        private String Sc;
        private HashMap<String, String> eun;
        private d euo;
        private volatile x mNetwork = null;
        private String postUrl;

        public C0205a(String str, String str2, HashMap<String, String> hashMap, d dVar) {
            this.Sc = str;
            this.postUrl = str2;
            this.eun = hashMap;
            this.euo = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new x(this.postUrl);
                Set<String> keySet = this.eun.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.n(str, this.eun.get(str));
                        }
                    }
                }
                this.mNetwork.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.vj().wi().mIsNeedTbs = true;
                String uL = this.mNetwork.uL();
                if (!this.mNetwork.vj().wj().vm()) {
                    hVar.errorCode = this.mNetwork.vo();
                    hVar.errorString = this.mNetwork.uN();
                } else {
                    hVar.errorCode = this.mNetwork.vn();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.vj().wj().isRequestSuccess() && !TextUtils.isEmpty(uL)) {
                    JSONObject jSONObject = new JSONObject(uL);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            hVar.Sd = true;
                            hVar.Sc = this.Sc;
                            return hVar;
                        }
                        String str2 = "";
                        if (jSONObject.has("msg")) {
                            str2 = jSONObject.optString("msg", "");
                        }
                        hVar.Sd = false;
                        hVar.Sc = this.Sc;
                        hVar.errorString = str2;
                        return hVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.Sd = false;
            hVar.Sc = this.Sc;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.euo != null) {
                this.euo.f(hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.euo != null) {
                this.euo.f(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.eW();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.euo != null) {
                this.euo.f(null);
            }
        }
    }
}
