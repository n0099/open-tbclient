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
    public TextView aXA;
    public View ayL;
    public View ayM;
    public TextView cbc;
    public View eHF;
    public boolean eHq;
    public TextView eIl;
    public LinearLayout eLR;
    public TextView eLS;
    public TextView eLT;
    public TextView eLU;
    public PbFloorAgreeView eLV;
    public ImageView eLW;
    public HeadImageView eLX;
    public TbRichTextView eLY;
    public ConstrainImageGroup eLZ;
    public SubPbLayout eMa;
    public TextView eMb;
    public ImageView eMc;
    public HeadPendantView eMd;
    public UserIconBox eMe;
    public UserIconBox eMf;
    public int mSkinType;

    public k(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eHq = true;
        if (tbPageContext != null && view != null) {
            this.eHF = view;
            this.ayL = view.findViewById(d.h.top_divider_line);
            this.aXA = (TextView) view.findViewById(d.h.view_user_name);
            this.eLR = (LinearLayout) view.findViewById(d.h.content_user_and_praise);
            this.eLS = (TextView) view.findViewById(d.h.view_author_tip);
            this.eLT = (TextView) view.findViewById(d.h.view_post_time);
            this.cbc = (TextView) view.findViewById(d.h.view_forum_name);
            this.eMc = (ImageView) view.findViewById(d.h.icon_forum_level);
            this.eLU = (TextView) view.findViewById(d.h.view_location);
            this.eLW = (ImageView) view.findViewById(d.h.image_more_tip);
            this.eLV = (PbFloorAgreeView) view.findViewById(d.h.view_floor_praise);
            this.eLX = (HeadImageView) view.findViewById(d.h.normal_user_photo);
            this.eMd = (HeadPendantView) view.findViewById(d.h.pendant_user_photo);
            this.eMd.wE();
            if (this.eMd.getHeadView() != null) {
                this.eMd.getHeadView().setIsRound(true);
                this.eMd.getHeadView().setDrawBorder(false);
            }
            if (this.eMd.getPendantView() != null) {
                this.eMd.getPendantView().setIsRound(true);
                this.eMd.getPendantView().setDrawBorder(false);
            }
            this.eMe = (UserIconBox) view.findViewById(d.h.show_icon_vip);
            this.eMf = (UserIconBox) view.findViewById(d.h.show_icon_yinji);
            this.eLY = (TbRichTextView) view.findViewById(d.h.richText);
            this.eMa = (SubPbLayout) view.findViewById(d.h.pb_post_footer_layout);
            this.eLZ = (ConstrainImageGroup) view.findViewById(d.h.floor_images_content);
            this.ayM = view.findViewById(d.h.pb_bottom_line);
            this.eMb = (TextView) view.findViewById(d.h.floor_num);
            this.eLZ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
            this.eLZ.setSingleImageRatio(0.75d);
            this.eLZ.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eLY.Jc();
            this.eLY.setImageViewStretch(true);
            this.eLY.setTextSize(TbConfig.getContentSize());
            this.eLX.setIsRound(true);
            this.eLY.k(this.eHq, false);
            this.eLY.setVoiceViewRes(d.j.voice_play_btn_new);
            this.eIl = (TextView) view.findViewById(d.h.pb_item_tail_content);
        }
    }
}
