package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes4.dex */
public class j extends v.a {
    public TextView dYR;
    public boolean hoZ;
    public View hpF;
    public LinearLayout hpG;
    public TextView hpH;
    public TextView hpI;
    public TextView hpJ;
    public TextView hpK;
    public TextView hpL;
    public AgreeView hpM;
    public HeadImageView hpN;
    public TbRichTextView hpO;
    public ConstrainImageGroup hpP;
    public SubPbLayout hpQ;
    public TextView hpR;
    public TextView hpS;
    public TextView hpT;
    public ImageView hpU;
    public HeadPendantView hpV;
    public UserIconBox hpW;
    public UserIconBox hpX;
    public TextView hpY;
    public LinearLayout hpZ;
    public TextView hqa;
    public View hqb;
    public TextView hqc;
    public ImageView hqd;
    public LinearLayout hqe;
    public LinearLayout hqf;
    public TextView hqg;
    public ImageView hqh;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hoZ = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hpF = view;
            this.mTopLine = view.findViewById(d.g.top_divider_line);
            this.dYR = (TextView) view.findViewById(d.g.view_user_name);
            this.hpG = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.hpH = (TextView) view.findViewById(d.g.view_author_tip);
            this.hpI = (TextView) view.findViewById(d.g.view_post_time);
            this.hpU = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.hpL = (TextView) view.findViewById(d.g.view_location);
            this.hpM = (AgreeView) view.findViewById(d.g.pb_floor_praise_view);
            this.hpM.setAgreeAnimationResource(d.i.agree);
            this.hpM.setDisagreeAnimationResource(d.i.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxm = 5;
            dVar.bxr = 8;
            dVar.bxq = 2;
            this.hpM.setStatisticData(dVar);
            this.hpM.setLayoutParams(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds112), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds17), com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds7), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds3), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds13));
            this.hpN = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.hpV = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.hpV.setHasPendantStyle();
            if (this.hpV.getHeadView() != null) {
                this.hpV.getHeadView().setIsRound(true);
                this.hpV.getHeadView().setDrawBorder(false);
            }
            this.hpW = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.hpX = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.hpO = (TbRichTextView) view.findViewById(d.g.richText);
            this.hpQ = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.hpR = (TextView) view.findViewById(d.g.pb_post_reply_count);
            this.hpR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
            this.hpR.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds4));
            this.hpR.setTextSize(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds40));
            this.hpS = (TextView) view.findViewById(d.g.pb_post_reply);
            this.hpP = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.hpT = (TextView) view.findViewById(d.g.floor_num);
            this.hpJ = (TextView) view.findViewById(d.g.point_between_floor_and_time);
            this.hpK = (TextView) view.findViewById(d.g.point_between_time_and_locate);
            this.hpP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.hpP.setSingleImageRatio(0.75d);
            this.hpP.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hpO.getLayoutStrategy());
            bVar.kH(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hpO.setLayoutStrategy(bVar);
            this.hpO.setTextSize(TbConfig.getContentSize());
            this.hpN.setIsRound(true);
            this.hpO.setDisplayImage(this.hoZ, false);
            this.hpO.setVoiceViewRes(d.h.voice_play_btn_new);
            this.hpY = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.hpZ = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.hqa = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.hqb = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.hqc = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.hqd = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.hqe = (LinearLayout) view.findViewById(d.g.all_content);
            this.hqf = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.hqg = (TextView) view.findViewById(d.g.fold_title);
            this.hqh = (ImageView) view.findViewById(d.g.pic_comment_god);
        }
    }

    public void nt(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxm = 12;
            dVar.bxr = 9;
            dVar.bxq = 3;
            this.hpM.setStatisticData(dVar);
        }
    }
}
