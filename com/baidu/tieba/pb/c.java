package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.tbadk.core.view.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private static String llj;

    public static SpannableStringBuilder aR(Context context, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        Drawable drawable = context.getResources().getDrawable(R.drawable.icon_nichenghuodong);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.append((CharSequence) "tag");
        spannableStringBuilder.setSpan(new l(drawable), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static String dhr() {
        if (TextUtils.isEmpty(llj)) {
            llj = com.baidu.tbadk.core.sharedPref.b.bpu().getString("nick_name_activity_link", "");
        }
        return llj;
    }
}
