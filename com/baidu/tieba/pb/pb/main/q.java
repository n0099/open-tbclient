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
    private View hrb;
    private ViewStub hrd;
    private PbGiftListView hre;
    private ViewStub hrf;
    private OriginalThreadCardView.a hrg;
    private ViewStub hrh;
    private LinearLayout hri;
    public View hrj;
    public BaseWebView hrk;
    private int dTs = 0;
    private int hrc = 0;

    public q(View view) {
        this.hrb = view;
        this.hrd = (ViewStub) view.findViewById(d.g.gift_list_viewStub);
        this.hrf = (ViewStub) view.findViewById(d.g.original_thread_info_viewStub);
        this.hrh = (ViewStub) view.findViewById(d.g.link_thread_viewStub);
    }

    public void wm(int i) {
        this.hrc = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hrg = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.T(aoVar.XM()) || this.hrd == null) {
            if (this.hre != null) {
                this.hre.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hre == null) {
            this.hre = (PbGiftListView) this.hrd.inflate();
        }
        this.hre.setVisibility(0);
        this.hre.a(aoVar, str, str2, j, j2, j3);
        this.hre.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hrf == null || originalThreadInfo == null) {
            if (this.ejE != null) {
                this.ejE.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ejE == null) {
            this.ejE = (OriginalThreadCardView) this.hrf.inflate();
        }
        this.ejE.setSubClickListener(this.hrg);
        this.ejE.setVisibility(0);
        this.ejE.ekp = this.hrc;
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
            if ((this.hrk == null || !this.hrk.getIsLoaded()) && afVar.Xy() == com.baidu.tbadk.core.data.af.bzf && this.hrh != null) {
                if (afVar.Xz()) {
                    if (this.hri != null) {
                        this.hri.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hri == null) {
                    this.hri = (LinearLayout) this.hrh.inflate();
                    this.hrj = this.hri.findViewById(d.g.link_thread_divider);
                    this.hrk = (BaseWebView) this.hri.findViewById(d.g.link_thread_webview);
                }
                this.hrj.setVisibility(0);
                com.baidu.tbadk.core.util.al.l(this.hrj, d.C0236d.cp_bg_line_c);
                this.hrk.setVisibility(0);
                this.hrk.setFocusable(false);
                this.hrk.setBackgroundColor(0);
                this.hrk.getSettings().setCacheMode(-1);
                this.hrk.setVerticalScrollBarEnabled(false);
                this.hrk.setHorizontalScrollBarEnabled(false);
                this.hrk.getSettings().setAllowFileAccess(true);
                this.hrk.getSettings().setAppCacheEnabled(true);
                this.hrk.getSettings().setDomStorageEnabled(true);
                this.hrk.getSettings().setDatabaseEnabled(true);
                this.hrk.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hrk.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hrk.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hrk != null) {
            this.hrk.removeAllViews();
            this.hrk.getSettings().setBuiltInZoomControls(true);
            this.hrk.setVisibility(8);
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hrk != null) {
                            q.this.hrk.destroy();
                            q.this.hrk = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hrk != null) {
            try {
                this.hrk.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hrk != null) {
            try {
                this.hrk.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
