package com.baidu.tieba.payment;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.d<PayVcodeActivity> {
    private PayVcodeActivity lJD;
    private View lJE;
    private ViewGroup lJF;
    private TextView lJG;
    private TextView lJH;
    private ProgressBar mProgress;
    private ViewGroup mRootView;
    private BaseWebView mWebView;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.lJD = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        p(payVcodeActivity);
    }

    private void p(PayVcodeActivity payVcodeActivity) {
        this.mRootView = (ViewGroup) this.lJD.findViewById(R.id.payvcode_parent);
        this.lJG = (TextView) this.lJD.findViewById(R.id.payment_performance);
        ap.setBackgroundResource(this.lJG, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.lJG, R.color.CAM_X0101, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.lJH = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.lJE = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.lJF = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.mProgress = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView dkK() {
        return this.lJG;
    }

    public TextView dkL() {
        return this.lJH;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void uz(boolean z) {
        this.lJH.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lJD.getPageContext(), this.mRootView);
        ap.setBgColor(this.lJH, i);
        ap.setBackgroundResource(this.lJG, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.lJG, R.color.CAM_X0101, 1);
    }

    public View dkM() {
        return this.lJE;
    }

    public ViewGroup dkN() {
        return this.lJF;
    }

    public void tL(boolean z) {
        this.mProgress.setVisibility(z ? 0 : 8);
    }
}
