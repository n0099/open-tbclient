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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes4.dex */
public class j extends v.a {
    public TextView ejr;
    public boolean hGC;
    public UserIconBox hHA;
    public TextView hHB;
    public LinearLayout hHC;
    public TextView hHD;
    public View hHE;
    public TextView hHF;
    public ImageView hHG;
    public LinearLayout hHH;
    public LinearLayout hHI;
    public TextView hHJ;
    public ImageView hHK;
    public View hHi;
    public LinearLayout hHj;
    public TextView hHk;
    public TextView hHl;
    public TextView hHm;
    public TextView hHn;
    public TextView hHo;
    public AgreeView hHp;
    public HeadImageView hHq;
    public TbRichTextView hHr;
    public ConstrainImageGroup hHs;
    public SubPbLayout hHt;
    public TextView hHu;
    public TextView hHv;
    public TextView hHw;
    public ImageView hHx;
    public HeadPendantView hHy;
    public UserIconBox hHz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hGC = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hHi = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.ejr = (TextView) view.findViewById(R.id.view_user_name);
            this.hHj = (LinearLayout) view.findViewById(R.id.content_user_and_praise);
            this.hHk = (TextView) view.findViewById(R.id.view_author_tip);
            this.hHl = (TextView) view.findViewById(R.id.view_post_time);
            this.hHx = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.hHo = (TextView) view.findViewById(R.id.view_location);
            this.hHp = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.hHp.setAgreeAnimationResource(R.raw.agree);
            this.hHp.setDisagreeAnimationResource(R.raw.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bEy = 5;
            dVar.bED = 8;
            dVar.bEC = 2;
            this.hHp.setStatisticData(dVar);
            this.hHp.setLayoutParams(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds112), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds17), com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds7), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds3), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds13));
            this.hHq = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.hHy = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.hHy.setHasPendantStyle();
            if (this.hHy.getHeadView() != null) {
                this.hHy.getHeadView().setIsRound(true);
                this.hHy.getHeadView().setDrawBorder(false);
            }
            this.hHz = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.hHA = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.hHr = (TbRichTextView) view.findViewById(R.id.richText);
            this.hHt = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.hHu = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.hHu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.hHu.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.hHu.setTextSize(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.hHv = (TextView) view.findViewById(R.id.pb_post_reply);
            this.hHs = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.hHw = (TextView) view.findViewById(R.id.floor_num);
            this.hHm = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.hHn = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.hHs.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.hHs.setSingleImageRatio(0.75d);
            this.hHs.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hHr.getLayoutStrategy());
            bVar.lw(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hHr.setLayoutStrategy(bVar);
            this.hHr.setTextSize(TbConfig.getContentSize());
            this.hHq.setIsRound(true);
            this.hHr.setDisplayImage(this.hGC, false);
            this.hHr.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.hHB = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.hHC = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.hHD = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.hHE = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.hHF = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.hHG = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.hHH = (LinearLayout) view.findViewById(R.id.all_content);
            this.hHI = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.hHJ = (TextView) view.findViewById(R.id.fold_title);
            this.hHK = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void oi(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bEy = 12;
            dVar.bED = 9;
            dVar.bEC = 3;
            this.hHp.setStatisticData(dVar);
        }
    }
}
