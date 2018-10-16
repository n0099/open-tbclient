package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class c {
    private static String fFH;

    public static SpannableStringBuilder aD(Context context, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        Drawable drawable = context.getResources().getDrawable(e.f.icon_nichenghuodong);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.append((CharSequence) "tag");
        spannableStringBuilder.setSpan(new p(drawable), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static String beD() {
        if (TextUtils.isEmpty(fFH)) {
            fFH = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nick_name_activity_link", "");
        }
        return fFH;
    }
}
