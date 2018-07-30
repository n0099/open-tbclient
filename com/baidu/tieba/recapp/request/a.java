package com.baidu.tieba.recapp.request;

import android.webkit.CookieManager;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes3.dex */
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
                HashMap aRi = a.this.aRi();
                HashMap b = a.this.b(str, i, i2, i3, str2, str3);
                e eVar = new e();
                eVar.hW().setUrl(a.this.url);
                eVar.hW().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                if (aRi != null && !aRi.isEmpty()) {
                    eVar.hW().g(a.this.aRi());
                }
                if (b != null && !b.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, Object> entry : b.entrySet()) {
                        arrayList.add(entry);
                    }
                    eVar.hW().j(arrayList);
                }
                new c(eVar).f(1, 0, 0);
                eVar.hX();
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> aRi() {
        String cookie = CookieManager.getInstance().getCookie("tieba.baidu.com");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(SM.COOKIE, cookie);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> b(String str, int i, int i2, int i3, String str2, String str3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(h.c, str);
        hashMap.put(TimeDisplaySetting.START_SHOW_TIME, i + "");
        hashMap.put("et", i2 + "");
        hashMap.put("dur", i3 + "");
        hashMap.put("pg", str2);
        hashMap.put("at", str3);
        return hashMap;
    }
}
