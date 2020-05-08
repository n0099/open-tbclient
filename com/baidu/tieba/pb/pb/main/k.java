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
    public int aqV;
    public TextView gbZ;
    public boolean jqH;
    public View jrC;
    public TextView jrD;
    public TextView jrE;
    public TextView jrF;
    public TextView jrG;
    public TextView jrH;
    public AgreeView jrI;
    public HeadImageView jrJ;
    public TbRichTextView jrK;
    public ConstrainImageGroup jrL;
    public SubPbLayout jrM;
    public TextView jrN;
    public TextView jrO;
    public TextView jrP;
    public ImageView jrQ;
    public HeadPendantView jrR;
    public UserIconBox jrS;
    public UserIconBox jrT;
    public TextView jrU;
    public LinearLayout jrV;
    public TextView jrW;
    public View jrX;
    public TextView jrY;
    public ImageView jrZ;
    public LinearLayout jsa;
    public LinearLayout jsb;
    public TextView jsc;
    public ImageView jsd;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public k(TbPageContext tbPageContext, View view, int i) {
        super(view);
        this.mSkinType = 3;
        this.jqH = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.jrC = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.gbZ = (TextView) view.findViewById(R.id.view_user_name);
            this.jrD = (TextView) view.findViewById(R.id.view_author_tip);
            this.jrE = (TextView) view.findViewById(R.id.view_post_time);
            this.jrQ = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.jrH = (TextView) view.findViewById(R.id.view_location);
            this.jrI = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.jrI.aPK();
            this.aqV = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.dmX = 5;
            dVar.dnd = 8;
            dVar.dnc = 2;
            dVar.dnb = i;
            this.jrI.setStatisticData(dVar);
            this.jrJ = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.jrR = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.jrR.setHasPendantStyle();
            if (this.jrR.getHeadView() != null) {
                this.jrR.getHeadView().setIsRound(true);
                this.jrR.getHeadView().setDrawBorder(false);
                this.jrR.getHeadView().setPlaceHolder(1);
            }
            this.jrS = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.jrT = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.jrK = (TbRichTextView) view.findViewById(R.id.richText);
            this.jrM = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.jrN = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.jrN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.jrN.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.jrN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.jrO = (TextView) view.findViewById(R.id.pb_post_reply);
            this.jrL = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.jrP = (TextView) view.findViewById(R.id.floor_num);
            this.jrF = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.jrG = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.jrL.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.jrL.setSingleImageRatio(0.75d);
            this.jrL.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.jrK.getLayoutStrategy());
            bVar.nF(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.jrK.setLayoutStrategy(bVar);
            this.jrK.setTextSize(TbConfig.getContentSize());
            this.jrJ.setIsRound(true);
            this.jrJ.setGodIconWidth(R.dimen.tbds31);
            this.jrJ.setPlaceHolder(1);
            this.jrK.setDisplayImage(this.jqH, false);
            this.jrK.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.jrU = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.jrV = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.jrW = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.jrX = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.jrY = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.jrZ = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.jsa = (LinearLayout) view.findViewById(R.id.all_content);
            this.jsb = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.jsc = (TextView) view.findViewById(R.id.fold_title);
            this.jsd = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void qS(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.dmX = 12;
            dVar.dnd = 9;
            dVar.dnc = 3;
            dVar.dnb = this.aqV;
            this.jrI.setStatisticData(dVar);
        }
    }
}
