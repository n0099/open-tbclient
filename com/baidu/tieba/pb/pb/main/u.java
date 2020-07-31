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
/* loaded from: classes16.dex */
public class u {
    private View knn;
    private ViewStub knp;
    private PbGiftListView knq;
    private ViewStub knr;
    private LinearLayout kns;
    public View knt;
    public BaseWebView knu;
    private int knm = 0;
    private int kno = 0;

    public u(View view) {
        this.knn = view;
        this.knp = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.knr = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void BH(int i) {
        this.kno = i;
    }

    public void a(com.baidu.tbadk.core.data.aw awVar, String str, String str2, long j, long j2, long j3) {
        if (awVar == null || com.baidu.tbadk.core.util.x.isEmpty(awVar.aVd()) || this.knp == null) {
            if (this.knq != null) {
                this.knq.setVisibility(8);
                return;
            }
            return;
        }
        if (this.knq == null) {
            this.knq = (PbGiftListView) this.knp.inflate();
        }
        this.knq.setVisibility(0);
        this.knq.a(awVar, str, str2, j, j2, j3);
        this.knq.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.al alVar) {
        if (alVar != null && !com.baidu.tbadk.core.util.as.isEmpty(alVar.getLinkUrl())) {
            if ((this.knu == null || !this.knu.getIsLoaded()) && alVar.aUG() == com.baidu.tbadk.core.data.al.dPs && this.knr != null) {
                if (alVar.aUH()) {
                    if (this.kns != null) {
                        this.kns.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.kns == null) {
                    this.kns = (LinearLayout) this.knr.inflate();
                    this.knt = this.kns.findViewById(R.id.link_thread_divider);
                    this.knu = (BaseWebView) this.kns.findViewById(R.id.link_thread_webview);
                }
                this.knt.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.knt, R.color.cp_bg_line_c);
                this.knu.setVisibility(0);
                this.knu.setFocusable(false);
                this.knu.setBackgroundColor(0);
                this.knu.getSettings().setCacheMode(-1);
                this.knu.setVerticalScrollBarEnabled(false);
                this.knu.setHorizontalScrollBarEnabled(false);
                this.knu.getSettings().setAllowFileAccess(true);
                this.knu.getSettings().setAppCacheEnabled(true);
                this.knu.getSettings().setDomStorageEnabled(true);
                this.knu.getSettings().setDatabaseEnabled(true);
                this.knu.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.knu.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.u.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.knu.loadUrl(alVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.knu != null) {
            this.knu.removeAllViews();
            this.knu.getSettings().setBuiltInZoomControls(true);
            this.knu.setVisibility(8);
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.u.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (u.this.knu != null) {
                            u.this.knu.destroy();
                            u.this.knu = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.knu != null) {
            try {
                this.knu.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.knu != null) {
            try {
                this.knu.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
