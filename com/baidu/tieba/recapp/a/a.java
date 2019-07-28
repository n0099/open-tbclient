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
/* loaded from: classes3.dex */
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
                C0399a c0399a = new C0399a(str, str2, hashMap, dVar);
                c0399a.setPriority(2);
                c0399a.execute(new Object[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0399a extends BdAsyncTask<Object, Integer, h> {
        private String bAM;
        private d ept;
        private HashMap<String, String> hcR;
        private volatile x mNetwork = null;
        private String postUrl;

        public C0399a(String str, String str2, HashMap<String, String> hashMap, d dVar) {
            this.bAM = str;
            this.postUrl = str2;
            this.hcR = hashMap;
            this.ept = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new x(this.postUrl);
                Set<String> keySet = this.hcR.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.o(str, this.hcR.get(str));
                        }
                    }
                }
                this.mNetwork.o("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.o("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.aiE().ajE().mIsNeedTbs = true;
                String aig = this.mNetwork.aig();
                if (!this.mNetwork.aiE().ajF().aiH()) {
                    hVar.errorCode = this.mNetwork.aiJ();
                    hVar.errorString = this.mNetwork.aii();
                } else {
                    hVar.errorCode = this.mNetwork.aiI();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.aiE().ajF().isRequestSuccess() && !TextUtils.isEmpty(aig)) {
                    JSONObject jSONObject = new JSONObject(aig);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            hVar.result = true;
                            hVar.bAM = this.bAM;
                            return hVar;
                        }
                        String str2 = "";
                        if (jSONObject.has("msg")) {
                            str2 = jSONObject.optString("msg", "");
                        }
                        hVar.result = false;
                        hVar.bAM = this.bAM;
                        hVar.errorString = str2;
                        return hVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.result = false;
            hVar.bAM = this.bAM;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.ept != null) {
                this.ept.m(hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ept != null) {
                this.ept.m(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.ept != null) {
                this.ept.m(null);
            }
        }
    }
}
