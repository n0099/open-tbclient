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
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.pb.view.PbGiftListView;
/* loaded from: classes4.dex */
public class q {
    private OriginalThreadCardView eFP;
    private ViewStub hRA;
    private OriginalThreadCardView.a hRB;
    private ViewStub hRC;
    private LinearLayout hRD;
    public View hRE;
    public BaseWebView hRF;
    private View hRw;
    private ViewStub hRy;
    private PbGiftListView hRz;
    private int ejt = 0;
    private int hRx = 0;

    public q(View view) {
        this.hRw = view;
        this.hRy = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.hRA = (ViewStub) view.findViewById(R.id.original_thread_info_viewStub);
        this.hRC = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void xX(int i) {
        this.hRx = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hRB = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.aa(aoVar.ady()) || this.hRy == null) {
            if (this.hRz != null) {
                this.hRz.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hRz == null) {
            this.hRz = (PbGiftListView) this.hRy.inflate();
        }
        this.hRz.setVisibility(0);
        this.hRz.a(aoVar, str, str2, j, j2, j3);
        this.hRz.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hRA == null || originalThreadInfo == null) {
            if (this.eFP != null) {
                this.eFP.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eFP == null) {
            this.eFP = (OriginalThreadCardView) this.hRA.inflate();
        }
        this.eFP.setSubClickListener(this.hRB);
        this.eFP.setVisibility(0);
        this.eFP.eGz = this.hRx;
        this.eFP.b(originalThreadInfo);
        if (this.eFP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.ejt = this.ejt > 0 ? this.ejt : com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFP.getLayoutParams();
            layoutParams.bottomMargin = this.ejt;
            this.eFP.setLayoutParams(layoutParams);
        }
        this.eFP.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl())) {
            if ((this.hRF == null || !this.hRF.getIsLoaded()) && afVar.adj() == com.baidu.tbadk.core.data.af.bHW && this.hRC != null) {
                if (afVar.adk()) {
                    if (this.hRD != null) {
                        this.hRD.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hRD == null) {
                    this.hRD = (LinearLayout) this.hRC.inflate();
                    this.hRE = this.hRD.findViewById(R.id.link_thread_divider);
                    this.hRF = (BaseWebView) this.hRD.findViewById(R.id.link_thread_webview);
                }
                this.hRE.setVisibility(0);
                com.baidu.tbadk.core.util.am.l(this.hRE, R.color.cp_bg_line_c);
                this.hRF.setVisibility(0);
                this.hRF.setFocusable(false);
                this.hRF.setBackgroundColor(0);
                this.hRF.getSettings().setCacheMode(-1);
                this.hRF.setVerticalScrollBarEnabled(false);
                this.hRF.setHorizontalScrollBarEnabled(false);
                this.hRF.getSettings().setAllowFileAccess(true);
                this.hRF.getSettings().setAppCacheEnabled(true);
                this.hRF.getSettings().setDomStorageEnabled(true);
                this.hRF.getSettings().setDatabaseEnabled(true);
                this.hRF.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hRF.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hRF.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hRF != null) {
            this.hRF.removeAllViews();
            this.hRF.getSettings().setBuiltInZoomControls(true);
            this.hRF.setVisibility(8);
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hRF != null) {
                            q.this.hRF.destroy();
                            q.this.hRF = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hRF != null) {
            try {
                this.hRF.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hRF != null) {
            try {
                this.hRF.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
