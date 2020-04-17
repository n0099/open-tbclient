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
    private View jsI;
    private ViewStub jsK;
    private PbGiftListView jsL;
    private ViewStub jsM;
    private LinearLayout jsN;
    public View jsO;
    public BaseWebView jsP;
    private int fXQ = 0;
    private int jsJ = 0;

    public r(View view) {
        this.jsI = view;
        this.jsK = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.jsM = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void zv(int i) {
        this.jsJ = i;
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, String str, String str2, long j, long j2, long j3) {
        if (arVar == null || com.baidu.tbadk.core.util.v.isEmpty(arVar.aJC()) || this.jsK == null) {
            if (this.jsL != null) {
                this.jsL.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jsL == null) {
            this.jsL = (PbGiftListView) this.jsK.inflate();
        }
        this.jsL.setVisibility(0);
        this.jsL.a(arVar, str, str2, j, j2, j3);
        this.jsL.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl())) {
            if ((this.jsP == null || !this.jsP.getIsLoaded()) && agVar.aJg() == com.baidu.tbadk.core.data.ag.doJ && this.jsM != null) {
                if (agVar.aJh()) {
                    if (this.jsN != null) {
                        this.jsN.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.jsN == null) {
                    this.jsN = (LinearLayout) this.jsM.inflate();
                    this.jsO = this.jsN.findViewById(R.id.link_thread_divider);
                    this.jsP = (BaseWebView) this.jsN.findViewById(R.id.link_thread_webview);
                }
                this.jsO.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jsO, R.color.cp_bg_line_c);
                this.jsP.setVisibility(0);
                this.jsP.setFocusable(false);
                this.jsP.setBackgroundColor(0);
                this.jsP.getSettings().setCacheMode(-1);
                this.jsP.setVerticalScrollBarEnabled(false);
                this.jsP.setHorizontalScrollBarEnabled(false);
                this.jsP.getSettings().setAllowFileAccess(true);
                this.jsP.getSettings().setAppCacheEnabled(true);
                this.jsP.getSettings().setDomStorageEnabled(true);
                this.jsP.getSettings().setDatabaseEnabled(true);
                this.jsP.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.r.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.jsP.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.r.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.jsP.loadUrl(agVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.jsP != null) {
            this.jsP.removeAllViews();
            this.jsP.getSettings().setBuiltInZoomControls(true);
            this.jsP.setVisibility(8);
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.r.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (r.this.jsP != null) {
                            r.this.jsP.destroy();
                            r.this.jsP = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.jsP != null) {
            try {
                this.jsP.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.jsP != null) {
            try {
                this.jsP.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
