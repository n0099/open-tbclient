package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f1981a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, ac acVar) {
        this.b = dVar;
        this.f1981a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        SettingTextTipView settingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        settingTextTestNewView = this.b.h;
        if (view != settingTextTestNewView) {
            settingTextTipView = this.b.i;
            if (view != settingTextTipView) {
                settingTextFunctionIntroView = this.b.j;
                if (view == settingTextFunctionIntroView) {
                    this.f1981a.a(3);
                    return;
                }
                return;
            }
            this.f1981a.a(2);
            return;
        }
        this.f1981a.a(1);
    }
}
