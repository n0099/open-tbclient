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
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
/* loaded from: classes.dex */
public class by extends x.a {
    public TextView aGS;
    UserIconBox aTq;
    public UserIconBox bds;
    public TextView bqp;
    public TbRichTextView chB;
    public TextView ciM;
    public View cih;
    public View cii;
    public View cij;
    public View cik;
    public View cil;
    public HeadImageView cim;
    public ImageView cin;
    public ImageView cip;
    public TextView ciq;
    public ImageView cir;
    public ImageView cis;
    public RelativeLayout cit;
    public LinearLayout ciu;
    public ImageView civ;
    public SubPbLayout ciw;
    public RelativeLayout ckt;
    public LinearLayout cku;
    public ImageView ckv;
    public TextView ckw;
    public ImageView ckx;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [96=5] */
    public by(View view, boolean z, boolean z2, int i) {
        super(view);
        this.cil = view.findViewById(i.f.sub_pb_more);
        this.cim = (HeadImageView) view.findViewById(i.f.photo);
        this.aGS = (TextView) view.findViewById(i.f.user_name);
        this.cin = (ImageView) view.findViewById(i.f.user_rank);
        this.cip = (ImageView) view.findViewById(i.f.user_gender);
        this.cis = (ImageView) view.findViewById(i.f.reply);
        this.chB = (TbRichTextView) view.findViewById(i.f.richText);
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
        this.ckt = (RelativeLayout) view.findViewById(i.f.chudian_info_container);
        this.cku = (LinearLayout) view.findViewById(i.f.landmark_container);
        this.ckv = (ImageView) view.findViewById(i.f.landmark_icon);
        this.ckw = (TextView) view.findViewById(i.f.landmark_content);
        this.ckx = (ImageView) view.findViewById(i.f.ad_icon);
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
        this.ciM = (TextView) view.findViewById(i.f.pb_item_tail_content);
    }
}
