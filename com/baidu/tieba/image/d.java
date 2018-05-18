package com.baidu.tieba.image;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes3.dex */
public class d {
    public static String om(String str) {
        int lastIndexOf;
        int indexOf;
        String aT = an.aT(str);
        if (aT != null) {
            if (aT.indexOf(".baidu.com") != -1 && (lastIndexOf = aT.lastIndexOf("/")) != -1 && (indexOf = aT.indexOf(Constants.DOT, lastIndexOf)) != -1) {
                return aT.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aT;
    }

    public static boolean oo(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String aT = an.aT(str);
        return !StringUtils.isNull(aT) && aT.contains("?t=");
    }

    public static boolean op(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }
}
