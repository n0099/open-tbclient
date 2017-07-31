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
    public TextView aXy;
    public View ayJ;
    public View ayK;
    public TextView cap;
    public View eFJ;
    public boolean eFu;
    public TextView eGp;
    public LinearLayout eJV;
    public TextView eJW;
    public TextView eJX;
    public TextView eJY;
    public PbFloorAgreeView eJZ;
    public ImageView eKa;
    public HeadImageView eKb;
    public TbRichTextView eKc;
    public ConstrainImageGroup eKd;
    public SubPbLayout eKe;
    public TextView eKf;
    public ImageView eKg;
    public HeadPendantView eKh;
    public UserIconBox eKi;
    public UserIconBox eKj;
    public int mSkinType;

    public k(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eFu = true;
        if (tbPageContext != null && view != null) {
            this.eFJ = view;
            this.ayJ = view.findViewById(d.h.top_divider_line);
            this.aXy = (TextView) view.findViewById(d.h.view_user_name);
            this.eJV = (LinearLayout) view.findViewById(d.h.content_user_and_praise);
            this.eJW = (TextView) view.findViewById(d.h.view_author_tip);
            this.eJX = (TextView) view.findViewById(d.h.view_post_time);
            this.cap = (TextView) view.findViewById(d.h.view_forum_name);
            this.eKg = (ImageView) view.findViewById(d.h.icon_forum_level);
            this.eJY = (TextView) view.findViewById(d.h.view_location);
            this.eKa = (ImageView) view.findViewById(d.h.image_more_tip);
            this.eJZ = (PbFloorAgreeView) view.findViewById(d.h.view_floor_praise);
            this.eKb = (HeadImageView) view.findViewById(d.h.normal_user_photo);
            this.eKh = (HeadPendantView) view.findViewById(d.h.pendant_user_photo);
            this.eKh.wD();
            if (this.eKh.getHeadView() != null) {
                this.eKh.getHeadView().setIsRound(true);
                this.eKh.getHeadView().setDrawBorder(false);
            }
            if (this.eKh.getPendantView() != null) {
                this.eKh.getPendantView().setIsRound(true);
                this.eKh.getPendantView().setDrawBorder(false);
            }
            this.eKi = (UserIconBox) view.findViewById(d.h.show_icon_vip);
            this.eKj = (UserIconBox) view.findViewById(d.h.show_icon_yinji);
            this.eKc = (TbRichTextView) view.findViewById(d.h.richText);
            this.eKe = (SubPbLayout) view.findViewById(d.h.pb_post_footer_layout);
            this.eKd = (ConstrainImageGroup) view.findViewById(d.h.floor_images_content);
            this.ayK = view.findViewById(d.h.pb_bottom_line);
            this.eKf = (TextView) view.findViewById(d.h.floor_num);
            this.eKd.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
            this.eKd.setSingleImageRatio(0.75d);
            this.eKd.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eKc.Jc();
            this.eKc.setImageViewStretch(true);
            this.eKc.setTextSize(TbConfig.getContentSize());
            this.eKb.setIsRound(true);
            this.eKc.k(this.eFu, false);
            this.eKc.setVoiceViewRes(d.j.voice_play_btn_new);
            this.eGp = (TextView) view.findViewById(d.h.pb_item_tail_content);
        }
    }
}
