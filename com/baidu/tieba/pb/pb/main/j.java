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
    public TextView ezp;
    public boolean hNy;
    public View hOA;
    public TextView hOB;
    public ImageView hOC;
    public LinearLayout hOD;
    public LinearLayout hOE;
    public TextView hOF;
    public ImageView hOG;
    public View hOe;
    public LinearLayout hOf;
    public TextView hOg;
    public TextView hOh;
    public TextView hOi;
    public TextView hOj;
    public TextView hOk;
    public AgreeView hOl;
    public HeadImageView hOm;
    public TbRichTextView hOn;
    public ConstrainImageGroup hOo;
    public SubPbLayout hOp;
    public TextView hOq;
    public TextView hOr;
    public TextView hOs;
    public ImageView hOt;
    public HeadPendantView hOu;
    public UserIconBox hOv;
    public UserIconBox hOw;
    public TextView hOx;
    public LinearLayout hOy;
    public TextView hOz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hNy = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hOe = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.ezp = (TextView) view.findViewById(R.id.view_user_name);
            this.hOf = (LinearLayout) view.findViewById(R.id.content_user_and_praise);
            this.hOg = (TextView) view.findViewById(R.id.view_author_tip);
            this.hOh = (TextView) view.findViewById(R.id.view_post_time);
            this.hOt = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.hOk = (TextView) view.findViewById(R.id.view_location);
            this.hOl = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.hOl.setAgreeAnimationResource(R.raw.agree);
            this.hOl.setDisagreeAnimationResource(R.raw.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bWZ = 5;
            dVar.bXe = 8;
            dVar.bXd = 2;
            this.hOl.setStatisticData(dVar);
            this.hOl.setLayoutParams(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds112), -com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds17), com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds7), -com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), -com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds13));
            this.hOm = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.hOu = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.hOu.setHasPendantStyle();
            if (this.hOu.getHeadView() != null) {
                this.hOu.getHeadView().setIsRound(true);
                this.hOu.getHeadView().setDrawBorder(false);
            }
            this.hOv = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.hOw = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.hOn = (TbRichTextView) view.findViewById(R.id.richText);
            this.hOp = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.hOq = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.hOq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.hOq.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.hOq.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.hOr = (TextView) view.findViewById(R.id.pb_post_reply);
            this.hOo = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.hOs = (TextView) view.findViewById(R.id.floor_num);
            this.hOi = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.hOj = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.hOo.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.hOo.setSingleImageRatio(0.75d);
            this.hOo.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hOn.getLayoutStrategy());
            bVar.kL(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hOn.setLayoutStrategy(bVar);
            this.hOn.setTextSize(TbConfig.getContentSize());
            this.hOm.setIsRound(true);
            this.hOn.setDisplayImage(this.hNy, false);
            this.hOn.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.hOx = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.hOy = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.hOz = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.hOA = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.hOB = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.hOC = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.hOD = (LinearLayout) view.findViewById(R.id.all_content);
            this.hOE = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.hOF = (TextView) view.findViewById(R.id.fold_title);
            this.hOG = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void ok(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bWZ = 12;
            dVar.bXe = 9;
            dVar.bXd = 3;
            this.hOl.setStatisticData(dVar);
        }
    }
}
