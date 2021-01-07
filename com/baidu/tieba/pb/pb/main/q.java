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
    private View lMo;
    private ViewStub lMq;
    private PbGiftListView lMr;
    private ViewStub lMs;
    private LinearLayout lMt;
    public View lMu;
    public BaseWebView lMv;
    private int lMn = 0;
    private int lMp = 0;

    public q(View view) {
        this.lMo = view;
        this.lMq = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.lMs = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void GT(int i) {
        this.lMp = i;
    }

    public void a(az azVar, String str, String str2, long j, long j2, long j3) {
        if (azVar == null || com.baidu.tbadk.core.util.x.isEmpty(azVar.bqi()) || this.lMq == null) {
            if (this.lMr != null) {
                this.lMr.setVisibility(8);
                return;
            }
            return;
        }
        if (this.lMr == null) {
            this.lMr = (PbGiftListView) this.lMq.inflate();
        }
        this.lMr.setVisibility(0);
        this.lMr.a(azVar, str, str2, j, j2, j3);
        this.lMr.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null && !com.baidu.tbadk.core.util.at.isEmpty(aoVar.getLinkUrl())) {
            if ((this.lMv == null || !this.lMv.getIsLoaded()) && aoVar.bpK() == com.baidu.tbadk.core.data.ao.eQA && this.lMs != null) {
                if (aoVar.bpL()) {
                    if (this.lMt != null) {
                        this.lMt.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.lMt == null) {
                    this.lMt = (LinearLayout) this.lMs.inflate();
                    this.lMu = this.lMt.findViewById(R.id.link_thread_divider);
                    this.lMv = (BaseWebView) this.lMt.findViewById(R.id.link_thread_webview);
                }
                this.lMu.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lMu, R.color.CAM_X0204);
                this.lMv.setVisibility(0);
                this.lMv.setFocusable(false);
                this.lMv.setBackgroundColor(0);
                this.lMv.getSettings().setCacheMode(-1);
                this.lMv.setVerticalScrollBarEnabled(false);
                this.lMv.setHorizontalScrollBarEnabled(false);
                this.lMv.getSettings().setAllowFileAccess(true);
                this.lMv.getSettings().setAppCacheEnabled(true);
                this.lMv.getSettings().setDomStorageEnabled(true);
                this.lMv.getSettings().setDatabaseEnabled(true);
                this.lMv.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.lMv.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.lMv.loadUrl(aoVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.lMv != null) {
            this.lMv.removeAllViews();
            this.lMv.getSettings().setBuiltInZoomControls(true);
            this.lMv.setVisibility(8);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.lMv != null) {
                            q.this.lMv.destroy();
                            q.this.lMv = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.lMv != null) {
            try {
                this.lMv.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.lMv != null) {
            try {
                this.lMv.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
