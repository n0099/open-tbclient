package com.baidu.tieba.pb.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class u {
    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && smallTailInfo.tailSpannable != null && smallTailInfo.tailSpannable.length() != 0 && textView != null) {
            a(smallTailInfo, textView);
            a(textView, z, z2, z3);
        }
    }

    private static void a(TextView textView, boolean z, boolean z2, boolean z3) {
        Drawable drawable;
        Resources resources = TbadkCoreApplication.m10getInst().getResources();
        float dimension = resources.getDimension(u.e.ds640) + resources.getDimension(u.e.ds16);
        float dimension2 = resources.getDimension(u.e.ds562);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (z2) {
            drawable = av.getDrawable(u.f.icon_pb_tail_long);
        } else if (z) {
            drawable = av.getDrawable(u.f.icon_pb_tail_sub);
        } else {
            drawable = av.getDrawable(u.f.icon_pb_tail_short);
            dimension = dimension2;
        }
        if (z2 && z3) {
            layoutParams.setMargins((int) resources.getDimension(u.e.ds32), (int) resources.getDimension(u.e.ds8), (int) resources.getDimension(u.e.ds32), (int) resources.getDimension(u.e.ds20));
        } else if (z) {
            layoutParams.setMargins(0, (int) resources.getDimension(u.e.ds8), 0, 0);
        } else if (!z2) {
            layoutParams.setMargins(0, (int) resources.getDimension(u.e.ds8), (int) resources.getDimension(u.e.ds32), (int) resources.getDimension(u.e.ds20));
        } else {
            layoutParams.setMargins((int) resources.getDimension(u.e.ds32), (int) resources.getDimension(u.e.ds8), (int) resources.getDimension(u.e.ds32), (int) resources.getDimension(u.e.ds20));
        }
        layoutParams.width = (int) dimension;
        drawable.setBounds(0, 0, (int) dimension, (int) resources.getDimension(u.e.ds36));
        textView.setLayoutParams(layoutParams);
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setCompoundDrawablePadding((int) resources.getDimension(u.e.ds20));
    }

    private static void a(SmallTailInfo smallTailInfo, TextView textView) {
        textView.setText(smallTailInfo.tailSpannable);
        textView.setTextColor(smallTailInfo.showColorId);
        textView.setVisibility(0);
    }
}
