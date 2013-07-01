package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class t implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BrowseSettingActivity f1108a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(BrowseSettingActivity browseSettingActivity) {
        this.f1108a = browseSettingActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.image_quality_high /* 2131099836 */:
                TiebaApplication.f().q(true);
                TiebaApplication.f().h(1);
                return;
            case R.id.image_quality_low /* 2131099837 */:
                TiebaApplication.f().q(true);
                TiebaApplication.f().h(2);
                return;
            case R.id.image_quality_close /* 2131099838 */:
                TiebaApplication.f().q(false);
                return;
            default:
                return;
        }
    }
}
