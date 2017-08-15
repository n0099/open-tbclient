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
    public TextView aXz;
    public View ayK;
    public View ayL;
    public TextView cbb;
    public View eHD;
    public boolean eHo;
    public TextView eIj;
    public LinearLayout eLP;
    public TextView eLQ;
    public TextView eLR;
    public TextView eLS;
    public PbFloorAgreeView eLT;
    public ImageView eLU;
    public HeadImageView eLV;
    public TbRichTextView eLW;
    public ConstrainImageGroup eLX;
    public SubPbLayout eLY;
    public TextView eLZ;
    public ImageView eMa;
    public HeadPendantView eMb;
    public UserIconBox eMc;
    public UserIconBox eMd;
    public int mSkinType;

    public k(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eHo = true;
        if (tbPageContext != null && view != null) {
            this.eHD = view;
            this.ayK = view.findViewById(d.h.top_divider_line);
            this.aXz = (TextView) view.findViewById(d.h.view_user_name);
            this.eLP = (LinearLayout) view.findViewById(d.h.content_user_and_praise);
            this.eLQ = (TextView) view.findViewById(d.h.view_author_tip);
            this.eLR = (TextView) view.findViewById(d.h.view_post_time);
            this.cbb = (TextView) view.findViewById(d.h.view_forum_name);
            this.eMa = (ImageView) view.findViewById(d.h.icon_forum_level);
            this.eLS = (TextView) view.findViewById(d.h.view_location);
            this.eLU = (ImageView) view.findViewById(d.h.image_more_tip);
            this.eLT = (PbFloorAgreeView) view.findViewById(d.h.view_floor_praise);
            this.eLV = (HeadImageView) view.findViewById(d.h.normal_user_photo);
            this.eMb = (HeadPendantView) view.findViewById(d.h.pendant_user_photo);
            this.eMb.wD();
            if (this.eMb.getHeadView() != null) {
                this.eMb.getHeadView().setIsRound(true);
                this.eMb.getHeadView().setDrawBorder(false);
            }
            if (this.eMb.getPendantView() != null) {
                this.eMb.getPendantView().setIsRound(true);
                this.eMb.getPendantView().setDrawBorder(false);
            }
            this.eMc = (UserIconBox) view.findViewById(d.h.show_icon_vip);
            this.eMd = (UserIconBox) view.findViewById(d.h.show_icon_yinji);
            this.eLW = (TbRichTextView) view.findViewById(d.h.richText);
            this.eLY = (SubPbLayout) view.findViewById(d.h.pb_post_footer_layout);
            this.eLX = (ConstrainImageGroup) view.findViewById(d.h.floor_images_content);
            this.ayL = view.findViewById(d.h.pb_bottom_line);
            this.eLZ = (TextView) view.findViewById(d.h.floor_num);
            this.eLX.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
            this.eLX.setSingleImageRatio(0.75d);
            this.eLX.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eLW.Jc();
            this.eLW.setImageViewStretch(true);
            this.eLW.setTextSize(TbConfig.getContentSize());
            this.eLV.setIsRound(true);
            this.eLW.k(this.eHo, false);
            this.eLW.setVoiceViewRes(d.j.voice_play_btn_new);
            this.eIj = (TextView) view.findViewById(d.h.pb_item_tail_content);
        }
    }
}
