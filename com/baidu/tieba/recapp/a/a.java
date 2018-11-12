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
                C0293a c0293a = new C0293a(str, str2, hashMap, dVar);
                c0293a.setPriority(2);
                c0293a.execute(new Object[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0293a extends BdAsyncTask<Object, Integer, h> {
        private String aie;
        private HashMap<String, String> feK;
        private d feL;
        private volatile x mNetwork = null;
        private String postUrl;

        public C0293a(String str, String str2, HashMap<String, String> hashMap, d dVar) {
            this.aie = str;
            this.postUrl = str2;
            this.feK = hashMap;
            this.feL = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new x(this.postUrl);
                Set<String> keySet = this.feK.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.x(str, this.feK.get(str));
                        }
                    }
                }
                this.mNetwork.x("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.x("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.Cf().Dd().mIsNeedTbs = true;
                String BH = this.mNetwork.BH();
                if (!this.mNetwork.Cf().De().Ci()) {
                    hVar.errorCode = this.mNetwork.Ck();
                    hVar.errorString = this.mNetwork.BJ();
                } else {
                    hVar.errorCode = this.mNetwork.Cj();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.Cf().De().isRequestSuccess() && !TextUtils.isEmpty(BH)) {
                    JSONObject jSONObject = new JSONObject(BH);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            hVar.aif = true;
                            hVar.aie = this.aie;
                            return hVar;
                        }
                        String str2 = "";
                        if (jSONObject.has("msg")) {
                            str2 = jSONObject.optString("msg", "");
                        }
                        hVar.aif = false;
                        hVar.aie = this.aie;
                        hVar.errorString = str2;
                        return hVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.aif = false;
            hVar.aie = this.aie;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.feL != null) {
                this.feL.m(hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.feL != null) {
                this.feL.m(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.jg();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.feL != null) {
                this.feL.m(null);
            }
        }
    }
}
