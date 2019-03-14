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
    private OriginalThreadCardView ejA;
    private View hqV;
    private ViewStub hqX;
    private PbGiftListView hqY;
    private ViewStub hqZ;
    private OriginalThreadCardView.a hra;
    private ViewStub hrb;
    private LinearLayout hrc;
    public View hrd;
    public BaseWebView hre;
    private int dTo = 0;
    private int hqW = 0;

    public q(View view) {
        this.hqV = view;
        this.hqX = (ViewStub) view.findViewById(d.g.gift_list_viewStub);
        this.hqZ = (ViewStub) view.findViewById(d.g.original_thread_info_viewStub);
        this.hrb = (ViewStub) view.findViewById(d.g.link_thread_viewStub);
    }

    public void wm(int i) {
        this.hqW = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hra = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.T(aoVar.XM()) || this.hqX == null) {
            if (this.hqY != null) {
                this.hqY.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hqY == null) {
            this.hqY = (PbGiftListView) this.hqX.inflate();
        }
        this.hqY.setVisibility(0);
        this.hqY.a(aoVar, str, str2, j, j2, j3);
        this.hqY.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hqZ == null || originalThreadInfo == null) {
            if (this.ejA != null) {
                this.ejA.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ejA == null) {
            this.ejA = (OriginalThreadCardView) this.hqZ.inflate();
        }
        this.ejA.setSubClickListener(this.hra);
        this.ejA.setVisibility(0);
        this.ejA.ekl = this.hqW;
        this.ejA.b(originalThreadInfo);
        if (this.ejA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.dTo = this.dTo > 0 ? this.dTo : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejA.getLayoutParams();
            layoutParams.bottomMargin = this.dTo;
            this.ejA.setLayoutParams(layoutParams);
        }
        this.ejA.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl())) {
            if ((this.hre == null || !this.hre.getIsLoaded()) && afVar.Xy() == com.baidu.tbadk.core.data.af.bzh && this.hrb != null) {
                if (afVar.Xz()) {
                    if (this.hrc != null) {
                        this.hrc.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hrc == null) {
                    this.hrc = (LinearLayout) this.hrb.inflate();
                    this.hrd = this.hrc.findViewById(d.g.link_thread_divider);
                    this.hre = (BaseWebView) this.hrc.findViewById(d.g.link_thread_webview);
                }
                this.hrd.setVisibility(0);
                com.baidu.tbadk.core.util.al.l(this.hrd, d.C0277d.cp_bg_line_c);
                this.hre.setVisibility(0);
                this.hre.setFocusable(false);
                this.hre.setBackgroundColor(0);
                this.hre.getSettings().setCacheMode(-1);
                this.hre.setVerticalScrollBarEnabled(false);
                this.hre.setHorizontalScrollBarEnabled(false);
                this.hre.getSettings().setAllowFileAccess(true);
                this.hre.getSettings().setAppCacheEnabled(true);
                this.hre.getSettings().setDomStorageEnabled(true);
                this.hre.getSettings().setDatabaseEnabled(true);
                this.hre.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hre.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hre.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hre != null) {
            this.hre.removeAllViews();
            this.hre.getSettings().setBuiltInZoomControls(true);
            this.hre.setVisibility(8);
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hre != null) {
                            q.this.hre.destroy();
                            q.this.hre = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hre != null) {
            try {
                this.hre.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hre != null) {
            try {
                this.hre.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
