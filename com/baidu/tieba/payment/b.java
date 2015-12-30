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
    private PayVcodeActivity cAt;
    private View cAu;
    private ViewGroup cAv;
    private TextView cAw;
    private TextView cAx;
    private ProgressBar mProgress;
    private ViewGroup mRootView;
    private BaseWebView mWebView;

    public b(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.cAt = payVcodeActivity;
        payVcodeActivity.setContentView(n.h.pay_vcode_activity);
        o(payVcodeActivity);
    }

    private void o(PayVcodeActivity payVcodeActivity) {
        this.mRootView = (ViewGroup) this.cAt.findViewById(n.g.payvcode_parent);
        this.cAw = (TextView) this.cAt.findViewById(n.g.payment_performance);
        as.i((View) this.cAw, n.f.s_navbar_button_bg);
        as.b(this.cAw, n.d.cp_cont_i, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(n.g.vcode_webview);
        this.cAx = (TextView) payVcodeActivity.findViewById(n.g.webview_fail_view);
        this.cAu = payVcodeActivity.findViewById(n.g.payvcode_empty_layout);
        this.cAv = (ViewGroup) payVcodeActivity.findViewById(n.g.payvcode_layout);
        this.mProgress = (ProgressBar) payVcodeActivity.findViewById(n.g.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView akb() {
        return this.cAw;
    }

    public TextView akc() {
        return this.cAx;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void eJ(boolean z) {
        this.cAx.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.cAt.getPageContext(), this.mRootView);
        as.e((View) this.cAx, i);
        as.i((View) this.cAw, n.f.s_navbar_button_bg);
        as.b(this.cAw, n.d.cp_cont_i, 1);
    }

    public View akd() {
        return this.cAu;
    }

    public ViewGroup ake() {
        return this.cAv;
    }

    public void dy(boolean z) {
        this.mProgress.setVisibility(z ? 0 : 8);
    }
}
