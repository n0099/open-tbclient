package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes22.dex */
public class n extends af.a {
    public int aLC;
    private TBLottieAnimationView akx;
    public TextView hPL;
    public ImageView jYm;
    public boolean lEu;
    public TbRichTextView lFA;
    public ConstrainImageGroup lFB;
    public View lFC;
    public SubPbLayout lFD;
    public TextView lFE;
    public TextView lFF;
    public ImageView lFG;
    public View lFH;
    public View lFI;
    public View lFJ;
    public View lFK;
    public ImageView lFL;
    public TextView lFM;
    public ImageView lFN;
    public TextView lFO;
    public AgreeView lFP;
    public TextView lFQ;
    public ImageView lFR;
    public HeadPendantView lFS;
    public UserIconBox lFT;
    public UserIconBox lFU;
    public ImageView lFV;
    public TextView lFW;
    public LinearLayout lFX;
    public TextView lFY;
    public View lFZ;
    public View lFs;
    public TextView lFt;
    public TextView lFu;
    public TextView lFv;
    public TextView lFw;
    public TextView lFx;
    public AgreeView lFy;
    public HeadImageView lFz;
    public TextView lGa;
    public ImageView lGb;
    public LinearLayout lGc;
    public LinearLayout lGd;
    public TextView lGe;
    public ImageView lGf;
    public ViewGroup lGg;
    public AgreeView lGh;
    public ImageView lGi;
    public ViewGroup lGj;
    public TextView lGk;
    public TextView lGl;
    public ImageView lGm;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.lEu = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.lFs = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.hPL = (TextView) view.findViewById(R.id.view_user_name);
            this.lFt = (TextView) view.findViewById(R.id.view_author_tip);
            this.lFu = (TextView) view.findViewById(R.id.view_post_time);
            this.lFR = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.lFx = (TextView) view.findViewById(R.id.view_location);
            this.lFC = view.findViewById(R.id.pb_post_reply_container);
            this.lFG = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jYm = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.lFy = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.lFy.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lFy.setNormalColorResourceId(R.color.CAM_X0109);
            this.lFy.jy(false);
            this.lFH = view.findViewById(R.id.pb_floor_trisection_area);
            this.lFI = view.findViewById(R.id.pb_floor_share_container);
            this.lFJ = view.findViewById(R.id.pb_floor_comment_container);
            this.lFK = view.findViewById(R.id.pb_floor_agree_container);
            this.lFL = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.lFM = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.lFN = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.lFO = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.lFP = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.lFP.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lFP.setNormalColorResourceId(R.color.CAM_X0109);
            this.lFP.jy(true);
            this.lFH.setVisibility(8);
            this.lFC.setVisibility(0);
            this.lFG.setVisibility(0);
            this.jYm.setVisibility(0);
            this.lFy.setVisibility(0);
            this.lFV = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aLC = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eEJ = 5;
            dVar.eEP = 8;
            dVar.eEO = 2;
            dVar.eEN = i;
            this.lFy.setStatisticData(dVar);
            this.lFz = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.lFS = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.lFS.setHasPendantStyle();
            if (this.lFS.getHeadView() != null) {
                this.lFS.getHeadView().setIsRound(true);
                this.lFS.getHeadView().setDrawBorder(true);
                this.lFS.getHeadView().setPlaceHolder(1);
            }
            this.lFT = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.lFU = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.lFA = (TbRichTextView) view.findViewById(R.id.richText);
            this.lFD = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.lFE = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.lFE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null), (Drawable) null);
            this.lFE.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.lFE.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.lFF = (TextView) view.findViewById(R.id.pb_post_reply);
            this.lFB = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.lFQ = (TextView) view.findViewById(R.id.floor_num);
            this.lFv = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.lFw = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.lFB.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.lFB.setSingleImageRatio(0.75d);
            this.lFB.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar = new c(this.lFA.getLayoutStrategy());
            cVar.tx(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar.setLineSpacing(TbConfig.getPostLineSpace(), 1.0f);
            this.lFA.setLayoutStrategy(cVar);
            this.lFA.setTextSize(TbConfig.getContentSize());
            this.lFz.setIsRound(true);
            this.lFz.setGodIconWidth(R.dimen.tbds31);
            this.lFz.setPlaceHolder(1);
            this.lFA.setDisplayImage(this.lEu, false);
            this.lFA.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lFW = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lFX = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lFY = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lFZ = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lGa = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lGb = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lGc = (LinearLayout) view.findViewById(R.id.all_content);
            this.lGd = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lGe = (TextView) view.findViewById(R.id.fold_title);
            this.lGf = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.akx = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
            this.lGg = (ViewGroup) view.findViewById(R.id.pb_floor_right_top_layout);
            this.lGh = (AgreeView) view.findViewById(R.id.pb_floor_right_top_agree_view);
            this.lGi = (ImageView) view.findViewById(R.id.pb_floor_right_top_feedback);
            this.lGh.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lGh.setNormalColorResourceId(R.color.CAM_X0109);
            this.lGh.jy(false);
            this.lGh.setAgreeAlone(true);
            this.lGj = (ViewGroup) view.findViewById(R.id.pb_post_reply_layout_above);
            this.lGk = (TextView) view.findViewById(R.id.view_post_time_above);
            this.lGl = (TextView) view.findViewById(R.id.btn_post_above);
            this.lGm = (ImageView) view.findViewById(R.id.pb_post_op_more);
        }
    }

    public void uK(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eEJ = 12;
            dVar.eEP = 9;
            dVar.eEO = 3;
            dVar.eEN = this.aLC;
            this.lFy.setStatisticData(dVar);
        }
    }

    public void tp(boolean z) {
        if (z) {
            this.akx.setVisibility(0);
            if (!this.akx.isAnimating()) {
                this.akx.setSpeed(0.8f);
                this.akx.setRepeatCount(-1);
                this.akx.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.akx.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.akx.setVisibility(8);
        if (this.akx.isAnimating()) {
            this.akx.cancelAnimation();
        }
    }

    public void Fc(int i) {
        if (i == 1) {
            this.akx.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.akx.setAnimation("live/card_live_bg_black.json");
        } else {
            this.akx.setAnimation("live/card_live_bg.json");
        }
    }
}
