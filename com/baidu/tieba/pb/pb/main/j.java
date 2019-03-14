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
    public TextView dZu;
    public View hpS;
    public LinearLayout hpT;
    public TextView hpU;
    public TextView hpV;
    public TextView hpW;
    public TextView hpX;
    public TextView hpY;
    public AgreeView hpZ;
    public boolean hpm;
    public HeadImageView hqa;
    public TbRichTextView hqb;
    public ConstrainImageGroup hqc;
    public SubPbLayout hqd;
    public TextView hqe;
    public TextView hqf;
    public TextView hqg;
    public ImageView hqh;
    public HeadPendantView hqi;
    public UserIconBox hqj;
    public UserIconBox hqk;
    public TextView hql;
    public LinearLayout hqm;
    public TextView hqn;
    public View hqo;
    public TextView hqp;
    public ImageView hqq;
    public LinearLayout hqr;
    public LinearLayout hqs;
    public TextView hqt;
    public ImageView hqu;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hpm = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hpS = view;
            this.mTopLine = view.findViewById(d.g.top_divider_line);
            this.dZu = (TextView) view.findViewById(d.g.view_user_name);
            this.hpT = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.hpU = (TextView) view.findViewById(d.g.view_author_tip);
            this.hpV = (TextView) view.findViewById(d.g.view_post_time);
            this.hqh = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.hpY = (TextView) view.findViewById(d.g.view_location);
            this.hpZ = (AgreeView) view.findViewById(d.g.pb_floor_praise_view);
            this.hpZ.setAgreeAnimationResource(d.i.agree);
            this.hpZ.setDisagreeAnimationResource(d.i.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxj = 5;
            dVar.bxo = 8;
            dVar.bxn = 2;
            this.hpZ.setStatisticData(dVar);
            this.hpZ.setLayoutParams(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds112), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds17), com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds7), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds3), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds13));
            this.hqa = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.hqi = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.hqi.setHasPendantStyle();
            if (this.hqi.getHeadView() != null) {
                this.hqi.getHeadView().setIsRound(true);
                this.hqi.getHeadView().setDrawBorder(false);
            }
            this.hqj = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.hqk = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.hqb = (TbRichTextView) view.findViewById(d.g.richText);
            this.hqd = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.hqe = (TextView) view.findViewById(d.g.pb_post_reply_count);
            this.hqe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
            this.hqe.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds4));
            this.hqe.setTextSize(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds40));
            this.hqf = (TextView) view.findViewById(d.g.pb_post_reply);
            this.hqc = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.hqg = (TextView) view.findViewById(d.g.floor_num);
            this.hpW = (TextView) view.findViewById(d.g.point_between_floor_and_time);
            this.hpX = (TextView) view.findViewById(d.g.point_between_time_and_locate);
            this.hqc.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.hqc.setSingleImageRatio(0.75d);
            this.hqc.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hqb.getLayoutStrategy());
            bVar.kI(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hqb.setLayoutStrategy(bVar);
            this.hqb.setTextSize(TbConfig.getContentSize());
            this.hqa.setIsRound(true);
            this.hqb.setDisplayImage(this.hpm, false);
            this.hqb.setVoiceViewRes(d.h.voice_play_btn_new);
            this.hql = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.hqm = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.hqn = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.hqo = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.hqp = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.hqq = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.hqr = (LinearLayout) view.findViewById(d.g.all_content);
            this.hqs = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.hqt = (TextView) view.findViewById(d.g.fold_title);
            this.hqu = (ImageView) view.findViewById(d.g.pic_comment_god);
        }
    }

    public void nt(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxj = 12;
            dVar.bxo = 9;
            dVar.bxn = 3;
            this.hpZ.setStatisticData(dVar);
        }
    }
}
