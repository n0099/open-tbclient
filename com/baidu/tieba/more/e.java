package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {
    final /* synthetic */ d a;
    private final /* synthetic */ ab b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, ab abVar) {
        this.a = dVar;
        this.b = abVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        SettingTextTipView settingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        settingTextTestNewView = this.a.h;
        if (view == settingTextTestNewView) {
            this.b.a(1);
            return;
        }
        settingTextTipView = this.a.i;
        if (view == settingTextTipView) {
            this.b.a(2);
            return;
        }
        settingTextFunctionIntroView = this.a.j;
        if (view == settingTextFunctionIntroView) {
            this.b.a(3);
        }
    }
}
