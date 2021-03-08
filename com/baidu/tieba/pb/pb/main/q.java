package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
/* loaded from: classes2.dex */
public class q {
    private View lSV;
    private ViewStub lSX;
    private PbGiftListView lSY;
    private ViewStub lSZ;
    private LinearLayout lTa;
    public View lTb;
    public BaseWebView lTc;
    private int lSU = 0;
    private int lSW = 0;

    public q(View view) {
        this.lSV = view;
        this.lSX = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.lSZ = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void FJ(int i) {
        this.lSW = i;
    }

    public void a(bb bbVar, String str, String str2, long j, long j2, long j3) {
        if (bbVar == null || com.baidu.tbadk.core.util.y.isEmpty(bbVar.bmJ()) || this.lSX == null) {
            if (this.lSY != null) {
                this.lSY.setVisibility(8);
                return;
            }
            return;
        }
        if (this.lSY == null) {
            this.lSY = (PbGiftListView) this.lSX.inflate();
        }
        this.lSY.setVisibility(0);
        this.lSY.a(bbVar, str, str2, j, j2, j3);
        this.lSY.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null && !com.baidu.tbadk.core.util.au.isEmpty(apVar.getLinkUrl())) {
            if ((this.lTc == null || !this.lTc.getIsLoaded()) && apVar.bmk() == com.baidu.tbadk.core.data.ap.ePB && this.lSZ != null) {
                if (apVar.bml()) {
                    if (this.lTa != null) {
                        this.lTa.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.lTa == null) {
                    this.lTa = (LinearLayout) this.lSZ.inflate();
                    this.lTb = this.lTa.findViewById(R.id.link_thread_divider);
                    this.lTc = (BaseWebView) this.lTa.findViewById(R.id.link_thread_webview);
                }
                this.lTb.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lTb, R.color.CAM_X0204);
                this.lTc.setVisibility(0);
                this.lTc.setFocusable(false);
                this.lTc.setBackgroundColor(0);
                this.lTc.getSettings().setCacheMode(-1);
                this.lTc.setVerticalScrollBarEnabled(false);
                this.lTc.setHorizontalScrollBarEnabled(false);
                this.lTc.getSettings().setAllowFileAccess(true);
                this.lTc.getSettings().setAppCacheEnabled(true);
                this.lTc.getSettings().setDomStorageEnabled(true);
                this.lTc.getSettings().setDatabaseEnabled(true);
                this.lTc.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.lTc.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.lTc.loadUrl(apVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.lTc != null) {
            this.lTc.removeAllViews();
            this.lTc.getSettings().setBuiltInZoomControls(true);
            this.lTc.setVisibility(8);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.lTc != null) {
                            q.this.lTc.destroy();
                            q.this.lTc = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.lTc != null) {
            try {
                this.lTc.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.lTc != null) {
            try {
                this.lTc.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
