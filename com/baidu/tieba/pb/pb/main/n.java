package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
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
/* loaded from: classes22.dex */
public class n extends af.a {
    public int aJu;
    private TBLottieAnimationView ajt;
    public TextView hAA;
    public ImageView jEa;
    public boolean lkv;
    public TextView llA;
    public TextView llB;
    public AgreeView llC;
    public HeadImageView llD;
    public TbRichTextView llE;
    public ConstrainImageGroup llF;
    public View llG;
    public SubPbLayout llH;
    public TextView llI;
    public TextView llJ;
    public ImageView llK;
    public View llL;
    public View llM;
    public View llN;
    public View llO;
    public ImageView llP;
    public TextView llQ;
    public ImageView llR;
    public TextView llS;
    public AgreeView llT;
    public TextView llU;
    public ImageView llV;
    public HeadPendantView llW;
    public UserIconBox llX;
    public UserIconBox llY;
    public ImageView llZ;
    public View llw;
    public TextView llx;
    public TextView lly;
    public TextView llz;
    public TextView lma;
    public LinearLayout lmb;
    public TextView lmc;
    public View lmd;
    public TextView lme;
    public ImageView lmf;
    public LinearLayout lmg;
    public LinearLayout lmh;
    public TextView lmi;
    public ImageView lmj;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.lkv = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.llw = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.hAA = (TextView) view.findViewById(R.id.view_user_name);
            this.llx = (TextView) view.findViewById(R.id.view_author_tip);
            this.lly = (TextView) view.findViewById(R.id.view_post_time);
            this.llV = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.llB = (TextView) view.findViewById(R.id.view_location);
            this.llG = view.findViewById(R.id.pb_post_reply_container);
            this.llK = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jEa = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.llC = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.llC.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.llC.setNormalColorResourceId(R.color.cp_cont_d);
            this.llC.iZ(false);
            this.llL = view.findViewById(R.id.pb_floor_trisection_area);
            this.llM = view.findViewById(R.id.pb_floor_share_container);
            this.llN = view.findViewById(R.id.pb_floor_comment_container);
            this.llO = view.findViewById(R.id.pb_floor_agree_container);
            this.llP = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.llQ = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.llR = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.llS = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.llT = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.llT.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.llT.setNormalColorResourceId(R.color.cp_cont_d);
            this.llT.iZ(true);
            if (z && z2) {
                this.llG.setVisibility(8);
                this.llL.setVisibility(0);
            } else if (z) {
                this.llL.setVisibility(0);
                this.llG.setVisibility(0);
                this.llK.setVisibility(8);
                this.jEa.setVisibility(8);
                this.llC.setVisibility(8);
            } else {
                this.llL.setVisibility(8);
                this.llG.setVisibility(0);
                this.llK.setVisibility(0);
                this.jEa.setVisibility(0);
                this.llC.setVisibility(0);
            }
            this.llZ = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aJu = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.etA = 5;
            cVar.etG = 8;
            cVar.etF = 2;
            cVar.etE = i;
            this.llC.setStatisticData(cVar);
            this.llD = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.llW = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.llW.setHasPendantStyle();
            if (this.llW.getHeadView() != null) {
                this.llW.getHeadView().setIsRound(true);
                this.llW.getHeadView().setDrawBorder(false);
                this.llW.getHeadView().setPlaceHolder(1);
            }
            this.llX = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.llY = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.llE = (TbRichTextView) view.findViewById(R.id.richText);
            this.llH = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.llI = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.llI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.llI.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.llI.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.llJ = (TextView) view.findViewById(R.id.pb_post_reply);
            this.llF = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.llU = (TextView) view.findViewById(R.id.floor_num);
            this.llz = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.llA = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.llF.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.llF.setSingleImageRatio(0.75d);
            this.llF.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.llE.getLayoutStrategy());
            cVar2.sm(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.llE.setLayoutStrategy(cVar2);
            this.llE.setTextSize(TbConfig.getContentSize());
            this.llD.setIsRound(true);
            this.llD.setGodIconWidth(R.dimen.tbds31);
            this.llD.setPlaceHolder(1);
            this.llE.setDisplayImage(this.lkv, false);
            this.llE.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lma = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lmb = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lmc = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lmd = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lme = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lmf = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lmg = (LinearLayout) view.findViewById(R.id.all_content);
            this.lmh = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lmi = (TextView) view.findViewById(R.id.fold_title);
            this.lmj = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.ajt = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        }
    }

    public void tW(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.etA = 12;
            cVar.etG = 9;
            cVar.etF = 3;
            cVar.etE = this.aJu;
            this.llC.setStatisticData(cVar);
        }
    }

    public void sB(boolean z) {
        if (z) {
            this.ajt.setVisibility(0);
            if (!this.ajt.isAnimating()) {
                this.ajt.setSpeed(0.8f);
                this.ajt.setRepeatCount(-1);
                this.ajt.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.ajt.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ajt.setVisibility(8);
        if (this.ajt.isAnimating()) {
            this.ajt.cancelAnimation();
        }
    }

    public void DC(int i) {
        if (i == 1) {
            this.ajt.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ajt.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ajt.setAnimation("live/card_live_bg.json");
        }
    }
}
