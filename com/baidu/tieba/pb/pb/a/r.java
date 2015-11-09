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
public class r extends x.a {
    public TextView aGS;
    UserIconBox aTq;
    public UserIconBox bds;
    public TextView bqp;
    public TbRichTextView chB;
    public View chD;
    public FrsPraiseView chE;
    public ImageView chF;
    public LinearLayout ciA;
    public Button ciB;
    public LinearLayout ciC;
    public TextView ciD;
    public View ciE;
    public View ciF;
    public LinearLayout ciG;
    public ImageView ciH;
    public TextView ciI;
    public LinearLayout ciJ;
    public ImageView ciK;
    public TextView ciL;
    public TextView ciM;
    public View cih;
    public View cii;
    public View cij;
    public View cik;
    public View cil;
    public HeadImageView cim;
    public ImageView cin;
    public ImageView cio;
    public ImageView cip;
    public TextView ciq;
    public ImageView cir;
    public ImageView cis;
    public RelativeLayout cit;
    public LinearLayout ciu;
    public ImageView civ;
    public SubPbLayout ciw;
    public BaobaoTailView cix;
    public LinearLayout ciy;
    public TextView ciz;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [126=5] */
    public r(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.cil = view.findViewById(i.f.sub_pb_more);
        this.cim = (HeadImageView) view.findViewById(i.f.photo);
        this.aGS = (TextView) view.findViewById(i.f.user_name);
        this.cin = (ImageView) view.findViewById(i.f.user_rank);
        this.cio = (ImageView) view.findViewById(i.f.user_bawu);
        this.cip = (ImageView) view.findViewById(i.f.user_gender);
        this.cis = (ImageView) view.findViewById(i.f.reply);
        this.chB = (TbRichTextView) view.findViewById(i.f.richText);
        this.chD = view.findViewById(i.f.pb_item_praise_topline);
        this.chE = (FrsPraiseView) view.findViewById(i.f.pb_item_praise_view);
        this.chF = (ImageView) view.findViewById(i.f.pb_item_praise_bottomline);
        this.ciG = (LinearLayout) view.findViewById(i.f.pb_item_location_container);
        this.ciI = (TextView) view.findViewById(i.f.pb_item_location_address);
        this.ciH = (ImageView) view.findViewById(i.f.pb_item_location_img);
        this.ciJ = (LinearLayout) view.findViewById(i.f.pb_reply_location_container);
        this.ciL = (TextView) view.findViewById(i.f.pb_reply_location_address);
        this.ciK = (ImageView) view.findViewById(i.f.pb_reply_location_img);
        this.cir = (ImageView) view.findViewById(i.f.floor_owner);
        this.ciq = (TextView) view.findViewById(i.f.floor);
        this.bqp = (TextView) view.findViewById(i.f.time);
        this.cit = (RelativeLayout) view.findViewById(i.f.pb_post_header_layout);
        this.ciw = (SubPbLayout) view.findViewById(i.f.pb_post_footer_layout);
        this.ciu = (LinearLayout) view.findViewById(i.f.pb_subpb_layout_root);
        this.civ = (ImageView) view.findViewById(i.f.pb_post_footer_layout_line_top);
        this.cih = view;
        this.cii = view.findViewById(i.f.new_pb_list_item_line_top);
        this.cij = view.findViewById(i.f.new_pb_list_item_line_top_full);
        this.cik = view.findViewById(i.f.new_pb_list_item_blank_top);
        this.chB.Fj();
        this.chB.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.chB.getPaddingLeft()) - this.chB.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds60)), i);
        this.chB.setMaxImageWidth(min);
        this.chB.setMaxImageHeight((int) (min * 1.618f));
        this.chB.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.cim.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds60);
            this.cim.setLayoutParams(layoutParams);
            this.cim.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.cim.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds30);
            this.cim.setLayoutParams(layoutParams2);
            this.cim.setVisibility(4);
        }
        this.chB.f(z2, false);
        this.chB.setVoiceViewRes(i.g.voice_play_btn);
        this.bds = (UserIconBox) view.findViewById(i.f.user_icon_box);
        this.aTq = (UserIconBox) view.findViewById(i.f.user_tshow_icon_box);
        this.ciy = (LinearLayout) view.findViewById(i.f.add_post_footer_layout);
        if (z3) {
            this.cit.setVisibility(8);
            this.cis.setVisibility(8);
            this.chB.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.chB.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            this.chB.setLayoutParams(layoutParams3);
            view.findViewById(i.f.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.ciA = (LinearLayout) view.findViewById(i.f.add_time_container);
            this.ciz = (TextView) view.findViewById(i.f.add_time);
            this.ciB = (Button) view.findViewById(i.f.manage_btn);
            this.ciA.setVisibility(0);
        }
        this.ciC = (LinearLayout) view.findViewById(i.f.addition_more_container);
        this.ciD = (TextView) this.ciC.findViewById(i.f.addition_more);
        this.ciE = this.ciC.findViewById(i.f.addition_divider1);
        this.ciF = this.ciC.findViewById(i.f.addition_divider2);
        this.cix = (BaobaoTailView) view.findViewById(i.f.baobao_tail);
        this.ciM = (TextView) view.findViewById(i.f.pb_item_tail_content);
    }
}
