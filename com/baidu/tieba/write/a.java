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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext eXu;
    public View.OnClickListener jWL = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.nVG != null) {
                if (a.this.nVG.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eXu.getPageActivity(), a.this.nVG.getBgColor());
                }
                a.this.nVG.ze(true);
            }
        }
    };
    protected View mRootView = cIy();
    protected g nVG;

    public abstract View cIy();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eXu = tbPageContext;
        this.nVG = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dXP() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView fow;
        public TextView nWA;
        public LinearLayout nWB;
        public ImageView nWC;
        public TextView nWD;
        public LinearLayout nWE;
        ImageView nWF;
        public LinearLayout nWG;
        ImageView nWH;
        TextView nWI;
        public LinearLayout nWJ;
        ImageView nWK;
        TextView nWL;
        public OvalActionButton nWM;
        public GridLayout nWN;
        public View nWi;
        public TBLottieAnimationView nWj;
        public View nWr;
        public LinearLayout nWs;
        public ImageView nWt;
        public TextView nWu;
        public LinearLayout nWv;
        public ImageView nWw;
        public TextView nWx;
        public LinearLayout nWy;
        public ImageView nWz;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.nWv = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.nWw = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.nWx = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.nWs = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.nWt = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.nWu = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.nWy = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.nWz = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.nWA = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.nWB = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.nWC = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.nWD = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.nWE = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.nWF = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.fow = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.nWG = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.nWH = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.nWI = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.nWJ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.nWK = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.nWL = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.nWM = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.nVG != null && "frs".equals(this.nVG.getFrom())) {
                    this.nWM.setIsCircle(true);
                    this.nWM.setHasShadow(false);
                }
                this.nWr = this.mRootView.findViewById(R.id.view_background_white);
                this.nWi = this.mRootView.findViewById(R.id.view_background_translate);
                this.nWN = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.nWN.setMeasureAllChild(true);
                this.nWN.setVerNum(2);
                this.nWj = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.nWj.setSpeed(1.2f);
                dXP();
                this.nWi.setOnClickListener(this.jWL);
                this.nWi.setClickable(true);
                this.nWw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVG != null) {
                            c.this.nVG.Vi(c.this.nVG.cNA());
                        }
                    }
                });
                this.nWt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVG != null) {
                            c.this.nVG.dYe();
                        }
                    }
                });
                this.nWz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVG != null) {
                            c.this.nVG.dYd();
                        }
                    }
                });
                this.nWC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVG != null) {
                            c.this.nVG.dYc();
                        }
                    }
                });
                this.nWE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVG != null) {
                            c.this.nVG.Vh(c.this.nVG.cNA());
                        }
                    }
                });
                this.nWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVG != null) {
                            c.this.nVG.dYf();
                        }
                    }
                });
                this.nWJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVG != null) {
                            c.this.nVG.dYb();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cIy() {
            return LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void za(boolean z) {
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.nWM.onChangeSkinType(i);
            ao.a(this.nWj, R.raw.bottom_bar_bg);
            ao.setBackgroundResource(this.nWr, R.drawable.write_tab_background);
            ao.setImageResource(this.nWt, R.drawable.icon_mask_post_photograph56);
            ao.setImageResource(this.nWw, R.drawable.icon_mask_post_text56);
            ao.setImageResource(this.nWz, R.drawable.icon_mask_post_image56);
            ao.setImageResource(this.nWC, R.drawable.icon_mask_post_live56);
            ao.setImageResource(this.nWF, R.drawable.icon_mask_post_vote56);
            ao.setImageResource(this.nWH, R.drawable.icon_mask_post_evaluation56);
            ao.setImageResource(this.nWK, R.drawable.icon_mask_post_goods56);
            ao.setViewTextColor(this.nWu, R.color.CAM_X0107);
            ao.setViewTextColor(this.nWx, R.color.CAM_X0107);
            ao.setViewTextColor(this.nWA, R.color.CAM_X0107);
            ao.setViewTextColor(this.nWD, R.color.CAM_X0107);
            ao.setViewTextColor(this.fow, R.color.CAM_X0107);
            ao.setViewTextColor(this.nWI, R.color.CAM_X0107);
            ao.setViewTextColor(this.nWL, R.color.CAM_X0107);
        }

        @Override // com.baidu.tieba.write.a
        public void dXP() {
            int equipmentWidth = l.getEquipmentWidth(this.eXu.getPageActivity());
            int i = (int) (0.13518518f * equipmentWidth);
            b(this.nWw, i);
            b(this.nWt, i);
            b(this.nWz, i);
            b(this.nWC, i);
            b(this.nWF, i);
            b(this.nWH, i);
            b(this.nWK, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.nWN.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds433) * dimens);
                this.nWN.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nWr.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1023 : dimens2;
                this.nWr.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.nWj.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.nWj.setLayoutParams(layoutParams3);
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
        public View eKf;
        public View eqn;
        public View nWi;
        public TBLottieAnimationView nWj;
        public RelativeLayout nWk;
        public View nWl;
        public View nWm;
        public View nWn;
        public View nWo;
        public View nWp;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.nWi = this.mRootView.findViewById(R.id.transparent_back_view);
            this.eqn = this.mRootView.findViewById(R.id.view_background);
            this.nWj = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.nWk = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.eKf = this.mRootView.findViewById(R.id.closeView);
            this.nWl = this.mRootView.findViewById(R.id.publish_text_view);
            this.nWm = this.mRootView.findViewById(R.id.publish_image_view);
            this.nWn = this.mRootView.findViewById(R.id.publish_video_view);
            this.nWo = this.mRootView.findViewById(R.id.publish_ala_view);
            this.nWp = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.eqn.setOnClickListener(this.jWL);
            this.nWk.setOnClickListener(this.jWL);
            this.eKf.setOnClickListener(this.jWL);
            this.nWl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nVG != null) {
                        b.this.nVG.Vi(b.this.nVG.cNA());
                    }
                }
            });
            this.nWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nVG != null) {
                        b.this.nVG.dYd();
                    }
                }
            });
            this.nWn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nVG != null) {
                        b.this.nVG.dYe();
                    }
                }
            });
            this.nWo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nVG != null) {
                        b.this.nVG.dYc();
                    }
                }
            });
            yY(false);
            this.nWj.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cIy() {
            return LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ao.a(this.nWj, R.raw.lottie_use_publish_n);
            ao.setBackgroundResource(this.eqn, R.color.CAM_X0502);
            ao.setBackgroundResource(this.nWp, R.drawable.home_publish_ala_red_tip);
        }

        public void yY(boolean z) {
            this.eqn.setClickable(z);
            this.nWk.setClickable(z);
            this.eKf.setClickable(z);
            this.nWl.setClickable(z);
            this.nWm.setClickable(z);
            this.nWn.setClickable(z);
            this.nWo.setClickable(z);
        }

        public void yZ(boolean z) {
            if (this.nWp != null) {
                if (z) {
                    this.nWp.setVisibility(0);
                } else {
                    this.nWp.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0910a extends a {
        public View eqn;
        public LinearLayout nVI;
        private LinearLayout nVJ;
        private LinearLayout nVK;
        private LinearLayout nVL;
        private LinearLayout nVM;
        private LinearLayout nVN;
        private LinearLayout nVO;
        private ImageView nVP;
        private ImageView nVQ;
        private ImageView nVR;
        private ImageView nVS;
        private ImageView nVT;
        private ImageView nVU;
        private TextView nVV;
        private TextView nVW;
        private TextView nVX;
        private TextView nVY;
        private TextView nVZ;
        private TextView nWa;
        private View nWb;
        private View nWc;
        private View nWd;
        private View nWe;
        private View nWf;
        private int nWg;

        public C0910a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.eqn = this.mRootView.findViewById(R.id.view_background);
            this.nVI = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.nVJ = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.nVP = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.nVV = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.nVK = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.nVQ = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.nVW = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.nVL = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.nVR = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.nVX = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.nVM = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.nVS = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.nVY = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.nVN = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.nVT = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.nVZ = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.nVO = (LinearLayout) this.mRootView.findViewById(R.id.thread_write_score);
            this.nVU = (ImageView) this.mRootView.findViewById(R.id.thread_write_score_iv);
            this.nWa = (TextView) this.mRootView.findViewById(R.id.thread_write_score_tv);
            this.nWb = this.mRootView.findViewById(R.id.line_1);
            this.nWc = this.mRootView.findViewById(R.id.line_2);
            this.nWd = this.mRootView.findViewById(R.id.line_3);
            this.nWe = this.mRootView.findViewById(R.id.line_4);
            this.nWf = this.mRootView.findViewById(R.id.line_5);
            this.nVV.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.nVW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.nVX.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.nVY.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.nVZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.nWa.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.eqn.setOnClickListener(this.jWL);
            this.nVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0910a.this.nVG != null) {
                        C0910a.this.nVG.Vi(C0910a.this.nVG.cNA());
                    }
                }
            });
            this.nVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0910a.this.nVG != null) {
                        C0910a.this.nVG.dYd();
                    }
                }
            });
            this.nVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0910a.this.nVG != null) {
                        C0910a.this.nVG.dYe();
                    }
                }
            });
            this.nVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0910a.this.nVG != null) {
                        C0910a.this.nVG.dYc();
                    }
                }
            });
            this.nVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0910a.this.nVG != null) {
                        C0910a.this.nVG.Vh(C0910a.this.nVG.cNA());
                    }
                }
            });
            this.nVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0910a.this.nVG != null) {
                        C0910a.this.nVG.dYf();
                    }
                }
            });
            this.nWg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cIy() {
            return LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ao.setBackgroundColor(this.eqn, R.color.CAM_X0603);
            com.baidu.tbadk.core.util.f.a.bwV().qq(0).qz(1).ae(this.nWg).qr(R.color.CAM_X0701).bz(this.nVI);
            this.nVP.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.nVQ.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.nVR.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.nVS.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.nVT.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            this.nVU.setImageDrawable(WebPManager.a(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
            ao.setViewTextColor(this.nVV, R.color.CAM_X0101);
            ao.setViewTextColor(this.nVW, R.color.CAM_X0101);
            ao.setViewTextColor(this.nVX, R.color.CAM_X0101);
            ao.setViewTextColor(this.nVY, R.color.CAM_X0101);
            ao.setViewTextColor(this.nVZ, R.color.CAM_X0101);
            ao.setViewTextColor(this.nWa, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.bwV().qq(0).qz(1).ag(this.nWg).af(this.nWg).bz(this.nVJ);
            com.baidu.tbadk.core.util.f.a.bwV().qq(0).qz(1).bz(this.nVK);
            com.baidu.tbadk.core.util.f.a.bwV().qq(0).qz(1).bz(this.nVL);
            com.baidu.tbadk.core.util.f.a.bwV().qq(0).qz(1).bz(this.nVM);
            com.baidu.tbadk.core.util.f.a.bwV().qq(0).qz(1).ai(this.nWg).ah(this.nWg).bz(this.nVN);
            com.baidu.tbadk.core.util.f.a.bwV().qq(0).qz(1).ai(this.nWg).ah(this.nWg).bz(this.nVO);
            ao.setBackgroundColor(this.nWb, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nWc, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nWd, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nWe, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nWf, R.color.CAM_X0613);
        }
    }
}
