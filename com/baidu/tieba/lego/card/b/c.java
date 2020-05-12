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

    public void cmI() {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.lego.card.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                HashMap cmJ = c.this.cmJ();
                e eVar = new e();
                eVar.kB().setUrl(c.this.url);
                eVar.kB().setMethod(HttpMessageTask.HTTP_METHOD.GET);
                if (cmJ != null && !cmJ.isEmpty()) {
                    eVar.kB().v(c.this.cmJ());
                }
                new com.baidu.adp.lib.network.http.c(eVar).f(1, 0, 0);
                eVar.kC();
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> cmJ() {
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
            cookie = com.baidu.tbadk.browser.a.djW;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(SM.COOKIE, cookie);
        return hashMap;
    }

    public static void FO(String str) {
        if (!TextUtils.isEmpty(str)) {
            new c(str).cmI();
        }
    }

    public static void a(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            FO(bVar.getParallelCharge().iJu);
            Iterator<String> it = bVar.getParallelCharge().iJx.iterator();
            while (it.hasNext()) {
                FO(it.next());
            }
        }
    }

    public static void b(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            FO(bVar.getParallelCharge().iJv);
            Iterator<String> it = bVar.getParallelCharge().iJw.iterator();
            while (it.hasNext()) {
                FO(it.next());
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
