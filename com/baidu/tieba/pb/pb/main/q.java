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
    private OriginalThreadCardView cZb;
    private int fZH;
    private View fZI;
    private ViewStub fZK;
    private PbGiftListView fZL;
    private ViewStub fZM;
    private OriginalThreadCardView.a fZN;
    private ViewStub fZO;
    private LinearLayout fZP;
    private TextView fZQ;
    private TextView fZR;
    private TextView fZS;
    private TextView fZT;
    private View fZU;
    private View fZV;
    private TextView fZW;
    private View.OnClickListener fZX;
    private ViewStub fZZ;
    private LinearLayout gaa;
    public View gab;
    public BaseWebView gac;
    private final int fZG = 3;
    private int cFe = 0;
    private int fZJ = 0;
    private int fZY = 3;

    public q(View view) {
        this.fZH = 0;
        Context context = view.getContext();
        this.fZH = com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0210e.ds130);
        this.fZI = view;
        this.fZK = (ViewStub) view.findViewById(e.g.gift_list_viewStub);
        this.fZM = (ViewStub) view.findViewById(e.g.original_thread_info_viewStub);
        this.fZO = (ViewStub) view.findViewById(e.g.multi_forum_viewStub);
        this.fZZ = (ViewStub) view.findViewById(e.g.link_thread_viewStub);
    }

    public void sz(int i) {
        this.fZJ = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.fZN = aVar;
    }

    public void K(View.OnClickListener onClickListener) {
        this.fZX = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.am amVar, String str, String str2, long j, long j2, long j3) {
        if (amVar == null || com.baidu.tbadk.core.util.v.I(amVar.yR()) || this.fZK == null) {
            if (this.fZL != null) {
                this.fZL.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fZL == null) {
            this.fZL = (PbGiftListView) this.fZK.inflate();
        }
        this.fZL.setVisibility(0);
        this.fZL.a(amVar, str, str2, j, j2, j3);
        this.fZL.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.fZM == null || originalThreadInfo == null) {
            if (this.cZb != null) {
                this.cZb.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cZb == null) {
            this.cZb = (OriginalThreadCardView) this.fZM.inflate();
        }
        this.cZb.setSubClickListener(this.fZN);
        this.cZb.setVisibility(0);
        this.cZb.cZO = this.fZJ;
        this.cZb.b(originalThreadInfo);
        if (this.cZb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.cFe = this.cFe > 0 ? this.cFe : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cZb.getLayoutParams();
            layoutParams.bottomMargin = this.cFe;
            this.cZb.setLayoutParams(layoutParams);
        }
        this.cZb.onChangeSkinType();
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, Context context) {
        com.baidu.tbadk.core.data.t tVar;
        if (z || dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bhr()) || this.fZO == null) {
            if (this.fZP != null) {
                this.fZP.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fZP == null) {
            this.fZP = (LinearLayout) this.fZO.inflate();
            this.fZQ = (TextView) this.fZP.findViewById(e.g.tip_source);
            this.fZR = (TextView) this.fZP.findViewById(e.g.view_forum1);
            this.fZS = (TextView) this.fZP.findViewById(e.g.view_forum2);
            this.fZT = (TextView) this.fZP.findViewById(e.g.view_forum3);
            this.fZU = this.fZP.findViewById(e.g.line_divide1);
            this.fZV = this.fZP.findViewById(e.g.line_divide2);
            this.fZW = (TextView) this.fZP.findViewById(e.g.pb_first_floor_multi_forum_del_txt);
        }
        this.fZP.setVisibility(0);
        List<ay> bhr = dVar.bhr();
        StringBuilder sb = new StringBuilder();
        for (ay ayVar : bhr) {
            if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.ata) != null && tVar.isDeleted && ((tVar.ara && (tVar.type == 1 || tVar.type == 2)) || (dVar.bgV() != null && dVar.bgV().zG() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.bgV().zG().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(context.getString(e.j.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.fZW.setVisibility(0);
            this.fZW.setText(String.format(context.getString(e.j.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.fZW.setVisibility(8);
        }
        int H = com.baidu.tbadk.core.util.v.H(dVar.bhr());
        if (H > 3) {
            H = 3;
        }
        int i = this.fZH / H;
        switch (H) {
            case 1:
                this.fZR.setMaxWidth(i);
                this.fZR.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 0)).getForumName()));
                this.fZR.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 0)).getForumName());
                this.fZR.setVisibility(0);
                this.fZS.setVisibility(0);
                this.fZT.setVisibility(0);
                this.fZU.setVisibility(8);
                this.fZV.setVisibility(8);
                break;
            case 2:
                this.fZR.setMaxWidth(i);
                this.fZR.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 0)).getForumName()));
                this.fZR.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 0)).getForumName());
                this.fZR.setVisibility(0);
                this.fZS.setMaxWidth(i);
                this.fZS.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 1)).getForumName()));
                this.fZS.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 1)).getForumName());
                this.fZS.setVisibility(0);
                this.fZT.setVisibility(8);
                this.fZU.setVisibility(0);
                this.fZV.setVisibility(8);
                break;
            case 3:
                this.fZR.setMaxWidth(i);
                this.fZR.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 0)).getForumName()));
                this.fZR.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 0)).getForumName());
                this.fZR.setVisibility(0);
                this.fZS.setMaxWidth(i);
                this.fZS.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 1)).getForumName()));
                this.fZS.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 1)).getForumName());
                this.fZS.setVisibility(0);
                this.fZT.setMaxWidth(i);
                this.fZT.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 2)).getForumName()));
                this.fZT.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bhr(), 2)).getForumName());
                this.fZT.setVisibility(0);
                this.fZU.setVisibility(0);
                this.fZV.setVisibility(0);
                break;
        }
        this.fZR.setOnClickListener(this.fZX);
        this.fZS.setOnClickListener(this.fZX);
        this.fZT.setOnClickListener(this.fZX);
        bjB();
    }

    private void bjB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fZP != null && this.fZY != skinType) {
            com.baidu.tbadk.core.util.al.c(this.fZQ, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fZR, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fZS, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fZT, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.j(this.fZU, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.j(this.fZV, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.c(this.fZW, e.d.cp_cont_d, 1);
            this.fZY = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl())) {
            if ((this.gac == null || !this.gac.getIsLoaded()) && adVar.yC() == com.baidu.tbadk.core.data.ad.arO && this.fZZ != null) {
                if (adVar.yD()) {
                    if (this.gaa != null) {
                        this.gaa.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.gaa == null) {
                    this.gaa = (LinearLayout) this.fZZ.inflate();
                    this.gab = this.gaa.findViewById(e.g.link_thread_divider);
                    this.gac = (BaseWebView) this.gaa.findViewById(e.g.link_thread_webview);
                }
                this.gab.setVisibility(0);
                com.baidu.tbadk.core.util.al.j(this.gab, e.d.cp_bg_line_c);
                this.gac.setVisibility(0);
                this.gac.setFocusable(false);
                this.gac.setBackgroundColor(0);
                this.gac.getSettings().setCacheMode(-1);
                this.gac.setVerticalScrollBarEnabled(false);
                this.gac.setHorizontalScrollBarEnabled(false);
                this.gac.getSettings().setAllowFileAccess(true);
                this.gac.getSettings().setAppCacheEnabled(true);
                this.gac.getSettings().setDomStorageEnabled(true);
                this.gac.getSettings().setDatabaseEnabled(true);
                this.gac.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.gac.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.gac.loadUrl(adVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.gac != null) {
            this.gac.removeAllViews();
            this.gac.getSettings().setBuiltInZoomControls(true);
            this.gac.setVisibility(8);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.gac != null) {
                            q.this.gac.destroy();
                            q.this.gac = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.gac != null) {
            try {
                this.gac.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.gac != null) {
            try {
                this.gac.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
