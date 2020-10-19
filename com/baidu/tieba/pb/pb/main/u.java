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
    private PbGiftListView laA;
    private ViewStub laB;
    private LinearLayout laC;
    public View laD;
    public BaseWebView laE;
    private View lax;
    private ViewStub laz;
    private int law = 0;
    private int lay = 0;

    public u(View view) {
        this.lax = view;
        this.laz = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.laB = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void Fi(int i) {
        this.lay = i;
    }

    public void a(com.baidu.tbadk.core.data.ax axVar, String str, String str2, long j, long j2, long j3) {
        if (axVar == null || com.baidu.tbadk.core.util.y.isEmpty(axVar.bgZ()) || this.laz == null) {
            if (this.laA != null) {
                this.laA.setVisibility(8);
                return;
            }
            return;
        }
        if (this.laA == null) {
            this.laA = (PbGiftListView) this.laz.inflate();
        }
        this.laA.setVisibility(0);
        this.laA.a(axVar, str, str2, j, j2, j3);
        this.laA.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl())) {
            if ((this.laE == null || !this.laE.getIsLoaded()) && amVar.bgC() == com.baidu.tbadk.core.data.am.enb && this.laB != null) {
                if (amVar.bgD()) {
                    if (this.laC != null) {
                        this.laC.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.laC == null) {
                    this.laC = (LinearLayout) this.laB.inflate();
                    this.laD = this.laC.findViewById(R.id.link_thread_divider);
                    this.laE = (BaseWebView) this.laC.findViewById(R.id.link_thread_webview);
                }
                this.laD.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.laD, R.color.cp_bg_line_c);
                this.laE.setVisibility(0);
                this.laE.setFocusable(false);
                this.laE.setBackgroundColor(0);
                this.laE.getSettings().setCacheMode(-1);
                this.laE.setVerticalScrollBarEnabled(false);
                this.laE.setHorizontalScrollBarEnabled(false);
                this.laE.getSettings().setAllowFileAccess(true);
                this.laE.getSettings().setAppCacheEnabled(true);
                this.laE.getSettings().setDomStorageEnabled(true);
                this.laE.getSettings().setDatabaseEnabled(true);
                this.laE.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.laE.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.u.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.laE.loadUrl(amVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.laE != null) {
            this.laE.removeAllViews();
            this.laE.getSettings().setBuiltInZoomControls(true);
            this.laE.setVisibility(8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.u.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (u.this.laE != null) {
                            u.this.laE.destroy();
                            u.this.laE = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.laE != null) {
            try {
                this.laE.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.laE != null) {
            try {
                this.laE.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
