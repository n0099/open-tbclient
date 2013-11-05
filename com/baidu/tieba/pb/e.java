package com.baidu.tieba.pb;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tieba.view.MultiImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f2133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImageActivity imageActivity) {
        this.f2133a = imageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        boolean z;
        LinearLayout linearLayout;
        MultiImageView multiImageView;
        AlphaAnimation alphaAnimation;
        AlphaAnimation alphaAnimation2;
        AlphaAnimation alphaAnimation3;
        LinearLayout linearLayout2;
        AlphaAnimation alphaAnimation4;
        LinearLayout linearLayout3;
        MultiImageView multiImageView2;
        LinearLayout linearLayout4;
        MultiImageView multiImageView3;
        MultiImageView multiImageView4;
        j jVar;
        Button button3;
        ProgressBar progressBar;
        LinearLayout linearLayout5;
        int i;
        button = this.f2133a.l;
        if (view == button) {
            linearLayout5 = this.f2133a.n;
            if (linearLayout5.getVisibility() != 8) {
                Intent intent = new Intent();
                i = this.f2133a.d;
                intent.putExtra("index", i);
                this.f2133a.setResult(-1, intent);
                this.f2133a.finish();
                return;
            }
            return;
        }
        button2 = this.f2133a.k;
        if (view == button2) {
            linearLayout4 = this.f2133a.n;
            if (linearLayout4.getVisibility() != 8) {
                try {
                    multiImageView3 = this.f2133a.o;
                    byte[] currentImageData = multiImageView3.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView4 = this.f2133a.o;
                        String currentImageUrl = multiImageView4.getCurrentImageUrl();
                        this.f2133a.j = new j(this.f2133a, currentImageUrl, currentImageData);
                        jVar = this.f2133a.j;
                        jVar.execute(new String[0]);
                        button3 = this.f2133a.k;
                        button3.setVisibility(4);
                        progressBar = this.f2133a.f2030a;
                        progressBar.setVisibility(0);
                    } else {
                        this.f2133a.a(this.f2133a.getString(R.string.no_data));
                    }
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        z = this.f2133a.t;
        if (z) {
            linearLayout = this.f2133a.n;
            if (linearLayout.getVisibility() != 0) {
                linearLayout3 = this.f2133a.n;
                linearLayout3.setVisibility(0);
                multiImageView2 = this.f2133a.o;
                multiImageView2.d();
                this.f2133a.s = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.f2133a.s = new AlphaAnimation(1.0f, 0.0f);
                this.f2133a.u = true;
                multiImageView = this.f2133a.o;
                multiImageView.e();
            }
            alphaAnimation = this.f2133a.s;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.f2133a.s;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.f2133a.s;
            alphaAnimation3.setAnimationListener(new f(this));
            this.f2133a.t = false;
            linearLayout2 = this.f2133a.n;
            alphaAnimation4 = this.f2133a.s;
            linearLayout2.startAnimation(alphaAnimation4);
        }
    }
}
