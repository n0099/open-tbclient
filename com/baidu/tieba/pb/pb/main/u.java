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
/* loaded from: classes21.dex */
public class u {
    private View kLl;
    private ViewStub kLn;
    private PbGiftListView kLo;
    private ViewStub kLp;
    private LinearLayout kLq;
    public View kLr;
    public BaseWebView kLs;
    private int kLk = 0;
    private int kLm = 0;

    public u(View view) {
        this.kLl = view;
        this.kLn = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.kLp = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void EC(int i) {
        this.kLm = i;
    }

    public void a(com.baidu.tbadk.core.data.ax axVar, String str, String str2, long j, long j2, long j3) {
        if (axVar == null || com.baidu.tbadk.core.util.y.isEmpty(axVar.beq()) || this.kLn == null) {
            if (this.kLo != null) {
                this.kLo.setVisibility(8);
                return;
            }
            return;
        }
        if (this.kLo == null) {
            this.kLo = (PbGiftListView) this.kLn.inflate();
        }
        this.kLo.setVisibility(0);
        this.kLo.a(axVar, str, str2, j, j2, j3);
        this.kLo.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl())) {
            if ((this.kLs == null || !this.kLs.getIsLoaded()) && amVar.bdT() == com.baidu.tbadk.core.data.am.eaZ && this.kLp != null) {
                if (amVar.bdU()) {
                    if (this.kLq != null) {
                        this.kLq.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.kLq == null) {
                    this.kLq = (LinearLayout) this.kLp.inflate();
                    this.kLr = this.kLq.findViewById(R.id.link_thread_divider);
                    this.kLs = (BaseWebView) this.kLq.findViewById(R.id.link_thread_webview);
                }
                this.kLr.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kLr, R.color.cp_bg_line_c);
                this.kLs.setVisibility(0);
                this.kLs.setFocusable(false);
                this.kLs.setBackgroundColor(0);
                this.kLs.getSettings().setCacheMode(-1);
                this.kLs.setVerticalScrollBarEnabled(false);
                this.kLs.setHorizontalScrollBarEnabled(false);
                this.kLs.getSettings().setAllowFileAccess(true);
                this.kLs.getSettings().setAppCacheEnabled(true);
                this.kLs.getSettings().setDomStorageEnabled(true);
                this.kLs.getSettings().setDatabaseEnabled(true);
                this.kLs.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.kLs.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.u.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.kLs.loadUrl(amVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.kLs != null) {
            this.kLs.removeAllViews();
            this.kLs.getSettings().setBuiltInZoomControls(true);
            this.kLs.setVisibility(8);
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.u.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (u.this.kLs != null) {
                            u.this.kLs.destroy();
                            u.this.kLs = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.kLs != null) {
            try {
                this.kLs.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.kLs != null) {
            try {
                this.kLs.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
