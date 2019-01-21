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
    public TextView cLX;
    public View fZD;
    public LinearLayout fZE;
    public TextView fZF;
    public TextView fZG;
    public View fZH;
    public View fZI;
    public TextView fZJ;
    public ImageView fZK;
    public PostPraiseView fZL;
    public PostDisPraiseView fZM;
    public HeadImageView fZN;
    public TbRichTextView fZO;
    public ConstrainImageGroup fZP;
    public SubPbLayout fZQ;
    public TextView fZR;
    public ImageView fZS;
    public HeadPendantView fZT;
    public UserIconBox fZU;
    public UserIconBox fZV;
    public TextView fZW;
    public LinearLayout fZX;
    public TextView fZY;
    public View fZZ;
    public boolean fZa;
    public TextView gaa;
    public ImageView gab;
    public LinearLayout gac;
    public LinearLayout gad;
    public TextView gae;
    public ImageView gaf;
    public com.baidu.tbadk.core.view.a gag;
    public View mBottomLine;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fZa = true;
        if (tbPageContext != null && view != null) {
            this.fZD = view;
            this.mTopLine = view.findViewById(e.g.top_divider_line);
            this.cLX = (TextView) view.findViewById(e.g.view_user_name);
            this.fZE = (LinearLayout) view.findViewById(e.g.content_user_and_praise);
            this.fZF = (TextView) view.findViewById(e.g.view_author_tip);
            this.fZG = (TextView) view.findViewById(e.g.view_post_time);
            this.fZS = (ImageView) view.findViewById(e.g.icon_forum_level);
            this.fZJ = (TextView) view.findViewById(e.g.view_location);
            this.fZK = (ImageView) view.findViewById(e.g.image_more_tip);
            this.fZL = (PostPraiseView) view.findViewById(e.g.view_floor_new_praise);
            this.fZM = (PostDisPraiseView) view.findViewById(e.g.view_floor_new_dispraise);
            this.gag = new com.baidu.tbadk.core.view.a(this.fZL, this.fZM, this.fZK);
            this.fZN = (HeadImageView) view.findViewById(e.g.normal_user_photo);
            this.fZT = (HeadPendantView) view.findViewById(e.g.pendant_user_photo);
            this.fZT.setHasPendantStyle();
            if (this.fZT.getHeadView() != null) {
                this.fZT.getHeadView().setIsRound(true);
                this.fZT.getHeadView().setDrawBorder(false);
            }
            this.fZU = (UserIconBox) view.findViewById(e.g.show_icon_vip);
            this.fZV = (UserIconBox) view.findViewById(e.g.show_icon_yinji);
            this.fZO = (TbRichTextView) view.findViewById(e.g.richText);
            this.fZQ = (SubPbLayout) view.findViewById(e.g.pb_post_footer_layout);
            this.fZP = (ConstrainImageGroup) view.findViewById(e.g.floor_images_content);
            this.mBottomLine = view.findViewById(e.g.pb_bottom_line);
            this.fZR = (TextView) view.findViewById(e.g.floor_num);
            this.fZH = view.findViewById(e.g.line_between_floor_and_time);
            this.fZI = view.findViewById(e.g.line_between_time_and_locate);
            this.fZP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16));
            this.fZP.setSingleImageRatio(0.75d);
            this.fZP.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fZO.setLayoutStrategy(new b(this.fZO.getLayoutStrategy()));
            this.fZO.setTextSize(TbConfig.getContentSize());
            this.fZN.setIsRound(true);
            this.fZO.setDisplayImage(this.fZa, false);
            this.fZO.setVoiceViewRes(e.h.voice_play_btn_new);
            this.fZW = (TextView) view.findViewById(e.g.pb_item_tail_content);
            this.fZX = (LinearLayout) view.findViewById(e.g.pb_post_recommend_live_layout);
            this.fZY = (TextView) view.findViewById(e.g.pb_post_recommend_live_prefix_tv);
            this.fZZ = view.findViewById(e.g.pb_post_recommend_live_divider);
            this.gaa = (TextView) view.findViewById(e.g.pb_post_recommend_live_title);
            this.gab = (ImageView) view.findViewById(e.g.pb_post_recommend_live_arrow);
            this.gac = (LinearLayout) view.findViewById(e.g.all_content);
            this.gad = (LinearLayout) view.findViewById(e.g.fold_op_area);
            this.gae = (TextView) view.findViewById(e.g.fold_title);
            this.gaf = (ImageView) view.findViewById(e.g.fold_btn);
            this.gag.ES();
            this.gag.h(tbPageContext.getUniqueId());
        }
    }

    public void bz(boolean z) {
        if (this.gag != null) {
            this.gag.bz(z);
            this.gag.ES();
        }
    }
}
