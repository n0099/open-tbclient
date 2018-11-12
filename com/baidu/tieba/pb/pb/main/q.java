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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.view.PbGiftListView;
import java.util.List;
/* loaded from: classes6.dex */
public class q {
    private OriginalThreadCardView cPE;
    private int fPZ;
    private View fQa;
    private ViewStub fQc;
    private PbGiftListView fQd;
    private ViewStub fQe;
    private OriginalThreadCardView.a fQf;
    private ViewStub fQg;
    private LinearLayout fQh;
    private TextView fQi;
    private TextView fQj;
    private TextView fQk;
    private TextView fQl;
    private View fQm;
    private View fQn;
    private TextView fQo;
    private View.OnClickListener fQp;
    private ViewStub fQr;
    private LinearLayout fQs;
    public View fQt;
    public BaseWebView fQu;
    private final int fPY = 3;
    private int cAm = 0;
    private int fQb = 0;
    private int fQq = 3;

    public q(View view) {
        this.fPZ = 0;
        Context context = view.getContext();
        this.fPZ = com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0200e.ds130);
        this.fQa = view;
        this.fQc = (ViewStub) view.findViewById(e.g.gift_list_viewStub);
        this.fQe = (ViewStub) view.findViewById(e.g.original_thread_info_viewStub);
        this.fQg = (ViewStub) view.findViewById(e.g.multi_forum_viewStub);
        this.fQr = (ViewStub) view.findViewById(e.g.link_thread_viewStub);
    }

    public void rS(int i) {
        this.fQb = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.fQf = aVar;
    }

    public void K(View.OnClickListener onClickListener) {
        this.fQp = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.am amVar, String str, String str2, long j, long j2, long j3) {
        if (amVar == null || com.baidu.tbadk.core.util.v.I(amVar.xN()) || this.fQc == null) {
            if (this.fQd != null) {
                this.fQd.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fQd == null) {
            this.fQd = (PbGiftListView) this.fQc.inflate();
        }
        this.fQd.setVisibility(0);
        this.fQd.a(amVar, str, str2, j, j2, j3);
        this.fQd.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.fQe == null || originalThreadInfo == null) {
            if (this.cPE != null) {
                this.cPE.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cPE == null) {
            this.cPE = (OriginalThreadCardView) this.fQe.inflate();
        }
        this.cPE.setSubClickListener(this.fQf);
        this.cPE.setVisibility(0);
        this.cPE.cQr = this.fQb;
        this.cPE.b(originalThreadInfo);
        if (this.cPE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.cAm = this.cAm > 0 ? this.cAm : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPE.getLayoutParams();
            layoutParams.bottomMargin = this.cAm;
            this.cPE.setLayoutParams(layoutParams);
        }
        this.cPE.onChangeSkinType();
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, Context context) {
        com.baidu.tbadk.core.data.t tVar;
        if (z || dVar == null || com.baidu.tbadk.core.util.v.I(dVar.beP()) || this.fQg == null) {
            if (this.fQh != null) {
                this.fQh.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fQh == null) {
            this.fQh = (LinearLayout) this.fQg.inflate();
            this.fQi = (TextView) this.fQh.findViewById(e.g.tip_source);
            this.fQj = (TextView) this.fQh.findViewById(e.g.view_forum1);
            this.fQk = (TextView) this.fQh.findViewById(e.g.view_forum2);
            this.fQl = (TextView) this.fQh.findViewById(e.g.view_forum3);
            this.fQm = this.fQh.findViewById(e.g.line_divide1);
            this.fQn = this.fQh.findViewById(e.g.line_divide2);
            this.fQo = (TextView) this.fQh.findViewById(e.g.pb_first_floor_multi_forum_del_txt);
        }
        this.fQh.setVisibility(0);
        List<ay> beP = dVar.beP();
        StringBuilder sb = new StringBuilder();
        for (ay ayVar : beP) {
            if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.apA) != null && tVar.isDeleted && ((tVar.anz && (tVar.type == 1 || tVar.type == 2)) || (dVar.bet() != null && dVar.bet().yC() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.bet().yC().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(context.getString(e.j.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.fQo.setVisibility(0);
            this.fQo.setText(String.format(context.getString(e.j.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.fQo.setVisibility(8);
        }
        int H = com.baidu.tbadk.core.util.v.H(dVar.beP());
        if (H > 3) {
            H = 3;
        }
        int i = this.fPZ / H;
        switch (H) {
            case 1:
                this.fQj.setMaxWidth(i);
                this.fQj.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 0)).getForumName()));
                this.fQj.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 0)).getForumName());
                this.fQj.setVisibility(0);
                this.fQk.setVisibility(0);
                this.fQl.setVisibility(0);
                this.fQm.setVisibility(8);
                this.fQn.setVisibility(8);
                break;
            case 2:
                this.fQj.setMaxWidth(i);
                this.fQj.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 0)).getForumName()));
                this.fQj.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 0)).getForumName());
                this.fQj.setVisibility(0);
                this.fQk.setMaxWidth(i);
                this.fQk.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 1)).getForumName()));
                this.fQk.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 1)).getForumName());
                this.fQk.setVisibility(0);
                this.fQl.setVisibility(8);
                this.fQm.setVisibility(0);
                this.fQn.setVisibility(8);
                break;
            case 3:
                this.fQj.setMaxWidth(i);
                this.fQj.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 0)).getForumName()));
                this.fQj.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 0)).getForumName());
                this.fQj.setVisibility(0);
                this.fQk.setMaxWidth(i);
                this.fQk.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 1)).getForumName()));
                this.fQk.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 1)).getForumName());
                this.fQk.setVisibility(0);
                this.fQl.setMaxWidth(i);
                this.fQl.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 2)).getForumName()));
                this.fQl.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.beP(), 2)).getForumName());
                this.fQl.setVisibility(0);
                this.fQm.setVisibility(0);
                this.fQn.setVisibility(0);
                break;
        }
        this.fQj.setOnClickListener(this.fQp);
        this.fQk.setOnClickListener(this.fQp);
        this.fQl.setOnClickListener(this.fQp);
        bgY();
    }

    private void bgY() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fQh != null && this.fQq != skinType) {
            com.baidu.tbadk.core.util.al.c(this.fQi, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fQj, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fQk, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fQl, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.j(this.fQm, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.j(this.fQn, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.c(this.fQo, e.d.cp_cont_d, 1);
            this.fQq = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl())) {
            if ((this.fQu == null || !this.fQu.getIsLoaded()) && adVar.xy() == com.baidu.tbadk.core.data.ad.aon && this.fQr != null) {
                if (adVar.xz()) {
                    if (this.fQs != null) {
                        this.fQs.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.fQs == null) {
                    this.fQs = (LinearLayout) this.fQr.inflate();
                    this.fQt = this.fQs.findViewById(e.g.link_thread_divider);
                    this.fQu = (BaseWebView) this.fQs.findViewById(e.g.link_thread_webview);
                }
                this.fQt.setVisibility(0);
                com.baidu.tbadk.core.util.al.j(this.fQt, e.d.cp_bg_line_c);
                this.fQu.setVisibility(0);
                this.fQu.setFocusable(false);
                this.fQu.setBackgroundColor(0);
                this.fQu.getSettings().setCacheMode(-1);
                this.fQu.setVerticalScrollBarEnabled(false);
                this.fQu.setHorizontalScrollBarEnabled(false);
                this.fQu.getSettings().setAllowFileAccess(true);
                this.fQu.getSettings().setAppCacheEnabled(true);
                this.fQu.getSettings().setDomStorageEnabled(true);
                this.fQu.getSettings().setDatabaseEnabled(true);
                this.fQu.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.fQu.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.fQu.loadUrl(adVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.fQu != null) {
            this.fQu.removeAllViews();
            this.fQu.getSettings().setBuiltInZoomControls(true);
            this.fQu.setVisibility(8);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.fQu != null) {
                            q.this.fQu.destroy();
                            q.this.fQu = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.fQu != null) {
            try {
                this.fQu.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.fQu != null) {
            try {
                this.fQu.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
