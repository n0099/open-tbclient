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
    private View lGY;
    private ViewStub lHa;
    private PbGiftListView lHb;
    private ViewStub lHc;
    private LinearLayout lHd;
    public View lHe;
    public BaseWebView lHf;
    private int lGX = 0;
    private int lGZ = 0;

    public u(View view) {
        this.lGY = view;
        this.lHa = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.lHc = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void Hb(int i) {
        this.lGZ = i;
    }

    public void a(com.baidu.tbadk.core.data.az azVar, String str, String str2, long j, long j2, long j3) {
        if (azVar == null || com.baidu.tbadk.core.util.y.isEmpty(azVar.bnH()) || this.lHa == null) {
            if (this.lHb != null) {
                this.lHb.setVisibility(8);
                return;
            }
            return;
        }
        if (this.lHb == null) {
            this.lHb = (PbGiftListView) this.lHa.inflate();
        }
        this.lHb.setVisibility(0);
        this.lHb.a(azVar, str, str2, j, j2, j3);
        this.lHb.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null && !com.baidu.tbadk.core.util.au.isEmpty(aoVar.getLinkUrl())) {
            if ((this.lHf == null || !this.lHf.getIsLoaded()) && aoVar.bnk() == com.baidu.tbadk.core.data.ao.eGK && this.lHc != null) {
                if (aoVar.bnl()) {
                    if (this.lHd != null) {
                        this.lHd.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.lHd == null) {
                    this.lHd = (LinearLayout) this.lHc.inflate();
                    this.lHe = this.lHd.findViewById(R.id.link_thread_divider);
                    this.lHf = (BaseWebView) this.lHd.findViewById(R.id.link_thread_webview);
                }
                this.lHe.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lHe, R.color.CAM_X0204);
                this.lHf.setVisibility(0);
                this.lHf.setFocusable(false);
                this.lHf.setBackgroundColor(0);
                this.lHf.getSettings().setCacheMode(-1);
                this.lHf.setVerticalScrollBarEnabled(false);
                this.lHf.setHorizontalScrollBarEnabled(false);
                this.lHf.getSettings().setAllowFileAccess(true);
                this.lHf.getSettings().setAppCacheEnabled(true);
                this.lHf.getSettings().setDomStorageEnabled(true);
                this.lHf.getSettings().setDatabaseEnabled(true);
                this.lHf.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.lHf.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.u.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.lHf.loadUrl(aoVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.lHf != null) {
            this.lHf.removeAllViews();
            this.lHf.getSettings().setBuiltInZoomControls(true);
            this.lHf.setVisibility(8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.u.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (u.this.lHf != null) {
                            u.this.lHf.destroy();
                            u.this.lHf = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.lHf != null) {
            try {
                this.lHf.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.lHf != null) {
            try {
                this.lHf.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
