package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
/* loaded from: classes21.dex */
public class u {
    private View ltm;
    private ViewStub lto;
    private PbGiftListView ltp;
    private ViewStub ltq;
    private LinearLayout lts;
    public View ltt;
    public BaseWebView ltu;
    private int ltl = 0;
    private int ltn = 0;

    public u(View view) {
        this.ltm = view;
        this.lto = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.ltq = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void Gm(int i) {
        this.ltn = i;
    }

    public void a(com.baidu.tbadk.core.data.ay ayVar, String str, String str2, long j, long j2, long j3) {
        if (ayVar == null || com.baidu.tbadk.core.util.y.isEmpty(ayVar.bku()) || this.lto == null) {
            if (this.ltp != null) {
                this.ltp.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ltp == null) {
            this.ltp = (PbGiftListView) this.lto.inflate();
        }
        this.ltp.setVisibility(0);
        this.ltp.a(ayVar, str, str2, j, j2, j3);
        this.ltp.onChangeSkinType();
    }

    public void a(com.baidu.tbadk.core.data.an anVar) {
        if (anVar != null && !com.baidu.tbadk.core.util.au.isEmpty(anVar.getLinkUrl())) {
            if ((this.ltu == null || !this.ltu.getIsLoaded()) && anVar.bjX() == com.baidu.tbadk.core.data.an.ezL && this.ltq != null) {
                if (anVar.bjY()) {
                    if (this.lts != null) {
                        this.lts.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.lts == null) {
                    this.lts = (LinearLayout) this.ltq.inflate();
                    this.ltt = this.lts.findViewById(R.id.link_thread_divider);
                    this.ltu = (BaseWebView) this.lts.findViewById(R.id.link_thread_webview);
                }
                this.ltt.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ltt, R.color.CAM_X0204);
                this.ltu.setVisibility(0);
                this.ltu.setFocusable(false);
                this.ltu.setBackgroundColor(0);
                this.ltu.getSettings().setCacheMode(-1);
                this.ltu.setVerticalScrollBarEnabled(false);
                this.ltu.setHorizontalScrollBarEnabled(false);
                this.ltu.getSettings().setAllowFileAccess(true);
                this.ltu.getSettings().setAppCacheEnabled(true);
                this.ltu.getSettings().setDomStorageEnabled(true);
                this.ltu.getSettings().setDatabaseEnabled(true);
                this.ltu.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.ltu.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.u.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.ltu.loadUrl(anVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.ltu != null) {
            this.ltu.removeAllViews();
            this.ltu.getSettings().setBuiltInZoomControls(true);
            this.ltu.setVisibility(8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.u.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (u.this.ltu != null) {
                            u.this.ltu.destroy();
                            u.this.ltu = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.ltu != null) {
            try {
                this.ltu.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.ltu != null) {
            try {
                this.ltu.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
