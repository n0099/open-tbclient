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
    protected TbPageContext eGu;
    public View.OnClickListener jvX = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.nEi != null) {
                if (a.this.nEi.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eGu.getPageActivity(), a.this.nEi.getBgColor());
                }
                a.this.nEi.yz(true);
            }
        }
    };
    protected View mRootView = cBk();
    protected g nEi;

    public abstract View cBk();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eGu = tbPageContext;
        this.nEi = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dSQ() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView eXr;
        public View nEG;
        public TBLottieAnimationView nEH;
        public View nEP;
        public LinearLayout nEQ;
        public ImageView nER;
        public TextView nES;
        public LinearLayout nET;
        public ImageView nEU;
        public TextView nEV;
        public LinearLayout nEW;
        public ImageView nEX;
        public TextView nEY;
        public LinearLayout nEZ;
        public ImageView nFa;
        public TextView nFb;
        public LinearLayout nFc;
        ImageView nFd;
        public LinearLayout nFe;
        ImageView nFf;
        TextView nFg;
        public LinearLayout nFh;
        ImageView nFi;
        TextView nFj;
        public OvalActionButton nFk;
        public GridLayout nFl;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.nET = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.nEU = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.nEV = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.nEQ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.nER = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.nES = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.nEW = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.nEX = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.nEY = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.nEZ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.nFa = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.nFb = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.nFc = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.nFd = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.eXr = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.nFe = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.nFf = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.nFg = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.nFh = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.nFi = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.nFj = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.nFk = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.nEi != null && "frs".equals(this.nEi.getFrom())) {
                    this.nFk.setIsCircle(true);
                    this.nFk.setHasShadow(false);
                }
                this.nEP = this.mRootView.findViewById(R.id.view_background_white);
                this.nEG = this.mRootView.findViewById(R.id.view_background_translate);
                this.nFl = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.nFl.setMeasureAllChild(true);
                this.nFl.setVerNum(2);
                this.nEH = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.nEH.setSpeed(1.2f);
                dSQ();
                this.nEG.setOnClickListener(this.jvX);
                this.nEG.setClickable(true);
                this.nEU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nEi != null) {
                            c.this.nEi.Up(c.this.nEi.cFj());
                        }
                    }
                });
                this.nER.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nEi != null) {
                            c.this.nEi.dTf();
                        }
                    }
                });
                this.nEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nEi != null) {
                            c.this.nEi.dTe();
                        }
                    }
                });
                this.nFa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nEi != null) {
                            c.this.nEi.dTd();
                        }
                    }
                });
                this.nFc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nEi != null) {
                            c.this.nEi.Uo(c.this.nEi.cFj());
                        }
                    }
                });
                this.nFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nEi != null) {
                            c.this.nEi.dTb();
                        }
                    }
                });
                this.nFh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nEi != null) {
                            c.this.nEi.dTc();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cBk() {
            return LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void yv(boolean z) {
            this.nFe.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.nFk.onChangeSkinType(i);
            ap.a(this.nEH, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.nEP, R.drawable.write_tab_background);
            ap.setImageResource(this.nER, R.drawable.icon_mask_post_photograph56);
            ap.setImageResource(this.nEU, R.drawable.icon_mask_post_text56);
            ap.setImageResource(this.nEX, R.drawable.icon_mask_post_image56);
            ap.setImageResource(this.nFa, R.drawable.icon_mask_post_live56);
            ap.setImageResource(this.nFd, R.drawable.icon_mask_post_vote56);
            ap.setImageResource(this.nFf, R.drawable.icon_mask_post_evaluation56);
            ap.setImageResource(this.nFi, R.drawable.icon_mask_post_goods56);
            ap.setViewTextColor(this.nES, R.color.CAM_X0107);
            ap.setViewTextColor(this.nEV, R.color.CAM_X0107);
            ap.setViewTextColor(this.nEY, R.color.CAM_X0107);
            ap.setViewTextColor(this.nFb, R.color.CAM_X0107);
            ap.setViewTextColor(this.eXr, R.color.CAM_X0107);
            ap.setViewTextColor(this.nFg, R.color.CAM_X0107);
            ap.setViewTextColor(this.nFj, R.color.CAM_X0107);
        }

        @Override // com.baidu.tieba.write.a
        public void dSQ() {
            int equipmentWidth = l.getEquipmentWidth(this.eGu.getPageActivity());
            int i = (int) (0.13518518f * equipmentWidth);
            b(this.nEU, i);
            b(this.nER, i);
            b(this.nEX, i);
            b(this.nFa, i);
            b(this.nFd, i);
            b(this.nFf, i);
            b(this.nFi, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.nFl.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds433) * dimens);
                this.nFl.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nEP.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1023 : dimens2;
                this.nEP.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.nEH.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.nEH.setLayoutParams(layoutParams3);
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
        public View eal;
        public View etA;
        public View nEG;
        public TBLottieAnimationView nEH;
        public RelativeLayout nEI;
        public View nEJ;
        public View nEK;
        public View nEL;
        public View nEM;
        public View nEN;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.nEG = this.mRootView.findViewById(R.id.transparent_back_view);
            this.eal = this.mRootView.findViewById(R.id.view_background);
            this.nEH = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.nEI = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.etA = this.mRootView.findViewById(R.id.closeView);
            this.nEJ = this.mRootView.findViewById(R.id.publish_text_view);
            this.nEK = this.mRootView.findViewById(R.id.publish_image_view);
            this.nEL = this.mRootView.findViewById(R.id.publish_video_view);
            this.nEM = this.mRootView.findViewById(R.id.publish_ala_view);
            this.nEN = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.eal.setOnClickListener(this.jvX);
            this.nEI.setOnClickListener(this.jvX);
            this.etA.setOnClickListener(this.jvX);
            this.nEJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nEi != null) {
                        b.this.nEi.Up(b.this.nEi.cFj());
                    }
                }
            });
            this.nEK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nEi != null) {
                        b.this.nEi.dTe();
                    }
                }
            });
            this.nEL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nEi != null) {
                        b.this.nEi.dTf();
                    }
                }
            });
            this.nEM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nEi != null) {
                        b.this.nEi.dTd();
                    }
                }
            });
            yt(false);
            this.nEH.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cBk() {
            return LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.nEH, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.eal, R.color.CAM_X0502);
            ap.setBackgroundResource(this.nEN, R.drawable.home_publish_ala_red_tip);
        }

        public void yt(boolean z) {
            this.eal.setClickable(z);
            this.nEI.setClickable(z);
            this.etA.setClickable(z);
            this.nEJ.setClickable(z);
            this.nEK.setClickable(z);
            this.nEL.setClickable(z);
            this.nEM.setClickable(z);
        }

        public void yu(boolean z) {
            if (this.nEN != null) {
                if (z) {
                    this.nEN.setVisibility(0);
                } else {
                    this.nEN.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0874a extends a {
        public View eal;
        private View nEA;
        private View nEB;
        private View nEC;
        private View nED;
        private int nEE;
        public LinearLayout nEk;
        private LinearLayout nEl;
        private LinearLayout nEm;
        private LinearLayout nEn;
        private LinearLayout nEo;
        private LinearLayout nEp;
        private ImageView nEq;
        private ImageView nEr;
        private ImageView nEs;
        private ImageView nEt;
        private ImageView nEu;
        private TextView nEv;
        private TextView nEw;
        private TextView nEx;
        private TextView nEy;
        private TextView nEz;

        public C0874a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.eal = this.mRootView.findViewById(R.id.view_background);
            this.nEk = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.nEl = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.nEq = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.nEv = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.nEm = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.nEr = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.nEw = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.nEn = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.nEs = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.nEx = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.nEo = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.nEt = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.nEy = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.nEp = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.nEu = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.nEz = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.nEA = this.mRootView.findViewById(R.id.line_1);
            this.nEB = this.mRootView.findViewById(R.id.line_2);
            this.nEC = this.mRootView.findViewById(R.id.line_3);
            this.nED = this.mRootView.findViewById(R.id.line_4);
            this.nEv.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.nEw.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.nEx.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.nEy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.nEz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.eal.setOnClickListener(this.jvX);
            this.nEl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0874a.this.nEi != null) {
                        C0874a.this.nEi.Up(C0874a.this.nEi.cFj());
                    }
                }
            });
            this.nEm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0874a.this.nEi != null) {
                        C0874a.this.nEi.dTe();
                    }
                }
            });
            this.nEn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0874a.this.nEi != null) {
                        C0874a.this.nEi.dTf();
                    }
                }
            });
            this.nEo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0874a.this.nEi != null) {
                        C0874a.this.nEi.dTd();
                    }
                }
            });
            this.nEp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0874a.this.nEi != null) {
                        C0874a.this.nEi.Uo(C0874a.this.nEi.cFj());
                    }
                }
            });
            this.nEE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cBk() {
            return LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.eal, R.color.CAM_X0603);
            com.baidu.tbadk.core.util.e.a.brc().pF(0).pO(1).ac(this.nEE).pG(R.color.CAM_X0701).bn(this.nEk);
            this.nEq.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.nEr.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.nEs.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.nEt.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.nEu.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.nEv, R.color.CAM_X0101);
            ap.setViewTextColor(this.nEw, R.color.CAM_X0101);
            ap.setViewTextColor(this.nEx, R.color.CAM_X0101);
            ap.setViewTextColor(this.nEy, R.color.CAM_X0101);
            ap.setViewTextColor(this.nEz, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.e.a.brc().pF(0).pO(1).ae(this.nEE).ad(this.nEE).bn(this.nEl);
            com.baidu.tbadk.core.util.e.a.brc().pF(0).pO(1).bn(this.nEm);
            com.baidu.tbadk.core.util.e.a.brc().pF(0).pO(1).bn(this.nEn);
            com.baidu.tbadk.core.util.e.a.brc().pF(0).pO(1).bn(this.nEo);
            com.baidu.tbadk.core.util.e.a.brc().pF(0).pO(1).ag(this.nEE).af(this.nEE).bn(this.nEp);
            ap.setBackgroundColor(this.nEA, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nEB, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nEC, R.color.CAM_X0613);
            ap.setBackgroundColor(this.nED, R.color.CAM_X0613);
        }
    }
}
