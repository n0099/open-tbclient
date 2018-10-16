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
                C0265a c0265a = new C0265a(str, str2, hashMap, dVar);
                c0265a.setPriority(2);
                c0265a.execute(new Object[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0265a extends BdAsyncTask<Object, Integer, h> {
        private String ahr;
        private HashMap<String, String> fdq;
        private d fdr;
        private volatile x mNetwork = null;
        private String postUrl;

        public C0265a(String str, String str2, HashMap<String, String> hashMap, d dVar) {
            this.ahr = str;
            this.postUrl = str2;
            this.fdq = hashMap;
            this.fdr = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new x(this.postUrl);
                Set<String> keySet = this.fdq.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.x(str, this.fdq.get(str));
                        }
                    }
                }
                this.mNetwork.x("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.x("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.BY().CW().mIsNeedTbs = true;
                String BA = this.mNetwork.BA();
                if (!this.mNetwork.BY().CX().Cb()) {
                    hVar.errorCode = this.mNetwork.Cd();
                    hVar.errorString = this.mNetwork.BC();
                } else {
                    hVar.errorCode = this.mNetwork.Cc();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.BY().CX().isRequestSuccess() && !TextUtils.isEmpty(BA)) {
                    JSONObject jSONObject = new JSONObject(BA);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            hVar.ahs = true;
                            hVar.ahr = this.ahr;
                            return hVar;
                        }
                        String str2 = "";
                        if (jSONObject.has("msg")) {
                            str2 = jSONObject.optString("msg", "");
                        }
                        hVar.ahs = false;
                        hVar.ahr = this.ahr;
                        hVar.errorString = str2;
                        return hVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.ahs = false;
            hVar.ahr = this.ahr;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.fdr != null) {
                this.fdr.m(hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.fdr != null) {
                this.fdr.m(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.fdr != null) {
                this.fdr.m(null);
            }
        }
    }
}
