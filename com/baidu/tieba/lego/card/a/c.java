package com.baidu.tieba.lego.card.a;

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

    public void dbF() {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.lego.card.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                HashMap dbG = c.this.dbG();
                e eVar = new e();
                eVar.lU().setUrl(c.this.url);
                eVar.lU().setMethod(HttpMessageTask.HTTP_METHOD.GET);
                if (dbG != null && !dbG.isEmpty()) {
                    eVar.lU().t(c.this.dbG());
                }
                new com.baidu.adp.lib.network.http.c(eVar).f(1, 0, 0);
                eVar.lV();
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> dbG() {
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
            cookie = com.baidu.tbadk.browser.a.eHi;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(SM.COOKIE, cookie);
        return hashMap;
    }

    private static void NH(String str) {
        if (!TextUtils.isEmpty(str)) {
            new c(str).dbF();
        }
    }

    public static boolean a(b bVar) {
        if (bVar == null || bVar.getParallelCharge() == null) {
            return false;
        }
        String str = bVar.getParallelCharge().lbF;
        NH(str);
        boolean z = !TextUtils.isEmpty(str);
        Iterator<String> it = bVar.getParallelCharge().lbI.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            String next = it.next();
            z2 = z2 || !TextUtils.isEmpty(next);
            NH(next);
        }
        return z2;
    }

    public static void b(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            NH(bVar.getParallelCharge().lbG);
            Iterator<String> it = bVar.getParallelCharge().lbH.iterator();
            while (it.hasNext()) {
                NH(it.next());
            }
        }
    }

    public static b c(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null || advertAppInfo.legoCard == null || !(advertAppInfo.legoCard instanceof b)) {
            return null;
        }
        return (b) advertAppInfo.legoCard;
    }
}
