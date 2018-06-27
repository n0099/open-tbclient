package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.PbGiftListView;
import java.util.List;
/* loaded from: classes2.dex */
public class q {
    private OriginalThreadCardView cxM;
    private LinearLayout fzA;
    public View fzB;
    public BaseWebView fzC;
    private int fzh;
    private View fzi;
    private ViewStub fzk;
    private PbGiftListView fzl;
    private ViewStub fzm;
    private OriginalThreadCardView.a fzn;
    private ViewStub fzo;
    private LinearLayout fzp;
    private TextView fzq;
    private TextView fzr;
    private TextView fzs;
    private TextView fzt;
    private View fzu;
    private View fzv;
    private TextView fzw;
    private View.OnClickListener fzx;
    private ViewStub fzz;
    private final int fzg = 3;
    private int cjd = 0;
    private int fzj = 0;
    private int fzy = 3;

    public q(View view) {
        this.fzh = 0;
        Context context = view.getContext();
        this.fzh = com.baidu.adp.lib.util.l.ah(context) - com.baidu.adp.lib.util.l.e(context, d.e.ds130);
        this.fzi = view;
        this.fzk = (ViewStub) view.findViewById(d.g.gift_list_viewStub);
        this.fzm = (ViewStub) view.findViewById(d.g.original_thread_info_viewStub);
        this.fzo = (ViewStub) view.findViewById(d.g.multi_forum_viewStub);
        this.fzz = (ViewStub) view.findViewById(d.g.link_thread_viewStub);
    }

    public void qF(int i) {
        this.fzj = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.fzn = aVar;
    }

