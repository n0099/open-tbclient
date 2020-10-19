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
/* loaded from: classes22.dex */
public class n extends af.a {
    public int aIS;
    private TBLottieAnimationView ajs;
    public TextView hoF;
    public ImageView jrA;
    public boolean kXW;
    public View kYX;
    public TextView kYY;
    public TextView kYZ;
    public ImageView kZA;
    public TextView kZB;
    public LinearLayout kZC;
    public TextView kZD;
    public View kZE;
    public TextView kZF;
    public ImageView kZG;
    public LinearLayout kZH;
    public LinearLayout kZI;
    public TextView kZJ;
    public ImageView kZK;
    public TextView kZa;
    public TextView kZb;
    public TextView kZc;
    public AgreeView kZd;
    public HeadImageView kZe;
    public TbRichTextView kZf;
    public ConstrainImageGroup kZg;
    public View kZh;
    public SubPbLayout kZi;
    public TextView kZj;
    public TextView kZk;
    public ImageView kZl;
    public View kZm;
    public View kZn;
    public View kZo;
    public View kZp;
    public ImageView kZq;
    public TextView kZr;
    public ImageView kZs;
    public TextView kZt;
    public AgreeView kZu;
    public TextView kZv;
    public ImageView kZw;
    public HeadPendantView kZx;
    public UserIconBox kZy;
    public UserIconBox kZz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public n(TbPageContext tbPageContext, View view, int i, boolean z, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.kXW = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.kYX = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.hoF = (TextView) view.findViewById(R.id.view_user_name);
            this.kYY = (TextView) view.findViewById(R.id.view_author_tip);
            this.kYZ = (TextView) view.findViewById(R.id.view_post_time);
            this.kZw = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.kZc = (TextView) view.findViewById(R.id.view_location);
            this.kZh = view.findViewById(R.id.pb_post_reply_container);
            this.kZl = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.jrA = (ImageView) view.findViewById(R.id.post_info_share_img);
            this.kZd = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            this.kZd.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.kZd.setNormalColorResourceId(R.color.cp_cont_d);
            this.kZd.iM(false);
            this.kZm = view.findViewById(R.id.pb_floor_trisection_area);
            this.kZn = view.findViewById(R.id.pb_floor_share_container);
            this.kZo = view.findViewById(R.id.pb_floor_comment_container);
            this.kZp = view.findViewById(R.id.pb_floor_agree_container);
            this.kZq = (ImageView) view.findViewById(R.id.pb_floor_share_img);
            this.kZr = (TextView) view.findViewById(R.id.pb_floor_share_text);
            this.kZs = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
            this.kZt = (TextView) view.findViewById(R.id.pb_floor_comment_text);
            this.kZu = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
            this.kZu.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.kZu.setNormalColorResourceId(R.color.cp_cont_d);
            this.kZu.iM(true);
            if (z && z2) {
                this.kZh.setVisibility(8);
                this.kZm.setVisibility(0);
            } else if (z) {
                this.kZm.setVisibility(0);
                this.kZh.setVisibility(0);
                this.kZl.setVisibility(8);
                this.jrA.setVisibility(8);
                this.kZd.setVisibility(8);
            } else {
                this.kZm.setVisibility(8);
                this.kZh.setVisibility(0);
                this.kZl.setVisibility(0);
                this.jrA.setVisibility(0);
                this.kZd.setVisibility(0);
            }
            this.kZA = (ImageView) view.findViewById(R.id.pb_floor_feedback);
            this.aIS = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.ela = 5;
            cVar.elg = 8;
            cVar.elf = 2;
            cVar.ele = i;
            this.kZd.setStatisticData(cVar);
            this.kZe = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.kZx = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.kZx.setHasPendantStyle();
            if (this.kZx.getHeadView() != null) {
                this.kZx.getHeadView().setIsRound(true);
                this.kZx.getHeadView().setDrawBorder(false);
                this.kZx.getHeadView().setPlaceHolder(1);
            }
            this.kZy = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.kZz = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.kZf = (TbRichTextView) view.findViewById(R.id.richText);
            this.kZi = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.kZj = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.kZj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.kZj.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.kZj.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.kZk = (TextView) view.findViewById(R.id.pb_post_reply);
            this.kZg = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.kZv = (TextView) view.findViewById(R.id.floor_num);
            this.kZa = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.kZb = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.kZg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.kZg.setSingleImageRatio(0.75d);
            this.kZg.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.kZf.getLayoutStrategy());
            cVar2.sb(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kZf.setLayoutStrategy(cVar2);
            this.kZf.setTextSize(TbConfig.getContentSize());
            this.kZe.setIsRound(true);
            this.kZe.setGodIconWidth(R.dimen.tbds31);
            this.kZe.setPlaceHolder(1);
            this.kZf.setDisplayImage(this.kXW, false);
            this.kZf.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.kZB = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.kZC = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.kZD = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.kZE = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.kZF = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.kZG = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.kZH = (LinearLayout) view.findViewById(R.id.all_content);
            this.kZI = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.kZJ = (TextView) view.findViewById(R.id.fold_title);
            this.kZK = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.ajs = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        }
    }

    public void tF(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.ela = 12;
            cVar.elg = 9;
            cVar.elf = 3;
            cVar.ele = this.aIS;
            this.kZd.setStatisticData(cVar);
        }
    }

    public void sj(boolean z) {
        if (z) {
            this.ajs.setVisibility(0);
            if (!this.ajs.isAnimating()) {
                this.ajs.setSpeed(0.8f);
                this.ajs.setRepeatCount(-1);
                this.ajs.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.ajs.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ajs.setVisibility(8);
        if (this.ajs.isAnimating()) {
            this.ajs.cancelAnimation();
        }
    }

    public void Dj(int i) {
        if (i == 1) {
            this.ajs.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ajs.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ajs.setAnimation("live/card_live_bg.json");
        }
    }
}
