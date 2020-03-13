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
    protected TbPageContext cVi;
    protected f kLg;
    public View.OnClickListener kLh = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kLg != null) {
                if (a.this.kLg.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.cVi.getPageActivity(), a.this.kLg.getBgColor());
                }
                a.this.kLg.tI(true);
            }
        }
    };
    protected View mRootView = bGJ();

    public abstract View bGJ();

    public a(TbPageContext tbPageContext, f fVar) {
        this.cVi = tbPageContext;
        this.kLg = fVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void cUb() {
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public ImageView kLA;
        public TextView kLB;
        public OvalActionButton kLC;
        public GridLayout kLD;
        public View kLj;
        public TBLottieAnimationView kLk;
        public View kLq;
        public ImageView kLr;
        public TextView kLs;
        public LinearLayout kLt;
        public ImageView kLu;
        public TextView kLv;
        public LinearLayout kLw;
        public ImageView kLx;
        public TextView kLy;
        public LinearLayout kLz;
        public LinearLayout mPhotoView;

        public b(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            if (tbPageContext != null) {
                this.kLt = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.kLu = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.kLv = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mPhotoView = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.kLr = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.kLs = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.kLw = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.kLx = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.kLy = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.kLz = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.kLA = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.kLB = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.kLC = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.kLg != null && "frs".equals(this.kLg.getFrom())) {
                    this.kLC.setIsCircle(true);
                }
                this.kLq = this.mRootView.findViewById(R.id.view_background_white);
                this.kLj = this.mRootView.findViewById(R.id.view_background_translate);
                this.kLD = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.kLD.setMeasureAllChild(true);
                this.kLD.setVerNum(1);
                this.kLk = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.kLk.setSpeed(1.2f);
                cUb();
                this.kLj.setOnClickListener(this.kLh);
                this.kLj.setClickable(true);
                this.kLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kLg != null) {
                            b.this.kLg.KO(b.this.kLg.bKu());
                        }
                    }
                });
                this.kLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kLg != null) {
                            b.this.kLg.cUq();
                        }
                    }
                });
                this.kLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kLg != null) {
                            b.this.kLg.cUp();
                        }
                    }
                });
                this.kLA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kLg != null) {
                            b.this.kLg.cUo();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View bGJ() {
            return LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.kLC.onChangeSkinType(i);
            am.a(this.kLk, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.kLq, R.drawable.write_tab_background);
            this.kLr.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.kLu.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_post_text_n_svg, 1, true));
            this.kLx.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_post_image_n_svg, 1, true));
            this.kLA.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.kLs, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kLv, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kLy, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kLB, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void cUb() {
            int equipmentWidth = l.getEquipmentWidth(this.cVi.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            b(this.kLu, i);
            b(this.kLr, i);
            b(this.kLx, i);
            b(this.kLA, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.kLD.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.kLD.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.kLq.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.kLq.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.kLk.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.kLk.setLayoutParams(layoutParams3);
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
        public View cuA;
        public View kLj;
        public TBLottieAnimationView kLk;
        public RelativeLayout kLl;
        public View kLm;
        public View kLn;
        public View kLo;
        public View mCloseView;

        public C0630a(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            this.kLj = this.mRootView.findViewById(R.id.transparent_back_view);
            this.cuA = this.mRootView.findViewById(R.id.view_background);
            this.kLk = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.kLl = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.mCloseView = this.mRootView.findViewById(R.id.closeView);
            this.kLm = this.mRootView.findViewById(R.id.publish_text_view);
            this.kLn = this.mRootView.findViewById(R.id.publish_image_view);
            this.kLo = this.mRootView.findViewById(R.id.publish_video_view);
            this.cuA.setOnClickListener(this.kLh);
            this.kLl.setOnClickListener(this.kLh);
            this.mCloseView.setOnClickListener(this.kLh);
            this.kLm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0630a.this.kLg != null) {
                        C0630a.this.kLg.KO(C0630a.this.kLg.bKu());
                    }
                }
            });
            this.kLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0630a.this.kLg != null) {
                        C0630a.this.kLg.cUp();
                    }
                }
            });
            this.kLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0630a.this.kLg != null) {
                        C0630a.this.kLg.cUq();
                    }
                }
            });
            tF(false);
            this.kLk.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bGJ() {
            return LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            am.a(this.kLk, R.raw.lottie_use_publish_n);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                am.setBackgroundResource(this.cuA, R.color.cp_mask_b_alpha83);
            } else {
                am.setBackgroundResource(this.cuA, R.color.cp_mask_c_alpha83);
            }
        }

        public void tF(boolean z) {
            this.cuA.setClickable(z);
            this.kLl.setClickable(z);
            this.mCloseView.setClickable(z);
            this.kLm.setClickable(z);
            this.kLn.setClickable(z);
            this.kLo.setClickable(z);
        }
    }
}
