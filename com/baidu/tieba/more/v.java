package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class v implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BrowseSettingActivity f1426a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(BrowseSettingActivity browseSettingActivity) {
        this.f1426a = browseSettingActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.font_size_big /* 2131099846 */:
                TiebaApplication.f().g(1);
                return;
            case R.id.font_size_mid /* 2131099847 */:
                TiebaApplication.f().g(2);
                return;
            case R.id.font_size_small /* 2131099848 */:
                TiebaApplication.f().g(3);
                return;
            default:
                return;
        }
    }
}
