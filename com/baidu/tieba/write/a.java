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
    protected TbPageContext cVh;
    protected f kKU;
    public View.OnClickListener kKV = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kKU != null) {
                if (a.this.kKU.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.cVh.getPageActivity(), a.this.kKU.getBgColor());
                }
                a.this.kKU.tI(true);
            }
        }
    };
    protected View mRootView = bGI();

    public abstract View bGI();

    public a(TbPageContext tbPageContext, f fVar) {
        this.cVh = tbPageContext;
        this.kKU = fVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void cUa() {
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public View kKX;
        public TBLottieAnimationView kKY;
        public View kLe;
        public ImageView kLf;
        public TextView kLg;
        public LinearLayout kLh;
        public ImageView kLi;
        public TextView kLj;
        public LinearLayout kLk;
        public ImageView kLl;
        public TextView kLm;
        public LinearLayout kLn;
        public ImageView kLo;
        public TextView kLp;
        public OvalActionButton kLq;
        public GridLayout kLr;
        public LinearLayout mPhotoView;

        public b(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            if (tbPageContext != null) {
                this.kLh = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.kLi = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.kLj = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mPhotoView = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.kLf = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.kLg = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.kLk = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.kLl = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.kLm = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.kLn = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.kLo = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.kLp = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.kLq = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.kKU != null && "frs".equals(this.kKU.getFrom())) {
                    this.kLq.setIsCircle(true);
                }
                this.kLe = this.mRootView.findViewById(R.id.view_background_white);
                this.kKX = this.mRootView.findViewById(R.id.view_background_translate);
                this.kLr = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.kLr.setMeasureAllChild(true);
                this.kLr.setVerNum(1);
                this.kKY = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.kKY.setSpeed(1.2f);
                cUa();
                this.kKX.setOnClickListener(this.kKV);
                this.kKX.setClickable(true);
                this.kLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKU != null) {
                            b.this.kKU.KN(b.this.kKU.bKt());
                        }
                    }
                });
                this.kLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKU != null) {
                            b.this.kKU.cUp();
                        }
                    }
                });
                this.kLl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKU != null) {
                            b.this.kKU.cUo();
                        }
                    }
                });
                this.kLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kKU != null) {
                            b.this.kKU.cUn();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View bGI() {
            return LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.kLq.onChangeSkinType(i);
            am.a(this.kKY, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.kLe, R.drawable.write_tab_background);
            this.kLf.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.kLi.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_post_text_n_svg, 1, true));
            this.kLl.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_post_image_n_svg, 1, true));
            this.kLo.setImageDrawable(SvgManager.aGC().i(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.kLg, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kLj, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kLm, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kLp, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void cUa() {
            int equipmentWidth = l.getEquipmentWidth(this.cVh.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            b(this.kLi, i);
            b(this.kLf, i);
            b(this.kLl, i);
            b(this.kLo, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.kLr.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.kLr.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.kLe.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.kLe.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.kKY.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.kKY.setLayoutParams(layoutParams3);
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
        public View cuz;
        public View kKX;
        public TBLottieAnimationView kKY;
        public RelativeLayout kKZ;
        public View kLa;
        public View kLb;
        public View kLc;
        public View mCloseView;

        public C0630a(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            this.kKX = this.mRootView.findViewById(R.id.transparent_back_view);
            this.cuz = this.mRootView.findViewById(R.id.view_background);
            this.kKY = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.kKZ = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.mCloseView = this.mRootView.findViewById(R.id.closeView);
            this.kLa = this.mRootView.findViewById(R.id.publish_text_view);
            this.kLb = this.mRootView.findViewById(R.id.publish_image_view);
            this.kLc = this.mRootView.findViewById(R.id.publish_video_view);
            this.cuz.setOnClickListener(this.kKV);
            this.kKZ.setOnClickListener(this.kKV);
            this.mCloseView.setOnClickListener(this.kKV);
            this.kLa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0630a.this.kKU != null) {
                        C0630a.this.kKU.KN(C0630a.this.kKU.bKt());
                    }
                }
            });
            this.kLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0630a.this.kKU != null) {
                        C0630a.this.kKU.cUo();
                    }
                }
            });
            this.kLc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0630a.this.kKU != null) {
                        C0630a.this.kKU.cUp();
                    }
                }
            });
            tF(false);
            this.kKY.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bGI() {
            return LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            am.a(this.kKY, R.raw.lottie_use_publish_n);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                am.setBackgroundResource(this.cuz, R.color.cp_mask_b_alpha83);
            } else {
                am.setBackgroundResource(this.cuz, R.color.cp_mask_c_alpha83);
            }
        }

        public void tF(boolean z) {
            this.cuz.setClickable(z);
            this.kKZ.setClickable(z);
            this.mCloseView.setClickable(z);
            this.kLa.setClickable(z);
            this.kLb.setClickable(z);
            this.kLc.setClickable(z);
        }
    }
}
