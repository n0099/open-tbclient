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
    protected TbPageContext duK;
    protected f lwh;
    public View.OnClickListener lwi = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.lwh != null) {
                if (a.this.lwh.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.duK.getPageActivity(), a.this.lwh.getBgColor());
                }
                a.this.lwh.uP(true);
            }
        }
    };
    protected View mRootView = bRx();

    public abstract View bRx();

    public a(TbPageContext tbPageContext, f fVar) {
        this.duK = tbPageContext;
        this.lwh = fVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void deN() {
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public LinearLayout lwA;
        public ImageView lwB;
        public TextView lwC;
        public LinearLayout lwD;
        public ImageView lwE;
        public TextView lwF;
        public OvalActionButton lwG;
        public GridLayout lwH;
        public View lwk;
        public TBLottieAnimationView lwl;
        public View lwt;
        public LinearLayout lwu;
        public ImageView lwv;
        public TextView lww;
        public LinearLayout lwx;
        public ImageView lwy;
        public TextView lwz;

        public b(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            if (tbPageContext != null) {
                this.lwx = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.lwy = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.lwz = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.lwu = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.lwv = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.lww = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.lwA = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.lwB = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.lwC = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.lwD = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.lwE = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.lwF = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.lwG = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.lwh != null && "frs".equals(this.lwh.getFrom())) {
                    this.lwG.setIsCircle(true);
                }
                this.lwt = this.mRootView.findViewById(R.id.view_background_white);
                this.lwk = this.mRootView.findViewById(R.id.view_background_translate);
                this.lwH = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.lwH.setMeasureAllChild(true);
                this.lwH.setVerNum(1);
                this.lwl = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.lwl.setSpeed(1.2f);
                deN();
                this.lwk.setOnClickListener(this.lwi);
                this.lwk.setClickable(true);
                this.lwy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.lwh != null) {
                            b.this.lwh.Mv(b.this.lwh.bVf());
                        }
                    }
                });
                this.lwv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.lwh != null) {
                            b.this.lwh.dfc();
                        }
                    }
                });
                this.lwB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.lwh != null) {
                            b.this.lwh.dfb();
                        }
                    }
                });
                this.lwE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.lwh != null) {
                            b.this.lwh.dfa();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View bRx() {
            return LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.lwG.onChangeSkinType(i);
            am.a(this.lwl, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.lwt, R.drawable.write_tab_background);
            this.lwv.setImageDrawable(SvgManager.aOR().i(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.lwy.setImageDrawable(SvgManager.aOR().i(R.drawable.icon_post_text_n_svg, 1, true));
            this.lwB.setImageDrawable(SvgManager.aOR().i(R.drawable.icon_post_image_n_svg, 1, true));
            this.lwE.setImageDrawable(SvgManager.aOR().i(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.lww, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lwz, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lwC, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lwF, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void deN() {
            int equipmentWidth = l.getEquipmentWidth(this.duK.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            b(this.lwy, i);
            b(this.lwv, i);
            b(this.lwB, i);
            b(this.lwE, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.lwH.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.lwH.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.lwt.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.lwt.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.lwl.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.lwl.setLayoutParams(layoutParams3);
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
    public static class C0693a extends a {
        public View cTM;
        public View dkr;
        public View lwk;
        public TBLottieAnimationView lwl;
        public RelativeLayout lwm;
        public View lwn;
        public View lwo;
        public View lwp;
        public View lwq;
        public View lwr;

        public C0693a(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            this.lwk = this.mRootView.findViewById(R.id.transparent_back_view);
            this.cTM = this.mRootView.findViewById(R.id.view_background);
            this.lwl = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.lwm = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dkr = this.mRootView.findViewById(R.id.closeView);
            this.lwn = this.mRootView.findViewById(R.id.publish_text_view);
            this.lwo = this.mRootView.findViewById(R.id.publish_image_view);
            this.lwp = this.mRootView.findViewById(R.id.publish_video_view);
            this.lwq = this.mRootView.findViewById(R.id.publish_ala_view);
            this.lwr = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.cTM.setOnClickListener(this.lwi);
            this.lwm.setOnClickListener(this.lwi);
            this.dkr.setOnClickListener(this.lwi);
            this.lwn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0693a.this.lwh != null) {
                        C0693a.this.lwh.Mv(C0693a.this.lwh.bVf());
                    }
                }
            });
            this.lwo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0693a.this.lwh != null) {
                        C0693a.this.lwh.dfb();
                    }
                }
            });
            this.lwp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0693a.this.lwh != null) {
                        C0693a.this.lwh.dfc();
                    }
                }
            });
            this.lwq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0693a.this.lwh != null) {
                        C0693a.this.lwh.dfa();
                    }
                }
            });
            uL(false);
            this.lwl.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bRx() {
            return LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            am.a(this.lwl, R.raw.lottie_use_publish_n);
            am.setBackgroundResource(this.cTM, R.color.cp_mask_d);
            am.setBackgroundResource(this.lwr, R.drawable.home_publish_ala_red_tip);
        }

        public void uL(boolean z) {
            this.cTM.setClickable(z);
            this.lwm.setClickable(z);
            this.dkr.setClickable(z);
            this.lwn.setClickable(z);
            this.lwo.setClickable(z);
            this.lwp.setClickable(z);
            this.lwq.setClickable(z);
        }

        public void uM(boolean z) {
            if (this.lwr != null) {
                if (z) {
                    this.lwr.setVisibility(0);
                } else {
                    this.lwr.setVisibility(8);
                }
            }
        }
    }
}
