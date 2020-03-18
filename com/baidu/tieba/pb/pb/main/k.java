package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes9.dex */
public class k extends v.a {
    public int YF;
    public TextView fxu;
    public boolean iGw;
    public ConstrainImageGroup iHA;
    public SubPbLayout iHB;
    public TextView iHC;
    public TextView iHD;
    public TextView iHE;
    public ImageView iHF;
    public HeadPendantView iHG;
    public UserIconBox iHH;
    public UserIconBox iHI;
    public TextView iHJ;
    public LinearLayout iHK;
    public TextView iHL;
    public View iHM;
    public TextView iHN;
    public ImageView iHO;
    public LinearLayout iHP;
    public LinearLayout iHQ;
    public TextView iHR;
    public ImageView iHS;
    public View iHr;
    public TextView iHs;
    public TextView iHt;
    public TextView iHu;
    public TextView iHv;
    public TextView iHw;
    public AgreeView iHx;
    public HeadImageView iHy;
    public TbRichTextView iHz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public k(TbPageContext tbPageContext, View view, int i) {
        super(view);
        this.mSkinType = 3;
        this.iGw = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.iHr = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.fxu = (TextView) view.findViewById(R.id.view_user_name);
            this.iHs = (TextView) view.findViewById(R.id.view_author_tip);
            this.iHt = (TextView) view.findViewById(R.id.view_post_time);
            this.iHF = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.iHw = (TextView) view.findViewById(R.id.view_location);
            this.iHx = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.iHx.aHv();
            this.YF = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cNP = 5;
            dVar.cNV = 8;
            dVar.cNU = 2;
            dVar.cNT = i;
            this.iHx.setStatisticData(dVar);
            this.iHy = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.iHG = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.iHG.setHasPendantStyle();
            if (this.iHG.getHeadView() != null) {
                this.iHG.getHeadView().setIsRound(true);
                this.iHG.getHeadView().setDrawBorder(false);
                this.iHG.getHeadView().setPlaceHolder(1);
            }
            this.iHH = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.iHI = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.iHz = (TbRichTextView) view.findViewById(R.id.richText);
            this.iHB = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.iHC = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.iHC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.iHC.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.iHC.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.iHD = (TextView) view.findViewById(R.id.pb_post_reply);
            this.iHA = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.iHE = (TextView) view.findViewById(R.id.floor_num);
            this.iHu = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.iHv = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.iHA.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.iHA.setSingleImageRatio(0.75d);
            this.iHA.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.iHz.getLayoutStrategy());
            bVar.nt(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iHz.setLayoutStrategy(bVar);
            this.iHz.setTextSize(TbConfig.getContentSize());
            this.iHy.setIsRound(true);
            this.iHy.setGodIconWidth(R.dimen.tbds31);
            this.iHy.setPlaceHolder(1);
            this.iHz.setDisplayImage(this.iGw, false);
            this.iHz.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.iHJ = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.iHK = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.iHL = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.iHM = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.iHN = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.iHO = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.iHP = (LinearLayout) view.findViewById(R.id.all_content);
            this.iHQ = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.iHR = (TextView) view.findViewById(R.id.fold_title);
            this.iHS = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void pO(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cNP = 12;
            dVar.cNV = 9;
            dVar.cNU = 3;
            dVar.cNT = this.YF;
            this.iHx.setStatisticData(dVar);
        }
    }
}
