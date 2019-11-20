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
    private OriginalThreadCardView eNF;
    private View hPk;
    private ViewStub hPm;
    private PbGiftListView hPn;
    private ViewStub hPo;
    private OriginalThreadCardView.a hPp;
    private ViewStub hPq;
    private LinearLayout hPr;
    public View hPs;
    public BaseWebView hPt;
    private int evw = 0;
    private int hPl = 0;

    public q(View view) {
        this.hPk = view;
        this.hPm = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.hPo = (ViewStub) view.findViewById(R.id.original_thread_info_viewStub);
        this.hPq = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void wC(int i) {
        this.hPl = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hPp = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.isEmpty(aoVar.ahA()) || this.hPm == null) {
            if (this.hPn != null) {
                this.hPn.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hPn == null) {
            this.hPn = (PbGiftListView) this.hPm.inflate();
        }
        this.hPn.setVisibility(0);
        this.hPn.a(aoVar, str, str2, j, j2, j3);
        this.hPn.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hPo == null || originalThreadInfo == null) {
            if (this.eNF != null) {
                this.eNF.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eNF == null) {
            this.eNF = (OriginalThreadCardView) this.hPo.inflate();
        }
        this.eNF.setSubClickListener(this.hPp);
        this.eNF.setVisibility(0);
        this.eNF.eOp = this.hPl;
        this.eNF.b(originalThreadInfo);
        if (this.eNF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.evw = this.evw > 0 ? this.evw : com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNF.getLayoutParams();
            layoutParams.bottomMargin = this.evw;
            this.eNF.setLayoutParams(layoutParams);
        }
        this.eNF.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl())) {
            if ((this.hPt == null || !this.hPt.getIsLoaded()) && afVar.ahn() == com.baidu.tbadk.core.data.af.bYQ && this.hPq != null) {
                if (afVar.aho()) {
                    if (this.hPr != null) {
                        this.hPr.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hPr == null) {
                    this.hPr = (LinearLayout) this.hPq.inflate();
                    this.hPs = this.hPr.findViewById(R.id.link_thread_divider);
                    this.hPt = (BaseWebView) this.hPr.findViewById(R.id.link_thread_webview);
                }
                this.hPs.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hPs, R.color.cp_bg_line_c);
                this.hPt.setVisibility(0);
                this.hPt.setFocusable(false);
                this.hPt.setBackgroundColor(0);
                this.hPt.getSettings().setCacheMode(-1);
                this.hPt.setVerticalScrollBarEnabled(false);
                this.hPt.setHorizontalScrollBarEnabled(false);
                this.hPt.getSettings().setAllowFileAccess(true);
                this.hPt.getSettings().setAppCacheEnabled(true);
                this.hPt.getSettings().setDomStorageEnabled(true);
                this.hPt.getSettings().setDatabaseEnabled(true);
                this.hPt.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hPt.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hPt.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hPt != null) {
            this.hPt.removeAllViews();
            this.hPt.getSettings().setBuiltInZoomControls(true);
            this.hPt.setVisibility(8);
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hPt != null) {
                            q.this.hPt.destroy();
                            q.this.hPt = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hPt != null) {
            try {
                this.hPt.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hPt != null) {
            try {
                this.hPt.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
