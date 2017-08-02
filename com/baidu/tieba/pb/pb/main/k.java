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
    public TextView aWn;
    public View axs;
    public View axt;
    public TextView bZj;
    public boolean eEh;
    public View eEw;
    public TextView eFc;
    public LinearLayout eII;
    public TextView eIJ;
    public TextView eIK;
    public TextView eIL;
    public PbFloorAgreeView eIM;
    public ImageView eIN;
    public HeadImageView eIO;
    public TbRichTextView eIP;
    public ConstrainImageGroup eIQ;
    public SubPbLayout eIR;
    public TextView eIS;
    public ImageView eIT;
    public HeadPendantView eIU;
    public UserIconBox eIV;
    public UserIconBox eIW;
    public int mSkinType;

    public k(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eEh = true;
        if (tbPageContext != null && view != null) {
            this.eEw = view;
            this.axs = view.findViewById(d.h.top_divider_line);
            this.aWn = (TextView) view.findViewById(d.h.view_user_name);
            this.eII = (LinearLayout) view.findViewById(d.h.content_user_and_praise);
            this.eIJ = (TextView) view.findViewById(d.h.view_author_tip);
            this.eIK = (TextView) view.findViewById(d.h.view_post_time);
            this.bZj = (TextView) view.findViewById(d.h.view_forum_name);
            this.eIT = (ImageView) view.findViewById(d.h.icon_forum_level);
            this.eIL = (TextView) view.findViewById(d.h.view_location);
            this.eIN = (ImageView) view.findViewById(d.h.image_more_tip);
            this.eIM = (PbFloorAgreeView) view.findViewById(d.h.view_floor_praise);
            this.eIO = (HeadImageView) view.findViewById(d.h.normal_user_photo);
            this.eIU = (HeadPendantView) view.findViewById(d.h.pendant_user_photo);
            this.eIU.wt();
            if (this.eIU.getHeadView() != null) {
                this.eIU.getHeadView().setIsRound(true);
                this.eIU.getHeadView().setDrawBorder(false);
            }
            if (this.eIU.getPendantView() != null) {
                this.eIU.getPendantView().setIsRound(true);
                this.eIU.getPendantView().setDrawBorder(false);
            }
            this.eIV = (UserIconBox) view.findViewById(d.h.show_icon_vip);
            this.eIW = (UserIconBox) view.findViewById(d.h.show_icon_yinji);
            this.eIP = (TbRichTextView) view.findViewById(d.h.richText);
            this.eIR = (SubPbLayout) view.findViewById(d.h.pb_post_footer_layout);
            this.eIQ = (ConstrainImageGroup) view.findViewById(d.h.floor_images_content);
            this.axt = view.findViewById(d.h.pb_bottom_line);
            this.eIS = (TextView) view.findViewById(d.h.floor_num);
            this.eIQ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
            this.eIQ.setSingleImageRatio(0.75d);
            this.eIQ.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eIP.IV();
            this.eIP.setImageViewStretch(true);
            this.eIP.setTextSize(TbConfig.getContentSize());
            this.eIO.setIsRound(true);
            this.eIP.k(this.eEh, false);
            this.eIP.setVoiceViewRes(d.j.voice_play_btn_new);
            this.eFc = (TextView) view.findViewById(d.h.pb_item_tail_content);
        }
    }
}
