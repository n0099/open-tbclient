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
    private PayVcodeActivity lHB;
    private View lHC;
    private ViewGroup lHD;
    private TextView lHE;
    private TextView lHF;
    private ProgressBar mProgress;
    private ViewGroup mRootView;
    private BaseWebView mWebView;

    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.lHB = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        p(payVcodeActivity);
    }

    private void p(PayVcodeActivity payVcodeActivity) {
        this.mRootView = (ViewGroup) this.lHB.findViewById(R.id.payvcode_parent);
        this.lHE = (TextView) this.lHB.findViewById(R.id.payment_performance);
        ap.setBackgroundResource(this.lHE, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.lHE, R.color.CAM_X0101, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
        this.lHF = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
        this.lHC = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
        this.lHD = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
        this.mProgress = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView dkB() {
        return this.lHE;
    }

    public TextView dkC() {
        return this.lHF;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void uz(boolean z) {
        this.lHF.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lHB.getPageContext(), this.mRootView);
        ap.setBgColor(this.lHF, i);
        ap.setBackgroundResource(this.lHE, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.lHE, R.color.CAM_X0101, 1);
    }

    public View dkD() {
        return this.lHC;
    }

    public ViewGroup dkE() {
        return this.lHD;
    }

    public void tL(boolean z) {
        this.mProgress.setVisibility(z ? 0 : 8);
    }
}
