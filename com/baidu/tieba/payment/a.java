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
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.base.d<PayVcodeActivity> {
    private PayVcodeActivity lDf;
    private View lDg;
    private ViewGroup lDh;
    private TextView lDi;
    private TextView lDj;
    private ProgressBar mProgress;
    private ViewGroup mRootView;
    private BaseWebView mWebView;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.lDf = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        p(payVcodeActivity);
    }

    private void p(PayVcodeActivity payVcodeActivity) {
        this.mRootView = (ViewGroup) this.lDf.findViewById(R.id.payvcode_parent);
        this.lDi = (TextView) this.lDf.findViewById(R.id.payment_performance);
        ao.setBackgroundResource(this.lDi, R.drawable.s_navbar_button_bg);
        ao.setViewTextColor(this.lDi, R.color.CAM_X0101, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.lDj = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.lDg = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.lDh = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.mProgress = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView dma() {
        return this.lDi;
    }

    public TextView dmb() {
        return this.lDj;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void uq(boolean z) {
        this.lDj.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lDf.getPageContext(), this.mRootView);
        ao.setBgColor(this.lDj, i);
        ao.setBackgroundResource(this.lDi, R.drawable.s_navbar_button_bg);
        ao.setViewTextColor(this.lDi, R.color.CAM_X0101, 1);
    }

    public View dmc() {
        return this.lDg;
    }

    public ViewGroup dmd() {
        return this.lDh;
    }

    public void tC(boolean z) {
        this.mProgress.setVisibility(z ? 0 : 8);
    }
}
