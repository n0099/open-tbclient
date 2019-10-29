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
    public TextView eAg;
    public View hOV;
    public LinearLayout hOW;
    public TextView hOX;
    public TextView hOY;
    public TextView hOZ;
    public boolean hOp;
    public TextView hPa;
    public TextView hPb;
    public AgreeView hPc;
    public HeadImageView hPd;
    public TbRichTextView hPe;
    public ConstrainImageGroup hPf;
    public SubPbLayout hPg;
    public TextView hPh;
    public TextView hPi;
    public TextView hPj;
    public ImageView hPk;
    public HeadPendantView hPl;
    public UserIconBox hPm;
    public UserIconBox hPn;
    public TextView hPo;
    public LinearLayout hPp;
    public TextView hPq;
    public View hPr;
    public TextView hPs;
    public ImageView hPt;
    public LinearLayout hPu;
    public LinearLayout hPv;
    public TextView hPw;
    public ImageView hPx;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hOp = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hOV = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.eAg = (TextView) view.findViewById(R.id.view_user_name);
            this.hOW = (LinearLayout) view.findViewById(R.id.content_user_and_praise);
            this.hOX = (TextView) view.findViewById(R.id.view_author_tip);
            this.hOY = (TextView) view.findViewById(R.id.view_post_time);
            this.hPk = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.hPb = (TextView) view.findViewById(R.id.view_location);
            this.hPc = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.hPc.setAgreeAnimationResource(R.raw.agree);
            this.hPc.setDisagreeAnimationResource(R.raw.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bXQ = 5;
            dVar.bXV = 8;
            dVar.bXU = 2;
            this.hPc.setStatisticData(dVar);
            this.hPc.setLayoutParams(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds112), -com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds17), com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds7), -com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), -com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds13));
            this.hPd = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.hPl = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.hPl.setHasPendantStyle();
            if (this.hPl.getHeadView() != null) {
                this.hPl.getHeadView().setIsRound(true);
                this.hPl.getHeadView().setDrawBorder(false);
            }
            this.hPm = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.hPn = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.hPe = (TbRichTextView) view.findViewById(R.id.richText);
            this.hPg = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.hPh = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.hPh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.hPh.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.hPh.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.hPi = (TextView) view.findViewById(R.id.pb_post_reply);
            this.hPf = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.hPj = (TextView) view.findViewById(R.id.floor_num);
            this.hOZ = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.hPa = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.hPf.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.hPf.setSingleImageRatio(0.75d);
            this.hPf.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hPe.getLayoutStrategy());
            bVar.kM(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hPe.setLayoutStrategy(bVar);
            this.hPe.setTextSize(TbConfig.getContentSize());
            this.hPd.setIsRound(true);
            this.hPe.setDisplayImage(this.hOp, false);
            this.hPe.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.hPo = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.hPp = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.hPq = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.hPr = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.hPs = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.hPt = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.hPu = (LinearLayout) view.findViewById(R.id.all_content);
            this.hPv = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.hPw = (TextView) view.findViewById(R.id.fold_title);
            this.hPx = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void ok(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bXQ = 12;
            dVar.bXV = 9;
            dVar.bXU = 3;
            this.hPc.setStatisticData(dVar);
        }
    }
}
