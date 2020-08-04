package com.baidu.tieba.pb.view;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b {
    private static SparseIntArray kKo = new SparseIntArray();

    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && smallTailInfo.tailSpannable != null && smallTailInfo.tailSpannable.length() != 0 && textView != null) {
            smallTailInfo.updateShowInfo();
            b(smallTailInfo, textView, z, z2, z3);
        }
    }

    private static void b(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && textView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            int CA = CA(R.dimen.ds32);
            if (z2 && z3) {
                layoutParams.setMargins(CA, CA(R.dimen.ds8), CA, CA(R.dimen.ds18));
            } else if (z) {
                layoutParams.setMargins(0, CA(R.dimen.ds8), 0, 0);
            } else if (!z2) {
                layoutParams.setMargins(CA(R.dimen.ds120), CA(R.dimen.ds8), CA(R.dimen.ds34), CA(R.dimen.ds14));
            } else {
                layoutParams.setMargins(CA, CA(R.dimen.ds8), CA, CA(R.dimen.ds14));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
            Drawable drawable = ao.getDrawable(R.drawable.icon_pb_tail);
            drawable.setBounds(0, 0, CA, CA);
            com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(drawable);
            dVar.setPaddingRight(CA(R.dimen.ds4));
            spannableStringBuilder.setSpan(dVar, 0, 4, 33);
            textView.setLayoutParams(layoutParams);
            textView.setText(spannableStringBuilder);
            textView.setTextColor(smallTailInfo.showColorId);
            textView.setVisibility(0);
        }
    }

    private static int CA(int i) {
        int i2 = kKo.get(i, -1);
        if (i2 == -1) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
            kKo.put(i, dimens);
            return dimens;
        }
        return i2;
    }
}
