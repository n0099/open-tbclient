package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.BaobaoTailView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class bw extends x.a {
    public TextView aHY;
    UserIconBox aTi;
    public UserIconBox bcN;
    public TextView bpL;
    public LinearLayout chA;
    public TextView chB;
    public LinearLayout chC;
    public Button chD;
    public LinearLayout chE;
    public TextView chF;
    public View chG;
    public View chH;
    public LinearLayout chI;
    public ImageView chJ;
    public TextView chK;
    public TextView chL;
    public ImageView chP;
    public LinearLayout chQ;
    public ImageView chR;
    public TextView chS;
    public View che;
    public View chf;
    public View chg;
    public View chh;
    public View chi;
    public HeadImageView chj;
    public ImageView chk;
    public ImageView chl;
    public TextView chm;
    public ImageView chn;
    public ImageView cho;
    public TbRichTextView chp;
    public View chs;
    public FrsPraiseView cht;
    public ImageView chu;
    public RelativeLayout chv;
    public LinearLayout chw;
    public ImageView chx;
    public SubPbLayout chy;
    public BaobaoTailView chz;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [126=5] */
    public bw(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.chi = view.findViewById(i.f.sub_pb_more);
        this.chj = (HeadImageView) view.findViewById(i.f.photo);
        this.aHY = (TextView) view.findViewById(i.f.user_name);
        this.chk = (ImageView) view.findViewById(i.f.user_rank);
        this.chP = (ImageView) view.findViewById(i.f.user_bawu);
        this.chl = (ImageView) view.findViewById(i.f.user_gender);
        this.cho = (ImageView) view.findViewById(i.f.reply);
        this.chp = (TbRichTextView) view.findViewById(i.f.richText);
        this.chs = view.findViewById(i.f.pb_item_praise_topline);
        this.cht = (FrsPraiseView) view.findViewById(i.f.pb_item_praise_view);
        this.chu = (ImageView) view.findViewById(i.f.pb_item_praise_bottomline);
        this.chI = (LinearLayout) view.findViewById(i.f.pb_item_location_container);
        this.chK = (TextView) view.findViewById(i.f.pb_item_location_address);
        this.chJ = (ImageView) view.findViewById(i.f.pb_item_location_img);
        this.chQ = (LinearLayout) view.findViewById(i.f.pb_reply_location_container);
        this.chS = (TextView) view.findViewById(i.f.pb_reply_location_address);
        this.chR = (ImageView) view.findViewById(i.f.pb_reply_location_img);
        this.chn = (ImageView) view.findViewById(i.f.floor_owner);
        this.chm = (TextView) view.findViewById(i.f.floor);
        this.bpL = (TextView) view.findViewById(i.f.time);
        this.chv = (RelativeLayout) view.findViewById(i.f.pb_post_header_layout);
        this.chy = (SubPbLayout) view.findViewById(i.f.pb_post_footer_layout);
        this.chw = (LinearLayout) view.findViewById(i.f.pb_subpb_layout_root);
        this.chx = (ImageView) view.findViewById(i.f.pb_post_footer_layout_line_top);
        this.che = view;
        this.chf = view.findViewById(i.f.new_pb_list_item_line_top);
        this.chg = view.findViewById(i.f.new_pb_list_item_line_top_full);
        this.chh = view.findViewById(i.f.new_pb_list_item_blank_top);
        this.chp.Fm();
        this.chp.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.chp.getPaddingLeft()) - this.chp.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds60)), i);
        this.chp.setMaxImageWidth(min);
        this.chp.setMaxImageHeight((int) (min * 1.618f));
        this.chp.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.chj.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds60);
            this.chj.setLayoutParams(layoutParams);
            this.chj.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.chj.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds30);
            this.chj.setLayoutParams(layoutParams2);
            this.chj.setVisibility(4);
        }
        this.chp.f(z2, false);
        this.chp.setVoiceViewRes(i.g.voice_play_btn);
        this.bcN = (UserIconBox) view.findViewById(i.f.user_icon_box);
        this.aTi = (UserIconBox) view.findViewById(i.f.user_tshow_icon_box);
        this.chA = (LinearLayout) view.findViewById(i.f.add_post_footer_layout);
        if (z3) {
            this.chv.setVisibility(8);
            this.cho.setVisibility(8);
            this.chp.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.chp.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            this.chp.setLayoutParams(layoutParams3);
            view.findViewById(i.f.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.chC = (LinearLayout) view.findViewById(i.f.add_time_container);
            this.chB = (TextView) view.findViewById(i.f.add_time);
            this.chD = (Button) view.findViewById(i.f.manage_btn);
            this.chC.setVisibility(0);
        }
        this.chE = (LinearLayout) view.findViewById(i.f.addition_more_container);
        this.chF = (TextView) this.chE.findViewById(i.f.addition_more);
        this.chG = this.chE.findViewById(i.f.addition_divider1);
        this.chH = this.chE.findViewById(i.f.addition_divider2);
        this.chz = (BaobaoTailView) view.findViewById(i.f.baobao_tail);
        this.chL = (TextView) view.findViewById(i.f.pb_item_tail_content);
    }
}
