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
    public View boF;
    public TextView cSO;
    public boolean fIS;
    public TextView fJM;
    public View fJh;
    public LinearLayout fNY;
    public ImageView fNZ;
    public TextView fOa;
    public View fOb;
    public View fOc;
    public TextView fOd;
    public PbFloorAgreeView fOe;
    public ImageView fOf;
    public HeadImageView fOg;
    public TbRichTextView fOh;
    public ConstrainImageGroup fOi;
    public SubPbLayout fOj;
    public TextView fOk;
    public ImageView fOl;
    public HeadPendantView fOm;
    public UserIconBox fOn;
    public UserIconBox fOo;
    public LinearLayout fOp;
    public TextView fOq;
    public View fOr;
    public TextView fOs;
    public ImageView fOt;
    public LinearLayout fOu;
    public TextView fOv;
    public LinearLayout fOw;
    public TextView fOx;
    public ImageView fOy;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fIS = true;
        if (tbPageContext != null && view != null) {
            this.fJh = view;
            this.boF = view.findViewById(d.g.top_divider_line);
            this.cSO = (TextView) view.findViewById(d.g.view_user_name);
            this.fNY = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.fNZ = (ImageView) view.findViewById(d.g.view_author_tip);
            this.fOa = (TextView) view.findViewById(d.g.view_post_time);
            this.fOl = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.fOd = (TextView) view.findViewById(d.g.view_location);
            this.fOf = (ImageView) view.findViewById(d.g.image_more_tip);
            this.fOe = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.fOg = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.fOm = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.fOm.DT();
            if (this.fOm.getHeadView() != null) {
                this.fOm.getHeadView().setIsRound(true);
                this.fOm.getHeadView().setDrawBorder(false);
            }
            this.fOn = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.fOo = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.fOh = (TbRichTextView) view.findViewById(d.g.richText);
            this.fOj = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.fOi = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.fOk = (TextView) view.findViewById(d.g.floor_num);
            this.fOb = view.findViewById(d.g.line_between_floor_and_time);
            this.fOc = view.findViewById(d.g.line_between_time_and_locate);
            this.fOi.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fOi.setSingleImageRatio(0.75d);
            this.fOi.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.fOh.setLayoutStrategy(new b(this.fOh.getLayoutStrategy()));
            this.fOh.setTextSize(TbConfig.getContentSize());
            this.fOg.setIsRound(true);
            this.fOh.o(this.fIS, false);
            this.fOh.setVoiceViewRes(d.h.voice_play_btn_new);
            this.fJM = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.fOp = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.fOq = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fOr = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.fOs = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.fOt = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fOu = (LinearLayout) view.findViewById(d.g.all_content);
            this.fOv = (TextView) view.findViewById(d.g.fold_tip_text);
            this.fOw = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.fOx = (TextView) view.findViewById(d.g.fold_title);
            this.fOy = (ImageView) view.findViewById(d.g.fold_btn);
        }
    }
}
