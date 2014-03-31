package com.baidu.tieba.pb.main;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
final class ab implements com.baidu.tbadk.core.util.bi {
    @Override // com.baidu.tbadk.core.util.bi
    public final boolean a(Context context, String[] strArr) {
        String str;
        String str2;
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str3 = strArr[0];
        if (str3.startsWith("pb:")) {
            String substring = str3.substring(3);
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            if (strArr.length > 1) {
                str = substring;
                str2 = strArr[1];
            } else {
                str = substring;
                str2 = null;
            }
        } else if (!str3.startsWith("tieba.baidu.com/p/")) {
            return false;
        } else {
            String substring2 = str3.substring(str3.indexOf("tieba.baidu.com/p/") + 18);
            if (TextUtils.isEmpty(substring2)) {
                return false;
            }
            str = substring2;
            str2 = "allthread";
        }
        if (context instanceof com.baidu.tbadk.core.e) {
            ((com.baidu.tbadk.core.e) context).a(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(context).a(str, null, str2)));
            return true;
        } else if (context instanceof com.baidu.tbadk.a) {
            ((com.baidu.tbadk.a) context).sendMessage(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(context).a(str, null, str2)));
            return true;
        } else {
            return false;
        }
    }
}
