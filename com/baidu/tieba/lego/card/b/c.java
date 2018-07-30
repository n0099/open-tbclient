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

    public void aRh() {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.lego.card.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                HashMap aRi = c.this.aRi();
                e eVar = new e();
                eVar.hW().setUrl(c.this.url);
                eVar.hW().setMethod(HttpMessageTask.HTTP_METHOD.GET);
                if (aRi != null && !aRi.isEmpty()) {
                    eVar.hW().g(c.this.aRi());
                }
                new com.baidu.adp.lib.network.http.c(eVar).f(1, 0, 0);
                eVar.hX();
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> aRi() {
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(SM.COOKIE, cookie);
        return hashMap;
    }

    public static void pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            new c(str).aRh();
        }
    }

    public static void a(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            pr(bVar.getParallelCharge().ePE);
            Iterator<String> it = bVar.getParallelCharge().ePH.iterator();
            while (it.hasNext()) {
                pr(it.next());
            }
        }
    }

    public static void b(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            pr(bVar.getParallelCharge().ePF);
            Iterator<String> it = bVar.getParallelCharge().ePG.iterator();
            while (it.hasNext()) {
                pr(it.next());
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
