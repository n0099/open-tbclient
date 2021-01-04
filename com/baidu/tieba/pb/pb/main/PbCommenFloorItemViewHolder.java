package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
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
/* loaded from: classes2.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public int aMg;
    private TBLottieAnimationView akZ;
    public TextView icj;
    public ImageView jQR;
    public ImageView jQT;
    public boolean lJJ;
    public View lKK;
    public TextView lKL;
    public TextView lKM;
    public TextView lKN;
    public TextView lKO;
    public TextView lKP;
    public AgreeView lKQ;
    public HeadImageView lKR;
    public TbRichTextView lKS;
    public ConstrainImageGroup lKT;
    public View lKU;
    public SubPbLayout lKV;
    public TextView lKW;
    public TextView lKX;
    public View lKY;
    public View lKZ;
    public ViewGroup lLA;
    public TextView lLB;
    public TextView lLC;
    public ImageView lLD;
    public View lLa;
    public View lLb;
    public ImageView lLc;
    public TextView lLd;
    public ImageView lLe;
    public TextView lLf;
    public AgreeView lLg;
    public TextView lLh;
    public ImageView lLi;
    public HeadPendantView lLj;
    public UserIconBox lLk;
    public UserIconBox lLl;
    public ImageView lLm;
    public TextView lLn;
    public LinearLayout lLo;
    public TextView lLp;
    public View lLq;
    public TextView lLr;
    public ImageView lLs;
    public LinearLayout lLt;
    public LinearLayout lLu;
    public TextView lLv;
    public ImageView lLw;
    public ViewGroup lLx;
    public AgreeView lLy;
    public ImageView lLz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.lJJ = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.lKK = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.icj = (TextView) view.findViewById(R.id.view_user_name);
            this.lKL = (TextView) view.findViewById(R.id.view_author_tip);
            this.lKM = (TextView) view.findViewById(R.id.view_post_time);
            this.lLi = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.lKP = (TextView) view.findViewById(R.id.view_location);
            this.lKU = view.findViewById(R.id.pb_post_reply_container);
            this.jQT = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jQR = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.lKQ = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.lKQ.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lKQ.setNormalColorResourceId(R.color.CAM_X0109);
            this.lKQ.jU(false);
            this.lKY = view.findViewById(R.id.pb_floor_trisection_area);
            this.lKZ = view.findViewById(R.id.pb_floor_share_container);
            this.lLa = view.findViewById(R.id.pb_floor_comment_container);
            this.lLb = view.findViewById(R.id.pb_floor_agree_container);
            this.lLc = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.lLd = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.lLe = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.lLf = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.lLg = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.lLg.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lLg.setNormalColorResourceId(R.color.CAM_X0109);
            this.lLg.jU(true);
            this.lKY.setVisibility(8);
            this.lKU.setVisibility(0);
            this.jQT.setVisibility(0);
            this.jQR.setVisibility(0);
            this.lKQ.setVisibility(0);
            this.lLm = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aMg = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eOz = 5;
            dVar.eOF = 8;
            dVar.eOE = 2;
            dVar.eOD = i;
            this.lKQ.setStatisticData(dVar);
            this.lKR = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.lLj = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.lLj.setHasPendantStyle();
            if (this.lLj.getHeadView() != null) {
                this.lLj.getHeadView().setIsRound(true);
                this.lLj.getHeadView().setDrawBorder(true);
                this.lLj.getHeadView().setPlaceHolder(1);
            }
            this.lLk = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.lLl = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.lKS = (TbRichTextView) view.findViewById(R.id.richText);
            this.lKV = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.lKW = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.lKW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null), (Drawable) null);
            this.lKW.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.lKW.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.lKX = (TextView) view.findViewById(R.id.pb_post_reply);
            this.lKT = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.lLh = (TextView) view.findViewById(R.id.floor_num);
            this.lKN = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.lKO = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.lKT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.lKT.setSingleImageRatio(0.75d);
            this.lKT.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar = new c(this.lKS.getLayoutStrategy());
            cVar.tI(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar.setLineSpacing(TbConfig.getPostLineSpace(), 1.0f);
            this.lKS.setLayoutStrategy(cVar);
            this.lKS.setTextSize(TbConfig.getContentSize());
            this.lKR.setIsRound(true);
            this.lKR.setGodIconWidth(R.dimen.tbds31);
            this.lKR.setPlaceHolder(1);
            this.lKS.setDisplayImage(this.lJJ, false);
            this.lKS.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lLn = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lLo = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lLp = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lLq = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lLr = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lLs = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lLt = (LinearLayout) view.findViewById(R.id.all_content);
            this.lLu = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lLv = (TextView) view.findViewById(R.id.fold_title);
            this.lLw = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.akZ = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
            this.lLx = (ViewGroup) view.findViewById(R.id.pb_floor_right_top_layout);
            this.lLy = (AgreeView) view.findViewById(R.id.pb_floor_right_top_agree_view);
            this.lLz = (ImageView) view.findViewById(R.id.pb_floor_right_top_feedback);
            this.lLy.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lLy.setNormalColorResourceId(R.color.CAM_X0109);
            this.lLy.jU(false);
            this.lLy.setAgreeAlone(true);
            this.lLA = (ViewGroup) view.findViewById(R.id.pb_post_reply_layout_above);
            this.lLB = (TextView) view.findViewById(R.id.view_post_time_above);
            this.lLC = (TextView) view.findViewById(R.id.btn_post_above);
            this.lLD = (ImageView) view.findViewById(R.id.pb_post_op_more);
        }
    }

    public void uL(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eOz = 12;
            dVar.eOF = 9;
            dVar.eOE = 3;
            dVar.eOD = this.aMg;
            this.lKQ.setStatisticData(dVar);
        }
    }

    public void tq(boolean z) {
        if (z) {
            this.akZ.setVisibility(0);
            if (!this.akZ.isAnimating()) {
                this.akZ.setSpeed(0.8f);
                this.akZ.setRepeatCount(-1);
                this.akZ.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PbCommenFloorItemViewHolder.this.akZ.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.akZ.setVisibility(8);
        if (this.akZ.isAnimating()) {
            this.akZ.cancelAnimation();
        }
    }

    public void EW(int i) {
        if (i == 1) {
            this.akZ.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.akZ.setAnimation("live/card_live_bg_black.json");
        } else {
            this.akZ.setAnimation("live/card_live_bg.json");
        }
    }
}
