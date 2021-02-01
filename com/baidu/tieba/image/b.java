package com.baidu.tieba.image;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes8.dex */
public class b {
    public static String Nr(String str) {
        int indexOf;
        String urlDecode = au.getUrlDecode(str);
        if (urlDecode != null) {
            int lastIndexOf = urlDecode.lastIndexOf("/");
            if (lastIndexOf != -1 && (indexOf = urlDecode.indexOf(".", lastIndexOf)) != -1) {
                return urlDecode.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return urlDecode;
    }

    public static boolean Ns(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String urlDecode = au.getUrlDecode(str);
        return !StringUtils.isNull(urlDecode) && urlDecode.contains("?t=");
    }
}
