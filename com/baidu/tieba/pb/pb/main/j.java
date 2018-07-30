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
    public View aIx;
    public TextView csJ;
    public boolean fxJ;
    public ImageView fyA;
    public HeadImageView fyB;
    public TbRichTextView fyC;
    public ConstrainImageGroup fyD;
    public SubPbLayout fyE;
    public TextView fyF;
    public ImageView fyG;
    public HeadPendantView fyH;
    public UserIconBox fyI;
    public UserIconBox fyJ;
    public TextView fyK;
    public LinearLayout fyL;
    public TextView fyM;
    public View fyN;
    public TextView fyO;
    public ImageView fyP;
    public LinearLayout fyQ;
    public LinearLayout fyR;
    public TextView fyS;
    public ImageView fyT;
    public View fys;
    public LinearLayout fyt;
    public TextView fyu;
    public TextView fyv;
    public View fyw;
    public View fyx;
    public TextView fyy;
    public PbFloorAgreeView fyz;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fxJ = true;
        if (tbPageContext != null && view != null) {
            this.fys = view;
            this.aIx = view.findViewById(d.g.top_divider_line);
            this.csJ = (TextView) view.findViewById(d.g.view_user_name);
            this.fyt = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.fyu = (TextView) view.findViewById(d.g.view_author_tip);
            this.fyv = (TextView) view.findViewById(d.g.view_post_time);
            this.fyG = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.fyy = (TextView) view.findViewById(d.g.view_location);
            this.fyA = (ImageView) view.findViewById(d.g.image_more_tip);
            this.fyz = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.fyB = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.fyH = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.fyH.setHasPendantStyle();
            if (this.fyH.getHeadView() != null) {
                this.fyH.getHeadView().setIsRound(true);
                this.fyH.getHeadView().setDrawBorder(false);
            }
            this.fyI = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.fyJ = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.fyC = (TbRichTextView) view.findViewById(d.g.richText);
            this.fyE = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.fyD = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.fyF = (TextView) view.findViewById(d.g.floor_num);
            this.fyw = view.findViewById(d.g.line_between_floor_and_time);
            this.fyx = view.findViewById(d.g.line_between_time_and_locate);
            this.fyD.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fyD.setSingleImageRatio(0.75d);
            this.fyD.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fyC.setLayoutStrategy(new b(this.fyC.getLayoutStrategy()));
            this.fyC.setTextSize(TbConfig.getContentSize());
            this.fyB.setIsRound(true);
            this.fyC.setDisplayImage(this.fxJ, false);
            this.fyC.setVoiceViewRes(d.h.voice_play_btn_new);
            this.fyK = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.fyL = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.fyM = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fyN = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.fyO = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.fyP = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fyQ = (LinearLayout) view.findViewById(d.g.all_content);
            this.fyR = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.fyS = (TextView) view.findViewById(d.g.fold_title);
            this.fyT = (ImageView) view.findViewById(d.g.fold_btn);
        }
    }
}
