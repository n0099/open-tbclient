package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class u implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ BrowseSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(BrowseSettingActivity browseSettingActivity) {
        this.a = browseSettingActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.font_size_big /* 2131099841 */:
                TiebaApplication.f().i(1);
                return;
            case R.id.font_size_mid /* 2131099842 */:
                TiebaApplication.f().i(2);
                return;
            case R.id.font_size_small /* 2131099843 */:
                TiebaApplication.f().i(3);
                return;
            default:
                return;
        }
    }
}
