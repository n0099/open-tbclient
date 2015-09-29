package com.baidu.tieba.payment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PayVcodeActivity> {
    private PayVcodeActivity cdF;
    private View cdG;
    private ViewGroup cdH;
    private TextView cdI;
    private TextView cdJ;
    private ProgressBar mProgress;
    private ViewGroup mRootView;
    private BaseWebView mWebView;

    public b(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        this.cdF = payVcodeActivity;
        payVcodeActivity.setContentView(i.g.pay_vcode_activity);
        n(payVcodeActivity);
    }

    private void n(PayVcodeActivity payVcodeActivity) {
        this.mRootView = (ViewGroup) this.cdF.findViewById(i.f.payvcode_parent);
        this.cdI = (TextView) this.cdF.findViewById(i.f.payment_performance);
        am.i((View) this.cdI, i.e.s_navbar_button_bg);
        am.b(this.cdI, i.c.cp_cont_i, 1);
        this.mWebView = (BaseWebView) payVcodeActivity.findViewById(i.f.vcode_webview);
        this.cdJ = (TextView) payVcodeActivity.findViewById(i.f.webview_fail_view);
        this.cdG = payVcodeActivity.findViewById(i.f.payvcode_empty_layout);
        this.cdH = (ViewGroup) payVcodeActivity.findViewById(i.f.payvcode_layout);
        this.mProgress = (ProgressBar) payVcodeActivity.findViewById(i.f.payvcode_progress);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setScrollBarStyle(33554432);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public TextView ael() {
        return this.cdI;
    }

    public TextView aem() {
        return this.cdJ;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void eg(boolean z) {
        this.cdJ.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.cdF.getPageContext(), this.mRootView);
        am.e((View) this.cdJ, i);
        am.i((View) this.cdI, i.e.s_navbar_button_bg);
        am.b(this.cdI, i.c.cp_cont_i, 1);
    }

    public View aen() {
        return this.cdG;
    }

    public ViewGroup aeo() {
        return this.cdH;
    }

    public void da(boolean z) {
        this.mProgress.setVisibility(z ? 0 : 8);
    }
}
