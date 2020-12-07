package com.baidu.tieba.livesdk.scheme;

import android.app.Activity;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.sdk.b.f;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
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
            Activity currentActivity = com.baidu.adp.base.a.lg().currentActivity();
            if (currentActivity != null) {
                bf.bua().a((TbPageContext) i.J(currentActivity), new String[]{sb.toString()}, true);
            }
        }
    }

    @Override // com.baidu.tieba.sdk.b.f
    public void Oz(String str) {
        openScheme(str);
    }
}
