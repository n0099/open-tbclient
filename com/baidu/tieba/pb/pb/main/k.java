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
public class k extends j.a {
    public TextView aXm;
    public View axW;
    public View axX;
    public TextView cdT;
    public boolean eFJ;
    public View eFY;
    public TextView eGE;
    public LinearLayout eKh;
    public TextView eKi;
    public TextView eKj;
    public View eKk;
    public TextView eKl;
    public PbFloorAgreeView eKm;
    public ImageView eKn;
    public HeadImageView eKo;
    public TbRichTextView eKp;
    public ConstrainImageGroup eKq;
    public SubPbLayout eKr;
    public TextView eKs;
    public ImageView eKt;
    public HeadPendantView eKu;
    public UserIconBox eKv;
    public UserIconBox eKw;
    public int mSkinType;

    public k(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eFJ = true;
        if (tbPageContext != null && view != null) {
            this.eFY = view;
            this.axW = view.findViewById(d.h.top_divider_line);
            this.aXm = (TextView) view.findViewById(d.h.view_user_name);
            this.eKh = (LinearLayout) view.findViewById(d.h.content_user_and_praise);
            this.eKi = (TextView) view.findViewById(d.h.view_author_tip);
            this.eKj = (TextView) view.findViewById(d.h.view_post_time);
            this.cdT = (TextView) view.findViewById(d.h.view_forum_name);
            this.eKt = (ImageView) view.findViewById(d.h.icon_forum_level);
            this.eKl = (TextView) view.findViewById(d.h.view_location);
            this.eKn = (ImageView) view.findViewById(d.h.image_more_tip);
            this.eKm = (PbFloorAgreeView) view.findViewById(d.h.view_floor_praise);
            this.eKo = (HeadImageView) view.findViewById(d.h.normal_user_photo);
            this.eKu = (HeadPendantView) view.findViewById(d.h.pendant_user_photo);
            this.eKu.wB();
            if (this.eKu.getHeadView() != null) {
                this.eKu.getHeadView().setIsRound(true);
                this.eKu.getHeadView().setDrawBorder(false);
            }
            if (this.eKu.getPendantView() != null) {
                this.eKu.getPendantView().setIsRound(true);
                this.eKu.getPendantView().setDrawBorder(false);
            }
            this.eKv = (UserIconBox) view.findViewById(d.h.show_icon_vip);
            this.eKw = (UserIconBox) view.findViewById(d.h.show_icon_yinji);
            this.eKp = (TbRichTextView) view.findViewById(d.h.richText);
            this.eKr = (SubPbLayout) view.findViewById(d.h.pb_post_footer_layout);
            this.eKq = (ConstrainImageGroup) view.findViewById(d.h.floor_images_content);
            this.axX = view.findViewById(d.h.pb_bottom_line);
            this.eKs = (TextView) view.findViewById(d.h.floor_num);
            this.eKk = view.findViewById(d.h.line_between_floor_and_time);
            this.eKq.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
            this.eKq.setSingleImageRatio(0.75d);
            this.eKq.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eKp.Jk();
            this.eKp.setImageViewStretch(true);
            this.eKp.setTextSize(TbConfig.getContentSize());
            this.eKo.setIsRound(true);
            this.eKp.l(this.eFJ, false);
            this.eKp.setVoiceViewRes(d.j.voice_play_btn_new);
            this.eGE = (TextView) view.findViewById(d.h.pb_item_tail_content);
        }
    }
}
