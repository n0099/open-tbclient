package com.baidu.tieba.more;

import com.baidu.tieba.CommonWebviewActivity;
import com.baidu.tieba.GuideActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AboutActivity f1968a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.f1968a = aboutActivity;
    }

    @Override // com.baidu.tieba.more.ac
    public void a(int i) {
        String str;
        if (i == 0) {
            this.f1968a.finish();
        } else if (i == 1) {
            this.f1968a.a();
        } else if (i == 2) {
            GuideActivity.a(this.f1968a, 0, GuideActivity.b);
        } else if (i == 3) {
            com.baidu.tieba.sharedPref.b.a().b(SettingTextFunctionIntroView.f1962a, true);
            AboutActivity aboutActivity = this.f1968a;
            String string = this.f1968a.getString(R.string.setting_funtion_intro);
            str = this.f1968a.d;
            CommonWebviewActivity.a(aboutActivity, string, str, true);
        }
    }
}
