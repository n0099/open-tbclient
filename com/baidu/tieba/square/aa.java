package com.baidu.tieba.square;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements ViewPager.OnPageChangeListener {
    final /* synthetic */ v a;

    private aa(v vVar) {
        this.a = vVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(v vVar, aa aaVar) {
        this(vVar);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IndicatorView indicatorView;
        y yVar;
        ArrayList arrayList;
        y yVar2;
        IndicatorView indicatorView2;
        IndicatorView indicatorView3;
        IndicatorView indicatorView4;
        indicatorView = this.a.d;
        if (indicatorView != null) {
            yVar = this.a.e;
            if (yVar != null) {
                arrayList = this.a.m;
                if (arrayList.size() > 1) {
                    yVar2 = this.a.e;
                    int count = yVar2.getCount();
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
        y yVar;
        ViewPager viewPager2;
        ArrayList arrayList;
        ViewPager viewPager3;
        ViewPager viewPager4;
        y yVar2;
        Handler handler;
        Handler handler2;
        int i2;
        ViewPager viewPager5;
        ViewPager viewPager6;
        Handler handler3;
        Handler handler4;
        int i3;
        ViewPager viewPager7;
        y yVar3;
        ViewPager viewPager8;
        viewPager = this.a.c;
        if (viewPager != null) {
            yVar = this.a.e;
            if (yVar != null) {
                if (i == 0) {
                    arrayList = this.a.m;
                    if (arrayList.size() > 1) {
                        viewPager4 = this.a.c;
                        int currentItem = viewPager4.getCurrentItem();
                        if (currentItem < 1) {
                            viewPager7 = this.a.c;
                            yVar3 = this.a.e;
                            viewPager7.setCurrentItem(yVar3.getCount() - 2, false);
                            viewPager8 = this.a.c;
                            viewPager8.invalidate();
                        } else {
                            yVar2 = this.a.e;
                            if (currentItem > yVar2.getCount() - 2) {
                                viewPager5 = this.a.c;
                                viewPager5.setCurrentItem(1, false);
                                viewPager6 = this.a.c;
                                viewPager6.invalidate();
                                handler3 = this.a.n;
                                handler3.removeMessages(0);
                                handler4 = this.a.n;
                                i3 = v.l;
                                handler4.sendEmptyMessageDelayed(0, i3);
                            } else {
                                handler = this.a.n;
                                handler.removeMessages(0);
                                handler2 = this.a.n;
                                i2 = v.l;
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
