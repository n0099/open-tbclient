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
    public boolean lJI;
    public View lKJ;
    public TextView lKK;
    public TextView lKL;
    public TextView lKM;
    public TextView lKN;
    public TextView lKO;
    public AgreeView lKP;
    public HeadImageView lKQ;
    public TbRichTextView lKR;
    public ConstrainImageGroup lKS;
    public View lKT;
    public SubPbLayout lKU;
    public TextView lKV;
    public TextView lKW;
    public View lKX;
    public View lKY;
    public View lKZ;
    public TextView lLA;
    public TextView lLB;
    public ImageView lLC;
    public View lLa;
    public ImageView lLb;
    public TextView lLc;
    public ImageView lLd;
    public TextView lLe;
    public AgreeView lLf;
    public TextView lLg;
    public ImageView lLh;
    public HeadPendantView lLi;
    public UserIconBox lLj;
    public UserIconBox lLk;
    public ImageView lLl;
    public TextView lLm;
    public LinearLayout lLn;
    public TextView lLo;
    public View lLp;
    public TextView lLq;
    public ImageView lLr;
    public LinearLayout lLs;
    public LinearLayout lLt;
    public TextView lLu;
    public ImageView lLv;
    public ViewGroup lLw;
    public AgreeView lLx;
    public ImageView lLy;
    public ViewGroup lLz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.lJI = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.lKJ = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.icj = (TextView) view.findViewById(R.id.view_user_name);
            this.lKK = (TextView) view.findViewById(R.id.view_author_tip);
            this.lKL = (TextView) view.findViewById(R.id.view_post_time);
            this.lLh = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.lKO = (TextView) view.findViewById(R.id.view_location);
            this.lKT = view.findViewById(R.id.pb_post_reply_container);
            this.jQT = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jQR = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.lKP = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.lKP.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lKP.setNormalColorResourceId(R.color.CAM_X0109);
            this.lKP.jU(false);
            this.lKX = view.findViewById(R.id.pb_floor_trisection_area);
            this.lKY = view.findViewById(R.id.pb_floor_share_container);
            this.lKZ = view.findViewById(R.id.pb_floor_comment_container);
            this.lLa = view.findViewById(R.id.pb_floor_agree_container);
            this.lLb = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.lLc = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.lLd = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.lLe = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.lLf = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.lLf.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lLf.setNormalColorResourceId(R.color.CAM_X0109);
            this.lLf.jU(true);
            this.lKX.setVisibility(8);
            this.lKT.setVisibility(0);
            this.jQT.setVisibility(0);
            this.jQR.setVisibility(0);
            this.lKP.setVisibility(0);
            this.lLl = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aMg = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eOz = 5;
            dVar.eOF = 8;
            dVar.eOE = 2;
            dVar.eOD = i;
            this.lKP.setStatisticData(dVar);
            this.lKQ = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.lLi = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.lLi.setHasPendantStyle();
            if (this.lLi.getHeadView() != null) {
                this.lLi.getHeadView().setIsRound(true);
                this.lLi.getHeadView().setDrawBorder(true);
                this.lLi.getHeadView().setPlaceHolder(1);
            }
            this.lLj = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.lLk = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.lKR = (TbRichTextView) view.findViewById(R.id.richText);
            this.lKU = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.lKV = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.lKV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null), (Drawable) null);
            this.lKV.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.lKV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.lKW = (TextView) view.findViewById(R.id.pb_post_reply);
            this.lKS = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.lLg = (TextView) view.findViewById(R.id.floor_num);
            this.lKM = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.lKN = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.lKS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.lKS.setSingleImageRatio(0.75d);
            this.lKS.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar = new c(this.lKR.getLayoutStrategy());
            cVar.tI(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar.setLineSpacing(TbConfig.getPostLineSpace(), 1.0f);
            this.lKR.setLayoutStrategy(cVar);
            this.lKR.setTextSize(TbConfig.getContentSize());
            this.lKQ.setIsRound(true);
            this.lKQ.setGodIconWidth(R.dimen.tbds31);
            this.lKQ.setPlaceHolder(1);
            this.lKR.setDisplayImage(this.lJI, false);
            this.lKR.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lLm = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lLn = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lLo = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lLp = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lLq = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lLr = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lLs = (LinearLayout) view.findViewById(R.id.all_content);
            this.lLt = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lLu = (TextView) view.findViewById(R.id.fold_title);
            this.lLv = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.akZ = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
            this.lLw = (ViewGroup) view.findViewById(R.id.pb_floor_right_top_layout);
            this.lLx = (AgreeView) view.findViewById(R.id.pb_floor_right_top_agree_view);
            this.lLy = (ImageView) view.findViewById(R.id.pb_floor_right_top_feedback);
            this.lLx.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lLx.setNormalColorResourceId(R.color.CAM_X0109);
            this.lLx.jU(false);
            this.lLx.setAgreeAlone(true);
            this.lLz = (ViewGroup) view.findViewById(R.id.pb_post_reply_layout_above);
            this.lLA = (TextView) view.findViewById(R.id.view_post_time_above);
            this.lLB = (TextView) view.findViewById(R.id.btn_post_above);
            this.lLC = (ImageView) view.findViewById(R.id.pb_post_op_more);
        }
    }

    public void uL(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eOz = 12;
            dVar.eOF = 9;
            dVar.eOE = 3;
            dVar.eOD = this.aMg;
            this.lKP.setStatisticData(dVar);
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
