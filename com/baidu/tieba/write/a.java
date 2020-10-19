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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a {
    protected TbPageContext etO;
    public View.OnClickListener jcS = new View.OnClickListener() { // from class: com.baidu.tieba.write.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.nkq != null) {
                if (a.this.nkq.getBgColor() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.etO.getPageActivity(), a.this.nkq.getBgColor());
                }
                a.this.nkq.xS(true);
            }
        }
    };
    protected View mRootView = cvZ();
    protected g nkq;

    public abstract View cvZ();

    public a(TbPageContext tbPageContext, g gVar) {
        this.etO = tbPageContext;
        this.nkq = gVar;
    }

    public void onChangeSkinType(int i) {
    }

    public void dNh() {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        TextView eJZ;
        public View nkO;
        public TBLottieAnimationView nkP;
        public View nkX;
        public LinearLayout nkY;
        public ImageView nkZ;
        public TextView nla;
        public LinearLayout nlb;
        public ImageView nlc;
        public TextView nld;
        public LinearLayout nle;
        public ImageView nlf;
        public TextView nlg;
        public LinearLayout nlh;
        public ImageView nli;
        public TextView nlj;
        public LinearLayout nlk;
        ImageView nll;
        public LinearLayout nlm;
        ImageView nln;
        TextView nlo;
        public LinearLayout nlp;
        ImageView nlq;
        TextView nlr;
        public OvalActionButton nls;
        public GridLayout nlt;

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext != null) {
                this.nlb = (LinearLayout) this.mRootView.findViewById(R.id.home_write_article);
                this.nlc = (ImageView) this.mRootView.findViewById(R.id.home_write_article_icon);
                this.nld = (TextView) this.mRootView.findViewById(R.id.home_write_article_title);
                this.nkY = (LinearLayout) this.mRootView.findViewById(R.id.home_write_photo);
                this.nkZ = (ImageView) this.mRootView.findViewById(R.id.home_write_photo_icon);
                this.nla = (TextView) this.mRootView.findViewById(R.id.home_write_photo_title);
                this.nle = (LinearLayout) this.mRootView.findViewById(R.id.home_write_album);
                this.nlf = (ImageView) this.mRootView.findViewById(R.id.home_write_album_icon);
                this.nlg = (TextView) this.mRootView.findViewById(R.id.home_write_album_title);
                this.nlh = (LinearLayout) this.mRootView.findViewById(R.id.home_write_live);
                this.nli = (ImageView) this.mRootView.findViewById(R.id.home_write_live_icon);
                this.nlj = (TextView) this.mRootView.findViewById(R.id.home_write_live_title);
                this.nlk = (LinearLayout) this.mRootView.findViewById(R.id.home_write_vote);
                this.nll = (ImageView) this.mRootView.findViewById(R.id.home_write_vote_icon);
                this.eJZ = (TextView) this.mRootView.findViewById(R.id.home_write_vote_title);
                this.nlm = (LinearLayout) this.mRootView.findViewById(R.id.home_write_score);
                this.nln = (ImageView) this.mRootView.findViewById(R.id.home_write_score_icon);
                this.nlo = (TextView) this.mRootView.findViewById(R.id.home_write_score_title);
                this.nlp = (LinearLayout) this.mRootView.findViewById(R.id.home_write_commodity);
                this.nlq = (ImageView) this.mRootView.findViewById(R.id.home_write_commodity_icon);
                this.nlr = (TextView) this.mRootView.findViewById(R.id.home_write_commodity_title);
                this.nls = (OvalActionButton) this.mRootView.findViewById(R.id.write_close_view);
                if (this.nkq != null && "frs".equals(this.nkq.getFrom())) {
                    this.nls.setIsCircle(true);
                    this.nls.setHasShadow(false);
                }
                this.nkX = this.mRootView.findViewById(R.id.view_background_white);
                this.nkO = this.mRootView.findViewById(R.id.view_background_translate);
                this.nlt = (GridLayout) this.mRootView.findViewById(R.id.type_container);
                this.nlt.setMeasureAllChild(true);
                this.nlt.setVerNum(2);
                this.nkP = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
                this.nkP.setSpeed(1.2f);
                dNh();
                this.nkO.setOnClickListener(this.jcS);
                this.nkO.setClickable(true);
                this.nlc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nkq != null) {
                            c.this.nkq.TO(c.this.nkq.czW());
                        }
                    }
                });
                this.nkZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nkq != null) {
                            c.this.nkq.dNy();
                        }
                    }
                });
                this.nlf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nkq != null) {
                            c.this.nkq.dNx();
                        }
                    }
                });
                this.nli.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nkq != null) {
                            c.this.nkq.dNw();
                        }
                    }
                });
                this.nlk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nkq != null) {
                            c.this.nkq.TN(c.this.nkq.czW());
                        }
                    }
                });
                this.nlm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nkq != null) {
                            c.this.nkq.dNu();
                        }
                    }
                });
                this.nlp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.c.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.nkq != null) {
                            c.this.nkq.dNv();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.write.a
        public View cvZ() {
            return LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        public void xO(boolean z) {
            this.nlm.setVisibility(z ? 0 : 8);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            this.nls.onChangeSkinType(i);
            ap.a(this.nkP, R.raw.bottom_bar_bg);
            ap.setBackgroundResource(this.nkX, R.drawable.write_tab_background);
            this.nkZ.setImageDrawable(SvgManager.bmU().j(R.drawable.ic_icon_post_photograph60_svg, 1, true));
            this.nlc.setImageDrawable(SvgManager.bmU().j(R.drawable.ic_icon_post_text60_svg, 1, true));
            this.nlf.setImageDrawable(SvgManager.bmU().j(R.drawable.ic_icon_post_image60_svg, 1, true));
            this.nli.setImageDrawable(SvgManager.bmU().j(R.drawable.ic_icon_post_live60_svg, 1, true));
            this.nll.setImageDrawable(SvgManager.bmU().j(R.drawable.ic_icon_post_vote60_svg, 1, true));
            this.nln.setImageDrawable(SvgManager.bmU().j(R.drawable.ic_icon_post_evaluation60_svg, 1, true));
            ap.setImageResource(this.nlq, R.drawable.icon_post_haowu60);
            ap.setViewTextColor(this.nla, R.color.cp_cont_b);
            ap.setViewTextColor(this.nld, R.color.cp_cont_b);
            ap.setViewTextColor(this.nlg, R.color.cp_cont_b);
            ap.setViewTextColor(this.nlj, R.color.cp_cont_b);
            ap.setViewTextColor(this.eJZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.nlo, R.color.cp_cont_b);
            ap.setViewTextColor(this.nlr, R.color.cp_cont_b);
        }

        @Override // com.baidu.tieba.write.a
        public void dNh() {
            int equipmentWidth = l.getEquipmentWidth(this.etO.getPageActivity());
            int i = (int) (0.14537036f * equipmentWidth);
            b(this.nlc, i);
            b(this.nkZ, i);
            b(this.nlf, i);
            b(this.nli, i);
            b(this.nll, i);
            b(this.nln, i);
            b(this.nlq, i);
            float dimens = (equipmentWidth * 1.0f) / l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.nlt.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds455) * dimens);
                this.nlt.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.nkX.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int dimens2 = (int) (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1144) * dimens);
                ((RelativeLayout.LayoutParams) layoutParams2).height = dimens2 <= 0 ? 1144 : dimens2;
                this.nkX.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.nkP.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((dimens * l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds800)) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds135) * dimens) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.nkP.setLayoutParams(layoutParams3);
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
        public View dNE;
        public View egS;
        public View nkO;
        public TBLottieAnimationView nkP;
        public RelativeLayout nkQ;
        public View nkR;
        public View nkS;
        public View nkT;
        public View nkU;
        public View nkV;

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.nkO = this.mRootView.findViewById(R.id.transparent_back_view);
            this.dNE = this.mRootView.findViewById(R.id.view_background);
            this.nkP = (TBLottieAnimationView) this.mRootView.findViewById(R.id.bottom_bar_background);
            this.nkQ = (RelativeLayout) this.mRootView.findViewById(R.id.type_container);
            this.egS = this.mRootView.findViewById(R.id.closeView);
            this.nkR = this.mRootView.findViewById(R.id.publish_text_view);
            this.nkS = this.mRootView.findViewById(R.id.publish_image_view);
            this.nkT = this.mRootView.findViewById(R.id.publish_video_view);
            this.nkU = this.mRootView.findViewById(R.id.publish_ala_view);
            this.nkV = this.mRootView.findViewById(R.id.publish_ala_view_tip);
            this.dNE.setOnClickListener(this.jcS);
            this.nkQ.setOnClickListener(this.jcS);
            this.egS.setOnClickListener(this.jcS);
            this.nkR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nkq != null) {
                        b.this.nkq.TO(b.this.nkq.czW());
                    }
                }
            });
            this.nkS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nkq != null) {
                        b.this.nkq.dNx();
                    }
                }
            });
            this.nkT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nkq != null) {
                        b.this.nkq.dNy();
                    }
                }
            });
            this.nkU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nkq != null) {
                        b.this.nkq.dNw();
                    }
                }
            });
            xM(false);
            this.nkP.setSpeed(1.4f);
        }

        @Override // com.baidu.tieba.write.a
        public View cvZ() {
            return LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            ap.a(this.nkP, R.raw.lottie_use_publish_n);
            ap.setBackgroundResource(this.dNE, R.color.cp_mask_d);
            ap.setBackgroundResource(this.nkV, R.drawable.home_publish_ala_red_tip);
        }

        public void xM(boolean z) {
            this.dNE.setClickable(z);
            this.nkQ.setClickable(z);
            this.egS.setClickable(z);
            this.nkR.setClickable(z);
            this.nkS.setClickable(z);
            this.nkT.setClickable(z);
            this.nkU.setClickable(z);
        }

        public void xN(boolean z) {
            if (this.nkV != null) {
                if (z) {
                    this.nkV.setVisibility(0);
                } else {
                    this.nkV.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0841a extends a {
        public View dNE;
        private ImageView nkA;
        private ImageView nkB;
        private ImageView nkC;
        private TextView nkD;
        private TextView nkE;
        private TextView nkF;
        private TextView nkG;
        private TextView nkH;
        private View nkI;
        private View nkJ;
        private View nkK;
        private View nkL;
        private int nkM;
        public LinearLayout nks;
        private LinearLayout nkt;
        private LinearLayout nku;
        private LinearLayout nkv;
        private LinearLayout nkw;
        private LinearLayout nkx;
        private ImageView nky;
        private ImageView nkz;

        public C0841a(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.dNE = this.mRootView.findViewById(R.id.view_background);
            this.nks = (LinearLayout) this.mRootView.findViewById(R.id.type_container);
            this.nkt = (LinearLayout) this.mRootView.findViewById(R.id.thread_text);
            this.nky = (ImageView) this.mRootView.findViewById(R.id.thread_text_iv);
            this.nkD = (TextView) this.mRootView.findViewById(R.id.thread_text_tv);
            this.nku = (LinearLayout) this.mRootView.findViewById(R.id.thread_pic);
            this.nkz = (ImageView) this.mRootView.findViewById(R.id.thread_pic_iv);
            this.nkE = (TextView) this.mRootView.findViewById(R.id.thread_pic_tv);
            this.nkv = (LinearLayout) this.mRootView.findViewById(R.id.thread_video);
            this.nkA = (ImageView) this.mRootView.findViewById(R.id.thread_video_iv);
            this.nkF = (TextView) this.mRootView.findViewById(R.id.thread_video_tv);
            this.nkw = (LinearLayout) this.mRootView.findViewById(R.id.thread_ala);
            this.nkB = (ImageView) this.mRootView.findViewById(R.id.thread_ala_iv);
            this.nkG = (TextView) this.mRootView.findViewById(R.id.thread_ala_tv);
            this.nkx = (LinearLayout) this.mRootView.findViewById(R.id.thread_vote);
            this.nkC = (ImageView) this.mRootView.findViewById(R.id.thread_vote_iv);
            this.nkH = (TextView) this.mRootView.findViewById(R.id.thread_vote_tv);
            this.nkI = this.mRootView.findViewById(R.id.line_1);
            this.nkJ = this.mRootView.findViewById(R.id.line_2);
            this.nkK = this.mRootView.findViewById(R.id.line_3);
            this.nkL = this.mRootView.findViewById(R.id.line_4);
            this.nkD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.nkE.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.nkF.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.nkG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.nkH.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.dNE.setOnClickListener(this.jcS);
            this.nkt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0841a.this.nkq != null) {
                        C0841a.this.nkq.TO(C0841a.this.nkq.czW());
                    }
                }
            });
            this.nku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0841a.this.nkq != null) {
                        C0841a.this.nkq.dNx();
                    }
                }
            });
            this.nkv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0841a.this.nkq != null) {
                        C0841a.this.nkq.dNy();
                    }
                }
            });
            this.nkw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0841a.this.nkq != null) {
                        C0841a.this.nkq.dNw();
                    }
                }
            });
            this.nkx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0841a.this.nkq != null) {
                        C0841a.this.nkq.TN(C0841a.this.nkq.czW());
                    }
                }
            });
            this.nkM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.write.a
        public View cvZ() {
            return LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // com.baidu.tieba.write.a
        public void onChangeSkinType(int i) {
            super.onChangeSkinType(i);
            ap.setBackgroundColor(this.dNE, R.color.cp_mask_b_alpha16);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).oV(1).X(this.nkM).oP(R.color.cp_bg_line_i).bf(this.nks);
            SvgManager.bmU().a(this.nky, R.drawable.ic_icon_mask_send_word16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bmU().a(this.nkz, R.drawable.ic_icon_mask_send_pic16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bmU().a(this.nkA, R.drawable.ic_icon_mask_send_video16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bmU().a(this.nkB, R.drawable.ic_icon_mask_send_live16, SvgManager.SvgResourceStateType.NORMAL);
            this.nkC.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_toupiao16, WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.nkD, R.color.cp_cont_b);
            ap.setViewTextColor(this.nkE, R.color.cp_cont_b);
            ap.setViewTextColor(this.nkF, R.color.cp_cont_b);
            ap.setViewTextColor(this.nkG, R.color.cp_cont_b);
            ap.setViewTextColor(this.nkH, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).oV(1).oR(R.color.cp_bg_line_c).oP(R.color.cp_bg_line_i).Z(this.nkM).Y(this.nkM).bf(this.nkt);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).oV(1).oR(R.color.cp_bg_line_c).oP(R.color.cp_bg_line_i).bf(this.nku);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).oV(1).oR(R.color.cp_bg_line_c).oP(R.color.cp_bg_line_i).bf(this.nkv);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).oV(1).oR(R.color.cp_bg_line_c).oP(R.color.cp_bg_line_i).bf(this.nkw);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).oV(1).oR(R.color.cp_bg_line_c).oP(R.color.cp_bg_line_i).ab(this.nkM).aa(this.nkM).bf(this.nkx);
            ap.setBackgroundColor(this.nkI, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.nkJ, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.nkK, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.nkL, R.color.cp_bg_line_b);
        }
    }
}
