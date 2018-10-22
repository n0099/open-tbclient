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
    public boolean fMV;
    public TextView fNA;
    public TextView fNB;
    public View fNC;
    public View fND;
    public TextView fNE;
    public ImageView fNF;
    public PostPraiseView fNG;
    public PostDisPraiseView fNH;
    public HeadImageView fNI;
    public TbRichTextView fNJ;
    public ConstrainImageGroup fNK;
    public SubPbLayout fNL;
    public TextView fNM;
    public ImageView fNN;
    public HeadPendantView fNO;
    public UserIconBox fNP;
    public UserIconBox fNQ;
    public TextView fNR;
    public LinearLayout fNS;
    public TextView fNT;
    public View fNU;
    public TextView fNV;
    public ImageView fNW;
    public LinearLayout fNX;
    public LinearLayout fNY;
    public TextView fNZ;
    public View fNy;
    public LinearLayout fNz;
    public ImageView fOa;
    public com.baidu.tbadk.core.view.a fOb;
    public View mBottomLine;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fMV = true;
        if (tbPageContext != null && view != null) {
            this.fNy = view;
            this.mTopLine = view.findViewById(e.g.top_divider_line);
            this.cGZ = (TextView) view.findViewById(e.g.view_user_name);
            this.fNz = (LinearLayout) view.findViewById(e.g.content_user_and_praise);
            this.fNA = (TextView) view.findViewById(e.g.view_author_tip);
            this.fNB = (TextView) view.findViewById(e.g.view_post_time);
            this.fNN = (ImageView) view.findViewById(e.g.icon_forum_level);
            this.fNE = (TextView) view.findViewById(e.g.view_location);
            this.fNF = (ImageView) view.findViewById(e.g.image_more_tip);
            this.fNG = (PostPraiseView) view.findViewById(e.g.view_floor_new_praise);
            this.fNH = (PostDisPraiseView) view.findViewById(e.g.view_floor_new_dispraise);
            this.fOb = new com.baidu.tbadk.core.view.a(this.fNG, this.fNH, this.fNF);
            this.fNI = (HeadImageView) view.findViewById(e.g.normal_user_photo);
            this.fNO = (HeadPendantView) view.findViewById(e.g.pendant_user_photo);
            this.fNO.setHasPendantStyle();
            if (this.fNO.getHeadView() != null) {
                this.fNO.getHeadView().setIsRound(true);
                this.fNO.getHeadView().setDrawBorder(false);
            }
            this.fNP = (UserIconBox) view.findViewById(e.g.show_icon_vip);
            this.fNQ = (UserIconBox) view.findViewById(e.g.show_icon_yinji);
            this.fNJ = (TbRichTextView) view.findViewById(e.g.richText);
            this.fNL = (SubPbLayout) view.findViewById(e.g.pb_post_footer_layout);
            this.fNK = (ConstrainImageGroup) view.findViewById(e.g.floor_images_content);
            this.mBottomLine = view.findViewById(e.g.pb_bottom_line);
            this.fNM = (TextView) view.findViewById(e.g.floor_num);
            this.fNC = view.findViewById(e.g.line_between_floor_and_time);
            this.fND = view.findViewById(e.g.line_between_time_and_locate);
            this.fNK.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds16));
            this.fNK.setSingleImageRatio(0.75d);
            this.fNK.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fNJ.setLayoutStrategy(new b(this.fNJ.getLayoutStrategy()));
            this.fNJ.setTextSize(TbConfig.getContentSize());
            this.fNI.setIsRound(true);
            this.fNJ.setDisplayImage(this.fMV, false);
            this.fNJ.setVoiceViewRes(e.h.voice_play_btn_new);
            this.fNR = (TextView) view.findViewById(e.g.pb_item_tail_content);
            this.fNS = (LinearLayout) view.findViewById(e.g.pb_post_recommend_live_layout);
            this.fNT = (TextView) view.findViewById(e.g.pb_post_recommend_live_prefix_tv);
            this.fNU = view.findViewById(e.g.pb_post_recommend_live_divider);
            this.fNV = (TextView) view.findViewById(e.g.pb_post_recommend_live_title);
            this.fNW = (ImageView) view.findViewById(e.g.pb_post_recommend_live_arrow);
            this.fNX = (LinearLayout) view.findViewById(e.g.all_content);
            this.fNY = (LinearLayout) view.findViewById(e.g.fold_op_area);
            this.fNZ = (TextView) view.findViewById(e.g.fold_title);
            this.fOa = (ImageView) view.findViewById(e.g.fold_btn);
            this.fOb.Du();
            this.fOb.h(tbPageContext.getUniqueId());
        }
    }

    public void bh(boolean z) {
        if (this.fOb != null) {
            this.fOb.bh(z);
            this.fOb.Du();
        }
    }
}
