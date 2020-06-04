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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext dIF;
    protected g lQl;
    public View.OnClickListener lQm = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.lQl != null) {
                if (a.this.lQl.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.dIF.getPageActivity(), a.this.lQl.getBgColor());
                }
                a.this.lQl.vp(true);
            }
        }
    };
    protected View mRootView = bXX();

    public abstract View bXX();

    public a(TbPageContext tbPageContext, g gVar) {
        this.dIF = tbPageContext;
        this.lQl = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dmt() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        public View lQG;
        public TBLottieAnimationView lQH;
        public View lQP;
        public LinearLayout lQQ;
        public ImageView lQR;
        public TextView lQS;
        public LinearLayout lQT;
        public ImageView lQU;
        public TextView lQV;
        public LinearLayout lQW;
        public ImageView lQX;
        public TextView lQY;
        public LinearLayout lQZ;
        public ImageView lRa;
        public TextView lRb;
        public LinearLayout lRc;
        ImageView lRd;
        TextView lRe;
        public OvalActionButton lRf;
        public GridLayout lRg;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.lQT = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.lQU = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.lQV = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.lQQ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.lQR = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.lQS = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.lQW = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.lQX = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.lQY = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.lQZ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.lRa = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.lRb = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.lRc = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.lRd = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.lRe = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.lRf = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.lQl != null && "frs".equals(this.lQl.getFrom())) {
                    this.lRf.setIsCircle(true);
                }
                this.lQP = this.mRootView.findViewById(R.id.view_background_white);
                this.lQG = this.mRootView.findViewById(R.id.view_background_translate);
                this.lRg = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.lRg.setMeasureAllChild(true);
                this.lRg.setVerNum(2);
                this.lQH = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.lQH.setSpeed(1.2f);
                dmt();
                this.lQG.setOnClickListener(this.lQm);
                this.lQG.setClickable(true);
                this.lQU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.lQl != null) {
                            c.this.lQl.Oj(c.this.lQl.cbL());
                        }
                    }
                });
                this.lQR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.lQl != null) {
                            c.this.lQl.dmJ();
                        }
                    }
                });
                this.lQX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.lQl != null) {
                            c.this.lQl.dmI();
                        }
                    }
                });
                this.lRa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.lQl != null) {
                            c.this.lQl.dmH();
                        }
                    }
                });
                this.lRc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.lQl != null) {
                            c.this.lQl.dmG();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View bXX() {
            return LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void vl(boolean z) {
            this.lRc.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.lRf.onChangeSkinType(i);
            am.a(this.lQH, (int) R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.lQP, R.drawable.write_tab_background);
            this.lQR.setImageDrawable(SvgManager.aUW().i(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.lQU.setImageDrawable(SvgManager.aUW().i(R.drawable.icon_post_text_n_svg, 1, true));
            this.lQX.setImageDrawable(SvgManager.aUW().i(R.drawable.icon_post_image_n_svg, 1, true));
            this.lRa.setImageDrawable(SvgManager.aUW().i(R.drawable.icon_post_live_n_svg, 1, true));
            this.lRd.setImageDrawable(SvgManager.aUW().i(R.drawable.ic_icon_post_evaluation_n, 1, true));
            am.setViewTextColor(this.lQS, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lQV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lQY, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lRb, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lRe, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dmt() {
            int dimens;
            int equipmentWidth = l.getEquipmentWidth(this.dIF.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.lQU, i);
            b(this.lQR, i);
            b(this.lQX, i);
            b(this.lRa, i);
            b(this.lRd, i);
            float dimens2 = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.lRg.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                if (this.lRg.getVerNum() > 1) {
                    dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds334);
                } else {
                    dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418);
                }
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (dimens * dimens2);
                this.lRg.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.lQP.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens3 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens2);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens3 <= 0 ? 912 : dimens3;
                this.lQP.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.lQH.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens2 * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens2) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.lQH.setLayoutParams(layoutParams3);
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
        public View deP;
        public View dyr;
        public View lQG;
        public TBLottieAnimationView lQH;
        public RelativeLayout lQI;
        public View lQJ;
        public View lQK;
        public View lQL;
        public View lQM;
        public View lQN;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.lQG = this.mRootView.findViewById(R.id.transparent_back_view);
            this.deP = this.mRootView.findViewById(R.id.view_background);
            this.lQH = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.lQI = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dyr = this.mRootView.findViewById(R.id.closeView);
            this.lQJ = this.mRootView.findViewById(R.id.publish_text_view);
            this.lQK = this.mRootView.findViewById(R.id.publish_image_view);
            this.lQL = this.mRootView.findViewById(R.id.publish_video_view);
            this.lQM = this.mRootView.findViewById(R.id.publish_ala_view);
            this.lQN = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.deP.setOnClickListener(this.lQm);
            this.lQI.setOnClickListener(this.lQm);
            this.dyr.setOnClickListener(this.lQm);
            this.lQJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.lQl != null) {
                        b.this.lQl.Oj(b.this.lQl.cbL());
                    }
                }
            });
            this.lQK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.lQl != null) {
                        b.this.lQl.dmI();
                    }
                }
            });
            this.lQL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.lQl != null) {
                        b.this.lQl.dmJ();
                    }
                }
            });
            this.lQM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.lQl != null) {
                        b.this.lQl.dmH();
                    }
                }
            });
            vj(false);
            this.lQH.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bXX() {
            return LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            am.a(this.lQH, (int) R.raw.lottie_use_publish_n);
            am.setBackgroundResource(this.deP, R.color.cp_mask_d);
            am.setBackgroundResource(this.lQN, R.drawable.home_publish_ala_red_tip);
        }

        public void vj(boolean z) {
            this.deP.setClickable(z);
            this.lQI.setClickable(z);
            this.dyr.setClickable(z);
            this.lQJ.setClickable(z);
            this.lQK.setClickable(z);
            this.lQL.setClickable(z);
            this.lQM.setClickable(z);
        }

        public void vk(boolean z) {
            if (this.lQN != null) {
                if (z) {
                    this.lQN.setVisibility(0);
                } else {
                    this.lQN.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0747a extends a {
        public View deP;
        private TextView lQA;
        private View lQB;
        private View lQC;
        private View lQD;
        private int lQE;
        private LinearLayout lQo;
        private LinearLayout lQp;
        private LinearLayout lQq;
        private LinearLayout lQr;
        private LinearLayout lQs;
        private ImageView lQt;
        private ImageView lQu;
        private ImageView lQv;
        private ImageView lQw;
        private TextView lQx;
        private TextView lQy;
        private TextView lQz;

        public C0747a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.deP = this.mRootView.findViewById(R.id.view_background);
            this.lQo = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.lQp = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.lQt = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.lQx = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.lQq = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.lQu = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.lQy = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.lQr = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.lQv = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.lQz = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.lQs = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.lQw = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.lQA = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.lQB = this.mRootView.findViewById(R.id.line_1);
            this.lQC = this.mRootView.findViewById(R.id.line_2);
            this.lQD = this.mRootView.findViewById(R.id.line_3);
            this.lQx.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_title));
            this.lQy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.lQz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.lQA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.deP.setOnClickListener(this.lQm);
            this.lQp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0747a.this.lQl != null) {
                        C0747a.this.lQl.Oj(C0747a.this.lQl.cbL());
                    }
                }
            });
            this.lQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0747a.this.lQl != null) {
                        C0747a.this.lQl.dmI();
                    }
                }
            });
            this.lQr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0747a.this.lQl != null) {
                        C0747a.this.lQl.dmJ();
                    }
                }
            });
            this.lQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0747a.this.lQl != null) {
                        C0747a.this.lQl.dmH();
                    }
                }
            });
            this.lQE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View bXX() {
            return LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            am.setBackgroundColor(this.deP, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.aVw().lp(0).lw(1).O(this.lQE).lq(R.color.cp_bg_line_i).aR(this.lQo);
            SvgManager.aUW().a(this.lQt, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUW().a(this.lQu, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUW().a(this.lQv, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUW().a(this.lQw, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.lQx, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lQy, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lQz, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lQA, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aVw().lp(0).lw(1).ls(R.color.cp_bg_line_c).lq(R.color.cp_bg_line_i).Q(this.lQE).P(this.lQE).aR(this.lQp);
            com.baidu.tbadk.core.util.e.a.aVw().lp(0).lw(1).ls(R.color.cp_bg_line_c).lq(R.color.cp_bg_line_i).aR(this.lQq);
            com.baidu.tbadk.core.util.e.a.aVw().lp(0).lw(1).ls(R.color.cp_bg_line_c).lq(R.color.cp_bg_line_i).aR(this.lQr);
            com.baidu.tbadk.core.util.e.a.aVw().lp(0).lw(1).ls(R.color.cp_bg_line_c).lq(R.color.cp_bg_line_i).S(this.lQE).R(this.lQE).aR(this.lQs);
            am.setBackgroundColor(this.lQB, R.color.cp_bg_line_b);
            am.setBackgroundColor(this.lQC, R.color.cp_bg_line_b);
            am.setBackgroundColor(this.lQD, R.color.cp_bg_line_b);
        }
    }
}
