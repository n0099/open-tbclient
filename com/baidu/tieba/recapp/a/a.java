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
    public String rq() {
        Uri parse = Uri.parse(this.mKey);
        return parse != null ? parse.getAuthority() + parse.getPath() : "";
    }

    @Override // com.baidu.tbadk.a.a, com.baidu.tbadk.a.f
    public void a(Object obj, HashMap<String, String> hashMap, String str, d dVar) {
        if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("url")) {
            String str2 = hashMap.get("url");
            if (!TextUtils.isEmpty(str2)) {
                C0224a c0224a = new C0224a(str, str2, hashMap, dVar);
                c0224a.setPriority(2);
                c0224a.execute(new Object[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.recapp.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0224a extends BdAsyncTask<Object, Integer, h> {
        private String ZQ;
        private HashMap<String, String> eOo;
        private d eOp;
        private volatile y mNetwork = null;
        private String postUrl;

        public C0224a(String str, String str2, HashMap<String, String> hashMap, d dVar) {
            this.ZQ = str;
            this.postUrl = str2;
            this.eOo = hashMap;
            this.eOp = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public h doInBackground(Object... objArr) {
            h hVar = new h();
            try {
                this.mNetwork = new y(this.postUrl);
                Set<String> keySet = this.eOo.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.mNetwork.o(str, this.eOo.get(str));
                        }
                    }
                }
                this.mNetwork.o("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.o("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.yM().zK().mIsNeedTbs = true;
                String yo = this.mNetwork.yo();
                if (!this.mNetwork.yM().zL().yP()) {
                    hVar.errorCode = this.mNetwork.yR();
                    hVar.errorString = this.mNetwork.yq();
                } else {
                    hVar.errorCode = this.mNetwork.yQ();
                    hVar.errorString = this.mNetwork.getErrorString();
                }
                if (this.mNetwork.yM().zL().isRequestSuccess() && !TextUtils.isEmpty(yo)) {
                    JSONObject jSONObject = new JSONObject(yo);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            hVar.ZR = true;
                            hVar.ZQ = this.ZQ;
                            return hVar;
                        }
                        String str2 = "";
                        if (jSONObject.has("msg")) {
                            str2 = jSONObject.optString("msg", "");
                        }
                        hVar.ZR = false;
                        hVar.ZQ = this.ZQ;
                        hVar.errorString = str2;
                        return hVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            hVar.ZR = false;
            hVar.ZQ = this.ZQ;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            if (this.eOp != null) {
                this.eOp.i(hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eOp != null) {
                this.eOp.i(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            super.cancel(true);
            if (this.eOp != null) {
                this.eOp.i(null);
            }
        }
    }
}
