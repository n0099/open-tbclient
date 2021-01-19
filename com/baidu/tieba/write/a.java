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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext eSJ;
    public View.OnClickListener jSg = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.nRc != null) {
                if (a.this.nRc.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eSJ.getPageActivity(), a.this.nRc.getBgColor());
                }
                a.this.nRc.za(true);
            }
        }
    };
    protected View mRootView = cEG();
    protected g nRc;

    public abstract View cEG();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eSJ = tbPageContext;
        this.nRc = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dTX() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView fjN;
        public View nRE;
        public TBLottieAnimationView nRF;
        public View nRN;
        public LinearLayout nRO;
        public ImageView nRP;
        public TextView nRQ;
        public LinearLayout nRR;
        public ImageView nRS;
        public TextView nRT;
        public LinearLayout nRU;
        public ImageView nRV;
        public TextView nRW;
        public LinearLayout nRX;
        public ImageView nRY;
        public TextView nRZ;
        public LinearLayout nSa;
        ImageView nSb;
        public LinearLayout nSc;
        ImageView nSd;
        TextView nSe;
        public LinearLayout nSf;
        ImageView nSg;
        TextView nSh;
        public OvalActionButton nSi;
        public GridLayout nSj;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.nRR = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.nRS = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.nRT = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.nRO = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.nRP = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.nRQ = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.nRU = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.nRV = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.nRW = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.nRX = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.nRY = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.nRZ = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.nSa = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.nSb = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.fjN = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.nSc = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.nSd = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.nSe = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.nSf = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.nSg = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.nSh = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.nSi = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.nRc != null && "frs".equals(this.nRc.getFrom())) {
                    this.nSi.setIsCircle(true);
                    this.nSi.setHasShadow(false);
                }
                this.nRN = this.mRootView.findViewById(R.id.view_background_white);
                this.nRE = this.mRootView.findViewById(R.id.view_background_translate);
                this.nSj = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.nSj.setMeasureAllChild(true);
                this.nSj.setVerNum(2);
                this.nRF = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.nRF.setSpeed(1.2f);
                dTX();
                this.nRE.setOnClickListener(this.jSg);
                this.nRE.setClickable(true);
                this.nRS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRc != null) {
                            c.this.nRc.Ub(c.this.nRc.cJI());
                        }
                    }
                });
                this.nRP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRc != null) {
                            c.this.nRc.dUm();
                        }
                    }
                });
                this.nRV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRc != null) {
                            c.this.nRc.dUl();
                        }
                    }
                });
                this.nRY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRc != null) {
                            c.this.nRc.dUk();
                        }
                    }
                });
                this.nSa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRc != null) {
                            c.this.nRc.Ua(c.this.nRc.cJI());
                        }
                    }
                });
                this.nSc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRc != null) {
                            c.this.nRc.dUn();
                        }
                    }
                });
                this.nSf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRc != null) {
                            c.this.nRc.dUj();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cEG() {
            return LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void yW(boolean z) {
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.nSi.onChangeSkinType(i);
            ao.a(this.nRF, R.raw.bottom_bar_bg);
            ao.setBackgroundResource(this.nRN, R.drawable.write_tab_background);
            ao.setImageResource(this.nRP, R.drawable.icon_mask_post_photograph56);
            ao.setImageResource(this.nRS, R.drawable.icon_mask_post_text56);
            ao.setImageResource(this.nRV, R.drawable.icon_mask_post_image56);
            ao.setImageResource(this.nRY, R.drawable.icon_mask_post_live56);
            ao.setImageResource(this.nSb, R.drawable.icon_mask_post_vote56);
            ao.setImageResource(this.nSd, R.drawable.icon_mask_post_evaluation56);
            ao.setImageResource(this.nSg, R.drawable.icon_mask_post_goods56);
            ao.setViewTextColor(this.nRQ, R.color.CAM_X0107);
            ao.setViewTextColor(this.nRT, R.color.CAM_X0107);
            ao.setViewTextColor(this.nRW, R.color.CAM_X0107);
            ao.setViewTextColor(this.nRZ, R.color.CAM_X0107);
            ao.setViewTextColor(this.fjN, R.color.CAM_X0107);
            ao.setViewTextColor(this.nSe, R.color.CAM_X0107);
            ao.setViewTextColor(this.nSh, R.color.CAM_X0107);
        }

        @Override // com.baidu.tieba.write.a
        public void dTX() {
            int equipmentWidth = l.getEquipmentWidth(this.eSJ.getPageActivity());
            int i = (int) (0.13518518f * equipmentWidth);
            b(this.nRS, i);
            b(this.nRP, i);
            b(this.nRV, i);
            b(this.nRY, i);
            b(this.nSb, i);
            b(this.nSd, i);
            b(this.nSg, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.nSj.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds433) * dimens);
                this.nSj.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nRN.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1023 : dimens2;
                this.nRN.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.nRF.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.nRF.setLayoutParams(layoutParams3);
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
        public View eFu;
        public View ely;
        public View nRE;
        public TBLottieAnimationView nRF;
        public RelativeLayout nRG;
        public View nRH;
        public View nRI;
        public View nRJ;
        public View nRK;
        public View nRL;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.nRE = this.mRootView.findViewById(R.id.transparent_back_view);
            this.ely = this.mRootView.findViewById(R.id.view_background);
            this.nRF = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.nRG = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.eFu = this.mRootView.findViewById(R.id.closeView);
            this.nRH = this.mRootView.findViewById(R.id.publish_text_view);
            this.nRI = this.mRootView.findViewById(R.id.publish_image_view);
            this.nRJ = this.mRootView.findViewById(R.id.publish_video_view);
            this.nRK = this.mRootView.findViewById(R.id.publish_ala_view);
            this.nRL = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.ely.setOnClickListener(this.jSg);
            this.nRG.setOnClickListener(this.jSg);
            this.eFu.setOnClickListener(this.jSg);
            this.nRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nRc != null) {
                        b.this.nRc.Ub(b.this.nRc.cJI());
                    }
                }
            });
            this.nRI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nRc != null) {
                        b.this.nRc.dUl();
                    }
                }
            });
            this.nRJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nRc != null) {
                        b.this.nRc.dUm();
                    }
                }
            });
            this.nRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nRc != null) {
                        b.this.nRc.dUk();
                    }
                }
            });
            yU(false);
            this.nRF.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cEG() {
            return LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ao.a(this.nRF, R.raw.lottie_use_publish_n);
            ao.setBackgroundResource(this.ely, R.color.CAM_X0502);
            ao.setBackgroundResource(this.nRL, R.drawable.home_publish_ala_red_tip);
        }

        public void yU(boolean z) {
            this.ely.setClickable(z);
            this.nRG.setClickable(z);
            this.eFu.setClickable(z);
            this.nRH.setClickable(z);
            this.nRI.setClickable(z);
            this.nRJ.setClickable(z);
            this.nRK.setClickable(z);
        }

        public void yV(boolean z) {
            if (this.nRL != null) {
                if (z) {
                    this.nRL.setVisibility(0);
                } else {
                    this.nRL.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0893a extends a {
        public View ely;
        private View nRA;
        private View nRB;
        private int nRC;
        public LinearLayout nRe;
        private LinearLayout nRf;
        private LinearLayout nRg;
        private LinearLayout nRh;
        private LinearLayout nRi;
        private LinearLayout nRj;
        private LinearLayout nRk;
        private ImageView nRl;
        private ImageView nRm;
        private ImageView nRn;
        private ImageView nRo;
        private ImageView nRp;
        private ImageView nRq;
        private TextView nRr;
        private TextView nRs;
        private TextView nRt;
        private TextView nRu;
        private TextView nRv;
        private TextView nRw;
        private View nRx;
        private View nRy;
        private View nRz;

        public C0893a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.ely = this.mRootView.findViewById(R.id.view_background);
            this.nRe = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.nRf = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.nRl = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.nRr = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.nRg = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.nRm = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.nRs = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.nRh = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.nRn = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.nRt = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.nRi = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.nRo = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.nRu = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.nRj = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.nRp = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.nRv = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.nRk = (LinearLayout) this.mRootView.findViewById(R.id.thread_write_score);
            this.nRq = (ImageView) this.mRootView.findViewById(R.id.thread_write_score_iv);
            this.nRw = (TextView) this.mRootView.findViewById(R.id.thread_write_score_tv);
            this.nRx = this.mRootView.findViewById(R.id.line_1);
            this.nRy = this.mRootView.findViewById(R.id.line_2);
            this.nRz = this.mRootView.findViewById(R.id.line_3);
            this.nRA = this.mRootView.findViewById(R.id.line_4);
            this.nRB = this.mRootView.findViewById(R.id.line_5);
            this.nRr.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.nRs.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.nRt.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.nRu.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.nRv.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.nRw.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.ely.setOnClickListener(this.jSg);
            this.nRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRc != null) {
                        C0893a.this.nRc.Ub(C0893a.this.nRc.cJI());
                    }
                }
            });
            this.nRg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRc != null) {
                        C0893a.this.nRc.dUl();
                    }
                }
            });
            this.nRh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRc != null) {
                        C0893a.this.nRc.dUm();
                    }
                }
            });
            this.nRi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRc != null) {
                        C0893a.this.nRc.dUk();
                    }
                }
            });
            this.nRj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRc != null) {
                        C0893a.this.nRc.Ua(C0893a.this.nRc.cJI());
                    }
                }
            });
            this.nRk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRc != null) {
                        C0893a.this.nRc.dUn();
                    }
                }
            });
            this.nRC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cEG() {
            return LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ao.setBackgroundColor(this.ely, R.color.CAM_X0603);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).ae(this.nRC).oK(R.color.CAM_X0701).bz(this.nRe);
            this.nRl.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.nRm.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.nRn.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.nRo.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.nRp.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            this.nRq.setImageDrawable(WebPManager.a(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
            ao.setViewTextColor(this.nRr, R.color.CAM_X0101);
            ao.setViewTextColor(this.nRs, R.color.CAM_X0101);
            ao.setViewTextColor(this.nRt, R.color.CAM_X0101);
            ao.setViewTextColor(this.nRu, R.color.CAM_X0101);
            ao.setViewTextColor(this.nRv, R.color.CAM_X0101);
            ao.setViewTextColor(this.nRw, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).ag(this.nRC).af(this.nRC).bz(this.nRf);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).bz(this.nRg);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).bz(this.nRh);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).bz(this.nRi);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).ai(this.nRC).ah(this.nRC).bz(this.nRj);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).ai(this.nRC).ah(this.nRC).bz(this.nRk);
            ao.setBackgroundColor(this.nRx, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nRy, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nRz, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nRA, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nRB, R.color.CAM_X0613);
        }
    }
}
