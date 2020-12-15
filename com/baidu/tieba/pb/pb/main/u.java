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
    private View lHa;
    private ViewStub lHc;
    private PbGiftListView lHd;
    private ViewStub lHe;
    private LinearLayout lHf;
    public View lHg;
    public BaseWebView lHh;
    private int lGZ = 0;
    private int lHb = 0;

    public u(View view) {
        this.lHa = view;
        this.lHc = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.lHe = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void Hb(int i) {
        this.lHb = i;
    }

    public void a(com.baidu.tbadk.core.data.az azVar, String str, String str2, long j, long j2, long j3) {
        if (azVar == null || com.baidu.tbadk.core.util.y.isEmpty(azVar.bnH()) || this.lHc == null) {
            if (this.lHd != null) {
                this.lHd.setVisibility(8);
                return;
            }
            return;
        }
        if (this.lHd == null) {
            this.lHd = (PbGiftListView) this.lHc.inflate();
        }
        this.lHd.setVisibility(0);
        this.lHd.a(azVar, str, str2, j, j2, j3);
        this.lHd.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null && !com.baidu.tbadk.core.util.au.isEmpty(aoVar.getLinkUrl())) {
            if ((this.lHh == null || !this.lHh.getIsLoaded()) && aoVar.bnk() == com.baidu.tbadk.core.data.ao.eGK && this.lHe != null) {
                if (aoVar.bnl()) {
                    if (this.lHf != null) {
                        this.lHf.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.lHf == null) {
                    this.lHf = (LinearLayout) this.lHe.inflate();
                    this.lHg = this.lHf.findViewById(R.id.link_thread_divider);
                    this.lHh = (BaseWebView) this.lHf.findViewById(R.id.link_thread_webview);
                }
                this.lHg.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lHg, R.color.CAM_X0204);
                this.lHh.setVisibility(0);
                this.lHh.setFocusable(false);
                this.lHh.setBackgroundColor(0);
                this.lHh.getSettings().setCacheMode(-1);
                this.lHh.setVerticalScrollBarEnabled(false);
                this.lHh.setHorizontalScrollBarEnabled(false);
                this.lHh.getSettings().setAllowFileAccess(true);
                this.lHh.getSettings().setAppCacheEnabled(true);
                this.lHh.getSettings().setDomStorageEnabled(true);
                this.lHh.getSettings().setDatabaseEnabled(true);
                this.lHh.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.lHh.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.u.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.lHh.loadUrl(aoVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.lHh != null) {
            this.lHh.removeAllViews();
            this.lHh.getSettings().setBuiltInZoomControls(true);
            this.lHh.setVisibility(8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.u.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (u.this.lHh != null) {
                            u.this.lHh.destroy();
                            u.this.lHh = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.lHh != null) {
            try {
                this.lHh.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.lHh != null) {
            try {
                this.lHh.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
