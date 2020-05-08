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
/* loaded from: classes9.dex */
public class r {
    private View jsM;
    private ViewStub jsO;
    private PbGiftListView jsP;
    private ViewStub jsQ;
    private LinearLayout jsR;
    public View jsS;
    public BaseWebView jsT;
    private int fXV = 0;
    private int jsN = 0;

    public r(View view) {
        this.jsM = view;
        this.jsO = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.jsQ = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void zv(int i) {
        this.jsN = i;
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, String str, String str2, long j, long j2, long j3) {
        if (arVar == null || com.baidu.tbadk.core.util.v.isEmpty(arVar.aJA()) || this.jsO == null) {
            if (this.jsP != null) {
                this.jsP.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jsP == null) {
            this.jsP = (PbGiftListView) this.jsO.inflate();
        }
        this.jsP.setVisibility(0);
        this.jsP.a(arVar, str, str2, j, j2, j3);
        this.jsP.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl())) {
            if ((this.jsT == null || !this.jsT.getIsLoaded()) && agVar.aJe() == com.baidu.tbadk.core.data.ag.doN && this.jsQ != null) {
                if (agVar.aJf()) {
                    if (this.jsR != null) {
                        this.jsR.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.jsR == null) {
                    this.jsR = (LinearLayout) this.jsQ.inflate();
                    this.jsS = this.jsR.findViewById(R.id.link_thread_divider);
                    this.jsT = (BaseWebView) this.jsR.findViewById(R.id.link_thread_webview);
                }
                this.jsS.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jsS, R.color.cp_bg_line_c);
                this.jsT.setVisibility(0);
                this.jsT.setFocusable(false);
                this.jsT.setBackgroundColor(0);
                this.jsT.getSettings().setCacheMode(-1);
                this.jsT.setVerticalScrollBarEnabled(false);
                this.jsT.setHorizontalScrollBarEnabled(false);
                this.jsT.getSettings().setAllowFileAccess(true);
                this.jsT.getSettings().setAppCacheEnabled(true);
                this.jsT.getSettings().setDomStorageEnabled(true);
                this.jsT.getSettings().setDatabaseEnabled(true);
                this.jsT.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.r.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.jsT.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.r.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.jsT.loadUrl(agVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.jsT != null) {
            this.jsT.removeAllViews();
            this.jsT.getSettings().setBuiltInZoomControls(true);
            this.jsT.setVisibility(8);
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.r.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (r.this.jsT != null) {
                            r.this.jsT.destroy();
                            r.this.jsT = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.jsT != null) {
            try {
                this.jsT.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.jsT != null) {
            try {
                this.jsT.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
