package com.baidu.tieba.payment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PayVcodeActivity> {
    private PayVcodeActivity cdQ;
    private View cdR;
    private ViewGroup cdS;
    private TextView cdT;
    private TextView cdU;
    private ProgressBar mProgress;
    private ViewGroup mRootView;
    private BaseWebView mWebView;

    public b(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.cdQ = payVcodeActivity;
        payVcodeActivity.setContentView(i.g.pay_vcode_activity);
        n(payVcodeActivity);
    }

    private void n(PayVcodeActivity payVcodeActivity) {
        this.mRootView = (ViewGroup) this.cdQ.findViewById(i.f.payvcode_parent);
        this.cdT = (TextView) this.cdQ.findViewById(i.f.payment_performance);
        an.i((View) this.cdT, i.e.s_navbar_button_bg);
        an.b(this.cdT, i.c.cp_cont_i, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(i.f.vcode_webview);
        this.cdU = (TextView) payVcodeActivity.findViewById(i.f.webview_fail_view);
        this.cdR = payVcodeActivity.findViewById(i.f.payvcode_empty_layout);
        this.cdS = (ViewGroup) payVcodeActivity.findViewById(i.f.payvcode_layout);
        this.mProgress = (ProgressBar) payVcodeActivity.findViewById(i.f.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView aeh() {
        return this.cdT;
    }

    public TextView aei() {
        return this.cdU;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void eg(boolean z) {
        this.cdU.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.cdQ.getPageContext(), this.mRootView);
        an.e((View) this.cdU, i);
        an.i((View) this.cdT, i.e.s_navbar_button_bg);
        an.b(this.cdT, i.c.cp_cont_i, 1);
    }

    public View aej() {
        return this.cdR;
    }

    public ViewGroup aek() {
        return this.cdS;
    }

    public void da(boolean z) {
        this.mProgress.setVisibility(z ? 0 : 8);
    }
}
