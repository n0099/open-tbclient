package com.baidu.tieba.square;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends Handler {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ViewPager viewPager;
        ViewPager viewPager2;
        t tVar;
        ArrayList arrayList;
        t tVar2;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        ViewPager viewPager7;
        t tVar3;
        ViewPager viewPager8;
        viewPager = this.a.c;
        int currentItem = viewPager.getCurrentItem();
        if (message.what == 0) {
            viewPager2 = this.a.c;
            if (viewPager2 != null) {
                tVar = this.a.e;
                if (tVar != null) {
                    arrayList = this.a.m;
                    if (arrayList.size() > 1) {
                        if (currentItem < 1) {
                            viewPager7 = this.a.c;
                            tVar3 = this.a.e;
                            viewPager7.setCurrentItem(tVar3.getCount() - 2, false);
                            viewPager8 = this.a.c;
                            viewPager8.invalidate();
                            return;
                        }
                        tVar2 = this.a.e;
                        if (currentItem > tVar2.getCount() - 2) {
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
