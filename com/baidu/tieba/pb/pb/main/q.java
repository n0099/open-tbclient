package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.PbGiftListView;
/* loaded from: classes4.dex */
public class q {
    private OriginalThreadCardView ejm;
    private View hqI;
    private ViewStub hqK;
    private PbGiftListView hqL;
    private ViewStub hqM;
    private OriginalThreadCardView.a hqN;
    private ViewStub hqO;
    private LinearLayout hqP;
    public View hqQ;
    public BaseWebView hqR;
    private int dSF = 0;
    private int hqJ = 0;

    public q(View view) {
        this.hqI = view;
        this.hqK = (ViewStub) view.findViewById(d.g.gift_list_viewStub);
        this.hqM = (ViewStub) view.findViewById(d.g.original_thread_info_viewStub);
        this.hqO = (ViewStub) view.findViewById(d.g.link_thread_viewStub);
    }

    public void wi(int i) {
        this.hqJ = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hqN = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.T(aoVar.XJ()) || this.hqK == null) {
            if (this.hqL != null) {
                this.hqL.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hqL == null) {
            this.hqL = (PbGiftListView) this.hqK.inflate();
        }
        this.hqL.setVisibility(0);
        this.hqL.a(aoVar, str, str2, j, j2, j3);
        this.hqL.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hqM == null || originalThreadInfo == null) {
            if (this.ejm != null) {
                this.ejm.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ejm == null) {
            this.ejm = (OriginalThreadCardView) this.hqM.inflate();
        }
        this.ejm.setSubClickListener(this.hqN);
        this.ejm.setVisibility(0);
        this.ejm.ejX = this.hqJ;
        this.ejm.b(originalThreadInfo);
        if (this.ejm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.dSF = this.dSF > 0 ? this.dSF : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejm.getLayoutParams();
            layoutParams.bottomMargin = this.dSF;
            this.ejm.setLayoutParams(layoutParams);
        }
        this.ejm.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl())) {
            if ((this.hqR == null || !this.hqR.getIsLoaded()) && afVar.Xv() == com.baidu.tbadk.core.data.af.bzk && this.hqO != null) {
                if (afVar.Xw()) {
                    if (this.hqP != null) {
                        this.hqP.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hqP == null) {
                    this.hqP = (LinearLayout) this.hqO.inflate();
                    this.hqQ = this.hqP.findViewById(d.g.link_thread_divider);
                    this.hqR = (BaseWebView) this.hqP.findViewById(d.g.link_thread_webview);
                }
                this.hqQ.setVisibility(0);
                com.baidu.tbadk.core.util.al.l(this.hqQ, d.C0277d.cp_bg_line_c);
                this.hqR.setVisibility(0);
                this.hqR.setFocusable(false);
                this.hqR.setBackgroundColor(0);
                this.hqR.getSettings().setCacheMode(-1);
                this.hqR.setVerticalScrollBarEnabled(false);
                this.hqR.setHorizontalScrollBarEnabled(false);
                this.hqR.getSettings().setAllowFileAccess(true);
                this.hqR.getSettings().setAppCacheEnabled(true);
                this.hqR.getSettings().setDomStorageEnabled(true);
                this.hqR.getSettings().setDatabaseEnabled(true);
                this.hqR.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hqR.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hqR.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hqR != null) {
            this.hqR.removeAllViews();
            this.hqR.getSettings().setBuiltInZoomControls(true);
            this.hqR.setVisibility(8);
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hqR != null) {
                            q.this.hqR.destroy();
                            q.this.hqR = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hqR != null) {
            try {
                this.hqR.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hqR != null) {
            try {
                this.hqR.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
