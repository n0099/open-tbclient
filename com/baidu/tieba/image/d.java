package com.baidu.tieba.image;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes3.dex */
public class d {
    public static String zN(String str) {
        int lastIndexOf;
        int indexOf;
        String bj = aq.bj(str);
        if (bj != null) {
            if (bj.indexOf(".baidu.com") != -1 && (lastIndexOf = bj.lastIndexOf("/")) != -1 && (indexOf = bj.indexOf(".", lastIndexOf)) != -1) {
                return bj.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return bj;
    }

    public static boolean zO(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String bj = aq.bj(str);
        return !StringUtils.isNull(bj) && bj.contains("?t=");
    }
}
