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
    private View iGO;
    private ViewStub iGQ;
    private PbGiftListView iGR;
    private ViewStub iGS;
    private LinearLayout iGT;
    public View iGU;
    public BaseWebView iGV;
    private int fsJ = 0;
    private int iGP = 0;

    public r(View view) {
        this.iGO = view;
        this.iGQ = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.iGS = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void yM(int i) {
        this.iGP = i;
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, String str, String str2, long j, long j2, long j3) {
        if (arVar == null || com.baidu.tbadk.core.util.v.isEmpty(arVar.aBm()) || this.iGQ == null) {
            if (this.iGR != null) {
                this.iGR.setVisibility(8);
                return;
            }
            return;
        }
        if (this.iGR == null) {
            this.iGR = (PbGiftListView) this.iGQ.inflate();
        }
        this.iGR.setVisibility(0);
        this.iGR.a(arVar, str, str2, j, j2, j3);
        this.iGR.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl())) {
            if ((this.iGV == null || !this.iGV.getIsLoaded()) && agVar.aAQ() == com.baidu.tbadk.core.data.ag.cPp && this.iGS != null) {
                if (agVar.aAR()) {
                    if (this.iGT != null) {
                        this.iGT.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.iGT == null) {
                    this.iGT = (LinearLayout) this.iGS.inflate();
                    this.iGU = this.iGT.findViewById(R.id.link_thread_divider);
                    this.iGV = (BaseWebView) this.iGT.findViewById(R.id.link_thread_webview);
                }
                this.iGU.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iGU, R.color.cp_bg_line_c);
                this.iGV.setVisibility(0);
                this.iGV.setFocusable(false);
                this.iGV.setBackgroundColor(0);
                this.iGV.getSettings().setCacheMode(-1);
                this.iGV.setVerticalScrollBarEnabled(false);
                this.iGV.setHorizontalScrollBarEnabled(false);
                this.iGV.getSettings().setAllowFileAccess(true);
                this.iGV.getSettings().setAppCacheEnabled(true);
                this.iGV.getSettings().setDomStorageEnabled(true);
                this.iGV.getSettings().setDatabaseEnabled(true);
                this.iGV.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.r.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.iGV.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.r.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.iGV.loadUrl(agVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.iGV != null) {
            this.iGV.removeAllViews();
            this.iGV.getSettings().setBuiltInZoomControls(true);
            this.iGV.setVisibility(8);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.r.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (r.this.iGV != null) {
                            r.this.iGV.destroy();
                            r.this.iGV = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.iGV != null) {
            try {
                this.iGV.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.iGV != null) {
            try {
                this.iGV.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
