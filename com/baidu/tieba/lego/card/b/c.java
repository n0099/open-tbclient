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

    public void aQg() {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.lego.card.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                HashMap aQh = c.this.aQh();
                e eVar = new e();
                eVar.hV().setUrl(c.this.url);
                eVar.hV().setMethod(HttpMessageTask.HTTP_METHOD.GET);
                if (aQh != null && !aQh.isEmpty()) {
                    eVar.hV().g(c.this.aQh());
                }
                new com.baidu.adp.lib.network.http.c(eVar).f(1, 0, 0);
                eVar.hW();
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> aQh() {
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(SM.COOKIE, cookie);
        return hashMap;
    }

    public static void pp(String str) {
        if (!TextUtils.isEmpty(str)) {
            new c(str).aQg();
        }
    }

    public static void a(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            pp(bVar.getParallelCharge().eLJ);
            Iterator<String> it = bVar.getParallelCharge().eLM.iterator();
            while (it.hasNext()) {
                pp(it.next());
            }
        }
    }

    public static void b(b bVar) {
        if (bVar != null && bVar.getParallelCharge() != null) {
            pp(bVar.getParallelCharge().eLK);
            Iterator<String> it = bVar.getParallelCharge().eLL.iterator();
            while (it.hasNext()) {
                pp(it.next());
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
