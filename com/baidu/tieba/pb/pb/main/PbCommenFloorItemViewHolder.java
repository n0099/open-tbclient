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
    public TextView ick;
    public ImageView jTD;
    public ImageView jTF;
    public boolean lOj;
    public View lPA;
    public View lPB;
    public View lPC;
    public ImageView lPD;
    public TextView lPE;
    public ImageView lPF;
    public TextView lPG;
    public AgreeView lPH;
    public TextView lPI;
    public ImageView lPJ;
    public HeadPendantView lPK;
    public UserIconBox lPL;
    public UserIconBox lPM;
    public ImageView lPN;
    public TextView lPO;
    public LinearLayout lPP;
    public TextView lPQ;
    public View lPR;
    public TextView lPS;
    public ImageView lPT;
    public LinearLayout lPU;
    public LinearLayout lPV;
    public TextView lPW;
    public ImageView lPX;
    public ViewGroup lPY;
    public AgreeView lPZ;
    public View lPl;
    public TextView lPm;
    public TextView lPn;
    public TextView lPo;
    public TextView lPp;
    public TextView lPq;
    public AgreeView lPr;
    public HeadImageView lPs;
    public TbRichTextView lPt;
    public ConstrainImageGroup lPu;
    public View lPv;
    public SubPbLayout lPw;
    public TextView lPx;
    public TextView lPy;
    public View lPz;
    public ImageView lQa;
    public ViewGroup lQb;
    public TextView lQc;
    public TextView lQd;
    public ImageView lQe;
    public FrameLayout lQf;
    public MaskView lQg;
    public com.baidu.tieba.pb.pb.main.a.d lQh;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.lOj = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.lPl = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.ick = (TextView) view.findViewById(R.id.view_user_name);
            this.lPm = (TextView) view.findViewById(R.id.view_author_tip);
            this.lPn = (TextView) view.findViewById(R.id.view_post_time);
            this.lPJ = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.lPq = (TextView) view.findViewById(R.id.view_location);
            this.lPv = view.findViewById(R.id.pb_post_reply_container);
            this.jTF = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jTD = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.lPr = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.lPr.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lPr.setNormalColorResourceId(R.color.CAM_X0109);
            this.lPr.jT(false);
            this.lPz = view.findViewById(R.id.pb_floor_trisection_area);
            this.lPA = view.findViewById(R.id.pb_floor_share_container);
            this.lPB = view.findViewById(R.id.pb_floor_comment_container);
            this.lPC = view.findViewById(R.id.pb_floor_agree_container);
            this.lPD = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.lPE = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.lPF = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.lPG = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.lPH = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.lPH.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lPH.setNormalColorResourceId(R.color.CAM_X0109);
            this.lPH.jT(true);
            this.lPz.setVisibility(8);
            this.lPv.setVisibility(0);
            this.jTF.setVisibility(0);
            this.jTD.setVisibility(0);
            this.lPr.setVisibility(0);
            this.lPN = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aJY = i;
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eMa = 5;
            eVar.eMg = 8;
            eVar.eMf = 2;
            eVar.eMe = i;
            this.lPr.setStatisticData(eVar);
            this.lPs = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.lPK = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.lPK.setHasPendantStyle();
            if (this.lPK.getHeadView() != null) {
                this.lPK.getHeadView().setIsRound(true);
                this.lPK.getHeadView().setDrawBorder(true);
                this.lPK.getHeadView().setPlaceHolder(1);
            }
            this.lPL = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.lPM = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.lPt = (TbRichTextView) view.findViewById(R.id.richText);
            this.lPw = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.lPx = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.lPx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null), (Drawable) null);
            this.lPx.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.lPx.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.lPy = (TextView) view.findViewById(R.id.pb_post_reply);
            this.lPu = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.lPI = (TextView) view.findViewById(R.id.floor_num);
            this.lPo = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.lPp = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.lPu.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.lPu.setSingleImageRatio(0.75d);
            this.lPu.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar = new c(this.lPt.getLayoutStrategy());
            cVar.sh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar.setLineSpacing(TbConfig.getPostLineSpace(), 1.0f);
            this.lPt.setLayoutStrategy(cVar);
            this.lPt.setTextSize(TbConfig.getContentSize());
            this.lPs.setIsRound(true);
            this.lPs.setGodIconWidth(R.dimen.tbds31);
            this.lPs.setPlaceHolder(1);
            this.lPt.setDisplayImage(this.lOj, false);
            this.lPt.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lPO = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lPP = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lPQ = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lPR = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lPS = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lPT = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lPU = (LinearLayout) view.findViewById(R.id.all_content);
            this.lPV = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lPW = (TextView) view.findViewById(R.id.fold_title);
            this.lPX = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.ajX = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
            this.lPY = (ViewGroup) view.findViewById(R.id.pb_floor_right_top_layout);
            this.lPZ = (AgreeView) view.findViewById(R.id.pb_floor_right_top_agree_view);
            this.lQa = (ImageView) view.findViewById(R.id.pb_floor_right_top_feedback);
            this.lPZ.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lPZ.setNormalColorResourceId(R.color.CAM_X0109);
            this.lPZ.jT(false);
            this.lPZ.setAgreeAlone(true);
            this.lQb = (ViewGroup) view.findViewById(R.id.pb_post_reply_layout_above);
            this.lQc = (TextView) view.findViewById(R.id.view_post_time_above);
            this.lQd = (TextView) view.findViewById(R.id.btn_post_above);
            this.lQe = (ImageView) view.findViewById(R.id.pb_post_op_more);
            this.lQf = (FrameLayout) view.findViewById(R.id.ueg_root);
            this.lQh = new com.baidu.tieba.pb.pb.main.a.d(tbPageContext, this.lQf);
            this.lQh.fvb = 3;
            this.lQg = (MaskView) view.findViewById(R.id.mask_view_op);
        }
    }

    public void uW(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eMa = 12;
            eVar.eMg = 9;
            eVar.eMf = 3;
            eVar.eMe = this.aJY;
            this.lPr.setStatisticData(eVar);
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
        this.lQh.setPostId(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lPU.getLayoutParams();
        if (z) {
            this.lQf.setVisibility(0);
            layoutParams.addRule(3, R.id.ueg_root);
        } else {
            this.lQf.setVisibility(8);
            layoutParams.addRule(3, R.id.item_head_owner_root);
        }
        this.lPU.setLayoutParams(layoutParams);
        if (this.lQg != null) {
            this.lQg.setVisibility(((z || z2) && !com.baidu.tbadk.a.d.bjm()) ? 0 : 8);
        }
        dne();
    }

    public void dne() {
        this.lQh.onChangeSkinType();
        if (this.lQg != null) {
            this.lQg.bzn();
        }
    }
}
