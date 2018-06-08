package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.a.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
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
                C0222a c0222a = new C0222a(str, str2, hashMap, dVar);
                c0222a.setPriority(2);
                c0222a.execute(new Object[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0222a extends BdAsyncTask<Object, Integer, h> {
        private String aai;
        private HashMap<String, String> eGJ;
        private d eGK;
        private volatile y mNetwork = null;
        private String postUrl;

        public C0222a(String str, String str2, HashMap<String, String> hashMap, d dVar) {
            this.aai = str;
            this.postUrl = str2;
            this.eGJ = hashMap;
            this.eGK = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new y(this.postUrl);
                Set<String> keySet = this.eGJ.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.o(str, this.eGJ.get(str));
                        }
                    }
                }
                this.mNetwork.o("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.o("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.yJ().zI().mIsNeedTbs = true;
                String yl = this.mNetwork.yl();
                if (!this.mNetwork.yJ().zJ().yM()) {
                    hVar.errorCode = this.mNetwork.yO();
                    hVar.errorString = this.mNetwork.yn();
                } else {
                    hVar.errorCode = this.mNetwork.yN();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.yJ().zJ().isRequestSuccess() && !TextUtils.isEmpty(yl)) {
                    JSONObject jSONObject = new JSONObject(yl);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            hVar.aaj = true;
                            hVar.aai = this.aai;
                            return hVar;
                        }
                        String str2 = "";
                        if (jSONObject.has("msg")) {
                            str2 = jSONObject.optString("msg", "");
                        }
                        hVar.aaj = false;
                        hVar.aai = this.aai;
                        hVar.errorString = str2;
                        return hVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.aaj = false;
            hVar.aai = this.aai;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.eGK != null) {
                this.eGK.i(hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eGK != null) {
                this.eGK.i(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.eGK != null) {
                this.eGK.i(null);
            }
        }
    }
}
