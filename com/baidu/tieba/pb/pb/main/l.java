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
    public TextView aYZ;
    public View axo;
    public TextView clT;
    public boolean eHP;
    public TextView eIJ;
    public View eIe;
    public LinearLayout eMX;
    public TextView eMY;
    public TextView eMZ;
    public View eNa;
    public TextView eNb;
    public PbFloorAgreeView eNc;
    public ImageView eNd;
    public HeadImageView eNe;
    public TbRichTextView eNf;
    public ConstrainImageGroup eNg;
    public SubPbLayout eNh;
    public TextView eNi;
    public ImageView eNj;
    public HeadPendantView eNk;
    public UserIconBox eNl;
    public UserIconBox eNm;
    public View mBottomLine;
    public int mSkinType;

    public l(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eHP = true;
        if (tbPageContext != null && view != null) {
            this.eIe = view;
            this.axo = view.findViewById(d.g.top_divider_line);
            this.aYZ = (TextView) view.findViewById(d.g.view_user_name);
            this.eMX = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.eMY = (TextView) view.findViewById(d.g.view_author_tip);
            this.eMZ = (TextView) view.findViewById(d.g.view_post_time);
            this.clT = (TextView) view.findViewById(d.g.view_forum_name);
            this.eNj = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.eNb = (TextView) view.findViewById(d.g.view_location);
            this.eNd = (ImageView) view.findViewById(d.g.image_more_tip);
            this.eNc = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.eNe = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.eNk = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.eNk.wg();
            if (this.eNk.getHeadView() != null) {
                this.eNk.getHeadView().setIsRound(true);
                this.eNk.getHeadView().setDrawBorder(false);
            }
            if (this.eNk.getPendantView() != null) {
                this.eNk.getPendantView().setIsRound(true);
                this.eNk.getPendantView().setDrawBorder(false);
            }
            this.eNl = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.eNm = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.eNf = (TbRichTextView) view.findViewById(d.g.richText);
            this.eNh = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.eNg = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.eNi = (TextView) view.findViewById(d.g.floor_num);
            this.eNa = view.findViewById(d.g.line_between_floor_and_time);
            this.eNg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.eNg.setSingleImageRatio(0.75d);
            this.eNg.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eNf.setLayoutStrategy(new b(this.eNf.getLayoutStrategy()));
            this.eNf.setTextSize(TbConfig.getContentSize());
            this.eNe.setIsRound(true);
            this.eNf.m(this.eHP, false);
            this.eNf.setVoiceViewRes(d.h.voice_play_btn_new);
            this.eIJ = (TextView) view.findViewById(d.g.pb_item_tail_content);
        }
    }
}
