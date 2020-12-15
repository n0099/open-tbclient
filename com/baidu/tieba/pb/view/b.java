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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    private static SparseIntArray mfh = new SparseIntArray();

    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && smallTailInfo.tailSpannable != null && smallTailInfo.tailSpannable.length() != 0 && textView != null) {
            smallTailInfo.updateShowInfo();
            b(smallTailInfo, textView, z, z2, z3);
        }
    }

    private static void b(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && textView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            int HV = HV(R.dimen.ds32);
            if (z2 && z3) {
                layoutParams.setMargins(HV, HV(R.dimen.ds8), HV, HV(R.dimen.ds18));
            } else if (z) {
                layoutParams.setMargins(0, HV(R.dimen.ds8), 0, 0);
            } else if (!z2) {
                layoutParams.setMargins(HV(R.dimen.ds102), HV(R.dimen.ds8), HV(R.dimen.ds34), HV(R.dimen.ds14));
            } else {
                layoutParams.setMargins(HV, HV(R.dimen.ds8), HV, HV(R.dimen.ds14));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
            Drawable drawable = ap.getDrawable(R.drawable.icon_pb_tail);
            drawable.setBounds(0, 0, HV, HV);
            com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(drawable);
            dVar.setPaddingRight(HV(R.dimen.ds4));
            spannableStringBuilder.setSpan(dVar, 0, 4, 33);
            textView.setLayoutParams(layoutParams);
            textView.setText(spannableStringBuilder);
            textView.setTextColor(smallTailInfo.showColorId);
            textView.setVisibility(0);
        }
    }

    private static int HV(int i) {
        int i2 = mfh.get(i, -1);
        if (i2 == -1) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
            mfh.put(i, dimens);
            return dimens;
        }
        return i2;
    }
}
