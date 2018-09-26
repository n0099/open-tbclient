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
    public String sw() {
        Uri parse = Uri.parse(this.mKey);
        return parse != null ? parse.getAuthority() + parse.getPath() : "";
    }

    @Override // com.baidu.tbadk.a.a, com.baidu.tbadk.a.f
    public void a(Object obj, HashMap<String, String> hashMap, String str, d dVar) {
        if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("url")) {
            String str2 = hashMap.get("url");
            if (!TextUtils.isEmpty(str2)) {
                C0230a c0230a = new C0230a(str, str2, hashMap, dVar);
                c0230a.setPriority(2);
                c0230a.execute(new Object[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0230a extends BdAsyncTask<Object, Integer, h> {
        private String acs;
        private HashMap<String, String> eVJ;
        private d eVK;
        private volatile x mNetwork = null;
        private String postUrl;

        public C0230a(String str, String str2, HashMap<String, String> hashMap, d dVar) {
            this.acs = str;
            this.postUrl = str2;
            this.eVJ = hashMap;
            this.eVK = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new x(this.postUrl);
                Set<String> keySet = this.eVJ.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.u(str, this.eVJ.get(str));
                        }
                    }
                }
                this.mNetwork.u("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.u("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.zR().AP().mIsNeedTbs = true;
                String zt = this.mNetwork.zt();
                if (!this.mNetwork.zR().AQ().zU()) {
                    hVar.errorCode = this.mNetwork.zW();
                    hVar.errorString = this.mNetwork.zv();
                } else {
                    hVar.errorCode = this.mNetwork.zV();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.zR().AQ().isRequestSuccess() && !TextUtils.isEmpty(zt)) {
                    JSONObject jSONObject = new JSONObject(zt);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            hVar.act = true;
                            hVar.acs = this.acs;
                            return hVar;
                        }
                        String str2 = "";
                        if (jSONObject.has("msg")) {
                            str2 = jSONObject.optString("msg", "");
                        }
                        hVar.act = false;
                        hVar.acs = this.acs;
                        hVar.errorString = str2;
                        return hVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.act = false;
            hVar.acs = this.acs;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.eVK != null) {
                this.eVK.j(hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eVK != null) {
                this.eVK.j(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.iT();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.eVK != null) {
                this.eVK.j(null);
            }
        }
    }
}
