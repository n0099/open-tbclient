package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.PostDisPraiseView;
import com.baidu.tbadk.core.view.PostPraiseView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes2.dex */
public class j extends q.a {
    public TextView cyw;
    public View fFW;
    public LinearLayout fFX;
    public TextView fFY;
    public TextView fFZ;
    public boolean fFt;
    public View fGa;
    public View fGb;
    public TextView fGc;
    public ImageView fGd;
    public PostPraiseView fGe;
    public PostDisPraiseView fGf;
    public HeadImageView fGg;
    public TbRichTextView fGh;
    public ConstrainImageGroup fGi;
    public SubPbLayout fGj;
    public TextView fGk;
    public ImageView fGl;
    public HeadPendantView fGm;
    public UserIconBox fGn;
    public UserIconBox fGo;
    public TextView fGp;
    public LinearLayout fGq;
    public TextView fGr;
    public View fGs;
    public TextView fGt;
    public ImageView fGu;
    public LinearLayout fGv;
    public LinearLayout fGw;
    public TextView fGx;
    public ImageView fGy;
    public com.baidu.tbadk.core.view.a fGz;
    public View mBottomLine;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fFt = true;
        if (tbPageContext != null && view != null) {
            this.fFW = view;
            this.mTopLine = view.findViewById(e.g.top_divider_line);
            this.cyw = (TextView) view.findViewById(e.g.view_user_name);
            this.fFX = (LinearLayout) view.findViewById(e.g.content_user_and_praise);
            this.fFY = (TextView) view.findViewById(e.g.view_author_tip);
            this.fFZ = (TextView) view.findViewById(e.g.view_post_time);
            this.fGl = (ImageView) view.findViewById(e.g.icon_forum_level);
            this.fGc = (TextView) view.findViewById(e.g.view_location);
            this.fGd = (ImageView) view.findViewById(e.g.image_more_tip);
            this.fGe = (PostPraiseView) view.findViewById(e.g.view_floor_new_praise);
            this.fGf = (PostDisPraiseView) view.findViewById(e.g.view_floor_new_dispraise);
            this.fGz = new com.baidu.tbadk.core.view.a(this.fGe, this.fGf, this.fGd);
            this.fGg = (HeadImageView) view.findViewById(e.g.normal_user_photo);
            this.fGm = (HeadPendantView) view.findViewById(e.g.pendant_user_photo);
            this.fGm.setHasPendantStyle();
            if (this.fGm.getHeadView() != null) {
                this.fGm.getHeadView().setIsRound(true);
                this.fGm.getHeadView().setDrawBorder(false);
            }
            this.fGn = (UserIconBox) view.findViewById(e.g.show_icon_vip);
            this.fGo = (UserIconBox) view.findViewById(e.g.show_icon_yinji);
            this.fGh = (TbRichTextView) view.findViewById(e.g.richText);
            this.fGj = (SubPbLayout) view.findViewById(e.g.pb_post_footer_layout);
            this.fGi = (ConstrainImageGroup) view.findViewById(e.g.floor_images_content);
            this.mBottomLine = view.findViewById(e.g.pb_bottom_line);
            this.fGk = (TextView) view.findViewById(e.g.floor_num);
            this.fGa = view.findViewById(e.g.line_between_floor_and_time);
            this.fGb = view.findViewById(e.g.line_between_time_and_locate);
            this.fGi.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds16));
            this.fGi.setSingleImageRatio(0.75d);
            this.fGi.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fGh.setLayoutStrategy(new b(this.fGh.getLayoutStrategy()));
            this.fGh.setTextSize(TbConfig.getContentSize());
            this.fGg.setIsRound(true);
            this.fGh.setDisplayImage(this.fFt, false);
            this.fGh.setVoiceViewRes(e.h.voice_play_btn_new);
            this.fGp = (TextView) view.findViewById(e.g.pb_item_tail_content);
            this.fGq = (LinearLayout) view.findViewById(e.g.pb_post_recommend_live_layout);
            this.fGr = (TextView) view.findViewById(e.g.pb_post_recommend_live_prefix_tv);
            this.fGs = view.findViewById(e.g.pb_post_recommend_live_divider);
            this.fGt = (TextView) view.findViewById(e.g.pb_post_recommend_live_title);
            this.fGu = (ImageView) view.findViewById(e.g.pb_post_recommend_live_arrow);
            this.fGv = (LinearLayout) view.findViewById(e.g.all_content);
            this.fGw = (LinearLayout) view.findViewById(e.g.fold_op_area);
            this.fGx = (TextView) view.findViewById(e.g.fold_title);
            this.fGy = (ImageView) view.findViewById(e.g.fold_btn);
            this.fGz.Bn();
            this.fGz.h(tbPageContext.getUniqueId());
        }
    }

    public void aX(boolean z) {
        if (this.fGz != null) {
            this.fGz.aX(z);
            this.fGz.Bn();
        }
    }
}
