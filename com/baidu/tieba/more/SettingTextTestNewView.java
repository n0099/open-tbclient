package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class SettingTextTestNewView extends SettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        String u;
        boolean z = false;
        boolean z2 = TiebaApplication.g().ae() == 1;
        VersionData al = TiebaApplication.g().al();
        if (al != null && al.getHas_new_ver() == 1) {
            z = true;
        }
        if (z) {
            this.e.setText("New");
            this.e.setTextAppearance(this.b, z2 ? R.style.setting_version_prompt_text_1 : R.style.setting_version_prompt_text);
            this.e.setBackgroundResource(z2 ? R.drawable.icon_news_text_prompt_1 : R.drawable.icon_news_text_prompt);
            return;
        }
        this.e.setText((com.baidu.tieba.data.i.w() != 1 || bs.c(com.baidu.tieba.data.i.v())) ? com.baidu.tieba.data.i.u() : String.valueOf(u) + "." + com.baidu.tieba.data.i.v());
        this.e.setBackgroundDrawable(null);
        this.e.setTextAppearance(this.b, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
