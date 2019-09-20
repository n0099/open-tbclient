package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.sapi2.result.AddressManageResult;
import com.baidu.tbadk.core.view.n;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private static String hIj;

    public static SpannableStringBuilder aL(Context context, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        Drawable drawable = context.getResources().getDrawable(R.drawable.icon_nichenghuodong);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.append((CharSequence) AddressManageResult.KEY_TAG);
        spannableStringBuilder.setSpan(new n(drawable), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static String bTh() {
        if (TextUtils.isEmpty(hIj)) {
            hIj = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nick_name_activity_link", "");
        }
        return hIj;
    }
}
