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
    public View ayf;
    public TextView bcz;
    public boolean eQU;
    public TextView eRO;
    public View eRj;
    public LinearLayout eWA;
    public TextView eWB;
    public View eWC;
    public TextView eWD;
    public ImageView eWE;
    public LinearLayout eWj;
    public ImageView eWk;
    public TextView eWl;
    public View eWm;
    public View eWn;
    public TextView eWo;
    public PbFloorAgreeView eWp;
    public ImageView eWq;
    public HeadImageView eWr;
    public TbRichTextView eWs;
    public ConstrainImageGroup eWt;
    public SubPbLayout eWu;
    public TextView eWv;
    public ImageView eWw;
    public HeadPendantView eWx;
    public UserIconBox eWy;
    public UserIconBox eWz;
    public View mBottomLine;
    public int mSkinType;

    public l(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eQU = true;
        if (tbPageContext != null && view != null) {
            this.eRj = view;
            this.ayf = view.findViewById(d.g.top_divider_line);
            this.bcz = (TextView) view.findViewById(d.g.view_user_name);
            this.eWj = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.eWk = (ImageView) view.findViewById(d.g.view_author_tip);
            this.eWl = (TextView) view.findViewById(d.g.view_post_time);
            this.eWw = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.eWo = (TextView) view.findViewById(d.g.view_location);
            this.eWq = (ImageView) view.findViewById(d.g.image_more_tip);
            this.eWp = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.eWr = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.eWx = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.eWx.wi();
            if (this.eWx.getHeadView() != null) {
                this.eWx.getHeadView().setIsRound(true);
                this.eWx.getHeadView().setDrawBorder(false);
            }
            this.eWy = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.eWz = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.eWs = (TbRichTextView) view.findViewById(d.g.richText);
            this.eWu = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.eWt = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.eWv = (TextView) view.findViewById(d.g.floor_num);
            this.eWm = view.findViewById(d.g.line_between_floor_and_time);
            this.eWn = view.findViewById(d.g.line_between_time_and_locate);
            this.eWt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.eWt.setSingleImageRatio(0.75d);
            this.eWt.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eWs.setLayoutStrategy(new b(this.eWs.getLayoutStrategy()));
            this.eWs.setTextSize(TbConfig.getContentSize());
            this.eWr.setIsRound(true);
            this.eWs.m(this.eQU, false);
            this.eWs.setVoiceViewRes(d.h.voice_play_btn_new);
            this.eRO = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.eWA = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.eWB = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.eWC = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.eWD = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.eWE = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
        }
    }
}
