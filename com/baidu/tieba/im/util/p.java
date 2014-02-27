package com.baidu.tieba.im.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.UtilHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class p {
    private static final Pattern a = Pattern.compile("(((ht|f)tp(s{0,1}))://)?([\\w-]+\\.)+[a-zA-Z_-]{2,}(/[\\w-./?%&+=#]*)?", 2);

    public static SpannableString a(Context context, String str) {
        int start;
        Matcher matcher = a.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            String group = matcher.group();
            String group2 = matcher.group();
            if (!group2.endsWith(" ")) {
                group2 = String.valueOf(group2) + " ";
            }
            int length = group2.length();
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.h(context, 2, group), matcher.start(), (length + start) - 1, 33);
        }
        return spannableString;
    }

    public static void a(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith(com.baidu.loginshare.e.f) && !lowerCase.startsWith(com.baidu.loginshare.e.g) && !lowerCase.startsWith("ftp://") && !lowerCase.startsWith("mailto:")) {
                lowerCase = com.baidu.loginshare.e.f + lowerCase;
                str = com.baidu.loginshare.e.f + str;
            }
            a(context, lowerCase, str);
        }
    }

    public static void b(Context context, String str) {
        a(context, str, false);
    }

    public static boolean a(String str) {
        return str.startsWith("http://tieba.baidu.com/group/index?id=") || str.startsWith("http://tieba.baidu.com/p/");
    }

    private static boolean a(Context context, String str, String str2) {
        if (str.startsWith("http://tieba.baidu.com/group/index?id=")) {
            int indexOf = str2.indexOf("http://tieba.baidu.com/group/index?id=") + 38;
            int lastIndexOf = str2.lastIndexOf(38);
            if (lastIndexOf == -1 || lastIndexOf < indexOf) {
                lastIndexOf = str2.length();
            }
            long a2 = com.baidu.adp.lib.f.b.a(str2.substring(indexOf, lastIndexOf), 0L);
            if (a2 <= 0) {
                return false;
            }
            GroupInfoActivity.a(context, a2, 0);
        } else if (str.startsWith("http://tieba.baidu.com/p/")) {
            String substring = str2.substring(str2.indexOf("http://tieba.baidu.com/p/") + 25);
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            NewPbActivity.a(context, substring, (String) null, "allthread");
        } else {
            UtilHelper.c(context, str2);
        }
        return true;
    }
}
