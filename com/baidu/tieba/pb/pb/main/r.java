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
    private View iIB;
    private ViewStub iID;
    private PbGiftListView iIE;
    private ViewStub iIF;
    private LinearLayout iIG;
    public View iIH;
    public BaseWebView iII;
    private int ftw = 0;
    private int iIC = 0;

    public r(View view) {
        this.iIB = view;
        this.iID = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.iIF = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void yU(int i) {
        this.iIC = i;
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, String str, String str2, long j, long j2, long j3) {
        if (arVar == null || com.baidu.tbadk.core.util.v.isEmpty(arVar.aBp()) || this.iID == null) {
            if (this.iIE != null) {
                this.iIE.setVisibility(8);
                return;
            }
            return;
        }
        if (this.iIE == null) {
            this.iIE = (PbGiftListView) this.iID.inflate();
        }
        this.iIE.setVisibility(0);
        this.iIE.a(arVar, str, str2, j, j2, j3);
        this.iIE.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl())) {
            if ((this.iII == null || !this.iII.getIsLoaded()) && agVar.aAT() == com.baidu.tbadk.core.data.ag.cPD && this.iIF != null) {
                if (agVar.aAU()) {
                    if (this.iIG != null) {
                        this.iIG.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.iIG == null) {
                    this.iIG = (LinearLayout) this.iIF.inflate();
                    this.iIH = this.iIG.findViewById(R.id.link_thread_divider);
                    this.iII = (BaseWebView) this.iIG.findViewById(R.id.link_thread_webview);
                }
                this.iIH.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iIH, R.color.cp_bg_line_c);
                this.iII.setVisibility(0);
                this.iII.setFocusable(false);
                this.iII.setBackgroundColor(0);
                this.iII.getSettings().setCacheMode(-1);
                this.iII.setVerticalScrollBarEnabled(false);
                this.iII.setHorizontalScrollBarEnabled(false);
                this.iII.getSettings().setAllowFileAccess(true);
                this.iII.getSettings().setAppCacheEnabled(true);
                this.iII.getSettings().setDomStorageEnabled(true);
                this.iII.getSettings().setDatabaseEnabled(true);
                this.iII.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.r.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.iII.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.r.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.iII.loadUrl(agVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.iII != null) {
            this.iII.removeAllViews();
            this.iII.getSettings().setBuiltInZoomControls(true);
            this.iII.setVisibility(8);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.r.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (r.this.iII != null) {
                            r.this.iII.destroy();
                            r.this.iII = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.iII != null) {
            try {
                this.iII.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.iII != null) {
            try {
                this.iII.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
