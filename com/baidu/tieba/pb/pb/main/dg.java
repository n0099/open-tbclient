package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class dg extends y.a {
    public TextView aWr;
    public View avN;
    public View avO;
    public TextView bIm;
    public View eeP;
    public boolean eez;
    public TextView efv;
    public LinearLayout eiJ;
    public TextView eiK;
    public TextView eiL;
    public TextView eiM;
    public PbFloorAgreeView eiN;
    public ImageView eiO;
    public HeadImageView eiP;
    public TbRichTextView eiQ;
    public ConstrainImageGroup eiR;
    public SubPbLayout eiS;
    public TextView eiT;
    public ImageView eiU;
    public HeadPendantView eiV;
    public UserIconBox eiW;
    public UserIconBox eiX;
    public int mSkinType;

    public dg(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eez = true;
        if (tbPageContext != null && view != null) {
            this.eeP = view;
            this.avN = view.findViewById(w.h.top_divider_line);
            this.aWr = (TextView) view.findViewById(w.h.view_user_name);
            this.eiJ = (LinearLayout) view.findViewById(w.h.content_user_and_praise);
            this.eiK = (TextView) view.findViewById(w.h.view_author_tip);
            this.eiL = (TextView) view.findViewById(w.h.view_post_time);
            this.bIm = (TextView) view.findViewById(w.h.view_forum_name);
            this.eiU = (ImageView) view.findViewById(w.h.icon_forum_level);
            this.eiM = (TextView) view.findViewById(w.h.view_location);
            this.eiO = (ImageView) view.findViewById(w.h.image_more_tip);
            this.eiN = (PbFloorAgreeView) view.findViewById(w.h.view_floor_praise);
            this.eiP = (HeadImageView) view.findViewById(w.h.normal_user_photo);
            this.eiV = (HeadPendantView) view.findViewById(w.h.pendant_user_photo);
            this.eiV.vY();
            if (this.eiV.getHeadView() != null) {
                this.eiV.getHeadView().setIsRound(true);
                this.eiV.getHeadView().setDrawBorder(false);
            }
            if (this.eiV.getPendantView() != null) {
                this.eiV.getPendantView().setIsRound(true);
                this.eiV.getPendantView().setDrawBorder(false);
            }
            this.eiW = (UserIconBox) view.findViewById(w.h.show_icon_vip);
            this.eiX = (UserIconBox) view.findViewById(w.h.show_icon_yinji);
            this.eiQ = (TbRichTextView) view.findViewById(w.h.richText);
            this.eiS = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
            this.eiR = (ConstrainImageGroup) view.findViewById(w.h.floor_images_content);
            this.avO = view.findViewById(w.h.pb_bottom_line);
            this.eiT = (TextView) view.findViewById(w.h.floor_num);
            this.eiR.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds16));
            this.eiR.setSingleImageRatio(0.75d);
            this.eiR.setImageProcessor(new com.baidu.tbadk.widget.layout.i(3));
            this.eiQ.Iq();
            this.eiQ.setImageViewStretch(true);
            this.eiQ.setTextSize(TbConfig.getContentSize());
            this.eiP.setIsRound(true);
            this.eiQ.j(this.eez, false);
            this.eiQ.setVoiceViewRes(w.j.voice_play_btn_new);
            this.efv = (TextView) view.findViewById(w.h.pb_item_tail_content);
        }
    }
}
