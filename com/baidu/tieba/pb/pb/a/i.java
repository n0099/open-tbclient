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
public class i extends x.a {
    public TbRichTextView cKi;
    public View cKj;
    public PbGiftListView cKk;
    public FrsPraiseView cKl;
    public ImageView cKm;
    public View cKq;
    public TextView cKr;
    public LinearLayout cKs;
    public LinearLayout cKt;
    public TextView cKu;
    public TextView cKv;
    public TextView cKw;
    public View cKx;
    public View cKy;
    public SparseArray<com.baidu.tieba.pb.view.l> cKz;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [65=5] */
    public i(View view, boolean z, int i) {
        super(view);
        this.cKq = view;
        this.cKi = (TbRichTextView) view.findViewById(t.g.richText);
        this.cKr = (TextView) view.findViewById(t.g.pb_act_btn);
        this.cKj = view.findViewById(t.g.pb_item_praise_topline);
        this.cKl = (FrsPraiseView) view.findViewById(t.g.pb_item_praise_view);
        this.cKm = (ImageView) view.findViewById(t.g.pb_item_praise_bottomline);
        this.cKk = (PbGiftListView) view.findViewById(t.g.gift_list_view);
        this.cKs = (LinearLayout) view.findViewById(t.g.lottery_bottom_layout);
        this.cKt = (LinearLayout) view.findViewById(t.g.showpic_cardview_container_ll);
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
        this.cKi.g(z, false);
        this.cKi.setVoiceViewRes(t.h.voice_play_btn);
    }
}
