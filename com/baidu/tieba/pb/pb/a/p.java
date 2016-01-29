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
public class p extends x.a {
    public View cKC;
    public LinearLayout cKD;
    public LinearLayout cKE;
    public TbRichTextView cKi;
    public View cKj;
    public PbGiftListView cKk;
    public FrsPraiseView cKl;
    public ImageView cKm;
    public TextView cKr;
    public LinearLayout cKt;
    public TextView cKu;
    public TextView cKv;
    public TextView cKw;
    public View cKx;
    public View cKy;
    public SparseArray<com.baidu.tieba.pb.view.l> cKz;
    public com.baidu.tbadk.core.view.o mNoDataView;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [79=5] */
    public p(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.cKC = view;
        this.cKi = (TbRichTextView) view.findViewById(t.g.richText);
        this.cKr = (TextView) view.findViewById(t.g.pb_act_btn);
        this.cKj = view.findViewById(t.g.pb_item_praise_topline);
        this.cKl = (FrsPraiseView) view.findViewById(t.g.pb_item_praise_view);
        this.cKm = (ImageView) view.findViewById(t.g.pb_item_praise_bottomline);
        this.cKk = (PbGiftListView) view.findViewById(t.g.gift_list_view);
        this.cKD = (LinearLayout) view.findViewById(t.g.show_pic_bottom_layout);
        this.cKt = (LinearLayout) view.findViewById(t.g.showpic_cardview_container_ll);
        this.cKE = (LinearLayout) view.findViewById(t.g.line_tv_line);
        this.cKv = (TextView) view.findViewById(t.g.picture_list_tv);
        this.cKu = (TextView) view.findViewById(t.g.join_vote_tv);
        this.cKw = (TextView) view.findViewById(t.g.look_all_tv);
        this.cKx = view.findViewById(t.g.line_view_left);
        this.cKy = view.findViewById(t.g.line_view_right);
        this.cKi.HC();
        this.cKi.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.cKi.getPaddingLeft()) - this.cKi.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds60)), i);
        this.cKi.setMaxImageWidth(min);
        this.cKi.setMaxImageHeight((int) (min * 1.618f));
        this.cKi.setTextSize(TbConfig.getContentSize());
        this.cKi.g(z2, false);
        this.cKi.setVoiceViewRes(t.h.voice_play_btn);
    }
}
