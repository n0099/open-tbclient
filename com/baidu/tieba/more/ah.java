package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ af f1479a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.f1479a = afVar;
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
        TextView textView;
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        aa aaVar4;
        aa aaVar5;
        aa aaVar6;
        aa aaVar7;
        aa aaVar8;
        aa aaVar9;
        imageView = this.f1479a.o;
        if (view == imageView) {
            aaVar9 = this.f1479a.c;
            aaVar9.a(0);
            return;
        }
        settingTextImageView = this.f1479a.f;
        if (view == settingTextImageView) {
            aaVar8 = this.f1479a.c;
            aaVar8.a(1);
            return;
        }
        settingTextTipView = this.f1479a.g;
        if (view == settingTextTipView) {
            aaVar7 = this.f1479a.c;
            aaVar7.a(2);
            return;
        }
        settingTextTipView2 = this.f1479a.h;
        if (view == settingTextTipView2) {
            aaVar6 = this.f1479a.c;
            aaVar6.a(3);
            return;
        }
        settingTextTipView3 = this.f1479a.i;
        if (view == settingTextTipView3) {
            aaVar5 = this.f1479a.c;
            aaVar5.a(4);
            return;
        }
        settingTextVersionView = this.f1479a.j;
        if (view == settingTextVersionView) {
            aaVar4 = this.f1479a.c;
            aaVar4.a(6);
            return;
        }
        settingTextTipView4 = this.f1479a.k;
        if (view == settingTextTipView4) {
            aaVar3 = this.f1479a.c;
            aaVar3.a(7);
            return;
        }
        settingTextTipView5 = this.f1479a.l;
        if (view == settingTextTipView5) {
            aaVar2 = this.f1479a.c;
            aaVar2.a(8);
            return;
        }
        textView = this.f1479a.m;
        if (view == textView) {
            aaVar = this.f1479a.c;
            aaVar.a(5);
        }
    }
}
