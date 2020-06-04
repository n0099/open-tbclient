package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
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
/* loaded from: classes9.dex */
public class l extends aa.a {
    private TBLottieAnimationView agv;
    public int avV;
    public TextView gre;
    public ImageView ihG;
    public boolean jIB;
    public View jJB;
    public TextView jJC;
    public TextView jJD;
    public TextView jJE;
    public TextView jJF;
    public TextView jJG;
    public AgreeView jJH;
    public AgreeView jJI;
    public HeadImageView jJJ;
    public TbRichTextView jJK;
    public ConstrainImageGroup jJL;
    public SubPbLayout jJM;
    public TextView jJN;
    public TextView jJO;
    public ImageView jJP;
    public TextView jJQ;
    public ImageView jJR;
    public HeadPendantView jJS;
    public UserIconBox jJT;
    public UserIconBox jJU;
    public TextView jJV;
    public LinearLayout jJW;
    public TextView jJX;
    public View jJY;
    public TextView jJZ;
    public boolean jJt;
    public ImageView jKa;
    public LinearLayout jKb;
    public LinearLayout jKc;
    public TextView jKd;
    public ImageView jKe;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public l(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.jIB = true;
        this.mPosition = -1;
        this.jJt = false;
        if (tbPageContext != null && view != null) {
            this.jJt = z;
            this.jJB = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.gre = (TextView) view.findViewById(R.id.view_user_name);
            this.jJC = (TextView) view.findViewById(R.id.view_author_tip);
            this.jJD = (TextView) view.findViewById(R.id.view_post_time);
            this.jJR = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.jJG = (TextView) view.findViewById(R.id.view_location);
            this.jJP = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.ihG = (ImageView) view.findViewById(R.id.post_info_share_img);
            if (z) {
                this.jJH = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
                this.jJH.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
                this.jJH.setNormalColorResourceId(R.color.cp_cont_d);
                this.jJI = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            } else {
                this.jJH = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
                this.jJI = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            }
            this.jJH.setVisibility(0);
            this.jJI.setVisibility(8);
            this.jJH.hf(z);
            this.avV = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dAZ = 5;
            cVar.dBf = 8;
            cVar.dBe = 2;
            cVar.dBd = i;
            this.jJH.setStatisticData(cVar);
            this.jJJ = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.jJS = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.jJS.setHasPendantStyle();
            if (this.jJS.getHeadView() != null) {
                this.jJS.getHeadView().setIsRound(true);
                this.jJS.getHeadView().setDrawBorder(false);
                this.jJS.getHeadView().setPlaceHolder(1);
            }
            this.jJT = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.jJU = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.jJK = (TbRichTextView) view.findViewById(R.id.richText);
            this.jJM = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.jJN = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.jJN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.jJN.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.jJN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.jJO = (TextView) view.findViewById(R.id.pb_post_reply);
            this.jJL = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.jJQ = (TextView) view.findViewById(R.id.floor_num);
            this.jJE = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.jJF = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.jJL.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.jJL.setSingleImageRatio(0.75d);
            this.jJL.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.jJK.getLayoutStrategy());
            cVar2.ok(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.jJK.setLayoutStrategy(cVar2);
            this.jJK.setTextSize(TbConfig.getContentSize());
            this.jJJ.setIsRound(true);
            this.jJJ.setGodIconWidth(R.dimen.tbds31);
            this.jJJ.setPlaceHolder(1);
            this.jJK.setDisplayImage(this.jIB, false);
            this.jJK.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.jJV = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.jJW = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.jJX = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.jJY = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.jJZ = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.jKa = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.jKb = (LinearLayout) view.findViewById(R.id.all_content);
            this.jKc = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.jKd = (TextView) view.findViewById(R.id.fold_title);
            this.jKe = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.agv = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        }
    }

    public void rq(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dAZ = 12;
            cVar.dBf = 9;
            cVar.dBe = 3;
            cVar.dBd = this.avV;
            this.jJH.setStatisticData(cVar);
        }
    }

    public void pW(boolean z) {
        if (z) {
            this.agv.setVisibility(0);
            if (!this.agv.isAnimating()) {
                this.agv.setSpeed(0.8f);
                this.agv.setRepeatCount(-1);
                this.agv.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.agv.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.agv.setVisibility(8);
        if (this.agv.isAnimating()) {
            this.agv.cancelAnimation();
        }
    }

    public void yy(int i) {
        if (i == 1) {
            this.agv.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.agv.setAnimation("live/card_live_bg_black.json");
        } else {
            this.agv.setAnimation("live/card_live_bg.json");
        }
    }
}
