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
    public BaseWebView hIA;
    private View hIr;
    private ViewStub hIt;
    private PbGiftListView hIu;
    private ViewStub hIv;
    private OriginalThreadCardView.a hIw;
    private ViewStub hIx;
    private LinearLayout hIy;
    public View hIz;
    private int edg = 0;
    private int hIs = 0;

    public q(View view) {
        this.hIr = view;
        this.hIt = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.hIv = (ViewStub) view.findViewById(R.id.original_thread_info_viewStub);
        this.hIx = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void xo(int i) {
        this.hIs = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hIw = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.aa(aoVar.acr()) || this.hIt == null) {
            if (this.hIu != null) {
                this.hIu.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hIu == null) {
            this.hIu = (PbGiftListView) this.hIt.inflate();
        }
        this.hIu.setVisibility(0);
        this.hIu.a(aoVar, str, str2, j, j2, j3);
        this.hIu.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hIv == null || originalThreadInfo == null) {
            if (this.ezc != null) {
                this.ezc.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ezc == null) {
            this.ezc = (OriginalThreadCardView) this.hIv.inflate();
        }
        this.ezc.setSubClickListener(this.hIw);
        this.ezc.setVisibility(0);
        this.ezc.ezN = this.hIs;
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
            if ((this.hIA == null || !this.hIA.getIsLoaded()) && afVar.acc() == com.baidu.tbadk.core.data.af.bGx && this.hIx != null) {
                if (afVar.acd()) {
                    if (this.hIy != null) {
                        this.hIy.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hIy == null) {
                    this.hIy = (LinearLayout) this.hIx.inflate();
                    this.hIz = this.hIy.findViewById(R.id.link_thread_divider);
                    this.hIA = (BaseWebView) this.hIy.findViewById(R.id.link_thread_webview);
                }
                this.hIz.setVisibility(0);
                com.baidu.tbadk.core.util.al.l(this.hIz, R.color.cp_bg_line_c);
                this.hIA.setVisibility(0);
                this.hIA.setFocusable(false);
                this.hIA.setBackgroundColor(0);
                this.hIA.getSettings().setCacheMode(-1);
                this.hIA.setVerticalScrollBarEnabled(false);
                this.hIA.setHorizontalScrollBarEnabled(false);
                this.hIA.getSettings().setAllowFileAccess(true);
                this.hIA.getSettings().setAppCacheEnabled(true);
                this.hIA.getSettings().setDomStorageEnabled(true);
                this.hIA.getSettings().setDatabaseEnabled(true);
                this.hIA.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hIA.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hIA.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hIA != null) {
            this.hIA.removeAllViews();
            this.hIA.getSettings().setBuiltInZoomControls(true);
            this.hIA.setVisibility(8);
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hIA != null) {
                            q.this.hIA.destroy();
                            q.this.hIA = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hIA != null) {
            try {
                this.hIA.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hIA != null) {
            try {
                this.hIA.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
