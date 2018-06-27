package com.baidu.tieba.image;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes3.dex */
public class d {
    public static String pa(String str) {
        int lastIndexOf;
        int indexOf;
        String bh = ap.bh(str);
        if (bh != null) {
            if (bh.indexOf(".baidu.com") != -1 && (lastIndexOf = bh.lastIndexOf("/")) != -1 && (indexOf = bh.indexOf(".", lastIndexOf)) != -1) {
                return bh.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return bh;
    }

    public static boolean pb(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String bh = ap.bh(str);
        return !StringUtils.isNull(bh) && bh.contains("?t=");
    }

    public static boolean pc(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) ? false : true;
    }
}
