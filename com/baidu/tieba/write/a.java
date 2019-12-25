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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext cQU;
    protected f kGG;
    public View.OnClickListener kGH = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kGG != null) {
                if (a.this.kGG.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.cQU.getPageActivity(), a.this.kGG.getBgColor());
                }
                a.this.kGG.ts(true);
            }
        }
    };
    protected View mRootView = bEc();

    public abstract View bEc();

    public a(TbPageContext tbPageContext, f fVar) {
        this.cQU = tbPageContext;
        this.kGG = fVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void cRF() {
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public View kGJ;
        public TBLottieAnimationView kGK;
        public View kGQ;
        public ImageView kGR;
        public TextView kGS;
        public LinearLayout kGT;
        public ImageView kGU;
        public TextView kGV;
        public LinearLayout kGW;
        public ImageView kGX;
        public TextView kGY;
        public LinearLayout kGZ;
        public ImageView kHa;
        public TextView kHb;
        public OvalActionButton kHc;
        public GridLayout kHd;
        public LinearLayout mPhotoView;

        public b(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            if (tbPageContext != null) {
                this.kGT = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.kGU = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.kGV = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mPhotoView = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.kGR = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.kGS = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.kGW = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.kGX = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.kGY = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.kGZ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.kHa = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.kHb = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.kHc = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.kGG != null && "frs".equals(this.kGG.getFrom())) {
                    this.kHc.setIsCircle(true);
                }
                this.kGQ = this.mRootView.findViewById(R.id.view_background_white);
                this.kGJ = this.mRootView.findViewById(R.id.view_background_translate);
                this.kHd = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.kHd.setMeasureAllChild(true);
                this.kHd.setVerNum(1);
                this.kGK = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.kGK.setSpeed(1.2f);
                cRF();
                this.kGJ.setOnClickListener(this.kGH);
                this.kGJ.setClickable(true);
                this.kGU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kGG != null) {
                            b.this.kGG.Kq(b.this.kGG.bHN());
                        }
                    }
                });
                this.kGR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kGG != null) {
                            b.this.kGG.cRU();
                        }
                    }
                });
                this.kGX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kGG != null) {
                            b.this.kGG.cRT();
                        }
                    }
                });
                this.kHa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kGG != null) {
                            b.this.kGG.cRS();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View bEc() {
            return LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.kHc.onChangeSkinType(i);
            am.a(this.kGK, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.kGQ, R.drawable.write_tab_background);
            this.kGR.setImageDrawable(SvgManager.aDW().h(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.kGU.setImageDrawable(SvgManager.aDW().h(R.drawable.icon_post_text_n_svg, 1, true));
            this.kGX.setImageDrawable(SvgManager.aDW().h(R.drawable.icon_post_image_n_svg, 1, true));
            this.kHa.setImageDrawable(SvgManager.aDW().h(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.kGS, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kGV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kGY, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kHb, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void cRF() {
            int equipmentWidth = l.getEquipmentWidth(this.cQU.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            b(this.kGU, i);
            b(this.kGR, i);
            b(this.kGX, i);
            b(this.kHa, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.kHd.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.kHd.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.kGQ.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.kGQ.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.kGK.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.kGK.setLayoutParams(layoutParams3);
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
    public static class C0617a extends a {
        public View cqj;
        public View kGJ;
        public TBLottieAnimationView kGK;
        public RelativeLayout kGL;
        public View kGM;
        public View kGN;
        public View kGO;
        public View mCloseView;

        public C0617a(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            this.kGJ = this.mRootView.findViewById(R.id.transparent_back_view);
            this.cqj = this.mRootView.findViewById(R.id.view_background);
            this.kGK = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.kGL = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.mCloseView = this.mRootView.findViewById(R.id.closeView);
            this.kGM = this.mRootView.findViewById(R.id.publish_text_view);
            this.kGN = this.mRootView.findViewById(R.id.publish_image_view);
            this.kGO = this.mRootView.findViewById(R.id.publish_video_view);
            this.cqj.setOnClickListener(this.kGH);
            this.kGL.setOnClickListener(this.kGH);
            this.mCloseView.setOnClickListener(this.kGH);
            this.kGM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0617a.this.kGG != null) {
                        C0617a.this.kGG.Kq(C0617a.this.kGG.bHN());
                    }
                }
            });
            this.kGN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0617a.this.kGG != null) {
                        C0617a.this.kGG.cRT();
                    }
                }
            });
            this.kGO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0617a.this.kGG != null) {
                        C0617a.this.kGG.cRU();
                    }
                }
            });
            tp(false);
            this.kGK.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bEc() {
            return LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            am.a(this.kGK, R.raw.lottie_use_publish_n);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                am.setBackgroundResource(this.cqj, R.color.cp_mask_b_alpha83);
            } else {
                am.setBackgroundResource(this.cqj, R.color.cp_mask_c_alpha83);
            }
        }

        public void tp(boolean z) {
            this.cqj.setClickable(z);
            this.kGL.setClickable(z);
            this.mCloseView.setClickable(z);
            this.kGM.setClickable(z);
            this.kGN.setClickable(z);
            this.kGO.setClickable(z);
        }
    }
}
