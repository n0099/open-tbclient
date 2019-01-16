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
    private OriginalThreadCardView cZM;
    private int gaE;
    private View gaF;
    private ViewStub gaH;
    private PbGiftListView gaI;
    private ViewStub gaJ;
    private OriginalThreadCardView.a gaK;
    private ViewStub gaL;
    private LinearLayout gaM;
    private TextView gaN;
    private TextView gaO;
    private TextView gaP;
    private TextView gaQ;
    private View gaR;
    private View gaS;
    private TextView gaT;
    private View.OnClickListener gaU;
    private ViewStub gaW;
    private LinearLayout gaX;
    public View gaY;
    public BaseWebView gaZ;
    private final int gaD = 3;
    private int cFP = 0;
    private int gaG = 0;
    private int gaV = 3;

    public q(View view) {
        this.gaE = 0;
        Context context = view.getContext();
        this.gaE = com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0210e.ds130);
        this.gaF = view;
        this.gaH = (ViewStub) view.findViewById(e.g.gift_list_viewStub);
        this.gaJ = (ViewStub) view.findViewById(e.g.original_thread_info_viewStub);
        this.gaL = (ViewStub) view.findViewById(e.g.multi_forum_viewStub);
        this.gaW = (ViewStub) view.findViewById(e.g.link_thread_viewStub);
    }

    public void sD(int i) {
        this.gaG = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.gaK = aVar;
    }

    public void K(View.OnClickListener onClickListener) {
        this.gaU = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.am amVar, String str, String str2, long j, long j2, long j3) {
        if (amVar == null || com.baidu.tbadk.core.util.v.I(amVar.ze()) || this.gaH == null) {
            if (this.gaI != null) {
                this.gaI.setVisibility(8);
                return;
            }
            return;
        }
        if (this.gaI == null) {
            this.gaI = (PbGiftListView) this.gaH.inflate();
        }
        this.gaI.setVisibility(0);
        this.gaI.a(amVar, str, str2, j, j2, j3);
        this.gaI.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.gaJ == null || originalThreadInfo == null) {
            if (this.cZM != null) {
                this.cZM.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cZM == null) {
            this.cZM = (OriginalThreadCardView) this.gaJ.inflate();
        }
        this.cZM.setSubClickListener(this.gaK);
        this.cZM.setVisibility(0);
        this.cZM.daB = this.gaG;
        this.cZM.b(originalThreadInfo);
        if (this.cZM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.cFP = this.cFP > 0 ? this.cFP : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cZM.getLayoutParams();
            layoutParams.bottomMargin = this.cFP;
            this.cZM.setLayoutParams(layoutParams);
        }
        this.cZM.onChangeSkinType();
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, Context context) {
        com.baidu.tbadk.core.data.t tVar;
        if (z || dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bhV()) || this.gaL == null) {
            if (this.gaM != null) {
                this.gaM.setVisibility(8);
                return;
            }
            return;
        }
        if (this.gaM == null) {
            this.gaM = (LinearLayout) this.gaL.inflate();
            this.gaN = (TextView) this.gaM.findViewById(e.g.tip_source);
            this.gaO = (TextView) this.gaM.findViewById(e.g.view_forum1);
            this.gaP = (TextView) this.gaM.findViewById(e.g.view_forum2);
            this.gaQ = (TextView) this.gaM.findViewById(e.g.view_forum3);
            this.gaR = this.gaM.findViewById(e.g.line_divide1);
            this.gaS = this.gaM.findViewById(e.g.line_divide2);
            this.gaT = (TextView) this.gaM.findViewById(e.g.pb_first_floor_multi_forum_del_txt);
        }
        this.gaM.setVisibility(0);
        List<ay> bhV = dVar.bhV();
        StringBuilder sb = new StringBuilder();
        for (ay ayVar : bhV) {
            if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.atC) != null && tVar.isDeleted && ((tVar.arC && (tVar.type == 1 || tVar.type == 2)) || (dVar.bhz() != null && dVar.bhz().zT() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.bhz().zT().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(context.getString(e.j.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.gaT.setVisibility(0);
            this.gaT.setText(String.format(context.getString(e.j.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.gaT.setVisibility(8);
        }
        int H = com.baidu.tbadk.core.util.v.H(dVar.bhV());
        if (H > 3) {
            H = 3;
        }
        int i = this.gaE / H;
        switch (H) {
            case 1:
                this.gaO.setMaxWidth(i);
                this.gaO.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName()));
                this.gaO.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName());
                this.gaO.setVisibility(0);
                this.gaP.setVisibility(0);
                this.gaQ.setVisibility(0);
                this.gaR.setVisibility(8);
                this.gaS.setVisibility(8);
                break;
            case 2:
                this.gaO.setMaxWidth(i);
                this.gaO.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName()));
                this.gaO.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName());
                this.gaO.setVisibility(0);
                this.gaP.setMaxWidth(i);
                this.gaP.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 1)).getForumName()));
                this.gaP.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 1)).getForumName());
                this.gaP.setVisibility(0);
                this.gaQ.setVisibility(8);
                this.gaR.setVisibility(0);
                this.gaS.setVisibility(8);
                break;
            case 3:
                this.gaO.setMaxWidth(i);
                this.gaO.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName()));
                this.gaO.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName());
                this.gaO.setVisibility(0);
                this.gaP.setMaxWidth(i);
                this.gaP.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 1)).getForumName()));
                this.gaP.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 1)).getForumName());
                this.gaP.setVisibility(0);
                this.gaQ.setMaxWidth(i);
                this.gaQ.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 2)).getForumName()));
                this.gaQ.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 2)).getForumName());
                this.gaQ.setVisibility(0);
                this.gaR.setVisibility(0);
                this.gaS.setVisibility(0);
                break;
        }
        this.gaO.setOnClickListener(this.gaU);
        this.gaP.setOnClickListener(this.gaU);
        this.gaQ.setOnClickListener(this.gaU);
        bkf();
    }

    private void bkf() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gaM != null && this.gaV != skinType) {
            com.baidu.tbadk.core.util.al.c(this.gaN, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.gaO, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.gaP, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.gaQ, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.j(this.gaR, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.j(this.gaS, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.c(this.gaT, e.d.cp_cont_d, 1);
            this.gaV = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl())) {
            if ((this.gaZ == null || !this.gaZ.getIsLoaded()) && adVar.yP() == com.baidu.tbadk.core.data.ad.asq && this.gaW != null) {
                if (adVar.yQ()) {
                    if (this.gaX != null) {
                        this.gaX.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.gaX == null) {
                    this.gaX = (LinearLayout) this.gaW.inflate();
                    this.gaY = this.gaX.findViewById(e.g.link_thread_divider);
                    this.gaZ = (BaseWebView) this.gaX.findViewById(e.g.link_thread_webview);
                }
                this.gaY.setVisibility(0);
                com.baidu.tbadk.core.util.al.j(this.gaY, e.d.cp_bg_line_c);
                this.gaZ.setVisibility(0);
                this.gaZ.setFocusable(false);
                this.gaZ.setBackgroundColor(0);
                this.gaZ.getSettings().setCacheMode(-1);
                this.gaZ.setVerticalScrollBarEnabled(false);
                this.gaZ.setHorizontalScrollBarEnabled(false);
                this.gaZ.getSettings().setAllowFileAccess(true);
                this.gaZ.getSettings().setAppCacheEnabled(true);
                this.gaZ.getSettings().setDomStorageEnabled(true);
                this.gaZ.getSettings().setDatabaseEnabled(true);
                this.gaZ.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.gaZ.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.gaZ.loadUrl(adVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.gaZ != null) {
            this.gaZ.removeAllViews();
            this.gaZ.getSettings().setBuiltInZoomControls(true);
            this.gaZ.setVisibility(8);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.gaZ != null) {
                            q.this.gaZ.destroy();
                            q.this.gaZ = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.gaZ != null) {
            try {
                this.gaZ.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.gaZ != null) {
            try {
                this.gaZ.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