    public void K(View.OnClickListener onClickListener) {
        this.fzx = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.an anVar, String str, String str2, long j, long j2, long j3) {
        if (anVar == null || com.baidu.tbadk.core.util.w.A(anVar.uI()) || this.fzk == null) {
            if (this.fzl != null) {
                this.fzl.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fzl == null) {
            this.fzl = (PbGiftListView) this.fzk.inflate();
        }
        this.fzl.setVisibility(0);
        this.fzl.a(anVar, str, str2, j, j2, j3);
        this.fzl.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.fzm == null || originalThreadInfo == null) {
            if (this.cxM != null) {
                this.cxM.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cxM == null) {
            this.cxM = (OriginalThreadCardView) this.fzm.inflate();
        }
        this.cxM.setVisibility(0);
        this.cxM.cyz = this.fzj;
        this.cxM.b(originalThreadInfo);
        if (this.cxM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.cjd = this.cjd > 0 ? this.cjd : com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cxM.getLayoutParams();
            layoutParams.bottomMargin = this.cjd;
            this.cxM.setLayoutParams(layoutParams);
        }
        this.cxM.onChangeSkinType();
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, Context context) {
        com.baidu.tbadk.core.data.u uVar;
        if (z || dVar == null || com.baidu.tbadk.core.util.w.A(dVar.bbq()) || this.fzo == null) {
            if (this.fzp != null) {
                this.fzp.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fzp == null) {
            this.fzp = (LinearLayout) this.fzo.inflate();
            this.fzq = (TextView) this.fzp.findViewById(d.g.tip_source);
            this.fzr = (TextView) this.fzp.findViewById(d.g.view_forum1);
            this.fzs = (TextView) this.fzp.findViewById(d.g.view_forum2);
            this.fzt = (TextView) this.fzp.findViewById(d.g.view_forum3);
            this.fzu = this.fzp.findViewById(d.g.line_divide1);
            this.fzv = this.fzp.findViewById(d.g.line_divide2);
            this.fzw = (TextView) this.fzp.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
        }
        this.fzp.setVisibility(0);
        List<az> bbq = dVar.bbq();
        StringBuilder sb = new StringBuilder();
        for (az azVar : bbq) {
            if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (uVar = azVar.ahV) != null && uVar.isDeleted && ((uVar.afV && (uVar.type == 1 || uVar.type == 2)) || (dVar.baV() != null && dVar.baV().vw() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.baV().vw().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.j(azVar.getForumName(), 12)).append(context.getString(d.k.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.fzw.setVisibility(0);
            this.fzw.setText(String.format(context.getString(d.k.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.fzw.setVisibility(8);
        }
        int z2 = com.baidu.tbadk.core.util.w.z(dVar.bbq());
        if (z2 > 3) {
            z2 = 3;
        }
        int i = this.fzh / z2;
        switch (z2) {
            case 1:
                this.fzr.setMaxWidth(i);
                this.fzr.setText(context.getString(d.k.chosen_pb_original_bar, ((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 0)).getForumName()));
                this.fzr.setTag(((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 0)).getForumName());
                this.fzr.setVisibility(0);
                this.fzs.setVisibility(0);
                this.fzt.setVisibility(0);
                this.fzu.setVisibility(8);
                this.fzv.setVisibility(8);
                break;
            case 2:
                this.fzr.setMaxWidth(i);
                this.fzr.setText(context.getString(d.k.chosen_pb_original_bar, ((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 0)).getForumName()));
                this.fzr.setTag(((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 0)).getForumName());
                this.fzr.setVisibility(0);
                this.fzs.setMaxWidth(i);
                this.fzs.setText(context.getString(d.k.chosen_pb_original_bar, ((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 1)).getForumName()));
                this.fzs.setTag(((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 1)).getForumName());
                this.fzs.setVisibility(0);
                this.fzt.setVisibility(8);
                this.fzu.setVisibility(0);
                this.fzv.setVisibility(8);
                break;
            case 3:
                this.fzr.setMaxWidth(i);
                this.fzr.setText(context.getString(d.k.chosen_pb_original_bar, ((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 0)).getForumName()));
                this.fzr.setTag(((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 0)).getForumName());
                this.fzr.setVisibility(0);
                this.fzs.setMaxWidth(i);
                this.fzs.setText(context.getString(d.k.chosen_pb_original_bar, ((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 1)).getForumName()));
                this.fzs.setTag(((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 1)).getForumName());
                this.fzs.setVisibility(0);
                this.fzt.setMaxWidth(i);
                this.fzt.setText(context.getString(d.k.chosen_pb_original_bar, ((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 2)).getForumName()));
                this.fzt.setTag(((az) com.baidu.tbadk.core.util.w.d(dVar.bbq(), 2)).getForumName());
                this.fzt.setVisibility(0);
                this.fzu.setVisibility(0);
                this.fzv.setVisibility(0);
                break;
        }
        this.fzr.setOnClickListener(this.fzx);
        this.fzs.setOnClickListener(this.fzx);
        this.fzt.setOnClickListener(this.fzx);
        bdA();
    }

    private void bdA() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fzp != null && this.fzy != skinType) {
            com.baidu.tbadk.core.util.am.c(this.fzq, d.C0142d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.c(this.fzr, d.C0142d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.c(this.fzs, d.C0142d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.c(this.fzt, d.C0142d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.j(this.fzu, d.C0142d.cp_cont_e);
            com.baidu.tbadk.core.util.am.j(this.fzv, d.C0142d.cp_cont_e);
            com.baidu.tbadk.core.util.am.c(this.fzw, d.C0142d.cp_cont_d, 1);
            this.fzy = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ae aeVar) {
        if (aeVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(aeVar.getLinkUrl())) {
            if ((this.fzC == null || !this.fzC.getIsLoaded()) && aeVar.us() == com.baidu.tbadk.core.data.ae.agL && this.fzz != null) {
                if (aeVar.ut()) {
                    if (this.fzA != null) {
                        this.fzA.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.fzA == null) {
                    this.fzA = (LinearLayout) this.fzz.inflate();
                    this.fzB = this.fzA.findViewById(d.g.link_thread_divider);
                    this.fzC = (BaseWebView) this.fzA.findViewById(d.g.link_thread_webview);
                }
                this.fzB.setVisibility(0);
                com.baidu.tbadk.core.util.am.j(this.fzB, d.C0142d.cp_bg_line_c);
                this.fzC.setVisibility(0);
                this.fzC.setFocusable(false);
                this.fzC.setBackgroundColor(0);
                this.fzC.getSettings().setCacheMode(-1);
                this.fzC.setVerticalScrollBarEnabled(false);
                this.fzC.setHorizontalScrollBarEnabled(false);
                this.fzC.getSettings().setAllowFileAccess(true);
                this.fzC.getSettings().setAppCacheEnabled(true);
                this.fzC.getSettings().setDomStorageEnabled(true);
                this.fzC.getSettings().setDatabaseEnabled(true);
                this.fzC.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.fzC.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.fzC.loadUrl(aeVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.fzC != null) {
            this.fzC.removeAllViews();
            this.fzC.getSettings().setBuiltInZoomControls(true);
            this.fzC.setVisibility(8);
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.fzC != null) {
                            q.this.fzC.destroy();
                            q.this.fzC = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.fzC != null) {
            try {
                this.fzC.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.fzC != null) {
            try {
                this.fzC.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
