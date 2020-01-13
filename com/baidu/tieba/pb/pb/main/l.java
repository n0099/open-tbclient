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
/* loaded from: classes7.dex */
public class l extends v.a {
    public int WJ;
    public TextView ftZ;
    public View iDY;
    public TextView iDZ;
    public boolean iDa;
    public TextView iEa;
    public TextView iEb;
    public TextView iEc;
    public TextView iEd;
    public AgreeView iEe;
    public HeadImageView iEf;
    public TbRichTextView iEg;
    public ConstrainImageGroup iEh;
    public SubPbLayout iEi;
    public TextView iEj;
    public TextView iEk;
    public TextView iEl;
    public ImageView iEm;
    public HeadPendantView iEn;
    public UserIconBox iEo;
    public UserIconBox iEp;
    public TextView iEq;
    public LinearLayout iEr;
    public TextView iEs;
    public View iEt;
    public TextView iEu;
    public ImageView iEv;
    public LinearLayout iEw;
    public LinearLayout iEx;
    public TextView iEy;
    public ImageView iEz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public l(TbPageContext tbPageContext, View view, int i) {
        super(view);
        this.mSkinType = 3;
        this.iDa = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.iDY = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.ftZ = (TextView) view.findViewById(R.id.view_user_name);
            this.iDZ = (TextView) view.findViewById(R.id.view_author_tip);
            this.iEa = (TextView) view.findViewById(R.id.view_post_time);
            this.iEm = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.iEd = (TextView) view.findViewById(R.id.view_location);
            this.iEe = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.iEe.aFc();
            this.WJ = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cJx = 5;
            dVar.cJD = 8;
            dVar.cJC = 2;
            dVar.cJB = i;
            this.iEe.setStatisticData(dVar);
            this.iEf = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.iEn = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.iEn.setHasPendantStyle();
            if (this.iEn.getHeadView() != null) {
                this.iEn.getHeadView().setIsRound(true);
                this.iEn.getHeadView().setDrawBorder(false);
                this.iEn.getHeadView().setPlaceHolder(1);
            }
            this.iEo = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.iEp = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.iEg = (TbRichTextView) view.findViewById(R.id.richText);
            this.iEi = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.iEj = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.iEj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.iEj.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.iEj.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.iEk = (TextView) view.findViewById(R.id.pb_post_reply);
            this.iEh = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.iEl = (TextView) view.findViewById(R.id.floor_num);
            this.iEb = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.iEc = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.iEh.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.iEh.setSingleImageRatio(0.75d);
            this.iEh.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.iEg.getLayoutStrategy());
            bVar.na(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iEg.setLayoutStrategy(bVar);
            this.iEg.setTextSize(TbConfig.getContentSize());
            this.iEf.setIsRound(true);
            this.iEf.setGodIconWidth(R.dimen.tbds31);
            this.iEf.setPlaceHolder(1);
            this.iEg.setDisplayImage(this.iDa, false);
            this.iEg.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.iEq = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.iEr = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.iEs = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.iEt = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.iEu = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.iEv = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.iEw = (LinearLayout) view.findViewById(R.id.all_content);
            this.iEx = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.iEy = (TextView) view.findViewById(R.id.fold_title);
            this.iEz = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void pF(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cJx = 12;
            dVar.cJD = 9;
            dVar.cJC = 3;
            dVar.cJB = this.WJ;
            this.iEe.setStatisticData(dVar);
        }
    }
}
