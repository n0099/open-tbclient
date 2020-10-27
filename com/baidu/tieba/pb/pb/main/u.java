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
/* loaded from: classes22.dex */
public class u {
    private View lmV;
    private ViewStub lmX;
    private PbGiftListView lmY;
    private ViewStub lmZ;
    private LinearLayout lna;
    public View lnb;
    public BaseWebView lnc;
    private int lmU = 0;
    private int lmW = 0;

    public u(View view) {
        this.lmV = view;
        this.lmX = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.lmZ = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void FB(int i) {
        this.lmW = i;
    }

    public void a(com.baidu.tbadk.core.data.ax axVar, String str, String str2, long j, long j2, long j3) {
        if (axVar == null || com.baidu.tbadk.core.util.y.isEmpty(axVar.biS()) || this.lmX == null) {
            if (this.lmY != null) {
                this.lmY.setVisibility(8);
                return;
            }
            return;
        }
        if (this.lmY == null) {
            this.lmY = (PbGiftListView) this.lmX.inflate();
        }
        this.lmY.setVisibility(0);
        this.lmY.a(axVar, str, str2, j, j2, j3);
        this.lmY.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl())) {
            if ((this.lnc == null || !this.lnc.getIsLoaded()) && amVar.biv() == com.baidu.tbadk.core.data.am.evB && this.lmZ != null) {
                if (amVar.biw()) {
                    if (this.lna != null) {
                        this.lna.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.lna == null) {
                    this.lna = (LinearLayout) this.lmZ.inflate();
                    this.lnb = this.lna.findViewById(R.id.link_thread_divider);
                    this.lnc = (BaseWebView) this.lna.findViewById(R.id.link_thread_webview);
                }
                this.lnb.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lnb, R.color.cp_bg_line_c);
                this.lnc.setVisibility(0);
                this.lnc.setFocusable(false);
                this.lnc.setBackgroundColor(0);
                this.lnc.getSettings().setCacheMode(-1);
                this.lnc.setVerticalScrollBarEnabled(false);
                this.lnc.setHorizontalScrollBarEnabled(false);
                this.lnc.getSettings().setAllowFileAccess(true);
                this.lnc.getSettings().setAppCacheEnabled(true);
                this.lnc.getSettings().setDomStorageEnabled(true);
                this.lnc.getSettings().setDatabaseEnabled(true);
                this.lnc.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.lnc.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.u.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.lnc.loadUrl(amVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.lnc != null) {
            this.lnc.removeAllViews();
            this.lnc.getSettings().setBuiltInZoomControls(true);
            this.lnc.setVisibility(8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.u.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (u.this.lnc != null) {
                            u.this.lnc.destroy();
                            u.this.lnc = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.lnc != null) {
            try {
                this.lnc.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.lnc != null) {
            try {
                this.lnc.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
