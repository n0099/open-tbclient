package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes2.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public int aJY;
    private TBLottieAnimationView ajX;
    public TextView ibW;
    public ImageView jTp;
    public ImageView jTr;
    public boolean lNU;
    public View lOW;
    public TextView lOX;
    public TextView lOY;
    public TextView lOZ;
    public LinearLayout lPA;
    public TextView lPB;
    public View lPC;
    public TextView lPD;
    public ImageView lPE;
    public LinearLayout lPF;
    public LinearLayout lPG;
    public TextView lPH;
    public ImageView lPI;
    public ViewGroup lPJ;
    public AgreeView lPK;
    public ImageView lPL;
    public ViewGroup lPM;
    public TextView lPN;
    public TextView lPO;
    public ImageView lPP;
    public FrameLayout lPQ;
    public MaskView lPR;
    public com.baidu.tieba.pb.pb.main.a.d lPS;
    public TextView lPa;
    public TextView lPb;
    public AgreeView lPc;
    public HeadImageView lPd;
    public TbRichTextView lPe;
    public ConstrainImageGroup lPf;
    public View lPg;
    public SubPbLayout lPh;
    public TextView lPi;
    public TextView lPj;
    public View lPk;
    public View lPl;
    public View lPm;
    public View lPn;
    public ImageView lPo;
    public TextView lPp;
    public ImageView lPq;
    public TextView lPr;
    public AgreeView lPs;
    public TextView lPt;
    public ImageView lPu;
    public HeadPendantView lPv;
    public UserIconBox lPw;
    public UserIconBox lPx;
    public ImageView lPy;
    public TextView lPz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.lNU = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.lOW = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.ibW = (TextView) view.findViewById(R.id.view_user_name);
            this.lOX = (TextView) view.findViewById(R.id.view_author_tip);
            this.lOY = (TextView) view.findViewById(R.id.view_post_time);
            this.lPu = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.lPb = (TextView) view.findViewById(R.id.view_location);
            this.lPg = view.findViewById(R.id.pb_post_reply_container);
            this.jTr = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jTp = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.lPc = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.lPc.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lPc.setNormalColorResourceId(R.color.CAM_X0109);
            this.lPc.jT(false);
            this.lPk = view.findViewById(R.id.pb_floor_trisection_area);
            this.lPl = view.findViewById(R.id.pb_floor_share_container);
            this.lPm = view.findViewById(R.id.pb_floor_comment_container);
            this.lPn = view.findViewById(R.id.pb_floor_agree_container);
            this.lPo = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.lPp = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.lPq = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.lPr = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.lPs = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.lPs.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lPs.setNormalColorResourceId(R.color.CAM_X0109);
            this.lPs.jT(true);
            this.lPk.setVisibility(8);
            this.lPg.setVisibility(0);
            this.jTr.setVisibility(0);
            this.jTp.setVisibility(0);
            this.lPc.setVisibility(0);
            this.lPy = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aJY = i;
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eMa = 5;
            eVar.eMg = 8;
            eVar.eMf = 2;
            eVar.eMe = i;
            this.lPc.setStatisticData(eVar);
            this.lPd = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.lPv = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.lPv.setHasPendantStyle();
            if (this.lPv.getHeadView() != null) {
                this.lPv.getHeadView().setIsRound(true);
                this.lPv.getHeadView().setDrawBorder(true);
                this.lPv.getHeadView().setPlaceHolder(1);
            }
            this.lPw = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.lPx = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.lPe = (TbRichTextView) view.findViewById(R.id.richText);
            this.lPh = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.lPi = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.lPi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null), (Drawable) null);
            this.lPi.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.lPi.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.lPj = (TextView) view.findViewById(R.id.pb_post_reply);
            this.lPf = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.lPt = (TextView) view.findViewById(R.id.floor_num);
            this.lOZ = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.lPa = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.lPf.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.lPf.setSingleImageRatio(0.75d);
            this.lPf.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar = new c(this.lPe.getLayoutStrategy());
            cVar.sh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar.setLineSpacing(TbConfig.getPostLineSpace(), 1.0f);
            this.lPe.setLayoutStrategy(cVar);
            this.lPe.setTextSize(TbConfig.getContentSize());
            this.lPd.setIsRound(true);
            this.lPd.setGodIconWidth(R.dimen.tbds31);
            this.lPd.setPlaceHolder(1);
            this.lPe.setDisplayImage(this.lNU, false);
            this.lPe.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lPz = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lPA = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lPB = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lPC = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lPD = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lPE = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lPF = (LinearLayout) view.findViewById(R.id.all_content);
            this.lPG = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lPH = (TextView) view.findViewById(R.id.fold_title);
            this.lPI = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.ajX = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
            this.lPJ = (ViewGroup) view.findViewById(R.id.pb_floor_right_top_layout);
            this.lPK = (AgreeView) view.findViewById(R.id.pb_floor_right_top_agree_view);
            this.lPL = (ImageView) view.findViewById(R.id.pb_floor_right_top_feedback);
            this.lPK.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lPK.setNormalColorResourceId(R.color.CAM_X0109);
            this.lPK.jT(false);
            this.lPK.setAgreeAlone(true);
            this.lPM = (ViewGroup) view.findViewById(R.id.pb_post_reply_layout_above);
            this.lPN = (TextView) view.findViewById(R.id.view_post_time_above);
            this.lPO = (TextView) view.findViewById(R.id.btn_post_above);
            this.lPP = (ImageView) view.findViewById(R.id.pb_post_op_more);
            this.lPQ = (FrameLayout) view.findViewById(R.id.ueg_root);
            this.lPS = new com.baidu.tieba.pb.pb.main.a.d(tbPageContext, this.lPQ);
            this.lPS.fvb = 3;
            this.lPR = (MaskView) view.findViewById(R.id.mask_view_op);
        }
    }

    public void uW(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eMa = 12;
            eVar.eMg = 9;
            eVar.eMf = 3;
            eVar.eMe = this.aJY;
            this.lPc.setStatisticData(eVar);
        }
    }

    public void tz(boolean z) {
        if (z) {
            this.ajX.setVisibility(0);
            if (!this.ajX.isAnimating()) {
                this.ajX.setSpeed(0.8f);
                this.ajX.setRepeatCount(-1);
                this.ajX.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PbCommenFloorItemViewHolder.this.ajX.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ajX.setVisibility(8);
        if (this.ajX.isAnimating()) {
            this.ajX.cancelAnimation();
        }
    }

    public void DI(int i) {
        if (this.ajX != null) {
            com.baidu.tbadk.core.util.ap.a(this.ajX, R.raw.card_live_header_bg);
        }
    }

    public void c(boolean z, String str, boolean z2) {
        this.lPS.setPostId(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lPF.getLayoutParams();
        if (z) {
            this.lPQ.setVisibility(0);
            layoutParams.addRule(3, R.id.ueg_root);
        } else {
            this.lPQ.setVisibility(8);
            layoutParams.addRule(3, R.id.item_head_owner_root);
        }
        this.lPF.setLayoutParams(layoutParams);
        if (this.lPR != null) {
            this.lPR.setVisibility(((z || z2) && !com.baidu.tbadk.a.d.bjm()) ? 0 : 8);
        }
        dmX();
    }

    public void dmX() {
        this.lPS.onChangeSkinType();
        if (this.lPR != null) {
            this.lPR.bzn();
        }
    }
}
