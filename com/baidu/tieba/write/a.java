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
            if (a.this.nRb != null) {
                if (a.this.nRb.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eSJ.getPageActivity(), a.this.nRb.getBgColor());
                }
                a.this.nRb.za(true);
            }
        }
    };
    protected View mRootView = cEG();
    protected g nRb;

    public abstract View cEG();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eSJ = tbPageContext;
        this.nRb = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dTX() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView fjN;
        public View nRD;
        public TBLottieAnimationView nRE;
        public View nRM;
        public LinearLayout nRN;
        public ImageView nRO;
        public TextView nRP;
        public LinearLayout nRQ;
        public ImageView nRR;
        public TextView nRS;
        public LinearLayout nRT;
        public ImageView nRU;
        public TextView nRV;
        public LinearLayout nRW;
        public ImageView nRX;
        public TextView nRY;
        public LinearLayout nRZ;
        ImageView nSa;
        public LinearLayout nSb;
        ImageView nSc;
        TextView nSd;
        public LinearLayout nSe;
        ImageView nSf;
        TextView nSg;
        public OvalActionButton nSh;
        public GridLayout nSi;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.nRQ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.nRR = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.nRS = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.nRN = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.nRO = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.nRP = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.nRT = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.nRU = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.nRV = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.nRW = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.nRX = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.nRY = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.nRZ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.nSa = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.fjN = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.nSb = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.nSc = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.nSd = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.nSe = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.nSf = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.nSg = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.nSh = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.nRb != null && "frs".equals(this.nRb.getFrom())) {
                    this.nSh.setIsCircle(true);
                    this.nSh.setHasShadow(false);
                }
                this.nRM = this.mRootView.findViewById(R.id.view_background_white);
                this.nRD = this.mRootView.findViewById(R.id.view_background_translate);
                this.nSi = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.nSi.setMeasureAllChild(true);
                this.nSi.setVerNum(2);
                this.nRE = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.nRE.setSpeed(1.2f);
                dTX();
                this.nRD.setOnClickListener(this.jSg);
                this.nRD.setClickable(true);
                this.nRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRb != null) {
                            c.this.nRb.Ua(c.this.nRb.cJI());
                        }
                    }
                });
                this.nRO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRb != null) {
                            c.this.nRb.dUm();
                        }
                    }
                });
                this.nRU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRb != null) {
                            c.this.nRb.dUl();
                        }
                    }
                });
                this.nRX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRb != null) {
                            c.this.nRb.dUk();
                        }
                    }
                });
                this.nRZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRb != null) {
                            c.this.nRb.TZ(c.this.nRb.cJI());
                        }
                    }
                });
                this.nSb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRb != null) {
                            c.this.nRb.dUn();
                        }
                    }
                });
                this.nSe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nRb != null) {
                            c.this.nRb.dUj();
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
            this.nSh.onChangeSkinType(i);
            ao.a(this.nRE, R.raw.bottom_bar_bg);
            ao.setBackgroundResource(this.nRM, R.drawable.write_tab_background);
            ao.setImageResource(this.nRO, R.drawable.icon_mask_post_photograph56);
            ao.setImageResource(this.nRR, R.drawable.icon_mask_post_text56);
            ao.setImageResource(this.nRU, R.drawable.icon_mask_post_image56);
            ao.setImageResource(this.nRX, R.drawable.icon_mask_post_live56);
            ao.setImageResource(this.nSa, R.drawable.icon_mask_post_vote56);
            ao.setImageResource(this.nSc, R.drawable.icon_mask_post_evaluation56);
            ao.setImageResource(this.nSf, R.drawable.icon_mask_post_goods56);
            ao.setViewTextColor(this.nRP, R.color.CAM_X0107);
            ao.setViewTextColor(this.nRS, R.color.CAM_X0107);
            ao.setViewTextColor(this.nRV, R.color.CAM_X0107);
            ao.setViewTextColor(this.nRY, R.color.CAM_X0107);
            ao.setViewTextColor(this.fjN, R.color.CAM_X0107);
            ao.setViewTextColor(this.nSd, R.color.CAM_X0107);
            ao.setViewTextColor(this.nSg, R.color.CAM_X0107);
        }

        @Override // com.baidu.tieba.write.a
        public void dTX() {
            int equipmentWidth = l.getEquipmentWidth(this.eSJ.getPageActivity());
            int i = (int) (0.13518518f * equipmentWidth);
            b(this.nRR, i);
            b(this.nRO, i);
            b(this.nRU, i);
            b(this.nRX, i);
            b(this.nSa, i);
            b(this.nSc, i);
            b(this.nSf, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.nSi.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds433) * dimens);
                this.nSi.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nRM.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1023 : dimens2;
                this.nRM.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.nRE.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.nRE.setLayoutParams(layoutParams3);
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
        public View nRD;
        public TBLottieAnimationView nRE;
        public RelativeLayout nRF;
        public View nRG;
        public View nRH;
        public View nRI;
        public View nRJ;
        public View nRK;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.nRD = this.mRootView.findViewById(R.id.transparent_back_view);
            this.ely = this.mRootView.findViewById(R.id.view_background);
            this.nRE = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.nRF = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.eFu = this.mRootView.findViewById(R.id.closeView);
            this.nRG = this.mRootView.findViewById(R.id.publish_text_view);
            this.nRH = this.mRootView.findViewById(R.id.publish_image_view);
            this.nRI = this.mRootView.findViewById(R.id.publish_video_view);
            this.nRJ = this.mRootView.findViewById(R.id.publish_ala_view);
            this.nRK = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.ely.setOnClickListener(this.jSg);
            this.nRF.setOnClickListener(this.jSg);
            this.eFu.setOnClickListener(this.jSg);
            this.nRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nRb != null) {
                        b.this.nRb.Ua(b.this.nRb.cJI());
                    }
                }
            });
            this.nRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nRb != null) {
                        b.this.nRb.dUl();
                    }
                }
            });
            this.nRI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nRb != null) {
                        b.this.nRb.dUm();
                    }
                }
            });
            this.nRJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nRb != null) {
                        b.this.nRb.dUk();
                    }
                }
            });
            yU(false);
            this.nRE.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cEG() {
            return LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ao.a(this.nRE, R.raw.lottie_use_publish_n);
            ao.setBackgroundResource(this.ely, R.color.CAM_X0502);
            ao.setBackgroundResource(this.nRK, R.drawable.home_publish_ala_red_tip);
        }

        public void yU(boolean z) {
            this.ely.setClickable(z);
            this.nRF.setClickable(z);
            this.eFu.setClickable(z);
            this.nRG.setClickable(z);
            this.nRH.setClickable(z);
            this.nRI.setClickable(z);
            this.nRJ.setClickable(z);
        }

        public void yV(boolean z) {
            if (this.nRK != null) {
                if (z) {
                    this.nRK.setVisibility(0);
                } else {
                    this.nRK.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0893a extends a {
        public View ely;
        private View nRA;
        private int nRB;
        public LinearLayout nRd;
        private LinearLayout nRe;
        private LinearLayout nRf;
        private LinearLayout nRg;
        private LinearLayout nRh;
        private LinearLayout nRi;
        private LinearLayout nRj;
        private ImageView nRk;
        private ImageView nRl;
        private ImageView nRm;
        private ImageView nRn;
        private ImageView nRo;
        private ImageView nRp;
        private TextView nRq;
        private TextView nRr;
        private TextView nRs;
        private TextView nRt;
        private TextView nRu;
        private TextView nRv;
        private View nRw;
        private View nRx;
        private View nRy;
        private View nRz;

        public C0893a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.ely = this.mRootView.findViewById(R.id.view_background);
            this.nRd = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.nRe = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.nRk = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.nRq = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.nRf = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.nRl = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.nRr = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.nRg = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.nRm = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.nRs = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.nRh = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.nRn = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.nRt = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.nRi = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.nRo = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.nRu = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.nRj = (LinearLayout) this.mRootView.findViewById(R.id.thread_write_score);
            this.nRp = (ImageView) this.mRootView.findViewById(R.id.thread_write_score_iv);
            this.nRv = (TextView) this.mRootView.findViewById(R.id.thread_write_score_tv);
            this.nRw = this.mRootView.findViewById(R.id.line_1);
            this.nRx = this.mRootView.findViewById(R.id.line_2);
            this.nRy = this.mRootView.findViewById(R.id.line_3);
            this.nRz = this.mRootView.findViewById(R.id.line_4);
            this.nRA = this.mRootView.findViewById(R.id.line_5);
            this.nRq.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.nRr.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.nRs.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.nRt.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.nRu.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.nRv.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.ely.setOnClickListener(this.jSg);
            this.nRe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRb != null) {
                        C0893a.this.nRb.Ua(C0893a.this.nRb.cJI());
                    }
                }
            });
            this.nRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRb != null) {
                        C0893a.this.nRb.dUl();
                    }
                }
            });
            this.nRg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRb != null) {
                        C0893a.this.nRb.dUm();
                    }
                }
            });
            this.nRh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRb != null) {
                        C0893a.this.nRb.dUk();
                    }
                }
            });
            this.nRi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRb != null) {
                        C0893a.this.nRb.TZ(C0893a.this.nRb.cJI());
                    }
                }
            });
            this.nRj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0893a.this.nRb != null) {
                        C0893a.this.nRb.dUn();
                    }
                }
            });
            this.nRB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
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
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).ae(this.nRB).oK(R.color.CAM_X0701).bz(this.nRd);
            this.nRk.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.nRl.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.nRm.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.nRn.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.nRo.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            this.nRp.setImageDrawable(WebPManager.a(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
            ao.setViewTextColor(this.nRq, R.color.CAM_X0101);
            ao.setViewTextColor(this.nRr, R.color.CAM_X0101);
            ao.setViewTextColor(this.nRs, R.color.CAM_X0101);
            ao.setViewTextColor(this.nRt, R.color.CAM_X0101);
            ao.setViewTextColor(this.nRu, R.color.CAM_X0101);
            ao.setViewTextColor(this.nRv, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).ag(this.nRB).af(this.nRB).bz(this.nRe);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).bz(this.nRf);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).bz(this.nRg);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).bz(this.nRh);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).ai(this.nRB).ah(this.nRB).bz(this.nRi);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oS(1).ai(this.nRB).ah(this.nRB).bz(this.nRj);
            ao.setBackgroundColor(this.nRw, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nRx, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nRy, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nRz, R.color.CAM_X0613);
            ao.setBackgroundColor(this.nRA, R.color.CAM_X0613);
        }
    }
}
