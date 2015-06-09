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
    public TextView aBn;
    UserIconBox aKy;
    public UserIconBox aQL;
    public ImageView bMA;
    public TbRichTextView bMB;
    public TextView bMC;
    public TbRichTextView bMD;
    public View bME;
    public FrsPraiseView bMF;
    public ImageView bMG;
    public RelativeLayout bMH;
    public LinearLayout bMI;
    public ImageView bMJ;
    public SubPbLayout bMK;
    public BaobaoTailView bML;
    public LinearLayout bMM;
    public TextView bMN;
    public LinearLayout bMO;
    public Button bMP;
    public LinearLayout bMQ;
    public TextView bMR;
    public View bMS;
    public View bMT;
    public LinearLayout bMU;
    public ImageView bMV;
    public TextView bMW;
    public LinearLayout bMX;
    public ImageView bMY;
    public TextView bMZ;
    public View bMp;
    public View bMq;
    public View bMr;
    public View bMs;
    public View bMt;
    public HeadImageView bMu;
    public ImageView bMv;
    public ImageView bMw;
    public TextView bMx;
    public TextView bMy;
    public ImageView bMz;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [129=5] */
    public ca(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.bMt = view.findViewById(com.baidu.tieba.q.sub_pb_more);
        this.bMu = (HeadImageView) view.findViewById(com.baidu.tieba.q.photo);
        this.aBn = (TextView) view.findViewById(com.baidu.tieba.q.user_name);
        this.bMv = (ImageView) view.findViewById(com.baidu.tieba.q.user_rank);
        this.bMw = (ImageView) view.findViewById(com.baidu.tieba.q.user_gender);
        this.bMA = (ImageView) view.findViewById(com.baidu.tieba.q.reply);
        this.bMB = (TbRichTextView) view.findViewById(com.baidu.tieba.q.richText);
        this.bMC = (TextView) view.findViewById(com.baidu.tieba.q.pb_act_btn);
        this.bMD = (TbRichTextView) view.findViewById(com.baidu.tieba.q.pb_act_img);
        this.bME = view.findViewById(com.baidu.tieba.q.pb_item_praise_topline);
        this.bMF = (FrsPraiseView) view.findViewById(com.baidu.tieba.q.pb_item_praise_view);
        this.bMG = (ImageView) view.findViewById(com.baidu.tieba.q.pb_item_praise_bottomline);
        this.bMU = (LinearLayout) view.findViewById(com.baidu.tieba.q.pb_item_location_container);
        this.bMW = (TextView) view.findViewById(com.baidu.tieba.q.pb_item_location_address);
        this.bMV = (ImageView) view.findViewById(com.baidu.tieba.q.pb_item_location_img);
        this.bMX = (LinearLayout) view.findViewById(com.baidu.tieba.q.pb_reply_location_container);
        this.bMZ = (TextView) view.findViewById(com.baidu.tieba.q.pb_reply_location_address);
        this.bMY = (ImageView) view.findViewById(com.baidu.tieba.q.pb_reply_location_img);
        this.bMz = (ImageView) view.findViewById(com.baidu.tieba.q.floor_owner);
        this.bMx = (TextView) view.findViewById(com.baidu.tieba.q.floor);
        this.bMy = (TextView) view.findViewById(com.baidu.tieba.q.time);
        this.bMH = (RelativeLayout) view.findViewById(com.baidu.tieba.q.pb_post_header_layout);
        this.bMK = (SubPbLayout) view.findViewById(com.baidu.tieba.q.pb_post_footer_layout);
        this.bMI = (LinearLayout) view.findViewById(com.baidu.tieba.q.pb_subpb_layout_root);
        this.bMJ = (ImageView) view.findViewById(com.baidu.tieba.q.pb_post_footer_layout_line_top);
        this.bMp = view;
        this.bMq = view.findViewById(com.baidu.tieba.q.new_pb_list_item_line_top);
        this.bMr = view.findViewById(com.baidu.tieba.q.new_pb_list_item_line_top_full);
        this.bMs = view.findViewById(com.baidu.tieba.q.new_pb_list_item_blank_top);
        this.bMB.ED();
        this.bMB.setImageViewStretch(true);
        this.bMD.setMaxImageWidth(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst()) - (((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.o.ds30)) * 2));
        this.bMD.setMaxImageHeight((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.o.ds484));
        int min = Math.min(((((com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.bMB.getPaddingLeft()) - this.bMB.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.o.ds60)), i);
        this.bMB.setMaxImageWidth(min);
        this.bMB.setMaxImageHeight((int) (min * 1.618f));
        this.bMB.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.bMu.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.o.ds60);
            this.bMu.setLayoutParams(layoutParams);
            this.bMu.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.bMu.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.o.ds30);
            this.bMu.setLayoutParams(layoutParams2);
            this.bMu.setVisibility(4);
        }
        this.bMB.c(z2, false);
        this.bMB.setVoiceViewRes(com.baidu.tieba.r.voice_play_btn);
        this.aQL = (UserIconBox) view.findViewById(com.baidu.tieba.q.user_icon_box);
        this.aKy = (UserIconBox) view.findViewById(com.baidu.tieba.q.user_tshow_icon_box);
        this.bMM = (LinearLayout) view.findViewById(com.baidu.tieba.q.add_post_footer_layout);
        if (z3) {
            this.bMH.setVisibility(8);
            this.bMA.setVisibility(8);
            this.bMB.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bMB.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            this.bMB.setLayoutParams(layoutParams3);
            view.findViewById(com.baidu.tieba.q.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.bMO = (LinearLayout) view.findViewById(com.baidu.tieba.q.add_time_container);
            this.bMN = (TextView) view.findViewById(com.baidu.tieba.q.add_time);
            this.bMP = (Button) view.findViewById(com.baidu.tieba.q.manage_btn);
            this.bMO.setVisibility(0);
        }
        this.bMQ = (LinearLayout) view.findViewById(com.baidu.tieba.q.addition_more_container);
        this.bMR = (TextView) this.bMQ.findViewById(com.baidu.tieba.q.addition_more);
        this.bMS = this.bMQ.findViewById(com.baidu.tieba.q.addition_divider1);
        this.bMT = this.bMQ.findViewById(com.baidu.tieba.q.addition_divider2);
        this.bML = (BaobaoTailView) view.findViewById(com.baidu.tieba.q.baobao_tail);
    }
}
