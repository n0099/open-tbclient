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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext dPv;
    protected g mkv;
    public View.OnClickListener mkw = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mkv != null) {
                if (a.this.mkv.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.dPv.getPageActivity(), a.this.mkv.getBgColor());
                }
                a.this.mkv.vH(true);
            }
        }
    };
    protected View mRootView = cbm();

    public abstract View cbm();

    public a(TbPageContext tbPageContext, g gVar) {
        this.dPv = tbPageContext;
        this.mkv = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dqK() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView efC;
        public View mkQ;
        public TBLottieAnimationView mkR;
        public View mkZ;
        public LinearLayout mla;
        public ImageView mlb;
        public TextView mlc;
        public LinearLayout mld;
        public ImageView mle;
        public TextView mlf;
        public LinearLayout mlg;
        public ImageView mlh;
        public TextView mli;
        public LinearLayout mlj;
        public ImageView mlk;
        public TextView mll;
        public LinearLayout mlm;
        ImageView mln;
        public LinearLayout mlo;
        ImageView mlp;
        TextView mlq;
        public OvalActionButton mlr;
        public GridLayout mls;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.mld = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.mle = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.mlf = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mla = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.mlb = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.mlc = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.mlg = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.mlh = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.mli = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.mlj = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.mlk = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.mll = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.mlm = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.mln = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.efC = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.mlo = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.mlp = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.mlq = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.mlr = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.mkv != null && "frs".equals(this.mkv.getFrom())) {
                    this.mlr.setIsCircle(true);
                    this.mlr.setHasShadow(false);
                }
                this.mkZ = this.mRootView.findViewById(R.id.view_background_white);
                this.mkQ = this.mRootView.findViewById(R.id.view_background_translate);
                this.mls = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.mls.setMeasureAllChild(true);
                this.mls.setVerNum(2);
                this.mkR = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.mkR.setSpeed(1.2f);
                dqK();
                this.mkQ.setOnClickListener(this.mkw);
                this.mkQ.setClickable(true);
                this.mle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mkv != null) {
                            c.this.mkv.OR(c.this.mkv.cfe());
                        }
                    }
                });
                this.mlb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mkv != null) {
                            c.this.mkv.dra();
                        }
                    }
                });
                this.mlh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mkv != null) {
                            c.this.mkv.dqZ();
                        }
                    }
                });
                this.mlk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mkv != null) {
                            c.this.mkv.dqY();
                        }
                    }
                });
                this.mlm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mkv != null) {
                            c.this.mkv.OQ(c.this.mkv.cfe());
                        }
                    }
                });
                this.mlo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mkv != null) {
                            c.this.mkv.dqX();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cbm() {
            return LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void vD(boolean z) {
            this.mlo.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.mlr.onChangeSkinType(i);
            an.a(this.mkR, (int) R.raw.bottom_bar_bg);
            an.setBackgroundResource(this.mkZ, R.drawable.write_tab_background);
            this.mlb.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_photograph60_svg, 1, true));
            this.mle.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_text60_svg, 1, true));
            this.mlh.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_image60_svg, 1, true));
            this.mlk.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_live60_svg, 1, true));
            this.mln.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_vote60_svg, 1, true));
            this.mlp.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_evaluation60_svg, 1, true));
            an.setViewTextColor(this.mlc, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mlf, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mli, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mll, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.efC, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mlq, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dqK() {
            int equipmentWidth = l.getEquipmentWidth(this.dPv.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.mle, i);
            b(this.mlb, i);
            b(this.mlh, i);
            b(this.mlk, i);
            b(this.mln, i);
            b(this.mlp, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.mls.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds455) * dimens);
                this.mls.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mkZ.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1144) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1144 : dimens2;
                this.mkZ.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.mkR.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.mkR.setLayoutParams(layoutParams3);
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
        public View dDx;
        public View djB;
        public View mkQ;
        public TBLottieAnimationView mkR;
        public RelativeLayout mkS;
        public View mkT;
        public View mkU;
        public View mkV;
        public View mkW;
        public View mkX;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.mkQ = this.mRootView.findViewById(R.id.transparent_back_view);
            this.djB = this.mRootView.findViewById(R.id.view_background);
            this.mkR = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.mkS = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dDx = this.mRootView.findViewById(R.id.closeView);
            this.mkT = this.mRootView.findViewById(R.id.publish_text_view);
            this.mkU = this.mRootView.findViewById(R.id.publish_image_view);
            this.mkV = this.mRootView.findViewById(R.id.publish_video_view);
            this.mkW = this.mRootView.findViewById(R.id.publish_ala_view);
            this.mkX = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.djB.setOnClickListener(this.mkw);
            this.mkS.setOnClickListener(this.mkw);
            this.dDx.setOnClickListener(this.mkw);
            this.mkT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mkv != null) {
                        b.this.mkv.OR(b.this.mkv.cfe());
                    }
                }
            });
            this.mkU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mkv != null) {
                        b.this.mkv.dqZ();
                    }
                }
            });
            this.mkV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mkv != null) {
                        b.this.mkv.dra();
                    }
                }
            });
            this.mkW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mkv != null) {
                        b.this.mkv.dqY();
                    }
                }
            });
            vB(false);
            this.mkR.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cbm() {
            return LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            an.a(this.mkR, (int) R.raw.lottie_use_publish_n);
            an.setBackgroundResource(this.djB, R.color.cp_mask_d);
            an.setBackgroundResource(this.mkX, R.drawable.home_publish_ala_red_tip);
        }

        public void vB(boolean z) {
            this.djB.setClickable(z);
            this.mkS.setClickable(z);
            this.dDx.setClickable(z);
            this.mkT.setClickable(z);
            this.mkU.setClickable(z);
            this.mkV.setClickable(z);
            this.mkW.setClickable(z);
        }

        public void vC(boolean z) {
            if (this.mkX != null) {
                if (z) {
                    this.mkX.setVisibility(0);
                } else {
                    this.mkX.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0763a extends a {
        public View djB;
        private LinearLayout mkA;
        private LinearLayout mkB;
        private LinearLayout mkC;
        private ImageView mkD;
        private ImageView mkE;
        private ImageView mkF;
        private ImageView mkG;
        private TextView mkH;
        private TextView mkI;
        private TextView mkJ;
        private TextView mkK;
        private View mkL;
        private View mkM;
        private View mkN;
        private int mkO;
        private LinearLayout mky;
        private LinearLayout mkz;

        public C0763a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.djB = this.mRootView.findViewById(R.id.view_background);
            this.mky = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.mkz = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.mkD = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.mkH = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.mkA = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.mkE = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.mkI = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.mkB = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.mkF = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.mkJ = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.mkC = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.mkG = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.mkK = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.mkL = this.mRootView.findViewById(R.id.line_1);
            this.mkM = this.mRootView.findViewById(R.id.line_2);
            this.mkN = this.mRootView.findViewById(R.id.line_3);
            this.mkH.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_title));
            this.mkI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.mkJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.mkK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.djB.setOnClickListener(this.mkw);
            this.mkz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0763a.this.mkv != null) {
                        C0763a.this.mkv.OR(C0763a.this.mkv.cfe());
                    }
                }
            });
            this.mkA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0763a.this.mkv != null) {
                        C0763a.this.mkv.dqZ();
                    }
                }
            });
            this.mkB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0763a.this.mkv != null) {
                        C0763a.this.mkv.dra();
                    }
                }
            });
            this.mkC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0763a.this.mkv != null) {
                        C0763a.this.mkv.dqY();
                    }
                }
            });
            this.mkO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cbm() {
            return LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            an.setBackgroundColor(this.djB, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).lN(1).Q(this.mkO).lH(R.color.cp_bg_line_i).aR(this.mky);
            SvgManager.aWQ().a(this.mkD, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.mkE, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.mkF, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.mkG, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            an.setViewTextColor(this.mkH, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mkI, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mkJ, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mkK, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).lN(1).lJ(R.color.cp_bg_line_c).lH(R.color.cp_bg_line_i).S(this.mkO).R(this.mkO).aR(this.mkz);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).lN(1).lJ(R.color.cp_bg_line_c).lH(R.color.cp_bg_line_i).aR(this.mkA);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).lN(1).lJ(R.color.cp_bg_line_c).lH(R.color.cp_bg_line_i).aR(this.mkB);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).lN(1).lJ(R.color.cp_bg_line_c).lH(R.color.cp_bg_line_i).U(this.mkO).T(this.mkO).aR(this.mkC);
            an.setBackgroundColor(this.mkL, R.color.cp_bg_line_b);
            an.setBackgroundColor(this.mkM, R.color.cp_bg_line_b);
            an.setBackgroundColor(this.mkN, R.color.cp_bg_line_b);
        }
    }
}
