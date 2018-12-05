package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class SettingTextFunctionIntroView extends TbSettingTextTipView {
    public static String gYq = "has_shown_funtion_intro";

    public SettingTextFunctionIntroView(Context context) {
        super(context);
        hideArrow();
        g(0, 0, l.h(context, e.C0210e.ds30), 0);
    }

    public SettingTextFunctionIntroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        g(0, 0, l.h(context, e.C0210e.ds30), 0);
    }
}
