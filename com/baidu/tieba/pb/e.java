package com.baidu.tieba.pb;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.view.MultiImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class e implements View.OnClickListener {
    final /* synthetic */ ImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImageActivity imageActivity) {
        this.a = imageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        FrameLayout frameLayout;
        boolean z;
        NavigationBar navigationBar;
        MultiImageView multiImageView;
        AlphaAnimation alphaAnimation;
        AlphaAnimation alphaAnimation2;
        AlphaAnimation alphaAnimation3;
        NavigationBar navigationBar2;
        AlphaAnimation alphaAnimation4;
        NavigationBar navigationBar3;
        MultiImageView multiImageView2;
        NavigationBar navigationBar4;
        MultiImageView multiImageView3;
        MultiImageView multiImageView4;
        j jVar;
        TextView textView;
        ProgressBar progressBar;
        NavigationBar navigationBar5;
        int i;
        imageView = this.a.j;
        if (view == imageView) {
            navigationBar5 = this.a.l;
            if (navigationBar5.getVisibility() != 8) {
                Intent intent = new Intent();
                i = this.a.d;
                intent.putExtra("index", i);
                this.a.setResult(-1, intent);
                this.a.finish();
                return;
            }
            return;
        }
        frameLayout = this.a.D;
        if (view == frameLayout) {
            navigationBar4 = this.a.l;
            if (navigationBar4.getVisibility() != 8) {
                try {
                    multiImageView3 = this.a.m;
                    byte[] currentImageData = multiImageView3.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView4 = this.a.m;
                        String currentImageUrl = multiImageView4.getCurrentImageUrl();
                        this.a.h = new j(this.a, currentImageUrl, currentImageData);
                        jVar = this.a.h;
                        jVar.execute(new String[0]);
                        textView = this.a.i;
                        textView.setVisibility(4);
                        progressBar = this.a.a;
                        progressBar.setVisibility(0);
                    } else {
                        this.a.showToast(this.a.getString(R.string.no_data));
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
            navigationBar = this.a.l;
            if (navigationBar.getVisibility() != 0) {
                navigationBar3 = this.a.l;
                navigationBar3.setVisibility(0);
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
            alphaAnimation3.setAnimationListener(new f(this));
            this.a.r = false;
            navigationBar2 = this.a.l;
            alphaAnimation4 = this.a.q;
            navigationBar2.startAnimation(alphaAnimation4);
        }
    }
}
