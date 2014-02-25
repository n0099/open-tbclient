package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.a = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        SettingTextImageView settingTextImageView;
        SettingTextTipView settingTextTipView;
        SettingTextTipView settingTextTipView2;
        SettingTextTipView settingTextTipView3;
        SettingTextTipView settingTextTipView4;
        SettingTextVersionView settingTextVersionView;
        SettingTextTipView settingTextTipView5;
        SettingTextTipView settingTextTipView6;
        SettingTextTipView settingTextTipView7;
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        ab abVar5;
        ab abVar6;
        ab abVar7;
        ab abVar8;
        ab abVar9;
        ab abVar10;
        imageView = this.a.q;
        if (view == imageView) {
            abVar10 = this.a.c;
            abVar10.a(0);
            return;
        }
        settingTextImageView = this.a.f;
        if (view == settingTextImageView) {
            abVar9 = this.a.c;
            abVar9.a(1);
            return;
        }
        settingTextTipView = this.a.g;
        if (view == settingTextTipView) {
            abVar8 = this.a.c;
            abVar8.a(2);
            return;
        }
        settingTextTipView2 = this.a.h;
        if (view == settingTextTipView2) {
            abVar7 = this.a.c;
            abVar7.a(3);
            return;
        }
        settingTextTipView3 = this.a.i;
        if (view == settingTextTipView3) {
            abVar6 = this.a.c;
            abVar6.a(4);
            return;
        }
        settingTextTipView4 = this.a.j;
        if (view == settingTextTipView4) {
            abVar5 = this.a.c;
            abVar5.a(9);
            return;
        }
        settingTextVersionView = this.a.k;
        if (view == settingTextVersionView) {
            abVar4 = this.a.c;
            abVar4.a(6);
            return;
        }
        settingTextTipView5 = this.a.l;
        if (view == settingTextTipView5) {
            abVar3 = this.a.c;
            abVar3.a(7);
            return;
        }
        settingTextTipView6 = this.a.m;
        if (view == settingTextTipView6) {
            abVar2 = this.a.c;
            abVar2.a(8);
            return;
        }
        settingTextTipView7 = this.a.o;
        if (view == settingTextTipView7) {
            abVar = this.a.c;
            abVar.a(5);
        }
    }
}
