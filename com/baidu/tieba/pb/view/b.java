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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b {
    private static SparseIntArray hGq = new SparseIntArray();

    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && smallTailInfo.tailSpannable != null && smallTailInfo.tailSpannable.length() != 0 && textView != null) {
            smallTailInfo.updateShowInfo();
            b(smallTailInfo, textView, z, z2, z3);
        }
    }

    private static void b(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && textView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            int wO = wO(d.e.ds32);
            if (z2 && z3) {
                layoutParams.setMargins(wO, wO(d.e.ds8), wO, wO(d.e.ds18));
            } else if (z) {
                layoutParams.setMargins(0, wO(d.e.ds8), 0, 0);
            } else if (!z2) {
                layoutParams.setMargins(wO(d.e.ds120), wO(d.e.ds8), wO(d.e.ds34), wO(d.e.ds14));
            } else {
                layoutParams.setMargins(wO, wO(d.e.ds8), wO, wO(d.e.ds14));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "icon");
            spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
            Drawable drawable = al.getDrawable(d.f.icon_pb_tail);
            drawable.setBounds(0, 0, wO, wO);
            com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(drawable);
            cVar.ki(wO(d.e.ds4));
            spannableStringBuilder.setSpan(cVar, 0, 4, 33);
            textView.setLayoutParams(layoutParams);
            textView.setText(spannableStringBuilder);
            textView.setTextColor(smallTailInfo.showColorId);
            textView.setVisibility(0);
        }
    }

    private static int wO(int i) {
        int i2 = hGq.get(i, -1);
        if (i2 == -1) {
            int h = l.h(TbadkCoreApplication.getInst().getContext(), i);
            hGq.put(i, h);
            return h;
        }
        return i2;
    }
}
