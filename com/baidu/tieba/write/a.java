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
    protected TbPageContext ehG;
    public View.OnClickListener iOa = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mUR != null) {
                if (a.this.mUR.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.ehG.getPageActivity(), a.this.mUR.getBgColor());
                }
                a.this.mUR.xl(true);
            }
        }
    };
    protected View mRootView = csC();
    protected g mUR;

    public abstract View csC();

    public a(TbPageContext tbPageContext, g gVar) {
        this.ehG = tbPageContext;
        this.mUR = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dJv() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView exQ;
        public ImageView mVA;
        public TextView mVB;
        public LinearLayout mVC;
        public ImageView mVD;
        public TextView mVE;
        public LinearLayout mVF;
        public ImageView mVG;
        public TextView mVH;
        public LinearLayout mVI;
        public ImageView mVJ;
        public TextView mVK;
        public LinearLayout mVL;
        ImageView mVM;
        public LinearLayout mVN;
        ImageView mVO;
        TextView mVP;
        public LinearLayout mVQ;
        ImageView mVR;
        TextView mVS;
        public OvalActionButton mVT;
        public GridLayout mVU;
        public View mVp;
        public TBLottieAnimationView mVq;
        public View mVy;
        public LinearLayout mVz;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.mVC = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.mVD = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.mVE = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mVz = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.mVA = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.mVB = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.mVF = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.mVG = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.mVH = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.mVI = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.mVJ = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.mVK = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.mVL = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.mVM = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.exQ = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.mVN = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.mVO = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.mVP = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.mVQ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.mVR = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.mVS = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.mVT = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.mUR != null && "frs".equals(this.mUR.getFrom())) {
                    this.mVT.setIsCircle(true);
                    this.mVT.setHasShadow(false);
                }
                this.mVy = this.mRootView.findViewById(R.id.view_background_white);
                this.mVp = this.mRootView.findViewById(R.id.view_background_translate);
                this.mVU = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.mVU.setMeasureAllChild(true);
                this.mVU.setVerNum(2);
                this.mVq = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.mVq.setSpeed(1.2f);
                dJv();
                this.mVp.setOnClickListener(this.iOa);
                this.mVp.setClickable(true);
                this.mVD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mUR != null) {
                            c.this.mUR.Ta(c.this.mUR.cwz());
                        }
                    }
                });
                this.mVA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mUR != null) {
                            c.this.mUR.dJM();
                        }
                    }
                });
                this.mVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mUR != null) {
                            c.this.mUR.dJL();
                        }
                    }
                });
                this.mVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mUR != null) {
                            c.this.mUR.dJK();
                        }
                    }
                });
                this.mVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mUR != null) {
                            c.this.mUR.SZ(c.this.mUR.cwz());
                        }
                    }
                });
                this.mVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mUR != null) {
                            c.this.mUR.dJI();
                        }
                    }
                });
                this.mVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mUR != null) {
                            c.this.mUR.dJJ();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View csC() {
            return LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void xh(boolean z) {
            this.mVN.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.mVT.onChangeSkinType(i);
            ap.a(this.mVq, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.mVy, R.drawable.write_tab_background);
            this.mVA.setImageDrawable(SvgManager.bkl().j(R.drawable.ic_icon_post_photograph60_svg, 1, true));
            this.mVD.setImageDrawable(SvgManager.bkl().j(R.drawable.ic_icon_post_text60_svg, 1, true));
            this.mVG.setImageDrawable(SvgManager.bkl().j(R.drawable.ic_icon_post_image60_svg, 1, true));
            this.mVJ.setImageDrawable(SvgManager.bkl().j(R.drawable.ic_icon_post_live60_svg, 1, true));
            this.mVM.setImageDrawable(SvgManager.bkl().j(R.drawable.ic_icon_post_vote60_svg, 1, true));
            this.mVO.setImageDrawable(SvgManager.bkl().j(R.drawable.ic_icon_post_evaluation60_svg, 1, true));
            ap.setImageResource(this.mVR, R.drawable.icon_post_haowu60);
            ap.setViewTextColor(this.mVB, R.color.cp_cont_b);
            ap.setViewTextColor(this.mVE, R.color.cp_cont_b);
            ap.setViewTextColor(this.mVH, R.color.cp_cont_b);
            ap.setViewTextColor(this.mVK, R.color.cp_cont_b);
            ap.setViewTextColor(this.exQ, R.color.cp_cont_b);
            ap.setViewTextColor(this.mVP, R.color.cp_cont_b);
            ap.setViewTextColor(this.mVS, R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dJv() {
            int equipmentWidth = l.getEquipmentWidth(this.ehG.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.mVD, i);
            b(this.mVA, i);
            b(this.mVG, i);
            b(this.mVJ, i);
            b(this.mVM, i);
            b(this.mVO, i);
            b(this.mVR, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.mVU.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds455) * dimens);
                this.mVU.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mVy.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1144) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1144 : dimens2;
                this.mVy.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.mVq.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.mVq.setLayoutParams(layoutParams3);
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
        public View dBD;
        public View dUQ;
        public View mVp;
        public TBLottieAnimationView mVq;
        public RelativeLayout mVr;
        public View mVs;
        public View mVt;
        public View mVu;
        public View mVv;
        public View mVw;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.mVp = this.mRootView.findViewById(R.id.transparent_back_view);
            this.dBD = this.mRootView.findViewById(R.id.view_background);
            this.mVq = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.mVr = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dUQ = this.mRootView.findViewById(R.id.closeView);
            this.mVs = this.mRootView.findViewById(R.id.publish_text_view);
            this.mVt = this.mRootView.findViewById(R.id.publish_image_view);
            this.mVu = this.mRootView.findViewById(R.id.publish_video_view);
            this.mVv = this.mRootView.findViewById(R.id.publish_ala_view);
            this.mVw = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.dBD.setOnClickListener(this.iOa);
            this.mVr.setOnClickListener(this.iOa);
            this.dUQ.setOnClickListener(this.iOa);
            this.mVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mUR != null) {
                        b.this.mUR.Ta(b.this.mUR.cwz());
                    }
                }
            });
            this.mVt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mUR != null) {
                        b.this.mUR.dJL();
                    }
                }
            });
            this.mVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mUR != null) {
                        b.this.mUR.dJM();
                    }
                }
            });
            this.mVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mUR != null) {
                        b.this.mUR.dJK();
                    }
                }
            });
            xf(false);
            this.mVq.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View csC() {
            return LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.mVq, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.dBD, R.color.cp_mask_d);
            ap.setBackgroundResource(this.mVw, R.drawable.home_publish_ala_red_tip);
        }

        public void xf(boolean z) {
            this.dBD.setClickable(z);
            this.mVr.setClickable(z);
            this.dUQ.setClickable(z);
            this.mVs.setClickable(z);
            this.mVt.setClickable(z);
            this.mVu.setClickable(z);
            this.mVv.setClickable(z);
        }

        public void xg(boolean z) {
            if (this.mVw != null) {
                if (z) {
                    this.mVw.setVisibility(0);
                } else {
                    this.mVw.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0823a extends a {
        public View dBD;
        public LinearLayout mUT;
        private LinearLayout mUU;
        private LinearLayout mUV;
        private LinearLayout mUW;
        private LinearLayout mUX;
        private LinearLayout mUY;
        private ImageView mUZ;
        private ImageView mVa;
        private ImageView mVb;
        private ImageView mVc;
        private ImageView mVd;
        private TextView mVe;
        private TextView mVf;
        private TextView mVg;
        private TextView mVh;
        private TextView mVi;
        private View mVj;
        private View mVk;
        private View mVl;
        private View mVm;
        private int mVn;

        public C0823a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.dBD = this.mRootView.findViewById(R.id.view_background);
            this.mUT = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.mUU = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.mUZ = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.mVe = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.mUV = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.mVa = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.mVf = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.mUW = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.mVb = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.mVg = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.mUX = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.mVc = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.mVh = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.mUY = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.mVd = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.mVi = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.mVj = this.mRootView.findViewById(R.id.line_1);
            this.mVk = this.mRootView.findViewById(R.id.line_2);
            this.mVl = this.mRootView.findViewById(R.id.line_3);
            this.mVm = this.mRootView.findViewById(R.id.line_4);
            this.mVe.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.mVf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.mVg.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.mVh.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.mVi.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.dBD.setOnClickListener(this.iOa);
            this.mUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0823a.this.mUR != null) {
                        C0823a.this.mUR.Ta(C0823a.this.mUR.cwz());
                    }
                }
            });
            this.mUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0823a.this.mUR != null) {
                        C0823a.this.mUR.dJL();
                    }
                }
            });
            this.mUW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0823a.this.mUR != null) {
                        C0823a.this.mUR.dJM();
                    }
                }
            });
            this.mUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0823a.this.mUR != null) {
                        C0823a.this.mUR.dJK();
                    }
                }
            });
            this.mUY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0823a.this.mUR != null) {
                        C0823a.this.mUR.SZ(C0823a.this.mUR.cwz());
                    }
                }
            });
            this.mVn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View csC() {
            return LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.dBD, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).ox(1).V(this.mVn).or(R.color.cp_bg_line_i).bb(this.mUT);
            SvgManager.bkl().a(this.mUZ, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bkl().a(this.mVa, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bkl().a(this.mVb, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bkl().a(this.mVc, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            this.mVd.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_toupiao16, WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.mVe, R.color.cp_cont_b);
            ap.setViewTextColor(this.mVf, R.color.cp_cont_b);
            ap.setViewTextColor(this.mVg, R.color.cp_cont_b);
            ap.setViewTextColor(this.mVh, R.color.cp_cont_b);
            ap.setViewTextColor(this.mVi, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).ox(1).ot(R.color.cp_bg_line_c).or(R.color.cp_bg_line_i).X(this.mVn).W(this.mVn).bb(this.mUU);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).ox(1).ot(R.color.cp_bg_line_c).or(R.color.cp_bg_line_i).bb(this.mUV);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).ox(1).ot(R.color.cp_bg_line_c).or(R.color.cp_bg_line_i).bb(this.mUW);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).ox(1).ot(R.color.cp_bg_line_c).or(R.color.cp_bg_line_i).bb(this.mUX);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).ox(1).ot(R.color.cp_bg_line_c).or(R.color.cp_bg_line_i).Z(this.mVn).Y(this.mVn).bb(this.mUY);
            ap.setBackgroundColor(this.mVj, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.mVk, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.mVl, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.mVm, R.color.cp_bg_line_b);
        }
    }
}
