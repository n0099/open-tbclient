package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ah f2071a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.f2071a = ahVar;
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
        imageView = this.f2071a.o;
        if (view == imageView) {
            acVar9 = this.f2071a.c;
            acVar9.a(0);
            return;
        }
        settingTextImageView = this.f2071a.f;
        if (view == settingTextImageView) {
            acVar8 = this.f2071a.c;
            acVar8.a(1);
            return;
        }
        settingTextTipView = this.f2071a.g;
        if (view == settingTextTipView) {
            acVar7 = this.f2071a.c;
            acVar7.a(2);
            return;
        }
        settingTextTipView2 = this.f2071a.h;
        if (view == settingTextTipView2) {
            acVar6 = this.f2071a.c;
            acVar6.a(3);
            return;
        }
        settingTextTipView3 = this.f2071a.i;
        if (view == settingTextTipView3) {
            acVar5 = this.f2071a.c;
            acVar5.a(4);
            return;
        }
        settingTextVersionView = this.f2071a.j;
        if (view == settingTextVersionView) {
            acVar4 = this.f2071a.c;
            acVar4.a(6);
            return;
        }
        settingTextTipView4 = this.f2071a.k;
        if (view == settingTextTipView4) {
            acVar3 = this.f2071a.c;
            acVar3.a(7);
            return;
        }
        settingTextTipView5 = this.f2071a.l;
        if (view == settingTextTipView5) {
            acVar2 = this.f2071a.c;
            acVar2.a(8);
            return;
        }
        settingTextTipView6 = this.f2071a.m;
        if (view == settingTextTipView6) {
            acVar = this.f2071a.c;
            acVar.a(5);
        }
    }
}
