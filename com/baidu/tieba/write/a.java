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
    protected g msw;
    public View.OnClickListener msx = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.msw != null) {
                if (a.this.msw.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.dVN.getPageActivity(), a.this.msw.getBgColor());
                }
                a.this.msw.wl(true);
            }
        }
    };
    protected View mRootView = ceK();

    public abstract View ceK();

    public a(TbPageContext tbPageContext, g gVar) {
        this.dVN = tbPageContext;
        this.msw = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dtW() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView elM;
        public View msR;
        public TBLottieAnimationView msS;
        public View mta;
        public LinearLayout mtb;
        public ImageView mtc;
        public TextView mtd;
        public LinearLayout mte;
        public ImageView mtf;
        public TextView mtg;
        public LinearLayout mth;
        public ImageView mti;
        public TextView mtj;
        public LinearLayout mtk;
        public ImageView mtl;
        public TextView mtm;
        public LinearLayout mtn;
        ImageView mto;
        public LinearLayout mtp;
        ImageView mtq;
        TextView mtr;
        public OvalActionButton mts;
        public GridLayout mtt;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.mte = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.mtf = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.mtg = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mtb = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.mtc = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.mtd = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.mth = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.mti = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.mtj = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.mtk = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.mtl = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.mtm = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.mtn = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.mto = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.elM = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.mtp = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.mtq = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.mtr = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.mts = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.msw != null && "frs".equals(this.msw.getFrom())) {
                    this.mts.setIsCircle(true);
                    this.mts.setHasShadow(false);
                }
                this.mta = this.mRootView.findViewById(R.id.view_background_white);
                this.msR = this.mRootView.findViewById(R.id.view_background_translate);
                this.mtt = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.mtt.setMeasureAllChild(true);
                this.mtt.setVerNum(2);
                this.msS = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.msS.setSpeed(1.2f);
                dtW();
                this.msR.setOnClickListener(this.msx);
                this.msR.setClickable(true);
                this.mtf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msw != null) {
                            c.this.msw.PC(c.this.msw.ciD());
                        }
                    }
                });
                this.mtc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msw != null) {
                            c.this.msw.dum();
                        }
                    }
                });
                this.mti.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msw != null) {
                            c.this.msw.dul();
                        }
                    }
                });
                this.mtl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msw != null) {
                            c.this.msw.duk();
                        }
                    }
                });
                this.mtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msw != null) {
                            c.this.msw.PB(c.this.msw.ciD());
                        }
                    }
                });
                this.mtp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.msw != null) {
                            c.this.msw.duj();
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
            this.mtp.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.mts.onChangeSkinType(i);
            ao.a(this.msS, R.raw.bottom_bar_bg);
            ao.setBackgroundResource(this.mta, R.drawable.write_tab_background);
            this.mtc.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_photograph60_svg, 1, true));
            this.mtf.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_text60_svg, 1, true));
            this.mti.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_image60_svg, 1, true));
            this.mtl.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_live60_svg, 1, true));
            this.mto.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_vote60_svg, 1, true));
            this.mtq.setImageDrawable(SvgManager.baR().i(R.drawable.ic_icon_post_evaluation60_svg, 1, true));
            ao.setViewTextColor(this.mtd, R.color.cp_cont_b);
            ao.setViewTextColor(this.mtg, R.color.cp_cont_b);
            ao.setViewTextColor(this.mtj, R.color.cp_cont_b);
            ao.setViewTextColor(this.mtm, R.color.cp_cont_b);
            ao.setViewTextColor(this.elM, R.color.cp_cont_b);
            ao.setViewTextColor(this.mtr, R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dtW() {
            int equipmentWidth = l.getEquipmentWidth(this.dVN.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.mtf, i);
            b(this.mtc, i);
            b(this.mti, i);
            b(this.mtl, i);
            b(this.mto, i);
            b(this.mtq, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.mtt.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds455) * dimens);
                this.mtt.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mta.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1144) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1144 : dimens2;
                this.mta.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.msS.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.msS.setLayoutParams(layoutParams3);
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
        public View msR;
        public TBLottieAnimationView msS;
        public RelativeLayout msT;
        public View msU;
        public View msV;
        public View msW;
        public View msX;
        public View msY;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.msR = this.mRootView.findViewById(R.id.transparent_back_view);
            this.dpw = this.mRootView.findViewById(R.id.view_background);
            this.msS = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.msT = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dJu = this.mRootView.findViewById(R.id.closeView);
            this.msU = this.mRootView.findViewById(R.id.publish_text_view);
            this.msV = this.mRootView.findViewById(R.id.publish_image_view);
            this.msW = this.mRootView.findViewById(R.id.publish_video_view);
            this.msX = this.mRootView.findViewById(R.id.publish_ala_view);
            this.msY = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.dpw.setOnClickListener(this.msx);
            this.msT.setOnClickListener(this.msx);
            this.dJu.setOnClickListener(this.msx);
            this.msU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.msw != null) {
                        b.this.msw.PC(b.this.msw.ciD());
                    }
                }
            });
            this.msV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.msw != null) {
                        b.this.msw.dul();
                    }
                }
            });
            this.msW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.msw != null) {
                        b.this.msw.dum();
                    }
                }
            });
            this.msX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.msw != null) {
                        b.this.msw.duk();
                    }
                }
            });
            wf(false);
            this.msS.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View ceK() {
            return LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ao.a(this.msS, R.raw.lottie_use_publish_n);
            ao.setBackgroundResource(this.dpw, R.color.cp_mask_d);
            ao.setBackgroundResource(this.msY, R.drawable.home_publish_ala_red_tip);
        }

        public void wf(boolean z) {
            this.dpw.setClickable(z);
            this.msT.setClickable(z);
            this.dJu.setClickable(z);
            this.msU.setClickable(z);
            this.msV.setClickable(z);
            this.msW.setClickable(z);
            this.msX.setClickable(z);
        }

        public void wg(boolean z) {
            if (this.msY != null) {
                if (z) {
                    this.msY.setVisibility(0);
                } else {
                    this.msY.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0773a extends a {
        public View dpw;
        private LinearLayout msA;
        private LinearLayout msB;
        private LinearLayout msC;
        private LinearLayout msD;
        private ImageView msE;
        private ImageView msF;
        private ImageView msG;
        private ImageView msH;
        private TextView msI;
        private TextView msJ;
        private TextView msK;
        private TextView msL;
        private View msM;
        private View msN;
        private View msO;
        private int msP;
        private LinearLayout msz;

        public C0773a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.dpw = this.mRootView.findViewById(R.id.view_background);
            this.msz = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.msA = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.msE = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.msI = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.msB = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.msF = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.msJ = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.msC = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.msG = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.msK = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.msD = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.msH = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.msL = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.msM = this.mRootView.findViewById(R.id.line_1);
            this.msN = this.mRootView.findViewById(R.id.line_2);
            this.msO = this.mRootView.findViewById(R.id.line_3);
            this.msI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_title));
            this.msJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.msK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.msL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.dpw.setOnClickListener(this.msx);
            this.msA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0773a.this.msw != null) {
                        C0773a.this.msw.PC(C0773a.this.msw.ciD());
                    }
                }
            });
            this.msB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0773a.this.msw != null) {
                        C0773a.this.msw.dul();
                    }
                }
            });
            this.msC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0773a.this.msw != null) {
                        C0773a.this.msw.dum();
                    }
                }
            });
            this.msD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0773a.this.msw != null) {
                        C0773a.this.msw.duk();
                    }
                }
            });
            this.msP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
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
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).Q(this.msP).mb(R.color.cp_bg_line_i).aX(this.msz);
            SvgManager.baR().a(this.msE, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.msF, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.msG, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.msH, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.msI, R.color.cp_cont_b);
            ao.setViewTextColor(this.msJ, R.color.cp_cont_b);
            ao.setViewTextColor(this.msK, R.color.cp_cont_b);
            ao.setViewTextColor(this.msL, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).md(R.color.cp_bg_line_c).mb(R.color.cp_bg_line_i).S(this.msP).R(this.msP).aX(this.msA);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).md(R.color.cp_bg_line_c).mb(R.color.cp_bg_line_i).aX(this.msB);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).md(R.color.cp_bg_line_c).mb(R.color.cp_bg_line_i).aX(this.msC);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mh(1).md(R.color.cp_bg_line_c).mb(R.color.cp_bg_line_i).U(this.msP).T(this.msP).aX(this.msD);
            ao.setBackgroundColor(this.msM, R.color.cp_bg_line_b);
            ao.setBackgroundColor(this.msN, R.color.cp_bg_line_b);
            ao.setBackgroundColor(this.msO, R.color.cp_bg_line_b);
        }
    }
}
