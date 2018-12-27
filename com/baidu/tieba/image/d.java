package com.baidu.tieba.image;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes3.dex */
public class d {
    public static String qR(String str) {
        int lastIndexOf;
        int indexOf;
        String by = ao.by(str);
        if (by != null) {
            if (by.indexOf(".baidu.com") != -1 && (lastIndexOf = by.lastIndexOf("/")) != -1 && (indexOf = by.indexOf(".", lastIndexOf)) != -1) {
                return by.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return by;
    }

    public static boolean qS(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String by = ao.by(str);
        return !StringUtils.isNull(by) && by.contains("?t=");
    }

    public static boolean qT(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) ? false : true;
    }
}
