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
/* loaded from: classes6.dex */
public class s {
    private View iBE;
    private ViewStub iBG;
    private PbGiftListView iBH;
    private ViewStub iBI;
    private LinearLayout iBJ;
    public View iBK;
    public BaseWebView iBL;
    private int fmV = 0;
    private int iBF = 0;

    public s(View view) {
        this.iBE = view;
        this.iBG = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.iBI = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void yA(int i) {
        this.iBF = i;
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, String str, String str2, long j, long j2, long j3) {
        if (arVar == null || com.baidu.tbadk.core.util.v.isEmpty(arVar.ayA()) || this.iBG == null) {
            if (this.iBH != null) {
                this.iBH.setVisibility(8);
                return;
            }
            return;
        }
        if (this.iBH == null) {
            this.iBH = (PbGiftListView) this.iBG.inflate();
        }
        this.iBH.setVisibility(0);
        this.iBH.a(arVar, str, str2, j, j2, j3);
        this.iBH.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl())) {
            if ((this.iBL == null || !this.iBL.getIsLoaded()) && agVar.ayh() == com.baidu.tbadk.core.data.ag.cLb && this.iBI != null) {
                if (agVar.ayi()) {
                    if (this.iBJ != null) {
                        this.iBJ.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.iBJ == null) {
                    this.iBJ = (LinearLayout) this.iBI.inflate();
                    this.iBK = this.iBJ.findViewById(R.id.link_thread_divider);
                    this.iBL = (BaseWebView) this.iBJ.findViewById(R.id.link_thread_webview);
                }
                this.iBK.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iBK, R.color.cp_bg_line_c);
                this.iBL.setVisibility(0);
                this.iBL.setFocusable(false);
                this.iBL.setBackgroundColor(0);
                this.iBL.getSettings().setCacheMode(-1);
                this.iBL.setVerticalScrollBarEnabled(false);
                this.iBL.setHorizontalScrollBarEnabled(false);
                this.iBL.getSettings().setAllowFileAccess(true);
                this.iBL.getSettings().setAppCacheEnabled(true);
                this.iBL.getSettings().setDomStorageEnabled(true);
                this.iBL.getSettings().setDatabaseEnabled(true);
                this.iBL.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.s.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.iBL.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.s.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.iBL.loadUrl(agVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.iBL != null) {
            this.iBL.removeAllViews();
            this.iBL.getSettings().setBuiltInZoomControls(true);
            this.iBL.setVisibility(8);
            com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.s.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (s.this.iBL != null) {
                            s.this.iBL.destroy();
                            s.this.iBL = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.iBL != null) {
            try {
                this.iBL.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.iBL != null) {
            try {
                this.iBL.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
