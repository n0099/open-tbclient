package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f2006a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, ac acVar) {
        this.b = dVar;
        this.f2006a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextVersionView settingTextVersionView;
        SettingTextTipView settingTextTipView;
        settingTextVersionView = this.b.i;
        if (view != settingTextVersionView) {
            settingTextTipView = this.b.j;
            if (view == settingTextTipView) {
                this.f2006a.a(2);
                return;
            }
            return;
        }
        this.f2006a.a(1);
    }
}
