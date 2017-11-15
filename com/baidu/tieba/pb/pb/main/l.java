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
    public TextView aZi;
    public View axw;
    public TextView cmn;
    public boolean eIj;
    public View eIy;
    public TextView eJd;
    public ConstrainImageGroup eNA;
    public SubPbLayout eNB;
    public TextView eNC;
    public ImageView eND;
    public HeadPendantView eNE;
    public UserIconBox eNF;
    public UserIconBox eNG;
    public LinearLayout eNr;
    public TextView eNs;
    public TextView eNt;
    public View eNu;
    public TextView eNv;
    public PbFloorAgreeView eNw;
    public ImageView eNx;
    public HeadImageView eNy;
    public TbRichTextView eNz;
    public View mBottomLine;
    public int mSkinType;

    public l(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eIj = true;
        if (tbPageContext != null && view != null) {
            this.eIy = view;
            this.axw = view.findViewById(d.g.top_divider_line);
            this.aZi = (TextView) view.findViewById(d.g.view_user_name);
            this.eNr = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.eNs = (TextView) view.findViewById(d.g.view_author_tip);
            this.eNt = (TextView) view.findViewById(d.g.view_post_time);
            this.cmn = (TextView) view.findViewById(d.g.view_forum_name);
            this.eND = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.eNv = (TextView) view.findViewById(d.g.view_location);
            this.eNx = (ImageView) view.findViewById(d.g.image_more_tip);
            this.eNw = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.eNy = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.eNE = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.eNE.wg();
            if (this.eNE.getHeadView() != null) {
                this.eNE.getHeadView().setIsRound(true);
                this.eNE.getHeadView().setDrawBorder(false);
            }
            if (this.eNE.getPendantView() != null) {
                this.eNE.getPendantView().setIsRound(true);
                this.eNE.getPendantView().setDrawBorder(false);
            }
            this.eNF = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.eNG = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.eNz = (TbRichTextView) view.findViewById(d.g.richText);
            this.eNB = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.eNA = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.eNC = (TextView) view.findViewById(d.g.floor_num);
            this.eNu = view.findViewById(d.g.line_between_floor_and_time);
            this.eNA.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.eNA.setSingleImageRatio(0.75d);
            this.eNA.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eNz.setLayoutStrategy(new b(this.eNz.getLayoutStrategy()));
            this.eNz.setTextSize(TbConfig.getContentSize());
            this.eNy.setIsRound(true);
            this.eNz.m(this.eIj, false);
            this.eNz.setVoiceViewRes(d.h.voice_play_btn_new);
            this.eJd = (TextView) view.findViewById(d.g.pb_item_tail_content);
        }
    }
}
