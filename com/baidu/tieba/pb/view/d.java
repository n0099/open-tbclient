package com.baidu.tieba.pb.view;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d {
    boolean chn;
    boolean cho;
    boolean chp;
    TextView mTextView;

    public d(TextView textView, boolean z, boolean z2, boolean z3) {
        this.chn = true;
        this.cho = false;
        this.chp = false;
        this.mTextView = textView;
        this.chn = z2;
        this.cho = z;
        this.chp = z3;
    }

    public void a(SmallTailInfo smallTailInfo) {
        if (smallTailInfo != null && smallTailInfo.content != null && smallTailInfo.content.size() != 0) {
            b(smallTailInfo);
            afE();
        }
    }

    private void afE() {
        Drawable drawable;
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        float dimension = resources.getDimension(i.d.ds16) + resources.getDimension(i.d.ds640);
        float dimension2 = resources.getDimension(i.d.ds594) - resources.getDimension(i.d.ds14);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.chn) {
            drawable = al.getDrawable(i.e.icon_pb_tail_long);
        } else {
            drawable = al.getDrawable(i.e.icon_pb_tail_short);
            dimension = dimension2;
        }
        if (this.chn && this.chp) {
            layoutParams.setMargins((int) resources.getDimension(i.d.ds32), (int) resources.getDimension(i.d.ds8), (int) resources.getDimension(i.d.ds32), (int) resources.getDimension(i.d.ds20));
        } else if (this.cho) {
            layoutParams.setMargins((int) resources.getDimension(i.d.ds80), -((int) resources.getDimension(i.d.ds8)), (int) resources.getDimension(i.d.ds2), (int) resources.getDimension(i.d.ds20));
        } else if (!this.chn) {
            layoutParams.setMargins((int) resources.getDimension(i.d.ds100), -((int) resources.getDimension(i.d.ds8)), (int) resources.getDimension(i.d.ds32), (int) resources.getDimension(i.d.ds20));
        } else {
            layoutParams.setMargins((int) resources.getDimension(i.d.ds32), -((int) resources.getDimension(i.d.ds18)), (int) resources.getDimension(i.d.ds32), (int) resources.getDimension(i.d.ds20));
        }
        layoutParams.width = (int) dimension;
        drawable.setBounds(0, 0, (int) dimension, (int) resources.getDimension(i.d.ds36));
        this.mTextView.setLayoutParams(layoutParams);
        this.mTextView.setCompoundDrawables(null, drawable, null, null);
        this.mTextView.setCompoundDrawablePadding((int) resources.getDimension(i.d.ds20));
    }

    private void b(SmallTailInfo smallTailInfo) {
        StringBuilder sb = new StringBuilder();
        for (SmallTailInfo.SmallTailInfoContent smallTailInfoContent : smallTailInfo.content) {
            if (smallTailInfoContent.type == 0) {
                if (smallTailInfoContent.text != null) {
                    sb.append(smallTailInfoContent.text);
                }
            } else if (smallTailInfoContent.type == 2 && !StringUtils.isNull(smallTailInfoContent.text)) {
                String eB = TbFaceManager.Cd().eB(smallTailInfoContent.text);
                if (!StringUtils.isNull(eB)) {
                    sb.append("#(" + eB + ")");
                }
            }
        }
        this.mTextView.setText(TbFaceManager.Cd().a(TbadkCoreApplication.m411getInst(), sb.toString(), null));
        try {
            this.mTextView.setTextColor(Color.parseColor(iP(smallTailInfo.color)));
        } catch (Exception e) {
            this.mTextView.setTextColor(Color.parseColor(iP(TbadkCoreApplication.m411getInst().getString(i.C0057i.tail_color_default))));
        }
        this.mTextView.setVisibility(0);
        this.mTextView.setOnClickListener(new e(this));
    }

    public static String iP(String str) {
        if (str == null) {
            return null;
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            return String.valueOf(TbadkCoreApplication.m411getInst().getString(i.C0057i.color_prefix)) + TbadkCoreApplication.m411getInst().getString(i.C0057i.tail_color_night) + str;
        }
        return String.valueOf(TbadkCoreApplication.m411getInst().getString(i.C0057i.color_prefix)) + str;
    }
}
