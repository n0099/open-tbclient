package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.PostDisPraiseView;
import com.baidu.tbadk.core.view.PostPraiseView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes6.dex */
public class j extends q.a {
    public TextView cGZ;
    public boolean fMU;
    public TextView fNA;
    public View fNB;
    public View fNC;
    public TextView fND;
    public ImageView fNE;
    public PostPraiseView fNF;
    public PostDisPraiseView fNG;
    public HeadImageView fNH;
    public TbRichTextView fNI;
    public ConstrainImageGroup fNJ;
    public SubPbLayout fNK;
    public TextView fNL;
    public ImageView fNM;
    public HeadPendantView fNN;
    public UserIconBox fNO;
    public UserIconBox fNP;
    public TextView fNQ;
    public LinearLayout fNR;
    public TextView fNS;
    public View fNT;
    public TextView fNU;
    public ImageView fNV;
    public LinearLayout fNW;
    public LinearLayout fNX;
    public TextView fNY;
    public ImageView fNZ;
    public View fNx;
    public LinearLayout fNy;
    public TextView fNz;
    public com.baidu.tbadk.core.view.a fOa;
    public View mBottomLine;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fMU = true;
        if (tbPageContext != null && view != null) {
            this.fNx = view;
            this.mTopLine = view.findViewById(e.g.top_divider_line);
            this.cGZ = (TextView) view.findViewById(e.g.view_user_name);
            this.fNy = (LinearLayout) view.findViewById(e.g.content_user_and_praise);
            this.fNz = (TextView) view.findViewById(e.g.view_author_tip);
            this.fNA = (TextView) view.findViewById(e.g.view_post_time);
            this.fNM = (ImageView) view.findViewById(e.g.icon_forum_level);
            this.fND = (TextView) view.findViewById(e.g.view_location);
            this.fNE = (ImageView) view.findViewById(e.g.image_more_tip);
            this.fNF = (PostPraiseView) view.findViewById(e.g.view_floor_new_praise);
            this.fNG = (PostDisPraiseView) view.findViewById(e.g.view_floor_new_dispraise);
            this.fOa = new com.baidu.tbadk.core.view.a(this.fNF, this.fNG, this.fNE);
            this.fNH = (HeadImageView) view.findViewById(e.g.normal_user_photo);
            this.fNN = (HeadPendantView) view.findViewById(e.g.pendant_user_photo);
            this.fNN.setHasPendantStyle();
            if (this.fNN.getHeadView() != null) {
                this.fNN.getHeadView().setIsRound(true);
                this.fNN.getHeadView().setDrawBorder(false);
            }
            this.fNO = (UserIconBox) view.findViewById(e.g.show_icon_vip);
            this.fNP = (UserIconBox) view.findViewById(e.g.show_icon_yinji);
            this.fNI = (TbRichTextView) view.findViewById(e.g.richText);
            this.fNK = (SubPbLayout) view.findViewById(e.g.pb_post_footer_layout);
            this.fNJ = (ConstrainImageGroup) view.findViewById(e.g.floor_images_content);
            this.mBottomLine = view.findViewById(e.g.pb_bottom_line);
            this.fNL = (TextView) view.findViewById(e.g.floor_num);
            this.fNB = view.findViewById(e.g.line_between_floor_and_time);
            this.fNC = view.findViewById(e.g.line_between_time_and_locate);
            this.fNJ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds16));
            this.fNJ.setSingleImageRatio(0.75d);
            this.fNJ.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fNI.setLayoutStrategy(new b(this.fNI.getLayoutStrategy()));
            this.fNI.setTextSize(TbConfig.getContentSize());
            this.fNH.setIsRound(true);
            this.fNI.setDisplayImage(this.fMU, false);
            this.fNI.setVoiceViewRes(e.h.voice_play_btn_new);
            this.fNQ = (TextView) view.findViewById(e.g.pb_item_tail_content);
            this.fNR = (LinearLayout) view.findViewById(e.g.pb_post_recommend_live_layout);
            this.fNS = (TextView) view.findViewById(e.g.pb_post_recommend_live_prefix_tv);
            this.fNT = view.findViewById(e.g.pb_post_recommend_live_divider);
            this.fNU = (TextView) view.findViewById(e.g.pb_post_recommend_live_title);
            this.fNV = (ImageView) view.findViewById(e.g.pb_post_recommend_live_arrow);
            this.fNW = (LinearLayout) view.findViewById(e.g.all_content);
            this.fNX = (LinearLayout) view.findViewById(e.g.fold_op_area);
            this.fNY = (TextView) view.findViewById(e.g.fold_title);
            this.fNZ = (ImageView) view.findViewById(e.g.fold_btn);
            this.fOa.Du();
            this.fOa.h(tbPageContext.getUniqueId());
        }
    }

    public void bh(boolean z) {
        if (this.fOa != null) {
            this.fOa.bh(z);
            this.fOa.Du();
        }
    }
}
