package com.baidu.tieba.memberCenter.tail.a;

import android.graphics.Color;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c {
    public static String getShowColorText(String str) {
        if (str == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return TbadkCoreApplication.getInst().getString(R.string.color_prefix) + TbadkCoreApplication.getInst().getString(R.string.tail_color_night) + str;
        }
        return TbadkCoreApplication.getInst().getString(R.string.color_prefix) + str;
    }

    public static int Op(String str) {
        try {
            return Color.parseColor(getShowColorText(str));
        } catch (Exception e) {
            return 0;
        }
    }
}
