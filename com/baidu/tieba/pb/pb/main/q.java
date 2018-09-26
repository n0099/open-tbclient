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
/* loaded from: classes2.dex */
public class q {
    private OriginalThreadCardView cGe;
    private int fGY;
    private View fGZ;
    private ViewStub fHb;
    private PbGiftListView fHc;
    private ViewStub fHd;
    private OriginalThreadCardView.a fHe;
    private ViewStub fHf;
    private LinearLayout fHg;
    private TextView fHh;
    private TextView fHi;
    private TextView fHj;
    private TextView fHk;
    private View fHl;
    private View fHm;
    private TextView fHn;
    private View.OnClickListener fHo;
    private ViewStub fHq;
    private LinearLayout fHr;
    public View fHs;
    public BaseWebView fHt;
    private final int fGX = 3;
    private int cqB = 0;
    private int fHa = 0;
    private int fHp = 3;

    public q(View view) {
        this.fGY = 0;
        Context context = view.getContext();
        this.fGY = com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0141e.ds130);
        this.fGZ = view;
        this.fHb = (ViewStub) view.findViewById(e.g.gift_list_viewStub);
        this.fHd = (ViewStub) view.findViewById(e.g.original_thread_info_viewStub);
        this.fHf = (ViewStub) view.findViewById(e.g.multi_forum_viewStub);
        this.fHq = (ViewStub) view.findViewById(e.g.link_thread_viewStub);
    }

    public void rc(int i) {
        this.fHa = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.fHe = aVar;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fHo = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.am amVar, String str, String str2, long j, long j2, long j3) {
        if (amVar == null || com.baidu.tbadk.core.util.v.z(amVar.vx()) || this.fHb == null) {
            if (this.fHc != null) {
                this.fHc.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fHc == null) {
            this.fHc = (PbGiftListView) this.fHb.inflate();
        }
        this.fHc.setVisibility(0);
        this.fHc.a(amVar, str, str2, j, j2, j3);
        this.fHc.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.fHd == null || originalThreadInfo == null) {
            if (this.cGe != null) {
                this.cGe.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cGe == null) {
            this.cGe = (OriginalThreadCardView) this.fHd.inflate();
        }
        this.cGe.setSubClickListener(this.fHe);
        this.cGe.setVisibility(0);
        this.cGe.cGR = this.fHa;
        this.cGe.b(originalThreadInfo);
        if (this.cGe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.cqB = this.cqB > 0 ? this.cqB : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cGe.getLayoutParams();
            layoutParams.bottomMargin = this.cqB;
            this.cGe.setLayoutParams(layoutParams);
        }
        this.cGe.onChangeSkinType();
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, Context context) {
        com.baidu.tbadk.core.data.t tVar;
        if (z || dVar == null || com.baidu.tbadk.core.util.v.z(dVar.bcf()) || this.fHf == null) {
            if (this.fHg != null) {
                this.fHg.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fHg == null) {
            this.fHg = (LinearLayout) this.fHf.inflate();
            this.fHh = (TextView) this.fHg.findViewById(e.g.tip_source);
            this.fHi = (TextView) this.fHg.findViewById(e.g.view_forum1);
            this.fHj = (TextView) this.fHg.findViewById(e.g.view_forum2);
            this.fHk = (TextView) this.fHg.findViewById(e.g.view_forum3);
            this.fHl = this.fHg.findViewById(e.g.line_divide1);
            this.fHm = this.fHg.findViewById(e.g.line_divide2);
            this.fHn = (TextView) this.fHg.findViewById(e.g.pb_first_floor_multi_forum_del_txt);
        }
        this.fHg.setVisibility(0);
        List<ay> bcf = dVar.bcf();
        StringBuilder sb = new StringBuilder();
        for (ay ayVar : bcf) {
            if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.ajR) != null && tVar.isDeleted && ((tVar.ahQ && (tVar.type == 1 || tVar.type == 2)) || (dVar.bbJ() != null && dVar.bbJ().wm() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.bbJ().wm().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(context.getString(e.j.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.fHn.setVisibility(0);
            this.fHn.setText(String.format(context.getString(e.j.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.fHn.setVisibility(8);
        }
        int y = com.baidu.tbadk.core.util.v.y(dVar.bcf());
        if (y > 3) {
            y = 3;
        }
        int i = this.fGY / y;
        switch (y) {
            case 1:
                this.fHi.setMaxWidth(i);
                this.fHi.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 0)).getForumName()));
                this.fHi.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 0)).getForumName());
                this.fHi.setVisibility(0);
                this.fHj.setVisibility(0);
                this.fHk.setVisibility(0);
                this.fHl.setVisibility(8);
                this.fHm.setVisibility(8);
                break;
            case 2:
                this.fHi.setMaxWidth(i);
                this.fHi.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 0)).getForumName()));
                this.fHi.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 0)).getForumName());
                this.fHi.setVisibility(0);
                this.fHj.setMaxWidth(i);
                this.fHj.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 1)).getForumName()));
                this.fHj.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 1)).getForumName());
                this.fHj.setVisibility(0);
                this.fHk.setVisibility(8);
                this.fHl.setVisibility(0);
                this.fHm.setVisibility(8);
                break;
            case 3:
                this.fHi.setMaxWidth(i);
                this.fHi.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 0)).getForumName()));
                this.fHi.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 0)).getForumName());
                this.fHi.setVisibility(0);
                this.fHj.setMaxWidth(i);
                this.fHj.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 1)).getForumName()));
                this.fHj.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 1)).getForumName());
                this.fHj.setVisibility(0);
                this.fHk.setMaxWidth(i);
                this.fHk.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 2)).getForumName()));
                this.fHk.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bcf(), 2)).getForumName());
                this.fHk.setVisibility(0);
                this.fHl.setVisibility(0);
                this.fHm.setVisibility(0);
                break;
        }
        this.fHi.setOnClickListener(this.fHo);
        this.fHj.setOnClickListener(this.fHo);
        this.fHk.setOnClickListener(this.fHo);
        bep();
    }

    private void bep() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fHg != null && this.fHp != skinType) {
            com.baidu.tbadk.core.util.al.c(this.fHh, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fHi, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fHj, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fHk, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.j(this.fHl, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.j(this.fHm, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.c(this.fHn, e.d.cp_cont_d, 1);
            this.fHp = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl())) {
            if ((this.fHt == null || !this.fHt.getIsLoaded()) && adVar.vh() == com.baidu.tbadk.core.data.ad.aiF && this.fHq != null) {
                if (adVar.vi()) {
                    if (this.fHr != null) {
                        this.fHr.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.fHr == null) {
                    this.fHr = (LinearLayout) this.fHq.inflate();
                    this.fHs = this.fHr.findViewById(e.g.link_thread_divider);
                    this.fHt = (BaseWebView) this.fHr.findViewById(e.g.link_thread_webview);
                }
                this.fHs.setVisibility(0);
                com.baidu.tbadk.core.util.al.j(this.fHs, e.d.cp_bg_line_c);
                this.fHt.setVisibility(0);
                this.fHt.setFocusable(false);
                this.fHt.setBackgroundColor(0);
                this.fHt.getSettings().setCacheMode(-1);
                this.fHt.setVerticalScrollBarEnabled(false);
                this.fHt.setHorizontalScrollBarEnabled(false);
                this.fHt.getSettings().setAllowFileAccess(true);
                this.fHt.getSettings().setAppCacheEnabled(true);
                this.fHt.getSettings().setDomStorageEnabled(true);
                this.fHt.getSettings().setDatabaseEnabled(true);
                this.fHt.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.fHt.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.fHt.loadUrl(adVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.fHt != null) {
            this.fHt.removeAllViews();
            this.fHt.getSettings().setBuiltInZoomControls(true);
            this.fHt.setVisibility(8);
            com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.fHt != null) {
                            q.this.fHt.destroy();
                            q.this.fHt = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.fHt != null) {
            try {
                this.fHt.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.fHt != null) {
            try {
                this.fHt.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
