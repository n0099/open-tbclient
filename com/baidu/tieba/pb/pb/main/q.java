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
    private OriginalThreadCardView cOy;
    private View fOA;
    private ViewStub fOC;
    private PbGiftListView fOD;
    private ViewStub fOE;
    private OriginalThreadCardView.a fOF;
    private ViewStub fOG;
    private LinearLayout fOH;
    private TextView fOI;
    private TextView fOJ;
    private TextView fOK;
    private TextView fOL;
    private View fOM;
    private View fON;
    private TextView fOO;
    private View.OnClickListener fOP;
    private ViewStub fOR;
    private LinearLayout fOS;
    public View fOT;
    public BaseWebView fOU;
    private int fOz;
    private final int fOy = 3;
    private int cze = 0;
    private int fOB = 0;
    private int fOQ = 3;

    public q(View view) {
        this.fOz = 0;
        Context context = view.getContext();
        this.fOz = com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0175e.ds130);
        this.fOA = view;
        this.fOC = (ViewStub) view.findViewById(e.g.gift_list_viewStub);
        this.fOE = (ViewStub) view.findViewById(e.g.original_thread_info_viewStub);
        this.fOG = (ViewStub) view.findViewById(e.g.multi_forum_viewStub);
        this.fOR = (ViewStub) view.findViewById(e.g.link_thread_viewStub);
    }

    public void rz(int i) {
        this.fOB = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.fOF = aVar;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fOP = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.am amVar, String str, String str2, long j, long j2, long j3) {
        if (amVar == null || com.baidu.tbadk.core.util.v.J(amVar.xG()) || this.fOC == null) {
            if (this.fOD != null) {
                this.fOD.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fOD == null) {
            this.fOD = (PbGiftListView) this.fOC.inflate();
        }
        this.fOD.setVisibility(0);
        this.fOD.a(amVar, str, str2, j, j2, j3);
        this.fOD.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.fOE == null || originalThreadInfo == null) {
            if (this.cOy != null) {
                this.cOy.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cOy == null) {
            this.cOy = (OriginalThreadCardView) this.fOE.inflate();
        }
        this.cOy.setSubClickListener(this.fOF);
        this.cOy.setVisibility(0);
        this.cOy.cPl = this.fOB;
        this.cOy.b(originalThreadInfo);
        if (this.cOy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.cze = this.cze > 0 ? this.cze : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOy.getLayoutParams();
            layoutParams.bottomMargin = this.cze;
            this.cOy.setLayoutParams(layoutParams);
        }
        this.cOy.onChangeSkinType();
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, Context context) {
        com.baidu.tbadk.core.data.t tVar;
        if (z || dVar == null || com.baidu.tbadk.core.util.v.J(dVar.bfr()) || this.fOG == null) {
            if (this.fOH != null) {
                this.fOH.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fOH == null) {
            this.fOH = (LinearLayout) this.fOG.inflate();
            this.fOI = (TextView) this.fOH.findViewById(e.g.tip_source);
            this.fOJ = (TextView) this.fOH.findViewById(e.g.view_forum1);
            this.fOK = (TextView) this.fOH.findViewById(e.g.view_forum2);
            this.fOL = (TextView) this.fOH.findViewById(e.g.view_forum3);
            this.fOM = this.fOH.findViewById(e.g.line_divide1);
            this.fON = this.fOH.findViewById(e.g.line_divide2);
            this.fOO = (TextView) this.fOH.findViewById(e.g.pb_first_floor_multi_forum_del_txt);
        }
        this.fOH.setVisibility(0);
        List<ay> bfr = dVar.bfr();
        StringBuilder sb = new StringBuilder();
        for (ay ayVar : bfr) {
            if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aoM) != null && tVar.isDeleted && ((tVar.amM && (tVar.type == 1 || tVar.type == 2)) || (dVar.beV() != null && dVar.beV().yv() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.beV().yv().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(context.getString(e.j.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.fOO.setVisibility(0);
            this.fOO.setText(String.format(context.getString(e.j.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.fOO.setVisibility(8);
        }
        int I = com.baidu.tbadk.core.util.v.I(dVar.bfr());
        if (I > 3) {
            I = 3;
        }
        int i = this.fOz / I;
        switch (I) {
            case 1:
                this.fOJ.setMaxWidth(i);
                this.fOJ.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName()));
                this.fOJ.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName());
                this.fOJ.setVisibility(0);
                this.fOK.setVisibility(0);
                this.fOL.setVisibility(0);
                this.fOM.setVisibility(8);
                this.fON.setVisibility(8);
                break;
            case 2:
                this.fOJ.setMaxWidth(i);
                this.fOJ.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName()));
                this.fOJ.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName());
                this.fOJ.setVisibility(0);
                this.fOK.setMaxWidth(i);
                this.fOK.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 1)).getForumName()));
                this.fOK.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 1)).getForumName());
                this.fOK.setVisibility(0);
                this.fOL.setVisibility(8);
                this.fOM.setVisibility(0);
                this.fON.setVisibility(8);
                break;
            case 3:
                this.fOJ.setMaxWidth(i);
                this.fOJ.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName()));
                this.fOJ.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName());
                this.fOJ.setVisibility(0);
                this.fOK.setMaxWidth(i);
                this.fOK.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 1)).getForumName()));
                this.fOK.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 1)).getForumName());
                this.fOK.setVisibility(0);
                this.fOL.setMaxWidth(i);
                this.fOL.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 2)).getForumName()));
                this.fOL.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 2)).getForumName());
                this.fOL.setVisibility(0);
                this.fOM.setVisibility(0);
                this.fON.setVisibility(0);
                break;
        }
        this.fOJ.setOnClickListener(this.fOP);
        this.fOK.setOnClickListener(this.fOP);
        this.fOL.setOnClickListener(this.fOP);
        bhB();
    }

    private void bhB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fOH != null && this.fOQ != skinType) {
            com.baidu.tbadk.core.util.al.c(this.fOI, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fOJ, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fOK, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fOL, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.j(this.fOM, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.j(this.fON, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.c(this.fOO, e.d.cp_cont_d, 1);
            this.fOQ = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl())) {
            if ((this.fOU == null || !this.fOU.getIsLoaded()) && adVar.xq() == com.baidu.tbadk.core.data.ad.anA && this.fOR != null) {
                if (adVar.xr()) {
                    if (this.fOS != null) {
                        this.fOS.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.fOS == null) {
                    this.fOS = (LinearLayout) this.fOR.inflate();
                    this.fOT = this.fOS.findViewById(e.g.link_thread_divider);
                    this.fOU = (BaseWebView) this.fOS.findViewById(e.g.link_thread_webview);
                }
                this.fOT.setVisibility(0);
                com.baidu.tbadk.core.util.al.j(this.fOT, e.d.cp_bg_line_c);
                this.fOU.setVisibility(0);
                this.fOU.setFocusable(false);
                this.fOU.setBackgroundColor(0);
                this.fOU.getSettings().setCacheMode(-1);
                this.fOU.setVerticalScrollBarEnabled(false);
                this.fOU.setHorizontalScrollBarEnabled(false);
                this.fOU.getSettings().setAllowFileAccess(true);
                this.fOU.getSettings().setAppCacheEnabled(true);
                this.fOU.getSettings().setDomStorageEnabled(true);
                this.fOU.getSettings().setDatabaseEnabled(true);
                this.fOU.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.fOU.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.fOU.loadUrl(adVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.fOU != null) {
            this.fOU.removeAllViews();
            this.fOU.getSettings().setBuiltInZoomControls(true);
            this.fOU.setVisibility(8);
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.fOU != null) {
                            q.this.fOU.destroy();
                            q.this.fOU = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.fOU != null) {
            try {
                this.fOU.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.fOU != null) {
            try {
                this.fOU.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
