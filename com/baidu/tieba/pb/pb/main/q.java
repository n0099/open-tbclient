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
    private OriginalThreadCardView eOw;
    private View hQb;
    private ViewStub hQd;
    private PbGiftListView hQe;
    private ViewStub hQf;
    private OriginalThreadCardView.a hQg;
    private ViewStub hQh;
    private LinearLayout hQi;
    public View hQj;
    public BaseWebView hQk;
    private int ewn = 0;
    private int hQc = 0;

    public q(View view) {
        this.hQb = view;
        this.hQd = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.hQf = (ViewStub) view.findViewById(R.id.original_thread_info_viewStub);
        this.hQh = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void wD(int i) {
        this.hQc = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.hQg = aVar;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, String str, String str2, long j, long j2, long j3) {
        if (aoVar == null || com.baidu.tbadk.core.util.v.isEmpty(aoVar.ahC()) || this.hQd == null) {
            if (this.hQe != null) {
                this.hQe.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hQe == null) {
            this.hQe = (PbGiftListView) this.hQd.inflate();
        }
        this.hQe.setVisibility(0);
        this.hQe.a(aoVar, str, str2, j, j2, j3);
        this.hQe.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.hQf == null || originalThreadInfo == null) {
            if (this.eOw != null) {
                this.eOw.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eOw == null) {
            this.eOw = (OriginalThreadCardView) this.hQf.inflate();
        }
        this.eOw.setSubClickListener(this.hQg);
        this.eOw.setVisibility(0);
        this.eOw.ePg = this.hQc;
        this.eOw.b(originalThreadInfo);
        if (this.eOw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.ewn = this.ewn > 0 ? this.ewn : com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOw.getLayoutParams();
            layoutParams.bottomMargin = this.ewn;
            this.eOw.setLayoutParams(layoutParams);
        }
        this.eOw.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl())) {
            if ((this.hQk == null || !this.hQk.getIsLoaded()) && afVar.ahp() == com.baidu.tbadk.core.data.af.bZH && this.hQh != null) {
                if (afVar.ahq()) {
                    if (this.hQi != null) {
                        this.hQi.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.hQi == null) {
                    this.hQi = (LinearLayout) this.hQh.inflate();
                    this.hQj = this.hQi.findViewById(R.id.link_thread_divider);
                    this.hQk = (BaseWebView) this.hQi.findViewById(R.id.link_thread_webview);
                }
                this.hQj.setVisibility(0);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hQj, R.color.cp_bg_line_c);
                this.hQk.setVisibility(0);
                this.hQk.setFocusable(false);
                this.hQk.setBackgroundColor(0);
                this.hQk.getSettings().setCacheMode(-1);
                this.hQk.setVerticalScrollBarEnabled(false);
                this.hQk.setHorizontalScrollBarEnabled(false);
                this.hQk.getSettings().setAllowFileAccess(true);
                this.hQk.getSettings().setAppCacheEnabled(true);
                this.hQk.getSettings().setDomStorageEnabled(true);
                this.hQk.getSettings().setDatabaseEnabled(true);
                this.hQk.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.hQk.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.hQk.loadUrl(afVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.hQk != null) {
            this.hQk.removeAllViews();
            this.hQk.getSettings().setBuiltInZoomControls(true);
            this.hQk.setVisibility(8);
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.hQk != null) {
                            q.this.hQk.destroy();
                            q.this.hQk = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.hQk != null) {
            try {
                this.hQk.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.hQk != null) {
            try {
                this.hQk.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
