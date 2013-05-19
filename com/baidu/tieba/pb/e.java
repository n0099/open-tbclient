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
    final /* synthetic */ ImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImageActivity imageActivity) {
        this.a = imageActivity;
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
        button = this.a.l;
        if (view != button) {
            button2 = this.a.k;
            if (view == button2) {
                linearLayout4 = this.a.n;
                if (linearLayout4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.a.o;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.a.o;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.a.j = new j(this.a, currentImageUrl, currentImageData);
                            jVar = this.a.j;
                            jVar.execute(new String[0]);
                            button3 = this.a.k;
                            button3.setVisibility(4);
                            progressBar = this.a.c;
                            progressBar.setVisibility(0);
                        } else {
                            this.a.a(this.a.getString(R.string.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.a.t;
            if (z) {
                linearLayout = this.a.n;
                if (linearLayout.getVisibility() != 0) {
                    linearLayout3 = this.a.n;
                    linearLayout3.setVisibility(0);
                    multiImageView2 = this.a.o;
                    multiImageView2.d();
                    this.a.s = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.a.s = new AlphaAnimation(1.0f, 0.0f);
                    this.a.u = true;
                    multiImageView = this.a.o;
                    multiImageView.e();
                }
                alphaAnimation = this.a.s;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.a.s;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.a.s;
                alphaAnimation3.setAnimationListener(new f(this));
                this.a.t = false;
                linearLayout2 = this.a.n;
                alphaAnimation4 = this.a.s;
                linearLayout2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        linearLayout5 = this.a.n;
        if (linearLayout5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.a.f;
            intent.putExtra("index", i);
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
