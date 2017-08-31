package com.baidu.tieba.pb.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g {
    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && smallTailInfo.tailSpannable != null && smallTailInfo.tailSpannable.length() != 0 && textView != null) {
            smallTailInfo.updateShowInfo();
            b(smallTailInfo, textView, z, z2, z3);
        }
    }

    private static void b(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && textView != null) {
            Resources resources = TbadkCoreApplication.getInst().getResources();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            if (z2 && z3) {
                layoutParams.setMargins((int) resources.getDimension(d.f.ds32), (int) resources.getDimension(d.f.ds8), (int) resources.getDimension(d.f.ds32), (int) resources.getDimension(d.f.ds18));
            } else if (z) {
                layoutParams.setMargins(0, (int) resources.getDimension(d.f.ds8), 0, 0);
            } else if (!z2) {
                layoutParams.setMargins((int) resources.getDimension(d.f.ds120), (int) resources.getDimension(d.f.ds8), (int) resources.getDimension(d.f.ds34), (int) resources.getDimension(d.f.ds14));
            } else {
                layoutParams.setMargins((int) resources.getDimension(d.f.ds32), (int) resources.getDimension(d.f.ds8), (int) resources.getDimension(d.f.ds32), (int) resources.getDimension(d.f.ds14));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "icon");
            spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
            Drawable drawable = aj.getDrawable(d.g.icon_pb_tail);
            int g = k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds32);
            drawable.setBounds(0, 0, g, g);
            com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(drawable);
            cVar.fr(k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds4));
            spannableStringBuilder.setSpan(cVar, 0, 4, 33);
            textView.setLayoutParams(layoutParams);
            textView.setText(spannableStringBuilder);
            textView.setTextColor(smallTailInfo.showColorId);
            textView.setVisibility(0);
        }
    }
}
