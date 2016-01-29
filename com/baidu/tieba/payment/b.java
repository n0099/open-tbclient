package com.baidu.tieba.payment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PayVcodeActivity> {
    private ViewGroup Ye;
    private ProgressBar aNo;
    private PayVcodeActivity cGZ;
    private View cHa;
    private ViewGroup cHb;
    private TextView cHc;
    private TextView cHd;
    private BaseWebView mWebView;

    public b(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.cGZ = payVcodeActivity;
        payVcodeActivity.setContentView(t.h.pay_vcode_activity);
        o(payVcodeActivity);
    }

    private void o(PayVcodeActivity payVcodeActivity) {
        this.Ye = (ViewGroup) this.cGZ.findViewById(t.g.payvcode_parent);
        this.cHc = (TextView) this.cGZ.findViewById(t.g.payment_performance);
        ar.k(this.cHc, t.f.s_navbar_button_bg);
        ar.b(this.cHc, t.d.cp_cont_i, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(t.g.vcode_webview);
        this.cHd = (TextView) payVcodeActivity.findViewById(t.g.webview_fail_view);
        this.cHa = payVcodeActivity.findViewById(t.g.payvcode_empty_layout);
        this.cHb = (ViewGroup) payVcodeActivity.findViewById(t.g.payvcode_layout);
        this.aNo = (ProgressBar) payVcodeActivity.findViewById(t.g.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView anZ() {
        return this.cHc;
    }

    public TextView aoa() {
        return this.cHd;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void eX(boolean z) {
        this.cHd.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.cGZ.getPageContext(), this.Ye);
        ar.g((View) this.cHd, i);
        ar.k(this.cHc, t.f.s_navbar_button_bg);
        ar.b(this.cHc, t.d.cp_cont_i, 1);
    }

    public View aob() {
        return this.cHa;
    }

    public ViewGroup aoc() {
        return this.cHb;
    }

    public void dB(boolean z) {
        this.aNo.setVisibility(z ? 0 : 8);
    }
}
