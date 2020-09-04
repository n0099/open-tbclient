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
    public int aED;
    private TBLottieAnimationView aiG;
    public TextView gVX;
    public ImageView iTV;
    public boolean kAo;
    public TextView kBA;
    public TextView kBB;
    public ImageView kBC;
    public View kBD;
    public View kBE;
    public View kBF;
    public View kBG;
    public ImageView kBH;
    public TextView kBI;
    public ImageView kBJ;
    public TextView kBK;
    public AgreeView kBL;
    public TextView kBM;
    public ImageView kBN;
    public HeadPendantView kBO;
    public UserIconBox kBP;
    public UserIconBox kBQ;
    public ImageView kBR;
    public TextView kBS;
    public LinearLayout kBT;
    public TextView kBU;
    public View kBV;
    public TextView kBW;
    public ImageView kBX;
    public LinearLayout kBY;
    public LinearLayout kBZ;
    public View kBo;
    public TextView kBp;
    public TextView kBq;
    public TextView kBr;
    public TextView kBs;
    public TextView kBt;
    public AgreeView kBu;
    public HeadImageView kBv;
    public TbRichTextView kBw;
    public ConstrainImageGroup kBx;
    public View kBy;
    public SubPbLayout kBz;
    public TextView kCa;
    public ImageView kCb;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.kAo = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.kBo = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.gVX = (TextView) view.findViewById(R.id.view_user_name);
            this.kBp = (TextView) view.findViewById(R.id.view_author_tip);
            this.kBq = (TextView) view.findViewById(R.id.view_post_time);
            this.kBN = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.kBt = (TextView) view.findViewById(R.id.view_location);
            this.kBy = view.findViewById(R.id.pb_post_reply_container);
            this.kBC = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.iTV = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.kBu = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.kBu.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.kBu.setNormalColorResourceId(R.color.cp_cont_d);
            this.kBu.ir(false);
            this.kBD = view.findViewById(R.id.pb_floor_trisection_area);
            this.kBE = view.findViewById(R.id.pb_floor_share_container);
            this.kBF = view.findViewById(R.id.pb_floor_comment_container);
            this.kBG = view.findViewById(R.id.pb_floor_agree_container);
            this.kBH = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.kBI = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.kBJ = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.kBK = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.kBL = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.kBL.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.kBL.setNormalColorResourceId(R.color.cp_cont_d);
            this.kBL.ir(true);
            if (z && z2) {
                this.kBy.setVisibility(8);
                this.kBD.setVisibility(0);
            } else if (z) {
                this.kBD.setVisibility(0);
                this.kBy.setVisibility(0);
                this.kBC.setVisibility(8);
                this.iTV.setVisibility(8);
                this.kBu.setVisibility(8);
            } else {
                this.kBD.setVisibility(8);
                this.kBy.setVisibility(0);
                this.kBC.setVisibility(0);
                this.iTV.setVisibility(0);
                this.kBu.setVisibility(0);
            }
            this.kBR = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aED = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dWO = 5;
            cVar.dWU = 8;
            cVar.dWT = 2;
            cVar.dWS = i;
            this.kBu.setStatisticData(cVar);
            this.kBv = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.kBO = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.kBO.setHasPendantStyle();
            if (this.kBO.getHeadView() != null) {
                this.kBO.getHeadView().setIsRound(true);
                this.kBO.getHeadView().setDrawBorder(false);
                this.kBO.getHeadView().setPlaceHolder(1);
            }
            this.kBP = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.kBQ = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.kBw = (TbRichTextView) view.findViewById(R.id.richText);
            this.kBz = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.kBA = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.kBA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.kBA.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.kBA.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.kBB = (TextView) view.findViewById(R.id.pb_post_reply);
            this.kBx = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.kBM = (TextView) view.findViewById(R.id.floor_num);
            this.kBr = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.kBs = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.kBx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.kBx.setSingleImageRatio(0.75d);
            this.kBx.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.kBw.getLayoutStrategy());
            cVar2.rm(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kBw.setLayoutStrategy(cVar2);
            this.kBw.setTextSize(TbConfig.getContentSize());
            this.kBv.setIsRound(true);
            this.kBv.setGodIconWidth(R.dimen.tbds31);
            this.kBv.setPlaceHolder(1);
            this.kBw.setDisplayImage(this.kAo, false);
            this.kBw.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.kBS = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.kBT = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.kBU = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.kBV = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.kBW = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.kBX = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.kBY = (LinearLayout) view.findViewById(R.id.all_content);
            this.kBZ = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.kCa = (TextView) view.findViewById(R.id.fold_title);
            this.kCb = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.aiG = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        }
    }

    public void sR(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dWO = 12;
            cVar.dWU = 9;
            cVar.dWT = 3;
            cVar.dWS = this.aED;
            this.kBu.setStatisticData(cVar);
        }
    }

    public void rv(boolean z) {
        if (z) {
            this.aiG.setVisibility(0);
            if (!this.aiG.isAnimating()) {
                this.aiG.setSpeed(0.8f);
                this.aiG.setRepeatCount(-1);
                this.aiG.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.aiG.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.aiG.setVisibility(8);
        if (this.aiG.isAnimating()) {
            this.aiG.cancelAnimation();
        }
    }

    public void Cc(int i) {
        if (i == 1) {
            this.aiG.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.aiG.setAnimation("live/card_live_bg_black.json");
        } else {
            this.aiG.setAnimation("live/card_live_bg.json");
        }
    }
}
