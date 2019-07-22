package com.baidu.tieba.image;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class g {
    public static void aA(Context context, String str) {
        String format;
        if (!TextUtils.isEmpty(str)) {
            try {
                format = String.format("http://graph.baidu.com/details?image=%s&carousel=0&tn=tieba&promotion_name=shitu", URLEncoder.encode(str, HTTP.UTF_8));
            } catch (UnsupportedEncodingException e) {
                format = String.format("http://graph.baidu.com/details?image=%s&carousel=0&tn=tieba&promotion_name=shitu", str);
            }
            com.baidu.tbadk.browser.a.ae(context, format);
        }
    }
}
