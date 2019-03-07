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
    public View hpY;
    public LinearLayout hpZ;
    public boolean hps;
    public ImageView hqA;
    public TextView hqa;
    public TextView hqb;
    public TextView hqc;
    public TextView hqd;
    public TextView hqe;
    public AgreeView hqf;
    public HeadImageView hqg;
    public TbRichTextView hqh;
    public ConstrainImageGroup hqi;
    public SubPbLayout hqj;
    public TextView hqk;
    public TextView hql;
    public TextView hqm;
    public ImageView hqn;
    public HeadPendantView hqo;
    public UserIconBox hqp;
    public UserIconBox hqq;
    public TextView hqr;
    public LinearLayout hqs;
    public TextView hqt;
    public View hqu;
    public TextView hqv;
    public ImageView hqw;
    public LinearLayout hqx;
    public LinearLayout hqy;
    public TextView hqz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hps = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hpY = view;
            this.mTopLine = view.findViewById(d.g.top_divider_line);
            this.dZy = (TextView) view.findViewById(d.g.view_user_name);
            this.hpZ = (LinearLayout) view.findViewById(d.g.content_user_and_praise);
            this.hqa = (TextView) view.findViewById(d.g.view_author_tip);
            this.hqb = (TextView) view.findViewById(d.g.view_post_time);
            this.hqn = (ImageView) view.findViewById(d.g.icon_forum_level);
            this.hqe = (TextView) view.findViewById(d.g.view_location);
            this.hqf = (AgreeView) view.findViewById(d.g.pb_floor_praise_view);
            this.hqf.setAgreeAnimationResource(d.i.agree);
            this.hqf.setDisagreeAnimationResource(d.i.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxh = 5;
            dVar.bxm = 8;
            dVar.bxl = 2;
            this.hqf.setStatisticData(dVar);
            this.hqf.setLayoutParams(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds112), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds17), com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds7), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds3), -com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds13));
            this.hqg = (HeadImageView) view.findViewById(d.g.normal_user_photo);
            this.hqo = (HeadPendantView) view.findViewById(d.g.pendant_user_photo);
            this.hqo.setHasPendantStyle();
            if (this.hqo.getHeadView() != null) {
                this.hqo.getHeadView().setIsRound(true);
                this.hqo.getHeadView().setDrawBorder(false);
            }
            this.hqp = (UserIconBox) view.findViewById(d.g.show_icon_vip);
            this.hqq = (UserIconBox) view.findViewById(d.g.show_icon_yinji);
            this.hqh = (TbRichTextView) view.findViewById(d.g.richText);
            this.hqj = (SubPbLayout) view.findViewById(d.g.pb_post_footer_layout);
            this.hqk = (TextView) view.findViewById(d.g.pb_post_reply_count);
            this.hqk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
            this.hqk.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds4));
            this.hqk.setTextSize(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds40));
            this.hql = (TextView) view.findViewById(d.g.pb_post_reply);
            this.hqi = (ConstrainImageGroup) view.findViewById(d.g.floor_images_content);
            this.mBottomLine = view.findViewById(d.g.pb_bottom_line);
            this.hqm = (TextView) view.findViewById(d.g.floor_num);
            this.hqc = (TextView) view.findViewById(d.g.point_between_floor_and_time);
            this.hqd = (TextView) view.findViewById(d.g.point_between_time_and_locate);
            this.hqi.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
            this.hqi.setSingleImageRatio(0.75d);
            this.hqi.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hqh.getLayoutStrategy());
            bVar.kI(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hqh.setLayoutStrategy(bVar);
            this.hqh.setTextSize(TbConfig.getContentSize());
            this.hqg.setIsRound(true);
            this.hqh.setDisplayImage(this.hps, false);
            this.hqh.setVoiceViewRes(d.h.voice_play_btn_new);
            this.hqr = (TextView) view.findViewById(d.g.pb_item_tail_content);
            this.hqs = (LinearLayout) view.findViewById(d.g.pb_post_recommend_live_layout);
            this.hqt = (TextView) view.findViewById(d.g.pb_post_recommend_live_prefix_tv);
            this.hqu = view.findViewById(d.g.pb_post_recommend_live_divider);
            this.hqv = (TextView) view.findViewById(d.g.pb_post_recommend_live_title);
            this.hqw = (ImageView) view.findViewById(d.g.pb_post_recommend_live_arrow);
            this.hqx = (LinearLayout) view.findViewById(d.g.all_content);
            this.hqy = (LinearLayout) view.findViewById(d.g.fold_op_area);
            this.hqz = (TextView) view.findViewById(d.g.fold_title);
            this.hqA = (ImageView) view.findViewById(d.g.pic_comment_god);
        }
    }

    public void nt(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxh = 12;
            dVar.bxm = 9;
            dVar.bxl = 3;
            this.hqf.setStatisticData(dVar);
        }
    }
}
