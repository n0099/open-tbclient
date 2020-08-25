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
/* loaded from: classes16.dex */
public class n extends af.a {
    public int aEB;
    private TBLottieAnimationView aiE;
    public TextView gVT;
    public ImageView iTP;
    public boolean kAh;
    public ImageView kBA;
    public TextView kBB;
    public ImageView kBC;
    public TextView kBD;
    public AgreeView kBE;
    public TextView kBF;
    public ImageView kBG;
    public HeadPendantView kBH;
    public UserIconBox kBI;
    public UserIconBox kBJ;
    public ImageView kBK;
    public TextView kBL;
    public LinearLayout kBM;
    public TextView kBN;
    public View kBO;
    public TextView kBP;
    public ImageView kBQ;
    public LinearLayout kBR;
    public LinearLayout kBS;
    public TextView kBT;
    public ImageView kBU;
    public View kBh;
    public TextView kBi;
    public TextView kBj;
    public TextView kBk;
    public TextView kBl;
    public TextView kBm;
    public AgreeView kBn;
    public HeadImageView kBo;
    public TbRichTextView kBp;
    public ConstrainImageGroup kBq;
    public View kBr;
    public SubPbLayout kBs;
    public TextView kBt;
    public TextView kBu;
    public ImageView kBv;
    public View kBw;
    public View kBx;
    public View kBy;
    public View kBz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.kAh = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.kBh = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.gVT = (TextView) view.findViewById(R.id.view_user_name);
            this.kBi = (TextView) view.findViewById(R.id.view_author_tip);
            this.kBj = (TextView) view.findViewById(R.id.view_post_time);
            this.kBG = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.kBm = (TextView) view.findViewById(R.id.view_location);
            this.kBr = view.findViewById(R.id.pb_post_reply_container);
            this.kBv = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.iTP = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.kBn = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.kBn.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.kBn.setNormalColorResourceId(R.color.cp_cont_d);
            this.kBn.iq(false);
            this.kBw = view.findViewById(R.id.pb_floor_trisection_area);
            this.kBx = view.findViewById(R.id.pb_floor_share_container);
            this.kBy = view.findViewById(R.id.pb_floor_comment_container);
            this.kBz = view.findViewById(R.id.pb_floor_agree_container);
            this.kBA = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.kBB = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.kBC = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.kBD = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.kBE = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.kBE.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.kBE.setNormalColorResourceId(R.color.cp_cont_d);
            this.kBE.iq(true);
            if (z && z2) {
                this.kBr.setVisibility(8);
                this.kBw.setVisibility(0);
            } else if (z) {
                this.kBw.setVisibility(0);
                this.kBr.setVisibility(0);
                this.kBv.setVisibility(8);
                this.iTP.setVisibility(8);
                this.kBn.setVisibility(8);
            } else {
                this.kBw.setVisibility(8);
                this.kBr.setVisibility(0);
                this.kBv.setVisibility(0);
                this.iTP.setVisibility(0);
                this.kBn.setVisibility(0);
            }
            this.kBK = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aEB = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dWK = 5;
            cVar.dWQ = 8;
            cVar.dWP = 2;
            cVar.dWO = i;
            this.kBn.setStatisticData(cVar);
            this.kBo = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.kBH = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.kBH.setHasPendantStyle();
            if (this.kBH.getHeadView() != null) {
                this.kBH.getHeadView().setIsRound(true);
                this.kBH.getHeadView().setDrawBorder(false);
                this.kBH.getHeadView().setPlaceHolder(1);
            }
            this.kBI = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.kBJ = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.kBp = (TbRichTextView) view.findViewById(R.id.richText);
            this.kBs = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.kBt = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.kBt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.kBt.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.kBt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.kBu = (TextView) view.findViewById(R.id.pb_post_reply);
            this.kBq = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.kBF = (TextView) view.findViewById(R.id.floor_num);
            this.kBk = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.kBl = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.kBq.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.kBq.setSingleImageRatio(0.75d);
            this.kBq.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.kBp.getLayoutStrategy());
            cVar2.rm(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kBp.setLayoutStrategy(cVar2);
            this.kBp.setTextSize(TbConfig.getContentSize());
            this.kBo.setIsRound(true);
            this.kBo.setGodIconWidth(R.dimen.tbds31);
            this.kBo.setPlaceHolder(1);
            this.kBp.setDisplayImage(this.kAh, false);
            this.kBp.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.kBL = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.kBM = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.kBN = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.kBO = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.kBP = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.kBQ = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.kBR = (LinearLayout) view.findViewById(R.id.all_content);
            this.kBS = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.kBT = (TextView) view.findViewById(R.id.fold_title);
            this.kBU = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.aiE = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        }
    }

    public void sP(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dWK = 12;
            cVar.dWQ = 9;
            cVar.dWP = 3;
            cVar.dWO = this.aEB;
            this.kBn.setStatisticData(cVar);
        }
    }

    public void rt(boolean z) {
        if (z) {
            this.aiE.setVisibility(0);
            if (!this.aiE.isAnimating()) {
                this.aiE.setSpeed(0.8f);
                this.aiE.setRepeatCount(-1);
                this.aiE.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.aiE.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.aiE.setVisibility(8);
        if (this.aiE.isAnimating()) {
            this.aiE.cancelAnimation();
        }
    }

    public void Cc(int i) {
        if (i == 1) {
            this.aiE.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.aiE.setAnimation("live/card_live_bg_black.json");
        } else {
            this.aiE.setAnimation("live/card_live_bg.json");
        }
    }
}
