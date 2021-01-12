package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
/* loaded from: classes2.dex */
public class q {
    private View lHK;
    private ViewStub lHM;
    private PbGiftListView lHN;
    private ViewStub lHO;
    private LinearLayout lHP;
    public View lHQ;
    public BaseWebView lHR;
    private int lHJ = 0;
    private int lHL = 0;

    public q(View view) {
        this.lHK = view;
        this.lHM = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.lHO = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void Fn(int i) {
        this.lHL = i;
    }

    public void a(az azVar, String str, String str2, long j, long j2, long j3) {
        if (azVar == null || com.baidu.tbadk.core.util.x.isEmpty(azVar.bmo()) || this.lHM == null) {
            if (this.lHN != null) {
                this.lHN.setVisibility(8);
                return;
            }
            return;
        }
        if (this.lHN == null) {
            this.lHN = (PbGiftListView) this.lHM.inflate();
        }
        this.lHN.setVisibility(0);
        this.lHN.a(azVar, str, str2, j, j2, j3);
        this.lHN.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null && !com.baidu.tbadk.core.util.at.isEmpty(aoVar.getLinkUrl())) {
            if ((this.lHR == null || !this.lHR.getIsLoaded()) && aoVar.blQ() == com.baidu.tbadk.core.data.ao.eLP && this.lHO != null) {
                if (aoVar.blR()) {
                    if (this.lHP != null) {
                        this.lHP.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.lHP == null) {
                    this.lHP = (LinearLayout) this.lHO.inflate();
                    this.lHQ = this.lHP.findViewById(R.id.link_thread_divider);
                    this.lHR = (BaseWebView) this.lHP.findViewById(R.id.link_thread_webview);
                }
                this.lHQ.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lHQ, R.color.CAM_X0204);
                this.lHR.setVisibility(0);
                this.lHR.setFocusable(false);
                this.lHR.setBackgroundColor(0);
                this.lHR.getSettings().setCacheMode(-1);
                this.lHR.setVerticalScrollBarEnabled(false);
                this.lHR.setHorizontalScrollBarEnabled(false);
                this.lHR.getSettings().setAllowFileAccess(true);
                this.lHR.getSettings().setAppCacheEnabled(true);
                this.lHR.getSettings().setDomStorageEnabled(true);
                this.lHR.getSettings().setDatabaseEnabled(true);
                this.lHR.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.lHR.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.lHR.loadUrl(aoVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.lHR != null) {
            this.lHR.removeAllViews();
            this.lHR.getSettings().setBuiltInZoomControls(true);
            this.lHR.setVisibility(8);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.lHR != null) {
                            q.this.lHR.destroy();
                            q.this.lHR = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.lHR != null) {
            try {
                this.lHR.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.lHR != null) {
            try {
                this.lHR.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
