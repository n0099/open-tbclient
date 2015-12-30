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
import com.baidu.tieba.pb.view.PbNewChudianCommonView;
/* loaded from: classes.dex */
public class cs extends x.a {
    public TextView aLp;
    UserIconBox agT;
    public TextView bIB;
    public UserIconBox bnP;
    public TbRichTextView cDC;
    public TextView cEN;
    public View cEi;
    public View cEj;
    public View cEk;
    public View cEl;
    public View cEm;
    public HeadImageView cEn;
    public ImageView cEq;
    public TextView cEr;
    public ImageView cEt;
    public RelativeLayout cEu;
    public LinearLayout cEv;
    public ImageView cEw;
    public SubPbLayout cEx;
    public ImageView cGF;
    public ImageView cHS;
    public PbNewChudianCommonView cHT;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [85=5] */
    public cs(View view, boolean z, boolean z2, int i) {
        super(view);
        this.cEm = view.findViewById(n.g.sub_pb_more);
        this.cEn = (HeadImageView) view.findViewById(n.g.photo);
        this.aLp = (TextView) view.findViewById(n.g.user_name);
        this.cHS = (ImageView) view.findViewById(n.g.advertise);
        this.cEq = (ImageView) view.findViewById(n.g.user_gender);
        this.cEt = (ImageView) view.findViewById(n.g.reply);
        this.cDC = (TbRichTextView) view.findViewById(n.g.richText);
        this.cEr = (TextView) view.findViewById(n.g.floor);
        this.bIB = (TextView) view.findViewById(n.g.time);
        this.cEu = (RelativeLayout) view.findViewById(n.g.pb_post_header_layout);
        this.cEx = (SubPbLayout) view.findViewById(n.g.pb_post_footer_layout);
        this.cEv = (LinearLayout) view.findViewById(n.g.pb_subpb_layout_root);
        this.cEw = (ImageView) view.findViewById(n.g.pb_post_footer_layout_line_top);
        this.cEi = view;
        this.cEj = view.findViewById(n.g.new_pb_list_item_line_top);
        this.cEk = view.findViewById(n.g.new_pb_list_item_line_top_full);
        this.cEl = view.findViewById(n.g.new_pb_list_item_blank_top);
        this.cDC.Gd();
        this.cDC.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.cDC.getPaddingLeft()) - this.cDC.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.e.ds60)), i);
        this.cDC.setMaxImageWidth(min);
        this.cDC.setMaxImageHeight((int) (min * 1.618f));
        this.cDC.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.cEn.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.e.ds60);
            this.cEn.setLayoutParams(layoutParams);
            this.cEn.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.cEn.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.e.ds30);
            this.cEn.setLayoutParams(layoutParams2);
            this.cEn.setVisibility(4);
        }
        this.cDC.g(z2, false);
        this.cDC.setVoiceViewRes(n.h.voice_play_btn);
        this.bnP = (UserIconBox) view.findViewById(n.g.user_icon_box);
        this.agT = (UserIconBox) view.findViewById(n.g.user_tshow_icon_box);
        this.cEN = (TextView) view.findViewById(n.g.pb_item_tail_content);
        this.cGF = (ImageView) view.findViewById(n.g.replybtn);
        this.cHT = (PbNewChudianCommonView) view.findViewById(n.g.newchudian_common);
    }
}
