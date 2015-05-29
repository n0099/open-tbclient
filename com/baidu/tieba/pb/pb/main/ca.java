package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.BaobaoTailView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class ca extends com.baidu.adp.widget.ListView.am {
    public TextView aBm;
    UserIconBox aKx;
    public UserIconBox aQK;
    public TbRichTextView bMA;
    public TextView bMB;
    public TbRichTextView bMC;
    public View bMD;
    public FrsPraiseView bME;
    public ImageView bMF;
    public RelativeLayout bMG;
    public LinearLayout bMH;
    public ImageView bMI;
    public SubPbLayout bMJ;
    public BaobaoTailView bMK;
    public LinearLayout bML;
    public TextView bMM;
    public LinearLayout bMN;
    public Button bMO;
    public LinearLayout bMP;
    public TextView bMQ;
    public View bMR;
    public View bMS;
    public LinearLayout bMT;
    public ImageView bMU;
    public TextView bMV;
    public LinearLayout bMW;
    public ImageView bMX;
    public TextView bMY;
    public View bMo;
    public View bMp;
    public View bMq;
    public View bMr;
    public View bMs;
    public HeadImageView bMt;
    public ImageView bMu;
    public ImageView bMv;
    public TextView bMw;
    public TextView bMx;
    public ImageView bMy;
    public ImageView bMz;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [129=5] */
    public ca(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.bMs = view.findViewById(com.baidu.tieba.q.sub_pb_more);
        this.bMt = (HeadImageView) view.findViewById(com.baidu.tieba.q.photo);
        this.aBm = (TextView) view.findViewById(com.baidu.tieba.q.user_name);
        this.bMu = (ImageView) view.findViewById(com.baidu.tieba.q.user_rank);
        this.bMv = (ImageView) view.findViewById(com.baidu.tieba.q.user_gender);
        this.bMz = (ImageView) view.findViewById(com.baidu.tieba.q.reply);
        this.bMA = (TbRichTextView) view.findViewById(com.baidu.tieba.q.richText);
        this.bMB = (TextView) view.findViewById(com.baidu.tieba.q.pb_act_btn);
        this.bMC = (TbRichTextView) view.findViewById(com.baidu.tieba.q.pb_act_img);
        this.bMD = view.findViewById(com.baidu.tieba.q.pb_item_praise_topline);
        this.bME = (FrsPraiseView) view.findViewById(com.baidu.tieba.q.pb_item_praise_view);
        this.bMF = (ImageView) view.findViewById(com.baidu.tieba.q.pb_item_praise_bottomline);
        this.bMT = (LinearLayout) view.findViewById(com.baidu.tieba.q.pb_item_location_container);
        this.bMV = (TextView) view.findViewById(com.baidu.tieba.q.pb_item_location_address);
        this.bMU = (ImageView) view.findViewById(com.baidu.tieba.q.pb_item_location_img);
        this.bMW = (LinearLayout) view.findViewById(com.baidu.tieba.q.pb_reply_location_container);
        this.bMY = (TextView) view.findViewById(com.baidu.tieba.q.pb_reply_location_address);
        this.bMX = (ImageView) view.findViewById(com.baidu.tieba.q.pb_reply_location_img);
        this.bMy = (ImageView) view.findViewById(com.baidu.tieba.q.floor_owner);
        this.bMw = (TextView) view.findViewById(com.baidu.tieba.q.floor);
        this.bMx = (TextView) view.findViewById(com.baidu.tieba.q.time);
        this.bMG = (RelativeLayout) view.findViewById(com.baidu.tieba.q.pb_post_header_layout);
        this.bMJ = (SubPbLayout) view.findViewById(com.baidu.tieba.q.pb_post_footer_layout);
        this.bMH = (LinearLayout) view.findViewById(com.baidu.tieba.q.pb_subpb_layout_root);
        this.bMI = (ImageView) view.findViewById(com.baidu.tieba.q.pb_post_footer_layout_line_top);
        this.bMo = view;
        this.bMp = view.findViewById(com.baidu.tieba.q.new_pb_list_item_line_top);
        this.bMq = view.findViewById(com.baidu.tieba.q.new_pb_list_item_line_top_full);
        this.bMr = view.findViewById(com.baidu.tieba.q.new_pb_list_item_blank_top);
        this.bMA.EC();
        this.bMA.setImageViewStretch(true);
        this.bMC.setMaxImageWidth(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst()) - (((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.o.ds30)) * 2));
        this.bMC.setMaxImageHeight((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.o.ds484));
        int min = Math.min(((((com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.bMA.getPaddingLeft()) - this.bMA.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.o.ds60)), i);
        this.bMA.setMaxImageWidth(min);
        this.bMA.setMaxImageHeight((int) (min * 1.618f));
        this.bMA.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.bMt.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.o.ds60);
            this.bMt.setLayoutParams(layoutParams);
            this.bMt.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.bMt.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.o.ds30);
            this.bMt.setLayoutParams(layoutParams2);
            this.bMt.setVisibility(4);
        }
        this.bMA.c(z2, false);
        this.bMA.setVoiceViewRes(com.baidu.tieba.r.voice_play_btn);
        this.aQK = (UserIconBox) view.findViewById(com.baidu.tieba.q.user_icon_box);
        this.aKx = (UserIconBox) view.findViewById(com.baidu.tieba.q.user_tshow_icon_box);
        this.bML = (LinearLayout) view.findViewById(com.baidu.tieba.q.add_post_footer_layout);
        if (z3) {
            this.bMG.setVisibility(8);
            this.bMz.setVisibility(8);
            this.bMA.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bMA.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            this.bMA.setLayoutParams(layoutParams3);
            view.findViewById(com.baidu.tieba.q.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.bMN = (LinearLayout) view.findViewById(com.baidu.tieba.q.add_time_container);
            this.bMM = (TextView) view.findViewById(com.baidu.tieba.q.add_time);
            this.bMO = (Button) view.findViewById(com.baidu.tieba.q.manage_btn);
            this.bMN.setVisibility(0);
        }
        this.bMP = (LinearLayout) view.findViewById(com.baidu.tieba.q.addition_more_container);
        this.bMQ = (TextView) this.bMP.findViewById(com.baidu.tieba.q.addition_more);
        this.bMR = this.bMP.findViewById(com.baidu.tieba.q.addition_divider1);
        this.bMS = this.bMP.findViewById(com.baidu.tieba.q.addition_divider2);
        this.bMK = (BaobaoTailView) view.findViewById(com.baidu.tieba.q.baobao_tail);
    }
}
