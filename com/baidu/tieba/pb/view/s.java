package com.baidu.tieba.pb.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.f;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s {
    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && smallTailInfo.tailSpannable != null && smallTailInfo.tailSpannable.length() != 0 && textView != null) {
            b(smallTailInfo, textView, z, z2, z3);
        }
    }

    private static void b(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && textView != null) {
            Resources resources = TbadkCoreApplication.m9getInst().getResources();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            if (z2 && z3) {
                layoutParams.setMargins((int) resources.getDimension(r.e.ds32), (int) resources.getDimension(r.e.ds8), (int) resources.getDimension(r.e.ds32), (int) resources.getDimension(r.e.ds18));
            } else if (z) {
                layoutParams.setMargins(0, (int) resources.getDimension(r.e.ds8), 0, 0);
            } else if (!z2) {
                layoutParams.setMargins(0, (int) resources.getDimension(r.e.ds8), (int) resources.getDimension(r.e.ds32), (int) resources.getDimension(r.e.ds14));
            } else {
                layoutParams.setMargins((int) resources.getDimension(r.e.ds32), (int) resources.getDimension(r.e.ds8), (int) resources.getDimension(r.e.ds32), (int) resources.getDimension(r.e.ds14));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "icon");
            spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
            Drawable drawable = at.getDrawable(r.f.icon_pb_tail);
            int e = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds32);
            drawable.setBounds(0, 0, e, e);
            f fVar = new f(drawable);
            fVar.fq(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds4));
            spannableStringBuilder.setSpan(fVar, 0, 4, 33);
            textView.setLayoutParams(layoutParams);
            textView.setText(spannableStringBuilder);
            textView.setTextColor(smallTailInfo.showColorId);
            textView.setVisibility(0);
        }
    }
}
