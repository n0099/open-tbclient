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
    public TextView dYS;
    public View hpG;
    public LinearLayout hpH;
    public TextView hpI;
    public TextView hpJ;
    public TextView hpK;
    public TextView hpL;
    public TextView hpM;
    public AgreeView hpN;
    public HeadImageView hpO;
    public TbRichTextView hpP;
    public ConstrainImageGroup hpQ;
    public SubPbLayout hpR;
    public TextView hpS;
    public TextView hpT;
    public TextView hpU;
    public ImageView hpV;
    public HeadPendantView hpW;
    public UserIconBox hpX;
    public UserIconBox hpY;
    public TextView hpZ;
    public boolean hpa;
    public LinearLayout hqa;
    public TextView hqb;
    public View hqc;
    public TextView hqd;
    public ImageView hqe;
    public LinearLayout hqf;
    public LinearLayout hqg;
    public TextView hqh;
    public ImageView hqi;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hpa = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hpG = view;
            this.mTopLine = view.findViewById(d.g.top_divider_line);
            this.dYS = (TextView) view.findViewById(d.g.view_user_name);
            this.hpH = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.hpI = (TextView) view.findViewById(d.g.view_author_tip);
            this.hpJ = (TextView) view.findViewById(d.g.view_post_time);
            this.hpV = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.hpM = (TextView) view.findViewById(d.g.view_location);
            this.hpN = (AgreeView) view.findViewById(d.g.pb_floor_praise_view);
            this.hpN.setAgreeAnimationResource(d.i.agree);
            this.hpN.setDisagreeAnimationResource(d.i.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxn = 5;
            dVar.bxs = 8;
            dVar.bxr = 2;
            this.hpN.setStatisticData(dVar);
            this.hpN.setLayoutParams(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds112), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds17), com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds7), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds3), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds13));
            this.hpO = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.hpW = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.hpW.setHasPendantStyle();
            if (this.hpW.getHeadView() != null) {
                this.hpW.getHeadView().setIsRound(true);
                this.hpW.getHeadView().setDrawBorder(false);
            }
            this.hpX = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.hpY = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.hpP = (TbRichTextView) view.findViewById(d.g.richText);
            this.hpR = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.hpS = (TextView) view.findViewById(d.g.pb_post_reply_count);
            this.hpS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
            this.hpS.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds4));
            this.hpS.setTextSize(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds40));
            this.hpT = (TextView) view.findViewById(d.g.pb_post_reply);
            this.hpQ = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.hpU = (TextView) view.findViewById(d.g.floor_num);
            this.hpK = (TextView) view.findViewById(d.g.point_between_floor_and_time);
            this.hpL = (TextView) view.findViewById(d.g.point_between_time_and_locate);
            this.hpQ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.hpQ.setSingleImageRatio(0.75d);
            this.hpQ.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hpP.getLayoutStrategy());
            bVar.kH(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hpP.setLayoutStrategy(bVar);
            this.hpP.setTextSize(TbConfig.getContentSize());
            this.hpO.setIsRound(true);
            this.hpP.setDisplayImage(this.hpa, false);
            this.hpP.setVoiceViewRes(d.h.voice_play_btn_new);
            this.hpZ = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.hqa = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.hqb = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.hqc = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.hqd = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.hqe = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.hqf = (LinearLayout) view.findViewById(d.g.all_content);
            this.hqg = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.hqh = (TextView) view.findViewById(d.g.fold_title);
            this.hqi = (ImageView) view.findViewById(d.g.pic_comment_god);
        }
    }

    public void nt(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxn = 12;
            dVar.bxs = 9;
            dVar.bxr = 3;
            this.hpN.setStatisticData(dVar);
        }
    }
}
