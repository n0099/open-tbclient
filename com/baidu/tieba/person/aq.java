package com.baidu.tieba.person;

import android.content.Context;
import android.support.v4.view.ViewPager;
/* loaded from: classes.dex */
public class aq implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ao a;

    public aq(ao aoVar) {
        this.a = aoVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        com.baidu.tieba.model.au auVar;
        com.baidu.tieba.model.au auVar2;
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
        auVar = this.a.x;
        if (auVar != null) {
            auVar2 = this.a.x;
            if (auVar2.i()) {
                context2 = this.a.c;
                com.baidu.tbadk.core.f.a(context2, "person_self_scroll_click");
                return;
            }
            context = this.a.c;
            com.baidu.tbadk.core.f.a(context, "person_guid_scroll_click");
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
