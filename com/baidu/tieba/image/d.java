package com.baidu.tieba.image;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes15.dex */
public class d {
    public static String Iz(String str) {
        int indexOf;
        String urlDecode = as.getUrlDecode(str);
        if (urlDecode != null) {
            int lastIndexOf = urlDecode.lastIndexOf("/");
            if (lastIndexOf != -1 && (indexOf = urlDecode.indexOf(".", lastIndexOf)) != -1) {
                return urlDecode.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return urlDecode;
    }

    public static boolean IA(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String urlDecode = as.getUrlDecode(str);
        return !StringUtils.isNull(urlDecode) && urlDecode.contains("?t=");
    }
}
