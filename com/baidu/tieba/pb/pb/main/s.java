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
public class s {
    private View jKP;
    private ViewStub jKR;
    private PbGiftListView jKS;
    private ViewStub jKT;
    private LinearLayout jKU;
    public View jKV;
    public BaseWebView jKW;
    private int jKO = 0;
    private int jKQ = 0;

    public s(View view) {
        this.jKP = view;
        this.jKR = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.jKT = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void Ag(int i) {
        this.jKQ = i;
    }

    public void a(com.baidu.tbadk.core.data.aq aqVar, String str, String str2, long j, long j2, long j3) {
        if (aqVar == null || com.baidu.tbadk.core.util.v.isEmpty(aqVar.aPv()) || this.jKR == null) {
            if (this.jKS != null) {
                this.jKS.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jKS == null) {
            this.jKS = (PbGiftListView) this.jKR.inflate();
        }
        this.jKS.setVisibility(0);
        this.jKS.a(aqVar, str, str2, j, j2, j3);
        this.jKS.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl())) {
            if ((this.jKW == null || !this.jKW.getIsLoaded()) && afVar.aOZ() == com.baidu.tbadk.core.data.af.dCM && this.jKT != null) {
                if (afVar.aPa()) {
                    if (this.jKU != null) {
                        this.jKU.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.jKU == null) {
                    this.jKU = (LinearLayout) this.jKT.inflate();
                    this.jKV = this.jKU.findViewById(R.id.link_thread_divider);
                    this.jKW = (BaseWebView) this.jKU.findViewById(R.id.link_thread_webview);
                }
                this.jKV.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jKV, R.color.cp_bg_line_c);
                this.jKW.setVisibility(0);
                this.jKW.setFocusable(false);
                this.jKW.setBackgroundColor(0);
                this.jKW.getSettings().setCacheMode(-1);
                this.jKW.setVerticalScrollBarEnabled(false);
                this.jKW.setHorizontalScrollBarEnabled(false);
                this.jKW.getSettings().setAllowFileAccess(true);
                this.jKW.getSettings().setAppCacheEnabled(true);
                this.jKW.getSettings().setDomStorageEnabled(true);
                this.jKW.getSettings().setDatabaseEnabled(true);
                this.jKW.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.s.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.jKW.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.s.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.jKW.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.jKW != null) {
            this.jKW.removeAllViews();
            this.jKW.getSettings().setBuiltInZoomControls(true);
            this.jKW.setVisibility(8);
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.s.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (s.this.jKW != null) {
                            s.this.jKW.destroy();
                            s.this.jKW = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.jKW != null) {
            try {
                this.jKW.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.jKW != null) {
            try {
                this.jKW.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
