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
    public ImageView iER;
    public boolean kkP;
    public View klP;
    public TextView klQ;
    public TextView klR;
    public TextView klS;
    public TextView klT;
    public TextView klU;
    public AgreeView klV;
    public HeadImageView klW;
    public TbRichTextView klX;
    public ConstrainImageGroup klY;
    public View klZ;
    public LinearLayout kmA;
    public TextView kmB;
    public ImageView kmC;
    public SubPbLayout kma;
    public TextView kmb;
    public TextView kmc;
    public ImageView kmd;
    public View kme;
    public View kmf;
    public View kmg;
    public View kmh;
    public ImageView kmi;
    public TextView kmj;
    public ImageView kmk;
    public TextView kml;
    public AgreeView kmm;
    public TextView kmn;
    public ImageView kmo;
    public HeadPendantView kmp;
    public UserIconBox kmq;
    public UserIconBox kmr;
    public ImageView kms;
    public TextView kmt;
    public LinearLayout kmu;
    public TextView kmv;
    public View kmw;
    public TextView kmx;
    public ImageView kmy;
    public LinearLayout kmz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.kkP = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.klP = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.gJq = (TextView) view.findViewById(R.id.view_user_name);
            this.klQ = (TextView) view.findViewById(R.id.view_author_tip);
            this.klR = (TextView) view.findViewById(R.id.view_post_time);
            this.kmo = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.klU = (TextView) view.findViewById(R.id.view_location);
            this.klZ = view.findViewById(R.id.pb_post_reply_container);
            this.kmd = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.iER = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.klV = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.klV.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.klV.setNormalColorResourceId(R.color.cp_cont_d);
            this.klV.hT(false);
            this.kme = view.findViewById(R.id.pb_floor_trisection_area);
            this.kmf = view.findViewById(R.id.pb_floor_share_container);
            this.kmg = view.findViewById(R.id.pb_floor_comment_container);
            this.kmh = view.findViewById(R.id.pb_floor_agree_container);
            this.kmi = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.kmj = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.kmk = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.kml = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.kmm = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.kmm.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.kmm.setNormalColorResourceId(R.color.cp_cont_d);
            this.kmm.hT(true);
            if (z && z2) {
                this.klZ.setVisibility(8);
                this.kme.setVisibility(0);
            } else if (z) {
                this.kme.setVisibility(0);
                this.klZ.setVisibility(0);
                this.kmd.setVisibility(8);
                this.iER.setVisibility(8);
                this.klV.setVisibility(8);
            } else {
                this.kme.setVisibility(8);
                this.klZ.setVisibility(0);
                this.kmd.setVisibility(0);
                this.iER.setVisibility(0);
                this.klV.setVisibility(0);
            }
            this.kms = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.azq = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dNB = 5;
            cVar.dNH = 8;
            cVar.dNG = 2;
            cVar.dNF = i;
            this.klV.setStatisticData(cVar);
            this.klW = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.kmp = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.kmp.setHasPendantStyle();
            if (this.kmp.getHeadView() != null) {
                this.kmp.getHeadView().setIsRound(true);
                this.kmp.getHeadView().setDrawBorder(false);
                this.kmp.getHeadView().setPlaceHolder(1);
            }
            this.kmq = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.kmr = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.klX = (TbRichTextView) view.findViewById(R.id.richText);
            this.kma = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.kmb = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.kmb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.kmb.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.kmb.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.kmc = (TextView) view.findViewById(R.id.pb_post_reply);
            this.klY = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.kmn = (TextView) view.findViewById(R.id.floor_num);
            this.klS = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.klT = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.klY.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.klY.setSingleImageRatio(0.75d);
            this.klY.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.klX.getLayoutStrategy());
            cVar2.pa(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.klX.setLayoutStrategy(cVar2);
            this.klX.setTextSize(TbConfig.getContentSize());
            this.klW.setIsRound(true);
            this.klW.setGodIconWidth(R.dimen.tbds31);
            this.klW.setPlaceHolder(1);
            this.klX.setDisplayImage(this.kkP, false);
            this.klX.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.kmt = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.kmu = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.kmv = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.kmw = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.kmx = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.kmy = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.kmz = (LinearLayout) view.findViewById(R.id.all_content);
            this.kmA = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.kmB = (TextView) view.findViewById(R.id.fold_title);
            this.kmC = (ImageView) view.findViewById(R.id.pic_comment_god);
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
            this.klV.setStatisticData(cVar);
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
