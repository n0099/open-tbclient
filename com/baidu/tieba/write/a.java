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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext dVN;
    protected g msy;
    public View.OnClickListener msz = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.msy != null) {
                if (a.this.msy.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.dVN.getPageActivity(), a.this.msy.getBgColor());
                }
                a.this.msy.wl(true);
            }
        }
    };
    protected View mRootView = ceK();

    public abstract View ceK();

    public a(TbPageContext tbPageContext, g gVar) {
        this.dVN = tbPageContext;
        this.msy = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dtX() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView elM;
        public View msT;
        public TBLottieAnimationView msU;
        public View mtc;
        public LinearLayout mtd;
        public ImageView mte;
        public TextView mtf;
        public LinearLayout mtg;
        public ImageView mth;
        public TextView mti;
        public LinearLayout mtj;
        public ImageView mtk;
        public TextView mtl;
        public LinearLayout mtm;
        public ImageView mtn;
        public TextView mto;
        public LinearLayout mtp;
        ImageView mtq;
        public LinearLayout mtr;
        ImageView mts;
        TextView mtt;
        public OvalActionButton mtu;
        public GridLayout mtv;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.mtg = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.mth = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.mti = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mtd = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.mte = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.mtf = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.mtj = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.mtk = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.mtl = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.mtm = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.mtn = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.mto = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.mtp = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.mtq = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.elM = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.mtr = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.mts = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.mtt = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.mtu = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.msy != null && "frs".equals(this.msy.getFrom())) {
                    this.mtu.setIsCircle(true);
                    this.mtu.setHasShadow(false);
                }
                this.mtc = this.mRootView.findViewById(R.id.view_background_white);
                this.msT = this.mRootView.findViewById(R.id.view_background_translate);
                this.mtv = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.mtv.setMeasureAllChild(true);
                this.mtv.setVerNum(2);
                this.msU = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.msU.setSpeed(1.2f);
                dtX();
                this.msT.setOnClickListener(this.msz);
                this.msT.setClickable(true);
                this.mth.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msy != null) {
                            c.this.msy.PC(c.this.msy.ciD());
                        }
                    }
                });
                this.mte.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msy != null) {
                            c.this.msy.dun();
                        }
                    }
                });
                this.mtk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msy != null) {
                            c.this.msy.dum();
                        }
                    }
                });
                this.mtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msy != null) {
                            c.this.msy.dul();
                        }
                    }
                });
                this.mtp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msy != null) {
                            c.this.msy.PB(c.this.msy.ciD());
                        }
                    }
                });
                this.mtr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msy != null) {
                            c.this.msy.duk();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View ceK() {
            return LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void wh(boolean z) {
            this.mtr.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.mtu.onChangeSkinType(i);
            ao.a(this.msU, R.raw.bottom_bar_bg);
            ao.setBackgroundResource(this.mtc, R.drawable.write_tab_background);
            this.mte.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_photograph60_svg, 1, true));
            this.mth.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_text60_svg, 1, true));
            this.mtk.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_image60_svg, 1, true));
            this.mtn.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_live60_svg, 1, true));
            this.mtq.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_vote60_svg, 1, true));
            this.mts.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_evaluation60_svg, 1, true));
            ao.setViewTextColor(this.mtf, R.color.cp_cont_b);
            ao.setViewTextColor(this.mti, R.color.cp_cont_b);
            ao.setViewTextColor(this.mtl, R.color.cp_cont_b);
            ao.setViewTextColor(this.mto, R.color.cp_cont_b);
            ao.setViewTextColor(this.elM, R.color.cp_cont_b);
            ao.setViewTextColor(this.mtt, R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dtX() {
            int equipmentWidth = l.getEquipmentWidth(this.dVN.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.mth, i);
            b(this.mte, i);
            b(this.mtk, i);
            b(this.mtn, i);
            b(this.mtq, i);
            b(this.mts, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.mtv.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds455) * dimens);
                this.mtv.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mtc.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1144) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1144 : dimens2;
                this.mtc.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.msU.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.msU.setLayoutParams(layoutParams3);
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
        public View dJu;
        public View dpw;
        public View msT;
        public TBLottieAnimationView msU;
        public RelativeLayout msV;
        public View msW;
        public View msX;
        public View msY;
        public View msZ;
        public View mta;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.msT = this.mRootView.findViewById(R.id.transparent_back_view);
            this.dpw = this.mRootView.findViewById(R.id.view_background);
            this.msU = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.msV = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dJu = this.mRootView.findViewById(R.id.closeView);
            this.msW = this.mRootView.findViewById(R.id.publish_text_view);
            this.msX = this.mRootView.findViewById(R.id.publish_image_view);
            this.msY = this.mRootView.findViewById(R.id.publish_video_view);
            this.msZ = this.mRootView.findViewById(R.id.publish_ala_view);
            this.mta = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.dpw.setOnClickListener(this.msz);
            this.msV.setOnClickListener(this.msz);
            this.dJu.setOnClickListener(this.msz);
            this.msW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.msy != null) {
                        b.this.msy.PC(b.this.msy.ciD());
                    }
                }
            });
            this.msX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.msy != null) {
                        b.this.msy.dum();
                    }
                }
            });
            this.msY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.msy != null) {
                        b.this.msy.dun();
                    }
                }
            });
            this.msZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.msy != null) {
                        b.this.msy.dul();
                    }
                }
            });
            wf(false);
            this.msU.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View ceK() {
            return LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ao.a(this.msU, R.raw.lottie_use_publish_n);
            ao.setBackgroundResource(this.dpw, R.color.cp_mask_d);
            ao.setBackgroundResource(this.mta, R.drawable.home_publish_ala_red_tip);
        }

        public void wf(boolean z) {
            this.dpw.setClickable(z);
            this.msV.setClickable(z);
            this.dJu.setClickable(z);
            this.msW.setClickable(z);
            this.msX.setClickable(z);
            this.msY.setClickable(z);
            this.msZ.setClickable(z);
        }

        public void wg(boolean z) {
            if (this.mta != null) {
                if (z) {
                    this.mta.setVisibility(0);
                } else {
                    this.mta.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0773a extends a {
        public View dpw;
        private LinearLayout msB;
        private LinearLayout msC;
        private LinearLayout msD;
        private LinearLayout msE;
        private LinearLayout msF;
        private ImageView msG;
        private ImageView msH;
        private ImageView msI;
        private ImageView msJ;
        private TextView msK;
        private TextView msL;
        private TextView msM;
        private TextView msN;
        private View msO;
        private View msP;
        private View msQ;
        private int msR;

        public C0773a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.dpw = this.mRootView.findViewById(R.id.view_background);
            this.msB = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.msC = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.msG = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.msK = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.msD = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.msH = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.msL = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.msE = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.msI = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.msM = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.msF = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.msJ = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.msN = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.msO = this.mRootView.findViewById(R.id.line_1);
            this.msP = this.mRootView.findViewById(R.id.line_2);
            this.msQ = this.mRootView.findViewById(R.id.line_3);
            this.msK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_title));
            this.msL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.msM.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.msN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.dpw.setOnClickListener(this.msz);
            this.msC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0773a.this.msy != null) {
                        C0773a.this.msy.PC(C0773a.this.msy.ciD());
                    }
                }
            });
            this.msD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0773a.this.msy != null) {
                        C0773a.this.msy.dum();
                    }
                }
            });
            this.msE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0773a.this.msy != null) {
                        C0773a.this.msy.dun();
                    }
                }
            });
            this.msF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0773a.this.msy != null) {
                        C0773a.this.msy.dul();
                    }
                }
            });
            this.msR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View ceK() {
            return LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ao.setBackgroundColor(this.dpw, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).Q(this.msR).mb(R.color.cp_bg_line_i).aX(this.msB);
            SvgManager.baR().a(this.msG, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.msH, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.msI, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.msJ, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.msK, R.color.cp_cont_b);
            ao.setViewTextColor(this.msL, R.color.cp_cont_b);
            ao.setViewTextColor(this.msM, R.color.cp_cont_b);
            ao.setViewTextColor(this.msN, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).md(R.color.cp_bg_line_c).mb(R.color.cp_bg_line_i).S(this.msR).R(this.msR).aX(this.msC);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).md(R.color.cp_bg_line_c).mb(R.color.cp_bg_line_i).aX(this.msD);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).md(R.color.cp_bg_line_c).mb(R.color.cp_bg_line_i).aX(this.msE);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).md(R.color.cp_bg_line_c).mb(R.color.cp_bg_line_i).U(this.msR).T(this.msR).aX(this.msF);
            ao.setBackgroundColor(this.msO, R.color.cp_bg_line_b);
            ao.setBackgroundColor(this.msP, R.color.cp_bg_line_b);
            ao.setBackgroundColor(this.msQ, R.color.cp_bg_line_b);
        }
    }
}
