package com.baidu.tieba.livesdk.scheme;

import android.app.Activity;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.sdk.b.g;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public class a implements g {
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
            Activity currentActivity = com.baidu.adp.base.a.lf().currentActivity();
            if (currentActivity != null) {
                be.bkp().a((TbPageContext) i.I(currentActivity), new String[]{sb.toString()}, true);
            }
        }
    }

    @Override // com.baidu.tieba.sdk.b.g
    public void Mq(String str) {
        openScheme(str);
    }
}
