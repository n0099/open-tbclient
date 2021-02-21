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
    private View lQT;
    private ViewStub lQV;
    private PbGiftListView lQW;
    private ViewStub lQX;
    private LinearLayout lQY;
    public View lQZ;
    public BaseWebView lRa;
    private int lQS = 0;
    private int lQU = 0;

    public q(View view) {
        this.lQT = view;
        this.lQV = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.lQX = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void FG(int i) {
        this.lQU = i;
    }

    public void a(bb bbVar, String str, String str2, long j, long j2, long j3) {
        if (bbVar == null || com.baidu.tbadk.core.util.y.isEmpty(bbVar.bmH()) || this.lQV == null) {
            if (this.lQW != null) {
                this.lQW.setVisibility(8);
                return;
            }
            return;
        }
        if (this.lQW == null) {
            this.lQW = (PbGiftListView) this.lQV.inflate();
        }
        this.lQW.setVisibility(0);
        this.lQW.a(bbVar, str, str2, j, j2, j3);
        this.lQW.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null && !com.baidu.tbadk.core.util.au.isEmpty(apVar.getLinkUrl())) {
            if ((this.lRa == null || !this.lRa.getIsLoaded()) && apVar.bmi() == com.baidu.tbadk.core.data.ap.eOa && this.lQX != null) {
                if (apVar.bmj()) {
                    if (this.lQY != null) {
                        this.lQY.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.lQY == null) {
                    this.lQY = (LinearLayout) this.lQX.inflate();
                    this.lQZ = this.lQY.findViewById(R.id.link_thread_divider);
                    this.lRa = (BaseWebView) this.lQY.findViewById(R.id.link_thread_webview);
                }
                this.lQZ.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lQZ, R.color.CAM_X0204);
                this.lRa.setVisibility(0);
                this.lRa.setFocusable(false);
                this.lRa.setBackgroundColor(0);
                this.lRa.getSettings().setCacheMode(-1);
                this.lRa.setVerticalScrollBarEnabled(false);
                this.lRa.setHorizontalScrollBarEnabled(false);
                this.lRa.getSettings().setAllowFileAccess(true);
                this.lRa.getSettings().setAppCacheEnabled(true);
                this.lRa.getSettings().setDomStorageEnabled(true);
                this.lRa.getSettings().setDatabaseEnabled(true);
                this.lRa.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.lRa.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.lRa.loadUrl(apVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.lRa != null) {
            this.lRa.removeAllViews();
            this.lRa.getSettings().setBuiltInZoomControls(true);
            this.lRa.setVisibility(8);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.lRa != null) {
                            q.this.lRa.destroy();
                            q.this.lRa = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.lRa != null) {
            try {
                this.lRa.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.lRa != null) {
            try {
                this.lRa.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
