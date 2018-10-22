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
    private int fOA;
    private View fOB;
    private ViewStub fOD;
    private PbGiftListView fOE;
    private ViewStub fOF;
    private OriginalThreadCardView.a fOG;
    private ViewStub fOH;
    private LinearLayout fOI;
    private TextView fOJ;
    private TextView fOK;
    private TextView fOL;
    private TextView fOM;
    private View fON;
    private View fOO;
    private TextView fOP;
    private View.OnClickListener fOQ;
    private ViewStub fOS;
    private LinearLayout fOT;
    public View fOU;
    public BaseWebView fOV;
    private final int fOz = 3;
    private int cze = 0;
    private int fOC = 0;
    private int fOR = 3;

    public q(View view) {
        this.fOA = 0;
        Context context = view.getContext();
        this.fOA = com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0175e.ds130);
        this.fOB = view;
        this.fOD = (ViewStub) view.findViewById(e.g.gift_list_viewStub);
        this.fOF = (ViewStub) view.findViewById(e.g.original_thread_info_viewStub);
        this.fOH = (ViewStub) view.findViewById(e.g.multi_forum_viewStub);
        this.fOS = (ViewStub) view.findViewById(e.g.link_thread_viewStub);
    }

    public void rz(int i) {
        this.fOC = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.fOG = aVar;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fOQ = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.am amVar, String str, String str2, long j, long j2, long j3) {
        if (amVar == null || com.baidu.tbadk.core.util.v.J(amVar.xG()) || this.fOD == null) {
            if (this.fOE != null) {
                this.fOE.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fOE == null) {
            this.fOE = (PbGiftListView) this.fOD.inflate();
        }
        this.fOE.setVisibility(0);
        this.fOE.a(amVar, str, str2, j, j2, j3);
        this.fOE.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.fOF == null || originalThreadInfo == null) {
            if (this.cOy != null) {
                this.cOy.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cOy == null) {
            this.cOy = (OriginalThreadCardView) this.fOF.inflate();
        }
        this.cOy.setSubClickListener(this.fOG);
        this.cOy.setVisibility(0);
        this.cOy.cPl = this.fOC;
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
        if (z || dVar == null || com.baidu.tbadk.core.util.v.J(dVar.bfr()) || this.fOH == null) {
            if (this.fOI != null) {
                this.fOI.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fOI == null) {
            this.fOI = (LinearLayout) this.fOH.inflate();
            this.fOJ = (TextView) this.fOI.findViewById(e.g.tip_source);
            this.fOK = (TextView) this.fOI.findViewById(e.g.view_forum1);
            this.fOL = (TextView) this.fOI.findViewById(e.g.view_forum2);
            this.fOM = (TextView) this.fOI.findViewById(e.g.view_forum3);
            this.fON = this.fOI.findViewById(e.g.line_divide1);
            this.fOO = this.fOI.findViewById(e.g.line_divide2);
            this.fOP = (TextView) this.fOI.findViewById(e.g.pb_first_floor_multi_forum_del_txt);
        }
        this.fOI.setVisibility(0);
        List<ay> bfr = dVar.bfr();
        StringBuilder sb = new StringBuilder();
        for (ay ayVar : bfr) {
            if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aoM) != null && tVar.isDeleted && ((tVar.amM && (tVar.type == 1 || tVar.type == 2)) || (dVar.beV() != null && dVar.beV().yv() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.beV().yv().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(context.getString(e.j.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.fOP.setVisibility(0);
            this.fOP.setText(String.format(context.getString(e.j.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.fOP.setVisibility(8);
        }
        int I = com.baidu.tbadk.core.util.v.I(dVar.bfr());
        if (I > 3) {
            I = 3;
        }
        int i = this.fOA / I;
        switch (I) {
            case 1:
                this.fOK.setMaxWidth(i);
                this.fOK.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName()));
                this.fOK.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName());
                this.fOK.setVisibility(0);
                this.fOL.setVisibility(0);
                this.fOM.setVisibility(0);
                this.fON.setVisibility(8);
                this.fOO.setVisibility(8);
                break;
            case 2:
                this.fOK.setMaxWidth(i);
                this.fOK.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName()));
                this.fOK.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName());
                this.fOK.setVisibility(0);
                this.fOL.setMaxWidth(i);
                this.fOL.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 1)).getForumName()));
                this.fOL.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 1)).getForumName());
                this.fOL.setVisibility(0);
                this.fOM.setVisibility(8);
                this.fON.setVisibility(0);
                this.fOO.setVisibility(8);
                break;
            case 3:
                this.fOK.setMaxWidth(i);
                this.fOK.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName()));
                this.fOK.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 0)).getForumName());
                this.fOK.setVisibility(0);
                this.fOL.setMaxWidth(i);
                this.fOL.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 1)).getForumName()));
                this.fOL.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 1)).getForumName());
                this.fOL.setVisibility(0);
                this.fOM.setMaxWidth(i);
                this.fOM.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 2)).getForumName()));
                this.fOM.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bfr(), 2)).getForumName());
                this.fOM.setVisibility(0);
                this.fON.setVisibility(0);
                this.fOO.setVisibility(0);
                break;
        }
        this.fOK.setOnClickListener(this.fOQ);
        this.fOL.setOnClickListener(this.fOQ);
        this.fOM.setOnClickListener(this.fOQ);
        bhB();
    }

    private void bhB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fOI != null && this.fOR != skinType) {
            com.baidu.tbadk.core.util.al.c(this.fOJ, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fOK, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fOL, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fOM, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.j(this.fON, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.j(this.fOO, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.c(this.fOP, e.d.cp_cont_d, 1);
            this.fOR = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl())) {
            if ((this.fOV == null || !this.fOV.getIsLoaded()) && adVar.xq() == com.baidu.tbadk.core.data.ad.anA && this.fOS != null) {
                if (adVar.xr()) {
                    if (this.fOT != null) {
                        this.fOT.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.fOT == null) {
                    this.fOT = (LinearLayout) this.fOS.inflate();
                    this.fOU = this.fOT.findViewById(e.g.link_thread_divider);
                    this.fOV = (BaseWebView) this.fOT.findViewById(e.g.link_thread_webview);
                }
                this.fOU.setVisibility(0);
                com.baidu.tbadk.core.util.al.j(this.fOU, e.d.cp_bg_line_c);
                this.fOV.setVisibility(0);
                this.fOV.setFocusable(false);
                this.fOV.setBackgroundColor(0);
                this.fOV.getSettings().setCacheMode(-1);
                this.fOV.setVerticalScrollBarEnabled(false);
                this.fOV.setHorizontalScrollBarEnabled(false);
                this.fOV.getSettings().setAllowFileAccess(true);
                this.fOV.getSettings().setAppCacheEnabled(true);
                this.fOV.getSettings().setDomStorageEnabled(true);
                this.fOV.getSettings().setDatabaseEnabled(true);
                this.fOV.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.fOV.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.fOV.loadUrl(adVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.fOV != null) {
            this.fOV.removeAllViews();
            this.fOV.getSettings().setBuiltInZoomControls(true);
            this.fOV.setVisibility(8);
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.fOV != null) {
                            q.this.fOV.destroy();
                            q.this.fOV = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.fOV != null) {
            try {
                this.fOV.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.fOV != null) {
            try {
                this.fOV.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
