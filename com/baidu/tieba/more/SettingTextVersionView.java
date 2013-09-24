package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.VersionData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class SettingTextVersionView extends SettingTextTipView {
    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void d() {
        boolean z = true;
        boolean z2 = TiebaApplication.g().ap() == 1;
        VersionData au = TiebaApplication.g().au();
        if (au == null || au.getHas_new_ver() != 1) {
            z = false;
        }
        if (z) {
            this.d.setText("New");
            this.d.setTextAppearance(this.f1471a, z2 ? R.style.setting_version_prompt_text_1 : R.style.setting_version_prompt_text);
            this.d.setBackgroundResource(z2 ? R.drawable.icon_news_text_prompt_1 : R.drawable.icon_news_text_prompt);
            return;
        }
        this.d.setText(com.baidu.tieba.data.g.j());
        this.d.setBackgroundDrawable(null);
        this.d.setTextAppearance(this.f1471a, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
