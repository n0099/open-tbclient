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
    private OriginalThreadCardView eDZ;
    private View hOE;
    private ViewStub hOG;
    private PbGiftListView hOH;
    private ViewStub hOI;
    private OriginalThreadCardView.a hOJ;
    private ViewStub hOK;
    private LinearLayout hOL;
    public View hOM;
    public BaseWebView hON;
    private int ehC = 0;
    private int hOF = 0;

    public q(View view) {
        this.hOE = view;
        this.hOG = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.hOI = (ViewStub) view.findViewById(R.id.original_thread_info_viewStub);
        this.hOK = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void xS(int i) {
        this.hOF = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hOJ = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.aa(aoVar.adt()) || this.hOG == null) {
            if (this.hOH != null) {
                this.hOH.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hOH == null) {
            this.hOH = (PbGiftListView) this.hOG.inflate();
        }
        this.hOH.setVisibility(0);
        this.hOH.a(aoVar, str, str2, j, j2, j3);
        this.hOH.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hOI == null || originalThreadInfo == null) {
            if (this.eDZ != null) {
                this.eDZ.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eDZ == null) {
            this.eDZ = (OriginalThreadCardView) this.hOI.inflate();
        }
        this.eDZ.setSubClickListener(this.hOJ);
        this.eDZ.setVisibility(0);
        this.eDZ.eEJ = this.hOF;
        this.eDZ.b(originalThreadInfo);
        if (this.eDZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.ehC = this.ehC > 0 ? this.ehC : com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eDZ.getLayoutParams();
            layoutParams.bottomMargin = this.ehC;
            this.eDZ.setLayoutParams(layoutParams);
        }
        this.eDZ.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl())) {
            if ((this.hON == null || !this.hON.getIsLoaded()) && afVar.ade() == com.baidu.tbadk.core.data.af.bHx && this.hOK != null) {
                if (afVar.adf()) {
                    if (this.hOL != null) {
                        this.hOL.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hOL == null) {
                    this.hOL = (LinearLayout) this.hOK.inflate();
                    this.hOM = this.hOL.findViewById(R.id.link_thread_divider);
                    this.hON = (BaseWebView) this.hOL.findViewById(R.id.link_thread_webview);
                }
                this.hOM.setVisibility(0);
                com.baidu.tbadk.core.util.am.l(this.hOM, R.color.cp_bg_line_c);
                this.hON.setVisibility(0);
                this.hON.setFocusable(false);
                this.hON.setBackgroundColor(0);
                this.hON.getSettings().setCacheMode(-1);
                this.hON.setVerticalScrollBarEnabled(false);
                this.hON.setHorizontalScrollBarEnabled(false);
                this.hON.getSettings().setAllowFileAccess(true);
                this.hON.getSettings().setAppCacheEnabled(true);
                this.hON.getSettings().setDomStorageEnabled(true);
                this.hON.getSettings().setDatabaseEnabled(true);
                this.hON.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hON.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hON.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hON != null) {
            this.hON.removeAllViews();
            this.hON.getSettings().setBuiltInZoomControls(true);
            this.hON.setVisibility(8);
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hON != null) {
                            q.this.hON.destroy();
                            q.this.hON = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hON != null) {
            try {
                this.hON.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hON != null) {
            try {
                this.hON.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
