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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes2.dex */
public class j extends q.a {
    public TextView csG;
    public boolean fxC;
    public HeadPendantView fyA;
    public UserIconBox fyB;
    public UserIconBox fyC;
    public TextView fyD;
    public LinearLayout fyE;
    public TextView fyF;
    public View fyG;
    public TextView fyH;
    public ImageView fyI;
    public LinearLayout fyJ;
    public LinearLayout fyK;
    public TextView fyL;
    public ImageView fyM;
    public View fyl;
    public LinearLayout fym;
    public TextView fyn;
    public TextView fyo;
    public View fyp;
    public View fyq;
    public TextView fyr;
    public PbFloorAgreeView fys;
    public ImageView fyt;
    public HeadImageView fyu;
    public TbRichTextView fyv;
    public ConstrainImageGroup fyw;
    public SubPbLayout fyx;
    public TextView fyy;
    public ImageView fyz;
    public View mBottomLine;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fxC = true;
        if (tbPageContext != null && view != null) {
            this.fyl = view;
            this.mTopLine = view.findViewById(f.g.top_divider_line);
            this.csG = (TextView) view.findViewById(f.g.view_user_name);
            this.fym = (LinearLayout) view.findViewById(f.g.content_user_and_praise);
            this.fyn = (TextView) view.findViewById(f.g.view_author_tip);
            this.fyo = (TextView) view.findViewById(f.g.view_post_time);
            this.fyz = (ImageView) view.findViewById(f.g.icon_forum_level);
            this.fyr = (TextView) view.findViewById(f.g.view_location);
            this.fyt = (ImageView) view.findViewById(f.g.image_more_tip);
            this.fys = (PbFloorAgreeView) view.findViewById(f.g.view_floor_praise);
            this.fyu = (HeadImageView) view.findViewById(f.g.normal_user_photo);
            this.fyA = (HeadPendantView) view.findViewById(f.g.pendant_user_photo);
            this.fyA.setHasPendantStyle();
            if (this.fyA.getHeadView() != null) {
                this.fyA.getHeadView().setIsRound(true);
                this.fyA.getHeadView().setDrawBorder(false);
            }
            this.fyB = (UserIconBox) view.findViewById(f.g.show_icon_vip);
            this.fyC = (UserIconBox) view.findViewById(f.g.show_icon_yinji);
            this.fyv = (TbRichTextView) view.findViewById(f.g.richText);
            this.fyx = (SubPbLayout) view.findViewById(f.g.pb_post_footer_layout);
            this.fyw = (ConstrainImageGroup) view.findViewById(f.g.floor_images_content);
            this.mBottomLine = view.findViewById(f.g.pb_bottom_line);
            this.fyy = (TextView) view.findViewById(f.g.floor_num);
            this.fyp = view.findViewById(f.g.line_between_floor_and_time);
            this.fyq = view.findViewById(f.g.line_between_time_and_locate);
            this.fyw.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds16));
            this.fyw.setSingleImageRatio(0.75d);
            this.fyw.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fyv.setLayoutStrategy(new b(this.fyv.getLayoutStrategy()));
            this.fyv.setTextSize(TbConfig.getContentSize());
            this.fyu.setIsRound(true);
            this.fyv.setDisplayImage(this.fxC, false);
            this.fyv.setVoiceViewRes(f.h.voice_play_btn_new);
            this.fyD = (TextView) view.findViewById(f.g.pb_item_tail_content);
            this.fyE = (LinearLayout) view.findViewById(f.g.pb_post_recommend_live_layout);
            this.fyF = (TextView) view.findViewById(f.g.pb_post_recommend_live_prefix_tv);
            this.fyG = view.findViewById(f.g.pb_post_recommend_live_divider);
            this.fyH = (TextView) view.findViewById(f.g.pb_post_recommend_live_title);
            this.fyI = (ImageView) view.findViewById(f.g.pb_post_recommend_live_arrow);
            this.fyJ = (LinearLayout) view.findViewById(f.g.all_content);
            this.fyK = (LinearLayout) view.findViewById(f.g.fold_op_area);
            this.fyL = (TextView) view.findViewById(f.g.fold_title);
            this.fyM = (ImageView) view.findViewById(f.g.fold_btn);
        }
    }
}
