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
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes2.dex */
public class j extends q.a {
    public View aze;
    public TextView ciX;
    public boolean fgZ;
    public View fhK;
    public LinearLayout fhL;
    public ImageView fhM;
    public TextView fhN;
    public View fhO;
    public View fhP;
    public TextView fhQ;
    public PbFloorAgreeView fhR;
    public ImageView fhS;
    public HeadImageView fhT;
    public TbRichTextView fhU;
    public ConstrainImageGroup fhV;
    public SubPbLayout fhW;
    public TextView fhX;
    public ImageView fhY;
    public HeadPendantView fhZ;
    public UserIconBox fia;
    public UserIconBox fib;
    public TextView fic;
    public LinearLayout fie;
    public TextView fif;
    public View fig;
    public TextView fih;
    public ImageView fii;
    public LinearLayout fij;
    public LinearLayout fik;
    public TextView fil;
    public ImageView fim;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.mSkinType = 3;
        this.fgZ = true;
        if (tbPageContext != null && view2 != null) {
            this.fhK = view2;
            this.aze = view2.findViewById(d.g.top_divider_line);
            this.ciX = (TextView) view2.findViewById(d.g.view_user_name);
            this.fhL = (LinearLayout) view2.findViewById(d.g.content_user_and_praise);
            this.fhM = (ImageView) view2.findViewById(d.g.view_author_tip);
            this.fhN = (TextView) view2.findViewById(d.g.view_post_time);
            this.fhY = (ImageView) view2.findViewById(d.g.icon_forum_level);
            this.fhQ = (TextView) view2.findViewById(d.g.view_location);
            this.fhS = (ImageView) view2.findViewById(d.g.image_more_tip);
            this.fhR = (PbFloorAgreeView) view2.findViewById(d.g.view_floor_praise);
            this.fhT = (HeadImageView) view2.findViewById(d.g.normal_user_photo);
            this.fhZ = (HeadPendantView) view2.findViewById(d.g.pendant_user_photo);
            this.fhZ.setHasPendantStyle();
            if (this.fhZ.getHeadView() != null) {
                this.fhZ.getHeadView().setIsRound(true);
                this.fhZ.getHeadView().setDrawBorder(false);
            }
            this.fia = (UserIconBox) view2.findViewById(d.g.show_icon_vip);
            this.fib = (UserIconBox) view2.findViewById(d.g.show_icon_yinji);
            this.fhU = (TbRichTextView) view2.findViewById(d.g.richText);
            this.fhW = (SubPbLayout) view2.findViewById(d.g.pb_post_footer_layout);
            this.fhV = (ConstrainImageGroup) view2.findViewById(d.g.floor_images_content);
            this.mBottomLine = view2.findViewById(d.g.pb_bottom_line);
            this.fhX = (TextView) view2.findViewById(d.g.floor_num);
            this.fhO = view2.findViewById(d.g.line_between_floor_and_time);
            this.fhP = view2.findViewById(d.g.line_between_time_and_locate);
            this.fhV.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fhV.setSingleImageRatio(0.75d);
            this.fhV.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fhU.setLayoutStrategy(new b(this.fhU.getLayoutStrategy()));
            this.fhU.setTextSize(TbConfig.getContentSize());
            this.fhT.setIsRound(true);
            this.fhU.setDisplayImage(this.fgZ, false);
            this.fhU.setVoiceViewRes(d.i.voice_play_btn_new);
            this.fic = (TextView) view2.findViewById(d.g.pb_item_tail_content);
            this.fie = (LinearLayout) view2.findViewById(d.g.pb_post_recommend_live_layout);
            this.fif = (TextView) view2.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fig = view2.findViewById(d.g.pb_post_recommend_live_divider);
            this.fih = (TextView) view2.findViewById(d.g.pb_post_recommend_live_title);
            this.fii = (ImageView) view2.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fij = (LinearLayout) view2.findViewById(d.g.all_content);
            this.fik = (LinearLayout) view2.findViewById(d.g.fold_op_area);
            this.fil = (TextView) view2.findViewById(d.g.fold_title);
            this.fim = (ImageView) view2.findViewById(d.g.fold_btn);
        }
    }
}
