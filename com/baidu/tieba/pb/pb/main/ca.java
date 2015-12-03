package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes.dex */
public class ca extends x.a {
    public TextView aJR;
    UserIconBox aYE;
    public TextView bEX;
    public UserIconBox bjY;
    public View cAD;
    public View cAE;
    public View cAF;
    public View cAG;
    public View cAH;
    public HeadImageView cAI;
    public ImageView cAJ;
    public ImageView cAL;
    public TextView cAM;
    public ImageView cAN;
    public ImageView cAO;
    public RelativeLayout cAP;
    public LinearLayout cAQ;
    public ImageView cAR;
    public SubPbLayout cAS;
    public TextView cBi;
    public ImageView cCS;
    public RelativeLayout cCT;
    public LinearLayout cCU;
    public ImageView cCV;
    public TextView cCW;
    public ImageView cCX;
    public TbRichTextView czX;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [99=5] */
    public ca(View view, boolean z, boolean z2, int i) {
        super(view);
        this.cAH = view.findViewById(n.f.sub_pb_more);
        this.cAI = (HeadImageView) view.findViewById(n.f.photo);
        this.aJR = (TextView) view.findViewById(n.f.user_name);
        this.cAJ = (ImageView) view.findViewById(n.f.user_rank);
        this.cAL = (ImageView) view.findViewById(n.f.user_gender);
        this.cAO = (ImageView) view.findViewById(n.f.reply);
        this.czX = (TbRichTextView) view.findViewById(n.f.richText);
        this.cAN = (ImageView) view.findViewById(n.f.floor_owner);
        this.cAM = (TextView) view.findViewById(n.f.floor);
        this.bEX = (TextView) view.findViewById(n.f.time);
        this.cAP = (RelativeLayout) view.findViewById(n.f.pb_post_header_layout);
        this.cAS = (SubPbLayout) view.findViewById(n.f.pb_post_footer_layout);
        this.cAQ = (LinearLayout) view.findViewById(n.f.pb_subpb_layout_root);
        this.cAR = (ImageView) view.findViewById(n.f.pb_post_footer_layout_line_top);
        this.cAD = view;
        this.cAE = view.findViewById(n.f.new_pb_list_item_line_top);
        this.cAF = view.findViewById(n.f.new_pb_list_item_line_top_full);
        this.cAG = view.findViewById(n.f.new_pb_list_item_blank_top);
        this.cCT = (RelativeLayout) view.findViewById(n.f.chudian_info_container);
        this.cCU = (LinearLayout) view.findViewById(n.f.landmark_container);
        this.cCV = (ImageView) view.findViewById(n.f.landmark_icon);
        this.cCW = (TextView) view.findViewById(n.f.landmark_content);
        this.cCX = (ImageView) view.findViewById(n.f.ad_icon);
        this.czX.Go();
        this.czX.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.czX.getPaddingLeft()) - this.czX.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.d.ds60)), i);
        this.czX.setMaxImageWidth(min);
        this.czX.setMaxImageHeight((int) (min * 1.618f));
        this.czX.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.cAI.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.d.ds60);
            this.cAI.setLayoutParams(layoutParams);
            this.cAI.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.cAI.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.d.ds30);
            this.cAI.setLayoutParams(layoutParams2);
            this.cAI.setVisibility(4);
        }
        this.czX.f(z2, false);
        this.czX.setVoiceViewRes(n.g.voice_play_btn);
        this.bjY = (UserIconBox) view.findViewById(n.f.user_icon_box);
        this.aYE = (UserIconBox) view.findViewById(n.f.user_tshow_icon_box);
        this.cBi = (TextView) view.findViewById(n.f.pb_item_tail_content);
        this.cCS = (ImageView) view.findViewById(n.f.replybtn);
    }
}
