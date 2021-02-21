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
    protected TbPageContext eUY;
    public View.OnClickListener jZV = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.obH != null) {
                if (a.this.obH.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eUY.getPageActivity(), a.this.obH.getBgColor());
                }
                a.this.obH.zw(true);
            }
        }
    };
    protected View mRootView = cGa();
    protected g obH;

    public abstract View cGa();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eUY = tbPageContext;
        this.obH = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dWt() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView fme;
        public LinearLayout ocA;
        public ImageView ocB;
        public TextView ocC;
        public LinearLayout ocD;
        public ImageView ocE;
        public TextView ocF;
        public LinearLayout ocG;
        ImageView ocH;
        public LinearLayout ocI;
        ImageView ocJ;
        TextView ocK;
        public LinearLayout ocL;
        ImageView ocM;
        TextView ocN;
        public OvalActionButton ocO;
        public GridLayout ocP;
        public View ocj;
        public TBLottieAnimationView ock;
        public View oct;
        public LinearLayout ocu;
        public ImageView ocv;
        public TextView ocw;
        public LinearLayout ocx;
        public ImageView ocy;
        public TextView ocz;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.ocx = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.ocy = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.ocz = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.ocu = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.ocv = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.ocw = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.ocA = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.ocB = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.ocC = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.ocD = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.ocE = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.ocF = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.ocG = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.ocH = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.fme = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.ocI = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.ocJ = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.ocK = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.ocL = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.ocM = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.ocN = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.ocO = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.obH != null && "frs".equals(this.obH.getFrom())) {
                    this.ocO.setIsCircle(true);
                    this.ocO.setHasShadow(false);
                }
                this.oct = this.mRootView.findViewById(R.id.view_background_white);
                this.ocj = this.mRootView.findViewById(R.id.view_background_translate);
                this.ocP = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.ocP.setMeasureAllChild(true);
                this.ocP.setVerNum(2);
                this.ock = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.ock.setSpeed(1.2f);
                dWt();
                this.ocj.setOnClickListener(this.jZV);
                this.ocj.setClickable(true);
                this.ocy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obH != null) {
                            c.this.obH.Vl(c.this.obH.cLc());
                        }
                    }
                });
                this.ocv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obH != null) {
                            c.this.obH.dWI();
                        }
                    }
                });
                this.ocB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obH != null) {
                            c.this.obH.dWH();
                        }
                    }
                });
                this.ocE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obH != null) {
                            c.this.obH.dWG();
                        }
                    }
                });
                this.ocG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obH != null) {
                            c.this.obH.Vk(c.this.obH.cLc());
                        }
                    }
                });
                this.ocI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obH != null) {
                            c.this.obH.dWJ();
                        }
                    }
                });
                this.ocL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obH != null) {
                            c.this.obH.dWF();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cGa() {
            return LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void zs(boolean z) {
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.ocO.onChangeSkinType(i);
            ap.a(this.ock, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.oct, R.drawable.write_tab_background);
            ap.setImageResource(this.ocv, R.drawable.icon_mask_post_photograph56);
            ap.setImageResource(this.ocy, R.drawable.icon_mask_post_text56);
            ap.setImageResource(this.ocB, R.drawable.icon_mask_post_image56);
            ap.setImageResource(this.ocE, R.drawable.icon_mask_post_live56);
            ap.setImageResource(this.ocH, R.drawable.icon_mask_post_vote56);
            ap.setImageResource(this.ocJ, R.drawable.icon_mask_post_evaluation56);
            ap.setImageResource(this.ocM, R.drawable.icon_mask_post_goods56);
            ap.setViewTextColor(this.ocw, R.color.CAM_X0107);
            ap.setViewTextColor(this.ocz, R.color.CAM_X0107);
            ap.setViewTextColor(this.ocC, R.color.CAM_X0107);
            ap.setViewTextColor(this.ocF, R.color.CAM_X0107);
            ap.setViewTextColor(this.fme, R.color.CAM_X0107);
            ap.setViewTextColor(this.ocK, R.color.CAM_X0107);
            ap.setViewTextColor(this.ocN, R.color.CAM_X0107);
        }

        @Override // com.baidu.tieba.write.a
        public void dWt() {
            int equipmentWidth = l.getEquipmentWidth(this.eUY.getPageActivity());
            int i = (int) (0.13518518f * equipmentWidth);
            b(this.ocy, i);
            b(this.ocv, i);
            b(this.ocB, i);
            b(this.ocE, i);
            b(this.ocH, i);
            b(this.ocJ, i);
            b(this.ocM, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.ocP.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds423) * dimens);
                this.ocP.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.oct.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1023 : dimens2;
                this.oct.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.ock.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.ock.setLayoutParams(layoutParams3);
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
        public View eHA;
        public View enH;
        public View ocj;
        public TBLottieAnimationView ock;
        public RelativeLayout ocl;
        public View ocm;
        public View ocn;
        public View oco;
        public View ocp;
        public View ocq;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.ocj = this.mRootView.findViewById(R.id.transparent_back_view);
            this.enH = this.mRootView.findViewById(R.id.view_background);
            this.ock = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.ocl = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.eHA = this.mRootView.findViewById(R.id.closeView);
            this.ocm = this.mRootView.findViewById(R.id.publish_text_view);
            this.ocn = this.mRootView.findViewById(R.id.publish_image_view);
            this.oco = this.mRootView.findViewById(R.id.publish_video_view);
            this.ocp = this.mRootView.findViewById(R.id.publish_ala_view);
            this.ocq = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.enH.setOnClickListener(this.jZV);
            this.ocl.setOnClickListener(this.jZV);
            this.eHA.setOnClickListener(this.jZV);
            this.ocm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.obH != null) {
                        b.this.obH.Vl(b.this.obH.cLc());
                    }
                }
            });
            this.ocn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.obH != null) {
                        b.this.obH.dWH();
                    }
                }
            });
            this.oco.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.obH != null) {
                        b.this.obH.dWI();
                    }
                }
            });
            this.ocp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.obH != null) {
                        b.this.obH.dWG();
                    }
                }
            });
            zq(false);
            this.ock.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cGa() {
            return LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.ock, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.enH, R.color.CAM_X0502);
            ap.setBackgroundResource(this.ocq, R.drawable.home_publish_ala_red_tip);
        }

        public void zq(boolean z) {
            this.enH.setClickable(z);
            this.ocl.setClickable(z);
            this.eHA.setClickable(z);
            this.ocm.setClickable(z);
            this.ocn.setClickable(z);
            this.oco.setClickable(z);
            this.ocp.setClickable(z);
        }

        public void zr(boolean z) {
            if (this.ocq != null) {
                if (z) {
                    this.ocq.setVisibility(0);
                } else {
                    this.ocq.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0898a extends a {
        public View enH;
        public LinearLayout obJ;
        private LinearLayout obK;
        private LinearLayout obL;
        private LinearLayout obM;
        private LinearLayout obN;
        private LinearLayout obO;
        private LinearLayout obP;
        private ImageView obQ;
        private ImageView obR;
        private ImageView obS;
        private ImageView obT;
        private ImageView obU;
        private ImageView obV;
        private TextView obW;
        private TextView obX;
        private TextView obY;
        private TextView obZ;
        private TextView oca;
        private TextView ocb;
        private View occ;
        private View ocd;
        private View oce;
        private View ocf;
        private View ocg;
        private int och;

        public C0898a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.enH = this.mRootView.findViewById(R.id.view_background);
            this.obJ = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.obK = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.obQ = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.obW = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.obL = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.obR = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.obX = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.obM = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.obS = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.obY = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.obN = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.obT = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.obZ = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.obO = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.obU = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.oca = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.obP = (LinearLayout) this.mRootView.findViewById(R.id.thread_write_score);
            this.obV = (ImageView) this.mRootView.findViewById(R.id.thread_write_score_iv);
            this.ocb = (TextView) this.mRootView.findViewById(R.id.thread_write_score_tv);
            this.occ = this.mRootView.findViewById(R.id.line_1);
            this.ocd = this.mRootView.findViewById(R.id.line_2);
            this.oce = this.mRootView.findViewById(R.id.line_3);
            this.ocf = this.mRootView.findViewById(R.id.line_4);
            this.ocg = this.mRootView.findViewById(R.id.line_5);
            this.obW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.obX.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.obY.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.obZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.oca.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.ocb.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.enH.setOnClickListener(this.jZV);
            this.obK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0898a.this.obH != null) {
                        C0898a.this.obH.Vl(C0898a.this.obH.cLc());
                    }
                }
            });
            this.obL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0898a.this.obH != null) {
                        C0898a.this.obH.dWH();
                    }
                }
            });
            this.obM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0898a.this.obH != null) {
                        C0898a.this.obH.dWI();
                    }
                }
            });
            this.obN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0898a.this.obH != null) {
                        C0898a.this.obH.dWG();
                    }
                }
            });
            this.obO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0898a.this.obH != null) {
                        C0898a.this.obH.Vk(C0898a.this.obH.cLc());
                    }
                }
            });
            this.obP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0898a.this.obH != null) {
                        C0898a.this.obH.dWJ();
                    }
                }
            });
            this.och = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cGa() {
            return LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.enH, R.color.CAM_X0603);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).af(this.och).oP(R.color.CAM_X0701).bv(this.obJ);
            this.obQ.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.obR.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.obS.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.obT.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.obU.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            this.obV.setImageDrawable(WebPManager.a(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.obW, R.color.CAM_X0101);
            ap.setViewTextColor(this.obX, R.color.CAM_X0101);
            ap.setViewTextColor(this.obY, R.color.CAM_X0101);
            ap.setViewTextColor(this.obZ, R.color.CAM_X0101);
            ap.setViewTextColor(this.oca, R.color.CAM_X0101);
            ap.setViewTextColor(this.ocb, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).ah(this.och).ag(this.och).bv(this.obK);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).bv(this.obL);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).bv(this.obM);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).bv(this.obN);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).aj(this.och).ai(this.och).bv(this.obO);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).aj(this.och).ai(this.och).bv(this.obP);
            ap.setBackgroundColor(this.occ, R.color.CAM_X0613);
            ap.setBackgroundColor(this.ocd, R.color.CAM_X0613);
            ap.setBackgroundColor(this.oce, R.color.CAM_X0613);
            ap.setBackgroundColor(this.ocf, R.color.CAM_X0613);
            ap.setBackgroundColor(this.ocg, R.color.CAM_X0613);
        }
    }
}
