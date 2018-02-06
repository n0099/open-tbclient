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
    public String vG() {
        Uri parse = Uri.parse(this.mKey);
        return parse != null ? parse.getAuthority() + parse.getPath() : "";
    }

    @Override // com.baidu.tbadk.a.a, com.baidu.tbadk.a.f
    public void a(Object obj, HashMap<String, String> hashMap, String str, d dVar) {
        if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("url")) {
            String str2 = hashMap.get("url");
            if (!TextUtils.isEmpty(str2)) {
                C0222a c0222a = new C0222a(str, str2, hashMap, dVar);
                c0222a.setPriority(2);
                c0222a.execute(new Object[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0222a extends BdAsyncTask<Object, Integer, h> {
        private String aHc;
        private HashMap<String, String> eZC;
        private d eZD;
        private volatile x mNetwork = null;
        private String postUrl;

        public C0222a(String str, String str2, HashMap<String, String> hashMap, d dVar) {
            this.aHc = str;
            this.postUrl = str2;
            this.eZC = hashMap;
            this.eZD = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new x(this.postUrl);
                Set<String> keySet = this.eZC.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.n(str, this.eZC.get(str));
                        }
                    }
                }
                this.mNetwork.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.Cz().Dw().mIsNeedTbs = true;
                String Cb = this.mNetwork.Cb();
                if (!this.mNetwork.Cz().Dx().CC()) {
                    hVar.errorCode = this.mNetwork.CE();
                    hVar.errorString = this.mNetwork.Cd();
                } else {
                    hVar.errorCode = this.mNetwork.CD();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.Cz().Dx().isRequestSuccess() && !TextUtils.isEmpty(Cb)) {
                    JSONObject jSONObject = new JSONObject(Cb);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            hVar.aHd = true;
                            hVar.aHc = this.aHc;
                            return hVar;
                        }
                        String str2 = "";
                        if (jSONObject.has("msg")) {
                            str2 = jSONObject.optString("msg", "");
                        }
                        hVar.aHd = false;
                        hVar.aHc = this.aHc;
                        hVar.errorString = str2;
                        return hVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.aHd = false;
            hVar.aHc = this.aHc;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.eZD != null) {
                this.eZD.ak(hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eZD != null) {
                this.eZD.ak(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.eZD != null) {
                this.eZD.ak(null);
            }
        }
    }
}
