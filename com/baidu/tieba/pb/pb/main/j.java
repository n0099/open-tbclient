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
    public TextView cIi;
    public View fOX;
    public LinearLayout fOY;
    public TextView fOZ;
    public boolean fOu;
    public com.baidu.tbadk.core.view.a fPA;
    public TextView fPa;
    public View fPb;
    public View fPc;
    public TextView fPd;
    public ImageView fPe;
    public PostPraiseView fPf;
    public PostDisPraiseView fPg;
    public HeadImageView fPh;
    public TbRichTextView fPi;
    public ConstrainImageGroup fPj;
    public SubPbLayout fPk;
    public TextView fPl;
    public ImageView fPm;
    public HeadPendantView fPn;
    public UserIconBox fPo;
    public UserIconBox fPp;
    public TextView fPq;
    public LinearLayout fPr;
    public TextView fPs;
    public View fPt;
    public TextView fPu;
    public ImageView fPv;
    public LinearLayout fPw;
    public LinearLayout fPx;
    public TextView fPy;
    public ImageView fPz;
    public View mBottomLine;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fOu = true;
        if (tbPageContext != null && view != null) {
            this.fOX = view;
            this.mTopLine = view.findViewById(e.g.top_divider_line);
            this.cIi = (TextView) view.findViewById(e.g.view_user_name);
            this.fOY = (LinearLayout) view.findViewById(e.g.content_user_and_praise);
            this.fOZ = (TextView) view.findViewById(e.g.view_author_tip);
            this.fPa = (TextView) view.findViewById(e.g.view_post_time);
            this.fPm = (ImageView) view.findViewById(e.g.icon_forum_level);
            this.fPd = (TextView) view.findViewById(e.g.view_location);
            this.fPe = (ImageView) view.findViewById(e.g.image_more_tip);
            this.fPf = (PostPraiseView) view.findViewById(e.g.view_floor_new_praise);
            this.fPg = (PostDisPraiseView) view.findViewById(e.g.view_floor_new_dispraise);
            this.fPA = new com.baidu.tbadk.core.view.a(this.fPf, this.fPg, this.fPe);
            this.fPh = (HeadImageView) view.findViewById(e.g.normal_user_photo);
            this.fPn = (HeadPendantView) view.findViewById(e.g.pendant_user_photo);
            this.fPn.setHasPendantStyle();
            if (this.fPn.getHeadView() != null) {
                this.fPn.getHeadView().setIsRound(true);
                this.fPn.getHeadView().setDrawBorder(false);
            }
            this.fPo = (UserIconBox) view.findViewById(e.g.show_icon_vip);
            this.fPp = (UserIconBox) view.findViewById(e.g.show_icon_yinji);
            this.fPi = (TbRichTextView) view.findViewById(e.g.richText);
            this.fPk = (SubPbLayout) view.findViewById(e.g.pb_post_footer_layout);
            this.fPj = (ConstrainImageGroup) view.findViewById(e.g.floor_images_content);
            this.mBottomLine = view.findViewById(e.g.pb_bottom_line);
            this.fPl = (TextView) view.findViewById(e.g.floor_num);
            this.fPb = view.findViewById(e.g.line_between_floor_and_time);
            this.fPc = view.findViewById(e.g.line_between_time_and_locate);
            this.fPj.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds16));
            this.fPj.setSingleImageRatio(0.75d);
            this.fPj.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fPi.setLayoutStrategy(new b(this.fPi.getLayoutStrategy()));
            this.fPi.setTextSize(TbConfig.getContentSize());
            this.fPh.setIsRound(true);
            this.fPi.setDisplayImage(this.fOu, false);
            this.fPi.setVoiceViewRes(e.h.voice_play_btn_new);
            this.fPq = (TextView) view.findViewById(e.g.pb_item_tail_content);
            this.fPr = (LinearLayout) view.findViewById(e.g.pb_post_recommend_live_layout);
            this.fPs = (TextView) view.findViewById(e.g.pb_post_recommend_live_prefix_tv);
            this.fPt = view.findViewById(e.g.pb_post_recommend_live_divider);
            this.fPu = (TextView) view.findViewById(e.g.pb_post_recommend_live_title);
            this.fPv = (ImageView) view.findViewById(e.g.pb_post_recommend_live_arrow);
            this.fPw = (LinearLayout) view.findViewById(e.g.all_content);
            this.fPx = (LinearLayout) view.findViewById(e.g.fold_op_area);
            this.fPy = (TextView) view.findViewById(e.g.fold_title);
            this.fPz = (ImageView) view.findViewById(e.g.fold_btn);
            this.fPA.DB();
            this.fPA.h(tbPageContext.getUniqueId());
        }
    }

    public void bx(boolean z) {
        if (this.fPA != null) {
            this.fPA.bx(z);
            this.fPA.DB();
        }
    }
}
