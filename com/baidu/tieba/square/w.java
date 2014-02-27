package com.baidu.tieba.square;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends Handler {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.a = vVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ViewPager viewPager;
        ViewPager viewPager2;
        y yVar;
        ArrayList arrayList;
        y yVar2;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        ViewPager viewPager7;
        y yVar3;
        ViewPager viewPager8;
        viewPager = this.a.c;
        int currentItem = viewPager.getCurrentItem();
        if (message.what == 0) {
            viewPager2 = this.a.c;
            if (viewPager2 != null) {
                yVar = this.a.e;
                if (yVar != null) {
                    arrayList = this.a.m;
                    if (arrayList.size() > 1) {
                        if (currentItem <= 0) {
                            viewPager7 = this.a.c;
                            yVar3 = this.a.e;
                            viewPager7.setCurrentItem(yVar3.getCount() - 2, false);
                            viewPager8 = this.a.c;
                            viewPager8.invalidate();
                            return;
                        }
                        yVar2 = this.a.e;
                        if (currentItem > yVar2.getCount() - 2) {
                            viewPager5 = this.a.c;
                            viewPager5.setCurrentItem(1, false);
                            viewPager6 = this.a.c;
                            viewPager6.invalidate();
                            return;
                        }
                        viewPager3 = this.a.c;
                        viewPager3.setCurrentItem(currentItem + 1);
                        viewPager4 = this.a.c;
                        viewPager4.invalidate();
                    }
                }
            }
        }
    }
}
