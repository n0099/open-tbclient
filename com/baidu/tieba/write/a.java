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
    protected TbPageContext eWx;
    public View.OnClickListener kbX = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.odN != null) {
                if (a.this.odN.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.eWx.getPageActivity(), a.this.odN.getBgColor());
                }
                a.this.odN.zv(true);
            }
        }
    };
    protected View mRootView = cGg();
    protected g odN;

    public abstract View cGg();

    public a(TbPageContext tbPageContext, g gVar) {
        this.eWx = tbPageContext;
        this.odN = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dWB() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView fnE;
        public ImageView oeA;
        public TextView oeB;
        public LinearLayout oeC;
        public ImageView oeD;
        public TextView oeE;
        public LinearLayout oeF;
        public ImageView oeG;
        public TextView oeH;
        public LinearLayout oeI;
        public ImageView oeJ;
        public TextView oeK;
        public LinearLayout oeL;
        ImageView oeM;
        public LinearLayout oeN;
        ImageView oeO;
        TextView oeP;
        public LinearLayout oeQ;
        ImageView oeR;
        TextView oeS;
        public OvalActionButton oeT;
        public GridLayout oeU;
        public View oep;
        public TBLottieAnimationView oeq;
        public View oey;
        public LinearLayout oez;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.oeC = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.oeD = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.oeE = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.oez = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.oeA = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.oeB = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.oeF = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.oeG = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.oeH = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.oeI = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.oeJ = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.oeK = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.oeL = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.oeM = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.fnE = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.oeN = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.oeO = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.oeP = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.oeQ = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.oeR = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.oeS = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.oeT = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.odN != null && "frs".equals(this.odN.getFrom())) {
                    this.oeT.setIsCircle(true);
                    this.oeT.setHasShadow(false);
                }
                this.oey = this.mRootView.findViewById(R.id.view_background_white);
                this.oep = this.mRootView.findViewById(R.id.view_background_translate);
                this.oeU = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.oeU.setMeasureAllChild(true);
                this.oeU.setVerNum(2);
                this.oeq = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.oeq.setSpeed(1.2f);
                dWB();
                this.oep.setOnClickListener(this.kbX);
                this.oep.setClickable(true);
                this.oeD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.odN != null) {
                            c.this.odN.Vs(c.this.odN.cLi());
                        }
                    }
                });
                this.oeA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.odN != null) {
                            c.this.odN.dWQ();
                        }
                    }
                });
                this.oeG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.odN != null) {
                            c.this.odN.dWP();
                        }
                    }
                });
                this.oeJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.odN != null) {
                            c.this.odN.dWO();
                        }
                    }
                });
                this.oeL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.odN != null) {
                            c.this.odN.Vr(c.this.odN.cLi());
                        }
                    }
                });
                this.oeN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.odN != null) {
                            c.this.odN.dWR();
                        }
                    }
                });
                this.oeQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.odN != null) {
                            c.this.odN.dWN();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cGg() {
            return LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void zr(boolean z) {
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.oeT.onChangeSkinType(i);
            ap.a(this.oeq, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.oey, R.drawable.write_tab_background);
            ap.setImageResource(this.oeA, R.drawable.icon_mask_post_photograph56);
            ap.setImageResource(this.oeD, R.drawable.icon_mask_post_text56);
            ap.setImageResource(this.oeG, R.drawable.icon_mask_post_image56);
            ap.setImageResource(this.oeJ, R.drawable.icon_mask_post_live56);
            ap.setImageResource(this.oeM, R.drawable.icon_mask_post_vote56);
            ap.setImageResource(this.oeO, R.drawable.icon_mask_post_evaluation56);
            ap.setImageResource(this.oeR, R.drawable.icon_mask_post_goods56);
            ap.setViewTextColor(this.oeB, R.color.CAM_X0107);
            ap.setViewTextColor(this.oeE, R.color.CAM_X0107);
            ap.setViewTextColor(this.oeH, R.color.CAM_X0107);
            ap.setViewTextColor(this.oeK, R.color.CAM_X0107);
            ap.setViewTextColor(this.fnE, R.color.CAM_X0107);
            ap.setViewTextColor(this.oeP, R.color.CAM_X0107);
            ap.setViewTextColor(this.oeS, R.color.CAM_X0107);
        }

        @Override // com.baidu.tieba.write.a
        public void dWB() {
            int equipmentWidth = l.getEquipmentWidth(this.eWx.getPageActivity());
            int i = (int) (0.13518518f * equipmentWidth);
            b(this.oeD, i);
            b(this.oeA, i);
            b(this.oeG, i);
            b(this.oeJ, i);
            b(this.oeM, i);
            b(this.oeO, i);
            b(this.oeR, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.oeU.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds423) * dimens);
                this.oeU.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.oey.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1023 : dimens2;
                this.oey.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.oeq.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.oeq.setLayoutParams(layoutParams3);
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
        public View eJb;
        public View epj;
        public View oep;
        public TBLottieAnimationView oeq;
        public RelativeLayout oer;
        public View oes;
        public View oet;
        public View oeu;
        public View oev;
        public View oew;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.oep = this.mRootView.findViewById(R.id.transparent_back_view);
            this.epj = this.mRootView.findViewById(R.id.view_background);
            this.oeq = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.oer = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.eJb = this.mRootView.findViewById(R.id.closeView);
            this.oes = this.mRootView.findViewById(R.id.publish_text_view);
            this.oet = this.mRootView.findViewById(R.id.publish_image_view);
            this.oeu = this.mRootView.findViewById(R.id.publish_video_view);
            this.oev = this.mRootView.findViewById(R.id.publish_ala_view);
            this.oew = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.epj.setOnClickListener(this.kbX);
            this.oer.setOnClickListener(this.kbX);
            this.eJb.setOnClickListener(this.kbX);
            this.oes.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.odN != null) {
                        b.this.odN.Vs(b.this.odN.cLi());
                    }
                }
            });
            this.oet.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.odN != null) {
                        b.this.odN.dWP();
                    }
                }
            });
            this.oeu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.odN != null) {
                        b.this.odN.dWQ();
                    }
                }
            });
            this.oev.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.odN != null) {
                        b.this.odN.dWO();
                    }
                }
            });
            zp(false);
            this.oeq.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cGg() {
            return LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.oeq, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.epj, R.color.CAM_X0502);
            ap.setBackgroundResource(this.oew, R.drawable.home_publish_ala_red_tip);
        }

        public void zp(boolean z) {
            this.epj.setClickable(z);
            this.oer.setClickable(z);
            this.eJb.setClickable(z);
            this.oes.setClickable(z);
            this.oet.setClickable(z);
            this.oeu.setClickable(z);
            this.oev.setClickable(z);
        }

        public void zq(boolean z) {
            if (this.oew != null) {
                if (z) {
                    this.oew.setVisibility(0);
                } else {
                    this.oew.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0904a extends a {
        public View epj;
        public LinearLayout odP;
        private LinearLayout odQ;
        private LinearLayout odR;
        private LinearLayout odS;
        private LinearLayout odT;
        private LinearLayout odU;
        private LinearLayout odV;
        private ImageView odW;
        private ImageView odX;
        private ImageView odY;
        private ImageView odZ;
        private ImageView oea;
        private ImageView oeb;
        private TextView oec;
        private TextView oed;
        private TextView oee;
        private TextView oef;
        private TextView oeg;
        private TextView oeh;
        private View oei;
        private View oej;
        private View oek;
        private View oel;
        private View oem;
        private int oen;

        public C0904a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.epj = this.mRootView.findViewById(R.id.view_background);
            this.odP = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.odQ = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.odW = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.oec = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.odR = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.odX = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.oed = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.odS = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.odY = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.oee = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.odT = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.odZ = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.oef = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.odU = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.oea = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.oeg = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.odV = (LinearLayout) this.mRootView.findViewById(R.id.thread_write_score);
            this.oeb = (ImageView) this.mRootView.findViewById(R.id.thread_write_score_iv);
            this.oeh = (TextView) this.mRootView.findViewById(R.id.thread_write_score_tv);
            this.oei = this.mRootView.findViewById(R.id.line_1);
            this.oej = this.mRootView.findViewById(R.id.line_2);
            this.oek = this.mRootView.findViewById(R.id.line_3);
            this.oel = this.mRootView.findViewById(R.id.line_4);
            this.oem = this.mRootView.findViewById(R.id.line_5);
            this.oec.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.oed.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.oee.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.oef.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.oeg.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.oeh.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.epj.setOnClickListener(this.kbX);
            this.odQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0904a.this.odN != null) {
                        C0904a.this.odN.Vs(C0904a.this.odN.cLi());
                    }
                }
            });
            this.odR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0904a.this.odN != null) {
                        C0904a.this.odN.dWP();
                    }
                }
            });
            this.odS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0904a.this.odN != null) {
                        C0904a.this.odN.dWQ();
                    }
                }
            });
            this.odT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0904a.this.odN != null) {
                        C0904a.this.odN.dWO();
                    }
                }
            });
            this.odU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0904a.this.odN != null) {
                        C0904a.this.odN.Vr(C0904a.this.odN.cLi());
                    }
                }
            });
            this.odV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0904a.this.odN != null) {
                        C0904a.this.odN.dWR();
                    }
                }
            });
            this.oen = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cGg() {
            return LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.epj, R.color.CAM_X0603);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oY(1).aj(this.oen).oQ(R.color.CAM_X0701).bv(this.odP);
            this.odW.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.odX.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.odY.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.odZ.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.oea.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            this.oeb.setImageDrawable(WebPManager.a(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.oec, R.color.CAM_X0101);
            ap.setViewTextColor(this.oed, R.color.CAM_X0101);
            ap.setViewTextColor(this.oee, R.color.CAM_X0101);
            ap.setViewTextColor(this.oef, R.color.CAM_X0101);
            ap.setViewTextColor(this.oeg, R.color.CAM_X0101);
            ap.setViewTextColor(this.oeh, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oY(1).al(this.oen).ak(this.oen).bv(this.odQ);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oY(1).bv(this.odR);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oY(1).bv(this.odS);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oY(1).bv(this.odT);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oY(1).an(this.oen).am(this.oen).bv(this.odU);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oY(1).an(this.oen).am(this.oen).bv(this.odV);
            ap.setBackgroundColor(this.oei, R.color.CAM_X0613);
            ap.setBackgroundColor(this.oej, R.color.CAM_X0613);
            ap.setBackgroundColor(this.oek, R.color.CAM_X0613);
            ap.setBackgroundColor(this.oel, R.color.CAM_X0613);
            ap.setBackgroundColor(this.oem, R.color.CAM_X0613);
        }
    }
}
