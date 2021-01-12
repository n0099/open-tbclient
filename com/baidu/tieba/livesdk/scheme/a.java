package com.baidu.tieba.livesdk.scheme;

import android.app.Activity;
import com.baidu.adp.base.b;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.sdk.b.f;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes9.dex */
public class a implements f {
    public void openScheme(String str) {
        if (!StringUtils.isNull(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
            sb.append("=1");
            sb.append("&page_from=live");
            Activity currentActivity = b.kC().currentActivity();
            if (currentActivity != null) {
                be.bsB().a((TbPageContext) j.K(currentActivity), new String[]{sb.toString()}, true);
            }
        }
    }

    @Override // com.baidu.tieba.sdk.b.f
    public void MY(String str) {
        openScheme(str);
    }
}
