package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class SettingTextFunctionIntroView extends TbSettingTextTipView {
    public static String m = "has_shown_funtion_intro";

    public SettingTextFunctionIntroView(Context context) {
        super(context);
        c();
        h(0, 0, l.g(context, R.dimen.ds30), 0);
    }

    public SettingTextFunctionIntroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        h(0, 0, l.g(context, R.dimen.ds30), 0);
    }
}
