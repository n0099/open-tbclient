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
    public int aKu;
    private TBLottieAnimationView ajt;
    public TextView hGx;
    public ImageView jJY;
    public boolean lqw;
    public TextView lrA;
    public TextView lrB;
    public TextView lrC;
    public AgreeView lrD;
    public HeadImageView lrE;
    public TbRichTextView lrF;
    public ConstrainImageGroup lrG;
    public View lrH;
    public SubPbLayout lrI;
    public TextView lrJ;
    public TextView lrK;
    public ImageView lrL;
    public View lrM;
    public View lrN;
    public View lrO;
    public View lrP;
    public ImageView lrQ;
    public TextView lrR;
    public ImageView lrS;
    public TextView lrT;
    public AgreeView lrU;
    public TextView lrV;
    public ImageView lrW;
    public HeadPendantView lrX;
    public UserIconBox lrY;
    public UserIconBox lrZ;
    public View lrx;
    public TextView lry;
    public TextView lrz;
    public ImageView lsa;
    public TextView lsb;
    public LinearLayout lsc;
    public TextView lsd;
    public View lse;
    public TextView lsf;
    public ImageView lsg;
    public LinearLayout lsh;
    public LinearLayout lsi;
    public TextView lsj;
    public ImageView lsk;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.lqw = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.lrx = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.hGx = (TextView) view.findViewById(R.id.view_user_name);
            this.lry = (TextView) view.findViewById(R.id.view_author_tip);
            this.lrz = (TextView) view.findViewById(R.id.view_post_time);
            this.lrW = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.lrC = (TextView) view.findViewById(R.id.view_location);
            this.lrH = view.findViewById(R.id.pb_post_reply_container);
            this.lrL = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jJY = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.lrD = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.lrD.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lrD.setNormalColorResourceId(R.color.cp_cont_d);
            this.lrD.ji(false);
            this.lrM = view.findViewById(R.id.pb_floor_trisection_area);
            this.lrN = view.findViewById(R.id.pb_floor_share_container);
            this.lrO = view.findViewById(R.id.pb_floor_comment_container);
            this.lrP = view.findViewById(R.id.pb_floor_agree_container);
            this.lrQ = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.lrR = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.lrS = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.lrT = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.lrU = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.lrU.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lrU.setNormalColorResourceId(R.color.cp_cont_d);
            this.lrU.ji(true);
            if (z && z2) {
                this.lrH.setVisibility(8);
                this.lrM.setVisibility(0);
            } else if (z) {
                this.lrM.setVisibility(0);
                this.lrH.setVisibility(0);
                this.lrL.setVisibility(8);
                this.jJY.setVisibility(8);
                this.lrD.setVisibility(8);
            } else {
                this.lrM.setVisibility(8);
                this.lrH.setVisibility(0);
                this.lrL.setVisibility(0);
                this.jJY.setVisibility(0);
                this.lrD.setVisibility(0);
            }
            this.lsa = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aKu = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.ezt = 5;
            cVar.ezz = 8;
            cVar.ezy = 2;
            cVar.ezx = i;
            this.lrD.setStatisticData(cVar);
            this.lrE = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.lrX = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.lrX.setHasPendantStyle();
            if (this.lrX.getHeadView() != null) {
                this.lrX.getHeadView().setIsRound(true);
                this.lrX.getHeadView().setDrawBorder(false);
                this.lrX.getHeadView().setPlaceHolder(1);
            }
            this.lrY = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.lrZ = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.lrF = (TbRichTextView) view.findViewById(R.id.richText);
            this.lrI = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.lrJ = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.lrJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.lrJ.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.lrJ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.lrK = (TextView) view.findViewById(R.id.pb_post_reply);
            this.lrG = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.lrV = (TextView) view.findViewById(R.id.floor_num);
            this.lrA = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.lrB = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.lrG.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.lrG.setSingleImageRatio(0.75d);
            this.lrG.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.lrF.getLayoutStrategy());
            cVar2.sw(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.lrF.setLayoutStrategy(cVar2);
            this.lrF.setTextSize(TbConfig.getContentSize());
            this.lrE.setIsRound(true);
            this.lrE.setGodIconWidth(R.dimen.tbds31);
            this.lrE.setPlaceHolder(1);
            this.lrF.setDisplayImage(this.lqw, false);
            this.lrF.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lsb = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lsc = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lsd = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lse = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lsf = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lsg = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lsh = (LinearLayout) view.findViewById(R.id.all_content);
            this.lsi = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lsj = (TextView) view.findViewById(R.id.fold_title);
            this.lsk = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.ajt = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        }
    }

    public void uf(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.ezt = 12;
            cVar.ezz = 9;
            cVar.ezy = 3;
            cVar.ezx = this.aKu;
            this.lrD.setStatisticData(cVar);
        }
    }

    public void sK(boolean z) {
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

    public void DP(int i) {
        if (i == 1) {
            this.ajt.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ajt.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ajt.setAnimation("live/card_live_bg.json");
        }
    }
}
