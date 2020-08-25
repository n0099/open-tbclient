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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public abstract class a {
    protected TbPageContext efn;
    protected g mKI;
    public View.OnClickListener mKJ = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mKI != null) {
                if (a.this.mKI.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.efn.getPageActivity(), a.this.mKI.getBgColor());
                }
                a.this.mKI.xa(true);
            }
        }
    };
    protected View mRootView = cpo();

    public abstract View cpo();

    public a(TbPageContext tbPageContext, g gVar) {
        this.efn = tbPageContext;
        this.mKI = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dFs() {
    }

    /* loaded from: classes2.dex */
    public static class c extends a {
        TextView evH;
        ImageView mLA;
        public LinearLayout mLB;
        ImageView mLC;
        TextView mLD;
        public LinearLayout mLE;
        ImageView mLF;
        TextView mLG;
        public OvalActionButton mLH;
        public GridLayout mLI;
        public View mLd;
        public TBLottieAnimationView mLe;
        public View mLm;
        public LinearLayout mLn;
        public ImageView mLo;
        public TextView mLp;
        public LinearLayout mLq;
        public ImageView mLr;
        public TextView mLs;
        public LinearLayout mLt;
        public ImageView mLu;
        public TextView mLv;
        public LinearLayout mLw;
        public ImageView mLx;
        public TextView mLy;
        public LinearLayout mLz;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.mLq = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.mLr = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.mLs = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mLn = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.mLo = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.mLp = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.mLt = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.mLu = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.mLv = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.mLw = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.mLx = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.mLy = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.mLz = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.mLA = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.evH = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.mLB = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.mLC = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.mLD = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.mLE = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.mLF = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.mLG = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.mLH = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.mKI != null && "frs".equals(this.mKI.getFrom())) {
                    this.mLH.setIsCircle(true);
                    this.mLH.setHasShadow(false);
                }
                this.mLm = this.mRootView.findViewById(R.id.view_background_white);
                this.mLd = this.mRootView.findViewById(R.id.view_background_translate);
                this.mLI = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.mLI.setMeasureAllChild(true);
                this.mLI.setVerNum(2);
                this.mLe = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.mLe.setSpeed(1.2f);
                dFs();
                this.mLd.setOnClickListener(this.mKJ);
                this.mLd.setClickable(true);
                this.mLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mKI != null) {
                            c.this.mKI.SA(c.this.mKI.cth());
                        }
                    }
                });
                this.mLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mKI != null) {
                            c.this.mKI.dFJ();
                        }
                    }
                });
                this.mLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mKI != null) {
                            c.this.mKI.dFI();
                        }
                    }
                });
                this.mLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mKI != null) {
                            c.this.mKI.dFH();
                        }
                    }
                });
                this.mLz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mKI != null) {
                            c.this.mKI.Sz(c.this.mKI.cth());
                        }
                    }
                });
                this.mLB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mKI != null) {
                            c.this.mKI.dFF();
                        }
                    }
                });
                this.mLE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mKI != null) {
                            c.this.mKI.dFG();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cpo() {
            return LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void wW(boolean z) {
            this.mLB.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.mLH.onChangeSkinType(i);
            ap.a(this.mLe, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.mLm, R.drawable.write_tab_background);
            this.mLo.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_photograph60_svg, 1, true));
            this.mLr.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_text60_svg, 1, true));
            this.mLu.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_image60_svg, 1, true));
            this.mLx.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_live60_svg, 1, true));
            this.mLA.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_vote60_svg, 1, true));
            this.mLC.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_evaluation60_svg, 1, true));
            ap.setImageResource(this.mLF, R.drawable.icon_post_haowu60);
            ap.setViewTextColor(this.mLp, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLs, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLv, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLy, R.color.cp_cont_b);
            ap.setViewTextColor(this.evH, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLD, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLG, R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dFs() {
            int equipmentWidth = l.getEquipmentWidth(this.efn.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.mLr, i);
            b(this.mLo, i);
            b(this.mLu, i);
            b(this.mLx, i);
            b(this.mLA, i);
            b(this.mLC, i);
            b(this.mLF, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.mLI.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds455) * dimens);
                this.mLI.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mLm.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1144) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1144 : dimens2;
                this.mLm.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.mLe.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.mLe.setLayoutParams(layoutParams3);
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

    /* loaded from: classes2.dex */
    public static class b extends a {
        public View dSC;
        public View dzy;
        public View mLd;
        public TBLottieAnimationView mLe;
        public RelativeLayout mLf;
        public View mLg;
        public View mLh;
        public View mLi;
        public View mLj;
        public View mLk;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.mLd = this.mRootView.findViewById(R.id.transparent_back_view);
            this.dzy = this.mRootView.findViewById(R.id.view_background);
            this.mLe = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.mLf = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dSC = this.mRootView.findViewById(R.id.closeView);
            this.mLg = this.mRootView.findViewById(R.id.publish_text_view);
            this.mLh = this.mRootView.findViewById(R.id.publish_image_view);
            this.mLi = this.mRootView.findViewById(R.id.publish_video_view);
            this.mLj = this.mRootView.findViewById(R.id.publish_ala_view);
            this.mLk = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.dzy.setOnClickListener(this.mKJ);
            this.mLf.setOnClickListener(this.mKJ);
            this.dSC.setOnClickListener(this.mKJ);
            this.mLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mKI != null) {
                        b.this.mKI.SA(b.this.mKI.cth());
                    }
                }
            });
            this.mLh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mKI != null) {
                        b.this.mKI.dFI();
                    }
                }
            });
            this.mLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mKI != null) {
                        b.this.mKI.dFJ();
                    }
                }
            });
            this.mLj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mKI != null) {
                        b.this.mKI.dFH();
                    }
                }
            });
            wU(false);
            this.mLe.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cpo() {
            return LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.mLe, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.dzy, R.color.cp_mask_d);
            ap.setBackgroundResource(this.mLk, R.drawable.home_publish_ala_red_tip);
        }

        public void wU(boolean z) {
            this.dzy.setClickable(z);
            this.mLf.setClickable(z);
            this.dSC.setClickable(z);
            this.mLg.setClickable(z);
            this.mLh.setClickable(z);
            this.mLi.setClickable(z);
            this.mLj.setClickable(z);
        }

        public void wV(boolean z) {
            if (this.mLk != null) {
                if (z) {
                    this.mLk.setVisibility(0);
                } else {
                    this.mLk.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0826a extends a {
        public View dzy;
        private LinearLayout mKL;
        private LinearLayout mKM;
        private LinearLayout mKN;
        private LinearLayout mKO;
        private LinearLayout mKP;
        private ImageView mKQ;
        private ImageView mKR;
        private ImageView mKS;
        private ImageView mKT;
        private TextView mKU;
        private TextView mKV;
        private TextView mKW;
        private TextView mKX;
        private View mKY;
        private View mKZ;
        private View mLa;
        private int mLb;

        public C0826a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.dzy = this.mRootView.findViewById(R.id.view_background);
            this.mKL = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.mKM = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.mKQ = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.mKU = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.mKN = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.mKR = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.mKV = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.mKO = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.mKS = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.mKW = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.mKP = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.mKT = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.mKX = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.mKY = this.mRootView.findViewById(R.id.line_1);
            this.mKZ = this.mRootView.findViewById(R.id.line_2);
            this.mLa = this.mRootView.findViewById(R.id.line_3);
            this.mKU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_title));
            this.mKV.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.mKW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.mKX.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.dzy.setOnClickListener(this.mKJ);
            this.mKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0826a.this.mKI != null) {
                        C0826a.this.mKI.SA(C0826a.this.mKI.cth());
                    }
                }
            });
            this.mKN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0826a.this.mKI != null) {
                        C0826a.this.mKI.dFI();
                    }
                }
            });
            this.mKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0826a.this.mKI != null) {
                        C0826a.this.mKI.dFJ();
                    }
                }
            });
            this.mKP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0826a.this.mKI != null) {
                        C0826a.this.mKI.dFH();
                    }
                }
            });
            this.mLb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cpo() {
            return LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.dzy, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).V(this.mLb).of(R.color.cp_bg_line_i).aZ(this.mKL);
            SvgManager.bjq().a(this.mKQ, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.mKR, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.mKS, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.mKT, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mKU, R.color.cp_cont_b);
            ap.setViewTextColor(this.mKV, R.color.cp_cont_b);
            ap.setViewTextColor(this.mKW, R.color.cp_cont_b);
            ap.setViewTextColor(this.mKX, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).oh(R.color.cp_bg_line_c).of(R.color.cp_bg_line_i).X(this.mLb).W(this.mLb).aZ(this.mKM);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).oh(R.color.cp_bg_line_c).of(R.color.cp_bg_line_i).aZ(this.mKN);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).oh(R.color.cp_bg_line_c).of(R.color.cp_bg_line_i).aZ(this.mKO);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).oh(R.color.cp_bg_line_c).of(R.color.cp_bg_line_i).Z(this.mLb).Y(this.mLb).aZ(this.mKP);
            ap.setBackgroundColor(this.mKY, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.mKZ, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.mLa, R.color.cp_bg_line_b);
        }
    }
}
