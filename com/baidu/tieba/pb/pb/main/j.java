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
    public TextView cja;
    public View fhN;
    public LinearLayout fhO;
    public ImageView fhP;
    public TextView fhQ;
    public View fhR;
    public View fhS;
    public TextView fhT;
    public PbFloorAgreeView fhU;
    public ImageView fhV;
    public HeadImageView fhW;
    public TbRichTextView fhX;
    public ConstrainImageGroup fhY;
    public SubPbLayout fhZ;
    public boolean fhc;
    public TextView fia;
    public ImageView fib;
    public HeadPendantView fic;
    public UserIconBox fie;
    public UserIconBox fif;
    public TextView fig;
    public LinearLayout fih;
    public TextView fii;
    public View fij;
    public TextView fik;
    public ImageView fil;
    public LinearLayout fim;
    public LinearLayout fin;
    public TextView fio;
    public ImageView fip;
    public View mBottomLine;
    public int mSkinType;

    public j(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.mSkinType = 3;
        this.fhc = true;
        if (tbPageContext != null && view2 != null) {
            this.fhN = view2;
            this.aze = view2.findViewById(d.g.top_divider_line);
            this.cja = (TextView) view2.findViewById(d.g.view_user_name);
            this.fhO = (LinearLayout) view2.findViewById(d.g.content_user_and_praise);
            this.fhP = (ImageView) view2.findViewById(d.g.view_author_tip);
            this.fhQ = (TextView) view2.findViewById(d.g.view_post_time);
            this.fib = (ImageView) view2.findViewById(d.g.icon_forum_level);
            this.fhT = (TextView) view2.findViewById(d.g.view_location);
            this.fhV = (ImageView) view2.findViewById(d.g.image_more_tip);
            this.fhU = (PbFloorAgreeView) view2.findViewById(d.g.view_floor_praise);
            this.fhW = (HeadImageView) view2.findViewById(d.g.normal_user_photo);
            this.fic = (HeadPendantView) view2.findViewById(d.g.pendant_user_photo);
            this.fic.setHasPendantStyle();
            if (this.fic.getHeadView() != null) {
                this.fic.getHeadView().setIsRound(true);
                this.fic.getHeadView().setDrawBorder(false);
            }
            this.fie = (UserIconBox) view2.findViewById(d.g.show_icon_vip);
            this.fif = (UserIconBox) view2.findViewById(d.g.show_icon_yinji);
            this.fhX = (TbRichTextView) view2.findViewById(d.g.richText);
            this.fhZ = (SubPbLayout) view2.findViewById(d.g.pb_post_footer_layout);
            this.fhY = (ConstrainImageGroup) view2.findViewById(d.g.floor_images_content);
            this.mBottomLine = view2.findViewById(d.g.pb_bottom_line);
            this.fia = (TextView) view2.findViewById(d.g.floor_num);
            this.fhR = view2.findViewById(d.g.line_between_floor_and_time);
            this.fhS = view2.findViewById(d.g.line_between_time_and_locate);
            this.fhY.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.fhY.setSingleImageRatio(0.75d);
            this.fhY.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fhX.setLayoutStrategy(new b(this.fhX.getLayoutStrategy()));
            this.fhX.setTextSize(TbConfig.getContentSize());
            this.fhW.setIsRound(true);
            this.fhX.setDisplayImage(this.fhc, false);
            this.fhX.setVoiceViewRes(d.i.voice_play_btn_new);
            this.fig = (TextView) view2.findViewById(d.g.pb_item_tail_content);
            this.fih = (LinearLayout) view2.findViewById(d.g.pb_post_recommend_live_layout);
            this.fii = (TextView) view2.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.fij = view2.findViewById(d.g.pb_post_recommend_live_divider);
            this.fik = (TextView) view2.findViewById(d.g.pb_post_recommend_live_title);
            this.fil = (ImageView) view2.findViewById(d.g.pb_post_recommend_live_arrow);
            this.fim = (LinearLayout) view2.findViewById(d.g.all_content);
            this.fin = (LinearLayout) view2.findViewById(d.g.fold_op_area);
            this.fio = (TextView) view2.findViewById(d.g.fold_title);
            this.fip = (ImageView) view2.findViewById(d.g.fold_btn);
        }
    }
}
