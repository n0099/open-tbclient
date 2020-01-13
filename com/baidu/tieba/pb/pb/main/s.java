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
/* loaded from: classes7.dex */
public class s {
    private View iFi;
    private ViewStub iFk;
    private PbGiftListView iFl;
    private ViewStub iFm;
    private LinearLayout iFn;
    public View iFo;
    public BaseWebView iFp;
    private int fqf = 0;
    private int iFj = 0;

    public s(View view) {
        this.iFi = view;
        this.iFk = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.iFm = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void yF(int i) {
        this.iFj = i;
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, String str, String str2, long j, long j2, long j3) {
        if (arVar == null || com.baidu.tbadk.core.util.v.isEmpty(arVar.ayT()) || this.iFk == null) {
            if (this.iFl != null) {
                this.iFl.setVisibility(8);
                return;
            }
            return;
        }
        if (this.iFl == null) {
            this.iFl = (PbGiftListView) this.iFk.inflate();
        }
        this.iFl.setVisibility(0);
        this.iFl.a(arVar, str, str2, j, j2, j3);
        this.iFl.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl())) {
            if ((this.iFp == null || !this.iFp.getIsLoaded()) && agVar.ayA() == com.baidu.tbadk.core.data.ag.cLl && this.iFm != null) {
                if (agVar.ayB()) {
                    if (this.iFn != null) {
                        this.iFn.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.iFn == null) {
                    this.iFn = (LinearLayout) this.iFm.inflate();
                    this.iFo = this.iFn.findViewById(R.id.link_thread_divider);
                    this.iFp = (BaseWebView) this.iFn.findViewById(R.id.link_thread_webview);
                }
                this.iFo.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iFo, R.color.cp_bg_line_c);
                this.iFp.setVisibility(0);
                this.iFp.setFocusable(false);
                this.iFp.setBackgroundColor(0);
                this.iFp.getSettings().setCacheMode(-1);
                this.iFp.setVerticalScrollBarEnabled(false);
                this.iFp.setHorizontalScrollBarEnabled(false);
                this.iFp.getSettings().setAllowFileAccess(true);
                this.iFp.getSettings().setAppCacheEnabled(true);
                this.iFp.getSettings().setDomStorageEnabled(true);
                this.iFp.getSettings().setDatabaseEnabled(true);
                this.iFp.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.s.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.iFp.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.s.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.iFp.loadUrl(agVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.iFp != null) {
            this.iFp.removeAllViews();
            this.iFp.getSettings().setBuiltInZoomControls(true);
            this.iFp.setVisibility(8);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.s.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (s.this.iFp != null) {
                            s.this.iFp.destroy();
                            s.this.iFp = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.iFp != null) {
            try {
                this.iFp.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.iFp != null) {
            try {
                this.iFp.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
