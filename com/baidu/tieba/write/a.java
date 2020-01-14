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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext cRe;
    protected f kKm;
    public View.OnClickListener kKn = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kKm != null) {
                if (a.this.kKm.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.cRe.getPageActivity(), a.this.kKm.getBgColor());
                }
                a.this.kKm.tE(true);
            }
        }
    };
    protected View mRootView = bFe();

    public abstract View bFe();

    public a(TbPageContext tbPageContext, f fVar) {
        this.cRe = tbPageContext;
        this.kKm = fVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void cSK() {
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public ImageView kKA;
        public TextView kKB;
        public LinearLayout kKC;
        public ImageView kKD;
        public TextView kKE;
        public LinearLayout kKF;
        public ImageView kKG;
        public TextView kKH;
        public OvalActionButton kKI;
        public GridLayout kKJ;
        public View kKp;
        public TBLottieAnimationView kKq;
        public View kKw;
        public ImageView kKx;
        public TextView kKy;
        public LinearLayout kKz;
        public LinearLayout mPhotoView;

        public b(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            if (tbPageContext != null) {
                this.kKz = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.kKA = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.kKB = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mPhotoView = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.kKx = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.kKy = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.kKC = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.kKD = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.kKE = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.kKF = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.kKG = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.kKH = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.kKI = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.kKm != null && "frs".equals(this.kKm.getFrom())) {
                    this.kKI.setIsCircle(true);
                }
                this.kKw = this.mRootView.findViewById(R.id.view_background_white);
                this.kKp = this.mRootView.findViewById(R.id.view_background_translate);
                this.kKJ = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.kKJ.setMeasureAllChild(true);
                this.kKJ.setVerNum(1);
                this.kKq = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.kKq.setSpeed(1.2f);
                cSK();
                this.kKp.setOnClickListener(this.kKn);
                this.kKp.setClickable(true);
                this.kKA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKm != null) {
                            b.this.kKm.KA(b.this.kKm.bIP());
                        }
                    }
                });
                this.kKx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKm != null) {
                            b.this.kKm.cSZ();
                        }
                    }
                });
                this.kKD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKm != null) {
                            b.this.kKm.cSY();
                        }
                    }
                });
                this.kKG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKm != null) {
                            b.this.kKm.cSX();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View bFe() {
            return LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.kKI.onChangeSkinType(i);
            am.a(this.kKq, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.kKw, R.drawable.write_tab_background);
            this.kKx.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.kKA.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_post_text_n_svg, 1, true));
            this.kKD.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_post_image_n_svg, 1, true));
            this.kKG.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.kKy, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kKB, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kKE, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kKH, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void cSK() {
            int equipmentWidth = l.getEquipmentWidth(this.cRe.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            b(this.kKA, i);
            b(this.kKx, i);
            b(this.kKD, i);
            b(this.kKG, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.kKJ.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.kKJ.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.kKw.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.kKw.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.kKq.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.kKq.setLayoutParams(layoutParams3);
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

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0622a extends a {
        public View cqv;
        public View kKp;
        public TBLottieAnimationView kKq;
        public RelativeLayout kKr;
        public View kKs;
        public View kKt;
        public View kKu;
        public View mCloseView;

        public C0622a(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            this.kKp = this.mRootView.findViewById(R.id.transparent_back_view);
            this.cqv = this.mRootView.findViewById(R.id.view_background);
            this.kKq = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.kKr = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.mCloseView = this.mRootView.findViewById(R.id.closeView);
            this.kKs = this.mRootView.findViewById(R.id.publish_text_view);
            this.kKt = this.mRootView.findViewById(R.id.publish_image_view);
            this.kKu = this.mRootView.findViewById(R.id.publish_video_view);
            this.cqv.setOnClickListener(this.kKn);
            this.kKr.setOnClickListener(this.kKn);
            this.mCloseView.setOnClickListener(this.kKn);
            this.kKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0622a.this.kKm != null) {
                        C0622a.this.kKm.KA(C0622a.this.kKm.bIP());
                    }
                }
            });
            this.kKt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0622a.this.kKm != null) {
                        C0622a.this.kKm.cSY();
                    }
                }
            });
            this.kKu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0622a.this.kKm != null) {
                        C0622a.this.kKm.cSZ();
                    }
                }
            });
            tB(false);
            this.kKq.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bFe() {
            return LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            if (TbSingleton.getInstance().isShowNewYearSkin()) {
                am.a(this.kKq, R.raw.lottie_use_publish_cj_n);
            } else {
                am.a(this.kKq, R.raw.lottie_use_publish_n);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                am.setBackgroundResource(this.cqv, R.color.cp_mask_b_alpha83);
            } else {
                am.setBackgroundResource(this.cqv, R.color.cp_mask_c_alpha83);
            }
        }

        public void tB(boolean z) {
            this.cqv.setClickable(z);
            this.kKr.setClickable(z);
            this.mCloseView.setClickable(z);
            this.kKs.setClickable(z);
            this.kKt.setClickable(z);
            this.kKu.setClickable(z);
        }
    }
}
