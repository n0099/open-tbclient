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
    public View ayc;
    public TextView bcv;
    public boolean eQP;
    public TextView eRJ;
    public View eRe;
    public LinearLayout eWe;
    public ImageView eWf;
    public TextView eWg;
    public View eWh;
    public View eWi;
    public TextView eWj;
    public PbFloorAgreeView eWk;
    public ImageView eWl;
    public HeadImageView eWm;
    public TbRichTextView eWn;
    public ConstrainImageGroup eWo;
    public SubPbLayout eWp;
    public TextView eWq;
    public ImageView eWr;
    public HeadPendantView eWs;
    public UserIconBox eWt;
    public UserIconBox eWu;
    public LinearLayout eWv;
    public TextView eWw;
    public View eWx;
    public TextView eWy;
    public ImageView eWz;
    public View mBottomLine;
    public int mSkinType;

    public l(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eQP = true;
        if (tbPageContext != null && view != null) {
            this.eRe = view;
            this.ayc = view.findViewById(d.g.top_divider_line);
            this.bcv = (TextView) view.findViewById(d.g.view_user_name);
            this.eWe = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.eWf = (ImageView) view.findViewById(d.g.view_author_tip);
            this.eWg = (TextView) view.findViewById(d.g.view_post_time);
            this.eWr = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.eWj = (TextView) view.findViewById(d.g.view_location);
            this.eWl = (ImageView) view.findViewById(d.g.image_more_tip);
            this.eWk = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.eWm = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.eWs = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.eWs.wi();
            if (this.eWs.getHeadView() != null) {
                this.eWs.getHeadView().setIsRound(true);
                this.eWs.getHeadView().setDrawBorder(false);
            }
            this.eWt = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.eWu = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.eWn = (TbRichTextView) view.findViewById(d.g.richText);
            this.eWp = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.eWo = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.eWq = (TextView) view.findViewById(d.g.floor_num);
            this.eWh = view.findViewById(d.g.line_between_floor_and_time);
            this.eWi = view.findViewById(d.g.line_between_time_and_locate);
            this.eWo.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.eWo.setSingleImageRatio(0.75d);
            this.eWo.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eWn.setLayoutStrategy(new b(this.eWn.getLayoutStrategy()));
            this.eWn.setTextSize(TbConfig.getContentSize());
            this.eWm.setIsRound(true);
            this.eWn.m(this.eQP, false);
            this.eWn.setVoiceViewRes(d.h.voice_play_btn_new);
            this.eRJ = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.eWv = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.eWw = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.eWx = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.eWy = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.eWz = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
        }
    }
}
