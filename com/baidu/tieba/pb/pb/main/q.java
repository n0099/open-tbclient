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
    private View lMp;
    private ViewStub lMr;
    private PbGiftListView lMs;
    private ViewStub lMt;
    private LinearLayout lMu;
    public View lMv;
    public BaseWebView lMw;
    private int lMo = 0;
    private int lMq = 0;

    public q(View view) {
        this.lMp = view;
        this.lMr = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.lMt = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void GT(int i) {
        this.lMq = i;
    }

    public void a(az azVar, String str, String str2, long j, long j2, long j3) {
        if (azVar == null || com.baidu.tbadk.core.util.x.isEmpty(azVar.bqh()) || this.lMr == null) {
            if (this.lMs != null) {
                this.lMs.setVisibility(8);
                return;
            }
            return;
        }
        if (this.lMs == null) {
            this.lMs = (PbGiftListView) this.lMr.inflate();
        }
        this.lMs.setVisibility(0);
        this.lMs.a(azVar, str, str2, j, j2, j3);
        this.lMs.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null && !com.baidu.tbadk.core.util.at.isEmpty(aoVar.getLinkUrl())) {
            if ((this.lMw == null || !this.lMw.getIsLoaded()) && aoVar.bpJ() == com.baidu.tbadk.core.data.ao.eQA && this.lMt != null) {
                if (aoVar.bpK()) {
                    if (this.lMu != null) {
                        this.lMu.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.lMu == null) {
                    this.lMu = (LinearLayout) this.lMt.inflate();
                    this.lMv = this.lMu.findViewById(R.id.link_thread_divider);
                    this.lMw = (BaseWebView) this.lMu.findViewById(R.id.link_thread_webview);
                }
                this.lMv.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lMv, R.color.CAM_X0204);
                this.lMw.setVisibility(0);
                this.lMw.setFocusable(false);
                this.lMw.setBackgroundColor(0);
                this.lMw.getSettings().setCacheMode(-1);
                this.lMw.setVerticalScrollBarEnabled(false);
                this.lMw.setHorizontalScrollBarEnabled(false);
                this.lMw.getSettings().setAllowFileAccess(true);
                this.lMw.getSettings().setAppCacheEnabled(true);
                this.lMw.getSettings().setDomStorageEnabled(true);
                this.lMw.getSettings().setDatabaseEnabled(true);
                this.lMw.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.lMw.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.lMw.loadUrl(aoVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.lMw != null) {
            this.lMw.removeAllViews();
            this.lMw.getSettings().setBuiltInZoomControls(true);
            this.lMw.setVisibility(8);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.lMw != null) {
                            q.this.lMw.destroy();
                            q.this.lMw = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.lMw != null) {
            try {
                this.lMw.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.lMw != null) {
            try {
                this.lMw.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
