package com.baidu.tieba.pb;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ ImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ImageActivity imageActivity) {
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
        i iVar;
        Button button3;
        ProgressBar progressBar;
        LinearLayout linearLayout5;
        int i;
        button = this.a.k;
        if (view != button) {
            button2 = this.a.j;
            if (view == button2) {
                linearLayout4 = this.a.m;
                if (linearLayout4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.a.n;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.a.n;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.a.i = new i(this.a, currentImageUrl, currentImageData);
                            iVar = this.a.i;
                            iVar.execute(new String[0]);
                            button3 = this.a.j;
                            button3.setVisibility(4);
                            progressBar = this.a.c;
                            progressBar.setVisibility(0);
                        } else {
                            this.a.b(this.a.getString(R.string.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.a.s;
            if (z) {
                linearLayout = this.a.m;
                if (linearLayout.getVisibility() != 0) {
                    linearLayout3 = this.a.m;
                    linearLayout3.setVisibility(0);
                    multiImageView2 = this.a.n;
                    multiImageView2.d();
                    this.a.r = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.a.r = new AlphaAnimation(1.0f, 0.0f);
                    this.a.t = true;
                    multiImageView = this.a.n;
                    multiImageView.e();
                }
                alphaAnimation = this.a.r;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.a.r;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.a.r;
                alphaAnimation3.setAnimationListener(new e(this));
                this.a.s = false;
                linearLayout2 = this.a.m;
                alphaAnimation4 = this.a.r;
                linearLayout2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        linearLayout5 = this.a.m;
        if (linearLayout5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.a.e;
            intent.putExtra("index", i);
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
