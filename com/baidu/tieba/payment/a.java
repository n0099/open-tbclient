package com.baidu.tieba.payment;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.d<PayVcodeActivity> {
    private PayVcodeActivity lyA;
    private View lyB;
    private ViewGroup lyC;
    private TextView lyD;
    private TextView lyE;
    private ProgressBar mProgress;
    private ViewGroup mRootView;
    private BaseWebView mWebView;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.lyA = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        p(payVcodeActivity);
    }

    private void p(PayVcodeActivity payVcodeActivity) {
        this.mRootView = (ViewGroup) this.lyA.findViewById(R.id.payvcode_parent);
        this.lyD = (TextView) this.lyA.findViewById(R.id.payment_performance);
        ao.setBackgroundResource(this.lyD, R.drawable.s_navbar_button_bg);
        ao.setViewTextColor(this.lyD, R.color.CAM_X0101, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.lyE = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.lyB = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.lyC = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.mProgress = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView dii() {
        return this.lyD;
    }

    public TextView dij() {
        return this.lyE;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void um(boolean z) {
        this.lyE.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lyA.getPageContext(), this.mRootView);
        ao.setBgColor(this.lyE, i);
        ao.setBackgroundResource(this.lyD, R.drawable.s_navbar_button_bg);
        ao.setViewTextColor(this.lyD, R.color.CAM_X0101, 1);
    }

    public View dik() {
        return this.lyB;
    }

    public ViewGroup dil() {
        return this.lyC;
    }

    public void ty(boolean z) {
        this.mProgress.setVisibility(z ? 0 : 8);
    }
}
