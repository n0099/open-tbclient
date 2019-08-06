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
    private OriginalThreadCardView eEg;
    private int ehJ = 0;
    private int hPA = 0;
    private ViewStub hPB;
    private PbGiftListView hPC;
    private ViewStub hPD;
    private OriginalThreadCardView.a hPE;
    private ViewStub hPF;
    private LinearLayout hPG;
    public View hPH;
    public BaseWebView hPI;
    private View hPz;

    public q(View view) {
        this.hPz = view;
        this.hPB = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.hPD = (ViewStub) view.findViewById(R.id.original_thread_info_viewStub);
        this.hPF = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void xU(int i) {
        this.hPA = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hPE = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.aa(aoVar.adu()) || this.hPB == null) {
            if (this.hPC != null) {
                this.hPC.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hPC == null) {
            this.hPC = (PbGiftListView) this.hPB.inflate();
        }
        this.hPC.setVisibility(0);
        this.hPC.a(aoVar, str, str2, j, j2, j3);
        this.hPC.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hPD == null || originalThreadInfo == null) {
            if (this.eEg != null) {
                this.eEg.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eEg == null) {
            this.eEg = (OriginalThreadCardView) this.hPD.inflate();
        }
        this.eEg.setSubClickListener(this.hPE);
        this.eEg.setVisibility(0);
        this.eEg.eEQ = this.hPA;
        this.eEg.b(originalThreadInfo);
        if (this.eEg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.ehJ = this.ehJ > 0 ? this.ehJ : com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEg.getLayoutParams();
            layoutParams.bottomMargin = this.ehJ;
            this.eEg.setLayoutParams(layoutParams);
        }
        this.eEg.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl())) {
            if ((this.hPI == null || !this.hPI.getIsLoaded()) && afVar.adf() == com.baidu.tbadk.core.data.af.bHy && this.hPF != null) {
                if (afVar.adg()) {
                    if (this.hPG != null) {
                        this.hPG.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hPG == null) {
                    this.hPG = (LinearLayout) this.hPF.inflate();
                    this.hPH = this.hPG.findViewById(R.id.link_thread_divider);
                    this.hPI = (BaseWebView) this.hPG.findViewById(R.id.link_thread_webview);
                }
                this.hPH.setVisibility(0);
                com.baidu.tbadk.core.util.am.l(this.hPH, R.color.cp_bg_line_c);
                this.hPI.setVisibility(0);
                this.hPI.setFocusable(false);
                this.hPI.setBackgroundColor(0);
                this.hPI.getSettings().setCacheMode(-1);
                this.hPI.setVerticalScrollBarEnabled(false);
                this.hPI.setHorizontalScrollBarEnabled(false);
                this.hPI.getSettings().setAllowFileAccess(true);
                this.hPI.getSettings().setAppCacheEnabled(true);
                this.hPI.getSettings().setDomStorageEnabled(true);
                this.hPI.getSettings().setDatabaseEnabled(true);
                this.hPI.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hPI.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hPI.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hPI != null) {
            this.hPI.removeAllViews();
            this.hPI.getSettings().setBuiltInZoomControls(true);
            this.hPI.setVisibility(8);
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hPI != null) {
                            q.this.hPI.destroy();
                            q.this.hPI = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hPI != null) {
            try {
                this.hPI.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hPI != null) {
            try {
                this.hPI.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
