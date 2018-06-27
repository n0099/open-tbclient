package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.tbadk.core.view.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    private static String fqr;

    public static SpannableStringBuilder aj(Context context, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        Drawable drawable = context.getResources().getDrawable(d.f.icon_nichenghuodong);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.append((CharSequence) "tag");
        spannableStringBuilder.setSpan(new m(drawable), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static String baD() {
        if (TextUtils.isEmpty(fqr)) {
            fqr = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nick_name_activity_link", "");
        }
        return fqr;
    }
}
