package com.baidu.tieba.pb.view;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class c {
    private static SparseIntArray gqd = new SparseIntArray();

    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && smallTailInfo.tailSpannable != null && smallTailInfo.tailSpannable.length() != 0 && textView != null) {
            smallTailInfo.updateShowInfo();
            b(smallTailInfo, textView, z, z2, z3);
        }
    }

    private static void b(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        if (smallTailInfo != null && textView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            int te = te(e.C0210e.ds32);
            if (z2 && z3) {
                layoutParams.setMargins(te, te(e.C0210e.ds8), te, te(e.C0210e.ds18));
            } else if (z) {
                layoutParams.setMargins(0, te(e.C0210e.ds8), 0, 0);
            } else if (!z2) {
                layoutParams.setMargins(te(e.C0210e.ds120), te(e.C0210e.ds8), te(e.C0210e.ds34), te(e.C0210e.ds14));
            } else {
                layoutParams.setMargins(te, te(e.C0210e.ds8), te, te(e.C0210e.ds14));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY);
            spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
            Drawable drawable = al.getDrawable(e.f.icon_pb_tail);
            drawable.setBounds(0, 0, te, te);
            com.baidu.tbadk.widget.c cVar = new com.baidu.tbadk.widget.c(drawable);
            cVar.gu(te(e.C0210e.ds4));
            spannableStringBuilder.setSpan(cVar, 0, 4, 33);
            textView.setLayoutParams(layoutParams);
            textView.setText(spannableStringBuilder);
            textView.setTextColor(smallTailInfo.showColorId);
            textView.setVisibility(0);
        }
    }

    private static int te(int i) {
        int i2 = gqd.get(i, -1);
        if (i2 == -1) {
            int h = l.h(TbadkCoreApplication.getInst().getContext(), i);
            gqd.put(i, h);
            return h;
        }
        return i2;
    }
}
