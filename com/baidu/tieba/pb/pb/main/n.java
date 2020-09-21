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
/* loaded from: classes21.dex */
public class n extends af.a {
    public int aFO;
    private TBLottieAnimationView aja;
    public TextView gZE;
    public ImageView jcB;
    public boolean kIL;
    public View kJM;
    public TextView kJN;
    public TextView kJO;
    public TextView kJP;
    public TextView kJQ;
    public TextView kJR;
    public AgreeView kJS;
    public HeadImageView kJT;
    public TbRichTextView kJU;
    public ConstrainImageGroup kJV;
    public View kJW;
    public SubPbLayout kJX;
    public TextView kJY;
    public TextView kJZ;
    public ImageView kKa;
    public View kKb;
    public View kKc;
    public View kKd;
    public View kKe;
    public ImageView kKf;
    public TextView kKg;
    public ImageView kKh;
    public TextView kKi;
    public AgreeView kKj;
    public TextView kKk;
    public ImageView kKl;
    public HeadPendantView kKm;
    public UserIconBox kKn;
    public UserIconBox kKo;
    public ImageView kKp;
    public TextView kKq;
    public LinearLayout kKr;
    public TextView kKs;
    public View kKt;
    public TextView kKu;
    public ImageView kKv;
    public LinearLayout kKw;
    public LinearLayout kKx;
    public TextView kKy;
    public ImageView kKz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.kIL = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.kJM = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.gZE = (TextView) view.findViewById(R.id.view_user_name);
            this.kJN = (TextView) view.findViewById(R.id.view_author_tip);
            this.kJO = (TextView) view.findViewById(R.id.view_post_time);
            this.kKl = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.kJR = (TextView) view.findViewById(R.id.view_location);
            this.kJW = view.findViewById(R.id.pb_post_reply_container);
            this.kKa = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jcB = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.kJS = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.kJS.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.kJS.setNormalColorResourceId(R.color.cp_cont_d);
            this.kJS.io(false);
            this.kKb = view.findViewById(R.id.pb_floor_trisection_area);
            this.kKc = view.findViewById(R.id.pb_floor_share_container);
            this.kKd = view.findViewById(R.id.pb_floor_comment_container);
            this.kKe = view.findViewById(R.id.pb_floor_agree_container);
            this.kKf = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.kKg = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.kKh = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.kKi = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.kKj = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.kKj.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.kKj.setNormalColorResourceId(R.color.cp_cont_d);
            this.kKj.io(true);
            if (z && z2) {
                this.kJW.setVisibility(8);
                this.kKb.setVisibility(0);
            } else if (z) {
                this.kKb.setVisibility(0);
                this.kJW.setVisibility(0);
                this.kKa.setVisibility(8);
                this.jcB.setVisibility(8);
                this.kJS.setVisibility(8);
            } else {
                this.kKb.setVisibility(8);
                this.kJW.setVisibility(0);
                this.kKa.setVisibility(0);
                this.jcB.setVisibility(0);
                this.kJS.setVisibility(0);
            }
            this.kKp = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aFO = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dYY = 5;
            cVar.dZe = 8;
            cVar.dZd = 2;
            cVar.dZc = i;
            this.kJS.setStatisticData(cVar);
            this.kJT = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.kKm = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.kKm.setHasPendantStyle();
            if (this.kKm.getHeadView() != null) {
                this.kKm.getHeadView().setIsRound(true);
                this.kKm.getHeadView().setDrawBorder(false);
                this.kKm.getHeadView().setPlaceHolder(1);
            }
            this.kKn = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.kKo = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.kJU = (TbRichTextView) view.findViewById(R.id.richText);
            this.kJX = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.kJY = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.kJY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.kJY.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.kJY.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.kJZ = (TextView) view.findViewById(R.id.pb_post_reply);
            this.kJV = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.kKk = (TextView) view.findViewById(R.id.floor_num);
            this.kJP = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.kJQ = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.kJV.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.kJV.setSingleImageRatio(0.75d);
            this.kJV.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.kJU.getLayoutStrategy());
            cVar2.rD(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kJU.setLayoutStrategy(cVar2);
            this.kJU.setTextSize(TbConfig.getContentSize());
            this.kJT.setIsRound(true);
            this.kJT.setGodIconWidth(R.dimen.tbds31);
            this.kJT.setPlaceHolder(1);
            this.kJU.setDisplayImage(this.kIL, false);
            this.kJU.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.kKq = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.kKr = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.kKs = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.kKt = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.kKu = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.kKv = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.kKw = (LinearLayout) view.findViewById(R.id.all_content);
            this.kKx = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.kKy = (TextView) view.findViewById(R.id.fold_title);
            this.kKz = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.aja = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        }
    }

    public void sY(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dYY = 12;
            cVar.dZe = 9;
            cVar.dZd = 3;
            cVar.dZc = this.aFO;
            this.kJS.setStatisticData(cVar);
        }
    }

    public void rD(boolean z) {
        if (z) {
            this.aja.setVisibility(0);
            if (!this.aja.isAnimating()) {
                this.aja.setSpeed(0.8f);
                this.aja.setRepeatCount(-1);
                this.aja.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.aja.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.aja.setVisibility(8);
        if (this.aja.isAnimating()) {
            this.aja.cancelAnimation();
        }
    }

    public void CD(int i) {
        if (i == 1) {
            this.aja.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.aja.setAnimation("live/card_live_bg_black.json");
        } else {
            this.aja.setAnimation("live/card_live_bg.json");
        }
    }
}
