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
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes4.dex */
public class j extends v.a {
    public TextView enZ;
    public boolean hMT;
    public LinearLayout hNA;
    public TextView hNB;
    public TextView hNC;
    public TextView hND;
    public TextView hNE;
    public TextView hNF;
    public AgreeView hNG;
    public HeadImageView hNH;
    public TbRichTextView hNI;
    public ConstrainImageGroup hNJ;
    public SubPbLayout hNK;
    public TextView hNL;
    public TextView hNM;
    public TextView hNN;
    public ImageView hNO;
    public HeadPendantView hNP;
    public UserIconBox hNQ;
    public UserIconBox hNR;
    public TextView hNS;
    public LinearLayout hNT;
    public TextView hNU;
    public View hNV;
    public TextView hNW;
    public ImageView hNX;
    public LinearLayout hNY;
    public LinearLayout hNZ;
    public View hNz;
    public TextView hOa;
    public ImageView hOb;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hMT = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hNz = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.enZ = (TextView) view.findViewById(R.id.view_user_name);
            this.hNA = (LinearLayout) view.findViewById(R.id.content_user_and_praise);
            this.hNB = (TextView) view.findViewById(R.id.view_author_tip);
            this.hNC = (TextView) view.findViewById(R.id.view_post_time);
            this.hNO = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.hNF = (TextView) view.findViewById(R.id.view_location);
            this.hNG = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.hNG.setAgreeAnimationResource(R.raw.agree);
            this.hNG.setDisagreeAnimationResource(R.raw.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bFz = 5;
            dVar.bFE = 8;
            dVar.bFD = 2;
            this.hNG.setStatisticData(dVar);
            this.hNG.setLayoutParams(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds112), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds17), com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds7), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds3), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds13));
            this.hNH = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.hNP = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.hNP.setHasPendantStyle();
            if (this.hNP.getHeadView() != null) {
                this.hNP.getHeadView().setIsRound(true);
                this.hNP.getHeadView().setDrawBorder(false);
            }
            this.hNQ = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.hNR = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.hNI = (TbRichTextView) view.findViewById(R.id.richText);
            this.hNK = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.hNL = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.hNL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.hNL.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.hNL.setTextSize(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.hNM = (TextView) view.findViewById(R.id.pb_post_reply);
            this.hNJ = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.hNN = (TextView) view.findViewById(R.id.floor_num);
            this.hND = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.hNE = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.hNJ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.hNJ.setSingleImageRatio(0.75d);
            this.hNJ.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hNI.getLayoutStrategy());
            bVar.lC(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hNI.setLayoutStrategy(bVar);
            this.hNI.setTextSize(TbConfig.getContentSize());
            this.hNH.setIsRound(true);
            this.hNI.setDisplayImage(this.hMT, false);
            this.hNI.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.hNS = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.hNT = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.hNU = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.hNV = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.hNW = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.hNX = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.hNY = (LinearLayout) view.findViewById(R.id.all_content);
            this.hNZ = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.hOa = (TextView) view.findViewById(R.id.fold_title);
            this.hOb = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void ox(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bFz = 12;
            dVar.bFE = 9;
            dVar.bFD = 3;
            this.hNG.setStatisticData(dVar);
        }
    }
}
