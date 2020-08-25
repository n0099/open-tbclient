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
    private View kCG;
    private ViewStub kCI;
    private PbGiftListView kCJ;
    private ViewStub kCK;
    private LinearLayout kCL;
    public View kCM;
    public BaseWebView kCN;
    private int kCF = 0;
    private int kCH = 0;

    public u(View view) {
        this.kCG = view;
        this.kCI = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.kCK = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void Eb(int i) {
        this.kCH = i;
    }

    public void a(com.baidu.tbadk.core.data.ax axVar, String str, String str2, long j, long j2, long j3) {
        if (axVar == null || com.baidu.tbadk.core.util.y.isEmpty(axVar.bdw()) || this.kCI == null) {
            if (this.kCJ != null) {
                this.kCJ.setVisibility(8);
                return;
            }
            return;
        }
        if (this.kCJ == null) {
            this.kCJ = (PbGiftListView) this.kCI.inflate();
        }
        this.kCJ.setVisibility(0);
        this.kCJ.a(axVar, str, str2, j, j2, j3);
        this.kCJ.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl())) {
            if ((this.kCN == null || !this.kCN.getIsLoaded()) && amVar.bcZ() == com.baidu.tbadk.core.data.am.dYL && this.kCK != null) {
                if (amVar.bda()) {
                    if (this.kCL != null) {
                        this.kCL.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.kCL == null) {
                    this.kCL = (LinearLayout) this.kCK.inflate();
                    this.kCM = this.kCL.findViewById(R.id.link_thread_divider);
                    this.kCN = (BaseWebView) this.kCL.findViewById(R.id.link_thread_webview);
                }
                this.kCM.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kCM, R.color.cp_bg_line_c);
                this.kCN.setVisibility(0);
                this.kCN.setFocusable(false);
                this.kCN.setBackgroundColor(0);
                this.kCN.getSettings().setCacheMode(-1);
                this.kCN.setVerticalScrollBarEnabled(false);
                this.kCN.setHorizontalScrollBarEnabled(false);
                this.kCN.getSettings().setAllowFileAccess(true);
                this.kCN.getSettings().setAppCacheEnabled(true);
                this.kCN.getSettings().setDomStorageEnabled(true);
                this.kCN.getSettings().setDatabaseEnabled(true);
                this.kCN.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.kCN.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.u.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.kCN.loadUrl(amVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.kCN != null) {
            this.kCN.removeAllViews();
            this.kCN.getSettings().setBuiltInZoomControls(true);
            this.kCN.setVisibility(8);
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.u.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (u.this.kCN != null) {
                            u.this.kCN.destroy();
                            u.this.kCN = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.kCN != null) {
            try {
                this.kCN.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.kCN != null) {
            try {
                this.kCN.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
