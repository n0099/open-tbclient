package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes2.dex */
public class j extends r.a {
    public View boC;
    public TextView cSL;
    public boolean fIC;
    public View fIR;
    public TextView fJw;
    public LinearLayout fNI;
    public ImageView fNJ;
    public TextView fNK;
    public View fNL;
    public View fNM;
    public TextView fNN;
    public PbFloorAgreeView fNO;
    public ImageView fNP;
    public HeadImageView fNQ;
    public TbRichTextView fNR;
    public ConstrainImageGroup fNS;
    public SubPbLayout fNT;
    public TextView fNU;
    public ImageView fNV;
    public HeadPendantView fNW;
    public UserIconBox fNX;
    public UserIconBox fNY;
    public LinearLayout fNZ;
    public TextView fOa;
    public View fOb;
    public TextView fOc;
    public ImageView fOd;
    public LinearLayout fOe;
    public TextView fOf;
    public LinearLayout fOg;
    public TextView fOh;
    public ImageView fOi;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fIC = true;
        if (tbPageContext != null && view != null) {
            this.fIR = view;
            this.boC = view.findViewById(d.g.top_divider_line);
            this.cSL = (TextView) view.findViewById(d.g.view_user_name);
            this.fNI = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.fNJ = (ImageView) view.findViewById(d.g.view_author_tip);
            this.fNK = (TextView) view.findViewById(d.g.view_post_time);
            this.fNV = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.fNN = (TextView) view.findViewById(d.g.view_location);
            this.fNP = (ImageView) view.findViewById(d.g.image_more_tip);
            this.fNO = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.fNQ = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.fNW = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.fNW.DS();
            if (this.fNW.getHeadView() != null) {
                this.fNW.getHeadView().setIsRound(true);
                this.fNW.getHeadView().setDrawBorder(false);
            }
            this.fNX = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.fNY = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.fNR = (TbRichTextView) view.findViewById(d.g.richText);
            this.fNT = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.fNS = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.fNU = (TextView) view.findViewById(d.g.floor_num);
            this.fNL = view.findViewById(d.g.line_between_floor_and_time);
            this.fNM = view.findViewById(d.g.line_between_time_and_locate);
            this.fNS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fNS.setSingleImageRatio(0.75d);
            this.fNS.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.fNR.setLayoutStrategy(new b(this.fNR.getLayoutStrategy()));
            this.fNR.setTextSize(TbConfig.getContentSize());
            this.fNQ.setIsRound(true);
            this.fNR.o(this.fIC, false);
            this.fNR.setVoiceViewRes(d.h.voice_play_btn_new);
            this.fJw = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.fNZ = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.fOa = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fOb = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.fOc = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.fOd = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fOe = (LinearLayout) view.findViewById(d.g.all_content);
            this.fOf = (TextView) view.findViewById(d.g.fold_tip_text);
            this.fOg = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.fOh = (TextView) view.findViewById(d.g.fold_title);
            this.fOi = (ImageView) view.findViewById(d.g.fold_btn);
        }
    }
}
