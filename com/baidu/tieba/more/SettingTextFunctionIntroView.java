package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public class SettingTextFunctionIntroView extends TbSettingTextTipView {
    public static String bsP = "has_shown_funtion_intro";

    public SettingTextFunctionIntroView(Context context) {
        super(context);
    }

    public SettingTextFunctionIntroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void refresh() {
        TbadkApplication.m251getInst().getSkinType();
        VersionData wK = com.baidu.tieba.aj.wm().wK();
        boolean z = wK != null && wK.hasNewVer();
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean(bsP, false);
        if (!z && !z2) {
            com.baidu.tbadk.core.util.aw.h((View) this.Pi, com.baidu.tieba.u.icon_news_head_new);
        } else {
            qm();
        }
    }
}
