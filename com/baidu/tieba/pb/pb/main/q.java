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
    private OriginalThreadCardView ejE;
    private View hrc;
    private ViewStub hre;
    private PbGiftListView hrf;
    private ViewStub hrg;
    private OriginalThreadCardView.a hrh;
    private ViewStub hri;
    private LinearLayout hrj;
    public View hrk;
    public BaseWebView hrl;
    private int dTs = 0;
    private int hrd = 0;

    public q(View view) {
        this.hrc = view;
        this.hre = (ViewStub) view.findViewById(d.g.gift_list_viewStub);
        this.hrg = (ViewStub) view.findViewById(d.g.original_thread_info_viewStub);
        this.hri = (ViewStub) view.findViewById(d.g.link_thread_viewStub);
    }

    public void wm(int i) {
        this.hrd = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hrh = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.T(aoVar.XM()) || this.hre == null) {
            if (this.hrf != null) {
                this.hrf.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hrf == null) {
            this.hrf = (PbGiftListView) this.hre.inflate();
        }
        this.hrf.setVisibility(0);
        this.hrf.a(aoVar, str, str2, j, j2, j3);
        this.hrf.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hrg == null || originalThreadInfo == null) {
            if (this.ejE != null) {
                this.ejE.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ejE == null) {
            this.ejE = (OriginalThreadCardView) this.hrg.inflate();
        }
        this.ejE.setSubClickListener(this.hrh);
        this.ejE.setVisibility(0);
        this.ejE.ekp = this.hrd;
        this.ejE.b(originalThreadInfo);
        if (this.ejE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.dTs = this.dTs > 0 ? this.dTs : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejE.getLayoutParams();
            layoutParams.bottomMargin = this.dTs;
            this.ejE.setLayoutParams(layoutParams);
        }
        this.ejE.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl())) {
            if ((this.hrl == null || !this.hrl.getIsLoaded()) && afVar.Xy() == com.baidu.tbadk.core.data.af.bzf && this.hri != null) {
                if (afVar.Xz()) {
                    if (this.hrj != null) {
                        this.hrj.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hrj == null) {
                    this.hrj = (LinearLayout) this.hri.inflate();
                    this.hrk = this.hrj.findViewById(d.g.link_thread_divider);
                    this.hrl = (BaseWebView) this.hrj.findViewById(d.g.link_thread_webview);
                }
                this.hrk.setVisibility(0);
                com.baidu.tbadk.core.util.al.l(this.hrk, d.C0236d.cp_bg_line_c);
                this.hrl.setVisibility(0);
                this.hrl.setFocusable(false);
                this.hrl.setBackgroundColor(0);
                this.hrl.getSettings().setCacheMode(-1);
                this.hrl.setVerticalScrollBarEnabled(false);
                this.hrl.setHorizontalScrollBarEnabled(false);
                this.hrl.getSettings().setAllowFileAccess(true);
                this.hrl.getSettings().setAppCacheEnabled(true);
                this.hrl.getSettings().setDomStorageEnabled(true);
                this.hrl.getSettings().setDatabaseEnabled(true);
                this.hrl.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hrl.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hrl.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hrl != null) {
            this.hrl.removeAllViews();
            this.hrl.getSettings().setBuiltInZoomControls(true);
            this.hrl.setVisibility(8);
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hrl != null) {
                            q.this.hrl.destroy();
                            q.this.hrl = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hrl != null) {
            try {
                this.hrl.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hrl != null) {
            try {
                this.hrl.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
