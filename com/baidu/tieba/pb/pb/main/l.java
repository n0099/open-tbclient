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
/* loaded from: classes6.dex */
public class l extends v.a {
    public int Wq;
    public TextView fqP;
    public AgreeView iAA;
    public HeadImageView iAB;
    public TbRichTextView iAC;
    public ConstrainImageGroup iAD;
    public SubPbLayout iAE;
    public TextView iAF;
    public TextView iAG;
    public TextView iAH;
    public ImageView iAI;
    public HeadPendantView iAJ;
    public UserIconBox iAK;
    public UserIconBox iAL;
    public TextView iAM;
    public LinearLayout iAN;
    public TextView iAO;
    public View iAP;
    public TextView iAQ;
    public ImageView iAR;
    public LinearLayout iAS;
    public LinearLayout iAT;
    public TextView iAU;
    public ImageView iAV;
    public View iAu;
    public TextView iAv;
    public TextView iAw;
    public TextView iAx;
    public TextView iAy;
    public TextView iAz;
    public boolean izw;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public l(TbPageContext tbPageContext, View view, int i) {
        super(view);
        this.mSkinType = 3;
        this.izw = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.iAu = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.fqP = (TextView) view.findViewById(R.id.view_user_name);
            this.iAv = (TextView) view.findViewById(R.id.view_author_tip);
            this.iAw = (TextView) view.findViewById(R.id.view_post_time);
            this.iAI = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.iAz = (TextView) view.findViewById(R.id.view_location);
            this.iAA = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.iAA.aEJ();
            this.Wq = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cJm = 5;
            dVar.cJs = 8;
            dVar.cJr = 2;
            dVar.cJq = i;
            this.iAA.setStatisticData(dVar);
            this.iAB = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.iAJ = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.iAJ.setHasPendantStyle();
            if (this.iAJ.getHeadView() != null) {
                this.iAJ.getHeadView().setIsRound(true);
                this.iAJ.getHeadView().setDrawBorder(false);
                this.iAJ.getHeadView().setPlaceHolder(1);
            }
            this.iAK = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.iAL = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.iAC = (TbRichTextView) view.findViewById(R.id.richText);
            this.iAE = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.iAF = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.iAF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.iAF.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.iAF.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.iAG = (TextView) view.findViewById(R.id.pb_post_reply);
            this.iAD = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.iAH = (TextView) view.findViewById(R.id.floor_num);
            this.iAx = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.iAy = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.iAD.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.iAD.setSingleImageRatio(0.75d);
            this.iAD.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.iAC.getLayoutStrategy());
            bVar.na(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iAC.setLayoutStrategy(bVar);
            this.iAC.setTextSize(TbConfig.getContentSize());
            this.iAB.setIsRound(true);
            this.iAB.setGodIconWidth(R.dimen.tbds31);
            this.iAB.setPlaceHolder(1);
            this.iAC.setDisplayImage(this.izw, false);
            this.iAC.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.iAM = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.iAN = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.iAO = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.iAP = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.iAQ = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.iAR = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.iAS = (LinearLayout) view.findViewById(R.id.all_content);
            this.iAT = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.iAU = (TextView) view.findViewById(R.id.fold_title);
            this.iAV = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void pt(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cJm = 12;
            dVar.cJs = 9;
            dVar.cJr = 3;
            dVar.cJq = this.Wq;
            this.iAA.setStatisticData(dVar);
        }
    }
}
