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
        button = this.a.j;
        if (view == button) {
            linearLayout5 = this.a.l;
            if (linearLayout5.getVisibility() == 8) {
                return;
            }
            Intent intent = new Intent();
            i = this.a.d;
            intent.putExtra("index", i);
            this.a.setResult(-1, intent);
            this.a.finish();
            return;
        }
        button2 = this.a.i;
        if (view == button2) {
            linearLayout4 = this.a.l;
            if (linearLayout4.getVisibility() != 8) {
                try {
                    multiImageView3 = this.a.m;
                    byte[] currentImageData = multiImageView3.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView4 = this.a.m;
                        String currentImageUrl = multiImageView4.getCurrentImageUrl();
                        this.a.h = new i(this.a, currentImageUrl, currentImageData);
                        iVar = this.a.h;
                        iVar.execute(new String[0]);
                        button3 = this.a.i;
                        button3.setVisibility(4);
                        progressBar = this.a.b;
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
        z = this.a.r;
        if (z) {
            linearLayout = this.a.l;
            if (linearLayout.getVisibility() != 0) {
                linearLayout3 = this.a.l;
                linearLayout3.setVisibility(0);
                multiImageView2 = this.a.m;
                multiImageView2.d();
                this.a.q = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.a.q = new AlphaAnimation(1.0f, 0.0f);
                this.a.s = true;
                multiImageView = this.a.m;
                multiImageView.e();
            }
            alphaAnimation = this.a.q;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.a.q;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.a.q;
            alphaAnimation3.setAnimationListener(new e(this));
            this.a.r = false;
            linearLayout2 = this.a.l;
            alphaAnimation4 = this.a.q;
            linearLayout2.startAnimation(alphaAnimation4);
        }
    }
}
