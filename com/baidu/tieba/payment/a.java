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
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.base.d<PayVcodeActivity> {
    private PayVcodeActivity lHn;
    private View lHo;
    private ViewGroup lHp;
    private TextView lHq;
    private TextView lHr;
    private ProgressBar mProgress;
    private ViewGroup mRootView;
    private BaseWebView mWebView;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.lHn = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        p(payVcodeActivity);
    }

    private void p(PayVcodeActivity payVcodeActivity) {
        this.mRootView = (ViewGroup) this.lHn.findViewById(R.id.payvcode_parent);
        this.lHq = (TextView) this.lHn.findViewById(R.id.payment_performance);
        ap.setBackgroundResource(this.lHq, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.lHq, R.color.CAM_X0101, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.lHr = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.lHo = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.lHp = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.mProgress = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView dku() {
        return this.lHq;
    }

    public TextView dkv() {
        return this.lHr;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void uz(boolean z) {
        this.lHr.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lHn.getPageContext(), this.mRootView);
        ap.setBgColor(this.lHr, i);
        ap.setBackgroundResource(this.lHq, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.lHq, R.color.CAM_X0101, 1);
    }

    public View dkw() {
        return this.lHo;
    }

    public ViewGroup dkx() {
        return this.lHp;
    }

    public void tL(boolean z) {
        this.mProgress.setVisibility(z ? 0 : 8);
    }
}
