package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
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
public class l extends ad.a {
    private TBLottieAnimationView ahz;
    public int ayd;
    public TextView gDT;
    public ImageView iyL;
    public boolean kcl;
    public HeadPendantView kdA;
    public UserIconBox kdB;
    public UserIconBox kdC;
    public TextView kdD;
    public LinearLayout kdE;
    public TextView kdF;
    public View kdG;
    public TextView kdH;
    public ImageView kdI;
    public LinearLayout kdJ;
    public LinearLayout kdK;
    public TextView kdL;
    public ImageView kdM;
    public boolean kdb;
    public View kdj;
    public TextView kdk;
    public TextView kdl;
    public TextView kdm;
    public TextView kdn;
    public TextView kdo;
    public AgreeView kdp;
    public AgreeView kdq;
    public HeadImageView kdr;
    public TbRichTextView kds;
    public ConstrainImageGroup kdt;
    public SubPbLayout kdu;
    public TextView kdv;
    public TextView kdw;
    public ImageView kdx;
    public TextView kdy;
    public ImageView kdz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public l(TbPageContext tbPageContext, View view, int i, boolean z) {
        super(view);
        this.mSkinType = 3;
        this.kcl = true;
        this.mPosition = -1;
        this.kdb = false;
        if (tbPageContext != null && view != null) {
            this.kdb = z;
            this.kdj = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.gDT = (TextView) view.findViewById(R.id.view_user_name);
            this.kdk = (TextView) view.findViewById(R.id.view_author_tip);
            this.kdl = (TextView) view.findViewById(R.id.view_post_time);
            this.kdz = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.kdo = (TextView) view.findViewById(R.id.view_location);
            this.kdx = (ImageView) view.findViewById(R.id.post_info_commont_img);
            this.iyL = (ImageView) view.findViewById(R.id.post_info_share_img);
            if (z) {
                this.kdp = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
                this.kdp.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
                this.kdp.setNormalColorResourceId(R.color.cp_cont_d);
                this.kdq = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            } else {
                this.kdp = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
                this.kdq = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
            }
            this.kdp.setVisibility(0);
            this.kdq.setVisibility(8);
            this.kdp.ho(z);
            this.ayd = i;
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dHq = 5;
            cVar.dHw = 8;
            cVar.dHv = 2;
            cVar.dHu = i;
            this.kdp.setStatisticData(cVar);
            this.kdr = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.kdA = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.kdA.setHasPendantStyle();
            if (this.kdA.getHeadView() != null) {
                this.kdA.getHeadView().setIsRound(true);
                this.kdA.getHeadView().setDrawBorder(false);
                this.kdA.getHeadView().setPlaceHolder(1);
            }
            this.kdB = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.kdC = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.kds = (TbRichTextView) view.findViewById(R.id.richText);
            this.kdu = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.kdv = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.kdv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.kdv.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.kdv.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.kdw = (TextView) view.findViewById(R.id.pb_post_reply);
            this.kdt = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.kdy = (TextView) view.findViewById(R.id.floor_num);
            this.kdm = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.kdn = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.kdt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.kdt.setSingleImageRatio(0.75d);
            this.kdt.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            c cVar2 = new c(this.kds.getLayoutStrategy());
            cVar2.oH(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            cVar2.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kds.setLayoutStrategy(cVar2);
            this.kds.setTextSize(TbConfig.getContentSize());
            this.kdr.setIsRound(true);
            this.kdr.setGodIconWidth(R.dimen.tbds31);
            this.kdr.setPlaceHolder(1);
            this.kds.setDisplayImage(this.kcl, false);
            this.kds.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.kdD = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.kdE = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.kdF = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.kdG = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.kdH = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.kdI = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.kdJ = (LinearLayout) view.findViewById(R.id.all_content);
            this.kdK = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.kdL = (TextView) view.findViewById(R.id.fold_title);
            this.kdM = (ImageView) view.findViewById(R.id.pic_comment_god);
            this.ahz = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        }
    }

    public void rD(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dHq = 12;
            cVar.dHw = 9;
            cVar.dHv = 3;
            cVar.dHu = this.ayd;
            this.kdp.setStatisticData(cVar);
        }
    }

    public void qg(boolean z) {
        if (z) {
            this.ahz.setVisibility(0);
            if (!this.ahz.isAnimating()) {
                this.ahz.setSpeed(0.8f);
                this.ahz.setRepeatCount(-1);
                this.ahz.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.ahz.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ahz.setVisibility(8);
        if (this.ahz.isAnimating()) {
            this.ahz.cancelAnimation();
        }
    }

    public void zk(int i) {
        if (i == 1) {
            this.ahz.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ahz.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ahz.setAnimation("live/card_live_bg.json");
        }
    }
}
