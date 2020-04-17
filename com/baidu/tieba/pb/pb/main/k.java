package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
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
/* loaded from: classes9.dex */
public class k extends y.a {
    public int aqP;
    public TextView gbU;
    public boolean jqD;
    public TextView jrA;
    public TextView jrB;
    public TextView jrC;
    public TextView jrD;
    public AgreeView jrE;
    public HeadImageView jrF;
    public TbRichTextView jrG;
    public ConstrainImageGroup jrH;
    public SubPbLayout jrI;
    public TextView jrJ;
    public TextView jrK;
    public TextView jrL;
    public ImageView jrM;
    public HeadPendantView jrN;
    public UserIconBox jrO;
    public UserIconBox jrP;
    public TextView jrQ;
    public LinearLayout jrR;
    public TextView jrS;
    public View jrT;
    public TextView jrU;
    public ImageView jrV;
    public LinearLayout jrW;
    public LinearLayout jrX;
    public TextView jrY;
    public ImageView jrZ;
    public View jry;
    public TextView jrz;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public k(TbPageContext tbPageContext, View view, int i) {
        super(view);
        this.mSkinType = 3;
        this.jqD = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.jry = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.gbU = (TextView) view.findViewById(R.id.view_user_name);
            this.jrz = (TextView) view.findViewById(R.id.view_author_tip);
            this.jrA = (TextView) view.findViewById(R.id.view_post_time);
            this.jrM = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.jrD = (TextView) view.findViewById(R.id.view_location);
            this.jrE = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.jrE.aPN();
            this.aqP = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.dmT = 5;
            dVar.dmZ = 8;
            dVar.dmY = 2;
            dVar.dmX = i;
            this.jrE.setStatisticData(dVar);
            this.jrF = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.jrN = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.jrN.setHasPendantStyle();
            if (this.jrN.getHeadView() != null) {
                this.jrN.getHeadView().setIsRound(true);
                this.jrN.getHeadView().setDrawBorder(false);
                this.jrN.getHeadView().setPlaceHolder(1);
            }
            this.jrO = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.jrP = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.jrG = (TbRichTextView) view.findViewById(R.id.richText);
            this.jrI = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.jrJ = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.jrJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.jrJ.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.jrJ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.jrK = (TextView) view.findViewById(R.id.pb_post_reply);
            this.jrH = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.jrL = (TextView) view.findViewById(R.id.floor_num);
            this.jrB = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.jrC = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.jrH.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.jrH.setSingleImageRatio(0.75d);
            this.jrH.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.jrG.getLayoutStrategy());
            bVar.nF(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.jrG.setLayoutStrategy(bVar);
            this.jrG.setTextSize(TbConfig.getContentSize());
            this.jrF.setIsRound(true);
            this.jrF.setGodIconWidth(R.dimen.tbds31);
            this.jrF.setPlaceHolder(1);
            this.jrG.setDisplayImage(this.jqD, false);
            this.jrG.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.jrQ = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.jrR = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.jrS = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.jrT = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.jrU = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.jrV = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.jrW = (LinearLayout) view.findViewById(R.id.all_content);
            this.jrX = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.jrY = (TextView) view.findViewById(R.id.fold_title);
            this.jrZ = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void qS(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.dmT = 12;
            dVar.dmZ = 9;
            dVar.dmY = 3;
            dVar.dmX = this.aqP;
            this.jrE.setStatisticData(dVar);
        }
    }
}
