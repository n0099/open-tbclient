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
    public int aLy;
    private TBLottieAnimationView alq;
    public TextView idX;
    public ImageView jVU;
    public ImageView jVW;
    public boolean lQl;
    public TextView lRA;
    public View lRB;
    public View lRC;
    public View lRD;
    public View lRE;
    public ImageView lRF;
    public TextView lRG;
    public ImageView lRH;
    public TextView lRI;
    public AgreeView lRJ;
    public TextView lRK;
    public ImageView lRL;
    public HeadPendantView lRM;
    public UserIconBox lRN;
    public UserIconBox lRO;
    public ImageView lRP;
    public TextView lRQ;
    public LinearLayout lRR;
    public TextView lRS;
    public View lRT;
    public TextView lRU;
    public ImageView lRV;
    public LinearLayout lRW;
    public LinearLayout lRX;
    public TextView lRY;
    public ImageView lRZ;
    public View lRn;
    public TextView lRo;
    public TextView lRp;
    public TextView lRq;
    public TextView lRr;
    public TextView lRs;
    public AgreeView lRt;
    public HeadImageView lRu;
    public TbRichTextView lRv;
    public ConstrainImageGroup lRw;
    public View lRx;
    public SubPbLayout lRy;
    public TextView lRz;
    public ViewGroup lSa;
    public AgreeView lSb;
    public ImageView lSc;
    public ViewGroup lSd;
    public TextView lSe;
    public TextView lSf;
    public ImageView lSg;
    public FrameLayout lSh;
    public MaskView lSi;
    public com.baidu.tieba.pb.pb.main.a.d lSj;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.lQl = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.lRn = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.idX = (TextView) view.findViewById(R.id.view_user_name);
            this.lRo = (TextView) view.findViewById(R.id.view_author_tip);
            this.lRp = (TextView) view.findViewById(R.id.view_post_time);
            this.lRL = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.lRs = (TextView) view.findViewById(R.id.view_location);
            this.lRx = view.findViewById(R.id.pb_post_reply_container);
            this.jVW = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jVU = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.lRt = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.lRt.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lRt.setNormalColorResourceId(R.color.CAM_X0109);
            this.lRt.jT(false);
            this.lRB = view.findViewById(R.id.pb_floor_trisection_area);
            this.lRC = view.findViewById(R.id.pb_floor_share_container);
            this.lRD = view.findViewById(R.id.pb_floor_comment_container);
            this.lRE = view.findViewById(R.id.pb_floor_agree_container);
            this.lRF = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.lRG = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.lRH = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.lRI = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.lRJ = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.lRJ.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lRJ.setNormalColorResourceId(R.color.CAM_X0109);
            this.lRJ.jT(true);
            this.lRB.setVisibility(8);
            this.lRx.setVisibility(0);
            this.jVW.setVisibility(0);
            this.jVU.setVisibility(0);
            this.lRt.setVisibility(0);
            this.lRP = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aLy = i;
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eNB = 5;
            eVar.eNH = 8;
            eVar.eNG = 2;
            eVar.eNF = i;
            this.lRt.setStatisticData(eVar);
            this.lRu = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.lRM = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.lRM.setHasPendantStyle();
            if (this.lRM.getHeadView() != null) {
                this.lRM.getHeadView().setIsRound(true);
                this.lRM.getHeadView().setDrawBorder(true);
                this.lRM.getHeadView().setPlaceHolder(1);
            }
            this.lRN = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.lRO = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.lRv = (TbRichTextView) view.findViewById(R.id.richText);
            this.lRy = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.lRz = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.lRz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null), (Drawable) null);
            this.lRz.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.lRz.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.lRA = (TextView) view.findViewById(R.id.pb_post_reply);
            this.lRw = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.lRK = (TextView) view.findViewById(R.id.floor_num);
            this.lRq = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.lRr = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.lRw.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.lRw.setSingleImageRatio(0.75d);
            this.lRw.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar = new c(this.lRv.getLayoutStrategy());
            cVar.sj(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar.setLineSpacing(TbConfig.getPostLineSpace(), 1.0f);
            this.lRv.setLayoutStrategy(cVar);
            this.lRv.setTextSize(TbConfig.getContentSize());
            this.lRu.setIsRound(true);
            this.lRu.setGodIconWidth(R.dimen.tbds31);
            this.lRu.setPlaceHolder(1);
            this.lRv.setDisplayImage(this.lQl, false);
            this.lRv.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lRQ = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lRR = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lRS = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lRT = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lRU = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lRV = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lRW = (LinearLayout) view.findViewById(R.id.all_content);
            this.lRX = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lRY = (TextView) view.findViewById(R.id.fold_title);
            this.lRZ = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.alq = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
            this.lSa = (ViewGroup) view.findViewById(R.id.pb_floor_right_top_layout);
            this.lSb = (AgreeView) view.findViewById(R.id.pb_floor_right_top_agree_view);
            this.lSc = (ImageView) view.findViewById(R.id.pb_floor_right_top_feedback);
            this.lSb.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lSb.setNormalColorResourceId(R.color.CAM_X0109);
            this.lSb.jT(false);
            this.lSb.setAgreeAlone(true);
            this.lSd = (ViewGroup) view.findViewById(R.id.pb_post_reply_layout_above);
            this.lSe = (TextView) view.findViewById(R.id.view_post_time_above);
            this.lSf = (TextView) view.findViewById(R.id.btn_post_above);
            this.lSg = (ImageView) view.findViewById(R.id.pb_post_op_more);
            this.lSh = (FrameLayout) view.findViewById(R.id.ueg_root);
            this.lSj = new com.baidu.tieba.pb.pb.main.a.d(tbPageContext, this.lSh);
            this.lSj.fwA = 3;
            this.lSi = (MaskView) view.findViewById(R.id.mask_view_op);
        }
    }

    public void uW(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eNB = 12;
            eVar.eNH = 9;
            eVar.eNG = 3;
            eVar.eNF = this.aLy;
            this.lRt.setStatisticData(eVar);
        }
    }

    public void tz(boolean z) {
        if (z) {
            this.alq.setVisibility(0);
            if (!this.alq.isAnimating()) {
                this.alq.setSpeed(0.8f);
                this.alq.setRepeatCount(-1);
                this.alq.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PbCommenFloorItemViewHolder.this.alq.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.alq.setVisibility(8);
        if (this.alq.isAnimating()) {
            this.alq.cancelAnimation();
        }
    }

    public void DL(int i) {
        if (this.alq != null) {
            com.baidu.tbadk.core.util.ap.a(this.alq, R.raw.card_live_header_bg);
        }
    }

    public void c(boolean z, String str, boolean z2) {
        this.lSj.setPostId(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lRW.getLayoutParams();
        if (z) {
            this.lSh.setVisibility(0);
            layoutParams.addRule(3, R.id.ueg_root);
        } else {
            this.lSh.setVisibility(8);
            layoutParams.addRule(3, R.id.item_head_owner_root);
        }
        this.lRW.setLayoutParams(layoutParams);
        if (this.lSi != null) {
            this.lSi.setVisibility(((z || z2) && !com.baidu.tbadk.a.d.bjo()) ? 0 : 8);
        }
        dnn();
    }

    public void dnn() {
        this.lSj.onChangeSkinType();
        if (this.lSi != null) {
            this.lSi.bzq();
        }
    }
}
