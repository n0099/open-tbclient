package com.baidu.tieba.payment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PayVcodeActivity> {
    private PayVcodeActivity cwP;
    private View cwQ;
    private ViewGroup cwR;
    private TextView cwS;
    private TextView cwT;
    private ProgressBar mProgress;
    private ViewGroup mRootView;
    private BaseWebView mWebView;

    public b(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.cwP = payVcodeActivity;
        payVcodeActivity.setContentView(n.g.pay_vcode_activity);
        o(payVcodeActivity);
    }

    private void o(PayVcodeActivity payVcodeActivity) {
        this.mRootView = (ViewGroup) this.cwP.findViewById(n.f.payvcode_parent);
        this.cwS = (TextView) this.cwP.findViewById(n.f.payment_performance);
        as.i((View) this.cwS, n.e.s_navbar_button_bg);
        as.b(this.cwS, n.c.cp_cont_i, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(n.f.vcode_webview);
        this.cwT = (TextView) payVcodeActivity.findViewById(n.f.webview_fail_view);
        this.cwQ = payVcodeActivity.findViewById(n.f.payvcode_empty_layout);
        this.cwR = (ViewGroup) payVcodeActivity.findViewById(n.f.payvcode_layout);
        this.mProgress = (ProgressBar) payVcodeActivity.findViewById(n.f.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView aiV() {
        return this.cwS;
    }

    public TextView aiW() {
        return this.cwT;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void eK(boolean z) {
        this.cwT.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.cwP.getPageContext(), this.mRootView);
        as.e((View) this.cwT, i);
        as.i((View) this.cwS, n.e.s_navbar_button_bg);
        as.b(this.cwS, n.c.cp_cont_i, 1);
    }

    public View aiX() {
        return this.cwQ;
    }

    public ViewGroup aiY() {
        return this.cwR;
    }

    public void dy(boolean z) {
        this.mProgress.setVisibility(z ? 0 : 8);
    }
}
