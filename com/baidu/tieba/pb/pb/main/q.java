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
    private OriginalThreadCardView cWl;
    private int fWP;
    private View fWQ;
    private ViewStub fWS;
    private PbGiftListView fWT;
    private ViewStub fWU;
    private OriginalThreadCardView.a fWV;
    private ViewStub fWW;
    private LinearLayout fWX;
    private TextView fWY;
    private TextView fWZ;
    private TextView fXa;
    private TextView fXb;
    private View fXc;
    private View fXd;
    private TextView fXe;
    private View.OnClickListener fXf;
    private ViewStub fXh;
    private LinearLayout fXi;
    public View fXj;
    public BaseWebView fXk;
    private final int fWO = 3;
    private int cEe = 0;
    private int fWR = 0;
    private int fXg = 3;

    public q(View view) {
        this.fWP = 0;
        Context context = view.getContext();
        this.fWP = com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0210e.ds130);
        this.fWQ = view;
        this.fWS = (ViewStub) view.findViewById(e.g.gift_list_viewStub);
        this.fWU = (ViewStub) view.findViewById(e.g.original_thread_info_viewStub);
        this.fWW = (ViewStub) view.findViewById(e.g.multi_forum_viewStub);
        this.fXh = (ViewStub) view.findViewById(e.g.link_thread_viewStub);
    }

    public void sm(int i) {
        this.fWR = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.fWV = aVar;
    }

    public void K(View.OnClickListener onClickListener) {
        this.fXf = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.am amVar, String str, String str2, long j, long j2, long j3) {
        if (amVar == null || com.baidu.tbadk.core.util.v.I(amVar.yR()) || this.fWS == null) {
            if (this.fWT != null) {
                this.fWT.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fWT == null) {
            this.fWT = (PbGiftListView) this.fWS.inflate();
        }
        this.fWT.setVisibility(0);
        this.fWT.a(amVar, str, str2, j, j2, j3);
        this.fWT.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.fWU == null || originalThreadInfo == null) {
            if (this.cWl != null) {
                this.cWl.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cWl == null) {
            this.cWl = (OriginalThreadCardView) this.fWU.inflate();
        }
        this.cWl.setSubClickListener(this.fWV);
        this.cWl.setVisibility(0);
        this.cWl.cWY = this.fWR;
        this.cWl.b(originalThreadInfo);
        if (this.cWl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.cEe = this.cEe > 0 ? this.cEe : com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWl.getLayoutParams();
            layoutParams.bottomMargin = this.cEe;
            this.cWl.setLayoutParams(layoutParams);
        }
        this.cWl.onChangeSkinType();
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, Context context) {
        com.baidu.tbadk.core.data.t tVar;
        if (z || dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bgF()) || this.fWW == null) {
            if (this.fWX != null) {
                this.fWX.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fWX == null) {
            this.fWX = (LinearLayout) this.fWW.inflate();
            this.fWY = (TextView) this.fWX.findViewById(e.g.tip_source);
            this.fWZ = (TextView) this.fWX.findViewById(e.g.view_forum1);
            this.fXa = (TextView) this.fWX.findViewById(e.g.view_forum2);
            this.fXb = (TextView) this.fWX.findViewById(e.g.view_forum3);
            this.fXc = this.fWX.findViewById(e.g.line_divide1);
            this.fXd = this.fWX.findViewById(e.g.line_divide2);
            this.fXe = (TextView) this.fWX.findViewById(e.g.pb_first_floor_multi_forum_del_txt);
        }
        this.fWX.setVisibility(0);
        List<ay> bgF = dVar.bgF();
        StringBuilder sb = new StringBuilder();
        for (ay ayVar : bgF) {
            if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.ata) != null && tVar.isDeleted && ((tVar.ara && (tVar.type == 1 || tVar.type == 2)) || (dVar.bgj() != null && dVar.bgj().zG() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.bgj().zG().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(context.getString(e.j.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.fXe.setVisibility(0);
            this.fXe.setText(String.format(context.getString(e.j.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.fXe.setVisibility(8);
        }
        int H = com.baidu.tbadk.core.util.v.H(dVar.bgF());
        if (H > 3) {
            H = 3;
        }
        int i = this.fWP / H;
        switch (H) {
            case 1:
                this.fWZ.setMaxWidth(i);
                this.fWZ.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 0)).getForumName()));
                this.fWZ.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 0)).getForumName());
                this.fWZ.setVisibility(0);
                this.fXa.setVisibility(0);
                this.fXb.setVisibility(0);
                this.fXc.setVisibility(8);
                this.fXd.setVisibility(8);
                break;
            case 2:
                this.fWZ.setMaxWidth(i);
                this.fWZ.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 0)).getForumName()));
                this.fWZ.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 0)).getForumName());
                this.fWZ.setVisibility(0);
                this.fXa.setMaxWidth(i);
                this.fXa.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 1)).getForumName()));
                this.fXa.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 1)).getForumName());
                this.fXa.setVisibility(0);
                this.fXb.setVisibility(8);
                this.fXc.setVisibility(0);
                this.fXd.setVisibility(8);
                break;
            case 3:
                this.fWZ.setMaxWidth(i);
                this.fWZ.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 0)).getForumName()));
                this.fWZ.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 0)).getForumName());
                this.fWZ.setVisibility(0);
                this.fXa.setMaxWidth(i);
                this.fXa.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 1)).getForumName()));
                this.fXa.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 1)).getForumName());
                this.fXa.setVisibility(0);
                this.fXb.setMaxWidth(i);
                this.fXb.setText(context.getString(e.j.chosen_pb_original_bar, ((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 2)).getForumName()));
                this.fXb.setTag(((ay) com.baidu.tbadk.core.util.v.d(dVar.bgF(), 2)).getForumName());
                this.fXb.setVisibility(0);
                this.fXc.setVisibility(0);
                this.fXd.setVisibility(0);
                break;
        }
        this.fWZ.setOnClickListener(this.fXf);
        this.fXa.setOnClickListener(this.fXf);
        this.fXb.setOnClickListener(this.fXf);
        biP();
    }

    private void biP() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fWX != null && this.fXg != skinType) {
            com.baidu.tbadk.core.util.al.c(this.fWY, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fWZ, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fXa, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.c(this.fXb, e.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.al.j(this.fXc, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.j(this.fXd, e.d.cp_cont_e);
            com.baidu.tbadk.core.util.al.c(this.fXe, e.d.cp_cont_d, 1);
            this.fXg = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl())) {
            if ((this.fXk == null || !this.fXk.getIsLoaded()) && adVar.yC() == com.baidu.tbadk.core.data.ad.arO && this.fXh != null) {
                if (adVar.yD()) {
                    if (this.fXi != null) {
                        this.fXi.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.fXi == null) {
                    this.fXi = (LinearLayout) this.fXh.inflate();
                    this.fXj = this.fXi.findViewById(e.g.link_thread_divider);
                    this.fXk = (BaseWebView) this.fXi.findViewById(e.g.link_thread_webview);
                }
                this.fXj.setVisibility(0);
                com.baidu.tbadk.core.util.al.j(this.fXj, e.d.cp_bg_line_c);
                this.fXk.setVisibility(0);
                this.fXk.setFocusable(false);
                this.fXk.setBackgroundColor(0);
                this.fXk.getSettings().setCacheMode(-1);
                this.fXk.setVerticalScrollBarEnabled(false);
                this.fXk.setHorizontalScrollBarEnabled(false);
                this.fXk.getSettings().setAllowFileAccess(true);
                this.fXk.getSettings().setAppCacheEnabled(true);
                this.fXk.getSettings().setDomStorageEnabled(true);
                this.fXk.getSettings().setDatabaseEnabled(true);
                this.fXk.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.fXk.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.fXk.loadUrl(adVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.fXk != null) {
            this.fXk.removeAllViews();
            this.fXk.getSettings().setBuiltInZoomControls(true);
            this.fXk.setVisibility(8);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.fXk != null) {
                            q.this.fXk.destroy();
                            q.this.fXk = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.fXk != null) {
            try {
                this.fXk.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.fXk != null) {
            try {
                this.fXk.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
