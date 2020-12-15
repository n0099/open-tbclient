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
    public TextView hPN;
    public ImageView jYo;
    public boolean lEw;
    public AgreeView lFA;
    public HeadImageView lFB;
    public TbRichTextView lFC;
    public ConstrainImageGroup lFD;
    public View lFE;
    public SubPbLayout lFF;
    public TextView lFG;
    public TextView lFH;
    public ImageView lFI;
    public View lFJ;
    public View lFK;
    public View lFL;
    public View lFM;
    public ImageView lFN;
    public TextView lFO;
    public ImageView lFP;
    public TextView lFQ;
    public AgreeView lFR;
    public TextView lFS;
    public ImageView lFT;
    public HeadPendantView lFU;
    public UserIconBox lFV;
    public UserIconBox lFW;
    public ImageView lFX;
    public TextView lFY;
    public LinearLayout lFZ;
    public View lFu;
    public TextView lFv;
    public TextView lFw;
    public TextView lFx;
    public TextView lFy;
    public TextView lFz;
    public TextView lGa;
    public View lGb;
    public TextView lGc;
    public ImageView lGd;
    public LinearLayout lGe;
    public LinearLayout lGf;
    public TextView lGg;
    public ImageView lGh;
    public ViewGroup lGi;
    public AgreeView lGj;
    public ImageView lGk;
    public ViewGroup lGl;
    public TextView lGm;
    public TextView lGn;
    public ImageView lGo;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.lEw = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.lFu = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.hPN = (TextView) view.findViewById(R.id.view_user_name);
            this.lFv = (TextView) view.findViewById(R.id.view_author_tip);
            this.lFw = (TextView) view.findViewById(R.id.view_post_time);
            this.lFT = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.lFz = (TextView) view.findViewById(R.id.view_location);
            this.lFE = view.findViewById(R.id.pb_post_reply_container);
            this.lFI = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jYo = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.lFA = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.lFA.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lFA.setNormalColorResourceId(R.color.CAM_X0109);
            this.lFA.jy(false);
            this.lFJ = view.findViewById(R.id.pb_floor_trisection_area);
            this.lFK = view.findViewById(R.id.pb_floor_share_container);
            this.lFL = view.findViewById(R.id.pb_floor_comment_container);
            this.lFM = view.findViewById(R.id.pb_floor_agree_container);
            this.lFN = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.lFO = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.lFP = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.lFQ = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.lFR = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.lFR.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lFR.setNormalColorResourceId(R.color.CAM_X0109);
            this.lFR.jy(true);
            this.lFJ.setVisibility(8);
            this.lFE.setVisibility(0);
            this.lFI.setVisibility(0);
            this.jYo.setVisibility(0);
            this.lFA.setVisibility(0);
            this.lFX = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aLC = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eEJ = 5;
            dVar.eEP = 8;
            dVar.eEO = 2;
            dVar.eEN = i;
            this.lFA.setStatisticData(dVar);
            this.lFB = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.lFU = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.lFU.setHasPendantStyle();
            if (this.lFU.getHeadView() != null) {
                this.lFU.getHeadView().setIsRound(true);
                this.lFU.getHeadView().setDrawBorder(true);
                this.lFU.getHeadView().setPlaceHolder(1);
            }
            this.lFV = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.lFW = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.lFC = (TbRichTextView) view.findViewById(R.id.richText);
            this.lFF = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.lFG = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.lFG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null), (Drawable) null);
            this.lFG.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.lFG.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.lFH = (TextView) view.findViewById(R.id.pb_post_reply);
            this.lFD = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.lFS = (TextView) view.findViewById(R.id.floor_num);
            this.lFx = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.lFy = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.lFD.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.lFD.setSingleImageRatio(0.75d);
            this.lFD.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar = new c(this.lFC.getLayoutStrategy());
            cVar.tx(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar.setLineSpacing(TbConfig.getPostLineSpace(), 1.0f);
            this.lFC.setLayoutStrategy(cVar);
            this.lFC.setTextSize(TbConfig.getContentSize());
            this.lFB.setIsRound(true);
            this.lFB.setGodIconWidth(R.dimen.tbds31);
            this.lFB.setPlaceHolder(1);
            this.lFC.setDisplayImage(this.lEw, false);
            this.lFC.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.lFY = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.lFZ = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.lGa = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.lGb = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.lGc = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.lGd = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.lGe = (LinearLayout) view.findViewById(R.id.all_content);
            this.lGf = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.lGg = (TextView) view.findViewById(R.id.fold_title);
            this.lGh = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.akx = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
            this.lGi = (ViewGroup) view.findViewById(R.id.pb_floor_right_top_layout);
            this.lGj = (AgreeView) view.findViewById(R.id.pb_floor_right_top_agree_view);
            this.lGk = (ImageView) view.findViewById(R.id.pb_floor_right_top_feedback);
            this.lGj.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.lGj.setNormalColorResourceId(R.color.CAM_X0109);
            this.lGj.jy(false);
            this.lGj.setAgreeAlone(true);
            this.lGl = (ViewGroup) view.findViewById(R.id.pb_post_reply_layout_above);
            this.lGm = (TextView) view.findViewById(R.id.view_post_time_above);
            this.lGn = (TextView) view.findViewById(R.id.btn_post_above);
            this.lGo = (ImageView) view.findViewById(R.id.pb_post_op_more);
        }
    }

    public void uK(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eEJ = 12;
            dVar.eEP = 9;
            dVar.eEO = 3;
            dVar.eEN = this.aLC;
            this.lFA.setStatisticData(dVar);
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
