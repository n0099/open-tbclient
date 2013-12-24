package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ ah a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.a = ahVar;
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
        ac acVar;
        ac acVar2;
        ac acVar3;
        ac acVar4;
        ac acVar5;
        ac acVar6;
        ac acVar7;
        ac acVar8;
        ac acVar9;
        ac acVar10;
        imageView = this.a.p;
        if (view == imageView) {
            acVar10 = this.a.c;
            acVar10.a(0);
            return;
        }
        settingTextImageView = this.a.f;
        if (view == settingTextImageView) {
            acVar9 = this.a.c;
            acVar9.a(1);
            return;
        }
        settingTextTipView = this.a.g;
        if (view == settingTextTipView) {
            acVar8 = this.a.c;
            acVar8.a(2);
            return;
        }
        settingTextTipView2 = this.a.h;
        if (view == settingTextTipView2) {
            acVar7 = this.a.c;
            acVar7.a(3);
            return;
        }
        settingTextTipView3 = this.a.i;
        if (view == settingTextTipView3) {
            acVar6 = this.a.c;
            acVar6.a(4);
            return;
        }
        settingTextTipView4 = this.a.j;
        if (view == settingTextTipView4) {
            acVar5 = this.a.c;
            acVar5.a(9);
            return;
        }
        settingTextVersionView = this.a.k;
        if (view == settingTextVersionView) {
            acVar4 = this.a.c;
            acVar4.a(6);
            return;
        }
        settingTextTipView5 = this.a.l;
        if (view == settingTextTipView5) {
            acVar3 = this.a.c;
            acVar3.a(7);
            return;
        }
        settingTextTipView6 = this.a.m;
        if (view == settingTextTipView6) {
            acVar2 = this.a.c;
            acVar2.a(8);
            return;
        }
        settingTextTipView7 = this.a.n;
        if (view == settingTextTipView7) {
            acVar = this.a.c;
            acVar.a(5);
        }
    }
}
