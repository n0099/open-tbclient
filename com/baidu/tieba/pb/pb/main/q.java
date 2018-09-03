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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.view.PbGiftListView;
import java.util.List;
/* loaded from: classes2.dex */
public class q {
    private OriginalThreadCardView cAm;
    private View fzA;
    private TextView fzB;
    private View.OnClickListener fzC;
    private ViewStub fzE;
    private LinearLayout fzF;
    public View fzG;
    public BaseWebView fzH;
    private int fzm;
    private View fzn;
    private ViewStub fzp;
    private PbGiftListView fzq;
    private ViewStub fzr;
    private OriginalThreadCardView.a fzs;
    private ViewStub fzt;
    private LinearLayout fzu;
    private TextView fzv;
    private TextView fzw;
    private TextView fzx;
    private TextView fzy;
    private View fzz;
    private final int fzl = 3;
    private int ckI = 0;
    private int fzo = 0;
    private int fzD = 3;

    public q(View view) {
        this.fzm = 0;
        Context context = view.getContext();
        this.fzm = com.baidu.adp.lib.util.l.ah(context) - com.baidu.adp.lib.util.l.f(context, f.e.ds130);
        this.fzn = view;
        this.fzp = (ViewStub) view.findViewById(f.g.gift_list_viewStub);
        this.fzr = (ViewStub) view.findViewById(f.g.original_thread_info_viewStub);
        this.fzt = (ViewStub) view.findViewById(f.g.multi_forum_viewStub);
        this.fzE = (ViewStub) view.findViewById(f.g.link_thread_viewStub);
    }

    public void qC(int i) {
        this.fzo = i;
    }

    public void a(OriginalThreadCardView.a aVar) {
        this.fzs = aVar;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fzC = onClickListener;
    }

