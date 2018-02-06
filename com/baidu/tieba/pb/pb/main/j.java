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
    public View boP;
    public TextView cSX;
    public boolean fIN;
    public TextView fJH;
    public View fJc;
    public LinearLayout fNT;
    public ImageView fNU;
    public TextView fNV;
    public View fNW;
    public View fNX;
    public TextView fNY;
    public PbFloorAgreeView fNZ;
    public ImageView fOa;
    public HeadImageView fOb;
    public TbRichTextView fOc;
    public ConstrainImageGroup fOd;
    public SubPbLayout fOe;
    public TextView fOf;
    public ImageView fOg;
    public HeadPendantView fOh;
    public UserIconBox fOi;
    public UserIconBox fOj;
    public LinearLayout fOk;
    public TextView fOl;
    public View fOm;
    public TextView fOn;
    public ImageView fOo;
    public LinearLayout fOp;
    public TextView fOq;
    public LinearLayout fOr;
    public TextView fOs;
    public ImageView fOt;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fIN = true;
        if (tbPageContext != null && view != null) {
            this.fJc = view;
            this.boP = view.findViewById(d.g.top_divider_line);
            this.cSX = (TextView) view.findViewById(d.g.view_user_name);
            this.fNT = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.fNU = (ImageView) view.findViewById(d.g.view_author_tip);
            this.fNV = (TextView) view.findViewById(d.g.view_post_time);
            this.fOg = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.fNY = (TextView) view.findViewById(d.g.view_location);
            this.fOa = (ImageView) view.findViewById(d.g.image_more_tip);
            this.fNZ = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.fOb = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.fOh = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.fOh.DT();
            if (this.fOh.getHeadView() != null) {
                this.fOh.getHeadView().setIsRound(true);
                this.fOh.getHeadView().setDrawBorder(false);
            }
            this.fOi = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.fOj = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.fOc = (TbRichTextView) view.findViewById(d.g.richText);
            this.fOe = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.fOd = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.fOf = (TextView) view.findViewById(d.g.floor_num);
            this.fNW = view.findViewById(d.g.line_between_floor_and_time);
            this.fNX = view.findViewById(d.g.line_between_time_and_locate);
            this.fOd.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fOd.setSingleImageRatio(0.75d);
            this.fOd.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.fOc.setLayoutStrategy(new b(this.fOc.getLayoutStrategy()));
            this.fOc.setTextSize(TbConfig.getContentSize());
            this.fOb.setIsRound(true);
            this.fOc.o(this.fIN, false);
            this.fOc.setVoiceViewRes(d.h.voice_play_btn_new);
            this.fJH = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.fOk = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.fOl = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fOm = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.fOn = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.fOo = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fOp = (LinearLayout) view.findViewById(d.g.all_content);
            this.fOq = (TextView) view.findViewById(d.g.fold_tip_text);
            this.fOr = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.fOs = (TextView) view.findViewById(d.g.fold_title);
            this.fOt = (ImageView) view.findViewById(d.g.fold_btn);
        }
    }
}
