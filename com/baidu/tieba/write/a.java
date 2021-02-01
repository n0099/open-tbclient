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
    public View.OnClickListener jZH = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.obg != null) {
                if (a.this.obg.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eUY.getPageActivity(), a.this.obg.getBgColor());
                }
                a.this.obg.zw(true);
            }
        }
    };
    protected View mRootView = cFT();
    protected g obg;

    public abstract View cFT();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eUY = tbPageContext;
        this.obg = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dWl() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView fme;
        public View obJ;
        public TBLottieAnimationView obK;
        public View obS;
        public LinearLayout obT;
        public ImageView obU;
        public TextView obV;
        public LinearLayout obW;
        public ImageView obX;
        public TextView obY;
        public LinearLayout obZ;
        public ImageView oca;
        public TextView ocb;
        public LinearLayout occ;
        public ImageView ocd;
        public TextView oce;
        public LinearLayout ocf;
        ImageView ocg;
        public LinearLayout och;
        ImageView oci;
        TextView ocj;
        public LinearLayout ock;
        ImageView ocl;
        TextView ocm;
        public OvalActionButton ocn;
        public GridLayout oco;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.obW = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.obX = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.obY = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.obT = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.obU = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.obV = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.obZ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.oca = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.ocb = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.occ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.ocd = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.oce = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.ocf = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.ocg = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.fme = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.och = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.oci = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.ocj = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.ock = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.ocl = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.ocm = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.ocn = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.obg != null && "frs".equals(this.obg.getFrom())) {
                    this.ocn.setIsCircle(true);
                    this.ocn.setHasShadow(false);
                }
                this.obS = this.mRootView.findViewById(R.id.view_background_white);
                this.obJ = this.mRootView.findViewById(R.id.view_background_translate);
                this.oco = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.oco.setMeasureAllChild(true);
                this.oco.setVerNum(2);
                this.obK = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.obK.setSpeed(1.2f);
                dWl();
                this.obJ.setOnClickListener(this.jZH);
                this.obJ.setClickable(true);
                this.obX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obg != null) {
                            c.this.obg.UZ(c.this.obg.cKV());
                        }
                    }
                });
                this.obU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obg != null) {
                            c.this.obg.dWA();
                        }
                    }
                });
                this.oca.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obg != null) {
                            c.this.obg.dWz();
                        }
                    }
                });
                this.ocd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obg != null) {
                            c.this.obg.dWy();
                        }
                    }
                });
                this.ocf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obg != null) {
                            c.this.obg.UY(c.this.obg.cKV());
                        }
                    }
                });
                this.och.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obg != null) {
                            c.this.obg.dWB();
                        }
                    }
                });
                this.ock.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.obg != null) {
                            c.this.obg.dWx();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cFT() {
            return LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void zs(boolean z) {
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.ocn.onChangeSkinType(i);
            ap.a(this.obK, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.obS, R.drawable.write_tab_background);
            ap.setImageResource(this.obU, R.drawable.icon_mask_post_photograph56);
            ap.setImageResource(this.obX, R.drawable.icon_mask_post_text56);
            ap.setImageResource(this.oca, R.drawable.icon_mask_post_image56);
            ap.setImageResource(this.ocd, R.drawable.icon_mask_post_live56);
            ap.setImageResource(this.ocg, R.drawable.icon_mask_post_vote56);
            ap.setImageResource(this.oci, R.drawable.icon_mask_post_evaluation56);
            ap.setImageResource(this.ocl, R.drawable.icon_mask_post_goods56);
            ap.setViewTextColor(this.obV, R.color.CAM_X0107);
            ap.setViewTextColor(this.obY, R.color.CAM_X0107);
            ap.setViewTextColor(this.ocb, R.color.CAM_X0107);
            ap.setViewTextColor(this.oce, R.color.CAM_X0107);
            ap.setViewTextColor(this.fme, R.color.CAM_X0107);
            ap.setViewTextColor(this.ocj, R.color.CAM_X0107);
            ap.setViewTextColor(this.ocm, R.color.CAM_X0107);
        }

        @Override // com.baidu.tieba.write.a
        public void dWl() {
            int equipmentWidth = l.getEquipmentWidth(this.eUY.getPageActivity());
            int i = (int) (0.13518518f * equipmentWidth);
            b(this.obX, i);
            b(this.obU, i);
            b(this.oca, i);
            b(this.ocd, i);
            b(this.ocg, i);
            b(this.oci, i);
            b(this.ocl, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.oco.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds423) * dimens);
                this.oco.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.obS.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1023 : dimens2;
                this.obS.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.obK.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.obK.setLayoutParams(layoutParams3);
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
        public View obJ;
        public TBLottieAnimationView obK;
        public RelativeLayout obL;
        public View obM;
        public View obN;
        public View obO;
        public View obP;
        public View obQ;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.obJ = this.mRootView.findViewById(R.id.transparent_back_view);
            this.enH = this.mRootView.findViewById(R.id.view_background);
            this.obK = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.obL = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.eHA = this.mRootView.findViewById(R.id.closeView);
            this.obM = this.mRootView.findViewById(R.id.publish_text_view);
            this.obN = this.mRootView.findViewById(R.id.publish_image_view);
            this.obO = this.mRootView.findViewById(R.id.publish_video_view);
            this.obP = this.mRootView.findViewById(R.id.publish_ala_view);
            this.obQ = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.enH.setOnClickListener(this.jZH);
            this.obL.setOnClickListener(this.jZH);
            this.eHA.setOnClickListener(this.jZH);
            this.obM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.obg != null) {
                        b.this.obg.UZ(b.this.obg.cKV());
                    }
                }
            });
            this.obN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.obg != null) {
                        b.this.obg.dWz();
                    }
                }
            });
            this.obO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.obg != null) {
                        b.this.obg.dWA();
                    }
                }
            });
            this.obP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.obg != null) {
                        b.this.obg.dWy();
                    }
                }
            });
            zq(false);
            this.obK.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cFT() {
            return LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.obK, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.enH, R.color.CAM_X0502);
            ap.setBackgroundResource(this.obQ, R.drawable.home_publish_ala_red_tip);
        }

        public void zq(boolean z) {
            this.enH.setClickable(z);
            this.obL.setClickable(z);
            this.eHA.setClickable(z);
            this.obM.setClickable(z);
            this.obN.setClickable(z);
            this.obO.setClickable(z);
            this.obP.setClickable(z);
        }

        public void zr(boolean z) {
            if (this.obQ != null) {
                if (z) {
                    this.obQ.setVisibility(0);
                } else {
                    this.obQ.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0896a extends a {
        public View enH;
        private TextView obA;
        private TextView obB;
        private View obC;
        private View obD;
        private View obE;
        private View obF;
        private View obG;
        private int obH;
        public LinearLayout obi;
        private LinearLayout obk;
        private LinearLayout obl;
        private LinearLayout obm;
        private LinearLayout obn;
        private LinearLayout obo;
        private LinearLayout obp;
        private ImageView obq;
        private ImageView obr;
        private ImageView obs;
        private ImageView obt;
        private ImageView obu;
        private ImageView obv;
        private TextView obw;
        private TextView obx;
        private TextView oby;
        private TextView obz;

        public C0896a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.enH = this.mRootView.findViewById(R.id.view_background);
            this.obi = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.obk = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.obq = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.obw = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.obl = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.obr = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.obx = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.obm = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.obs = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.oby = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.obn = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.obt = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.obz = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.obo = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.obu = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.obA = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.obp = (LinearLayout) this.mRootView.findViewById(R.id.thread_write_score);
            this.obv = (ImageView) this.mRootView.findViewById(R.id.thread_write_score_iv);
            this.obB = (TextView) this.mRootView.findViewById(R.id.thread_write_score_tv);
            this.obC = this.mRootView.findViewById(R.id.line_1);
            this.obD = this.mRootView.findViewById(R.id.line_2);
            this.obE = this.mRootView.findViewById(R.id.line_3);
            this.obF = this.mRootView.findViewById(R.id.line_4);
            this.obG = this.mRootView.findViewById(R.id.line_5);
            this.obw.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.obx.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.oby.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.obz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.obA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.obB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.enH.setOnClickListener(this.jZH);
            this.obk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0896a.this.obg != null) {
                        C0896a.this.obg.UZ(C0896a.this.obg.cKV());
                    }
                }
            });
            this.obl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0896a.this.obg != null) {
                        C0896a.this.obg.dWz();
                    }
                }
            });
            this.obm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0896a.this.obg != null) {
                        C0896a.this.obg.dWA();
                    }
                }
            });
            this.obn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0896a.this.obg != null) {
                        C0896a.this.obg.dWy();
                    }
                }
            });
            this.obo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0896a.this.obg != null) {
                        C0896a.this.obg.UY(C0896a.this.obg.cKV());
                    }
                }
            });
            this.obp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0896a.this.obg != null) {
                        C0896a.this.obg.dWB();
                    }
                }
            });
            this.obH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cFT() {
            return LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.enH, R.color.CAM_X0603);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).af(this.obH).oP(R.color.CAM_X0701).bv(this.obi);
            this.obq.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.obr.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.obs.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.obt.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.obu.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            this.obv.setImageDrawable(WebPManager.a(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.obw, R.color.CAM_X0101);
            ap.setViewTextColor(this.obx, R.color.CAM_X0101);
            ap.setViewTextColor(this.oby, R.color.CAM_X0101);
            ap.setViewTextColor(this.obz, R.color.CAM_X0101);
            ap.setViewTextColor(this.obA, R.color.CAM_X0101);
            ap.setViewTextColor(this.obB, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).ah(this.obH).ag(this.obH).bv(this.obk);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).bv(this.obl);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).bv(this.obm);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).bv(this.obn);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).aj(this.obH).ai(this.obH).bv(this.obo);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).aj(this.obH).ai(this.obH).bv(this.obp);
            ap.setBackgroundColor(this.obC, R.color.CAM_X0613);
            ap.setBackgroundColor(this.obD, R.color.CAM_X0613);
            ap.setBackgroundColor(this.obE, R.color.CAM_X0613);
            ap.setBackgroundColor(this.obF, R.color.CAM_X0613);
            ap.setBackgroundColor(this.obG, R.color.CAM_X0613);
        }
    }
}
