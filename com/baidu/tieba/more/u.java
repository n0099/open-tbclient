package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class u implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BrowseSettingActivity f1427a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(BrowseSettingActivity browseSettingActivity) {
        this.f1427a = browseSettingActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.image_quality_high /* 2131099841 */:
                TiebaApplication.f().r(true);
                TiebaApplication.f().f(1);
                return;
            case R.id.image_quality_low /* 2131099842 */:
                TiebaApplication.f().r(true);
                TiebaApplication.f().f(2);
                return;
            case R.id.image_quality_close /* 2131099843 */:
                TiebaApplication.f().r(false);
                return;
            default:
                return;
        }
    }
}
