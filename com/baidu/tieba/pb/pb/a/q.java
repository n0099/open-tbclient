package com.baidu.tieba.pb.pb.a;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class q extends x.a {
    public TbRichTextView ddA;
    public View ddB;
    public PbGiftListView ddC;
    public FrsPraiseView ddD;
    public ImageView ddE;
    public TextView ddJ;
    public LinearLayout ddL;
    public TextView ddM;
    public TextView ddN;
    public TextView ddO;
    public View ddP;
    public View ddQ;
    public SparseArray<com.baidu.tieba.pb.view.l> ddR;
    public View ddU;
    public LinearLayout ddV;
    public LinearLayout ddW;
    public com.baidu.tbadk.core.view.p mNoDataView;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=5] */
    public q(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.ddU = view;
        this.ddA = (TbRichTextView) view.findViewById(t.g.richText);
        this.ddJ = (TextView) view.findViewById(t.g.pb_act_btn);
        this.ddB = view.findViewById(t.g.pb_item_praise_topline);
        this.ddD = (FrsPraiseView) view.findViewById(t.g.pb_item_praise_view);
        this.ddE = (ImageView) view.findViewById(t.g.pb_item_praise_bottomline);
        this.ddC = (PbGiftListView) view.findViewById(t.g.gift_list_view);
        this.ddV = (LinearLayout) view.findViewById(t.g.show_pic_bottom_layout);
        this.ddL = (LinearLayout) view.findViewById(t.g.showpic_cardview_container_ll);
        this.ddW = (LinearLayout) view.findViewById(t.g.line_tv_line);
        this.ddN = (TextView) view.findViewById(t.g.picture_list_tv);
        this.ddM = (TextView) view.findViewById(t.g.join_vote_tv);
        this.ddO = (TextView) view.findViewById(t.g.look_all_tv);
        this.ddP = view.findViewById(t.g.line_view_left);
        this.ddQ = view.findViewById(t.g.line_view_right);
        this.ddA.IY();
        this.ddA.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ddA.getPaddingLeft()) - this.ddA.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds60)), i);
        this.ddA.setMaxImageWidth(min);
        this.ddA.setMaxImageHeight((int) (min * 1.618f));
        this.ddA.setTextSize(TbConfig.getContentSize());
        this.ddA.h(z2, false);
        this.ddA.setVoiceViewRes(t.h.voice_play_btn);
    }
}
