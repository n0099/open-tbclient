package com.baidu.tieba.lego.card.b;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.cookie.SM;
/* loaded from: classes.dex */
public class c {
    private String url;

    public c(String str) {
        this.url = str;
    }

    public void cYY() {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.lego.card.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                HashMap cYZ = c.this.cYZ();
                e eVar = new e();
                eVar.mx().setUrl(c.this.url);
                eVar.mx().setMethod(HttpMessageTask.HTTP_METHOD.GET);
                if (cYZ != null && !cYZ.isEmpty()) {
                    eVar.mx().t(c.this.cYZ());
                }
                new com.baidu.adp.lib.network.http.c(eVar).f(1, 0, 0);
                eVar.my();
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> cYZ() {
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
            cookie = com.baidu.tbadk.browser.a.euN;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(SM.COOKIE, cookie);
        return hashMap;
    }

    private static void NN(String str) {
        if (!TextUtils.isEmpty(str)) {
            new c(str).cYY();
        }
    }

    public static boolean a(b bVar) {
        if (bVar == null || bVar.getParallelCharge() == null) {
            return false;
        }
        String str = bVar.getParallelCharge().kEG;
        NN(str);
        boolean z = !TextUtils.isEmpty(str);
        Iterator<String> it = bVar.getParallelCharge().kEJ.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            String next = it.next();
            z2 = z2 || !TextUtils.isEmpty(next);
            NN(next);
        }
        return z2;
    }

    public static void b(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            NN(bVar.getParallelCharge().kEH);
            Iterator<String> it = bVar.getParallelCharge().kEI.iterator();
            while (it.hasNext()) {
                NN(it.next());
            }
        }
    }

    public static b d(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null || advertAppInfo.legoCard == null || !(advertAppInfo.legoCard instanceof b)) {
            return null;
        }
        return (b) advertAppInfo.legoCard;
    }
}
