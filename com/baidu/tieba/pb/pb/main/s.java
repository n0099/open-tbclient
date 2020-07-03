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
    private View keA;
    private ViewStub keC;
    private PbGiftListView keD;
    private ViewStub keE;
    private LinearLayout keF;
    public View keG;
    public BaseWebView keH;
    private int kez = 0;
    private int keB = 0;

    public s(View view) {
        this.keA = view;
        this.keC = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.keE = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void Bi(int i) {
        this.keB = i;
    }

    public void a(com.baidu.tbadk.core.data.av avVar, String str, String str2, long j, long j2, long j3) {
        if (avVar == null || com.baidu.tbadk.core.util.w.isEmpty(avVar.aRh()) || this.keC == null) {
            if (this.keD != null) {
                this.keD.setVisibility(8);
                return;
            }
            return;
        }
        if (this.keD == null) {
            this.keD = (PbGiftListView) this.keC.inflate();
        }
        this.keD.setVisibility(0);
        this.keD.a(avVar, str, str2, j, j2, j3);
        this.keD.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ak akVar) {
        if (akVar != null && !com.baidu.tbadk.core.util.ar.isEmpty(akVar.getLinkUrl())) {
            if ((this.keH == null || !this.keH.getIsLoaded()) && akVar.aQK() == com.baidu.tbadk.core.data.ak.dJh && this.keE != null) {
                if (akVar.aQL()) {
                    if (this.keF != null) {
                        this.keF.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.keF == null) {
                    this.keF = (LinearLayout) this.keE.inflate();
                    this.keG = this.keF.findViewById(R.id.link_thread_divider);
                    this.keH = (BaseWebView) this.keF.findViewById(R.id.link_thread_webview);
                }
                this.keG.setVisibility(0);
                com.baidu.tbadk.core.util.an.setBackgroundColor(this.keG, R.color.cp_bg_line_c);
                this.keH.setVisibility(0);
                this.keH.setFocusable(false);
                this.keH.setBackgroundColor(0);
                this.keH.getSettings().setCacheMode(-1);
                this.keH.setVerticalScrollBarEnabled(false);
                this.keH.setHorizontalScrollBarEnabled(false);
                this.keH.getSettings().setAllowFileAccess(true);
                this.keH.getSettings().setAppCacheEnabled(true);
                this.keH.getSettings().setDomStorageEnabled(true);
                this.keH.getSettings().setDatabaseEnabled(true);
                this.keH.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.s.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.keH.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.s.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.keH.loadUrl(akVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.keH != null) {
            this.keH.removeAllViews();
            this.keH.getSettings().setBuiltInZoomControls(true);
            this.keH.setVisibility(8);
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.s.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (s.this.keH != null) {
                            s.this.keH.destroy();
                            s.this.keH = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.keH != null) {
            try {
                this.keH.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.keH != null) {
            try {
                this.keH.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
