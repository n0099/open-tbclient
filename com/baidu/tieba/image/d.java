package com.baidu.tieba.image;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes6.dex */
public class d {
    public static String Dx(String str) {
        int indexOf;
        String urlDecode = aq.getUrlDecode(str);
        if (urlDecode != null) {
            int lastIndexOf = urlDecode.lastIndexOf("/");
            if (lastIndexOf != -1 && (indexOf = urlDecode.indexOf(".", lastIndexOf)) != -1) {
                return urlDecode.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return urlDecode;
    }

    public static boolean Dy(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String urlDecode = aq.getUrlDecode(str);
        return !StringUtils.isNull(urlDecode) && urlDecode.contains("?t=");
    }
}
