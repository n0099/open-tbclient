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
        boolean z = false;
        boolean z2 = TiebaApplication.g().as() == 1;
        VersionData ax = TiebaApplication.g().ax();
        if (ax != null && ax.getHas_new_ver() == 1) {
            z = true;
        }
        if (z) {
            this.d.setText("New");
            this.d.setTextAppearance(this.f1973a, z2 ? R.style.setting_version_prompt_text_1 : R.style.setting_version_prompt_text);
            this.d.setBackgroundResource(z2 ? R.drawable.icon_news_text_prompt_1 : R.drawable.icon_news_text_prompt);
            return;
        }
        this.d.setText(com.baidu.tieba.data.h.j());
        this.d.setBackgroundDrawable(null);
        this.d.setTextAppearance(this.f1973a, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
