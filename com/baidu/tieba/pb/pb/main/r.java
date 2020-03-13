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
    private View iHa;
    private ViewStub iHc;
    private PbGiftListView iHd;
    private ViewStub iHe;
    private LinearLayout iHf;
    public View iHg;
    public BaseWebView iHh;
    private int fsW = 0;
    private int iHb = 0;

    public r(View view) {
        this.iHa = view;
        this.iHc = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.iHe = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void yM(int i) {
        this.iHb = i;
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, String str, String str2, long j, long j2, long j3) {
        if (arVar == null || com.baidu.tbadk.core.util.v.isEmpty(arVar.aBm()) || this.iHc == null) {
            if (this.iHd != null) {
                this.iHd.setVisibility(8);
                return;
            }
            return;
        }
        if (this.iHd == null) {
            this.iHd = (PbGiftListView) this.iHc.inflate();
        }
        this.iHd.setVisibility(0);
        this.iHd.a(arVar, str, str2, j, j2, j3);
        this.iHd.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl())) {
            if ((this.iHh == null || !this.iHh.getIsLoaded()) && agVar.aAQ() == com.baidu.tbadk.core.data.ag.cPq && this.iHe != null) {
                if (agVar.aAR()) {
                    if (this.iHf != null) {
                        this.iHf.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.iHf == null) {
                    this.iHf = (LinearLayout) this.iHe.inflate();
                    this.iHg = this.iHf.findViewById(R.id.link_thread_divider);
                    this.iHh = (BaseWebView) this.iHf.findViewById(R.id.link_thread_webview);
                }
                this.iHg.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iHg, R.color.cp_bg_line_c);
                this.iHh.setVisibility(0);
                this.iHh.setFocusable(false);
                this.iHh.setBackgroundColor(0);
                this.iHh.getSettings().setCacheMode(-1);
                this.iHh.setVerticalScrollBarEnabled(false);
                this.iHh.setHorizontalScrollBarEnabled(false);
                this.iHh.getSettings().setAllowFileAccess(true);
                this.iHh.getSettings().setAppCacheEnabled(true);
                this.iHh.getSettings().setDomStorageEnabled(true);
                this.iHh.getSettings().setDatabaseEnabled(true);
                this.iHh.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.r.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.iHh.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.r.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.iHh.loadUrl(agVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.iHh != null) {
            this.iHh.removeAllViews();
            this.iHh.getSettings().setBuiltInZoomControls(true);
            this.iHh.setVisibility(8);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.r.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (r.this.iHh != null) {
                            r.this.iHh.destroy();
                            r.this.iHh = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.iHh != null) {
            try {
                this.iHh.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.iHh != null) {
            try {
                this.iHh.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
