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
    public TextView bQA;
    public View bmB;
    public View fFF;
    public boolean fFq;
    public TextView fGk;
    public LinearLayout fKJ;
    public ImageView fKK;
    public TextView fKL;
    public View fKM;
    public View fKN;
    public TextView fKO;
    public PbFloorAgreeView fKP;
    public ImageView fKQ;
    public HeadImageView fKR;
    public TbRichTextView fKS;
    public ConstrainImageGroup fKT;
    public SubPbLayout fKU;
    public TextView fKV;
    public ImageView fKW;
    public HeadPendantView fKX;
    public UserIconBox fKY;
    public UserIconBox fKZ;
    public LinearLayout fLa;
    public TextView fLb;
    public View fLc;
    public TextView fLd;
    public ImageView fLe;
    public LinearLayout fLf;
    public TextView fLg;
    public LinearLayout fLh;
    public TextView fLi;
    public ImageView fLj;
    public View mBottomLine;
    public int mSkinType;

    public l(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fFq = true;
        if (tbPageContext != null && view != null) {
            this.fFF = view;
            this.bmB = view.findViewById(d.g.top_divider_line);
            this.bQA = (TextView) view.findViewById(d.g.view_user_name);
            this.fKJ = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.fKK = (ImageView) view.findViewById(d.g.view_author_tip);
            this.fKL = (TextView) view.findViewById(d.g.view_post_time);
            this.fKW = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.fKO = (TextView) view.findViewById(d.g.view_location);
            this.fKQ = (ImageView) view.findViewById(d.g.image_more_tip);
            this.fKP = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.fKR = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.fKX = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.fKX.Dz();
            if (this.fKX.getHeadView() != null) {
                this.fKX.getHeadView().setIsRound(true);
                this.fKX.getHeadView().setDrawBorder(false);
            }
            this.fKY = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.fKZ = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.fKS = (TbRichTextView) view.findViewById(d.g.richText);
            this.fKU = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.fKT = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.fKV = (TextView) view.findViewById(d.g.floor_num);
            this.fKM = view.findViewById(d.g.line_between_floor_and_time);
            this.fKN = view.findViewById(d.g.line_between_time_and_locate);
            this.fKT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fKT.setSingleImageRatio(0.75d);
            this.fKT.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.fKS.setLayoutStrategy(new b(this.fKS.getLayoutStrategy()));
            this.fKS.setTextSize(TbConfig.getContentSize());
            this.fKR.setIsRound(true);
            this.fKS.o(this.fFq, false);
            this.fKS.setVoiceViewRes(d.h.voice_play_btn_new);
            this.fGk = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.fLa = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.fLb = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fLc = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.fLd = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.fLe = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fLf = (LinearLayout) view.findViewById(d.g.all_content);
            this.fLg = (TextView) view.findViewById(d.g.fold_tip_text);
            this.fLh = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.fLi = (TextView) view.findViewById(d.g.fold_title);
            this.fLj = (ImageView) view.findViewById(d.g.fold_btn);
        }
    }
}
