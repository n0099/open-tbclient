package com.bigkoo.svprogresshud.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigkoo.svprogresshud.R;
/* loaded from: classes19.dex */
public class SVProgressDefaultView extends LinearLayout {
    private SVCircleProgressBar circleProgressBar;
    private ImageView ivBigLoading;
    private ImageView ivSmallLoading;
    private RotateAnimation mRotateAnimation;
    private int resBigLoading;
    private int resError;
    private int resInfo;
    private int resSuccess;
    private TextView tvMsg;

    public SVProgressDefaultView(Context context) {
        super(context);
        this.resBigLoading = R.drawable.ic_svstatus_loading;
        this.resInfo = R.drawable.ic_svstatus_info;
        this.resSuccess = R.drawable.ic_svstatus_success;
        this.resError = R.drawable.ic_svstatus_error;
        initViews();
        init();
    }

    private void initViews() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_svprogressdefault, (ViewGroup) this, true);
        this.ivBigLoading = (ImageView) findViewById(R.id.ivBigLoading);
        this.ivSmallLoading = (ImageView) findViewById(R.id.ivSmallLoading);
        this.circleProgressBar = (SVCircleProgressBar) findViewById(R.id.circleProgressBar);
        this.tvMsg = (TextView) findViewById(R.id.tvMsg);
    }

    private void init() {
        this.mRotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(1000L);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setRepeatMode(1);
    }

    public void show() {
        clearAnimations();
        this.ivBigLoading.setImageResource(this.resBigLoading);
        this.ivBigLoading.setVisibility(0);
        this.ivSmallLoading.setVisibility(8);
        this.circleProgressBar.setVisibility(8);
        this.tvMsg.setVisibility(8);
        this.ivBigLoading.startAnimation(this.mRotateAnimation);
    }

    public void showWithStatus(String str) {
        if (str == null) {
            show();
            return;
        }
        showBaseStatus(this.resBigLoading, str);
        this.ivSmallLoading.startAnimation(this.mRotateAnimation);
    }

    public void showInfoWithStatus(String str) {
        showBaseStatus(this.resInfo, str);
    }

    public void showSuccessWithStatus(String str) {
        showBaseStatus(this.resSuccess, str);
    }

    public void showErrorWithStatus(String str) {
        showBaseStatus(this.resError, str);
    }

    public void showWithProgress(String str) {
        showProgress(str);
    }

    public SVCircleProgressBar getCircleProgressBar() {
        return this.circleProgressBar;
    }

    public void setText(String str) {
        this.tvMsg.setText(str);
    }

    public void showProgress(String str) {
        clearAnimations();
        this.tvMsg.setText(str);
        this.ivBigLoading.setVisibility(8);
        this.ivSmallLoading.setVisibility(8);
        this.circleProgressBar.setVisibility(0);
        this.tvMsg.setVisibility(0);
    }

    public void showBaseStatus(int i, String str) {
        clearAnimations();
        this.ivSmallLoading.setImageResource(i);
        this.tvMsg.setText(str);
        this.ivBigLoading.setVisibility(8);
        this.circleProgressBar.setVisibility(8);
        this.ivSmallLoading.setVisibility(0);
        this.tvMsg.setVisibility(0);
    }

    public void dismiss() {
        clearAnimations();
    }

    private void clearAnimations() {
        this.ivBigLoading.clearAnimation();
        this.ivSmallLoading.clearAnimation();
    }
}
