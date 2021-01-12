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
    public int aHt;
    private TBLottieAnimationView aki;
    public TextView hXC;
    public ImageView jMm;
    public ImageView jMo;
    public boolean lFe;
    public TextView lGA;
    public AgreeView lGB;
    public TextView lGC;
    public ImageView lGD;
    public HeadPendantView lGE;
    public UserIconBox lGF;
    public UserIconBox lGG;
    public ImageView lGH;
    public TextView lGI;
    public LinearLayout lGJ;
    public TextView lGK;
    public View lGL;
    public TextView lGM;
    public ImageView lGN;
    public LinearLayout lGO;
    public LinearLayout lGP;
    public TextView lGQ;
    public ImageView lGR;
    public ViewGroup lGS;
    public AgreeView lGT;
    public ImageView lGU;
    public ViewGroup lGV;
    public TextView lGW;
    public TextView lGX;
    public ImageView lGY;
    public View lGf;
    public TextView lGg;
    public TextView lGh;
    public TextView lGi;
    public TextView lGj;
    public TextView lGk;
    public AgreeView lGl;
    public HeadImageView lGm;
    public TbRichTextView lGn;
    public ConstrainImageGroup lGo;
    public View lGp;
    public SubPbLayout lGq;
    public TextView lGr;
    public TextView lGs;
    public View lGt;
    public View lGu;
    public View lGv;
    public View lGw;
    public ImageView lGx;
    public TextView lGy;
    public ImageView lGz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.lFe = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.lGf = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.hXC = (TextView) view.findViewById(R.id.view_user_name);
            this.lGg = (TextView) view.findViewById(R.id.view_author_tip);
            this.lGh = (TextView) view.findViewById(R.id.view_post_time);
            this.lGD = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.lGk = (TextView) view.findViewById(R.id.view_location);
            this.lGp = view.findViewById(R.id.pb_post_reply_container);
            this.jMo = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jMm = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.lGl = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.lGl.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lGl.setNormalColorResourceId(R.color.CAM_X0109);
            this.lGl.jQ(false);
            this.lGt = view.findViewById(R.id.pb_floor_trisection_area);
            this.lGu = view.findViewById(R.id.pb_floor_share_container);
            this.lGv = view.findViewById(R.id.pb_floor_comment_container);
            this.lGw = view.findViewById(R.id.pb_floor_agree_container);
            this.lGx = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.lGy = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.lGz = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.lGA = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.lGB = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.lGB.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lGB.setNormalColorResourceId(R.color.CAM_X0109);
            this.lGB.jQ(true);
            this.lGt.setVisibility(8);
            this.lGp.setVisibility(0);
            this.jMo.setVisibility(0);
            this.jMm.setVisibility(0);
            this.lGl.setVisibility(0);
            this.lGH = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aHt = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eJO = 5;
            dVar.eJU = 8;
            dVar.eJT = 2;
            dVar.eJS = i;
            this.lGl.setStatisticData(dVar);
            this.lGm = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.lGE = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.lGE.setHasPendantStyle();
            if (this.lGE.getHeadView() != null) {
                this.lGE.getHeadView().setIsRound(true);
                this.lGE.getHeadView().setDrawBorder(true);
                this.lGE.getHeadView().setPlaceHolder(1);
            }
            this.lGF = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.lGG = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.lGn = (TbRichTextView) view.findViewById(R.id.richText);
            this.lGq = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.lGr = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.lGr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null), (Drawable) null);
            this.lGr.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.lGr.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.lGs = (TextView) view.findViewById(R.id.pb_post_reply);
            this.lGo = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.lGC = (TextView) view.findViewById(R.id.floor_num);
            this.lGi = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.lGj = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.lGo.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.lGo.setSingleImageRatio(0.75d);
            this.lGo.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar = new c(this.lGn.getLayoutStrategy());
            cVar.sc(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar.setLineSpacing(TbConfig.getPostLineSpace(), 1.0f);
            this.lGn.setLayoutStrategy(cVar);
            this.lGn.setTextSize(TbConfig.getContentSize());
            this.lGm.setIsRound(true);
            this.lGm.setGodIconWidth(R.dimen.tbds31);
            this.lGm.setPlaceHolder(1);
            this.lGn.setDisplayImage(this.lFe, false);
            this.lGn.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lGI = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lGJ = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lGK = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lGL = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lGM = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lGN = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lGO = (LinearLayout) view.findViewById(R.id.all_content);
            this.lGP = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lGQ = (TextView) view.findViewById(R.id.fold_title);
            this.lGR = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.aki = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
            this.lGS = (ViewGroup) view.findViewById(R.id.pb_floor_right_top_layout);
            this.lGT = (AgreeView) view.findViewById(R.id.pb_floor_right_top_agree_view);
            this.lGU = (ImageView) view.findViewById(R.id.pb_floor_right_top_feedback);
            this.lGT.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lGT.setNormalColorResourceId(R.color.CAM_X0109);
            this.lGT.jQ(false);
            this.lGT.setAgreeAlone(true);
            this.lGV = (ViewGroup) view.findViewById(R.id.pb_post_reply_layout_above);
            this.lGW = (TextView) view.findViewById(R.id.view_post_time_above);
            this.lGX = (TextView) view.findViewById(R.id.btn_post_above);
            this.lGY = (ImageView) view.findViewById(R.id.pb_post_op_more);
        }
    }

    public void uH(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eJO = 12;
            dVar.eJU = 9;
            dVar.eJT = 3;
            dVar.eJS = this.aHt;
            this.lGl.setStatisticData(dVar);
        }
    }

    public void tm(boolean z) {
        if (z) {
            this.aki.setVisibility(0);
            if (!this.aki.isAnimating()) {
                this.aki.setSpeed(0.8f);
                this.aki.setRepeatCount(-1);
                this.aki.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PbCommenFloorItemViewHolder.this.aki.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.aki.setVisibility(8);
        if (this.aki.isAnimating()) {
            this.aki.cancelAnimation();
        }
    }

    public void Dq(int i) {
        if (this.aki != null) {
            com.baidu.tbadk.core.util.ao.a(this.aki, R.raw.card_live_header_bg);
        }
    }
}
