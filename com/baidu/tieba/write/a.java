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
    protected f kKh;
    public View.OnClickListener kKi = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kKh != null) {
                if (a.this.kKh.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.cRe.getPageActivity(), a.this.kKh.getBgColor());
                }
                a.this.kKh.tE(true);
            }
        }
    };
    protected View mRootView = bFe();

    public abstract View bFe();

    public a(TbPageContext tbPageContext, f fVar) {
        this.cRe = tbPageContext;
        this.kKh = fVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void cSI() {
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public LinearLayout kKA;
        public ImageView kKB;
        public TextView kKC;
        public OvalActionButton kKD;
        public GridLayout kKE;
        public View kKk;
        public TBLottieAnimationView kKl;
        public View kKr;
        public ImageView kKs;
        public TextView kKt;
        public LinearLayout kKu;
        public ImageView kKv;
        public TextView kKw;
        public LinearLayout kKx;
        public ImageView kKy;
        public TextView kKz;
        public LinearLayout mPhotoView;

        public b(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            if (tbPageContext != null) {
                this.kKu = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.kKv = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.kKw = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mPhotoView = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.kKs = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.kKt = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.kKx = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.kKy = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.kKz = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.kKA = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.kKB = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.kKC = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.kKD = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.kKh != null && "frs".equals(this.kKh.getFrom())) {
                    this.kKD.setIsCircle(true);
                }
                this.kKr = this.mRootView.findViewById(R.id.view_background_white);
                this.kKk = this.mRootView.findViewById(R.id.view_background_translate);
                this.kKE = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.kKE.setMeasureAllChild(true);
                this.kKE.setVerNum(1);
                this.kKl = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.kKl.setSpeed(1.2f);
                cSI();
                this.kKk.setOnClickListener(this.kKi);
                this.kKk.setClickable(true);
                this.kKv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKh != null) {
                            b.this.kKh.KA(b.this.kKh.bIP());
                        }
                    }
                });
                this.kKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKh != null) {
                            b.this.kKh.cSX();
                        }
                    }
                });
                this.kKy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKh != null) {
                            b.this.kKh.cSW();
                        }
                    }
                });
                this.kKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKh != null) {
                            b.this.kKh.cSV();
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
            this.kKD.onChangeSkinType(i);
            am.a(this.kKl, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.kKr, R.drawable.write_tab_background);
            this.kKs.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.kKv.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_post_text_n_svg, 1, true));
            this.kKy.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_post_image_n_svg, 1, true));
            this.kKB.setImageDrawable(SvgManager.aEp().h(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.kKt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kKw, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kKz, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kKC, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void cSI() {
            int equipmentWidth = l.getEquipmentWidth(this.cRe.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            b(this.kKv, i);
            b(this.kKs, i);
            b(this.kKy, i);
            b(this.kKB, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.kKE.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.kKE.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.kKr.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.kKr.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.kKl.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.kKl.setLayoutParams(layoutParams3);
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
        public View kKk;
        public TBLottieAnimationView kKl;
        public RelativeLayout kKm;
        public View kKn;
        public View kKo;
        public View kKp;
        public View mCloseView;

        public C0622a(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            this.kKk = this.mRootView.findViewById(R.id.transparent_back_view);
            this.cqv = this.mRootView.findViewById(R.id.view_background);
            this.kKl = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.kKm = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.mCloseView = this.mRootView.findViewById(R.id.closeView);
            this.kKn = this.mRootView.findViewById(R.id.publish_text_view);
            this.kKo = this.mRootView.findViewById(R.id.publish_image_view);
            this.kKp = this.mRootView.findViewById(R.id.publish_video_view);
            this.cqv.setOnClickListener(this.kKi);
            this.kKm.setOnClickListener(this.kKi);
            this.mCloseView.setOnClickListener(this.kKi);
            this.kKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0622a.this.kKh != null) {
                        C0622a.this.kKh.KA(C0622a.this.kKh.bIP());
                    }
                }
            });
            this.kKo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0622a.this.kKh != null) {
                        C0622a.this.kKh.cSW();
                    }
                }
            });
            this.kKp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0622a.this.kKh != null) {
                        C0622a.this.kKh.cSX();
                    }
                }
            });
            tB(false);
            this.kKl.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bFe() {
            return LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            if (TbSingleton.getInstance().isShowNewYearSkin()) {
                am.a(this.kKl, R.raw.lottie_use_publish_cj_n);
            } else {
                am.a(this.kKl, R.raw.lottie_use_publish_n);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                am.setBackgroundResource(this.cqv, R.color.cp_mask_b_alpha83);
            } else {
                am.setBackgroundResource(this.cqv, R.color.cp_mask_c_alpha83);
            }
        }

        public void tB(boolean z) {
            this.cqv.setClickable(z);
            this.kKm.setClickable(z);
            this.mCloseView.setClickable(z);
            this.kKn.setClickable(z);
            this.kKo.setClickable(z);
            this.kKp.setClickable(z);
        }
    }
}
