package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class SettingTextFunctionIntroView extends TbSettingTextTipView {
    public static String kXE = "has_shown_funtion_intro";

    public SettingTextFunctionIntroView(Context context) {
        super(context);
        hideArrow();
        t(0, 0, l.getDimens(context, R.dimen.ds30), 0);
    }

    public SettingTextFunctionIntroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        t(0, 0, l.getDimens(context, R.dimen.ds30), 0);
    }
}
