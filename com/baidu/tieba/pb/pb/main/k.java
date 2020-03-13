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
/* loaded from: classes9.dex */
public class k extends v.a {
    public int Yv;
    public TextView fwO;
    public boolean iEV;
    public View iFQ;
    public TextView iFR;
    public TextView iFS;
    public TextView iFT;
    public TextView iFU;
    public TextView iFV;
    public AgreeView iFW;
    public HeadImageView iFX;
    public TbRichTextView iFY;
    public ConstrainImageGroup iFZ;
    public SubPbLayout iGa;
    public TextView iGb;
    public TextView iGc;
    public TextView iGd;
    public ImageView iGe;
    public HeadPendantView iGf;
    public UserIconBox iGg;
    public UserIconBox iGh;
    public TextView iGi;
    public LinearLayout iGj;
    public TextView iGk;
    public View iGl;
    public TextView iGm;
    public ImageView iGn;
    public LinearLayout iGo;
    public LinearLayout iGp;
    public TextView iGq;
    public ImageView iGr;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public k(TbPageContext tbPageContext, View view, int i) {
        super(view);
        this.mSkinType = 3;
        this.iEV = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.iFQ = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.fwO = (TextView) view.findViewById(R.id.view_user_name);
            this.iFR = (TextView) view.findViewById(R.id.view_author_tip);
            this.iFS = (TextView) view.findViewById(R.id.view_post_time);
            this.iGe = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.iFV = (TextView) view.findViewById(R.id.view_location);
            this.iFW = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.iFW.aHr();
            this.Yv = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cNC = 5;
            dVar.cNI = 8;
            dVar.cNH = 2;
            dVar.cNG = i;
            this.iFW.setStatisticData(dVar);
            this.iFX = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.iGf = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.iGf.setHasPendantStyle();
            if (this.iGf.getHeadView() != null) {
                this.iGf.getHeadView().setIsRound(true);
                this.iGf.getHeadView().setDrawBorder(false);
                this.iGf.getHeadView().setPlaceHolder(1);
            }
            this.iGg = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.iGh = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.iFY = (TbRichTextView) view.findViewById(R.id.richText);
            this.iGa = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.iGb = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.iGb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.iGb.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.iGb.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.iGc = (TextView) view.findViewById(R.id.pb_post_reply);
            this.iFZ = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.iGd = (TextView) view.findViewById(R.id.floor_num);
            this.iFT = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.iFU = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.iFZ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.iFZ.setSingleImageRatio(0.75d);
            this.iFZ.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.iFY.getLayoutStrategy());
            bVar.nr(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iFY.setLayoutStrategy(bVar);
            this.iFY.setTextSize(TbConfig.getContentSize());
            this.iFX.setIsRound(true);
            this.iFX.setGodIconWidth(R.dimen.tbds31);
            this.iFX.setPlaceHolder(1);
            this.iFY.setDisplayImage(this.iEV, false);
            this.iFY.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.iGi = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.iGj = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.iGk = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.iGl = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.iGm = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.iGn = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.iGo = (LinearLayout) view.findViewById(R.id.all_content);
            this.iGp = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.iGq = (TextView) view.findViewById(R.id.fold_title);
            this.iGr = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void pI(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cNC = 12;
            dVar.cNI = 9;
            dVar.cNH = 3;
            dVar.cNG = this.Yv;
            this.iFW.setStatisticData(dVar);
        }
    }
}
