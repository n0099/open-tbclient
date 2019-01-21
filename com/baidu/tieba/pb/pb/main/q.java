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
    private OriginalThreadCardView cZN;
    private int gaF;
    private View gaG;
    private ViewStub gaI;
    private PbGiftListView gaJ;
    private ViewStub gaK;
    private OriginalThreadCardView.a gaL;
    private ViewStub gaM;
    private LinearLayout gaN;
    private TextView gaO;
    private TextView gaP;
    private TextView gaQ;
    private TextView gaR;
    private View gaS;
    private View gaT;
    private TextView gaU;
    private View.OnClickListener gaV;
    private ViewStub gaX;
    private LinearLayout gaY;
    public View gaZ;
    public BaseWebView gba;
    private final int gaE = 3;
    private int cFQ = 0;
    private int gaH = 0;
    private int gaW = 3;

    public q(View view) {
        this.gaF = 0;
        Context context = view.getContext();
        this.gaF = com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0210e.ds130);
        this.gaG = view;
        this.gaI = (ViewStub) view.findViewById(e.g.gift_list_viewStub);
        this.gaK = (ViewStub) view.findViewById(e.g.original_thread_info_viewStub);
        this.gaM = (ViewStub) view.findViewById(e.g.multi_forum_viewStub);
        this.gaX = (ViewStub) view.findViewById(e.g.link_thread_viewStub);
    }

    public void sD(int i) {
        this.gaH = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.gaL = aVar;
    }

    public void K(View.OnClickListener onClickListener) {
        this.gaV = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.am amVar, String str, String str2, long j, long j2, long j3) {
        if (amVar == null || com.baidu.tbadk.core.util.v.I(amVar.ze()) || this.gaI == null) {
            if (this.gaJ != null) {
                this.gaJ.setVisibility(8);
                return;
            }
            return;
        }
        if (this.gaJ == null) {
            this.gaJ = (PbGiftListView) this.gaI.inflate();
        }
        this.gaJ.setVisibility(0);
        this.gaJ.a(amVar, str, str2, j, j2, j3);
        this.gaJ.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.gaK == null || originalThreadInfo == null) {
            if (this.cZN != null) {
                this.cZN.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cZN == null) {
            this.cZN = (OriginalThreadCardView) this.gaK.inflate();
        }
        this.cZN.setSubClickListener(this.gaL);
        this.cZN.setVisibility(0);
        this.cZN.daC = this.gaH;
        this.cZN.b(originalThreadInfo);
        if (this.cZN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.cFQ = this.cFQ > 0 ? this.cFQ : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cZN.getLayoutParams();
            layoutParams.bottomMargin = this.cFQ;
            this.cZN.setLayoutParams(layoutParams);
        }
        this.cZN.onChangeSkinType();
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, Context context) {
        com.baidu.tbadk.core.data.t tVar;
        if (z || dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bhV()) || this.gaM == null) {
            if (this.gaN != null) {
                this.gaN.setVisibility(8);
                return;
            }
            return;
        }
        if (this.gaN == null) {
            this.gaN = (LinearLayout) this.gaM.inflate();
            this.gaO = (TextView) this.gaN.findViewById(e.g.tip_source);
            this.gaP = (TextView) this.gaN.findViewById(e.g.view_forum1);
            this.gaQ = (TextView) this.gaN.findViewById(e.g.view_forum2);
            this.gaR = (TextView) this.gaN.findViewById(e.g.view_forum3);
            this.gaS = this.gaN.findViewById(e.g.line_divide1);
            this.gaT = this.gaN.findViewById(e.g.line_divide2);
            this.gaU = (TextView) this.gaN.findViewById(e.g.pb_first_floor_multi_forum_del_txt);
        }
        this.gaN.setVisibility(0);
        List<ay> bhV = dVar.bhV();
        StringBuilder sb = new StringBuilder();
        for (ay ayVar : bhV) {
            if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.atD) != null && tVar.isDeleted && ((tVar.arD && (tVar.type == 1 || tVar.type == 2)) || (dVar.bhz() != null && dVar.bhz().zT() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.bhz().zT().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(context.getString(e.j.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.gaU.setVisibility(0);
            this.gaU.setText(String.format(context.getString(e.j.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.gaU.setVisibility(8);
        }
        int H = com.baidu.tbadk.core.util.v.H(dVar.bhV());
        if (H > 3) {
            H = 3;
        }
        int i = this.gaF / H;
        switch (H) {
            case 1:
                this.gaP.setMaxWidth(i);
                this.gaP.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName()));
                this.gaP.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName());
                this.gaP.setVisibility(0);
                this.gaQ.setVisibility(0);
                this.gaR.setVisibility(0);
                this.gaS.setVisibility(8);
                this.gaT.setVisibility(8);
                break;
            case 2:
                this.gaP.setMaxWidth(i);
                this.gaP.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName()));
                this.gaP.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName());
                this.gaP.setVisibility(0);
                this.gaQ.setMaxWidth(i);
                this.gaQ.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 1)).getForumName()));
                this.gaQ.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 1)).getForumName());
                this.gaQ.setVisibility(0);
                this.gaR.setVisibility(8);
                this.gaS.setVisibility(0);
                this.gaT.setVisibility(8);
                break;
            case 3:
                this.gaP.setMaxWidth(i);
                this.gaP.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName()));
                this.gaP.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 0)).getForumName());
                this.gaP.setVisibility(0);
                this.gaQ.setMaxWidth(i);
                this.gaQ.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 1)).getForumName()));
                this.gaQ.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 1)).getForumName());
                this.gaQ.setVisibility(0);
                this.gaR.setMaxWidth(i);
                this.gaR.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 2)).getForumName()));
                this.gaR.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhV(), 2)).getForumName());
                this.gaR.setVisibility(0);
                this.gaS.setVisibility(0);
                this.gaT.setVisibility(0);
                break;
        }
        this.gaP.setOnClickListener(this.gaV);
        this.gaQ.setOnClickListener(this.gaV);
        this.gaR.setOnClickListener(this.gaV);
        bkf();
    }

    private void bkf() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gaN != null && this.gaW != skinType) {
            com.baidu.tbadk.core.util.al.c(this.gaO, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.gaP, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.gaQ, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.gaR, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.j(this.gaS, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.j(this.gaT, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.c(this.gaU, e.d.cp_cont_d, 1);
            this.gaW = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl())) {
            if ((this.gba == null || !this.gba.getIsLoaded()) && adVar.yP() == com.baidu.tbadk.core.data.ad.asr && this.gaX != null) {
                if (adVar.yQ()) {
                    if (this.gaY != null) {
                        this.gaY.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.gaY == null) {
                    this.gaY = (LinearLayout) this.gaX.inflate();
                    this.gaZ = this.gaY.findViewById(e.g.link_thread_divider);
                    this.gba = (BaseWebView) this.gaY.findViewById(e.g.link_thread_webview);
                }
                this.gaZ.setVisibility(0);
                com.baidu.tbadk.core.util.al.j(this.gaZ, e.d.cp_bg_line_c);
                this.gba.setVisibility(0);
                this.gba.setFocusable(false);
                this.gba.setBackgroundColor(0);
                this.gba.getSettings().setCacheMode(-1);
                this.gba.setVerticalScrollBarEnabled(false);
                this.gba.setHorizontalScrollBarEnabled(false);
                this.gba.getSettings().setAllowFileAccess(true);
                this.gba.getSettings().setAppCacheEnabled(true);
                this.gba.getSettings().setDomStorageEnabled(true);
                this.gba.getSettings().setDatabaseEnabled(true);
                this.gba.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.gba.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.gba.loadUrl(adVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.gba != null) {
            this.gba.removeAllViews();
            this.gba.getSettings().setBuiltInZoomControls(true);
            this.gba.setVisibility(8);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.gba != null) {
                            q.this.gba.destroy();
                            q.this.gba = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.gba != null) {
            try {
                this.gba.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.gba != null) {
            try {
                this.gba.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
