package com.baidu.tieba.pb.image;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BaseViewPager;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class t implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ImagePbActivity a;

    public t(ImagePbActivity imagePbActivity) {
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
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        com.baidu.tieba.data.u uVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        com.baidu.tieba.data.u uVar2;
        com.baidu.tieba.data.u uVar3;
        BaseViewPager baseViewPager;
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
        ImageView imageView3;
        ImageView imageView4;
        TextView textView5;
        TextView textView6;
        LinearLayout linearLayout2;
        BaseViewPager baseViewPager2;
        ImagePbActivity imagePbActivity = this.a;
        i2 = this.a.J;
        imagePbActivity.a(i2, i);
        this.a.J = i;
        imageView = this.a.d;
        imageView.setVisibility(4);
        imageView2 = this.a.d;
        imageView2.setClickable(false);
        textView = this.a.i;
        textView.setText((CharSequence) null);
        uVar = this.a.G;
        if (uVar != null) {
            uVar2 = this.a.G;
            if (uVar2.k() > 0) {
                uVar3 = this.a.G;
                if (i == uVar3.k()) {
                    textView5 = this.a.i;
                    textView5.setVisibility(8);
                    textView6 = this.a.h;
                    textView6.setText(this.a.getString(com.baidu.tieba.a.k.image_recommend));
                    linearLayout2 = this.a.r;
                    linearLayout2.setVisibility(8);
                    baseViewPager2 = this.a.y;
                    ba.a(baseViewPager2, TbadkApplication.j().l());
                    return;
                }
                baseViewPager = this.a.y;
                baseViewPager.setBackgroundResource(0);
                textView2 = this.a.h;
                str = this.a.E;
                textView2.setText(str);
                textView3 = this.a.i;
                textView3.setVisibility(0);
                linearLayout = this.a.r;
                linearLayout.setVisibility(0);
                textView4 = this.a.i;
                StringBuilder append = new StringBuilder(String.valueOf(String.valueOf(i + 1))).append("/");
                uVar4 = this.a.G;
                textView4.setText(append.append(String.valueOf(uVar4.k())).toString());
                uVar5 = this.a.G;
                LinkedList<com.baidu.tieba.data.t> h = uVar5.h();
                if (h != null) {
                    i3 = this.a.J;
                    if (i3 < h.size()) {
                        i4 = this.a.J;
                        if (h.get(i4) != null) {
                            ImagePbActivity imagePbActivity2 = this.a;
                            i5 = this.a.J;
                            imagePbActivity2.L = h.get(i5).d();
                            i6 = this.a.J;
                            if (h.get(i6).i().equals(TbadkApplication.E())) {
                                imageView3 = this.a.d;
                                imageView3.setVisibility(0);
                                imageView4 = this.a.d;
                                imageView4.setClickable(true);
                            }
                        }
                    }
                }
            }
        }
        this.a.M = System.nanoTime();
        handler = this.a.R;
        runnable = this.a.S;
        handler.removeCallbacks(runnable);
        handler2 = this.a.R;
        runnable2 = this.a.S;
        handler2.postDelayed(runnable2, 300L);
    }
}
