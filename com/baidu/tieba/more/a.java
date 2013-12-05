package com.baidu.tieba.more;

import com.baidu.tieba.CommonWebviewActivity;
import com.baidu.tieba.GuideActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AboutActivity f2062a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.f2062a = aboutActivity;
    }

    @Override // com.baidu.tieba.more.ac
    public void a(int i) {
        String str;
        if (i == 0) {
            this.f2062a.finish();
        } else if (i == 1) {
            this.f2062a.a();
        } else if (i == 2) {
            GuideActivity.a(this.f2062a, 0, GuideActivity.b);
        } else if (i == 3) {
            com.baidu.tieba.sharedPref.b.a().b(SettingTextFunctionIntroView.f2057a, true);
            AboutActivity aboutActivity = this.f2062a;
            String string = this.f2062a.getString(R.string.setting_funtion_intro);
            str = this.f2062a.d;
            CommonWebviewActivity.a(aboutActivity, string, str, true);
        }
    }
}
