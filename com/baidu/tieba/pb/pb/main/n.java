package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes16.dex */
public class n extends ad.a {
    private TBLottieAnimationView ahq;
    public int azq;
    public TextView gJq;
    public ImageView iEP;
    public boolean kkN;
    public View klN;
    public TextView klO;
    public TextView klP;
    public TextView klQ;
    public TextView klR;
    public TextView klS;
    public AgreeView klT;
    public HeadImageView klU;
    public TbRichTextView klV;
    public ConstrainImageGroup klW;
    public View klX;
    public SubPbLayout klY;
    public TextView klZ;
    public ImageView kmA;
    public TextView kma;
    public ImageView kmb;
    public View kmc;
    public View kmd;
    public View kme;
    public View kmf;
    public ImageView kmg;
    public TextView kmh;
    public ImageView kmi;
    public TextView kmj;
    public AgreeView kmk;
    public TextView kml;
    public ImageView kmm;
    public HeadPendantView kmn;
    public UserIconBox kmo;
    public UserIconBox kmp;
    public ImageView kmq;
    public TextView kmr;
    public LinearLayout kms;
    public TextView kmt;
    public View kmu;
    public TextView kmv;
    public ImageView kmw;
    public LinearLayout kmx;
    public LinearLayout kmy;
    public TextView kmz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.kkN = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.klN = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.gJq = (TextView) view.findViewById(R.id.view_user_name);
            this.klO = (TextView) view.findViewById(R.id.view_author_tip);
            this.klP = (TextView) view.findViewById(R.id.view_post_time);
            this.kmm = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.klS = (TextView) view.findViewById(R.id.view_location);
            this.klX = view.findViewById(R.id.pb_post_reply_container);
            this.kmb = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.iEP = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.klT = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.klT.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.klT.setNormalColorResourceId(R.color.cp_cont_d);
            this.klT.hT(false);
            this.kmc = view.findViewById(R.id.pb_floor_trisection_area);
            this.kmd = view.findViewById(R.id.pb_floor_share_container);
            this.kme = view.findViewById(R.id.pb_floor_comment_container);
            this.kmf = view.findViewById(R.id.pb_floor_agree_container);
            this.kmg = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.kmh = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.kmi = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.kmj = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.kmk = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.kmk.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.kmk.setNormalColorResourceId(R.color.cp_cont_d);
            this.kmk.hT(true);
            if (z && z2) {
                this.klX.setVisibility(8);
                this.kmc.setVisibility(0);
            } else if (z) {
                this.kmc.setVisibility(0);
                this.klX.setVisibility(0);
                this.kmb.setVisibility(8);
                this.iEP.setVisibility(8);
                this.klT.setVisibility(8);
            } else {
                this.kmc.setVisibility(8);
                this.klX.setVisibility(0);
                this.kmb.setVisibility(0);
                this.iEP.setVisibility(0);
                this.klT.setVisibility(0);
            }
            this.kmq = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.azq = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dNB = 5;
            cVar.dNH = 8;
            cVar.dNG = 2;
            cVar.dNF = i;
            this.klT.setStatisticData(cVar);
            this.klU = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.kmn = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.kmn.setHasPendantStyle();
            if (this.kmn.getHeadView() != null) {
                this.kmn.getHeadView().setIsRound(true);
                this.kmn.getHeadView().setDrawBorder(false);
                this.kmn.getHeadView().setPlaceHolder(1);
            }
            this.kmo = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.kmp = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.klV = (TbRichTextView) view.findViewById(R.id.richText);
            this.klY = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.klZ = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.klZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.klZ.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.klZ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.kma = (TextView) view.findViewById(R.id.pb_post_reply);
            this.klW = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.kml = (TextView) view.findViewById(R.id.floor_num);
            this.klQ = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.klR = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.klW.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.klW.setSingleImageRatio(0.75d);
            this.klW.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.klV.getLayoutStrategy());
            cVar2.pa(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.klV.setLayoutStrategy(cVar2);
            this.klV.setTextSize(TbConfig.getContentSize());
            this.klU.setIsRound(true);
            this.klU.setGodIconWidth(R.dimen.tbds31);
            this.klU.setPlaceHolder(1);
            this.klV.setDisplayImage(this.kkN, false);
            this.klV.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.kmr = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.kms = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.kmt = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.kmu = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.kmv = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.kmw = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.kmx = (LinearLayout) view.findViewById(R.id.all_content);
            this.kmy = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.kmz = (TextView) view.findViewById(R.id.fold_title);
            this.kmA = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.ahq = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        }
    }

    public void si(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dNB = 12;
            cVar.dNH = 9;
            cVar.dNG = 3;
            cVar.dNF = this.azq;
            this.klT.setStatisticData(cVar);
        }
    }

    public void qN(boolean z) {
        if (z) {
            this.ahq.setVisibility(0);
            if (!this.ahq.isAnimating()) {
                this.ahq.setSpeed(0.8f);
                this.ahq.setRepeatCount(-1);
                this.ahq.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.ahq.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ahq.setVisibility(8);
        if (this.ahq.isAnimating()) {
            this.ahq.cancelAnimation();
        }
    }

    public void zJ(int i) {
        if (i == 1) {
            this.ahq.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ahq.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ahq.setAnimation("live/card_live_bg.json");
        }
    }
}
