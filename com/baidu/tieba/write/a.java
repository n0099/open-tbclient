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
    protected TbPageContext cVg;
    protected f kKS;
    public View.OnClickListener kKT = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kKS != null) {
                if (a.this.kKS.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.cVg.getPageActivity(), a.this.kKS.getBgColor());
                }
                a.this.kKS.tI(true);
            }
        }
    };
    protected View mRootView = bGG();

    public abstract View bGG();

    public a(TbPageContext tbPageContext, f fVar) {
        this.cVg = tbPageContext;
        this.kKS = fVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void cTY() {
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public View kKV;
        public TBLottieAnimationView kKW;
        public View kLc;
        public ImageView kLd;
        public TextView kLe;
        public LinearLayout kLf;
        public ImageView kLg;
        public TextView kLh;
        public LinearLayout kLi;
        public ImageView kLj;
        public TextView kLk;
        public LinearLayout kLl;
        public ImageView kLm;
        public TextView kLn;
        public OvalActionButton kLo;
        public GridLayout kLp;
        public LinearLayout mPhotoView;

        public b(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            if (tbPageContext != null) {
                this.kLf = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.kLg = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.kLh = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mPhotoView = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.kLd = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.kLe = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.kLi = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.kLj = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.kLk = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.kLl = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.kLm = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.kLn = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.kLo = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.kKS != null && "frs".equals(this.kKS.getFrom())) {
                    this.kLo.setIsCircle(true);
                }
                this.kLc = this.mRootView.findViewById(R.id.view_background_white);
                this.kKV = this.mRootView.findViewById(R.id.view_background_translate);
                this.kLp = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.kLp.setMeasureAllChild(true);
                this.kLp.setVerNum(1);
                this.kKW = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.kKW.setSpeed(1.2f);
                cTY();
                this.kKV.setOnClickListener(this.kKT);
                this.kKV.setClickable(true);
                this.kLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKS != null) {
                            b.this.kKS.KN(b.this.kKS.bKr());
                        }
                    }
                });
                this.kLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKS != null) {
                            b.this.kKS.cUn();
                        }
                    }
                });
                this.kLj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKS != null) {
                            b.this.kKS.cUm();
                        }
                    }
                });
                this.kLm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKS != null) {
                            b.this.kKS.cUl();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View bGG() {
            return LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.kLo.onChangeSkinType(i);
            am.a(this.kKW, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.kLc, R.drawable.write_tab_background);
            this.kLd.setImageDrawable(SvgManager.aGA().i(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.kLg.setImageDrawable(SvgManager.aGA().i(R.drawable.icon_post_text_n_svg, 1, true));
            this.kLj.setImageDrawable(SvgManager.aGA().i(R.drawable.icon_post_image_n_svg, 1, true));
            this.kLm.setImageDrawable(SvgManager.aGA().i(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.kLe, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kLh, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kLk, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kLn, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void cTY() {
            int equipmentWidth = l.getEquipmentWidth(this.cVg.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            b(this.kLg, i);
            b(this.kLd, i);
            b(this.kLj, i);
            b(this.kLm, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.kLp.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.kLp.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.kLc.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.kLc.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.kKW.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.kKW.setLayoutParams(layoutParams3);
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
    public static class C0630a extends a {
        public View cuy;
        public View kKV;
        public TBLottieAnimationView kKW;
        public RelativeLayout kKX;
        public View kKY;
        public View kKZ;
        public View kLa;
        public View mCloseView;

        public C0630a(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            this.kKV = this.mRootView.findViewById(R.id.transparent_back_view);
            this.cuy = this.mRootView.findViewById(R.id.view_background);
            this.kKW = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.kKX = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.mCloseView = this.mRootView.findViewById(R.id.closeView);
            this.kKY = this.mRootView.findViewById(R.id.publish_text_view);
            this.kKZ = this.mRootView.findViewById(R.id.publish_image_view);
            this.kLa = this.mRootView.findViewById(R.id.publish_video_view);
            this.cuy.setOnClickListener(this.kKT);
            this.kKX.setOnClickListener(this.kKT);
            this.mCloseView.setOnClickListener(this.kKT);
            this.kKY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0630a.this.kKS != null) {
                        C0630a.this.kKS.KN(C0630a.this.kKS.bKr());
                    }
                }
            });
            this.kKZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0630a.this.kKS != null) {
                        C0630a.this.kKS.cUm();
                    }
                }
            });
            this.kLa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0630a.this.kKS != null) {
                        C0630a.this.kKS.cUn();
                    }
                }
            });
            tF(false);
            this.kKW.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bGG() {
            return LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            am.a(this.kKW, R.raw.lottie_use_publish_n);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                am.setBackgroundResource(this.cuy, R.color.cp_mask_b_alpha83);
            } else {
                am.setBackgroundResource(this.cuy, R.color.cp_mask_c_alpha83);
            }
        }

        public void tF(boolean z) {
            this.cuy.setClickable(z);
            this.kKX.setClickable(z);
            this.mCloseView.setClickable(z);
            this.kKY.setClickable(z);
            this.kKZ.setClickable(z);
            this.kLa.setClickable(z);
        }
    }
}
