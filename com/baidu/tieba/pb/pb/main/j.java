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
    public TextView cLl;
    public View fYF;
    public LinearLayout fYG;
    public TextView fYH;
    public TextView fYI;
    public View fYJ;
    public View fYK;
    public TextView fYL;
    public ImageView fYM;
    public PostPraiseView fYN;
    public PostDisPraiseView fYO;
    public HeadImageView fYP;
    public TbRichTextView fYQ;
    public ConstrainImageGroup fYR;
    public SubPbLayout fYS;
    public TextView fYT;
    public ImageView fYU;
    public HeadPendantView fYV;
    public UserIconBox fYW;
    public UserIconBox fYX;
    public TextView fYY;
    public LinearLayout fYZ;
    public boolean fYc;
    public TextView fZa;
    public View fZb;
    public TextView fZc;
    public ImageView fZd;
    public LinearLayout fZe;
    public LinearLayout fZf;
    public TextView fZg;
    public ImageView fZh;
    public com.baidu.tbadk.core.view.a fZi;
    public View mBottomLine;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fYc = true;
        if (tbPageContext != null && view != null) {
            this.fYF = view;
            this.mTopLine = view.findViewById(e.g.top_divider_line);
            this.cLl = (TextView) view.findViewById(e.g.view_user_name);
            this.fYG = (LinearLayout) view.findViewById(e.g.content_user_and_praise);
            this.fYH = (TextView) view.findViewById(e.g.view_author_tip);
            this.fYI = (TextView) view.findViewById(e.g.view_post_time);
            this.fYU = (ImageView) view.findViewById(e.g.icon_forum_level);
            this.fYL = (TextView) view.findViewById(e.g.view_location);
            this.fYM = (ImageView) view.findViewById(e.g.image_more_tip);
            this.fYN = (PostPraiseView) view.findViewById(e.g.view_floor_new_praise);
            this.fYO = (PostDisPraiseView) view.findViewById(e.g.view_floor_new_dispraise);
            this.fZi = new com.baidu.tbadk.core.view.a(this.fYN, this.fYO, this.fYM);
            this.fYP = (HeadImageView) view.findViewById(e.g.normal_user_photo);
            this.fYV = (HeadPendantView) view.findViewById(e.g.pendant_user_photo);
            this.fYV.setHasPendantStyle();
            if (this.fYV.getHeadView() != null) {
                this.fYV.getHeadView().setIsRound(true);
                this.fYV.getHeadView().setDrawBorder(false);
            }
            this.fYW = (UserIconBox) view.findViewById(e.g.show_icon_vip);
            this.fYX = (UserIconBox) view.findViewById(e.g.show_icon_yinji);
            this.fYQ = (TbRichTextView) view.findViewById(e.g.richText);
            this.fYS = (SubPbLayout) view.findViewById(e.g.pb_post_footer_layout);
            this.fYR = (ConstrainImageGroup) view.findViewById(e.g.floor_images_content);
            this.mBottomLine = view.findViewById(e.g.pb_bottom_line);
            this.fYT = (TextView) view.findViewById(e.g.floor_num);
            this.fYJ = view.findViewById(e.g.line_between_floor_and_time);
            this.fYK = view.findViewById(e.g.line_between_time_and_locate);
            this.fYR.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16));
            this.fYR.setSingleImageRatio(0.75d);
            this.fYR.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fYQ.setLayoutStrategy(new b(this.fYQ.getLayoutStrategy()));
            this.fYQ.setTextSize(TbConfig.getContentSize());
            this.fYP.setIsRound(true);
            this.fYQ.setDisplayImage(this.fYc, false);
            this.fYQ.setVoiceViewRes(e.h.voice_play_btn_new);
            this.fYY = (TextView) view.findViewById(e.g.pb_item_tail_content);
            this.fYZ = (LinearLayout) view.findViewById(e.g.pb_post_recommend_live_layout);
            this.fZa = (TextView) view.findViewById(e.g.pb_post_recommend_live_prefix_tv);
            this.fZb = view.findViewById(e.g.pb_post_recommend_live_divider);
            this.fZc = (TextView) view.findViewById(e.g.pb_post_recommend_live_title);
            this.fZd = (ImageView) view.findViewById(e.g.pb_post_recommend_live_arrow);
            this.fZe = (LinearLayout) view.findViewById(e.g.all_content);
            this.fZf = (LinearLayout) view.findViewById(e.g.fold_op_area);
            this.fZg = (TextView) view.findViewById(e.g.fold_title);
            this.fZh = (ImageView) view.findViewById(e.g.fold_btn);
            this.fZi.EF();
            this.fZi.h(tbPageContext.getUniqueId());
        }
    }

    public void by(boolean z) {
        if (this.fZi != null) {
            this.fZi.by(z);
            this.fZi.EF();
        }
    }
}
