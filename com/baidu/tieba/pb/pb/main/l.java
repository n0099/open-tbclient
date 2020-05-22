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
    public TextView gqT;
    public ImageView igT;
    public boolean jHv;
    public TextView jIA;
    public AgreeView jIB;
    public AgreeView jIC;
    public HeadImageView jID;
    public TbRichTextView jIE;
    public ConstrainImageGroup jIF;
    public SubPbLayout jIG;
    public TextView jIH;
    public TextView jII;
    public ImageView jIJ;
    public TextView jIK;
    public ImageView jIL;
    public HeadPendantView jIM;
    public UserIconBox jIN;
    public UserIconBox jIO;
    public TextView jIP;
    public LinearLayout jIQ;
    public TextView jIR;
    public View jIS;
    public TextView jIT;
    public ImageView jIU;
    public LinearLayout jIV;
    public LinearLayout jIW;
    public TextView jIX;
    public ImageView jIY;
    public boolean jIn;
    public View jIv;
    public TextView jIw;
    public TextView jIx;
    public TextView jIy;
    public TextView jIz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public l(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.jHv = true;
        this.mPosition = -1;
        this.jIn = false;
        if (tbPageContext != null && view != null) {
            this.jIn = z;
            this.jIv = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.gqT = (TextView) view.findViewById(R.id.view_user_name);
            this.jIw = (TextView) view.findViewById(R.id.view_author_tip);
            this.jIx = (TextView) view.findViewById(R.id.view_post_time);
            this.jIL = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.jIA = (TextView) view.findViewById(R.id.view_location);
            this.jIJ = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.igT = (ImageView) view.findViewById(R.id.post_info_share_img);
            if (z) {
                this.jIB = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
                this.jIB.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
                this.jIB.setNormalColorResourceId(R.color.cp_cont_d);
                this.jIC = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            } else {
                this.jIB = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
                this.jIC = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            }
            this.jIB.setVisibility(0);
            this.jIC.setVisibility(8);
            this.jIB.hf(z);
            this.avV = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dAZ = 5;
            cVar.dBf = 8;
            cVar.dBe = 2;
            cVar.dBd = i;
            this.jIB.setStatisticData(cVar);
            this.jID = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.jIM = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.jIM.setHasPendantStyle();
            if (this.jIM.getHeadView() != null) {
                this.jIM.getHeadView().setIsRound(true);
                this.jIM.getHeadView().setDrawBorder(false);
                this.jIM.getHeadView().setPlaceHolder(1);
            }
            this.jIN = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.jIO = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.jIE = (TbRichTextView) view.findViewById(R.id.richText);
            this.jIG = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.jIH = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.jIH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.jIH.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.jIH.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.jII = (TextView) view.findViewById(R.id.pb_post_reply);
            this.jIF = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.jIK = (TextView) view.findViewById(R.id.floor_num);
            this.jIy = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.jIz = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.jIF.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.jIF.setSingleImageRatio(0.75d);
            this.jIF.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.jIE.getLayoutStrategy());
            cVar2.oi(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.jIE.setLayoutStrategy(cVar2);
            this.jIE.setTextSize(TbConfig.getContentSize());
            this.jID.setIsRound(true);
            this.jID.setGodIconWidth(R.dimen.tbds31);
            this.jID.setPlaceHolder(1);
            this.jIE.setDisplayImage(this.jHv, false);
            this.jIE.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.jIP = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.jIQ = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.jIR = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.jIS = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.jIT = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.jIU = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.jIV = (LinearLayout) view.findViewById(R.id.all_content);
            this.jIW = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.jIX = (TextView) view.findViewById(R.id.fold_title);
            this.jIY = (ImageView) view.findViewById(R.id.pic_comment_god);
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
            this.jIB.setStatisticData(cVar);
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

    public void yw(int i) {
        if (i == 1) {
            this.agv.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.agv.setAnimation("live/card_live_bg_black.json");
        } else {
            this.agv.setAnimation("live/card_live_bg.json");
        }
    }
}
