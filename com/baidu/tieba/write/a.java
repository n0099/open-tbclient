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
    protected TbPageContext cVv;
    protected f kMN;
    public View.OnClickListener kMO = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kMN != null) {
                if (a.this.kMN.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.cVv.getPageActivity(), a.this.kMN.getBgColor());
                }
                a.this.kMN.tP(true);
            }
        }
    };
    protected View mRootView = bGY();

    public abstract View bGY();

    public a(TbPageContext tbPageContext, f fVar) {
        this.cVv = tbPageContext;
        this.kMN = fVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void cUv() {
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public View kMQ;
        public TBLottieAnimationView kMR;
        public View kMZ;
        public ImageView kNa;
        public TextView kNb;
        public LinearLayout kNc;
        public ImageView kNd;
        public TextView kNe;
        public LinearLayout kNf;
        public ImageView kNg;
        public TextView kNh;
        public LinearLayout kNi;
        public ImageView kNj;
        public TextView kNk;
        public OvalActionButton kNl;
        public GridLayout kNm;
        public LinearLayout mPhotoView;

        public b(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            if (tbPageContext != null) {
                this.kNc = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.kNd = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.kNe = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.mPhotoView = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.kNa = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.kNb = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.kNf = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.kNg = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.kNh = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.kNi = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.kNj = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.kNk = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.kNl = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.kMN != null && "frs".equals(this.kMN.getFrom())) {
                    this.kNl.setIsCircle(true);
                }
                this.kMZ = this.mRootView.findViewById(R.id.view_background_white);
                this.kMQ = this.mRootView.findViewById(R.id.view_background_translate);
                this.kNm = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.kNm.setMeasureAllChild(true);
                this.kNm.setVerNum(1);
                this.kMR = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.kMR.setSpeed(1.2f);
                cUv();
                this.kMQ.setOnClickListener(this.kMO);
                this.kMQ.setClickable(true);
                this.kNd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kMN != null) {
                            b.this.kMN.KN(b.this.kMN.bKH());
                        }
                    }
                });
                this.kNa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kMN != null) {
                            b.this.kMN.cUK();
                        }
                    }
                });
                this.kNg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kMN != null) {
                            b.this.kMN.cUJ();
                        }
                    }
                });
                this.kNj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.kMN != null) {
                            b.this.kMN.cUI();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View bGY() {
            return LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.kNl.onChangeSkinType(i);
            am.a(this.kMR, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.kMZ, R.drawable.write_tab_background);
            this.kNa.setImageDrawable(SvgManager.aGG().i(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.kNd.setImageDrawable(SvgManager.aGG().i(R.drawable.icon_post_text_n_svg, 1, true));
            this.kNg.setImageDrawable(SvgManager.aGG().i(R.drawable.icon_post_image_n_svg, 1, true));
            this.kNj.setImageDrawable(SvgManager.aGG().i(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.kNb, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kNe, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kNh, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kNk, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void cUv() {
            int equipmentWidth = l.getEquipmentWidth(this.cVv.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            b(this.kNd, i);
            b(this.kNa, i);
            b(this.kNg, i);
            b(this.kNj, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.kNm.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.kNm.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.kMZ.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.kMZ.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.kMR.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.kMR.setLayoutParams(layoutParams3);
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
    public static class C0631a extends a {
        public View cuL;
        public View kMQ;
        public TBLottieAnimationView kMR;
        public RelativeLayout kMS;
        public View kMT;
        public View kMU;
        public View kMV;
        public View kMW;
        public View kMX;
        public View mCloseView;

        public C0631a(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            this.kMQ = this.mRootView.findViewById(R.id.transparent_back_view);
            this.cuL = this.mRootView.findViewById(R.id.view_background);
            this.kMR = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.kMS = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.mCloseView = this.mRootView.findViewById(R.id.closeView);
            this.kMT = this.mRootView.findViewById(R.id.publish_text_view);
            this.kMU = this.mRootView.findViewById(R.id.publish_image_view);
            this.kMV = this.mRootView.findViewById(R.id.publish_video_view);
            this.kMW = this.mRootView.findViewById(R.id.publish_ala_view);
            this.kMX = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.cuL.setOnClickListener(this.kMO);
            this.kMS.setOnClickListener(this.kMO);
            this.mCloseView.setOnClickListener(this.kMO);
            this.kMT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0631a.this.kMN != null) {
                        C0631a.this.kMN.KN(C0631a.this.kMN.bKH());
                    }
                }
            });
            this.kMU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0631a.this.kMN != null) {
                        C0631a.this.kMN.cUJ();
                    }
                }
            });
            this.kMV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0631a.this.kMN != null) {
                        C0631a.this.kMN.cUK();
                    }
                }
            });
            this.kMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0631a.this.kMN != null) {
                        C0631a.this.kMN.cUI();
                    }
                }
            });
            tL(false);
            this.kMR.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bGY() {
            return LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            am.a(this.kMR, R.raw.lottie_use_publish_n);
            am.setBackgroundResource(this.cuL, R.color.cp_mask_d);
            am.setBackgroundResource(this.kMX, R.drawable.home_publish_ala_red_tip);
        }

        public void tL(boolean z) {
            this.cuL.setClickable(z);
            this.kMS.setClickable(z);
            this.mCloseView.setClickable(z);
            this.kMT.setClickable(z);
            this.kMU.setClickable(z);
            this.kMV.setClickable(z);
            this.kMW.setClickable(z);
        }

        public void tM(boolean z) {
            if (this.kMX != null) {
                if (z) {
                    this.kMX.setVisibility(0);
                } else {
                    this.kMX.setVisibility(8);
                }
            }
        }
    }
}
