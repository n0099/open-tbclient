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
    protected g lPd;
    public View.OnClickListener lPe = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.lPd != null) {
                if (a.this.lPd.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.dIF.getPageActivity(), a.this.lPd.getBgColor());
                }
                a.this.lPd.vn(true);
            }
        }
    };
    protected View mRootView = bXU();

    public abstract View bXU();

    public a(TbPageContext tbPageContext, g gVar) {
        this.dIF = tbPageContext;
        this.lPd = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dme() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        public View lPH;
        public LinearLayout lPI;
        public ImageView lPJ;
        public TextView lPK;
        public LinearLayout lPL;
        public ImageView lPM;
        public TextView lPN;
        public LinearLayout lPO;
        public ImageView lPP;
        public TextView lPQ;
        public LinearLayout lPR;
        public ImageView lPS;
        public TextView lPT;
        public OvalActionButton lPU;
        public GridLayout lPV;
        public View lPy;
        public TBLottieAnimationView lPz;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.lPL = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.lPM = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.lPN = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.lPI = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.lPJ = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.lPK = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.lPO = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.lPP = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.lPQ = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.lPR = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.lPS = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.lPT = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.lPU = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.lPd != null && "frs".equals(this.lPd.getFrom())) {
                    this.lPU.setIsCircle(true);
                }
                this.lPH = this.mRootView.findViewById(R.id.view_background_white);
                this.lPy = this.mRootView.findViewById(R.id.view_background_translate);
                this.lPV = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.lPV.setMeasureAllChild(true);
                this.lPV.setVerNum(1);
                this.lPz = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.lPz.setSpeed(1.2f);
                dme();
                this.lPy.setOnClickListener(this.lPe);
                this.lPy.setClickable(true);
                this.lPM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.lPd != null) {
                            c.this.lPd.Oi(c.this.lPd.cbD());
                        }
                    }
                });
                this.lPJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.lPd != null) {
                            c.this.lPd.dmt();
                        }
                    }
                });
                this.lPP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.lPd != null) {
                            c.this.lPd.dms();
                        }
                    }
                });
                this.lPS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.lPd != null) {
                            c.this.lPd.dmr();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View bXU() {
            return LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.lPU.onChangeSkinType(i);
            am.a(this.lPz, (int) R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.lPH, R.drawable.write_tab_background);
            this.lPJ.setImageDrawable(SvgManager.aUV().i(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.lPM.setImageDrawable(SvgManager.aUV().i(R.drawable.icon_post_text_n_svg, 1, true));
            this.lPP.setImageDrawable(SvgManager.aUV().i(R.drawable.icon_post_image_n_svg, 1, true));
            this.lPS.setImageDrawable(SvgManager.aUV().i(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.lPK, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lPN, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lPQ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lPT, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dme() {
            int equipmentWidth = l.getEquipmentWidth(this.dIF.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            b(this.lPM, i);
            b(this.lPJ, i);
            b(this.lPP, i);
            b(this.lPS, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.lPV.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.lPV.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.lPH.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.lPH.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.lPz.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.lPz.setLayoutParams(layoutParams3);
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
        public RelativeLayout lPA;
        public View lPB;
        public View lPC;
        public View lPD;
        public View lPE;
        public View lPF;
        public View lPy;
        public TBLottieAnimationView lPz;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.lPy = this.mRootView.findViewById(R.id.transparent_back_view);
            this.deP = this.mRootView.findViewById(R.id.view_background);
            this.lPz = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.lPA = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dyr = this.mRootView.findViewById(R.id.closeView);
            this.lPB = this.mRootView.findViewById(R.id.publish_text_view);
            this.lPC = this.mRootView.findViewById(R.id.publish_image_view);
            this.lPD = this.mRootView.findViewById(R.id.publish_video_view);
            this.lPE = this.mRootView.findViewById(R.id.publish_ala_view);
            this.lPF = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.deP.setOnClickListener(this.lPe);
            this.lPA.setOnClickListener(this.lPe);
            this.dyr.setOnClickListener(this.lPe);
            this.lPB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.lPd != null) {
                        b.this.lPd.Oi(b.this.lPd.cbD());
                    }
                }
            });
            this.lPC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.lPd != null) {
                        b.this.lPd.dms();
                    }
                }
            });
            this.lPD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.lPd != null) {
                        b.this.lPd.dmt();
                    }
                }
            });
            this.lPE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.lPd != null) {
                        b.this.lPd.dmr();
                    }
                }
            });
            vj(false);
            this.lPz.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bXU() {
            return LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            am.a(this.lPz, (int) R.raw.lottie_use_publish_n);
            am.setBackgroundResource(this.deP, R.color.cp_mask_d);
            am.setBackgroundResource(this.lPF, R.drawable.home_publish_ala_red_tip);
        }

        public void vj(boolean z) {
            this.deP.setClickable(z);
            this.lPA.setClickable(z);
            this.dyr.setClickable(z);
            this.lPB.setClickable(z);
            this.lPC.setClickable(z);
            this.lPD.setClickable(z);
            this.lPE.setClickable(z);
        }

        public void vk(boolean z) {
            if (this.lPF != null) {
                if (z) {
                    this.lPF.setVisibility(0);
                } else {
                    this.lPF.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0746a extends a {
        public View deP;
        private LinearLayout lPg;
        private LinearLayout lPh;
        private LinearLayout lPi;
        private LinearLayout lPj;
        private LinearLayout lPk;
        private ImageView lPl;
        private ImageView lPm;
        private ImageView lPn;
        private ImageView lPo;
        private TextView lPp;
        private TextView lPq;
        private TextView lPr;
        private TextView lPs;
        private View lPt;
        private View lPu;
        private View lPv;
        private int lPw;

        public C0746a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.deP = this.mRootView.findViewById(R.id.view_background);
            this.lPg = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.lPh = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.lPl = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.lPp = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.lPi = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.lPm = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.lPq = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.lPj = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.lPn = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.lPr = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.lPk = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.lPo = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.lPs = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.lPt = this.mRootView.findViewById(R.id.line_1);
            this.lPu = this.mRootView.findViewById(R.id.line_2);
            this.lPv = this.mRootView.findViewById(R.id.line_3);
            this.lPp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_title));
            this.lPq.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.lPr.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.lPs.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.deP.setOnClickListener(this.lPe);
            this.lPh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0746a.this.lPd != null) {
                        C0746a.this.lPd.Oi(C0746a.this.lPd.cbD());
                    }
                }
            });
            this.lPi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0746a.this.lPd != null) {
                        C0746a.this.lPd.dms();
                    }
                }
            });
            this.lPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0746a.this.lPd != null) {
                        C0746a.this.lPd.dmt();
                    }
                }
            });
            this.lPk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0746a.this.lPd != null) {
                        C0746a.this.lPd.dmr();
                    }
                }
            });
            this.lPw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View bXU() {
            return LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            am.setBackgroundColor(this.deP, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.aVv().ln(0).lu(1).O(this.lPw).lo(R.color.cp_bg_line_i).aR(this.lPg);
            SvgManager.aUV().a(this.lPl, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUV().a(this.lPm, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUV().a(this.lPn, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUV().a(this.lPo, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.lPp, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lPq, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lPr, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lPs, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aVv().ln(0).lu(1).lq(R.color.cp_bg_line_c).lo(R.color.cp_bg_line_i).Q(this.lPw).P(this.lPw).aR(this.lPh);
            com.baidu.tbadk.core.util.e.a.aVv().ln(0).lu(1).lq(R.color.cp_bg_line_c).lo(R.color.cp_bg_line_i).aR(this.lPi);
            com.baidu.tbadk.core.util.e.a.aVv().ln(0).lu(1).lq(R.color.cp_bg_line_c).lo(R.color.cp_bg_line_i).aR(this.lPj);
            com.baidu.tbadk.core.util.e.a.aVv().ln(0).lu(1).lq(R.color.cp_bg_line_c).lo(R.color.cp_bg_line_i).S(this.lPw).R(this.lPw).aR(this.lPk);
            am.setBackgroundColor(this.lPt, R.color.cp_bg_line_b);
            am.setBackgroundColor(this.lPu, R.color.cp_bg_line_b);
            am.setBackgroundColor(this.lPv, R.color.cp_bg_line_b);
        }
    }
}
