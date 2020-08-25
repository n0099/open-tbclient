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
/* loaded from: classes2.dex */
public class c {
    private String url;

    public c(String str) {
        this.url = str;
    }

    public void cLZ() {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.lego.card.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                HashMap cMa = c.this.cMa();
                e eVar = new e();
                eVar.ms().setUrl(c.this.url);
                eVar.ms().setMethod(HttpMessageTask.HTTP_METHOD.GET);
                if (cMa != null && !cMa.isEmpty()) {
                    eVar.ms().t(c.this.cMa());
                }
                new com.baidu.adp.lib.network.http.c(eVar).f(1, 0, 0);
                eVar.mt();
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> cMa() {
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
            cookie = com.baidu.tbadk.browser.a.dSg;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(SM.COOKIE, cookie);
        return hashMap;
    }

    public static void LG(String str) {
        if (!TextUtils.isEmpty(str)) {
            new c(str).cLZ();
        }
    }

    public static boolean a(b bVar) {
        if (bVar == null || bVar.getParallelCharge() == null) {
            return false;
        }
        String str = bVar.getParallelCharge().jOq;
        LG(str);
        boolean z = !TextUtils.isEmpty(str);
        Iterator<String> it = bVar.getParallelCharge().jOt.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            String next = it.next();
            z2 = z2 || !TextUtils.isEmpty(next);
            LG(next);
        }
        return z2;
    }

    public static void b(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            LG(bVar.getParallelCharge().jOr);
            Iterator<String> it = bVar.getParallelCharge().jOs.iterator();
            while (it.hasNext()) {
                LG(it.next());
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
