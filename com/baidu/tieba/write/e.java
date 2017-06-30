package com.baidu.tieba.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.n.ad;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    private ViewGroup ZO;
    private TbPageContext aat;
    private View gdA;
    private TbImageView gdB;
    private TextView gdC;
    private TbImageView gdD;
    private TextView gdE;
    private TbImageView gdF;
    private TextView gdG;
    private TbImageView gdH;
    private TextView gdI;
    private TbImageView gdJ;
    private GridLayout gdK;
    private a gdL;
    private ForumWriteData gdN;
    private String gdO;
    private PopupWindow gdQ;
    private boolean gdR;
    private boolean gdM = false;
    private boolean gdP = false;
    private View.OnClickListener fQR = new f(this);
    private Runnable fQQ = new g(this);
    private Runnable fQP = new h(this);

    public e(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.aat = tbPageContext;
        this.ZO = viewGroup;
        initView();
    }

    public void a(ForumWriteData forumWriteData) {
        this.gdN = forumWriteData;
    }

    public void sa(String str) {
        this.gdO = str;
    }

    private void initView() {
        if (this.aat != null && this.aat.getPageActivity() != null && this.ZO != null) {
            this.gdA = LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.bottom_write_thread, (ViewGroup) null);
            this.gdB = (TbImageView) this.gdA.findViewById(w.h.home_write_PL_icon);
            this.gdC = (TextView) this.gdA.findViewById(w.h.home_write_PL_title);
            this.gdD = (TbImageView) this.gdA.findViewById(w.h.home_write_video_icon);
            this.gdE = (TextView) this.gdA.findViewById(w.h.home_write_video_title);
            this.gdF = (TbImageView) this.gdA.findViewById(w.h.home_write_live_icon);
            this.gdG = (TextView) this.gdA.findViewById(w.h.home_write_live_title);
            this.gdH = (TbImageView) this.gdA.findViewById(w.h.home_write_url_icon);
            this.gdI = (TextView) this.gdA.findViewById(w.h.home_write_url_title);
            this.gdJ = (TbImageView) this.gdA.findViewById(w.h.write_switch);
            this.gdK = (GridLayout) this.gdA.findViewById(w.h.type_container);
            this.gdK.setMeasureAllChild(true);
            this.gdK.setVerNum(2);
            this.gdR = XiaoyingUtil.showXiaoyingTool();
            a(this.gdK, this.gdR);
            boolean fU = ad.fU();
            b(this.gdK, fU);
            this.gdA.setOnClickListener(new i(this));
            this.gdA.findViewById(w.h.home_write_live).setOnClickListener(new j(this));
            this.gdA.findViewById(w.h.home_write_PL).setOnClickListener(new k(this));
            if (fU) {
                this.gdA.findViewById(w.h.home_write_url).setOnClickListener(new l(this));
            }
            if (this.gdR) {
                this.gdA.findViewById(w.h.home_write_video).setOnClickListener(new m(this));
            }
            onChangeSkinType();
            if (fU) {
                brx();
            }
        }
    }

    public void brx() {
        if (!this.gdP && this.gdA != null) {
            this.gdP = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_write_url_tips", false);
            if (!this.gdP) {
                View inflate = LayoutInflater.from(this.aat.getContext()).inflate(w.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(w.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(w.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                if (this.gdR) {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.aat.getContext(), w.f.ds120);
                } else {
                    layoutParams.gravity = 5;
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.aat.getContext(), w.f.ds140);
                }
                textView.setText(w.l.write_url_tips);
                textView.setOnClickListener(this.fQR);
                this.gdQ = new PopupWindow(inflate, -2, -2);
                this.gdA.removeCallbacks(this.fQP);
                this.gdA.postDelayed(this.fQP, 400L);
            }
        }
    }

    public void bry() {
        if (this.gdA != null) {
            this.gdA.removeCallbacks(this.fQP);
            this.gdA.removeCallbacks(this.fQQ);
        }
        boq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boq() {
        com.baidu.adp.lib.g.j.a(this.gdQ);
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            gridLayout.findViewById(w.h.home_write_video).setVisibility(8);
            gridLayout.setVerNum(1);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds180);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            gridLayout.findViewById(w.h.home_write_url).setVisibility(8);
            gridLayout.setVerNum(1);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds180);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private View mView;

        public a(View view) {
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (e.this.gdA.getParent() == e.this.ZO) {
                e.this.ZO.removeView(e.this.gdA);
            }
            e.this.gdM = false;
        }
    }

    public void ms(boolean z) {
        if (!this.gdM && this.ZO != null) {
            this.gdM = true;
            if (this.gdA.getParent() == null) {
                com.baidu.tbadk.i.d.K(this.ZO).a(this.ZO, this.gdA, z);
            }
            com.baidu.adp.lib.g.h.fR().postDelayed(new n(this), 100L);
            TiebaStatic.log(new au("c12052").Z("obj_locate", "1"));
        }
    }

    public void brz() {
        d(this.gdK, this.gdJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, View view2) {
        bry();
        if (this.gdL != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.gdL);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.home_write_bgout);
        loadAnimation.setFillAfter(true);
        view.startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.home_write_out);
        loadAnimation2.setFillAfter(true);
        view2.startAnimation(loadAnimation2);
        this.gdL = new a(view);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.gdL, 300L);
    }

    public void onChangeSkinType() {
        as.k(this.gdA, w.e.cp_bg_line_d);
        as.c(this.gdB, w.g.icon_posts_photo_n);
        as.c(this.gdD, w.g.icon_posts_video_n);
        as.c(this.gdF, w.g.icon_posts_live_n);
        as.c(this.gdJ, w.g.home_write_s);
        as.c(this.gdH, w.g.icon_posts_url_n);
        as.i(this.gdC, w.e.cp_cont_f);
        as.i(this.gdE, w.e.cp_cont_f);
        as.i(this.gdG, w.e.cp_cont_f);
        as.i(this.gdI, w.e.cp_cont_f);
    }

    public void onDestroy() {
        bry();
        if (this.gdA != null && this.gdA.getParent() == this.ZO) {
            this.ZO.removeView(this.gdA);
        }
        if (this.gdL != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.gdL);
            this.gdL = null;
        }
    }

    public boolean isShowing() {
        return this.gdM;
    }
}
