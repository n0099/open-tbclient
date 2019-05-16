package com.baidu.tieba.image;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes3.dex */
public class d {
    public static String yZ(String str) {
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

    public static boolean za(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String bi = ap.bi(str);
        return !StringUtils.isNull(bi) && bi.contains("?t=");
    }
}
