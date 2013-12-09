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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f2248a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImageActivity imageActivity) {
        this.f2248a = imageActivity;
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
        TextView textView;
        ProgressBar progressBar;
        NavigationBar navigationBar5;
        int i;
        imageView = this.f2248a.j;
        if (view == imageView) {
            navigationBar5 = this.f2248a.l;
            if (navigationBar5.getVisibility() != 8) {
                Intent intent = new Intent();
                i = this.f2248a.d;
                intent.putExtra("index", i);
                this.f2248a.setResult(-1, intent);
                this.f2248a.finish();
                return;
            }
            return;
        }
        frameLayout = this.f2248a.D;
        if (view == frameLayout) {
            navigationBar4 = this.f2248a.l;
            if (navigationBar4.getVisibility() != 8) {
                try {
                    multiImageView3 = this.f2248a.m;
                    byte[] currentImageData = multiImageView3.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView4 = this.f2248a.m;
                        String currentImageUrl = multiImageView4.getCurrentImageUrl();
                        this.f2248a.h = new j(this.f2248a, currentImageUrl, currentImageData);
                        jVar = this.f2248a.h;
                        jVar.execute(new String[0]);
                        textView = this.f2248a.i;
                        textView.setVisibility(4);
                        progressBar = this.f2248a.f2137a;
                        progressBar.setVisibility(0);
                    } else {
                        this.f2248a.showToast(this.f2248a.getString(R.string.no_data));
                    }
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        z = this.f2248a.r;
        if (z) {
            navigationBar = this.f2248a.l;
            if (navigationBar.getVisibility() != 0) {
                navigationBar3 = this.f2248a.l;
                navigationBar3.setVisibility(0);
                multiImageView2 = this.f2248a.m;
                multiImageView2.d();
                this.f2248a.q = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.f2248a.q = new AlphaAnimation(1.0f, 0.0f);
                this.f2248a.s = true;
                multiImageView = this.f2248a.m;
                multiImageView.e();
            }
            alphaAnimation = this.f2248a.q;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.f2248a.q;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.f2248a.q;
            alphaAnimation3.setAnimationListener(new f(this));
            this.f2248a.r = false;
            navigationBar2 = this.f2248a.l;
            alphaAnimation4 = this.f2248a.q;
            navigationBar2.startAnimation(alphaAnimation4);
        }
    }
}
