package com.baidu.tieba.person;

import android.content.Context;
import android.support.v4.view.ViewPager;
/* loaded from: classes.dex */
public class bh implements ViewPager.OnPageChangeListener {
    final /* synthetic */ bg a;

    public bh(bg bgVar) {
        this.a = bgVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bp bpVar2;
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
        bpVar = this.a.u;
        if (bpVar != null) {
            bpVar2 = this.a.u;
            if (bpVar2.e()) {
                context2 = this.a.a;
                com.baidu.tieba.ai.a(context2, "person_self_scroll_click");
                return;
            }
            context = this.a.a;
            com.baidu.tieba.ai.a(context, "person_guid_scroll_click");
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
