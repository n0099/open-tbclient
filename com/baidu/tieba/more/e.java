package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1489a;
    private final /* synthetic */ aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, aa aaVar) {
        this.f1489a = dVar;
        this.b = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextVersionView settingTextVersionView;
        SettingTextTipView settingTextTipView;
        settingTextVersionView = this.f1489a.i;
        if (view == settingTextVersionView) {
            this.b.a(1);
            return;
        }
        settingTextTipView = this.f1489a.j;
        if (view == settingTextTipView) {
            this.b.a(2);
        }
    }
}
