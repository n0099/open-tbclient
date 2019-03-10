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
    public TextView dZy;
    public View hpZ;
    public boolean hpt;
    public TextView hqA;
    public ImageView hqB;
    public LinearLayout hqa;
    public TextView hqb;
    public TextView hqc;
    public TextView hqd;
    public TextView hqe;
    public TextView hqf;
    public AgreeView hqg;
    public HeadImageView hqh;
    public TbRichTextView hqi;
    public ConstrainImageGroup hqj;
    public SubPbLayout hqk;
    public TextView hql;
    public TextView hqm;
    public TextView hqn;
    public ImageView hqo;
    public HeadPendantView hqp;
    public UserIconBox hqq;
    public UserIconBox hqr;
    public TextView hqs;
    public LinearLayout hqt;
    public TextView hqu;
    public View hqv;
    public TextView hqw;
    public ImageView hqx;
    public LinearLayout hqy;
    public LinearLayout hqz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hpt = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hpZ = view;
            this.mTopLine = view.findViewById(d.g.top_divider_line);
            this.dZy = (TextView) view.findViewById(d.g.view_user_name);
            this.hqa = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.hqb = (TextView) view.findViewById(d.g.view_author_tip);
            this.hqc = (TextView) view.findViewById(d.g.view_post_time);
            this.hqo = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.hqf = (TextView) view.findViewById(d.g.view_location);
            this.hqg = (AgreeView) view.findViewById(d.g.pb_floor_praise_view);
            this.hqg.setAgreeAnimationResource(d.i.agree);
            this.hqg.setDisagreeAnimationResource(d.i.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxh = 5;
            dVar.bxm = 8;
            dVar.bxl = 2;
            this.hqg.setStatisticData(dVar);
            this.hqg.setLayoutParams(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds112), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds17), com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds7), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds3), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds13));
            this.hqh = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.hqp = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.hqp.setHasPendantStyle();
            if (this.hqp.getHeadView() != null) {
                this.hqp.getHeadView().setIsRound(true);
                this.hqp.getHeadView().setDrawBorder(false);
            }
            this.hqq = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.hqr = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.hqi = (TbRichTextView) view.findViewById(d.g.richText);
            this.hqk = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.hql = (TextView) view.findViewById(d.g.pb_post_reply_count);
            this.hql.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
            this.hql.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds4));
            this.hql.setTextSize(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds40));
            this.hqm = (TextView) view.findViewById(d.g.pb_post_reply);
            this.hqj = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.hqn = (TextView) view.findViewById(d.g.floor_num);
            this.hqd = (TextView) view.findViewById(d.g.point_between_floor_and_time);
            this.hqe = (TextView) view.findViewById(d.g.point_between_time_and_locate);
            this.hqj.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.hqj.setSingleImageRatio(0.75d);
            this.hqj.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hqi.getLayoutStrategy());
            bVar.kI(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hqi.setLayoutStrategy(bVar);
            this.hqi.setTextSize(TbConfig.getContentSize());
            this.hqh.setIsRound(true);
            this.hqi.setDisplayImage(this.hpt, false);
            this.hqi.setVoiceViewRes(d.h.voice_play_btn_new);
            this.hqs = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.hqt = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.hqu = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.hqv = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.hqw = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.hqx = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.hqy = (LinearLayout) view.findViewById(d.g.all_content);
            this.hqz = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.hqA = (TextView) view.findViewById(d.g.fold_title);
            this.hqB = (ImageView) view.findViewById(d.g.pic_comment_god);
        }
    }

    public void nt(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxh = 12;
            dVar.bxm = 9;
            dVar.bxl = 3;
            this.hqg.setStatisticData(dVar);
        }
    }
}
