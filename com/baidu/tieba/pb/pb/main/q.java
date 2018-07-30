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
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.PbGiftListView;
import java.util.List;
/* loaded from: classes2.dex */
public class q {
    private OriginalThreadCardView cAp;
    private ViewStub fzA;
    private LinearLayout fzB;
    private TextView fzC;
    private TextView fzD;
    private TextView fzE;
    private TextView fzF;
    private View fzG;
    private View fzH;
    private TextView fzI;
    private View.OnClickListener fzJ;
    private ViewStub fzL;
    private LinearLayout fzM;
    public View fzN;
    public BaseWebView fzO;
    private int fzt;
    private View fzu;
    private ViewStub fzw;
    private PbGiftListView fzx;
    private ViewStub fzy;
    private OriginalThreadCardView.a fzz;
    private final int fzs = 3;
    private int ckL = 0;
    private int fzv = 0;
    private int fzK = 3;

    public q(View view) {
        this.fzt = 0;
        Context context = view.getContext();
        this.fzt = com.baidu.adp.lib.util.l.ah(context) - com.baidu.adp.lib.util.l.f(context, d.e.ds130);
        this.fzu = view;
        this.fzw = (ViewStub) view.findViewById(d.g.gift_list_viewStub);
        this.fzy = (ViewStub) view.findViewById(d.g.original_thread_info_viewStub);
        this.fzA = (ViewStub) view.findViewById(d.g.multi_forum_viewStub);
        this.fzL = (ViewStub) view.findViewById(d.g.link_thread_viewStub);
    }

