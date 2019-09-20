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
import com.baidu.tbadk.core.util.SvgManager;
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
    public TextView epQ;
    public boolean hPK;
    public ConstrainImageGroup hQA;
    public SubPbLayout hQB;
    public TextView hQC;
    public TextView hQD;
    public TextView hQE;
    public ImageView hQF;
    public HeadPendantView hQG;
    public UserIconBox hQH;
    public UserIconBox hQI;
    public TextView hQJ;
    public LinearLayout hQK;
    public TextView hQL;
    public View hQM;
    public TextView hQN;
    public ImageView hQO;
    public LinearLayout hQP;
    public LinearLayout hQQ;
    public TextView hQR;
    public ImageView hQS;
    public View hQq;
    public LinearLayout hQr;
    public TextView hQs;
    public TextView hQt;
    public TextView hQu;
    public TextView hQv;
    public TextView hQw;
    public AgreeView hQx;
    public HeadImageView hQy;
    public TbRichTextView hQz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hPK = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hQq = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.epQ = (TextView) view.findViewById(R.id.view_user_name);
            this.hQr = (LinearLayout) view.findViewById(R.id.content_user_and_praise);
            this.hQs = (TextView) view.findViewById(R.id.view_author_tip);
            this.hQt = (TextView) view.findViewById(R.id.view_post_time);
            this.hQF = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.hQw = (TextView) view.findViewById(R.id.view_location);
            this.hQx = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.hQx.setAgreeAnimationResource(R.raw.agree);
            this.hQx.setDisagreeAnimationResource(R.raw.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bFY = 5;
            dVar.bGd = 8;
            dVar.bGc = 2;
            this.hQx.setStatisticData(dVar);
            this.hQx.setLayoutParams(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds112), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds17), com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds7), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds3), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds13));
            this.hQy = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.hQG = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.hQG.setHasPendantStyle();
            if (this.hQG.getHeadView() != null) {
                this.hQG.getHeadView().setIsRound(true);
                this.hQG.getHeadView().setDrawBorder(false);
            }
            this.hQH = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.hQI = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.hQz = (TbRichTextView) view.findViewById(R.id.richText);
            this.hQB = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.hQC = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.hQC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.hQC.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.hQC.setTextSize(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.hQD = (TextView) view.findViewById(R.id.pb_post_reply);
            this.hQA = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.hQE = (TextView) view.findViewById(R.id.floor_num);
            this.hQu = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.hQv = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.hQA.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.hQA.setSingleImageRatio(0.75d);
            this.hQA.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hQz.getLayoutStrategy());
            bVar.lH(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hQz.setLayoutStrategy(bVar);
            this.hQz.setTextSize(TbConfig.getContentSize());
            this.hQy.setIsRound(true);
            this.hQz.setDisplayImage(this.hPK, false);
            this.hQz.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.hQJ = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.hQK = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.hQL = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.hQM = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.hQN = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.hQO = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.hQP = (LinearLayout) view.findViewById(R.id.all_content);
            this.hQQ = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.hQR = (TextView) view.findViewById(R.id.fold_title);
            this.hQS = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void oB(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bFY = 12;
            dVar.bGd = 9;
            dVar.bGc = 3;
            this.hQx.setStatisticData(dVar);
        }
    }
}
