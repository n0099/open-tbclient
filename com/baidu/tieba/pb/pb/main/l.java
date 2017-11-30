package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
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
/* loaded from: classes.dex */
public class l extends j.a {
    public View axX;
    public TextView bcu;
    public boolean ePM;
    public TextView eQG;
    public View eQb;
    public LinearLayout eVb;
    public ImageView eVc;
    public TextView eVd;
    public View eVe;
    public View eVf;
    public TextView eVg;
    public PbFloorAgreeView eVh;
    public ImageView eVi;
    public HeadImageView eVj;
    public TbRichTextView eVk;
    public ConstrainImageGroup eVl;
    public SubPbLayout eVm;
    public TextView eVn;
    public ImageView eVo;
    public HeadPendantView eVp;
    public UserIconBox eVq;
    public UserIconBox eVr;
    public LinearLayout eVs;
    public TextView eVt;
    public View eVu;
    public TextView eVv;
    public ImageView eVw;
    public View mBottomLine;
    public int mSkinType;

    public l(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.ePM = true;
        if (tbPageContext != null && view != null) {
            this.eQb = view;
            this.axX = view.findViewById(d.g.top_divider_line);
            this.bcu = (TextView) view.findViewById(d.g.view_user_name);
            this.eVb = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.eVc = (ImageView) view.findViewById(d.g.view_author_tip);
            this.eVd = (TextView) view.findViewById(d.g.view_post_time);
            this.eVo = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.eVg = (TextView) view.findViewById(d.g.view_location);
            this.eVi = (ImageView) view.findViewById(d.g.image_more_tip);
            this.eVh = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.eVj = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.eVp = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.eVp.wk();
            if (this.eVp.getHeadView() != null) {
                this.eVp.getHeadView().setIsRound(true);
                this.eVp.getHeadView().setDrawBorder(false);
            }
            this.eVq = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.eVr = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.eVk = (TbRichTextView) view.findViewById(d.g.richText);
            this.eVm = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.eVl = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.eVn = (TextView) view.findViewById(d.g.floor_num);
            this.eVe = view.findViewById(d.g.line_between_floor_and_time);
            this.eVf = view.findViewById(d.g.line_between_time_and_locate);
            this.eVl.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.eVl.setSingleImageRatio(0.75d);
            this.eVl.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eVk.setLayoutStrategy(new b(this.eVk.getLayoutStrategy()));
            this.eVk.setTextSize(TbConfig.getContentSize());
            this.eVj.setIsRound(true);
            this.eVk.m(this.ePM, false);
            this.eVk.setVoiceViewRes(d.h.voice_play_btn_new);
            this.eQG = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.eVs = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.eVt = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.eVu = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.eVv = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.eVw = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
        }
    }
}
