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
    private OriginalThreadCardView ezb;
    private View hIn;
    private ViewStub hIp;
    private PbGiftListView hIq;
    private ViewStub hIr;
    private OriginalThreadCardView.a hIs;
    private ViewStub hIt;
    private LinearLayout hIu;
    public View hIv;
    public BaseWebView hIw;
    private int edf = 0;
    private int hIo = 0;

    public q(View view) {
        this.hIn = view;
        this.hIp = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.hIr = (ViewStub) view.findViewById(R.id.original_thread_info_viewStub);
        this.hIt = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void xo(int i) {
        this.hIo = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hIs = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.aa(aoVar.acr()) || this.hIp == null) {
            if (this.hIq != null) {
                this.hIq.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hIq == null) {
            this.hIq = (PbGiftListView) this.hIp.inflate();
        }
        this.hIq.setVisibility(0);
        this.hIq.a(aoVar, str, str2, j, j2, j3);
        this.hIq.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hIr == null || originalThreadInfo == null) {
            if (this.ezb != null) {
                this.ezb.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ezb == null) {
            this.ezb = (OriginalThreadCardView) this.hIr.inflate();
        }
        this.ezb.setSubClickListener(this.hIs);
        this.ezb.setVisibility(0);
        this.ezb.ezM = this.hIo;
        this.ezb.b(originalThreadInfo);
        if (this.ezb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.edf = this.edf > 0 ? this.edf : com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ezb.getLayoutParams();
            layoutParams.bottomMargin = this.edf;
            this.ezb.setLayoutParams(layoutParams);
        }
        this.ezb.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl())) {
            if ((this.hIw == null || !this.hIw.getIsLoaded()) && afVar.acc() == com.baidu.tbadk.core.data.af.bGw && this.hIt != null) {
                if (afVar.acd()) {
                    if (this.hIu != null) {
                        this.hIu.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hIu == null) {
                    this.hIu = (LinearLayout) this.hIt.inflate();
                    this.hIv = this.hIu.findViewById(R.id.link_thread_divider);
                    this.hIw = (BaseWebView) this.hIu.findViewById(R.id.link_thread_webview);
                }
                this.hIv.setVisibility(0);
                com.baidu.tbadk.core.util.al.l(this.hIv, R.color.cp_bg_line_c);
                this.hIw.setVisibility(0);
                this.hIw.setFocusable(false);
                this.hIw.setBackgroundColor(0);
                this.hIw.getSettings().setCacheMode(-1);
                this.hIw.setVerticalScrollBarEnabled(false);
                this.hIw.setHorizontalScrollBarEnabled(false);
                this.hIw.getSettings().setAllowFileAccess(true);
                this.hIw.getSettings().setAppCacheEnabled(true);
                this.hIw.getSettings().setDomStorageEnabled(true);
                this.hIw.getSettings().setDatabaseEnabled(true);
                this.hIw.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hIw.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hIw.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hIw != null) {
            this.hIw.removeAllViews();
            this.hIw.getSettings().setBuiltInZoomControls(true);
            this.hIw.setVisibility(8);
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hIw != null) {
                            q.this.hIw.destroy();
                            q.this.hIw = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hIw != null) {
            try {
                this.hIw.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hIw != null) {
            try {
                this.hIw.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
