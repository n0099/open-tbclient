package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class v implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BrowseSettingActivity f1463a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(BrowseSettingActivity browseSettingActivity) {
        this.f1463a = browseSettingActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.font_size_big /* 2131099855 */:
                TiebaApplication.g().f(1);
                return;
            case R.id.font_size_mid /* 2131099856 */:
                TiebaApplication.g().f(2);
                return;
            case R.id.font_size_small /* 2131099857 */:
                TiebaApplication.g().f(3);
                return;
            default:
                return;
        }
    }
}
