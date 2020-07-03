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
    protected g mks;
    public View.OnClickListener mkt = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mks != null) {
                if (a.this.mks.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.dPv.getPageActivity(), a.this.mks.getBgColor());
                }
                a.this.mks.vH(true);
            }
        }
    };
    protected View mRootView = cbl();

    public abstract View cbl();

    public a(TbPageContext tbPageContext, g gVar) {
        this.dPv = tbPageContext;
        this.mks = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dqG() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView efC;
        public View mkN;
        public TBLottieAnimationView mkO;
        public View mkW;
        public LinearLayout mkX;
        public ImageView mkY;
        public TextView mkZ;
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
        ImageView mlk;
        public LinearLayout mll;
        ImageView mlm;
        TextView mln;
        public OvalActionButton mlo;
        public GridLayout mlp;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.mla = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.mlb = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.mlc = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mkX = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.mkY = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.mkZ = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.mld = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.mle = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.mlf = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.mlg = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.mlh = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.mli = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.mlj = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.mlk = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.efC = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.mll = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.mlm = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.mln = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.mlo = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.mks != null && "frs".equals(this.mks.getFrom())) {
                    this.mlo.setIsCircle(true);
                    this.mlo.setHasShadow(false);
                }
                this.mkW = this.mRootView.findViewById(R.id.view_background_white);
                this.mkN = this.mRootView.findViewById(R.id.view_background_translate);
                this.mlp = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.mlp.setMeasureAllChild(true);
                this.mlp.setVerNum(2);
                this.mkO = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.mkO.setSpeed(1.2f);
                dqG();
                this.mkN.setOnClickListener(this.mkt);
                this.mkN.setClickable(true);
                this.mlb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mks != null) {
                            c.this.mks.OQ(c.this.mks.cfd());
                        }
                    }
                });
                this.mkY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mks != null) {
                            c.this.mks.dqW();
                        }
                    }
                });
                this.mle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mks != null) {
                            c.this.mks.dqV();
                        }
                    }
                });
                this.mlh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mks != null) {
                            c.this.mks.dqU();
                        }
                    }
                });
                this.mlj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mks != null) {
                            c.this.mks.OP(c.this.mks.cfd());
                        }
                    }
                });
                this.mll.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mks != null) {
                            c.this.mks.dqT();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cbl() {
            return LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void vD(boolean z) {
            this.mll.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.mlo.onChangeSkinType(i);
            an.a(this.mkO, (int) R.raw.bottom_bar_bg);
            an.setBackgroundResource(this.mkW, R.drawable.write_tab_background);
            this.mkY.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_photograph60_svg, 1, true));
            this.mlb.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_text60_svg, 1, true));
            this.mle.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_image60_svg, 1, true));
            this.mlh.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_live60_svg, 1, true));
            this.mlk.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_vote60_svg, 1, true));
            this.mlm.setImageDrawable(SvgManager.aWQ().i(R.drawable.ic_icon_post_evaluation60_svg, 1, true));
            an.setViewTextColor(this.mkZ, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mlc, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mlf, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mli, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.efC, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mln, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dqG() {
            int equipmentWidth = l.getEquipmentWidth(this.dPv.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.mlb, i);
            b(this.mkY, i);
            b(this.mle, i);
            b(this.mlh, i);
            b(this.mlk, i);
            b(this.mlm, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.mlp.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds455) * dimens);
                this.mlp.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mkW.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1144) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1144 : dimens2;
                this.mkW.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.mkO.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.mkO.setLayoutParams(layoutParams3);
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
        public View mkN;
        public TBLottieAnimationView mkO;
        public RelativeLayout mkP;
        public View mkQ;
        public View mkR;
        public View mkS;
        public View mkT;
        public View mkU;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.mkN = this.mRootView.findViewById(R.id.transparent_back_view);
            this.djB = this.mRootView.findViewById(R.id.view_background);
            this.mkO = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.mkP = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dDx = this.mRootView.findViewById(R.id.closeView);
            this.mkQ = this.mRootView.findViewById(R.id.publish_text_view);
            this.mkR = this.mRootView.findViewById(R.id.publish_image_view);
            this.mkS = this.mRootView.findViewById(R.id.publish_video_view);
            this.mkT = this.mRootView.findViewById(R.id.publish_ala_view);
            this.mkU = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.djB.setOnClickListener(this.mkt);
            this.mkP.setOnClickListener(this.mkt);
            this.dDx.setOnClickListener(this.mkt);
            this.mkQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mks != null) {
                        b.this.mks.OQ(b.this.mks.cfd());
                    }
                }
            });
            this.mkR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mks != null) {
                        b.this.mks.dqV();
                    }
                }
            });
            this.mkS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mks != null) {
                        b.this.mks.dqW();
                    }
                }
            });
            this.mkT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mks != null) {
                        b.this.mks.dqU();
                    }
                }
            });
            vB(false);
            this.mkO.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cbl() {
            return LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            an.a(this.mkO, (int) R.raw.lottie_use_publish_n);
            an.setBackgroundResource(this.djB, R.color.cp_mask_d);
            an.setBackgroundResource(this.mkU, R.drawable.home_publish_ala_red_tip);
        }

        public void vB(boolean z) {
            this.djB.setClickable(z);
            this.mkP.setClickable(z);
            this.dDx.setClickable(z);
            this.mkQ.setClickable(z);
            this.mkR.setClickable(z);
            this.mkS.setClickable(z);
            this.mkT.setClickable(z);
        }

        public void vC(boolean z) {
            if (this.mkU != null) {
                if (z) {
                    this.mkU.setVisibility(0);
                } else {
                    this.mkU.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0762a extends a {
        public View djB;
        private ImageView mkA;
        private ImageView mkB;
        private ImageView mkC;
        private ImageView mkD;
        private TextView mkE;
        private TextView mkF;
        private TextView mkG;
        private TextView mkH;
        private View mkI;
        private View mkJ;
        private View mkK;
        private int mkL;
        private LinearLayout mkv;
        private LinearLayout mkw;
        private LinearLayout mkx;
        private LinearLayout mky;
        private LinearLayout mkz;

        public C0762a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.djB = this.mRootView.findViewById(R.id.view_background);
            this.mkv = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.mkw = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.mkA = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.mkE = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.mkx = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.mkB = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.mkF = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.mky = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.mkC = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.mkG = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.mkz = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.mkD = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.mkH = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.mkI = this.mRootView.findViewById(R.id.line_1);
            this.mkJ = this.mRootView.findViewById(R.id.line_2);
            this.mkK = this.mRootView.findViewById(R.id.line_3);
            this.mkE.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_title));
            this.mkF.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.mkG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.mkH.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.djB.setOnClickListener(this.mkt);
            this.mkw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0762a.this.mks != null) {
                        C0762a.this.mks.OQ(C0762a.this.mks.cfd());
                    }
                }
            });
            this.mkx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0762a.this.mks != null) {
                        C0762a.this.mks.dqV();
                    }
                }
            });
            this.mky.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0762a.this.mks != null) {
                        C0762a.this.mks.dqW();
                    }
                }
            });
            this.mkz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0762a.this.mks != null) {
                        C0762a.this.mks.dqU();
                    }
                }
            });
            this.mkL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cbl() {
            return LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            an.setBackgroundColor(this.djB, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).lN(1).Q(this.mkL).lH(R.color.cp_bg_line_i).aR(this.mkv);
            SvgManager.aWQ().a(this.mkA, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.mkB, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.mkC, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.mkD, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            an.setViewTextColor(this.mkE, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mkF, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mkG, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.mkH, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).lN(1).lJ(R.color.cp_bg_line_c).lH(R.color.cp_bg_line_i).S(this.mkL).R(this.mkL).aR(this.mkw);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).lN(1).lJ(R.color.cp_bg_line_c).lH(R.color.cp_bg_line_i).aR(this.mkx);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).lN(1).lJ(R.color.cp_bg_line_c).lH(R.color.cp_bg_line_i).aR(this.mky);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).lN(1).lJ(R.color.cp_bg_line_c).lH(R.color.cp_bg_line_i).U(this.mkL).T(this.mkL).aR(this.mkz);
            an.setBackgroundColor(this.mkI, R.color.cp_bg_line_b);
            an.setBackgroundColor(this.mkJ, R.color.cp_bg_line_b);
            an.setBackgroundColor(this.mkK, R.color.cp_bg_line_b);
        }
    }
}
