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
    private View iGM;
    private ViewStub iGO;
    private PbGiftListView iGP;
    private ViewStub iGQ;
    private LinearLayout iGR;
    public View iGS;
    public BaseWebView iGT;
    private int fsI = 0;
    private int iGN = 0;

    public r(View view) {
        this.iGM = view;
        this.iGO = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.iGQ = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void yM(int i) {
        this.iGN = i;
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, String str, String str2, long j, long j2, long j3) {
        if (arVar == null || com.baidu.tbadk.core.util.v.isEmpty(arVar.aBk()) || this.iGO == null) {
            if (this.iGP != null) {
                this.iGP.setVisibility(8);
                return;
            }
            return;
        }
        if (this.iGP == null) {
            this.iGP = (PbGiftListView) this.iGO.inflate();
        }
        this.iGP.setVisibility(0);
        this.iGP.a(arVar, str, str2, j, j2, j3);
        this.iGP.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl())) {
            if ((this.iGT == null || !this.iGT.getIsLoaded()) && agVar.aAO() == com.baidu.tbadk.core.data.ag.cPo && this.iGQ != null) {
                if (agVar.aAP()) {
                    if (this.iGR != null) {
                        this.iGR.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.iGR == null) {
                    this.iGR = (LinearLayout) this.iGQ.inflate();
                    this.iGS = this.iGR.findViewById(R.id.link_thread_divider);
                    this.iGT = (BaseWebView) this.iGR.findViewById(R.id.link_thread_webview);
                }
                this.iGS.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iGS, R.color.cp_bg_line_c);
                this.iGT.setVisibility(0);
                this.iGT.setFocusable(false);
                this.iGT.setBackgroundColor(0);
                this.iGT.getSettings().setCacheMode(-1);
                this.iGT.setVerticalScrollBarEnabled(false);
                this.iGT.setHorizontalScrollBarEnabled(false);
                this.iGT.getSettings().setAllowFileAccess(true);
                this.iGT.getSettings().setAppCacheEnabled(true);
                this.iGT.getSettings().setDomStorageEnabled(true);
                this.iGT.getSettings().setDatabaseEnabled(true);
                this.iGT.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.r.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.iGT.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.r.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.iGT.loadUrl(agVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.iGT != null) {
            this.iGT.removeAllViews();
            this.iGT.getSettings().setBuiltInZoomControls(true);
            this.iGT.setVisibility(8);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.r.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (r.this.iGT != null) {
                            r.this.iGT.destroy();
                            r.this.iGT = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.iGT != null) {
            try {
                this.iGT.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.iGT != null) {
            try {
                this.iGT.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
