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
    protected TbPageContext eCn;
    public View.OnClickListener jpo = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.nwR != null) {
                if (a.this.nwR.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eCn.getPageActivity(), a.this.nwR.getBgColor());
                }
                a.this.nwR.yj(true);
            }
        }
    };
    protected View mRootView = czg();
    protected g nwR;

    public abstract View czg();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eCn = tbPageContext;
        this.nwR = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dQp() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView eSv;
        public ImageView nxA;
        public TextView nxB;
        public LinearLayout nxC;
        public ImageView nxD;
        public TextView nxE;
        public LinearLayout nxF;
        public ImageView nxG;
        public TextView nxH;
        public LinearLayout nxI;
        public ImageView nxJ;
        public TextView nxK;
        public LinearLayout nxL;
        ImageView nxM;
        public LinearLayout nxN;
        ImageView nxO;
        TextView nxP;
        public LinearLayout nxQ;
        ImageView nxR;
        TextView nxS;
        public OvalActionButton nxT;
        public GridLayout nxU;
        public View nxp;
        public TBLottieAnimationView nxq;
        public View nxy;
        public LinearLayout nxz;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.nxC = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.nxD = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.nxE = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.nxz = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.nxA = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.nxB = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.nxF = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.nxG = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.nxH = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.nxI = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.nxJ = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.nxK = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.nxL = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.nxM = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.eSv = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.nxN = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.nxO = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.nxP = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.nxQ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.nxR = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.nxS = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.nxT = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.nwR != null && "frs".equals(this.nwR.getFrom())) {
                    this.nxT.setIsCircle(true);
                    this.nxT.setHasShadow(false);
                }
                this.nxy = this.mRootView.findViewById(R.id.view_background_white);
                this.nxp = this.mRootView.findViewById(R.id.view_background_translate);
                this.nxU = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.nxU.setMeasureAllChild(true);
                this.nxU.setVerNum(2);
                this.nxq = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.nxq.setSpeed(1.2f);
                dQp();
                this.nxp.setOnClickListener(this.jpo);
                this.nxp.setClickable(true);
                this.nxD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nwR != null) {
                            c.this.nwR.Un(c.this.nwR.cDd());
                        }
                    }
                });
                this.nxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nwR != null) {
                            c.this.nwR.dQG();
                        }
                    }
                });
                this.nxG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nwR != null) {
                            c.this.nwR.dQF();
                        }
                    }
                });
                this.nxJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nwR != null) {
                            c.this.nwR.dQE();
                        }
                    }
                });
                this.nxL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nwR != null) {
                            c.this.nwR.Um(c.this.nwR.cDd());
                        }
                    }
                });
                this.nxN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nwR != null) {
                            c.this.nwR.dQC();
                        }
                    }
                });
                this.nxQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nwR != null) {
                            c.this.nwR.dQD();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View czg() {
            return LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void yf(boolean z) {
            this.nxN.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.nxT.onChangeSkinType(i);
            ap.a(this.nxq, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.nxy, R.drawable.write_tab_background);
            this.nxA.setImageDrawable(SvgManager.boN().j(R.drawable.ic_icon_post_photograph60_svg, 1, true));
            this.nxD.setImageDrawable(SvgManager.boN().j(R.drawable.ic_icon_post_text60_svg, 1, true));
            this.nxG.setImageDrawable(SvgManager.boN().j(R.drawable.ic_icon_post_image60_svg, 1, true));
            this.nxJ.setImageDrawable(SvgManager.boN().j(R.drawable.ic_icon_post_live60_svg, 1, true));
            this.nxM.setImageDrawable(SvgManager.boN().j(R.drawable.ic_icon_post_vote60_svg, 1, true));
            this.nxO.setImageDrawable(SvgManager.boN().j(R.drawable.ic_icon_post_evaluation60_svg, 1, true));
            ap.setImageResource(this.nxR, R.drawable.icon_post_haowu60);
            ap.setViewTextColor(this.nxB, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxE, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxH, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxK, R.color.cp_cont_b);
            ap.setViewTextColor(this.eSv, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxP, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxS, R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dQp() {
            int equipmentWidth = l.getEquipmentWidth(this.eCn.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.nxD, i);
            b(this.nxA, i);
            b(this.nxG, i);
            b(this.nxJ, i);
            b(this.nxM, i);
            b(this.nxO, i);
            b(this.nxR, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.nxU.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds455) * dimens);
                this.nxU.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nxy.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1144) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1144 : dimens2;
                this.nxy.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.nxq.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.nxq.setLayoutParams(layoutParams3);
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
        public View dWb;
        public View epq;
        public View nxp;
        public TBLottieAnimationView nxq;
        public RelativeLayout nxr;
        public View nxs;
        public View nxt;
        public View nxu;
        public View nxv;
        public View nxw;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.nxp = this.mRootView.findViewById(R.id.transparent_back_view);
            this.dWb = this.mRootView.findViewById(R.id.view_background);
            this.nxq = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.nxr = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.epq = this.mRootView.findViewById(R.id.closeView);
            this.nxs = this.mRootView.findViewById(R.id.publish_text_view);
            this.nxt = this.mRootView.findViewById(R.id.publish_image_view);
            this.nxu = this.mRootView.findViewById(R.id.publish_video_view);
            this.nxv = this.mRootView.findViewById(R.id.publish_ala_view);
            this.nxw = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.dWb.setOnClickListener(this.jpo);
            this.nxr.setOnClickListener(this.jpo);
            this.epq.setOnClickListener(this.jpo);
            this.nxs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nwR != null) {
                        b.this.nwR.Un(b.this.nwR.cDd());
                    }
                }
            });
            this.nxt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nwR != null) {
                        b.this.nwR.dQF();
                    }
                }
            });
            this.nxu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nwR != null) {
                        b.this.nwR.dQG();
                    }
                }
            });
            this.nxv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nwR != null) {
                        b.this.nwR.dQE();
                    }
                }
            });
            yd(false);
            this.nxq.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View czg() {
            return LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.nxq, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.dWb, R.color.cp_mask_d);
            ap.setBackgroundResource(this.nxw, R.drawable.home_publish_ala_red_tip);
        }

        public void yd(boolean z) {
            this.dWb.setClickable(z);
            this.nxr.setClickable(z);
            this.epq.setClickable(z);
            this.nxs.setClickable(z);
            this.nxt.setClickable(z);
            this.nxu.setClickable(z);
            this.nxv.setClickable(z);
        }

        public void ye(boolean z) {
            if (this.nxw != null) {
                if (z) {
                    this.nxw.setVisibility(0);
                } else {
                    this.nxw.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0856a extends a {
        public View dWb;
        public LinearLayout nwT;
        private LinearLayout nwU;
        private LinearLayout nwV;
        private LinearLayout nwW;
        private LinearLayout nwX;
        private LinearLayout nwY;
        private ImageView nwZ;
        private ImageView nxa;
        private ImageView nxb;
        private ImageView nxc;
        private ImageView nxd;
        private TextView nxe;
        private TextView nxf;
        private TextView nxg;
        private TextView nxh;
        private TextView nxi;
        private View nxj;
        private View nxk;
        private View nxl;
        private View nxm;
        private int nxn;

        public C0856a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.dWb = this.mRootView.findViewById(R.id.view_background);
            this.nwT = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.nwU = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.nwZ = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.nxe = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.nwV = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.nxa = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.nxf = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.nwW = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.nxb = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.nxg = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.nwX = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.nxc = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.nxh = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.nwY = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.nxd = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.nxi = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.nxj = this.mRootView.findViewById(R.id.line_1);
            this.nxk = this.mRootView.findViewById(R.id.line_2);
            this.nxl = this.mRootView.findViewById(R.id.line_3);
            this.nxm = this.mRootView.findViewById(R.id.line_4);
            this.nxe.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.nxf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.nxg.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.nxh.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.nxi.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.dWb.setOnClickListener(this.jpo);
            this.nwU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0856a.this.nwR != null) {
                        C0856a.this.nwR.Un(C0856a.this.nwR.cDd());
                    }
                }
            });
            this.nwV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0856a.this.nwR != null) {
                        C0856a.this.nwR.dQF();
                    }
                }
            });
            this.nwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0856a.this.nwR != null) {
                        C0856a.this.nwR.dQG();
                    }
                }
            });
            this.nwX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0856a.this.nwR != null) {
                        C0856a.this.nwR.dQE();
                    }
                }
            });
            this.nwY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0856a.this.nwR != null) {
                        C0856a.this.nwR.Um(C0856a.this.nwR.cDd());
                    }
                }
            });
            this.nxn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View czg() {
            return LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.dWb, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pg(1).Z(this.nxn).pa(R.color.cp_bg_line_i).bg(this.nwT);
            SvgManager.boN().a(this.nwZ, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.boN().a(this.nxa, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.boN().a(this.nxb, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.boN().a(this.nxc, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            this.nxd.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_toupiao16, WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.nxe, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxf, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxg, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxh, R.color.cp_cont_b);
            ap.setViewTextColor(this.nxi, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pg(1).pc(R.color.cp_bg_line_c).pa(R.color.cp_bg_line_i).ab(this.nxn).aa(this.nxn).bg(this.nwU);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pg(1).pc(R.color.cp_bg_line_c).pa(R.color.cp_bg_line_i).bg(this.nwV);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pg(1).pc(R.color.cp_bg_line_c).pa(R.color.cp_bg_line_i).bg(this.nwW);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pg(1).pc(R.color.cp_bg_line_c).pa(R.color.cp_bg_line_i).bg(this.nwX);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pg(1).pc(R.color.cp_bg_line_c).pa(R.color.cp_bg_line_i).ad(this.nxn).ac(this.nxn).bg(this.nwY);
            ap.setBackgroundColor(this.nxj, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.nxk, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.nxl, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.nxm, R.color.cp_bg_line_b);
        }
    }
}
