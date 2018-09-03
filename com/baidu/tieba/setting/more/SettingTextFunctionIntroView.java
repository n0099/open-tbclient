package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class SettingTextFunctionIntroView extends TbSettingTextTipView {
    public static String gBp = "has_shown_funtion_intro";

    public SettingTextFunctionIntroView(Context context) {
        super(context);
        hideArrow();
        f(0, 0, l.f(context, f.e.ds30), 0);
    }

    public SettingTextFunctionIntroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        f(0, 0, l.f(context, f.e.ds30), 0);
    }
}
