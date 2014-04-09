package com.baidu.tieba.pb.image;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BaseViewPager;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class s implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ImagePbActivity a;

    public s(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        int i2;
        TextView textView;
        com.baidu.tieba.data.u uVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        com.baidu.tieba.data.u uVar2;
        com.baidu.tieba.data.u uVar3;
        TextView textView2;
        String str;
        TextView textView3;
        LinearLayout linearLayout;
        TextView textView4;
        com.baidu.tieba.data.u uVar4;
        com.baidu.tieba.data.u uVar5;
        int i3;
        int i4;
        int i5;
        int i6;
        TextView textView5;
        TextView textView6;
        LinearLayout linearLayout2;
        BaseViewPager baseViewPager;
        ImagePbActivity imagePbActivity = this.a;
        i2 = this.a.I;
        imagePbActivity.a(i2, i);
        this.a.I = i;
        textView = this.a.h;
        textView.setText((CharSequence) null);
        uVar = this.a.F;
        if (uVar != null) {
            uVar2 = this.a.F;
            if (uVar2.j() > 0) {
                uVar3 = this.a.F;
                if (i != uVar3.j()) {
                    textView2 = this.a.g;
                    str = this.a.D;
                    textView2.setText(str);
                    textView3 = this.a.h;
                    textView3.setVisibility(0);
                    linearLayout = this.a.q;
                    linearLayout.setVisibility(0);
                    textView4 = this.a.h;
                    StringBuilder append = new StringBuilder(String.valueOf(String.valueOf(i + 1))).append("/");
                    uVar4 = this.a.F;
                    textView4.setText(append.append(String.valueOf(uVar4.j())).toString());
                    uVar5 = this.a.F;
                    LinkedList<com.baidu.tieba.data.t> g = uVar5.g();
                    if (g != null) {
                        i3 = this.a.I;
                        if (i3 < g.size()) {
                            i4 = this.a.I;
                            if (g.get(i4) != null) {
                                ImagePbActivity imagePbActivity2 = this.a;
                                i5 = this.a.I;
                                imagePbActivity2.K = g.get(i5).d();
                                i6 = this.a.I;
                                g.get(i6).i().equals(TbadkApplication.E());
                            }
                        }
                    }
                } else {
                    textView5 = this.a.h;
                    textView5.setVisibility(8);
                    textView6 = this.a.g;
                    textView6.setText(this.a.getString(com.baidu.tieba.a.k.image_recommend));
                    linearLayout2 = this.a.q;
                    linearLayout2.setVisibility(8);
                    baseViewPager = this.a.x;
                    ba.a(baseViewPager, TbadkApplication.j().l());
                    return;
                }
            }
        }
        this.a.L = System.nanoTime();
        handler = this.a.Q;
        runnable = this.a.R;
        handler.removeCallbacks(runnable);
        handler2 = this.a.Q;
        runnable2 = this.a.R;
        handler2.postDelayed(runnable2, 300L);
    }
}