    public void qC(int i) {
        this.fzv = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.fzz = aVar;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fzJ = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.am amVar, String str, String str2, long j, long j2, long j3) {
        if (amVar == null || com.baidu.tbadk.core.util.w.z(amVar.uv()) || this.fzw == null) {
            if (this.fzx != null) {
                this.fzx.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fzx == null) {
            this.fzx = (PbGiftListView) this.fzw.inflate();
        }
        this.fzx.setVisibility(0);
        this.fzx.a(amVar, str, str2, j, j2, j3);
        this.fzx.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.fzy == null || originalThreadInfo == null) {
            if (this.cAp != null) {
                this.cAp.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cAp == null) {
            this.cAp = (OriginalThreadCardView) this.fzy.inflate();
        }
        this.cAp.setSubClickListener(this.fzz);
        this.cAp.setVisibility(0);
        this.cAp.cBc = this.fzv;
        this.cAp.b(originalThreadInfo);
        if (this.cAp.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.ckL = this.ckL > 0 ? this.ckL : com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAp.getLayoutParams();
            layoutParams.bottomMargin = this.ckL;
            this.cAp.setLayoutParams(layoutParams);
        }
        this.cAp.onChangeSkinType();
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, Context context) {
        com.baidu.tbadk.core.data.t tVar;
        if (z || dVar == null || com.baidu.tbadk.core.util.w.z(dVar.aZJ()) || this.fzA == null) {
            if (this.fzB != null) {
                this.fzB.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fzB == null) {
            this.fzB = (LinearLayout) this.fzA.inflate();
            this.fzC = (TextView) this.fzB.findViewById(d.g.tip_source);
            this.fzD = (TextView) this.fzB.findViewById(d.g.view_forum1);
            this.fzE = (TextView) this.fzB.findViewById(d.g.view_forum2);
            this.fzF = (TextView) this.fzB.findViewById(d.g.view_forum3);
            this.fzG = this.fzB.findViewById(d.g.line_divide1);
            this.fzH = this.fzB.findViewById(d.g.line_divide2);
            this.fzI = (TextView) this.fzB.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
        }
        this.fzB.setVisibility(0);
        List<com.baidu.tbadk.core.data.ay> aZJ = dVar.aZJ();
        StringBuilder sb = new StringBuilder();
        for (com.baidu.tbadk.core.data.ay ayVar : aZJ) {
            if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.ahr) != null && tVar.isDeleted && ((tVar.afp && (tVar.type == 1 || tVar.type == 2)) || (dVar.aZn() != null && dVar.aZn().vk() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.aZn().vk().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.j(ayVar.getForumName(), 12)).append(context.getString(d.j.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.fzI.setVisibility(0);
            this.fzI.setText(String.format(context.getString(d.j.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.fzI.setVisibility(8);
        }
        int y = com.baidu.tbadk.core.util.w.y(dVar.aZJ());
        if (y > 3) {
            y = 3;
        }
        int i = this.fzt / y;
        switch (y) {
            case 1:
                this.fzD.setMaxWidth(i);
                this.fzD.setText(context.getString(d.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 0)).getForumName()));
                this.fzD.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 0)).getForumName());
                this.fzD.setVisibility(0);
                this.fzE.setVisibility(0);
                this.fzF.setVisibility(0);
                this.fzG.setVisibility(8);
                this.fzH.setVisibility(8);
                break;
            case 2:
                this.fzD.setMaxWidth(i);
                this.fzD.setText(context.getString(d.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 0)).getForumName()));
                this.fzD.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 0)).getForumName());
                this.fzD.setVisibility(0);
                this.fzE.setMaxWidth(i);
                this.fzE.setText(context.getString(d.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 1)).getForumName()));
                this.fzE.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 1)).getForumName());
                this.fzE.setVisibility(0);
                this.fzF.setVisibility(8);
                this.fzG.setVisibility(0);
                this.fzH.setVisibility(8);
                break;
            case 3:
                this.fzD.setMaxWidth(i);
                this.fzD.setText(context.getString(d.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 0)).getForumName()));
                this.fzD.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 0)).getForumName());
                this.fzD.setVisibility(0);
                this.fzE.setMaxWidth(i);
                this.fzE.setText(context.getString(d.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 1)).getForumName()));
                this.fzE.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 1)).getForumName());
                this.fzE.setVisibility(0);
                this.fzF.setMaxWidth(i);
                this.fzF.setText(context.getString(d.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 2)).getForumName()));
                this.fzF.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZJ(), 2)).getForumName());
                this.fzF.setVisibility(0);
                this.fzG.setVisibility(0);
                this.fzH.setVisibility(0);
                break;
        }
        this.fzD.setOnClickListener(this.fzJ);
        this.fzE.setOnClickListener(this.fzJ);
        this.fzF.setOnClickListener(this.fzJ);
        bbT();
    }

    private void bbT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fzB != null && this.fzK != skinType) {
            com.baidu.tbadk.core.util.am.c(this.fzC, d.C0140d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.c(this.fzD, d.C0140d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.c(this.fzE, d.C0140d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.c(this.fzF, d.C0140d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.j(this.fzG, d.C0140d.cp_cont_e);
            com.baidu.tbadk.core.util.am.j(this.fzH, d.C0140d.cp_cont_e);
            com.baidu.tbadk.core.util.am.c(this.fzI, d.C0140d.cp_cont_d, 1);
            this.fzK = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(adVar.getLinkUrl())) {
            if ((this.fzO == null || !this.fzO.getIsLoaded()) && adVar.uf() == com.baidu.tbadk.core.data.ad.agf && this.fzL != null) {
                if (adVar.ug()) {
                    if (this.fzM != null) {
                        this.fzM.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.fzM == null) {
                    this.fzM = (LinearLayout) this.fzL.inflate();
                    this.fzN = this.fzM.findViewById(d.g.link_thread_divider);
                    this.fzO = (BaseWebView) this.fzM.findViewById(d.g.link_thread_webview);
                }
                this.fzN.setVisibility(0);
                com.baidu.tbadk.core.util.am.j(this.fzN, d.C0140d.cp_bg_line_c);
                this.fzO.setVisibility(0);
                this.fzO.setFocusable(false);
                this.fzO.setBackgroundColor(0);
                this.fzO.getSettings().setCacheMode(-1);
                this.fzO.setVerticalScrollBarEnabled(false);
                this.fzO.setHorizontalScrollBarEnabled(false);
                this.fzO.getSettings().setAllowFileAccess(true);
                this.fzO.getSettings().setAppCacheEnabled(true);
                this.fzO.getSettings().setDomStorageEnabled(true);
                this.fzO.getSettings().setDatabaseEnabled(true);
                this.fzO.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.fzO.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.fzO.loadUrl(adVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.fzO != null) {
            this.fzO.removeAllViews();
            this.fzO.getSettings().setBuiltInZoomControls(true);
            this.fzO.setVisibility(8);
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.fzO != null) {
                            q.this.fzO.destroy();
                            q.this.fzO = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.fzO != null) {
            try {
                this.fzO.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.fzO != null) {
            try {
                this.fzO.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
