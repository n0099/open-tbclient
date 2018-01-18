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
    public TextView bQs;
    public View bmt;
    public boolean fEV;
    public TextView fFP;
    public View fFk;
    public TextView fKA;
    public ImageView fKB;
    public HeadPendantView fKC;
    public UserIconBox fKD;
    public UserIconBox fKE;
    public LinearLayout fKF;
    public TextView fKG;
    public View fKH;
    public TextView fKI;
    public ImageView fKJ;
    public LinearLayout fKK;
    public TextView fKL;
    public LinearLayout fKM;
    public TextView fKN;
    public ImageView fKO;
    public LinearLayout fKo;
    public ImageView fKp;
    public TextView fKq;
    public View fKr;
    public View fKs;
    public TextView fKt;
    public PbFloorAgreeView fKu;
    public ImageView fKv;
    public HeadImageView fKw;
    public TbRichTextView fKx;
    public ConstrainImageGroup fKy;
    public SubPbLayout fKz;
    public View mBottomLine;
    public int mSkinType;

    public l(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fEV = true;
        if (tbPageContext != null && view != null) {
            this.fFk = view;
            this.bmt = view.findViewById(d.g.top_divider_line);
            this.bQs = (TextView) view.findViewById(d.g.view_user_name);
            this.fKo = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.fKp = (ImageView) view.findViewById(d.g.view_author_tip);
            this.fKq = (TextView) view.findViewById(d.g.view_post_time);
            this.fKB = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.fKt = (TextView) view.findViewById(d.g.view_location);
            this.fKv = (ImageView) view.findViewById(d.g.image_more_tip);
            this.fKu = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.fKw = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.fKC = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.fKC.Dx();
            if (this.fKC.getHeadView() != null) {
                this.fKC.getHeadView().setIsRound(true);
                this.fKC.getHeadView().setDrawBorder(false);
            }
            this.fKD = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.fKE = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.fKx = (TbRichTextView) view.findViewById(d.g.richText);
            this.fKz = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.fKy = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.fKA = (TextView) view.findViewById(d.g.floor_num);
            this.fKr = view.findViewById(d.g.line_between_floor_and_time);
            this.fKs = view.findViewById(d.g.line_between_time_and_locate);
            this.fKy.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fKy.setSingleImageRatio(0.75d);
            this.fKy.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            this.fKx.setLayoutStrategy(new b(this.fKx.getLayoutStrategy()));
            this.fKx.setTextSize(TbConfig.getContentSize());
            this.fKw.setIsRound(true);
            this.fKx.o(this.fEV, false);
            this.fKx.setVoiceViewRes(d.h.voice_play_btn_new);
            this.fFP = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.fKF = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.fKG = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fKH = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.fKI = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.fKJ = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fKK = (LinearLayout) view.findViewById(d.g.all_content);
            this.fKL = (TextView) view.findViewById(d.g.fold_tip_text);
            this.fKM = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.fKN = (TextView) view.findViewById(d.g.fold_title);
            this.fKO = (ImageView) view.findViewById(d.g.fold_btn);
        }
    }
}
