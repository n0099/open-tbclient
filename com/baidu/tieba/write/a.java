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
            if (a.this.nVH != null) {
                if (a.this.nVH.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eXu.getPageActivity(), a.this.nVH.getBgColor());
                }
                a.this.nVH.ze(true);
            }
        }
    };
    protected View mRootView = cIx();
    protected g nVH;

    public abstract View cIx();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eXu = tbPageContext;
        this.nVH = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dXO() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView fow;
        public ImageView nWA;
        public TextView nWB;
        public LinearLayout nWC;
        public ImageView nWD;
        public TextView nWE;
        public LinearLayout nWF;
        ImageView nWG;
        public LinearLayout nWH;
        ImageView nWI;
        TextView nWJ;
        public LinearLayout nWK;
        ImageView nWL;
        TextView nWM;
        public OvalActionButton nWN;
        public GridLayout nWO;
        public View nWj;
        public TBLottieAnimationView nWk;
        public View nWs;
        public LinearLayout nWt;
        public ImageView nWu;
        public TextView nWv;
        public LinearLayout nWw;
        public ImageView nWx;
        public TextView nWy;
        public LinearLayout nWz;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.nWw = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.nWx = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.nWy = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.nWt = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.nWu = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.nWv = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.nWz = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.nWA = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.nWB = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.nWC = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.nWD = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.nWE = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.nWF = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.nWG = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.fow = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.nWH = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.nWI = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.nWJ = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.nWK = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.nWL = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.nWM = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.nWN = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.nVH != null && "frs".equals(this.nVH.getFrom())) {
                    this.nWN.setIsCircle(true);
                    this.nWN.setHasShadow(false);
                }
                this.nWs = this.mRootView.findViewById(R.id.view_background_white);
                this.nWj = this.mRootView.findViewById(R.id.view_background_translate);
                this.nWO = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.nWO.setMeasureAllChild(true);
                this.nWO.setVerNum(2);
                this.nWk = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.nWk.setSpeed(1.2f);
                dXO();
                this.nWj.setOnClickListener(this.jWL);
                this.nWj.setClickable(true);
                this.nWx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVH != null) {
                            c.this.nVH.Vj(c.this.nVH.cNz());
                        }
                    }
                });
                this.nWu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVH != null) {
                            c.this.nVH.dYd();
                        }
                    }
                });
                this.nWA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVH != null) {
                            c.this.nVH.dYc();
                        }
                    }
                });
                this.nWD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVH != null) {
                            c.this.nVH.dYb();
                        }
                    }
                });
                this.nWF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVH != null) {
                            c.this.nVH.Vi(c.this.nVH.cNz());
                        }
                    }
                });
                this.nWH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVH != null) {
                            c.this.nVH.dYe();
                        }
                    }
                });
                this.nWK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nVH != null) {
                            c.this.nVH.dYa();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cIx() {
            return LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void za(boolean z) {
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.nWN.onChangeSkinType(i);
            ao.a(this.nWk, R.raw.bottom_bar_bg);
            ao.setBackgroundResource(this.nWs, R.drawable.write_tab_background);
            ao.setImageResource(this.nWu, R.drawable.icon_mask_post_photograph56);
            ao.setImageResource(this.nWx, R.drawable.icon_mask_post_text56);
            ao.setImageResource(this.nWA, R.drawable.icon_mask_post_image56);
            ao.setImageResource(this.nWD, R.drawable.icon_mask_post_live56);
            ao.setImageResource(this.nWG, R.drawable.icon_mask_post_vote56);
            ao.setImageResource(this.nWI, R.drawable.icon_mask_post_evaluation56);
            ao.setImageResource(this.nWL, R.drawable.icon_mask_post_goods56);
            ao.setViewTextColor(this.nWv, R.color.CAM_X0107);
            ao.setViewTextColor(this.nWy, R.color.CAM_X0107);
            ao.setViewTextColor(this.nWB, R.color.CAM_X0107);
            ao.setViewTextColor(this.nWE, R.color.CAM_X0107);
            ao.setViewTextColor(this.fow, R.color.CAM_X0107);
            ao.setViewTextColor(this.nWJ, R.color.CAM_X0107);
            ao.setViewTextColor(this.nWM, R.color.CAM_X0107);
        }

        @Override // com.baidu.tieba.write.a
        public void dXO() {
            int equipmentWidth = l.getEquipmentWidth(this.eXu.getPageActivity());
            int i = (int) (0.13518518f * equipmentWidth);
            b(this.nWx, i);
            b(this.nWu, i);
            b(this.nWA, i);
            b(this.nWD, i);
            b(this.nWG, i);
            b(this.nWI, i);
            b(this.nWL, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.nWO.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds433) * dimens);
                this.nWO.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nWs.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1023 : dimens2;
                this.nWs.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.nWk.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.nWk.setLayoutParams(layoutParams3);
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
        public View nWj;
        public TBLottieAnimationView nWk;
        public RelativeLayout nWl;
        public View nWm;
        public View nWn;
        public View nWo;
        public View nWp;
        public View nWq;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.nWj = this.mRootView.findViewById(R.id.transparent_back_view);
            this.eqn = this.mRootView.findViewById(R.id.view_background);
            this.nWk = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.nWl = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.eKf = this.mRootView.findViewById(R.id.closeView);
            this.nWm = this.mRootView.findViewById(R.id.publish_text_view);
            this.nWn = this.mRootView.findViewById(R.id.publish_image_view);
            this.nWo = this.mRootView.findViewById(R.id.publish_video_view);
            this.nWp = this.mRootView.findViewById(R.id.publish_ala_view);
            this.nWq = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.eqn.setOnClickListener(this.jWL);
            this.nWl.setOnClickListener(this.jWL);
            this.eKf.setOnClickListener(this.jWL);
            this.nWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nVH != null) {
                        b.this.nVH.Vj(b.this.nVH.cNz());
                    }
                }
            });
            this.nWn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nVH != null) {
                        b.this.nVH.dYc();
                    }
                }
            });
            this.nWo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nVH != null) {
                        b.this.nVH.dYd();
                    }
                }
            });
            this.nWp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nVH != null) {
                        b.this.nVH.dYb();
                    }
                }
            });
            yY(false);
            this.nWk.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cIx() {
            return LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ao.a(this.nWk, R.raw.lottie_use_publish_n);
            ao.setBackgroundResource(this.eqn, R.color.CAM_X0502);
            ao.setBackgroundResource(this.nWq, R.drawable.home_publish_ala_red_tip);
        }

        public void yY(boolean z) {
            this.eqn.setClickable(z);
            this.nWl.setClickable(z);
            this.eKf.setClickable(z);
            this.nWm.setClickable(z);
            this.nWn.setClickable(z);
            this.nWo.setClickable(z);
            this.nWp.setClickable(z);
        }

        public void yZ(boolean z) {
            if (this.nWq != null) {
                if (z) {
                    this.nWq.setVisibility(0);
                } else {
                    this.nWq.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0872a extends a {
        public View eqn;
        public LinearLayout nVJ;
        private LinearLayout nVK;
        private LinearLayout nVL;
        private LinearLayout nVM;
        private LinearLayout nVN;
        private LinearLayout nVO;
        private LinearLayout nVP;
        private ImageView nVQ;
        private ImageView nVR;
        private ImageView nVS;
        private ImageView nVT;
        private ImageView nVU;
        private ImageView nVV;
        private TextView nVW;
        private TextView nVX;
        private TextView nVY;
        private TextView nVZ;
        private TextView nWa;
        private TextView nWb;
        private View nWc;
        private View nWd;
        private View nWe;
        private View nWf;
        private View nWg;
        private int nWh;

        public C0872a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.eqn = this.mRootView.findViewById(R.id.view_background);
            this.nVJ = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.nVK = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.nVQ = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.nVW = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.nVL = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.nVR = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.nVX = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.nVM = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.nVS = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.nVY = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.nVN = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.nVT = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.nVZ = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.nVO = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.nVU = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.nWa = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.nVP = (LinearLayout) this.mRootView.findViewById(R.id.thread_write_score);
            this.nVV = (ImageView) this.mRootView.findViewById(R.id.thread_write_score_iv);
            this.nWb = (TextView) this.mRootView.findViewById(R.id.thread_write_score_tv);
            this.nWc = this.mRootView.findViewById(R.id.line_1);
            this.nWd = this.mRootView.findViewById(R.id.line_2);
            this.nWe = this.mRootView.findViewById(R.id.line_3);
            this.nWf = this.mRootView.findViewById(R.id.line_4);
            this.nWg = this.mRootView.findViewById(R.id.line_5);
            this.nVW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.nVX.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.nVY.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.nVZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.nWa.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.nWb.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.eqn.setOnClickListener(this.jWL);
            this.nVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0872a.this.nVH != null) {
                        C0872a.this.nVH.Vj(C0872a.this.nVH.cNz());
                    }
                }
            });
            this.nVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0872a.this.nVH != null) {
                        C0872a.this.nVH.dYc();
                    }
                }
            });
            this.nVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0872a.this.nVH != null) {
                        C0872a.this.nVH.dYd();
                    }
                }
            });
            this.nVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0872a.this.nVH != null) {
                        C0872a.this.nVH.dYb();
                    }
                }
            });
            this.nVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0872a.this.nVH != null) {
                        C0872a.this.nVH.Vi(C0872a.this.nVH.cNz());
                    }
                }
            });
            this.nVP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0872a.this.nVH != null) {
                        C0872a.this.nVH.dYe();
                    }
                }
            });
            this.nWh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cIx() {
            return LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ao.setBackgroundColor(this.eqn, R.color.CAM_X0603);
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).qz(1).ae(this.nWh).qr(R.color.CAM_X0701).bz(this.nVJ);
            this.nVQ.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.nVR.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.nVS.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.nVT.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.nVU.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            this.nVV.setImageDrawable(WebPManager.a(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
            ao.setViewTextColor(this.nVW, R.color.CAM_X0101);
            ao.setViewTextColor(this.nVX, R.color.CAM_X0101);
            ao.setViewTextColor(this.nVY, R.color.CAM_X0101);
            ao.setViewTextColor(this.nVZ, R.color.CAM_X0101);
            ao.setViewTextColor(this.nWa, R.color.CAM_X0101);
            ao.setViewTextColor(this.nWb, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).qz(1).ag(this.nWh).af(this.nWh).bz(this.nVK);
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).qz(1).bz(this.nVL);
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).qz(1).bz(this.nVM);
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).qz(1).bz(this.nVN);
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).qz(1).ai(this.nWh).ah(this.nWh).bz(this.nVO);
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).qz(1).ai(this.nWh).ah(this.nWh).bz(this.nVP);
            ao.setBackgroundColor(this.nWc, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nWd, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nWe, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nWf, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nWg, R.color.CAM_X0613);
        }
    }
}
