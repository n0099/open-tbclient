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
    public boolean hGG;
    public TextView hHA;
    public ImageView hHB;
    public HeadPendantView hHC;
    public UserIconBox hHD;
    public UserIconBox hHE;
    public TextView hHF;
    public LinearLayout hHG;
    public TextView hHH;
    public View hHI;
    public TextView hHJ;
    public ImageView hHK;
    public LinearLayout hHL;
    public LinearLayout hHM;
    public TextView hHN;
    public ImageView hHO;
    public View hHm;
    public LinearLayout hHn;
    public TextView hHo;
    public TextView hHp;
    public TextView hHq;
    public TextView hHr;
    public TextView hHs;
    public AgreeView hHt;
    public HeadImageView hHu;
    public TbRichTextView hHv;
    public ConstrainImageGroup hHw;
    public SubPbLayout hHx;
    public TextView hHy;
    public TextView hHz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hGG = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hHm = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.ejs = (TextView) view.findViewById(R.id.view_user_name);
            this.hHn = (LinearLayout) view.findViewById(R.id.content_user_and_praise);
            this.hHo = (TextView) view.findViewById(R.id.view_author_tip);
            this.hHp = (TextView) view.findViewById(R.id.view_post_time);
            this.hHB = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.hHs = (TextView) view.findViewById(R.id.view_location);
            this.hHt = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.hHt.setAgreeAnimationResource(R.raw.agree);
            this.hHt.setDisagreeAnimationResource(R.raw.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bEz = 5;
            dVar.bEE = 8;
            dVar.bED = 2;
            this.hHt.setStatisticData(dVar);
            this.hHt.setLayoutParams(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds112), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds17), com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds7), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds3), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds13));
            this.hHu = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.hHC = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.hHC.setHasPendantStyle();
            if (this.hHC.getHeadView() != null) {
                this.hHC.getHeadView().setIsRound(true);
                this.hHC.getHeadView().setDrawBorder(false);
            }
            this.hHD = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.hHE = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.hHv = (TbRichTextView) view.findViewById(R.id.richText);
            this.hHx = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.hHy = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.hHy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.hHy.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.hHy.setTextSize(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.hHz = (TextView) view.findViewById(R.id.pb_post_reply);
            this.hHw = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.hHA = (TextView) view.findViewById(R.id.floor_num);
            this.hHq = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.hHr = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.hHw.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.hHw.setSingleImageRatio(0.75d);
            this.hHw.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hHv.getLayoutStrategy());
            bVar.lw(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hHv.setLayoutStrategy(bVar);
            this.hHv.setTextSize(TbConfig.getContentSize());
            this.hHu.setIsRound(true);
            this.hHv.setDisplayImage(this.hGG, false);
            this.hHv.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.hHF = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.hHG = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.hHH = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.hHI = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.hHJ = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.hHK = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.hHL = (LinearLayout) view.findViewById(R.id.all_content);
            this.hHM = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.hHN = (TextView) view.findViewById(R.id.fold_title);
            this.hHO = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void oj(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bEz = 12;
            dVar.bEE = 9;
            dVar.bED = 3;
            this.hHt.setStatisticData(dVar);
        }
    }
}
