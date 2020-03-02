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
    public TextView fwB;
    public boolean iEJ;
    public View iFE;
    public TextView iFF;
    public TextView iFG;
    public TextView iFH;
    public TextView iFI;
    public TextView iFJ;
    public AgreeView iFK;
    public HeadImageView iFL;
    public TbRichTextView iFM;
    public ConstrainImageGroup iFN;
    public SubPbLayout iFO;
    public TextView iFP;
    public TextView iFQ;
    public TextView iFR;
    public ImageView iFS;
    public HeadPendantView iFT;
    public UserIconBox iFU;
    public UserIconBox iFV;
    public TextView iFW;
    public LinearLayout iFX;
    public TextView iFY;
    public View iFZ;
    public TextView iGa;
    public ImageView iGb;
    public LinearLayout iGc;
    public LinearLayout iGd;
    public TextView iGe;
    public ImageView iGf;
    public View mBottomLine;
    public int mPosition;
    public int mSkinType;
    public View mTopLine;

    public k(TbPageContext tbPageContext, View view, int i) {
        super(view);
        this.mSkinType = 3;
        this.iEJ = true;
        this.mPosition = -1;
        if (tbPageContext != null && view != null) {
            this.iFE = view;
            this.mTopLine = view.findViewById(R.id.top_divider_line);
            this.fwB = (TextView) view.findViewById(R.id.view_user_name);
            this.iFF = (TextView) view.findViewById(R.id.view_author_tip);
            this.iFG = (TextView) view.findViewById(R.id.view_post_time);
            this.iFS = (ImageView) view.findViewById(R.id.icon_forum_level);
            this.iFJ = (TextView) view.findViewById(R.id.view_location);
            this.iFK = (AgreeView) view.findViewById(R.id.pb_floor_praise_view);
            this.iFK.aHq();
            this.Yv = i;
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cNB = 5;
            dVar.cNH = 8;
            dVar.cNG = 2;
            dVar.cNF = i;
            this.iFK.setStatisticData(dVar);
            this.iFL = (HeadImageView) view.findViewById(R.id.normal_user_photo);
            this.iFT = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
            this.iFT.setHasPendantStyle();
            if (this.iFT.getHeadView() != null) {
                this.iFT.getHeadView().setIsRound(true);
                this.iFT.getHeadView().setDrawBorder(false);
                this.iFT.getHeadView().setPlaceHolder(1);
            }
            this.iFU = (UserIconBox) view.findViewById(R.id.show_icon_vip);
            this.iFV = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
            this.iFM = (TbRichTextView) view.findViewById(R.id.richText);
            this.iFO = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
            this.iFP = (TextView) view.findViewById(R.id.pb_post_reply_count);
            this.iFP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            this.iFP.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.iFP.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            this.iFQ = (TextView) view.findViewById(R.id.pb_post_reply);
            this.iFN = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
            this.mBottomLine = view.findViewById(R.id.pb_bottom_line);
            this.iFR = (TextView) view.findViewById(R.id.floor_num);
            this.iFH = (TextView) view.findViewById(R.id.point_between_floor_and_time);
            this.iFI = (TextView) view.findViewById(R.id.point_between_time_and_locate);
            this.iFN.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
            this.iFN.setSingleImageRatio(0.75d);
            this.iFN.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
            b bVar = new b(this.iFM.getLayoutStrategy());
            bVar.nr(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
            bVar.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iFM.setLayoutStrategy(bVar);
            this.iFM.setTextSize(TbConfig.getContentSize());
            this.iFL.setIsRound(true);
            this.iFL.setGodIconWidth(R.dimen.tbds31);
            this.iFL.setPlaceHolder(1);
            this.iFM.setDisplayImage(this.iEJ, false);
            this.iFM.setVoiceViewRes(R.layout.voice_play_btn_new);
            this.iFW = (TextView) view.findViewById(R.id.pb_item_tail_content);
            this.iFX = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
            this.iFY = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
            this.iFZ = view.findViewById(R.id.pb_post_recommend_live_divider);
            this.iGa = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
            this.iGb = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
            this.iGc = (LinearLayout) view.findViewById(R.id.all_content);
            this.iGd = (LinearLayout) view.findViewById(R.id.fold_op_area);
            this.iGe = (TextView) view.findViewById(R.id.fold_title);
            this.iGf = (ImageView) view.findViewById(R.id.pic_comment_god);
        }
    }

    public void pI(boolean z) {
        if (z) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cNB = 12;
            dVar.cNH = 9;
            dVar.cNG = 3;
            dVar.cNF = this.Yv;
            this.iFK.setStatisticData(dVar);
        }
    }
}
