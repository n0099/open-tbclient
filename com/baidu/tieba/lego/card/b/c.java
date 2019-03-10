package com.baidu.tieba.lego.card.b;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private String url;

    public c(String str) {
        this.url = str;
    }

    public void bzO() {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.lego.card.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                HashMap bzP = c.this.bzP();
                e eVar = new e();
                eVar.jr().setUrl(c.this.url);
                eVar.jr().setMethod(HttpMessageTask.HTTP_METHOD.GET);
                if (bzP != null && !bzP.isEmpty()) {
                    eVar.jr().k(c.this.bzP());
                }
                new com.baidu.adp.lib.network.http.c(eVar).g(1, 0, 0);
                eVar.js();
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> bzP() {
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
            cookie = com.baidu.tbadk.browser.a.btD;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Cookie", cookie);
        return hashMap;
    }

    public static void yb(String str) {
        if (!TextUtils.isEmpty(str)) {
            new c(str).bzO();
        }
    }

    public static void a(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            yb(bVar.getParallelCharge().gGF);
            Iterator<String> it = bVar.getParallelCharge().gGI.iterator();
            while (it.hasNext()) {
                yb(it.next());
            }
        }
    }

    public static void b(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            yb(bVar.getParallelCharge().gGG);
            Iterator<String> it = bVar.getParallelCharge().gGH.iterator();
            while (it.hasNext()) {
                yb(it.next());
            }
        }
    }

    public static b e(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null || advertAppInfo.legoCard == null || !(advertAppInfo.legoCard instanceof b)) {
            return null;
        }
        return (b) advertAppInfo.legoCard;
    }
}
