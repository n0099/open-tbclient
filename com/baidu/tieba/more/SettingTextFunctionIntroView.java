package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public class SettingTextFunctionIntroView extends TbSettingTextTipView {
    public static String bsB = "has_shown_funtion_intro";

    public SettingTextFunctionIntroView(Context context) {
        super(context);
    }

    public SettingTextFunctionIntroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void refresh() {
        TbadkApplication.m251getInst().getSkinType();
        VersionData wI = com.baidu.tieba.aj.wk().wI();
        boolean z = wI != null && wI.hasNewVer();
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean(bsB, false);
        if (!z && !z2) {
            com.baidu.tbadk.core.util.aw.h((View) this.Pe, com.baidu.tieba.u.icon_news_head_new);
        } else {
            qk();
        }
    }
}
