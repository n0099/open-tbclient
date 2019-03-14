package com.baidu.tieba.image;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes3.dex */
public class d {
    public static String xL(String str) {
        int lastIndexOf;
        int indexOf;
        String by = ap.by(str);
        if (by != null) {
            if (by.indexOf(".baidu.com") != -1 && (lastIndexOf = by.lastIndexOf("/")) != -1 && (indexOf = by.indexOf(".", lastIndexOf)) != -1) {
                return by.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return by;
    }

    public static boolean xM(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String by = ap.by(str);
        return !StringUtils.isNull(by) && by.contains("?t=");
    }
}
