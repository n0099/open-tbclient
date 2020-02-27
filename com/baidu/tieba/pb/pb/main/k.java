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
    public TextView fwA;
    public boolean iEH;
    public View iFC;
    public TextView iFD;
    public TextView iFE;
    public TextView iFF;
    public TextView iFG;
    public TextView iFH;
    public AgreeView iFI;
    public HeadImageView iFJ;
    public TbRichTextView iFK;
    public ConstrainImageGroup iFL;
    public SubPbLayout iFM;
    public TextView iFN;
    public TextView iFO;
    public TextView iFP;
    public ImageView iFQ;
    public HeadPendantView iFR;
    public UserIconBox iFS;
    public UserIconBox iFT;
    public TextView iFU;
    public LinearLayout iFV;
    public TextView iFW;
    public View iFX;
    public TextView iFY;
    public ImageView iFZ;
    public LinearLayout iGa;
    public LinearLayout iGb;
    public TextView iGc;
    public ImageView iGd;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public k(TbPageContext tbPageContext, View view, int i) {
        super(view);
        this.mSkinType = 3;
        this.iEH = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.iFC = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.fwA = (TextView) view.findViewById(R.id.view_user_name);
            this.iFD = (TextView) view.findViewById(R.id.view_author_tip);
            this.iFE = (TextView) view.findViewById(R.id.view_post_time);
            this.iFQ = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.iFH = (TextView) view.findViewById(R.id.view_location);
            this.iFI = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.iFI.aHo();
            this.Yv = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cNA = 5;
            dVar.cNG = 8;
            dVar.cNF = 2;
            dVar.cNE = i;
            this.iFI.setStatisticData(dVar);
            this.iFJ = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.iFR = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.iFR.setHasPendantStyle();
            if (this.iFR.getHeadView() != null) {
                this.iFR.getHeadView().setIsRound(true);
                this.iFR.getHeadView().setDrawBorder(false);
                this.iFR.getHeadView().setPlaceHolder(1);
            }
            this.iFS = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.iFT = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.iFK = (TbRichTextView) view.findViewById(R.id.richText);
            this.iFM = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.iFN = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.iFN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.iFN.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.iFN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.iFO = (TextView) view.findViewById(R.id.pb_post_reply);
            this.iFL = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.iFP = (TextView) view.findViewById(R.id.floor_num);
            this.iFF = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.iFG = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.iFL.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.iFL.setSingleImageRatio(0.75d);
            this.iFL.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.iFK.getLayoutStrategy());
            bVar.nr(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iFK.setLayoutStrategy(bVar);
            this.iFK.setTextSize(TbConfig.getContentSize());
            this.iFJ.setIsRound(true);
            this.iFJ.setGodIconWidth(R.dimen.tbds31);
            this.iFJ.setPlaceHolder(1);
            this.iFK.setDisplayImage(this.iEH, false);
            this.iFK.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.iFU = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.iFV = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.iFW = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.iFX = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.iFY = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.iFZ = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.iGa = (LinearLayout) view.findViewById(R.id.all_content);
            this.iGb = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.iGc = (TextView) view.findViewById(R.id.fold_title);
            this.iGd = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void pI(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cNA = 12;
            dVar.cNG = 9;
            dVar.cNF = 3;
            dVar.cNE = this.Yv;
            this.iFI.setStatisticData(dVar);
        }
    }
}
