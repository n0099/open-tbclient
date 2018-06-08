package com.baidu.tieba.image;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes3.dex */
public class d {
    public static String oZ(String str) {
        int lastIndexOf;
        int indexOf;
        String bf = ao.bf(str);
        if (bf != null) {
            if (bf.indexOf(".baidu.com") != -1 && (lastIndexOf = bf.lastIndexOf("/")) != -1 && (indexOf = bf.indexOf(".", lastIndexOf)) != -1) {
                return bf.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return bf;
    }

    public static boolean pa(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String bf = ao.bf(str);
        return !StringUtils.isNull(bf) && bf.contains("?t=");
    }

    public static boolean pb(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }
}
