package com.baidu.tieba.pb.view;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    private static SparseIntArray hYb = new SparseIntArray();

    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && smallTailInfo.tailSpannable != null && smallTailInfo.tailSpannable.length() != 0 && textView != null) {
            smallTailInfo.updateShowInfo();
            b(smallTailInfo, textView, z, z2, z3);
        }
    }

    private static void b(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && textView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            int xQ = xQ(R.dimen.ds32);
            if (z2 && z3) {
                layoutParams.setMargins(xQ, xQ(R.dimen.ds8), xQ, xQ(R.dimen.ds18));
            } else if (z) {
                layoutParams.setMargins(0, xQ(R.dimen.ds8), 0, 0);
            } else if (!z2) {
                layoutParams.setMargins(xQ(R.dimen.ds120), xQ(R.dimen.ds8), xQ(R.dimen.ds34), xQ(R.dimen.ds14));
            } else {
                layoutParams.setMargins(xQ, xQ(R.dimen.ds8), xQ, xQ(R.dimen.ds14));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "icon");
            spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
            Drawable drawable = al.getDrawable(R.drawable.icon_pb_tail);
            drawable.setBounds(0, 0, xQ, xQ);
            com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(drawable);
            cVar.kW(xQ(R.dimen.ds4));
            spannableStringBuilder.setSpan(cVar, 0, 4, 33);
            textView.setLayoutParams(layoutParams);
            textView.setText(spannableStringBuilder);
            textView.setTextColor(smallTailInfo.showColorId);
            textView.setVisibility(0);
        }
    }

    private static int xQ(int i) {
        int i2 = hYb.get(i, -1);
        if (i2 == -1) {
            int g = l.g(TbadkCoreApplication.getInst().getContext(), i);
            hYb.put(i, g);
            return g;
        }
        return i2;
    }
}
