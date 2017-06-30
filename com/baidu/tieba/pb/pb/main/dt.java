package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
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
public class dt extends z.a {
    public TextView aVm;
    public View awA;
    public View awB;
    public TextView bUV;
    public boolean esY;
    public TextView etU;
    public View eto;
    public TextView exA;
    public TextView exB;
    public PbFloorAgreeView exC;
    public ImageView exD;
    public HeadImageView exE;
    public TbRichTextView exF;
    public ConstrainImageGroup exG;
    public SubPbLayout exH;
    public TextView exI;
    public ImageView exJ;
    public HeadPendantView exK;
    public UserIconBox exL;
    public UserIconBox exM;
    public LinearLayout exy;
    public TextView exz;
    public int mSkinType;

    public dt(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.esY = true;
        if (tbPageContext != null && view != null) {
            this.eto = view;
            this.awA = view.findViewById(w.h.top_divider_line);
            this.aVm = (TextView) view.findViewById(w.h.view_user_name);
            this.exy = (LinearLayout) view.findViewById(w.h.content_user_and_praise);
            this.exz = (TextView) view.findViewById(w.h.view_author_tip);
            this.exA = (TextView) view.findViewById(w.h.view_post_time);
            this.bUV = (TextView) view.findViewById(w.h.view_forum_name);
            this.exJ = (ImageView) view.findViewById(w.h.icon_forum_level);
            this.exB = (TextView) view.findViewById(w.h.view_location);
            this.exD = (ImageView) view.findViewById(w.h.image_more_tip);
            this.exC = (PbFloorAgreeView) view.findViewById(w.h.view_floor_praise);
            this.exE = (HeadImageView) view.findViewById(w.h.normal_user_photo);
            this.exK = (HeadPendantView) view.findViewById(w.h.pendant_user_photo);
            this.exK.wm();
            if (this.exK.getHeadView() != null) {
                this.exK.getHeadView().setIsRound(true);
                this.exK.getHeadView().setDrawBorder(false);
            }
            if (this.exK.getPendantView() != null) {
                this.exK.getPendantView().setIsRound(true);
                this.exK.getPendantView().setDrawBorder(false);
            }
            this.exL = (UserIconBox) view.findViewById(w.h.show_icon_vip);
            this.exM = (UserIconBox) view.findViewById(w.h.show_icon_yinji);
            this.exF = (TbRichTextView) view.findViewById(w.h.richText);
            this.exH = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
            this.exG = (ConstrainImageGroup) view.findViewById(w.h.floor_images_content);
            this.awB = view.findViewById(w.h.pb_bottom_line);
            this.exI = (TextView) view.findViewById(w.h.floor_num);
            this.exG.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds16));
            this.exG.setSingleImageRatio(0.75d);
            this.exG.setImageProcessor(new com.baidu.tbadk.widget.layout.i(3));
            this.exF.IJ();
            this.exF.setImageViewStretch(true);
            this.exF.setTextSize(TbConfig.getContentSize());
            this.exE.setIsRound(true);
            this.exF.k(this.esY, false);
            this.exF.setVoiceViewRes(w.j.voice_play_btn_new);
            this.etU = (TextView) view.findViewById(w.h.pb_item_tail_content);
        }
    }
}
