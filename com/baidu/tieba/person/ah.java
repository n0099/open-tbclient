package com.baidu.tieba.person;

import android.content.Context;
import android.support.v4.view.ViewPager;
/* loaded from: classes.dex */
public final class ah implements ViewPager.OnPageChangeListener {
    final /* synthetic */ af a;

    public ah(af afVar) {
        this.a = afVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        com.baidu.tieba.model.av avVar;
        com.baidu.tieba.model.av avVar2;
        Context context;
        Context context2;
        switch (i) {
            case 0:
                this.a.b(0);
                break;
            case 1:
                this.a.b(1);
                break;
        }
        avVar = this.a.u;
        if (avVar != null) {
            avVar2 = this.a.u;
            if (avVar2.f()) {
                context2 = this.a.a;
                com.baidu.tbadk.core.g.a(context2, "person_self_scroll_click");
                return;
            }
            context = this.a.a;
            com.baidu.tbadk.core.g.a(context, "person_guid_scroll_click");
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
    }
}
