package com.baidu.tieba.square;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements ViewPager.OnPageChangeListener {
    final /* synthetic */ q a;

    private v(q qVar) {
        this.a = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(q qVar, v vVar) {
        this(qVar);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IndicatorView indicatorView;
        t tVar;
        ArrayList arrayList;
        t tVar2;
        IndicatorView indicatorView2;
        IndicatorView indicatorView3;
        IndicatorView indicatorView4;
        indicatorView = this.a.d;
        if (indicatorView != null) {
            tVar = this.a.e;
            if (tVar != null) {
                arrayList = this.a.p;
                if (arrayList.size() > 1) {
                    tVar2 = this.a.e;
                    int count = tVar2.getCount();
                    if (i == 0) {
                        indicatorView4 = this.a.d;
                        indicatorView4.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        indicatorView3 = this.a.d;
                        indicatorView3.setPosition(f);
                    } else {
                        indicatorView2 = this.a.d;
                        indicatorView2.setPosition((i - 1) + f);
                    }
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager viewPager;
        t tVar;
        ViewPager viewPager2;
        ArrayList arrayList;
        ViewPager viewPager3;
        ViewPager viewPager4;
        t tVar2;
        Handler handler;
        Handler handler2;
        int i2;
        ViewPager viewPager5;
        ViewPager viewPager6;
        Handler handler3;
        Handler handler4;
        int i3;
        ViewPager viewPager7;
        t tVar3;
        ViewPager viewPager8;
        viewPager = this.a.c;
        if (viewPager != null) {
            tVar = this.a.e;
            if (tVar != null) {
                if (i == 0) {
                    arrayList = this.a.p;
                    if (arrayList.size() > 1) {
                        viewPager4 = this.a.c;
                        int currentItem = viewPager4.getCurrentItem();
                        if (currentItem < 1) {
                            viewPager7 = this.a.c;
                            tVar3 = this.a.e;
                            viewPager7.setCurrentItem(tVar3.getCount() - 2, false);
                            viewPager8 = this.a.c;
                            viewPager8.invalidate();
                        } else {
                            tVar2 = this.a.e;
                            if (currentItem > tVar2.getCount() - 2) {
                                viewPager5 = this.a.c;
                                viewPager5.setCurrentItem(1, false);
                                viewPager6 = this.a.c;
                                viewPager6.invalidate();
                                handler3 = this.a.q;
                                handler3.removeMessages(0);
                                handler4 = this.a.q;
                                i3 = q.l;
                                handler4.sendEmptyMessageDelayed(0, i3);
                            } else {
                                handler = this.a.q;
                                handler.removeMessages(0);
                                handler2 = this.a.q;
                                i2 = q.l;
                                handler2.sendEmptyMessageDelayed(0, i2);
                            }
                        }
                    }
                    viewPager3 = this.a.c;
                    viewPager3.requestDisallowInterceptTouchEvent(false);
                } else if (i == 1) {
                    viewPager2 = this.a.c;
                    viewPager2.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
    }
}
