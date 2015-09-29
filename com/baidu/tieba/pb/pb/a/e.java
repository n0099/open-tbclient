package com.baidu.tieba.pb.pb.a;

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
public class e extends x.a {
    public TextView aHN;
    UserIconBox aSX;
    public UserIconBox bcC;
    public TextView bpA;
    public View cgT;
    public View cgU;
    public View cgV;
    public View cgW;
    public View cgX;
    public HeadImageView cgY;
    public ImageView cgZ;
    public TextView chA;
    public ImageView cha;
    public TextView chb;
    public ImageView chc;
    public ImageView chd;
    public TbRichTextView che;
    public TextView chf;
    public TbRichTextView chg;
    public View chh;
    public FrsPraiseView chi;
    public ImageView chj;
    public RelativeLayout chk;
    public LinearLayout chl;
    public ImageView chm;
    public SubPbLayout chn;
    public BaobaoTailView cho;
    public LinearLayout chp;
    public TextView chq;
    public LinearLayout chr;
    public Button chs;
    public LinearLayout cht;
    public TextView chu;
    public View chv;
    public View chw;
    public LinearLayout chx;
    public ImageView chy;
    public TextView chz;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [123=5] */
    public e(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.cgX = view.findViewById(i.f.sub_pb_more);
        this.cgY = (HeadImageView) view.findViewById(i.f.photo);
        this.aHN = (TextView) view.findViewById(i.f.user_name);
        this.cgZ = (ImageView) view.findViewById(i.f.user_rank);
        this.cha = (ImageView) view.findViewById(i.f.user_gender);
        this.chd = (ImageView) view.findViewById(i.f.reply);
        this.che = (TbRichTextView) view.findViewById(i.f.richText);
        this.chf = (TextView) view.findViewById(i.f.pb_act_btn);
        this.chg = (TbRichTextView) view.findViewById(i.f.pb_act_img);
        this.chh = view.findViewById(i.f.pb_item_praise_topline);
        this.chi = (FrsPraiseView) view.findViewById(i.f.pb_item_praise_view);
        this.chj = (ImageView) view.findViewById(i.f.pb_item_praise_bottomline);
        this.chx = (LinearLayout) view.findViewById(i.f.pb_item_location_container);
        this.chz = (TextView) view.findViewById(i.f.pb_item_location_address);
        this.chy = (ImageView) view.findViewById(i.f.pb_item_location_img);
        this.chc = (ImageView) view.findViewById(i.f.floor_owner);
        this.chb = (TextView) view.findViewById(i.f.floor);
        this.bpA = (TextView) view.findViewById(i.f.time);
        this.chk = (RelativeLayout) view.findViewById(i.f.pb_post_header_layout);
        this.chn = (SubPbLayout) view.findViewById(i.f.pb_post_footer_layout);
        this.chl = (LinearLayout) view.findViewById(i.f.pb_subpb_layout_root);
        this.chm = (ImageView) view.findViewById(i.f.pb_post_footer_layout_line_top);
        this.cgT = view;
        this.cgU = view.findViewById(i.f.new_pb_list_item_line_top);
        this.cgV = view.findViewById(i.f.new_pb_list_item_line_top_full);
        this.cgW = view.findViewById(i.f.new_pb_list_item_blank_top);
        this.che.Fq();
        this.che.setImageViewStretch(true);
        this.chg.setMaxImageWidth(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - (((int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds30)) * 2));
        this.chg.setMaxImageHeight((int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds484));
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.che.getPaddingLeft()) - this.che.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds60)), i);
        this.che.setMaxImageWidth(min);
        this.che.setMaxImageHeight((int) (min * 1.618f));
        this.che.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.cgY.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds60);
            this.cgY.setLayoutParams(layoutParams);
            this.cgY.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.cgY.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds30);
            this.cgY.setLayoutParams(layoutParams2);
            this.cgY.setVisibility(4);
        }
        this.che.f(z2, false);
        this.che.setVoiceViewRes(i.g.voice_play_btn);
        this.bcC = (UserIconBox) view.findViewById(i.f.user_icon_box);
        this.aSX = (UserIconBox) view.findViewById(i.f.user_tshow_icon_box);
        this.chp = (LinearLayout) view.findViewById(i.f.add_post_footer_layout);
        if (z3) {
            this.chk.setVisibility(8);
            this.chd.setVisibility(8);
            this.che.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.che.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            this.che.setLayoutParams(layoutParams3);
            view.findViewById(i.f.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.chr = (LinearLayout) view.findViewById(i.f.add_time_container);
            this.chq = (TextView) view.findViewById(i.f.add_time);
            this.chs = (Button) view.findViewById(i.f.manage_btn);
            this.chr.setVisibility(0);
        }
        this.cht = (LinearLayout) view.findViewById(i.f.addition_more_container);
        this.chu = (TextView) this.cht.findViewById(i.f.addition_more);
        this.chv = this.cht.findViewById(i.f.addition_divider1);
        this.chw = this.cht.findViewById(i.f.addition_divider2);
        this.cho = (BaobaoTailView) view.findViewById(i.f.baobao_tail);
        this.chA = (TextView) view.findViewById(i.f.pb_item_tail_content);
    }
}
