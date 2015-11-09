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
    private PayVcodeActivity cer;
    private View ces;
    private ViewGroup cet;
    private TextView ceu;
    private TextView cev;
    private ProgressBar mProgress;
    private ViewGroup mRootView;
    private BaseWebView mWebView;

    public b(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.cer = payVcodeActivity;
        payVcodeActivity.setContentView(i.g.pay_vcode_activity);
        n(payVcodeActivity);
    }

    private void n(PayVcodeActivity payVcodeActivity) {
        this.mRootView = (ViewGroup) this.cer.findViewById(i.f.payvcode_parent);
        this.ceu = (TextView) this.cer.findViewById(i.f.payment_performance);
        an.i((View) this.ceu, i.e.s_navbar_button_bg);
        an.b(this.ceu, i.c.cp_cont_i, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(i.f.vcode_webview);
        this.cev = (TextView) payVcodeActivity.findViewById(i.f.webview_fail_view);
        this.ces = payVcodeActivity.findViewById(i.f.payvcode_empty_layout);
        this.cet = (ViewGroup) payVcodeActivity.findViewById(i.f.payvcode_layout);
        this.mProgress = (ProgressBar) payVcodeActivity.findViewById(i.f.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView aeC() {
        return this.ceu;
    }

    public TextView aeD() {
        return this.cev;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void ei(boolean z) {
        this.cev.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.cer.getPageContext(), this.mRootView);
        an.e((View) this.cev, i);
        an.i((View) this.ceu, i.e.s_navbar_button_bg);
        an.b(this.ceu, i.c.cp_cont_i, 1);
    }

    public View aeE() {
        return this.ces;
    }

    public ViewGroup aeF() {
        return this.cet;
    }

    public void dc(boolean z) {
        this.mProgress.setVisibility(z ? 0 : 8);
    }
}
