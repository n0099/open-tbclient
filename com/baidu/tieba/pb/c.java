package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.tbadk.core.view.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private static String jBW;

    public static SpannableStringBuilder aK(Context context, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        Drawable drawable = context.getResources().getDrawable(R.drawable.icon_nichenghuodong);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.append((CharSequence) "tag");
        spannableStringBuilder.setSpan(new l(drawable), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static String cBR() {
        if (TextUtils.isEmpty(jBW)) {
            jBW = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nick_name_activity_link", "");
        }
        return jBW;
    }
}