    public void a(com.baidu.tbadk.core.data.am amVar, String str, String str2, long j, long j2, long j3) {
        if (amVar == null || com.baidu.tbadk.core.util.w.z(amVar.uu()) || this.fzp == null) {
            if (this.fzq != null) {
                this.fzq.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fzq == null) {
            this.fzq = (PbGiftListView) this.fzp.inflate();
        }
        this.fzq.setVisibility(0);
        this.fzq.a(amVar, str, str2, j, j2, j3);
        this.fzq.onChangeSkinType();
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (this.fzr == null || originalThreadInfo == null) {
            if (this.cAm != null) {
                this.cAm.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cAm == null) {
            this.cAm = (OriginalThreadCardView) this.fzr.inflate();
        }
        this.cAm.setSubClickListener(this.fzs);
        this.cAm.setVisibility(0);
        this.cAm.cAZ = this.fzo;
        this.cAm.b(originalThreadInfo);
        if (this.cAm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            this.ckI = this.ckI > 0 ? this.ckI : com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds34);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAm.getLayoutParams();
            layoutParams.bottomMargin = this.ckI;
            this.cAm.setLayoutParams(layoutParams);
        }
        this.cAm.onChangeSkinType();
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, Context context) {
        com.baidu.tbadk.core.data.t tVar;
        if (z || dVar == null || com.baidu.tbadk.core.util.w.z(dVar.aZE()) || this.fzt == null) {
            if (this.fzu != null) {
                this.fzu.setVisibility(8);
                return;
            }
            return;
        }
        if (this.fzu == null) {
            this.fzu = (LinearLayout) this.fzt.inflate();
            this.fzv = (TextView) this.fzu.findViewById(f.g.tip_source);
            this.fzw = (TextView) this.fzu.findViewById(f.g.view_forum1);
            this.fzx = (TextView) this.fzu.findViewById(f.g.view_forum2);
            this.fzy = (TextView) this.fzu.findViewById(f.g.view_forum3);
            this.fzz = this.fzu.findViewById(f.g.line_divide1);
            this.fzA = this.fzu.findViewById(f.g.line_divide2);
            this.fzB = (TextView) this.fzu.findViewById(f.g.pb_first_floor_multi_forum_del_txt);
        }
        this.fzu.setVisibility(0);
        List<com.baidu.tbadk.core.data.ay> aZE = dVar.aZE();
        StringBuilder sb = new StringBuilder();
        for (com.baidu.tbadk.core.data.ay ayVar : aZE) {
            if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.ahr) != null && tVar.isDeleted && ((tVar.afp && (tVar.type == 1 || tVar.type == 2)) || (dVar.aZi() != null && dVar.aZi().vj() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dVar.aZi().vj().getUserId())))) {
                sb.append(com.baidu.adp.lib.util.k.j(ayVar.getForumName(), 12)).append(context.getString(f.j.forum)).append("、");
            }
        }
        String sb2 = sb.toString();
        if (!StringUtils.isNull(sb2)) {
            this.fzB.setVisibility(0);
            this.fzB.setText(String.format(context.getString(f.j.first_floor_del_multi_forum_default_txt), sb2.substring(0, sb.length() - 1)));
        } else {
            this.fzB.setVisibility(8);
        }
        int y = com.baidu.tbadk.core.util.w.y(dVar.aZE());
        if (y > 3) {
            y = 3;
        }
        int i = this.fzm / y;
        switch (y) {
            case 1:
                this.fzw.setMaxWidth(i);
                this.fzw.setText(context.getString(f.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 0)).getForumName()));
                this.fzw.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 0)).getForumName());
                this.fzw.setVisibility(0);
                this.fzx.setVisibility(0);
                this.fzy.setVisibility(0);
                this.fzz.setVisibility(8);
                this.fzA.setVisibility(8);
                break;
            case 2:
                this.fzw.setMaxWidth(i);
                this.fzw.setText(context.getString(f.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 0)).getForumName()));
                this.fzw.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 0)).getForumName());
                this.fzw.setVisibility(0);
                this.fzx.setMaxWidth(i);
                this.fzx.setText(context.getString(f.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 1)).getForumName()));
                this.fzx.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 1)).getForumName());
                this.fzx.setVisibility(0);
                this.fzy.setVisibility(8);
                this.fzz.setVisibility(0);
                this.fzA.setVisibility(8);
                break;
            case 3:
                this.fzw.setMaxWidth(i);
                this.fzw.setText(context.getString(f.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 0)).getForumName()));
                this.fzw.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 0)).getForumName());
                this.fzw.setVisibility(0);
                this.fzx.setMaxWidth(i);
                this.fzx.setText(context.getString(f.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 1)).getForumName()));
                this.fzx.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 1)).getForumName());
                this.fzx.setVisibility(0);
                this.fzy.setMaxWidth(i);
                this.fzy.setText(context.getString(f.j.chosen_pb_original_bar, ((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 2)).getForumName()));
                this.fzy.setTag(((com.baidu.tbadk.core.data.ay) com.baidu.tbadk.core.util.w.d(dVar.aZE(), 2)).getForumName());
                this.fzy.setVisibility(0);
                this.fzz.setVisibility(0);
                this.fzA.setVisibility(0);
                break;
        }
        this.fzw.setOnClickListener(this.fzC);
        this.fzx.setOnClickListener(this.fzC);
        this.fzy.setOnClickListener(this.fzC);
        bbO();
    }

    private void bbO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fzu != null && this.fzD != skinType) {
            com.baidu.tbadk.core.util.am.c(this.fzv, f.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.c(this.fzw, f.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.c(this.fzx, f.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.c(this.fzy, f.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.am.j(this.fzz, f.d.cp_cont_e);
            com.baidu.tbadk.core.util.am.j(this.fzA, f.d.cp_cont_e);
            com.baidu.tbadk.core.util.am.c(this.fzB, f.d.cp_cont_d, 1);
            this.fzD = skinType;
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(adVar.getLinkUrl())) {
            if ((this.fzH == null || !this.fzH.getIsLoaded()) && adVar.ue() == com.baidu.tbadk.core.data.ad.agf && this.fzE != null) {
                if (adVar.uf()) {
                    if (this.fzF != null) {
                        this.fzF.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.fzF == null) {
                    this.fzF = (LinearLayout) this.fzE.inflate();
                    this.fzG = this.fzF.findViewById(f.g.link_thread_divider);
                    this.fzH = (BaseWebView) this.fzF.findViewById(f.g.link_thread_webview);
                }
                this.fzG.setVisibility(0);
                com.baidu.tbadk.core.util.am.j(this.fzG, f.d.cp_bg_line_c);
                this.fzH.setVisibility(0);
                this.fzH.setFocusable(false);
                this.fzH.setBackgroundColor(0);
                this.fzH.getSettings().setCacheMode(-1);
                this.fzH.setVerticalScrollBarEnabled(false);
                this.fzH.setHorizontalScrollBarEnabled(false);
                this.fzH.getSettings().setAllowFileAccess(true);
                this.fzH.getSettings().setAppCacheEnabled(true);
                this.fzH.getSettings().setDomStorageEnabled(true);
                this.fzH.getSettings().setDatabaseEnabled(true);
                this.fzH.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.1
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return true;
                    }
                });
                this.fzH.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.2
                    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                    public void onPageFinished(WebView webView, String str) {
                        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                    }
                });
                this.fzH.loadUrl(adVar.getLinkUrl());
            }
        }
    }

    public void destroy() {
        if (this.fzH != null) {
            this.fzH.removeAllViews();
            this.fzH.getSettings().setBuiltInZoomControls(true);
            this.fzH.setVisibility(8);
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.fzH != null) {
                            q.this.fzH.destroy();
                            q.this.fzH = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.fzH != null) {
            try {
                this.fzH.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (this.fzH != null) {
            try {
                this.fzH.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
