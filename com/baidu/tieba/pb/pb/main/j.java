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
    public View azf;
    public TextView cjV;
    public View fiT;
    public LinearLayout fiU;
    public ImageView fiV;
    public TextView fiW;
    public View fiX;
    public View fiY;
    public TextView fiZ;
    public boolean fih;
    public PbFloorAgreeView fja;
    public ImageView fjb;
    public HeadImageView fjc;
    public TbRichTextView fjd;
    public ConstrainImageGroup fje;
    public SubPbLayout fjf;
    public TextView fjg;
    public ImageView fjh;
    public HeadPendantView fji;
    public UserIconBox fjj;
    public UserIconBox fjk;
    public TextView fjl;
    public LinearLayout fjm;
    public TextView fjn;
    public View fjo;
    public TextView fjp;
    public ImageView fjq;
    public LinearLayout fjr;
    public LinearLayout fjs;
    public TextView fjt;
    public ImageView fju;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.mSkinType = 3;
        this.fih = true;
        if (tbPageContext != null && view2 != null) {
            this.fiT = view2;
            this.azf = view2.findViewById(d.g.top_divider_line);
            this.cjV = (TextView) view2.findViewById(d.g.view_user_name);
            this.fiU = (LinearLayout) view2.findViewById(d.g.content_user_and_praise);
            this.fiV = (ImageView) view2.findViewById(d.g.view_author_tip);
            this.fiW = (TextView) view2.findViewById(d.g.view_post_time);
            this.fjh = (ImageView) view2.findViewById(d.g.icon_forum_level);
            this.fiZ = (TextView) view2.findViewById(d.g.view_location);
            this.fjb = (ImageView) view2.findViewById(d.g.image_more_tip);
            this.fja = (PbFloorAgreeView) view2.findViewById(d.g.view_floor_praise);
            this.fjc = (HeadImageView) view2.findViewById(d.g.normal_user_photo);
            this.fji = (HeadPendantView) view2.findViewById(d.g.pendant_user_photo);
            this.fji.setHasPendantStyle();
            if (this.fji.getHeadView() != null) {
                this.fji.getHeadView().setIsRound(true);
                this.fji.getHeadView().setDrawBorder(false);
            }
            this.fjj = (UserIconBox) view2.findViewById(d.g.show_icon_vip);
            this.fjk = (UserIconBox) view2.findViewById(d.g.show_icon_yinji);
            this.fjd = (TbRichTextView) view2.findViewById(d.g.richText);
            this.fjf = (SubPbLayout) view2.findViewById(d.g.pb_post_footer_layout);
            this.fje = (ConstrainImageGroup) view2.findViewById(d.g.floor_images_content);
            this.mBottomLine = view2.findViewById(d.g.pb_bottom_line);
            this.fjg = (TextView) view2.findViewById(d.g.floor_num);
            this.fiX = view2.findViewById(d.g.line_between_floor_and_time);
            this.fiY = view2.findViewById(d.g.line_between_time_and_locate);
            this.fje.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fje.setSingleImageRatio(0.75d);
            this.fje.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fjd.setLayoutStrategy(new b(this.fjd.getLayoutStrategy()));
            this.fjd.setTextSize(TbConfig.getContentSize());
            this.fjc.setIsRound(true);
            this.fjd.setDisplayImage(this.fih, false);
            this.fjd.setVoiceViewRes(d.i.voice_play_btn_new);
            this.fjl = (TextView) view2.findViewById(d.g.pb_item_tail_content);
            this.fjm = (LinearLayout) view2.findViewById(d.g.pb_post_recommend_live_layout);
            this.fjn = (TextView) view2.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fjo = view2.findViewById(d.g.pb_post_recommend_live_divider);
            this.fjp = (TextView) view2.findViewById(d.g.pb_post_recommend_live_title);
            this.fjq = (ImageView) view2.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fjr = (LinearLayout) view2.findViewById(d.g.all_content);
            this.fjs = (LinearLayout) view2.findViewById(d.g.fold_op_area);
            this.fjt = (TextView) view2.findViewById(d.g.fold_title);
            this.fju = (ImageView) view2.findViewById(d.g.fold_btn);
        }
    }
}
