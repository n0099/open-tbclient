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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext eNx;
    public View.OnClickListener jJA = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.nSm != null) {
                if (a.this.nSm.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eNx.getPageActivity(), a.this.nSm.getBgColor());
                }
                a.this.nSm.ze(true);
            }
        }
    };
    protected View mRootView = cFB();
    protected g nSm;

    public abstract View cFB();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eNx = tbPageContext;
        this.nSm = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dYl() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView feO;
        public View nSO;
        public TBLottieAnimationView nSP;
        public View nSX;
        public LinearLayout nSY;
        public ImageView nSZ;
        public TextView nTa;
        public LinearLayout nTb;
        public ImageView nTc;
        public TextView nTd;
        public LinearLayout nTe;
        public ImageView nTf;
        public TextView nTg;
        public LinearLayout nTh;
        public ImageView nTi;
        public TextView nTj;
        public LinearLayout nTk;
        ImageView nTl;
        public LinearLayout nTm;
        ImageView nTn;
        TextView nTo;
        public LinearLayout nTp;
        ImageView nTq;
        TextView nTr;
        public OvalActionButton nTs;
        public GridLayout nTt;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.nTb = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.nTc = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.nTd = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.nSY = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.nSZ = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.nTa = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.nTe = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.nTf = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.nTg = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.nTh = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.nTi = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.nTj = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.nTk = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.nTl = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.feO = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.nTm = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.nTn = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.nTo = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.nTp = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.nTq = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.nTr = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.nTs = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.nSm != null && "frs".equals(this.nSm.getFrom())) {
                    this.nTs.setIsCircle(true);
                    this.nTs.setHasShadow(false);
                }
                this.nSX = this.mRootView.findViewById(R.id.view_background_white);
                this.nSO = this.mRootView.findViewById(R.id.view_background_translate);
                this.nTt = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.nTt.setMeasureAllChild(true);
                this.nTt.setVerNum(2);
                this.nSP = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.nSP.setSpeed(1.2f);
                dYl();
                this.nSO.setOnClickListener(this.jJA);
                this.nSO.setClickable(true);
                this.nTc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSm != null) {
                            c.this.nSm.VE(c.this.nSm.cKz());
                        }
                    }
                });
                this.nSZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSm != null) {
                            c.this.nSm.dYz();
                        }
                    }
                });
                this.nTf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSm != null) {
                            c.this.nSm.dYy();
                        }
                    }
                });
                this.nTi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSm != null) {
                            c.this.nSm.dYx();
                        }
                    }
                });
                this.nTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSm != null) {
                            c.this.nSm.VD(c.this.nSm.cKz());
                        }
                    }
                });
                this.nTm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSm != null) {
                            c.this.nSm.dYA();
                        }
                    }
                });
                this.nTp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSm != null) {
                            c.this.nSm.dYw();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cFB() {
            return LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void za(boolean z) {
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.nTs.onChangeSkinType(i);
            ap.a(this.nSP, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.nSX, R.drawable.write_tab_background);
            ap.setImageResource(this.nSZ, R.drawable.icon_mask_post_photograph56);
            ap.setImageResource(this.nTc, R.drawable.icon_mask_post_text56);
            ap.setImageResource(this.nTf, R.drawable.icon_mask_post_image56);
            ap.setImageResource(this.nTi, R.drawable.icon_mask_post_live56);
            ap.setImageResource(this.nTl, R.drawable.icon_mask_post_vote56);
            ap.setImageResource(this.nTn, R.drawable.icon_mask_post_evaluation56);
            ap.setImageResource(this.nTq, R.drawable.icon_mask_post_goods56);
            ap.setViewTextColor(this.nTa, R.color.CAM_X0107);
            ap.setViewTextColor(this.nTd, R.color.CAM_X0107);
            ap.setViewTextColor(this.nTg, R.color.CAM_X0107);
            ap.setViewTextColor(this.nTj, R.color.CAM_X0107);
            ap.setViewTextColor(this.feO, R.color.CAM_X0107);
            ap.setViewTextColor(this.nTo, R.color.CAM_X0107);
            ap.setViewTextColor(this.nTr, R.color.CAM_X0107);
        }

        @Override // com.baidu.tieba.write.a
        public void dYl() {
            int equipmentWidth = l.getEquipmentWidth(this.eNx.getPageActivity());
            int i = (int) (0.13518518f * equipmentWidth);
            b(this.nTc, i);
            b(this.nSZ, i);
            b(this.nTf, i);
            b(this.nTi, i);
            b(this.nTl, i);
            b(this.nTn, i);
            b(this.nTq, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.nTt.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds433) * dimens);
                this.nTt.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nSX.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1023 : dimens2;
                this.nSX.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.nSP.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.nSP.setLayoutParams(layoutParams3);
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
        public View eAC;
        public View ehl;
        public View nSO;
        public TBLottieAnimationView nSP;
        public RelativeLayout nSQ;
        public View nSR;
        public View nSS;
        public View nST;
        public View nSU;
        public View nSV;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.nSO = this.mRootView.findViewById(R.id.transparent_back_view);
            this.ehl = this.mRootView.findViewById(R.id.view_background);
            this.nSP = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.nSQ = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.eAC = this.mRootView.findViewById(R.id.closeView);
            this.nSR = this.mRootView.findViewById(R.id.publish_text_view);
            this.nSS = this.mRootView.findViewById(R.id.publish_image_view);
            this.nST = this.mRootView.findViewById(R.id.publish_video_view);
            this.nSU = this.mRootView.findViewById(R.id.publish_ala_view);
            this.nSV = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.ehl.setOnClickListener(this.jJA);
            this.nSQ.setOnClickListener(this.jJA);
            this.eAC.setOnClickListener(this.jJA);
            this.nSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nSm != null) {
                        b.this.nSm.VE(b.this.nSm.cKz());
                    }
                }
            });
            this.nSS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nSm != null) {
                        b.this.nSm.dYy();
                    }
                }
            });
            this.nST.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nSm != null) {
                        b.this.nSm.dYz();
                    }
                }
            });
            this.nSU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nSm != null) {
                        b.this.nSm.dYx();
                    }
                }
            });
            yY(false);
            this.nSP.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cFB() {
            return LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.nSP, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.ehl, R.color.CAM_X0502);
            ap.setBackgroundResource(this.nSV, R.drawable.home_publish_ala_red_tip);
        }

        public void yY(boolean z) {
            this.ehl.setClickable(z);
            this.nSQ.setClickable(z);
            this.eAC.setClickable(z);
            this.nSR.setClickable(z);
            this.nSS.setClickable(z);
            this.nST.setClickable(z);
            this.nSU.setClickable(z);
        }

        public void yZ(boolean z) {
            if (this.nSV != null) {
                if (z) {
                    this.nSV.setVisibility(0);
                } else {
                    this.nSV.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0890a extends a {
        public View ehl;
        private ImageView nSA;
        private TextView nSB;
        private TextView nSC;
        private TextView nSD;
        private TextView nSE;
        private TextView nSF;
        private TextView nSG;
        private View nSH;
        private View nSI;
        private View nSJ;
        private View nSK;
        private View nSL;
        private int nSM;
        public LinearLayout nSo;
        private LinearLayout nSp;
        private LinearLayout nSq;
        private LinearLayout nSr;
        private LinearLayout nSs;
        private LinearLayout nSt;
        private LinearLayout nSu;
        private ImageView nSv;
        private ImageView nSw;
        private ImageView nSx;
        private ImageView nSy;
        private ImageView nSz;

        public C0890a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.ehl = this.mRootView.findViewById(R.id.view_background);
            this.nSo = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.nSp = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.nSv = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.nSB = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.nSq = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.nSw = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.nSC = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.nSr = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.nSx = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.nSD = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.nSs = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.nSy = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.nSE = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.nSt = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.nSz = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.nSF = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.nSu = (LinearLayout) this.mRootView.findViewById(R.id.thread_write_score);
            this.nSA = (ImageView) this.mRootView.findViewById(R.id.thread_write_score_iv);
            this.nSG = (TextView) this.mRootView.findViewById(R.id.thread_write_score_tv);
            this.nSH = this.mRootView.findViewById(R.id.line_1);
            this.nSI = this.mRootView.findViewById(R.id.line_2);
            this.nSJ = this.mRootView.findViewById(R.id.line_3);
            this.nSK = this.mRootView.findViewById(R.id.line_4);
            this.nSL = this.mRootView.findViewById(R.id.line_5);
            this.nSB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.nSC.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.nSD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.nSE.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.nSF.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.nSG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.ehl.setOnClickListener(this.jJA);
            this.nSp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSm != null) {
                        C0890a.this.nSm.VE(C0890a.this.nSm.cKz());
                    }
                }
            });
            this.nSq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSm != null) {
                        C0890a.this.nSm.dYy();
                    }
                }
            });
            this.nSr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSm != null) {
                        C0890a.this.nSm.dYz();
                    }
                }
            });
            this.nSs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSm != null) {
                        C0890a.this.nSm.dYx();
                    }
                }
            });
            this.nSt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSm != null) {
                        C0890a.this.nSm.VD(C0890a.this.nSm.cKz());
                    }
                }
            });
            this.nSu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSm != null) {
                        C0890a.this.nSm.dYA();
                    }
                }
            });
            this.nSM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cFB() {
            return LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.ehl, R.color.CAM_X0603);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).ac(this.nSM).qg(R.color.CAM_X0701).bq(this.nSo);
            this.nSv.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.nSw.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.nSx.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.nSy.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.nSz.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            this.nSA.setImageDrawable(WebPManager.a(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.nSB, R.color.CAM_X0101);
            ap.setViewTextColor(this.nSC, R.color.CAM_X0101);
            ap.setViewTextColor(this.nSD, R.color.CAM_X0101);
            ap.setViewTextColor(this.nSE, R.color.CAM_X0101);
            ap.setViewTextColor(this.nSF, R.color.CAM_X0101);
            ap.setViewTextColor(this.nSG, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).ae(this.nSM).ad(this.nSM).bq(this.nSp);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).bq(this.nSq);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).bq(this.nSr);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).bq(this.nSs);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).ag(this.nSM).af(this.nSM).bq(this.nSt);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).ag(this.nSM).af(this.nSM).bq(this.nSu);
            ap.setBackgroundColor(this.nSH, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nSI, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nSJ, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nSK, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nSL, R.color.CAM_X0613);
        }
    }
}
