package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.PostDisPraiseView;
import com.baidu.tbadk.core.view.PostPraiseView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes6.dex */
public class j extends q.a {
    public TextView cKl;
    public View fVN;
    public LinearLayout fVO;
    public TextView fVP;
    public TextView fVQ;
    public View fVR;
    public View fVS;
    public TextView fVT;
    public ImageView fVU;
    public PostPraiseView fVV;
    public PostDisPraiseView fVW;
    public HeadImageView fVX;
    public TbRichTextView fVY;
    public ConstrainImageGroup fVZ;
    public boolean fVk;
    public SubPbLayout fWa;
    public TextView fWb;
    public ImageView fWc;
    public HeadPendantView fWd;
    public UserIconBox fWe;
    public UserIconBox fWf;
    public TextView fWg;
    public LinearLayout fWh;
    public TextView fWi;
    public View fWj;
    public TextView fWk;
    public ImageView fWl;
    public LinearLayout fWm;
    public LinearLayout fWn;
    public TextView fWo;
    public ImageView fWp;
    public com.baidu.tbadk.core.view.a fWq;
    public View mBottomLine;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fVk = true;
        if (tbPageContext != null && view != null) {
            this.fVN = view;
            this.mTopLine = view.findViewById(e.g.top_divider_line);
            this.cKl = (TextView) view.findViewById(e.g.view_user_name);
            this.fVO = (LinearLayout) view.findViewById(e.g.content_user_and_praise);
            this.fVP = (TextView) view.findViewById(e.g.view_author_tip);
            this.fVQ = (TextView) view.findViewById(e.g.view_post_time);
            this.fWc = (ImageView) view.findViewById(e.g.icon_forum_level);
            this.fVT = (TextView) view.findViewById(e.g.view_location);
            this.fVU = (ImageView) view.findViewById(e.g.image_more_tip);
            this.fVV = (PostPraiseView) view.findViewById(e.g.view_floor_new_praise);
            this.fVW = (PostDisPraiseView) view.findViewById(e.g.view_floor_new_dispraise);
            this.fWq = new com.baidu.tbadk.core.view.a(this.fVV, this.fVW, this.fVU);
            this.fVX = (HeadImageView) view.findViewById(e.g.normal_user_photo);
            this.fWd = (HeadPendantView) view.findViewById(e.g.pendant_user_photo);
            this.fWd.setHasPendantStyle();
            if (this.fWd.getHeadView() != null) {
                this.fWd.getHeadView().setIsRound(true);
                this.fWd.getHeadView().setDrawBorder(false);
            }
            this.fWe = (UserIconBox) view.findViewById(e.g.show_icon_vip);
            this.fWf = (UserIconBox) view.findViewById(e.g.show_icon_yinji);
            this.fVY = (TbRichTextView) view.findViewById(e.g.richText);
            this.fWa = (SubPbLayout) view.findViewById(e.g.pb_post_footer_layout);
            this.fVZ = (ConstrainImageGroup) view.findViewById(e.g.floor_images_content);
            this.mBottomLine = view.findViewById(e.g.pb_bottom_line);
            this.fWb = (TextView) view.findViewById(e.g.floor_num);
            this.fVR = view.findViewById(e.g.line_between_floor_and_time);
            this.fVS = view.findViewById(e.g.line_between_time_and_locate);
            this.fVZ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16));
            this.fVZ.setSingleImageRatio(0.75d);
            this.fVZ.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fVY.setLayoutStrategy(new b(this.fVY.getLayoutStrategy()));
            this.fVY.setTextSize(TbConfig.getContentSize());
            this.fVX.setIsRound(true);
            this.fVY.setDisplayImage(this.fVk, false);
            this.fVY.setVoiceViewRes(e.h.voice_play_btn_new);
            this.fWg = (TextView) view.findViewById(e.g.pb_item_tail_content);
            this.fWh = (LinearLayout) view.findViewById(e.g.pb_post_recommend_live_layout);
            this.fWi = (TextView) view.findViewById(e.g.pb_post_recommend_live_prefix_tv);
            this.fWj = view.findViewById(e.g.pb_post_recommend_live_divider);
            this.fWk = (TextView) view.findViewById(e.g.pb_post_recommend_live_title);
            this.fWl = (ImageView) view.findViewById(e.g.pb_post_recommend_live_arrow);
            this.fWm = (LinearLayout) view.findViewById(e.g.all_content);
            this.fWn = (LinearLayout) view.findViewById(e.g.fold_op_area);
            this.fWo = (TextView) view.findViewById(e.g.fold_title);
            this.fWp = (ImageView) view.findViewById(e.g.fold_btn);
            this.fWq.EF();
            this.fWq.h(tbPageContext.getUniqueId());
        }
    }

    public void by(boolean z) {
        if (this.fWq != null) {
            this.fWq.by(z);
            this.fWq.EF();
        }
    }
}
