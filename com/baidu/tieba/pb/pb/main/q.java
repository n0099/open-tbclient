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
    private OriginalThreadCardView ezc;
    private View hIq;
    private ViewStub hIs;
    private PbGiftListView hIt;
    private ViewStub hIu;
    private OriginalThreadCardView.a hIv;
    private ViewStub hIw;
    private LinearLayout hIx;
    public View hIy;
    public BaseWebView hIz;
    private int edg = 0;
    private int hIr = 0;

    public q(View view) {
        this.hIq = view;
        this.hIs = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.hIu = (ViewStub) view.findViewById(R.id.original_thread_info_viewStub);
        this.hIw = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void xo(int i) {
        this.hIr = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hIv = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.aa(aoVar.acr()) || this.hIs == null) {
            if (this.hIt != null) {
                this.hIt.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hIt == null) {
            this.hIt = (PbGiftListView) this.hIs.inflate();
        }
        this.hIt.setVisibility(0);
        this.hIt.a(aoVar, str, str2, j, j2, j3);
        this.hIt.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hIu == null || originalThreadInfo == null) {
            if (this.ezc != null) {
                this.ezc.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ezc == null) {
            this.ezc = (OriginalThreadCardView) this.hIu.inflate();
        }
        this.ezc.setSubClickListener(this.hIv);
        this.ezc.setVisibility(0);
        this.ezc.ezN = this.hIr;
        this.ezc.b(originalThreadInfo);
        if (this.ezc.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.edg = this.edg > 0 ? this.edg : com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ezc.getLayoutParams();
            layoutParams.bottomMargin = this.edg;
            this.ezc.setLayoutParams(layoutParams);
        }
        this.ezc.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl())) {
            if ((this.hIz == null || !this.hIz.getIsLoaded()) && afVar.acc() == com.baidu.tbadk.core.data.af.bGw && this.hIw != null) {
                if (afVar.acd()) {
                    if (this.hIx != null) {
                        this.hIx.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hIx == null) {
                    this.hIx = (LinearLayout) this.hIw.inflate();
                    this.hIy = this.hIx.findViewById(R.id.link_thread_divider);
                    this.hIz = (BaseWebView) this.hIx.findViewById(R.id.link_thread_webview);
                }
                this.hIy.setVisibility(0);
                com.baidu.tbadk.core.util.al.l(this.hIy, R.color.cp_bg_line_c);
                this.hIz.setVisibility(0);
                this.hIz.setFocusable(false);
                this.hIz.setBackgroundColor(0);
                this.hIz.getSettings().setCacheMode(-1);
                this.hIz.setVerticalScrollBarEnabled(false);
                this.hIz.setHorizontalScrollBarEnabled(false);
                this.hIz.getSettings().setAllowFileAccess(true);
                this.hIz.getSettings().setAppCacheEnabled(true);
                this.hIz.getSettings().setDomStorageEnabled(true);
                this.hIz.getSettings().setDatabaseEnabled(true);
                this.hIz.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hIz.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hIz.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hIz != null) {
            this.hIz.removeAllViews();
            this.hIz.getSettings().setBuiltInZoomControls(true);
            this.hIz.setVisibility(8);
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hIz != null) {
                            q.this.hIz.destroy();
                            q.this.hIz = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hIz != null) {
            try {
                this.hIz.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hIz != null) {
            try {
                this.hIz.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
