package com.baidu.tieba.recapp.request;

import android.webkit.CookieManager;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes13.dex */
public class a {
    private String url;

    public a(String str) {
        this.url = str;
    }

    public void a(final String str, final int i, final int i2, final int i3, final String str2, final String str3) {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.request.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                HashMap cxk = a.this.cxk();
                HashMap b = a.this.b(str, i, i2, i3, str2, str3);
                e eVar = new e();
                eVar.kT().setUrl(a.this.url);
                eVar.kT().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                if (cxk != null && !cxk.isEmpty()) {
                    eVar.kT().v(a.this.cxk());
                }
                if (b != null && !b.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, Object> entry : b.entrySet()) {
                        arrayList.add(entry);
                    }
                    eVar.kT().m(arrayList);
                }
                new c(eVar).f(1, 0, 0);
                eVar.kU();
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> cxk() {
        String cookie = CookieManager.getInstance().getCookie("tieba.baidu.com");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(SM.COOKIE, cookie);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> b(String str, int i, int i2, int i3, String str2, String str3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ev", str);
        hashMap.put("st", i + "");
        hashMap.put("et", i2 + "");
        hashMap.put("dur", i3 + "");
        hashMap.put("pg", str2);
        hashMap.put("at", str3);
        return hashMap;
    }
}
