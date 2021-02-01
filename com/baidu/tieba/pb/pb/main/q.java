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
    private View lQE;
    private ViewStub lQG;
    private PbGiftListView lQH;
    private ViewStub lQI;
    private LinearLayout lQJ;
    public View lQK;
    public BaseWebView lQL;
    private int lQD = 0;
    private int lQF = 0;

    public q(View view) {
        this.lQE = view;
        this.lQG = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.lQI = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void FG(int i) {
        this.lQF = i;
    }

    public void a(bb bbVar, String str, String str2, long j, long j2, long j3) {
        if (bbVar == null || com.baidu.tbadk.core.util.y.isEmpty(bbVar.bmH()) || this.lQG == null) {
            if (this.lQH != null) {
                this.lQH.setVisibility(8);
                return;
            }
            return;
        }
        if (this.lQH == null) {
            this.lQH = (PbGiftListView) this.lQG.inflate();
        }
        this.lQH.setVisibility(0);
        this.lQH.a(bbVar, str, str2, j, j2, j3);
        this.lQH.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null && !com.baidu.tbadk.core.util.au.isEmpty(apVar.getLinkUrl())) {
            if ((this.lQL == null || !this.lQL.getIsLoaded()) && apVar.bmi() == com.baidu.tbadk.core.data.ap.eOa && this.lQI != null) {
                if (apVar.bmj()) {
                    if (this.lQJ != null) {
                        this.lQJ.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.lQJ == null) {
                    this.lQJ = (LinearLayout) this.lQI.inflate();
                    this.lQK = this.lQJ.findViewById(R.id.link_thread_divider);
                    this.lQL = (BaseWebView) this.lQJ.findViewById(R.id.link_thread_webview);
                }
                this.lQK.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lQK, R.color.CAM_X0204);
                this.lQL.setVisibility(0);
                this.lQL.setFocusable(false);
                this.lQL.setBackgroundColor(0);
                this.lQL.getSettings().setCacheMode(-1);
                this.lQL.setVerticalScrollBarEnabled(false);
                this.lQL.setHorizontalScrollBarEnabled(false);
                this.lQL.getSettings().setAllowFileAccess(true);
                this.lQL.getSettings().setAppCacheEnabled(true);
                this.lQL.getSettings().setDomStorageEnabled(true);
                this.lQL.getSettings().setDatabaseEnabled(true);
                this.lQL.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.lQL.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.lQL.loadUrl(apVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.lQL != null) {
            this.lQL.removeAllViews();
            this.lQL.getSettings().setBuiltInZoomControls(true);
            this.lQL.setVisibility(8);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.lQL != null) {
                            q.this.lQL.destroy();
                            q.this.lQL = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.lQL != null) {
            try {
                this.lQL.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.lQL != null) {
            try {
                this.lQL.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
