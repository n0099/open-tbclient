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
    protected TbPageContext duG;
    protected f lwd;
    public View.OnClickListener lwe = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.lwd != null) {
                if (a.this.lwd.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.duG.getPageActivity(), a.this.lwd.getBgColor());
                }
                a.this.lwd.uP(true);
            }
        }
    };
    protected View mRootView = bRz();

    public abstract View bRz();

    public a(TbPageContext tbPageContext, f fVar) {
        this.duG = tbPageContext;
        this.lwd = fVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void deQ() {
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public ImageView lwA;
        public TextView lwB;
        public OvalActionButton lwC;
        public GridLayout lwD;
        public View lwg;
        public TBLottieAnimationView lwh;
        public View lwp;
        public LinearLayout lwq;
        public ImageView lwr;
        public TextView lws;
        public LinearLayout lwt;
        public ImageView lwu;
        public TextView lwv;
        public LinearLayout lww;
        public ImageView lwx;
        public TextView lwy;
        public LinearLayout lwz;

        public b(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            if (tbPageContext != null) {
                this.lwt = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.lwu = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.lwv = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.lwq = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.lwr = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.lws = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.lww = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.lwx = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.lwy = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.lwz = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.lwA = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.lwB = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.lwC = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.lwd != null && "frs".equals(this.lwd.getFrom())) {
                    this.lwC.setIsCircle(true);
                }
                this.lwp = this.mRootView.findViewById(R.id.view_background_white);
                this.lwg = this.mRootView.findViewById(R.id.view_background_translate);
                this.lwD = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.lwD.setMeasureAllChild(true);
                this.lwD.setVerNum(1);
                this.lwh = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.lwh.setSpeed(1.2f);
                deQ();
                this.lwg.setOnClickListener(this.lwe);
                this.lwg.setClickable(true);
                this.lwu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.lwd != null) {
                            b.this.lwd.Ms(b.this.lwd.bVh());
                        }
                    }
                });
                this.lwr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.lwd != null) {
                            b.this.lwd.dff();
                        }
                    }
                });
                this.lwx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.lwd != null) {
                            b.this.lwd.dfe();
                        }
                    }
                });
                this.lwA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.lwd != null) {
                            b.this.lwd.dfd();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View bRz() {
            return LayoutInflater.from(this.duG.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.lwC.onChangeSkinType(i);
            am.a(this.lwh, R.raw.bottom_bar_bg);
            am.setBackgroundResource(this.lwp, R.drawable.write_tab_background);
            this.lwr.setImageDrawable(SvgManager.aOU().i(R.drawable.icon_post_photograph_n_svg, 1, true));
            this.lwu.setImageDrawable(SvgManager.aOU().i(R.drawable.icon_post_text_n_svg, 1, true));
            this.lwx.setImageDrawable(SvgManager.aOU().i(R.drawable.icon_post_image_n_svg, 1, true));
            this.lwA.setImageDrawable(SvgManager.aOU().i(R.drawable.icon_post_live_n_svg, 1, true));
            am.setViewTextColor(this.lws, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lwv, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lwy, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lwB, (int) R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void deQ() {
            int equipmentWidth = l.getEquipmentWidth(this.duG.getPageActivity());
            int i = (int) (0.15555556f * equipmentWidth);
            b(this.lwu, i);
            b(this.lwr, i);
            b(this.lwx, i);
            b(this.lwA, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.lwD.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds418) * dimens);
                this.lwD.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.lwp.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds912) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 912 : dimens2;
                this.lwp.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.lwh.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.lwh.setLayoutParams(layoutParams3);
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
    public static class C0672a extends a {
        public View cTH;
        public View dkn;
        public View lwg;
        public TBLottieAnimationView lwh;
        public RelativeLayout lwi;
        public View lwj;
        public View lwk;
        public View lwl;
        public View lwm;
        public View lwn;

        public C0672a(TbPageContext tbPageContext, f fVar) {
            super(tbPageContext, fVar);
            this.lwg = this.mRootView.findViewById(R.id.transparent_back_view);
            this.cTH = this.mRootView.findViewById(R.id.view_background);
            this.lwh = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.lwi = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.dkn = this.mRootView.findViewById(R.id.closeView);
            this.lwj = this.mRootView.findViewById(R.id.publish_text_view);
            this.lwk = this.mRootView.findViewById(R.id.publish_image_view);
            this.lwl = this.mRootView.findViewById(R.id.publish_video_view);
            this.lwm = this.mRootView.findViewById(R.id.publish_ala_view);
            this.lwn = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.cTH.setOnClickListener(this.lwe);
            this.lwi.setOnClickListener(this.lwe);
            this.dkn.setOnClickListener(this.lwe);
            this.lwj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0672a.this.lwd != null) {
                        C0672a.this.lwd.Ms(C0672a.this.lwd.bVh());
                    }
                }
            });
            this.lwk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0672a.this.lwd != null) {
                        C0672a.this.lwd.dfe();
                    }
                }
            });
            this.lwl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0672a.this.lwd != null) {
                        C0672a.this.lwd.dff();
                    }
                }
            });
            this.lwm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0672a.this.lwd != null) {
                        C0672a.this.lwd.dfd();
                    }
                }
            });
            uL(false);
            this.lwh.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View bRz() {
            return LayoutInflater.from(this.duG.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            am.a(this.lwh, R.raw.lottie_use_publish_n);
            am.setBackgroundResource(this.cTH, R.color.cp_mask_d);
            am.setBackgroundResource(this.lwn, R.drawable.home_publish_ala_red_tip);
        }

        public void uL(boolean z) {
            this.cTH.setClickable(z);
            this.lwi.setClickable(z);
            this.dkn.setClickable(z);
            this.lwj.setClickable(z);
            this.lwk.setClickable(z);
            this.lwl.setClickable(z);
            this.lwm.setClickable(z);
        }

        public void uM(boolean z) {
            if (this.lwn != null) {
                if (z) {
                    this.lwn.setVisibility(0);
                } else {
                    this.lwn.setVisibility(8);
                }
            }
        }
    }
}
