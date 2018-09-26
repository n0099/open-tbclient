package com.baidu.tieba.image;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes3.dex */
public class d {
    public static String pJ(String str) {
        int lastIndexOf;
        int indexOf;
        String bz = ao.bz(str);
        if (bz != null) {
            if (bz.indexOf(".baidu.com") != -1 && (lastIndexOf = bz.lastIndexOf("/")) != -1 && (indexOf = bz.indexOf(".", lastIndexOf)) != -1) {
                return bz.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return bz;
    }

    public static boolean pK(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String bz = ao.bz(str);
        return !StringUtils.isNull(bz) && bz.contains("?t=");
    }

    public static boolean pL(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) ? false : true;
    }
}
