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
public class j extends j.a {
    public TextView aYX;
    public View axd;
    public TextView ceM;
    public TextView eAW;
    public boolean eAa;
    public View eAq;
    public LinearLayout eEA;
    public TextView eEB;
    public TextView eEC;
    public View eED;
    public TextView eEE;
    public PbFloorAgreeView eEF;
    public ImageView eEG;
    public HeadImageView eEH;
    public TbRichTextView eEI;
    public ConstrainImageGroup eEJ;
    public SubPbLayout eEK;
    public TextView eEL;
    public ImageView eEM;
    public HeadPendantView eEN;
    public UserIconBox eEO;
    public UserIconBox eEP;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eAa = true;
        if (tbPageContext != null && view != null) {
            this.eAq = view;
            this.axd = view.findViewById(d.h.top_divider_line);
            this.aYX = (TextView) view.findViewById(d.h.view_user_name);
            this.eEA = (LinearLayout) view.findViewById(d.h.content_user_and_praise);
            this.eEB = (TextView) view.findViewById(d.h.view_author_tip);
            this.eEC = (TextView) view.findViewById(d.h.view_post_time);
            this.ceM = (TextView) view.findViewById(d.h.view_forum_name);
            this.eEM = (ImageView) view.findViewById(d.h.icon_forum_level);
            this.eEE = (TextView) view.findViewById(d.h.view_location);
            this.eEG = (ImageView) view.findViewById(d.h.image_more_tip);
            this.eEF = (PbFloorAgreeView) view.findViewById(d.h.view_floor_praise);
            this.eEH = (HeadImageView) view.findViewById(d.h.normal_user_photo);
            this.eEN = (HeadPendantView) view.findViewById(d.h.pendant_user_photo);
            this.eEN.wg();
            if (this.eEN.getHeadView() != null) {
                this.eEN.getHeadView().setIsRound(true);
                this.eEN.getHeadView().setDrawBorder(false);
            }
            if (this.eEN.getPendantView() != null) {
                this.eEN.getPendantView().setIsRound(true);
                this.eEN.getPendantView().setDrawBorder(false);
            }
            this.eEO = (UserIconBox) view.findViewById(d.h.show_icon_vip);
            this.eEP = (UserIconBox) view.findViewById(d.h.show_icon_yinji);
            this.eEI = (TbRichTextView) view.findViewById(d.h.richText);
            this.eEK = (SubPbLayout) view.findViewById(d.h.pb_post_footer_layout);
            this.eEJ = (ConstrainImageGroup) view.findViewById(d.h.floor_images_content);
            this.mBottomLine = view.findViewById(d.h.pb_bottom_line);
            this.eEL = (TextView) view.findViewById(d.h.floor_num);
            this.eED = view.findViewById(d.h.line_between_floor_and_time);
            this.eEJ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
            this.eEJ.setSingleImageRatio(0.75d);
            this.eEJ.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eEI.Jt();
            this.eEI.setImageViewStretch(true);
            this.eEI.setTextSize(TbConfig.getContentSize());
            this.eEH.setIsRound(true);
            this.eEI.m(this.eAa, false);
            this.eEI.setVoiceViewRes(d.j.voice_play_btn_new);
            this.eAW = (TextView) view.findViewById(d.h.pb_item_tail_content);
        }
    }
}
