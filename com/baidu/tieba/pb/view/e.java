package com.baidu.tieba.pb.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e {
    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && smallTailInfo.tailSpannable != null && smallTailInfo.tailSpannable.length() != 0 && textView != null) {
            a(smallTailInfo, textView);
            a(textView, z, z2, z3);
        }
    }

    private static void a(TextView textView, boolean z, boolean z2, boolean z3) {
        Drawable drawable;
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        float dimension = resources.getDimension(n.d.ds640) + resources.getDimension(n.d.ds16);
        float dimension2 = resources.getDimension(n.d.ds594) - resources.getDimension(n.d.ds14);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (z2) {
            drawable = as.getDrawable(n.e.icon_pb_tail_long);
        } else {
            drawable = as.getDrawable(n.e.icon_pb_tail_short);
            dimension = dimension2;
        }
        if (z2 && z3) {
            layoutParams.setMargins((int) resources.getDimension(n.d.ds32), (int) resources.getDimension(n.d.ds8), (int) resources.getDimension(n.d.ds32), (int) resources.getDimension(n.d.ds20));
        } else if (z) {
            layoutParams.setMargins((int) resources.getDimension(n.d.ds80), -((int) resources.getDimension(n.d.ds8)), (int) resources.getDimension(n.d.ds2), (int) resources.getDimension(n.d.ds20));
        } else if (!z2) {
            layoutParams.setMargins((int) resources.getDimension(n.d.ds100), -((int) resources.getDimension(n.d.ds8)), (int) resources.getDimension(n.d.ds32), (int) resources.getDimension(n.d.ds20));
        } else {
            layoutParams.setMargins((int) resources.getDimension(n.d.ds32), -((int) resources.getDimension(n.d.ds18)), (int) resources.getDimension(n.d.ds32), (int) resources.getDimension(n.d.ds20));
        }
        layoutParams.width = (int) dimension;
        drawable.setBounds(0, 0, (int) dimension, (int) resources.getDimension(n.d.ds36));
        textView.setLayoutParams(layoutParams);
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setCompoundDrawablePadding((int) resources.getDimension(n.d.ds20));
    }

    private static void a(SmallTailInfo smallTailInfo, TextView textView) {
        textView.setText(smallTailInfo.tailSpannable);
        textView.setTextColor(smallTailInfo.showColorId);
        textView.setVisibility(0);
    }
}
