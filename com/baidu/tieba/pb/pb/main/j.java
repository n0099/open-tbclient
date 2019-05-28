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
    public TextView ejs;
    public boolean hGF;
    public ImageView hHA;
    public HeadPendantView hHB;
    public UserIconBox hHC;
    public UserIconBox hHD;
    public TextView hHE;
    public LinearLayout hHF;
    public TextView hHG;
    public View hHH;
    public TextView hHI;
    public ImageView hHJ;
    public LinearLayout hHK;
    public LinearLayout hHL;
    public TextView hHM;
    public ImageView hHN;
    public View hHl;
    public LinearLayout hHm;
    public TextView hHn;
    public TextView hHo;
    public TextView hHp;
    public TextView hHq;
    public TextView hHr;
    public AgreeView hHs;
    public HeadImageView hHt;
    public TbRichTextView hHu;
    public ConstrainImageGroup hHv;
    public SubPbLayout hHw;
    public TextView hHx;
    public TextView hHy;
    public TextView hHz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hGF = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hHl = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.ejs = (TextView) view.findViewById(R.id.view_user_name);
            this.hHm = (LinearLayout) view.findViewById(R.id.content_user_and_praise);
            this.hHn = (TextView) view.findViewById(R.id.view_author_tip);
            this.hHo = (TextView) view.findViewById(R.id.view_post_time);
            this.hHA = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.hHr = (TextView) view.findViewById(R.id.view_location);
            this.hHs = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.hHs.setAgreeAnimationResource(R.raw.agree);
            this.hHs.setDisagreeAnimationResource(R.raw.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bEy = 5;
            dVar.bED = 8;
            dVar.bEC = 2;
            this.hHs.setStatisticData(dVar);
            this.hHs.setLayoutParams(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds112), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds17), com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds7), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds3), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds13));
            this.hHt = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.hHB = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.hHB.setHasPendantStyle();
            if (this.hHB.getHeadView() != null) {
                this.hHB.getHeadView().setIsRound(true);
                this.hHB.getHeadView().setDrawBorder(false);
            }
            this.hHC = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.hHD = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.hHu = (TbRichTextView) view.findViewById(R.id.richText);
            this.hHw = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.hHx = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.hHx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.hHx.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.hHx.setTextSize(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.hHy = (TextView) view.findViewById(R.id.pb_post_reply);
            this.hHv = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.hHz = (TextView) view.findViewById(R.id.floor_num);
            this.hHp = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.hHq = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.hHv.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.hHv.setSingleImageRatio(0.75d);
            this.hHv.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hHu.getLayoutStrategy());
            bVar.lw(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hHu.setLayoutStrategy(bVar);
            this.hHu.setTextSize(TbConfig.getContentSize());
            this.hHt.setIsRound(true);
            this.hHu.setDisplayImage(this.hGF, false);
            this.hHu.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.hHE = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.hHF = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.hHG = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.hHH = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.hHI = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.hHJ = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.hHK = (LinearLayout) view.findViewById(R.id.all_content);
            this.hHL = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.hHM = (TextView) view.findViewById(R.id.fold_title);
            this.hHN = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void oi(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bEy = 12;
            dVar.bED = 9;
            dVar.bEC = 3;
            this.hHs.setStatisticData(dVar);
        }
    }
}
