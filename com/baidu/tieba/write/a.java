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
    public View.OnClickListener jJy = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.nSk != null) {
                if (a.this.nSk.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eNx.getPageActivity(), a.this.nSk.getBgColor());
                }
                a.this.nSk.ze(true);
            }
        }
    };
    protected View mRootView = cFA();
    protected g nSk;

    public abstract View cFA();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eNx = tbPageContext;
        this.nSk = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dYk() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView feO;
        public View nSM;
        public TBLottieAnimationView nSN;
        public View nSV;
        public LinearLayout nSW;
        public ImageView nSX;
        public TextView nSY;
        public LinearLayout nSZ;
        public ImageView nTa;
        public TextView nTb;
        public LinearLayout nTc;
        public ImageView nTd;
        public TextView nTe;
        public LinearLayout nTf;
        public ImageView nTg;
        public TextView nTh;
        public LinearLayout nTi;
        ImageView nTj;
        public LinearLayout nTk;
        ImageView nTl;
        TextView nTm;
        public LinearLayout nTn;
        ImageView nTo;
        TextView nTp;
        public OvalActionButton nTq;
        public GridLayout nTr;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.nSZ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.nTa = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.nTb = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.nSW = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.nSX = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.nSY = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.nTc = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.nTd = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.nTe = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.nTf = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.nTg = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.nTh = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.nTi = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.nTj = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.feO = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.nTk = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.nTl = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.nTm = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.nTn = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.nTo = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.nTp = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.nTq = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.nSk != null && "frs".equals(this.nSk.getFrom())) {
                    this.nTq.setIsCircle(true);
                    this.nTq.setHasShadow(false);
                }
                this.nSV = this.mRootView.findViewById(R.id.view_background_white);
                this.nSM = this.mRootView.findViewById(R.id.view_background_translate);
                this.nTr = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.nTr.setMeasureAllChild(true);
                this.nTr.setVerNum(2);
                this.nSN = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.nSN.setSpeed(1.2f);
                dYk();
                this.nSM.setOnClickListener(this.jJy);
                this.nSM.setClickable(true);
                this.nTa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSk != null) {
                            c.this.nSk.VE(c.this.nSk.cKy());
                        }
                    }
                });
                this.nSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSk != null) {
                            c.this.nSk.dYy();
                        }
                    }
                });
                this.nTd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSk != null) {
                            c.this.nSk.dYx();
                        }
                    }
                });
                this.nTg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSk != null) {
                            c.this.nSk.dYw();
                        }
                    }
                });
                this.nTi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSk != null) {
                            c.this.nSk.VD(c.this.nSk.cKy());
                        }
                    }
                });
                this.nTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSk != null) {
                            c.this.nSk.dYz();
                        }
                    }
                });
                this.nTn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nSk != null) {
                            c.this.nSk.dYv();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cFA() {
            return LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void za(boolean z) {
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.nTq.onChangeSkinType(i);
            ap.a(this.nSN, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.nSV, R.drawable.write_tab_background);
            ap.setImageResource(this.nSX, R.drawable.icon_mask_post_photograph56);
            ap.setImageResource(this.nTa, R.drawable.icon_mask_post_text56);
            ap.setImageResource(this.nTd, R.drawable.icon_mask_post_image56);
            ap.setImageResource(this.nTg, R.drawable.icon_mask_post_live56);
            ap.setImageResource(this.nTj, R.drawable.icon_mask_post_vote56);
            ap.setImageResource(this.nTl, R.drawable.icon_mask_post_evaluation56);
            ap.setImageResource(this.nTo, R.drawable.icon_mask_post_goods56);
            ap.setViewTextColor(this.nSY, R.color.CAM_X0107);
            ap.setViewTextColor(this.nTb, R.color.CAM_X0107);
            ap.setViewTextColor(this.nTe, R.color.CAM_X0107);
            ap.setViewTextColor(this.nTh, R.color.CAM_X0107);
            ap.setViewTextColor(this.feO, R.color.CAM_X0107);
            ap.setViewTextColor(this.nTm, R.color.CAM_X0107);
            ap.setViewTextColor(this.nTp, R.color.CAM_X0107);
        }

        @Override // com.baidu.tieba.write.a
        public void dYk() {
            int equipmentWidth = l.getEquipmentWidth(this.eNx.getPageActivity());
            int i = (int) (0.13518518f * equipmentWidth);
            b(this.nTa, i);
            b(this.nSX, i);
            b(this.nTd, i);
            b(this.nTg, i);
            b(this.nTj, i);
            b(this.nTl, i);
            b(this.nTo, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.nTr.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds433) * dimens);
                this.nTr.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nSV.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1023 : dimens2;
                this.nSV.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.nSN.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.nSN.setLayoutParams(layoutParams3);
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
        public View nSM;
        public TBLottieAnimationView nSN;
        public RelativeLayout nSO;
        public View nSP;
        public View nSQ;
        public View nSR;
        public View nSS;
        public View nST;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.nSM = this.mRootView.findViewById(R.id.transparent_back_view);
            this.ehl = this.mRootView.findViewById(R.id.view_background);
            this.nSN = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.nSO = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.eAC = this.mRootView.findViewById(R.id.closeView);
            this.nSP = this.mRootView.findViewById(R.id.publish_text_view);
            this.nSQ = this.mRootView.findViewById(R.id.publish_image_view);
            this.nSR = this.mRootView.findViewById(R.id.publish_video_view);
            this.nSS = this.mRootView.findViewById(R.id.publish_ala_view);
            this.nST = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.ehl.setOnClickListener(this.jJy);
            this.nSO.setOnClickListener(this.jJy);
            this.eAC.setOnClickListener(this.jJy);
            this.nSP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nSk != null) {
                        b.this.nSk.VE(b.this.nSk.cKy());
                    }
                }
            });
            this.nSQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nSk != null) {
                        b.this.nSk.dYx();
                    }
                }
            });
            this.nSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nSk != null) {
                        b.this.nSk.dYy();
                    }
                }
            });
            this.nSS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nSk != null) {
                        b.this.nSk.dYw();
                    }
                }
            });
            yY(false);
            this.nSN.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cFA() {
            return LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.nSN, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.ehl, R.color.CAM_X0502);
            ap.setBackgroundResource(this.nST, R.drawable.home_publish_ala_red_tip);
        }

        public void yY(boolean z) {
            this.ehl.setClickable(z);
            this.nSO.setClickable(z);
            this.eAC.setClickable(z);
            this.nSP.setClickable(z);
            this.nSQ.setClickable(z);
            this.nSR.setClickable(z);
            this.nSS.setClickable(z);
        }

        public void yZ(boolean z) {
            if (this.nST != null) {
                if (z) {
                    this.nST.setVisibility(0);
                } else {
                    this.nST.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0890a extends a {
        public View ehl;
        private TextView nSA;
        private TextView nSB;
        private TextView nSC;
        private TextView nSD;
        private TextView nSE;
        private View nSF;
        private View nSG;
        private View nSH;
        private View nSI;
        private View nSJ;
        private int nSK;
        public LinearLayout nSm;
        private LinearLayout nSn;
        private LinearLayout nSo;
        private LinearLayout nSp;
        private LinearLayout nSq;
        private LinearLayout nSr;
        private LinearLayout nSs;
        private ImageView nSt;
        private ImageView nSu;
        private ImageView nSv;
        private ImageView nSw;
        private ImageView nSx;
        private ImageView nSy;
        private TextView nSz;

        public C0890a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.ehl = this.mRootView.findViewById(R.id.view_background);
            this.nSm = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.nSn = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.nSt = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.nSz = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.nSo = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.nSu = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.nSA = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.nSp = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.nSv = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.nSB = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.nSq = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.nSw = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.nSC = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.nSr = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.nSx = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.nSD = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.nSs = (LinearLayout) this.mRootView.findViewById(R.id.thread_write_score);
            this.nSy = (ImageView) this.mRootView.findViewById(R.id.thread_write_score_iv);
            this.nSE = (TextView) this.mRootView.findViewById(R.id.thread_write_score_tv);
            this.nSF = this.mRootView.findViewById(R.id.line_1);
            this.nSG = this.mRootView.findViewById(R.id.line_2);
            this.nSH = this.mRootView.findViewById(R.id.line_3);
            this.nSI = this.mRootView.findViewById(R.id.line_4);
            this.nSJ = this.mRootView.findViewById(R.id.line_5);
            this.nSz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.nSA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.nSB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.nSC.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.nSD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.nSE.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.ehl.setOnClickListener(this.jJy);
            this.nSn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSk != null) {
                        C0890a.this.nSk.VE(C0890a.this.nSk.cKy());
                    }
                }
            });
            this.nSo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSk != null) {
                        C0890a.this.nSk.dYx();
                    }
                }
            });
            this.nSp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSk != null) {
                        C0890a.this.nSk.dYy();
                    }
                }
            });
            this.nSq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSk != null) {
                        C0890a.this.nSk.dYw();
                    }
                }
            });
            this.nSr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSk != null) {
                        C0890a.this.nSk.VD(C0890a.this.nSk.cKy());
                    }
                }
            });
            this.nSs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0890a.this.nSk != null) {
                        C0890a.this.nSk.dYz();
                    }
                }
            });
            this.nSK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cFA() {
            return LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.ehl, R.color.CAM_X0603);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).ac(this.nSK).qg(R.color.CAM_X0701).bq(this.nSm);
            this.nSt.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.nSu.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.nSv.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.nSw.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.nSx.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            this.nSy.setImageDrawable(WebPManager.a(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.nSz, R.color.CAM_X0101);
            ap.setViewTextColor(this.nSA, R.color.CAM_X0101);
            ap.setViewTextColor(this.nSB, R.color.CAM_X0101);
            ap.setViewTextColor(this.nSC, R.color.CAM_X0101);
            ap.setViewTextColor(this.nSD, R.color.CAM_X0101);
            ap.setViewTextColor(this.nSE, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).ae(this.nSK).ad(this.nSK).bq(this.nSn);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).bq(this.nSo);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).bq(this.nSp);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).bq(this.nSq);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).ag(this.nSK).af(this.nSK).bq(this.nSr);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qo(1).ag(this.nSK).af(this.nSK).bq(this.nSs);
            ap.setBackgroundColor(this.nSF, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nSG, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nSH, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nSI, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nSJ, R.color.CAM_X0613);
        }
    }
}
