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
    public TextView cLW;
    public boolean fYZ;
    public View fZC;
    public LinearLayout fZD;
    public TextView fZE;
    public TextView fZF;
    public View fZG;
    public View fZH;
    public TextView fZI;
    public ImageView fZJ;
    public PostPraiseView fZK;
    public PostDisPraiseView fZL;
    public HeadImageView fZM;
    public TbRichTextView fZN;
    public ConstrainImageGroup fZO;
    public SubPbLayout fZP;
    public TextView fZQ;
    public ImageView fZR;
    public HeadPendantView fZS;
    public UserIconBox fZT;
    public UserIconBox fZU;
    public TextView fZV;
    public LinearLayout fZW;
    public TextView fZX;
    public View fZY;
    public TextView fZZ;
    public ImageView gaa;
    public LinearLayout gab;
    public LinearLayout gac;
    public TextView gad;
    public ImageView gae;
    public com.baidu.tbadk.core.view.a gaf;
    public View mBottomLine;
    public int mSkinType;
    public View mTopLine;

    public j(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fYZ = true;
        if (tbPageContext != null && view != null) {
            this.fZC = view;
            this.mTopLine = view.findViewById(e.g.top_divider_line);
            this.cLW = (TextView) view.findViewById(e.g.view_user_name);
            this.fZD = (LinearLayout) view.findViewById(e.g.content_user_and_praise);
            this.fZE = (TextView) view.findViewById(e.g.view_author_tip);
            this.fZF = (TextView) view.findViewById(e.g.view_post_time);
            this.fZR = (ImageView) view.findViewById(e.g.icon_forum_level);
            this.fZI = (TextView) view.findViewById(e.g.view_location);
            this.fZJ = (ImageView) view.findViewById(e.g.image_more_tip);
            this.fZK = (PostPraiseView) view.findViewById(e.g.view_floor_new_praise);
            this.fZL = (PostDisPraiseView) view.findViewById(e.g.view_floor_new_dispraise);
            this.gaf = new com.baidu.tbadk.core.view.a(this.fZK, this.fZL, this.fZJ);
            this.fZM = (HeadImageView) view.findViewById(e.g.normal_user_photo);
            this.fZS = (HeadPendantView) view.findViewById(e.g.pendant_user_photo);
            this.fZS.setHasPendantStyle();
            if (this.fZS.getHeadView() != null) {
                this.fZS.getHeadView().setIsRound(true);
                this.fZS.getHeadView().setDrawBorder(false);
            }
            this.fZT = (UserIconBox) view.findViewById(e.g.show_icon_vip);
            this.fZU = (UserIconBox) view.findViewById(e.g.show_icon_yinji);
            this.fZN = (TbRichTextView) view.findViewById(e.g.richText);
            this.fZP = (SubPbLayout) view.findViewById(e.g.pb_post_footer_layout);
            this.fZO = (ConstrainImageGroup) view.findViewById(e.g.floor_images_content);
            this.mBottomLine = view.findViewById(e.g.pb_bottom_line);
            this.fZQ = (TextView) view.findViewById(e.g.floor_num);
            this.fZG = view.findViewById(e.g.line_between_floor_and_time);
            this.fZH = view.findViewById(e.g.line_between_time_and_locate);
            this.fZO.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16));
            this.fZO.setSingleImageRatio(0.75d);
            this.fZO.setImageProcessor(new com.baidu.tbadk.widget.layout.e(3));
            this.fZN.setLayoutStrategy(new b(this.fZN.getLayoutStrategy()));
            this.fZN.setTextSize(TbConfig.getContentSize());
            this.fZM.setIsRound(true);
            this.fZN.setDisplayImage(this.fYZ, false);
            this.fZN.setVoiceViewRes(e.h.voice_play_btn_new);
            this.fZV = (TextView) view.findViewById(e.g.pb_item_tail_content);
            this.fZW = (LinearLayout) view.findViewById(e.g.pb_post_recommend_live_layout);
            this.fZX = (TextView) view.findViewById(e.g.pb_post_recommend_live_prefix_tv);
            this.fZY = view.findViewById(e.g.pb_post_recommend_live_divider);
            this.fZZ = (TextView) view.findViewById(e.g.pb_post_recommend_live_title);
            this.gaa = (ImageView) view.findViewById(e.g.pb_post_recommend_live_arrow);
            this.gab = (LinearLayout) view.findViewById(e.g.all_content);
            this.gac = (LinearLayout) view.findViewById(e.g.fold_op_area);
            this.gad = (TextView) view.findViewById(e.g.fold_title);
            this.gae = (ImageView) view.findViewById(e.g.fold_btn);
            this.gaf.ES();
            this.gaf.h(tbPageContext.getUniqueId());
        }
    }

    public void bz(boolean z) {
        if (this.gaf != null) {
            this.gaf.bz(z);
            this.gaf.ES();
        }
    }
}
