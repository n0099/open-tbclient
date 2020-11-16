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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes21.dex */
public class n extends af.a {
    public int aIJ;
    private TBLottieAnimationView ajy;
    public TextView hGe;
    public ImageView jKJ;
    public boolean lqL;
    public View lrN;
    public TextView lrO;
    public TextView lrP;
    public TextView lrQ;
    public TextView lrR;
    public TextView lrS;
    public AgreeView lrT;
    public HeadImageView lrU;
    public TbRichTextView lrV;
    public ConstrainImageGroup lrW;
    public View lrX;
    public SubPbLayout lrY;
    public TextView lrZ;
    public ImageView lsA;
    public TextView lsa;
    public ImageView lsb;
    public View lsc;
    public View lsd;
    public View lse;
    public View lsf;
    public ImageView lsg;
    public TextView lsh;
    public ImageView lsi;
    public TextView lsj;
    public AgreeView lsk;
    public TextView lsl;
    public ImageView lsm;
    public HeadPendantView lsn;
    public UserIconBox lso;
    public UserIconBox lsp;
    public ImageView lsq;
    public TextView lsr;
    public LinearLayout lss;
    public TextView lst;
    public View lsu;
    public TextView lsv;
    public ImageView lsw;
    public LinearLayout lsx;
    public LinearLayout lsy;
    public TextView lsz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.lqL = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.lrN = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.hGe = (TextView) view.findViewById(R.id.view_user_name);
            this.lrO = (TextView) view.findViewById(R.id.view_author_tip);
            this.lrP = (TextView) view.findViewById(R.id.view_post_time);
            this.lsm = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.lrS = (TextView) view.findViewById(R.id.view_location);
            this.lrX = view.findViewById(R.id.pb_post_reply_container);
            this.lsb = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jKJ = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.lrT = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.lrT.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lrT.setNormalColorResourceId(R.color.CAM_X0109);
            this.lrT.jj(false);
            this.lsc = view.findViewById(R.id.pb_floor_trisection_area);
            this.lsd = view.findViewById(R.id.pb_floor_share_container);
            this.lse = view.findViewById(R.id.pb_floor_comment_container);
            this.lsf = view.findViewById(R.id.pb_floor_agree_container);
            this.lsg = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.lsh = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.lsi = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.lsj = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.lsk = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.lsk.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lsk.setNormalColorResourceId(R.color.CAM_X0109);
            this.lsk.jj(true);
            if (z && z2) {
                this.lrX.setVisibility(8);
                this.lsc.setVisibility(0);
            } else if (z) {
                this.lsc.setVisibility(0);
                this.lrX.setVisibility(0);
                this.lsb.setVisibility(8);
                this.jKJ.setVisibility(8);
                this.lrT.setVisibility(8);
            } else {
                this.lsc.setVisibility(8);
                this.lrX.setVisibility(0);
                this.lsb.setVisibility(0);
                this.jKJ.setVisibility(0);
                this.lrT.setVisibility(0);
            }
            this.lsq = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aIJ = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.exI = 5;
            dVar.exO = 8;
            dVar.exN = 2;
            dVar.exM = i;
            this.lrT.setStatisticData(dVar);
            this.lrU = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.lsn = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.lsn.setHasPendantStyle();
            if (this.lsn.getHeadView() != null) {
                this.lsn.getHeadView().setIsRound(true);
                this.lsn.getHeadView().setDrawBorder(true);
                this.lsn.getHeadView().setPlaceHolder(1);
            }
            this.lso = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.lsp = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.lrV = (TbRichTextView) view.findViewById(R.id.richText);
            this.lrY = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.lrZ = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.lrZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null), (Drawable) null);
            this.lrZ.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.lrZ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.lsa = (TextView) view.findViewById(R.id.pb_post_reply);
            this.lrW = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.lsl = (TextView) view.findViewById(R.id.floor_num);
            this.lrQ = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.lrR = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.lrW.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.lrW.setSingleImageRatio(0.75d);
            this.lrW.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar = new c(this.lrV.getLayoutStrategy());
            cVar.sU(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar.setLineSpacing(TbConfig.getPostLineSpace(), 1.0f);
            this.lrV.setLayoutStrategy(cVar);
            this.lrV.setTextSize(TbConfig.getContentSize());
            this.lrU.setIsRound(true);
            this.lrU.setGodIconWidth(R.dimen.tbds31);
            this.lrU.setPlaceHolder(1);
            this.lrV.setDisplayImage(this.lqL, false);
            this.lrV.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lsr = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lss = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lst = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lsu = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lsv = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lsw = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lsx = (LinearLayout) view.findViewById(R.id.all_content);
            this.lsy = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lsz = (TextView) view.findViewById(R.id.fold_title);
            this.lsA = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.ajy = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        }
    }

    public void ui(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.exI = 12;
            dVar.exO = 9;
            dVar.exN = 3;
            dVar.exM = this.aIJ;
            this.lrT.setStatisticData(dVar);
        }
    }

    public void sN(boolean z) {
        if (z) {
            this.ajy.setVisibility(0);
            if (!this.ajy.isAnimating()) {
                this.ajy.setSpeed(0.8f);
                this.ajy.setRepeatCount(-1);
                this.ajy.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.ajy.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ajy.setVisibility(8);
        if (this.ajy.isAnimating()) {
            this.ajy.cancelAnimation();
        }
    }

    public void En(int i) {
        if (i == 1) {
            this.ajy.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ajy.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ajy.setAnimation("live/card_live_bg.json");
        }
    }
}
