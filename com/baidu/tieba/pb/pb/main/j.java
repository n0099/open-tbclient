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
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes2.dex */
public class j extends q.a {
    public View aIx;
    public TextView cqi;
    public boolean fxx;
    public TextView fyA;
    public View fyB;
    public TextView fyC;
    public ImageView fyD;
    public LinearLayout fyE;
    public LinearLayout fyF;
    public TextView fyG;
    public ImageView fyH;
    public View fyg;
    public LinearLayout fyh;
    public TextView fyi;
    public TextView fyj;
    public View fyk;
    public View fyl;
    public TextView fym;
    public PbFloorAgreeView fyn;
    public ImageView fyo;
    public HeadImageView fyp;
    public TbRichTextView fyq;
    public ConstrainImageGroup fyr;
    public SubPbLayout fys;
    public TextView fyt;
    public ImageView fyu;
    public HeadPendantView fyv;
    public UserIconBox fyw;
    public UserIconBox fyx;
    public TextView fyy;
    public LinearLayout fyz;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fxx = true;
        if (tbPageContext != null && view != null) {
            this.fyg = view;
            this.aIx = view.findViewById(d.g.top_divider_line);
            this.cqi = (TextView) view.findViewById(d.g.view_user_name);
            this.fyh = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.fyi = (TextView) view.findViewById(d.g.view_author_tip);
            this.fyj = (TextView) view.findViewById(d.g.view_post_time);
            this.fyu = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.fym = (TextView) view.findViewById(d.g.view_location);
            this.fyo = (ImageView) view.findViewById(d.g.image_more_tip);
            this.fyn = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.fyp = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.fyv = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.fyv.setHasPendantStyle();
            if (this.fyv.getHeadView() != null) {
                this.fyv.getHeadView().setIsRound(true);
                this.fyv.getHeadView().setDrawBorder(false);
            }
            this.fyw = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.fyx = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.fyq = (TbRichTextView) view.findViewById(d.g.richText);
            this.fys = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.fyr = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.fyt = (TextView) view.findViewById(d.g.floor_num);
            this.fyk = view.findViewById(d.g.line_between_floor_and_time);
            this.fyl = view.findViewById(d.g.line_between_time_and_locate);
            this.fyr.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fyr.setSingleImageRatio(0.75d);
            this.fyr.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fyq.setLayoutStrategy(new b(this.fyq.getLayoutStrategy()));
            this.fyq.setTextSize(TbConfig.getContentSize());
            this.fyp.setIsRound(true);
            this.fyq.setDisplayImage(this.fxx, false);
            this.fyq.setVoiceViewRes(d.i.voice_play_btn_new);
            this.fyy = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.fyz = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.fyA = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fyB = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.fyC = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.fyD = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fyE = (LinearLayout) view.findViewById(d.g.all_content);
            this.fyF = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.fyG = (TextView) view.findViewById(d.g.fold_title);
            this.fyH = (ImageView) view.findViewById(d.g.fold_btn);
        }
    }
}
