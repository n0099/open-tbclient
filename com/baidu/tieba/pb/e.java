package com.baidu.tieba.pb;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.view.MultiImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f2140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImageActivity imageActivity) {
        this.f2140a = imageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
        Button button;
        ProgressBar progressBar;
        NavigationBar navigationBar5;
        int i;
        imageView = this.f2140a.j;
        if (view == imageView) {
            navigationBar5 = this.f2140a.l;
            if (navigationBar5.getVisibility() != 8) {
                Intent intent = new Intent();
                i = this.f2140a.d;
                intent.putExtra("index", i);
                this.f2140a.setResult(-1, intent);
                this.f2140a.finish();
                return;
            }
            return;
        }
        frameLayout = this.f2140a.D;
        if (view == frameLayout) {
            navigationBar4 = this.f2140a.l;
            if (navigationBar4.getVisibility() != 8) {
                try {
                    multiImageView3 = this.f2140a.m;
                    byte[] currentImageData = multiImageView3.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView4 = this.f2140a.m;
                        String currentImageUrl = multiImageView4.getCurrentImageUrl();
                        this.f2140a.h = new j(this.f2140a, currentImageUrl, currentImageData);
                        jVar = this.f2140a.h;
                        jVar.execute(new String[0]);
                        button = this.f2140a.i;
                        button.setVisibility(4);
                        progressBar = this.f2140a.f2029a;
                        progressBar.setVisibility(0);
                    } else {
                        this.f2140a.showToast(this.f2140a.getString(R.string.no_data));
                    }
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        z = this.f2140a.r;
        if (z) {
            navigationBar = this.f2140a.l;
            if (navigationBar.getVisibility() != 0) {
                navigationBar3 = this.f2140a.l;
                navigationBar3.setVisibility(0);
                multiImageView2 = this.f2140a.m;
                multiImageView2.d();
                this.f2140a.q = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.f2140a.q = new AlphaAnimation(1.0f, 0.0f);
                this.f2140a.s = true;
                multiImageView = this.f2140a.m;
                multiImageView.e();
            }
            alphaAnimation = this.f2140a.q;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.f2140a.q;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.f2140a.q;
            alphaAnimation3.setAnimationListener(new f(this));
            this.f2140a.r = false;
            navigationBar2 = this.f2140a.l;
            alphaAnimation4 = this.f2140a.q;
            navigationBar2.startAnimation(alphaAnimation4);
        }
    }
}
