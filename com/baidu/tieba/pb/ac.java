package com.baidu.tieba.pb;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ac implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ImagePbActivity a;

    public ac(ImagePbActivity imagePbActivity) {
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
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        com.baidu.tieba.data.ab abVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        com.baidu.tieba.data.ab abVar2;
        com.baidu.tieba.data.ab abVar3;
        BaseViewPager baseViewPager;
        TextView textView2;
        String str;
        TextView textView3;
        LinearLayout linearLayout;
        TextView textView4;
        com.baidu.tieba.data.ab abVar4;
        com.baidu.tieba.data.ab abVar5;
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
        abVar = this.a.G;
        if (abVar != null) {
            abVar2 = this.a.G;
            if (abVar2.k() > 0) {
                abVar3 = this.a.G;
                if (i == abVar3.k()) {
                    textView5 = this.a.i;
                    textView5.setVisibility(8);
                    textView6 = this.a.h;
                    textView6.setText(this.a.getString(R.string.image_recommend));
                    linearLayout2 = this.a.r;
                    linearLayout2.setVisibility(8);
                    baseViewPager2 = this.a.y;
                    com.baidu.tieba.util.bq.a(baseViewPager2, TiebaApplication.g().al());
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
                abVar4 = this.a.G;
                textView4.setText(append.append(String.valueOf(abVar4.k())).toString());
                abVar5 = this.a.G;
                LinkedList<com.baidu.tieba.data.aa> h = abVar5.h();
                if (h != null) {
                    i3 = this.a.J;
                    if (i3 < h.size()) {
                        i4 = this.a.J;
                        if (h.get(i4) != null) {
                            ImagePbActivity imagePbActivity2 = this.a;
                            i5 = this.a.J;
                            imagePbActivity2.L = h.get(i5).d();
                            i6 = this.a.J;
                            if (h.get(i6).i().equals(TiebaApplication.A())) {
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
