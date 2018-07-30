package com.baidu.tieba.image;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes3.dex */
public class d {
    public static String pc(String str) {
        int lastIndexOf;
        int indexOf;
        String bi = ap.bi(str);
        if (bi != null) {
            if (bi.indexOf(".baidu.com") != -1 && (lastIndexOf = bi.lastIndexOf("/")) != -1 && (indexOf = bi.indexOf(".", lastIndexOf)) != -1) {
                return bi.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return bi;
    }

    public static boolean pd(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String bi = ap.bi(str);
        return !StringUtils.isNull(bi) && bi.contains("?t=");
    }

    public static boolean pe(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) ? false : true;
    }
}
