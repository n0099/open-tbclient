package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
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
/* loaded from: classes2.dex */
public class l extends r.a {
    public TextView bQl;
    public View bmk;
    public View fDK;
    public boolean fDv;
    public TextView fEp;
    public LinearLayout fIO;
    public ImageView fIP;
    public TextView fIQ;
    public View fIR;
    public View fIS;
    public TextView fIT;
    public PbFloorAgreeView fIU;
    public ImageView fIV;
    public HeadImageView fIW;
    public TbRichTextView fIX;
    public ConstrainImageGroup fIY;
    public SubPbLayout fIZ;
    public TextView fJa;
    public ImageView fJb;
    public HeadPendantView fJc;
    public UserIconBox fJd;
    public UserIconBox fJe;
    public LinearLayout fJf;
    public TextView fJg;
    public View fJh;
    public TextView fJi;
    public ImageView fJj;
    public LinearLayout fJk;
    public TextView fJl;
    public LinearLayout fJm;
    public TextView fJn;
    public ImageView fJo;
    public View mBottomLine;
    public int mSkinType;

    public l(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fDv = true;
        if (tbPageContext != null && view != null) {
            this.fDK = view;
            this.bmk = view.findViewById(d.g.top_divider_line);
            this.bQl = (TextView) view.findViewById(d.g.view_user_name);
            this.fIO = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.fIP = (ImageView) view.findViewById(d.g.view_author_tip);
            this.fIQ = (TextView) view.findViewById(d.g.view_post_time);
            this.fJb = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.fIT = (TextView) view.findViewById(d.g.view_location);
            this.fIV = (ImageView) view.findViewById(d.g.image_more_tip);
            this.fIU = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.fIW = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.fJc = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.fJc.DG();
            if (this.fJc.getHeadView() != null) {
                this.fJc.getHeadView().setIsRound(true);
                this.fJc.getHeadView().setDrawBorder(false);
            }
            this.fJd = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.fJe = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.fIX = (TbRichTextView) view.findViewById(d.g.richText);
            this.fIZ = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.fIY = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.fJa = (TextView) view.findViewById(d.g.floor_num);
            this.fIR = view.findViewById(d.g.line_between_floor_and_time);
            this.fIS = view.findViewById(d.g.line_between_time_and_locate);
            this.fIY.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fIY.setSingleImageRatio(0.75d);
            this.fIY.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.fIX.setLayoutStrategy(new b(this.fIX.getLayoutStrategy()));
            this.fIX.setTextSize(TbConfig.getContentSize());
            this.fIW.setIsRound(true);
            this.fIX.o(this.fDv, false);
            this.fIX.setVoiceViewRes(d.h.voice_play_btn_new);
            this.fEp = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.fJf = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.fJg = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fJh = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.fJi = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.fJj = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fJk = (LinearLayout) view.findViewById(d.g.all_content);
            this.fJl = (TextView) view.findViewById(d.g.fold_tip_text);
            this.fJm = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.fJn = (TextView) view.findViewById(d.g.fold_title);
            this.fJo = (ImageView) view.findViewById(d.g.fold_btn);
        }
    }
}
