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
    public TextView aXj;
    public View axT;
    public View axU;
    public TextView ceL;
    public boolean eGD;
    public View eGS;
    public TextView eHy;
    public LinearLayout eLb;
    public TextView eLc;
    public TextView eLd;
    public View eLe;
    public TextView eLf;
    public PbFloorAgreeView eLg;
    public ImageView eLh;
    public HeadImageView eLi;
    public TbRichTextView eLj;
    public ConstrainImageGroup eLk;
    public SubPbLayout eLl;
    public TextView eLm;
    public ImageView eLn;
    public HeadPendantView eLo;
    public UserIconBox eLp;
    public UserIconBox eLq;
    public int mSkinType;

    public k(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eGD = true;
        if (tbPageContext != null && view != null) {
            this.eGS = view;
            this.axT = view.findViewById(d.h.top_divider_line);
            this.aXj = (TextView) view.findViewById(d.h.view_user_name);
            this.eLb = (LinearLayout) view.findViewById(d.h.content_user_and_praise);
            this.eLc = (TextView) view.findViewById(d.h.view_author_tip);
            this.eLd = (TextView) view.findViewById(d.h.view_post_time);
            this.ceL = (TextView) view.findViewById(d.h.view_forum_name);
            this.eLn = (ImageView) view.findViewById(d.h.icon_forum_level);
            this.eLf = (TextView) view.findViewById(d.h.view_location);
            this.eLh = (ImageView) view.findViewById(d.h.image_more_tip);
            this.eLg = (PbFloorAgreeView) view.findViewById(d.h.view_floor_praise);
            this.eLi = (HeadImageView) view.findViewById(d.h.normal_user_photo);
            this.eLo = (HeadPendantView) view.findViewById(d.h.pendant_user_photo);
            this.eLo.wB();
            if (this.eLo.getHeadView() != null) {
                this.eLo.getHeadView().setIsRound(true);
                this.eLo.getHeadView().setDrawBorder(false);
            }
            if (this.eLo.getPendantView() != null) {
                this.eLo.getPendantView().setIsRound(true);
                this.eLo.getPendantView().setDrawBorder(false);
            }
            this.eLp = (UserIconBox) view.findViewById(d.h.show_icon_vip);
            this.eLq = (UserIconBox) view.findViewById(d.h.show_icon_yinji);
            this.eLj = (TbRichTextView) view.findViewById(d.h.richText);
            this.eLl = (SubPbLayout) view.findViewById(d.h.pb_post_footer_layout);
            this.eLk = (ConstrainImageGroup) view.findViewById(d.h.floor_images_content);
            this.axU = view.findViewById(d.h.pb_bottom_line);
            this.eLm = (TextView) view.findViewById(d.h.floor_num);
            this.eLe = view.findViewById(d.h.line_between_floor_and_time);
            this.eLk.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
            this.eLk.setSingleImageRatio(0.75d);
            this.eLk.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.eLj.Jk();
            this.eLj.setImageViewStretch(true);
            this.eLj.setTextSize(TbConfig.getContentSize());
            this.eLi.setIsRound(true);
            this.eLj.l(this.eGD, false);
            this.eLj.setVoiceViewRes(d.j.voice_play_btn_new);
            this.eHy = (TextView) view.findViewById(d.h.pb_item_tail_content);
        }
    }
}
