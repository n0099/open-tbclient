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
    public TextView aYJ;
    public View awR;
    public TextView ceA;
    public TextView eAI;
    public View eAc;
    public UserIconBox eEA;
    public UserIconBox eEB;
    public LinearLayout eEm;
    public TextView eEn;
    public TextView eEo;
    public View eEp;
    public TextView eEq;
    public PbFloorAgreeView eEr;
    public ImageView eEs;
    public HeadImageView eEt;
    public TbRichTextView eEu;
    public ConstrainImageGroup eEv;
    public SubPbLayout eEw;
    public TextView eEx;
    public ImageView eEy;
    public HeadPendantView eEz;
    public boolean ezM;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.ezM = true;
        if (tbPageContext != null && view != null) {
            this.eAc = view;
            this.awR = view.findViewById(d.h.top_divider_line);
            this.aYJ = (TextView) view.findViewById(d.h.view_user_name);
            this.eEm = (LinearLayout) view.findViewById(d.h.content_user_and_praise);
            this.eEn = (TextView) view.findViewById(d.h.view_author_tip);
            this.eEo = (TextView) view.findViewById(d.h.view_post_time);
            this.ceA = (TextView) view.findViewById(d.h.view_forum_name);
            this.eEy = (ImageView) view.findViewById(d.h.icon_forum_level);
            this.eEq = (TextView) view.findViewById(d.h.view_location);
            this.eEs = (ImageView) view.findViewById(d.h.image_more_tip);
            this.eEr = (PbFloorAgreeView) view.findViewById(d.h.view_floor_praise);
            this.eEt = (HeadImageView) view.findViewById(d.h.normal_user_photo);
            this.eEz = (HeadPendantView) view.findViewById(d.h.pendant_user_photo);
            this.eEz.vZ();
            if (this.eEz.getHeadView() != null) {
                this.eEz.getHeadView().setIsRound(true);
                this.eEz.getHeadView().setDrawBorder(false);
            }
            if (this.eEz.getPendantView() != null) {
                this.eEz.getPendantView().setIsRound(true);
                this.eEz.getPendantView().setDrawBorder(false);
            }
            this.eEA = (UserIconBox) view.findViewById(d.h.show_icon_vip);
            this.eEB = (UserIconBox) view.findViewById(d.h.show_icon_yinji);
            this.eEu = (TbRichTextView) view.findViewById(d.h.richText);
            this.eEw = (SubPbLayout) view.findViewById(d.h.pb_post_footer_layout);
            this.eEv = (ConstrainImageGroup) view.findViewById(d.h.floor_images_content);
            this.mBottomLine = view.findViewById(d.h.pb_bottom_line);
            this.eEx = (TextView) view.findViewById(d.h.floor_num);
            this.eEp = view.findViewById(d.h.line_between_floor_and_time);
            this.eEv.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
            this.eEv.setSingleImageRatio(0.75d);
            this.eEv.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eEu.Jn();
            this.eEu.setImageViewStretch(true);
            this.eEu.setTextSize(TbConfig.getContentSize());
            this.eEt.setIsRound(true);
            this.eEu.m(this.ezM, false);
            this.eEu.setVoiceViewRes(d.j.voice_play_btn_new);
            this.eAI = (TextView) view.findViewById(d.h.pb_item_tail_content);
        }
    }
}
