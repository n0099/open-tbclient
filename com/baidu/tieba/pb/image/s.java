package com.baidu.tieba.pb.image;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BaseViewPager;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class s implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ImagePbActivity a;

    public s(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        TextView textView;
        com.baidu.tieba.data.w wVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        com.baidu.tieba.data.w wVar2;
        com.baidu.tieba.data.w wVar3;
        TextView textView2;
        String str;
        TextView textView3;
        LinearLayout linearLayout;
        TextView textView4;
        com.baidu.tieba.data.w wVar4;
        com.baidu.tieba.data.w wVar5;
        int i3;
        int i4;
        int i5;
        int i6;
        TextView textView5;
        TextView textView6;
        LinearLayout linearLayout2;
        BaseViewPager baseViewPager;
        ImagePbActivity imagePbActivity = this.a;
        i2 = this.a.H;
        imagePbActivity.a(i2, i);
        this.a.H = i;
        textView = this.a.h;
        textView.setText((CharSequence) null);
        wVar = this.a.E;
        if (wVar != null) {
            wVar2 = this.a.E;
            if (wVar2.j() > 0) {
                wVar3 = this.a.E;
                if (i != wVar3.j()) {
                    textView2 = this.a.g;
                    str = this.a.C;
                    textView2.setText(str);
                    textView3 = this.a.h;
                    textView3.setVisibility(0);
                    linearLayout = this.a.q;
                    linearLayout.setVisibility(0);
                    textView4 = this.a.h;
                    StringBuilder append = new StringBuilder(String.valueOf(String.valueOf(i + 1))).append("/");
                    wVar4 = this.a.E;
                    textView4.setText(append.append(String.valueOf(wVar4.j())).toString());
                    wVar5 = this.a.E;
                    LinkedList<com.baidu.tieba.data.v> g = wVar5.g();
                    if (g != null) {
                        i3 = this.a.H;
                        if (i3 < g.size()) {
                            i4 = this.a.H;
                            if (g.get(i4) != null) {
                                ImagePbActivity imagePbActivity2 = this.a;
                                i5 = this.a.H;
                                imagePbActivity2.J = g.get(i5).d();
                                i6 = this.a.H;
                                g.get(i6).i().equals(TbadkApplication.getCurrentAccount());
                            }
                        }
                    }
                } else {
                    textView5 = this.a.h;
                    textView5.setVisibility(8);
                    textView6 = this.a.g;
                    textView6.setText(this.a.getString(com.baidu.tieba.x.image_recommend));
                    linearLayout2 = this.a.q;
                    linearLayout2.setVisibility(8);
                    baseViewPager = this.a.w;
                    ay.a(baseViewPager, TbadkApplication.m252getInst().getSkinType());
                    return;
                }
            }
        }
        this.a.K = System.nanoTime();
        handler = this.a.P;
        runnable = this.a.Q;
        handler.removeCallbacks(runnable);
        handler2 = this.a.P;
        runnable2 = this.a.Q;
        handler2.postDelayed(runnable2, 90L);
    }
}
