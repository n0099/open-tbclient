package com.baidu.tieba.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext eIc;
    public View.OnClickListener jvl = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.nCL != null) {
                if (a.this.nCL.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eIc.getPageActivity(), a.this.nCL.getBgColor());
                }
                a.this.nCL.ys(true);
            }
        }
    };
    protected View mRootView = cBH();
    protected g nCL;

    public abstract View cBH();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eIc = tbPageContext;
        this.nCL = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dSR() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView eYk;
        public ImageView nDA;
        public TextView nDB;
        public LinearLayout nDC;
        public ImageView nDD;
        public TextView nDE;
        public LinearLayout nDF;
        ImageView nDG;
        public LinearLayout nDH;
        ImageView nDI;
        TextView nDJ;
        public LinearLayout nDK;
        ImageView nDL;
        TextView nDM;
        public OvalActionButton nDN;
        public GridLayout nDO;
        public View nDj;
        public TBLottieAnimationView nDk;
        public View nDs;
        public LinearLayout nDt;
        public ImageView nDu;
        public TextView nDv;
        public LinearLayout nDw;
        public ImageView nDx;
        public TextView nDy;
        public LinearLayout nDz;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.nDw = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.nDx = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.nDy = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.nDt = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.nDu = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.nDv = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.nDz = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.nDA = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.nDB = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.nDC = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.nDD = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.nDE = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.nDF = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.nDG = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.eYk = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.nDH = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.nDI = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.nDJ = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.nDK = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.nDL = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.nDM = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.nDN = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.nCL != null && "frs".equals(this.nCL.getFrom())) {
                    this.nDN.setIsCircle(true);
                    this.nDN.setHasShadow(false);
                }
                this.nDs = this.mRootView.findViewById(R.id.view_background_white);
                this.nDj = this.mRootView.findViewById(R.id.view_background_translate);
                this.nDO = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.nDO.setMeasureAllChild(true);
                this.nDO.setVerNum(2);
                this.nDk = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.nDk.setSpeed(1.2f);
                dSR();
                this.nDj.setOnClickListener(this.jvl);
                this.nDj.setClickable(true);
                this.nDx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nCL != null) {
                            c.this.nCL.UE(c.this.nCL.cFE());
                        }
                    }
                });
                this.nDu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nCL != null) {
                            c.this.nCL.dTg();
                        }
                    }
                });
                this.nDA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nCL != null) {
                            c.this.nCL.dTf();
                        }
                    }
                });
                this.nDD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nCL != null) {
                            c.this.nCL.dTe();
                        }
                    }
                });
                this.nDF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nCL != null) {
                            c.this.nCL.UD(c.this.nCL.cFE());
                        }
                    }
                });
                this.nDH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nCL != null) {
                            c.this.nCL.dTc();
                        }
                    }
                });
                this.nDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nCL != null) {
                            c.this.nCL.dTd();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cBH() {
            return LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void yo(boolean z) {
            this.nDH.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.nDN.onChangeSkinType(i);
            ap.a(this.nDk, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.nDs, R.drawable.write_tab_background);
            this.nDu.setImageDrawable(SvgManager.brn().j(R.drawable.ic_icon_post_photograph60_svg, 1, true));
            this.nDx.setImageDrawable(SvgManager.brn().j(R.drawable.ic_icon_post_text60_svg, 1, true));
            this.nDA.setImageDrawable(SvgManager.brn().j(R.drawable.ic_icon_post_image60_svg, 1, true));
            this.nDD.setImageDrawable(SvgManager.brn().j(R.drawable.ic_icon_post_live60_svg, 1, true));
            this.nDG.setImageDrawable(SvgManager.brn().j(R.drawable.ic_icon_post_vote60_svg, 1, true));
            this.nDI.setImageDrawable(SvgManager.brn().j(R.drawable.ic_icon_post_evaluation60_svg, 1, true));
            ap.setImageResource(this.nDL, R.drawable.icon_post_haowu60);
            ap.setViewTextColor(this.nDv, R.color.cp_cont_b);
            ap.setViewTextColor(this.nDy, R.color.cp_cont_b);
            ap.setViewTextColor(this.nDB, R.color.cp_cont_b);
            ap.setViewTextColor(this.nDE, R.color.cp_cont_b);
            ap.setViewTextColor(this.eYk, R.color.cp_cont_b);
            ap.setViewTextColor(this.nDJ, R.color.cp_cont_b);
            ap.setViewTextColor(this.nDM, R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dSR() {
            int equipmentWidth = l.getEquipmentWidth(this.eIc.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.nDx, i);
            b(this.nDu, i);
            b(this.nDA, i);
            b(this.nDD, i);
            b(this.nDG, i);
            b(this.nDI, i);
            b(this.nDL, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.nDO.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds455) * dimens);
                this.nDO.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nDs.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1144) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1144 : dimens2;
                this.nDs.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.nDk.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.nDk.setLayoutParams(layoutParams3);
            }
        }

        private void b(ImageView imageView, int i) {
            if (imageView != null && i > 0) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i;
                imageView.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public View ebT;
        public View evj;
        public View nDj;
        public TBLottieAnimationView nDk;
        public RelativeLayout nDl;
        public View nDm;
        public View nDn;
        public View nDo;
        public View nDp;
        public View nDq;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.nDj = this.mRootView.findViewById(R.id.transparent_back_view);
            this.ebT = this.mRootView.findViewById(R.id.view_background);
            this.nDk = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.nDl = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.evj = this.mRootView.findViewById(R.id.closeView);
            this.nDm = this.mRootView.findViewById(R.id.publish_text_view);
            this.nDn = this.mRootView.findViewById(R.id.publish_image_view);
            this.nDo = this.mRootView.findViewById(R.id.publish_video_view);
            this.nDp = this.mRootView.findViewById(R.id.publish_ala_view);
            this.nDq = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.ebT.setOnClickListener(this.jvl);
            this.nDl.setOnClickListener(this.jvl);
            this.evj.setOnClickListener(this.jvl);
            this.nDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nCL != null) {
                        b.this.nCL.UE(b.this.nCL.cFE());
                    }
                }
            });
            this.nDn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nCL != null) {
                        b.this.nCL.dTf();
                    }
                }
            });
            this.nDo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nCL != null) {
                        b.this.nCL.dTg();
                    }
                }
            });
            this.nDp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nCL != null) {
                        b.this.nCL.dTe();
                    }
                }
            });
            ym(false);
            this.nDk.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cBH() {
            return LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.nDk, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.ebT, R.color.cp_mask_d);
            ap.setBackgroundResource(this.nDq, R.drawable.home_publish_ala_red_tip);
        }

        public void ym(boolean z) {
            this.ebT.setClickable(z);
            this.nDl.setClickable(z);
            this.evj.setClickable(z);
            this.nDm.setClickable(z);
            this.nDn.setClickable(z);
            this.nDo.setClickable(z);
            this.nDp.setClickable(z);
        }

        public void yn(boolean z) {
            if (this.nDq != null) {
                if (z) {
                    this.nDq.setVisibility(0);
                } else {
                    this.nDq.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0871a extends a {
        public View ebT;
        public LinearLayout nCN;
        private LinearLayout nCO;
        private LinearLayout nCP;
        private LinearLayout nCQ;
        private LinearLayout nCR;
        private LinearLayout nCS;
        private ImageView nCT;
        private ImageView nCU;
        private ImageView nCV;
        private ImageView nCW;
        private ImageView nCX;
        private TextView nCY;
        private TextView nCZ;
        private TextView nDa;
        private TextView nDb;
        private TextView nDc;
        private View nDd;
        private View nDe;
        private View nDf;
        private View nDg;
        private int nDh;

        public C0871a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.ebT = this.mRootView.findViewById(R.id.view_background);
            this.nCN = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.nCO = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.nCT = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.nCY = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.nCP = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.nCU = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.nCZ = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.nCQ = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.nCV = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.nDa = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.nCR = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.nCW = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.nDb = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.nCS = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.nCX = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.nDc = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.nDd = this.mRootView.findViewById(R.id.line_1);
            this.nDe = this.mRootView.findViewById(R.id.line_2);
            this.nDf = this.mRootView.findViewById(R.id.line_3);
            this.nDg = this.mRootView.findViewById(R.id.line_4);
            this.nCY.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.nCZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.nDa.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.nDb.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.nDc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.ebT.setOnClickListener(this.jvl);
            this.nCO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0871a.this.nCL != null) {
                        C0871a.this.nCL.UE(C0871a.this.nCL.cFE());
                    }
                }
            });
            this.nCP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0871a.this.nCL != null) {
                        C0871a.this.nCL.dTf();
                    }
                }
            });
            this.nCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0871a.this.nCL != null) {
                        C0871a.this.nCL.dTg();
                    }
                }
            });
            this.nCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0871a.this.nCL != null) {
                        C0871a.this.nCL.dTe();
                    }
                }
            });
            this.nCS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0871a.this.nCL != null) {
                        C0871a.this.nCL.UD(C0871a.this.nCL.cFE());
                    }
                }
            });
            this.nDh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cBH() {
            return LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.ebT, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).pr(1).ab(this.nDh).pk(R.color.cp_bg_line_i).bk(this.nCN);
            SvgManager.brn().a(this.nCT, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.brn().a(this.nCU, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.brn().a(this.nCV, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.brn().a(this.nCW, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            this.nCX.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_toupiao16, WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.nCY, R.color.cp_cont_b);
            ap.setViewTextColor(this.nCZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.nDa, R.color.cp_cont_b);
            ap.setViewTextColor(this.nDb, R.color.cp_cont_b);
            ap.setViewTextColor(this.nDc, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).pr(1).pm(R.color.cp_bg_line_c).pk(R.color.cp_bg_line_i).ad(this.nDh).ac(this.nDh).bk(this.nCO);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).pr(1).pm(R.color.cp_bg_line_c).pk(R.color.cp_bg_line_i).bk(this.nCP);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).pr(1).pm(R.color.cp_bg_line_c).pk(R.color.cp_bg_line_i).bk(this.nCQ);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).pr(1).pm(R.color.cp_bg_line_c).pk(R.color.cp_bg_line_i).bk(this.nCR);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).pr(1).pm(R.color.cp_bg_line_c).pk(R.color.cp_bg_line_i).af(this.nDh).ae(this.nDh).bk(this.nCS);
            ap.setBackgroundColor(this.nDd, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.nDe, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.nDf, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.nDg, R.color.cp_bg_line_b);
        }
    }
}
