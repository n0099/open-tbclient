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
    private OriginalThreadCardView ejn;
    private View hqJ;
    private ViewStub hqL;
    private PbGiftListView hqM;
    private ViewStub hqN;
    private OriginalThreadCardView.a hqO;
    private ViewStub hqP;
    private LinearLayout hqQ;
    public View hqR;
    public BaseWebView hqS;
    private int dSG = 0;
    private int hqK = 0;

    public q(View view) {
        this.hqJ = view;
        this.hqL = (ViewStub) view.findViewById(d.g.gift_list_viewStub);
        this.hqN = (ViewStub) view.findViewById(d.g.original_thread_info_viewStub);
        this.hqP = (ViewStub) view.findViewById(d.g.link_thread_viewStub);
    }

    public void wi(int i) {
        this.hqK = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hqO = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.T(aoVar.XJ()) || this.hqL == null) {
            if (this.hqM != null) {
                this.hqM.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hqM == null) {
            this.hqM = (PbGiftListView) this.hqL.inflate();
        }
        this.hqM.setVisibility(0);
        this.hqM.a(aoVar, str, str2, j, j2, j3);
        this.hqM.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hqN == null || originalThreadInfo == null) {
            if (this.ejn != null) {
                this.ejn.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ejn == null) {
            this.ejn = (OriginalThreadCardView) this.hqN.inflate();
        }
        this.ejn.setSubClickListener(this.hqO);
        this.ejn.setVisibility(0);
        this.ejn.ejY = this.hqK;
        this.ejn.b(originalThreadInfo);
        if (this.ejn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.dSG = this.dSG > 0 ? this.dSG : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejn.getLayoutParams();
            layoutParams.bottomMargin = this.dSG;
            this.ejn.setLayoutParams(layoutParams);
        }
        this.ejn.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl())) {
            if ((this.hqS == null || !this.hqS.getIsLoaded()) && afVar.Xv() == com.baidu.tbadk.core.data.af.bzl && this.hqP != null) {
                if (afVar.Xw()) {
                    if (this.hqQ != null) {
                        this.hqQ.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hqQ == null) {
                    this.hqQ = (LinearLayout) this.hqP.inflate();
                    this.hqR = this.hqQ.findViewById(d.g.link_thread_divider);
                    this.hqS = (BaseWebView) this.hqQ.findViewById(d.g.link_thread_webview);
                }
                this.hqR.setVisibility(0);
                com.baidu.tbadk.core.util.al.l(this.hqR, d.C0277d.cp_bg_line_c);
                this.hqS.setVisibility(0);
                this.hqS.setFocusable(false);
                this.hqS.setBackgroundColor(0);
                this.hqS.getSettings().setCacheMode(-1);
                this.hqS.setVerticalScrollBarEnabled(false);
                this.hqS.setHorizontalScrollBarEnabled(false);
                this.hqS.getSettings().setAllowFileAccess(true);
                this.hqS.getSettings().setAppCacheEnabled(true);
                this.hqS.getSettings().setDomStorageEnabled(true);
                this.hqS.getSettings().setDatabaseEnabled(true);
                this.hqS.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hqS.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hqS.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hqS != null) {
            this.hqS.removeAllViews();
            this.hqS.getSettings().setBuiltInZoomControls(true);
            this.hqS.setVisibility(8);
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hqS != null) {
                            q.this.hqS.destroy();
                            q.this.hqS = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hqS != null) {
            try {
                this.hqS.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hqS != null) {
            try {
                this.hqS.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
