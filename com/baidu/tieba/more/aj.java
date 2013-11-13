package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ah f1977a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.f1977a = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        SettingTextImageView settingTextImageView;
        SettingTextTipView settingTextTipView;
        SettingTextTipView settingTextTipView2;
        SettingTextTipView settingTextTipView3;
        SettingTextVersionView settingTextVersionView;
        SettingTextTipView settingTextTipView4;
        SettingTextTipView settingTextTipView5;
        SettingTextTipView settingTextTipView6;
        ac acVar;
        ac acVar2;
        ac acVar3;
        ac acVar4;
        ac acVar5;
        ac acVar6;
        ac acVar7;
        ac acVar8;
        ac acVar9;
        imageView = this.f1977a.o;
        if (view == imageView) {
            acVar9 = this.f1977a.c;
            acVar9.a(0);
            return;
        }
        settingTextImageView = this.f1977a.f;
        if (view == settingTextImageView) {
            acVar8 = this.f1977a.c;
            acVar8.a(1);
            return;
        }
        settingTextTipView = this.f1977a.g;
        if (view == settingTextTipView) {
            acVar7 = this.f1977a.c;
            acVar7.a(2);
            return;
        }
        settingTextTipView2 = this.f1977a.h;
        if (view == settingTextTipView2) {
            acVar6 = this.f1977a.c;
            acVar6.a(3);
            return;
        }
        settingTextTipView3 = this.f1977a.i;
        if (view == settingTextTipView3) {
            acVar5 = this.f1977a.c;
            acVar5.a(4);
            return;
        }
        settingTextVersionView = this.f1977a.j;
        if (view == settingTextVersionView) {
            acVar4 = this.f1977a.c;
            acVar4.a(6);
            return;
        }
        settingTextTipView4 = this.f1977a.k;
        if (view == settingTextTipView4) {
            acVar3 = this.f1977a.c;
            acVar3.a(7);
            return;
        }
        settingTextTipView5 = this.f1977a.l;
        if (view == settingTextTipView5) {
            acVar2 = this.f1977a.c;
            acVar2.a(8);
            return;
        }
        settingTextTipView6 = this.f1977a.m;
        if (view == settingTextTipView6) {
            acVar = this.f1977a.c;
            acVar.a(5);
        }
    }
}
