package com.baidu.tieba.image;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class d {
    public static String oe(String str) {
        int lastIndexOf;
        int indexOf;
        String aW = am.aW(str);
        if (aW != null) {
            if (aW.indexOf(".baidu.com") != -1 && (lastIndexOf = aW.lastIndexOf("/")) != -1 && (indexOf = aW.indexOf(Constants.DOT, lastIndexOf)) != -1) {
                return aW.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aW;
    }

    public static boolean og(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String aW = am.aW(str);
        return !StringUtils.isNull(aW) && aW.contains("?t=");
    }

    public static boolean oh(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }
}
