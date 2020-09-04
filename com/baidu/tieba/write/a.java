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
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext efr;
    protected g mLa;
    public View.OnClickListener mLb = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mLa != null) {
                if (a.this.mLa.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.efr.getPageActivity(), a.this.mLa.getBgColor());
                }
                a.this.mLa.xc(true);
            }
        }
    };
    protected View mRootView = cpp();

    public abstract View cpp();

    public a(TbPageContext tbPageContext, g gVar) {
        this.efr = tbPageContext;
        this.mLa = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dFB() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView evL;
        public View mLE;
        public LinearLayout mLF;
        public ImageView mLG;
        public TextView mLH;
        public LinearLayout mLI;
        public ImageView mLJ;
        public TextView mLK;
        public LinearLayout mLL;
        public ImageView mLM;
        public TextView mLN;
        public LinearLayout mLO;
        public ImageView mLP;
        public TextView mLQ;
        public LinearLayout mLR;
        ImageView mLS;
        public LinearLayout mLT;
        ImageView mLU;
        TextView mLV;
        public LinearLayout mLW;
        ImageView mLX;
        TextView mLY;
        public OvalActionButton mLZ;
        public View mLv;
        public TBLottieAnimationView mLw;
        public GridLayout mMa;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.mLI = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.mLJ = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.mLK = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mLF = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.mLG = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.mLH = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.mLL = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.mLM = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.mLN = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.mLO = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.mLP = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.mLQ = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.mLR = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.mLS = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.evL = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.mLT = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.mLU = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.mLV = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.mLW = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.mLX = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.mLY = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.mLZ = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.mLa != null && "frs".equals(this.mLa.getFrom())) {
                    this.mLZ.setIsCircle(true);
                    this.mLZ.setHasShadow(false);
                }
                this.mLE = this.mRootView.findViewById(R.id.view_background_white);
                this.mLv = this.mRootView.findViewById(R.id.view_background_translate);
                this.mMa = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.mMa.setMeasureAllChild(true);
                this.mMa.setVerNum(2);
                this.mLw = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.mLw.setSpeed(1.2f);
                dFB();
                this.mLv.setOnClickListener(this.mLb);
                this.mLv.setClickable(true);
                this.mLJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mLa != null) {
                            c.this.mLa.SA(c.this.mLa.cti());
                        }
                    }
                });
                this.mLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mLa != null) {
                            c.this.mLa.dFS();
                        }
                    }
                });
                this.mLM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mLa != null) {
                            c.this.mLa.dFR();
                        }
                    }
                });
                this.mLP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mLa != null) {
                            c.this.mLa.dFQ();
                        }
                    }
                });
                this.mLR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mLa != null) {
                            c.this.mLa.Sz(c.this.mLa.cti());
                        }
                    }
                });
                this.mLT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mLa != null) {
                            c.this.mLa.dFO();
                        }
                    }
                });
                this.mLW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mLa != null) {
                            c.this.mLa.dFP();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cpp() {
            return LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void wY(boolean z) {
            this.mLT.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.mLZ.onChangeSkinType(i);
            ap.a(this.mLw, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.mLE, R.drawable.write_tab_background);
            this.mLG.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_photograph60_svg, 1, true));
            this.mLJ.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_text60_svg, 1, true));
            this.mLM.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_image60_svg, 1, true));
            this.mLP.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_live60_svg, 1, true));
            this.mLS.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_vote60_svg, 1, true));
            this.mLU.setImageDrawable(SvgManager.bjq().i(R.drawable.ic_icon_post_evaluation60_svg, 1, true));
            ap.setImageResource(this.mLX, R.drawable.icon_post_haowu60);
            ap.setViewTextColor(this.mLH, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLK, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLN, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLQ, R.color.cp_cont_b);
            ap.setViewTextColor(this.evL, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLV, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLY, R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dFB() {
            int equipmentWidth = l.getEquipmentWidth(this.efr.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.mLJ, i);
            b(this.mLG, i);
            b(this.mLM, i);
            b(this.mLP, i);
            b(this.mLS, i);
            b(this.mLU, i);
            b(this.mLX, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.mMa.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds455) * dimens);
                this.mMa.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mLE.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1144) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1144 : dimens2;
                this.mLE.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.mLw.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.mLw.setLayoutParams(layoutParams3);
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
        public View dSG;
        public View dzC;
        public View mLA;
        public View mLB;
        public View mLC;
        public View mLv;
        public TBLottieAnimationView mLw;
        public RelativeLayout mLx;
        public View mLy;
        public View mLz;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.mLv = this.mRootView.findViewById(R.id.transparent_back_view);
            this.dzC = this.mRootView.findViewById(R.id.view_background);
            this.mLw = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.mLx = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dSG = this.mRootView.findViewById(R.id.closeView);
            this.mLy = this.mRootView.findViewById(R.id.publish_text_view);
            this.mLz = this.mRootView.findViewById(R.id.publish_image_view);
            this.mLA = this.mRootView.findViewById(R.id.publish_video_view);
            this.mLB = this.mRootView.findViewById(R.id.publish_ala_view);
            this.mLC = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.dzC.setOnClickListener(this.mLb);
            this.mLx.setOnClickListener(this.mLb);
            this.dSG.setOnClickListener(this.mLb);
            this.mLy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mLa != null) {
                        b.this.mLa.SA(b.this.mLa.cti());
                    }
                }
            });
            this.mLz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mLa != null) {
                        b.this.mLa.dFR();
                    }
                }
            });
            this.mLA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mLa != null) {
                        b.this.mLa.dFS();
                    }
                }
            });
            this.mLB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mLa != null) {
                        b.this.mLa.dFQ();
                    }
                }
            });
            wW(false);
            this.mLw.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cpp() {
            return LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.mLw, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.dzC, R.color.cp_mask_d);
            ap.setBackgroundResource(this.mLC, R.drawable.home_publish_ala_red_tip);
        }

        public void wW(boolean z) {
            this.dzC.setClickable(z);
            this.mLx.setClickable(z);
            this.dSG.setClickable(z);
            this.mLy.setClickable(z);
            this.mLz.setClickable(z);
            this.mLA.setClickable(z);
            this.mLB.setClickable(z);
        }

        public void wX(boolean z) {
            if (this.mLC != null) {
                if (z) {
                    this.mLC.setVisibility(0);
                } else {
                    this.mLC.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0826a extends a {
        public View dzC;
        private LinearLayout mLd;
        private LinearLayout mLe;
        private LinearLayout mLf;
        private LinearLayout mLg;
        private LinearLayout mLh;
        private ImageView mLi;
        private ImageView mLj;
        private ImageView mLk;
        private ImageView mLl;
        private TextView mLm;
        private TextView mLn;
        private TextView mLo;
        private TextView mLp;
        private View mLq;
        private View mLr;
        private View mLs;
        private int mLt;

        public C0826a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.dzC = this.mRootView.findViewById(R.id.view_background);
            this.mLd = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.mLe = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.mLi = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.mLm = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.mLf = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.mLj = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.mLn = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.mLg = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.mLk = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.mLo = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.mLh = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.mLl = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.mLp = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.mLq = this.mRootView.findViewById(R.id.line_1);
            this.mLr = this.mRootView.findViewById(R.id.line_2);
            this.mLs = this.mRootView.findViewById(R.id.line_3);
            this.mLm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_title));
            this.mLn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.mLo.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.mLp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.dzC.setOnClickListener(this.mLb);
            this.mLe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0826a.this.mLa != null) {
                        C0826a.this.mLa.SA(C0826a.this.mLa.cti());
                    }
                }
            });
            this.mLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0826a.this.mLa != null) {
                        C0826a.this.mLa.dFR();
                    }
                }
            });
            this.mLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0826a.this.mLa != null) {
                        C0826a.this.mLa.dFS();
                    }
                }
            });
            this.mLh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0826a.this.mLa != null) {
                        C0826a.this.mLa.dFQ();
                    }
                }
            });
            this.mLt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cpp() {
            return LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.dzC, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).V(this.mLt).of(R.color.cp_bg_line_i).aZ(this.mLd);
            SvgManager.bjq().a(this.mLi, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.mLj, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.mLk, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.mLl, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mLm, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLn, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLo, R.color.cp_cont_b);
            ap.setViewTextColor(this.mLp, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).oh(R.color.cp_bg_line_c).of(R.color.cp_bg_line_i).X(this.mLt).W(this.mLt).aZ(this.mLe);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).oh(R.color.cp_bg_line_c).of(R.color.cp_bg_line_i).aZ(this.mLf);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).oh(R.color.cp_bg_line_c).of(R.color.cp_bg_line_i).aZ(this.mLg);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).ol(1).oh(R.color.cp_bg_line_c).of(R.color.cp_bg_line_i).Z(this.mLt).Y(this.mLt).aZ(this.mLh);
            ap.setBackgroundColor(this.mLq, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.mLr, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.mLs, R.color.cp_bg_line_b);
        }
    }
}
