package com.baidu.tieba.image;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes3.dex */
public class d {
    public static String yE(String str) {
        int lastIndexOf;
        int indexOf;
        String urlDecode = aq.getUrlDecode(str);
        if (urlDecode != null) {
            if (urlDecode.indexOf(".baidu.com") != -1 && (lastIndexOf = urlDecode.lastIndexOf("/")) != -1 && (indexOf = urlDecode.indexOf(DefaultConfig.TOKEN_SEPARATOR, lastIndexOf)) != -1) {
                return urlDecode.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return urlDecode;
    }

    public static boolean yF(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String urlDecode = aq.getUrlDecode(str);
        return !StringUtils.isNull(urlDecode) && urlDecode.contains("?t=");
    }
}
