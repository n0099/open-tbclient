package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
/* loaded from: classes16.dex */
public class u {
    private View kCN;
    private ViewStub kCP;
    private PbGiftListView kCQ;
    private ViewStub kCR;
    private LinearLayout kCS;
    public View kCT;
    public BaseWebView kCU;
    private int kCM = 0;
    private int kCO = 0;

    public u(View view) {
        this.kCN = view;
        this.kCP = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.kCR = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void Eb(int i) {
        this.kCO = i;
    }

    public void a(com.baidu.tbadk.core.data.ax axVar, String str, String str2, long j, long j2, long j3) {
        if (axVar == null || com.baidu.tbadk.core.util.y.isEmpty(axVar.bdw()) || this.kCP == null) {
            if (this.kCQ != null) {
                this.kCQ.setVisibility(8);
                return;
            }
            return;
        }
        if (this.kCQ == null) {
            this.kCQ = (PbGiftListView) this.kCP.inflate();
        }
        this.kCQ.setVisibility(0);
        this.kCQ.a(axVar, str, str2, j, j2, j3);
        this.kCQ.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl())) {
            if ((this.kCU == null || !this.kCU.getIsLoaded()) && amVar.bcZ() == com.baidu.tbadk.core.data.am.dYP && this.kCR != null) {
                if (amVar.bda()) {
                    if (this.kCS != null) {
                        this.kCS.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.kCS == null) {
                    this.kCS = (LinearLayout) this.kCR.inflate();
                    this.kCT = this.kCS.findViewById(R.id.link_thread_divider);
                    this.kCU = (BaseWebView) this.kCS.findViewById(R.id.link_thread_webview);
                }
                this.kCT.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kCT, R.color.cp_bg_line_c);
                this.kCU.setVisibility(0);
                this.kCU.setFocusable(false);
                this.kCU.setBackgroundColor(0);
                this.kCU.getSettings().setCacheMode(-1);
                this.kCU.setVerticalScrollBarEnabled(false);
                this.kCU.setHorizontalScrollBarEnabled(false);
                this.kCU.getSettings().setAllowFileAccess(true);
                this.kCU.getSettings().setAppCacheEnabled(true);
                this.kCU.getSettings().setDomStorageEnabled(true);
                this.kCU.getSettings().setDatabaseEnabled(true);
                this.kCU.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.kCU.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.u.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.kCU.loadUrl(amVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.kCU != null) {
            this.kCU.removeAllViews();
            this.kCU.getSettings().setBuiltInZoomControls(true);
            this.kCU.setVisibility(8);
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.u.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (u.this.kCU != null) {
                            u.this.kCU.destroy();
                            u.this.kCU = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.kCU != null) {
            try {
                this.kCU.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.kCU != null) {
            try {
                this.kCU.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
