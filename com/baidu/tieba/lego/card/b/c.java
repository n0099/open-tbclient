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

    public void ctt() {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.lego.card.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                HashMap ctu = c.this.ctu();
                e eVar = new e();
                eVar.kD().setUrl(c.this.url);
                eVar.kD().setMethod(HttpMessageTask.HTTP_METHOD.GET);
                if (ctu != null && !ctu.isEmpty()) {
                    eVar.kD().v(c.this.ctu());
                }
                new com.baidu.adp.lib.network.http.c(eVar).f(1, 0, 0);
                eVar.kE();
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> ctu() {
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
            cookie = com.baidu.tbadk.browser.a.dxW;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(SM.COOKIE, cookie);
        return hashMap;
    }

    public static void Hx(String str) {
        if (!TextUtils.isEmpty(str)) {
            new c(str).ctt();
        }
    }

    public static void a(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            Hx(bVar.getParallelCharge().iZh);
            Iterator<String> it = bVar.getParallelCharge().iZk.iterator();
            while (it.hasNext()) {
                Hx(it.next());
            }
        }
    }

    public static void b(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            Hx(bVar.getParallelCharge().iZi);
            Iterator<String> it = bVar.getParallelCharge().iZj.iterator();
            while (it.hasNext()) {
                Hx(it.next());
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
