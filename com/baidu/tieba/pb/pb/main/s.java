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
/* loaded from: classes9.dex */
public class s {
    private View jJJ;
    private ViewStub jJL;
    private PbGiftListView jJM;
    private ViewStub jJN;
    private LinearLayout jJO;
    public View jJP;
    public BaseWebView jJQ;
    private int jJI = 0;
    private int jJK = 0;

    public s(View view) {
        this.jJJ = view;
        this.jJL = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.jJN = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void Ae(int i) {
        this.jJK = i;
    }

    public void a(com.baidu.tbadk.core.data.aq aqVar, String str, String str2, long j, long j2, long j3) {
        if (aqVar == null || com.baidu.tbadk.core.util.v.isEmpty(aqVar.aPv()) || this.jJL == null) {
            if (this.jJM != null) {
                this.jJM.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jJM == null) {
            this.jJM = (PbGiftListView) this.jJL.inflate();
        }
        this.jJM.setVisibility(0);
        this.jJM.a(aqVar, str, str2, j, j2, j3);
        this.jJM.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl())) {
            if ((this.jJQ == null || !this.jJQ.getIsLoaded()) && afVar.aOZ() == com.baidu.tbadk.core.data.af.dCM && this.jJN != null) {
                if (afVar.aPa()) {
                    if (this.jJO != null) {
                        this.jJO.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.jJO == null) {
                    this.jJO = (LinearLayout) this.jJN.inflate();
                    this.jJP = this.jJO.findViewById(R.id.link_thread_divider);
                    this.jJQ = (BaseWebView) this.jJO.findViewById(R.id.link_thread_webview);
                }
                this.jJP.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jJP, R.color.cp_bg_line_c);
                this.jJQ.setVisibility(0);
                this.jJQ.setFocusable(false);
                this.jJQ.setBackgroundColor(0);
                this.jJQ.getSettings().setCacheMode(-1);
                this.jJQ.setVerticalScrollBarEnabled(false);
                this.jJQ.setHorizontalScrollBarEnabled(false);
                this.jJQ.getSettings().setAllowFileAccess(true);
                this.jJQ.getSettings().setAppCacheEnabled(true);
                this.jJQ.getSettings().setDomStorageEnabled(true);
                this.jJQ.getSettings().setDatabaseEnabled(true);
                this.jJQ.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.s.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.jJQ.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.s.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.jJQ.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.jJQ != null) {
            this.jJQ.removeAllViews();
            this.jJQ.getSettings().setBuiltInZoomControls(true);
            this.jJQ.setVisibility(8);
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.s.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (s.this.jJQ != null) {
                            s.this.jJQ.destroy();
                            s.this.jJQ = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.jJQ != null) {
            try {
                this.jJQ.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.jJQ != null) {
            try {
                this.jJQ.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
