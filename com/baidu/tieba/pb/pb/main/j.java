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
    public TextView eog;
    public boolean hNN;
    public AgreeView hOA;
    public HeadImageView hOB;
    public TbRichTextView hOC;
    public ConstrainImageGroup hOD;
    public SubPbLayout hOE;
    public TextView hOF;
    public TextView hOG;
    public TextView hOH;
    public ImageView hOI;
    public HeadPendantView hOJ;
    public UserIconBox hOK;
    public UserIconBox hOL;
    public TextView hOM;
    public LinearLayout hON;
    public TextView hOO;
    public View hOP;
    public TextView hOQ;
    public ImageView hOR;
    public LinearLayout hOS;
    public LinearLayout hOT;
    public TextView hOU;
    public ImageView hOV;
    public View hOt;
    public LinearLayout hOu;
    public TextView hOv;
    public TextView hOw;
    public TextView hOx;
    public TextView hOy;
    public TextView hOz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hNN = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.hOt = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.eog = (TextView) view.findViewById(R.id.view_user_name);
            this.hOu = (LinearLayout) view.findViewById(R.id.content_user_and_praise);
            this.hOv = (TextView) view.findViewById(R.id.view_author_tip);
            this.hOw = (TextView) view.findViewById(R.id.view_post_time);
            this.hOI = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.hOz = (TextView) view.findViewById(R.id.view_location);
            this.hOA = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.hOA.setAgreeAnimationResource(R.raw.agree);
            this.hOA.setDisagreeAnimationResource(R.raw.disagree);
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bFA = 5;
            dVar.bFF = 8;
            dVar.bFE = 2;
            this.hOA.setStatisticData(dVar);
            this.hOA.setLayoutParams(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds112), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds17), com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds7), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds3), -com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds13));
            this.hOB = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.hOJ = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.hOJ.setHasPendantStyle();
            if (this.hOJ.getHeadView() != null) {
                this.hOJ.getHeadView().setIsRound(true);
                this.hOJ.getHeadView().setDrawBorder(false);
            }
            this.hOK = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.hOL = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.hOC = (TbRichTextView) view.findViewById(R.id.richText);
            this.hOE = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.hOF = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.hOF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.hOF.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.hOF.setTextSize(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.hOG = (TextView) view.findViewById(R.id.pb_post_reply);
            this.hOD = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.hOH = (TextView) view.findViewById(R.id.floor_num);
            this.hOx = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.hOy = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.hOD.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.hOD.setSingleImageRatio(0.75d);
            this.hOD.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.hOC.getLayoutStrategy());
            bVar.lD(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hOC.setLayoutStrategy(bVar);
            this.hOC.setTextSize(TbConfig.getContentSize());
            this.hOB.setIsRound(true);
            this.hOC.setDisplayImage(this.hNN, false);
            this.hOC.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.hOM = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.hON = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.hOO = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.hOP = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.hOQ = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.hOR = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.hOS = (LinearLayout) view.findViewById(R.id.all_content);
            this.hOT = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.hOU = (TextView) view.findViewById(R.id.fold_title);
            this.hOV = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void ox(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bFA = 12;
            dVar.bFF = 9;
            dVar.bFE = 3;
            this.hOA.setStatisticData(dVar);
        }
    }
}
