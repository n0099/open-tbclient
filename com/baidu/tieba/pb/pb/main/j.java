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
    public View aHA;
    public TextView csb;
    public boolean ftF;
    public SubPbLayout fuA;
    public TextView fuB;
    public ImageView fuC;
    public HeadPendantView fuD;
    public UserIconBox fuE;
    public UserIconBox fuF;
    public TextView fuG;
    public LinearLayout fuH;
    public TextView fuI;
    public View fuJ;
    public TextView fuK;
    public ImageView fuL;
    public LinearLayout fuM;
    public LinearLayout fuN;
    public TextView fuO;
    public ImageView fuP;
    public View fuo;
    public LinearLayout fup;
    public ImageView fuq;
    public TextView fur;
    public View fus;
    public View fut;
    public TextView fuu;
    public PbFloorAgreeView fuv;
    public ImageView fuw;
    public HeadImageView fux;
    public TbRichTextView fuy;
    public ConstrainImageGroup fuz;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.ftF = true;
        if (tbPageContext != null && view != null) {
            this.fuo = view;
            this.aHA = view.findViewById(d.g.top_divider_line);
            this.csb = (TextView) view.findViewById(d.g.view_user_name);
            this.fup = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.fuq = (ImageView) view.findViewById(d.g.view_author_tip);
            this.fur = (TextView) view.findViewById(d.g.view_post_time);
            this.fuC = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.fuu = (TextView) view.findViewById(d.g.view_location);
            this.fuw = (ImageView) view.findViewById(d.g.image_more_tip);
            this.fuv = (PbFloorAgreeView) view.findViewById(d.g.view_floor_praise);
            this.fux = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.fuD = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.fuD.setHasPendantStyle();
            if (this.fuD.getHeadView() != null) {
                this.fuD.getHeadView().setIsRound(true);
                this.fuD.getHeadView().setDrawBorder(false);
            }
            this.fuE = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.fuF = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.fuy = (TbRichTextView) view.findViewById(d.g.richText);
            this.fuA = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.fuz = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.fuB = (TextView) view.findViewById(d.g.floor_num);
            this.fus = view.findViewById(d.g.line_between_floor_and_time);
            this.fut = view.findViewById(d.g.line_between_time_and_locate);
            this.fuz.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fuz.setSingleImageRatio(0.75d);
            this.fuz.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fuy.setLayoutStrategy(new b(this.fuy.getLayoutStrategy()));
            this.fuy.setTextSize(TbConfig.getContentSize());
            this.fux.setIsRound(true);
            this.fuy.setDisplayImage(this.ftF, false);
            this.fuy.setVoiceViewRes(d.i.voice_play_btn_new);
            this.fuG = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.fuH = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.fuI = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fuJ = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.fuK = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.fuL = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fuM = (LinearLayout) view.findViewById(d.g.all_content);
            this.fuN = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.fuO = (TextView) view.findViewById(d.g.fold_title);
            this.fuP = (ImageView) view.findViewById(d.g.fold_btn);
        }
    }
}
