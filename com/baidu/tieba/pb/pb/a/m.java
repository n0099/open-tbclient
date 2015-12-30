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
import com.baidu.tieba.n;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class m extends x.a {
    public TbRichTextView cDC;
    public TextView cDD;
    public View cDE;
    public FrsPraiseView cDF;
    public ImageView cDG;
    public PbGiftListView cDH;
    public LinearLayout cDJ;
    public TextView cDK;
    public TextView cDL;
    public TextView cDM;
    public View cDN;
    public View cDO;
    public SparseArray<com.baidu.tieba.pb.view.i> cDP;
    public View cDU;
    public LinearLayout cDV;
    public LinearLayout cDW;
    public com.baidu.tbadk.core.view.o mNoDataView;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [79=5] */
    public m(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.cDU = view;
        this.cDC = (TbRichTextView) view.findViewById(n.g.richText);
        this.cDD = (TextView) view.findViewById(n.g.pb_act_btn);
        this.cDE = view.findViewById(n.g.pb_item_praise_topline);
        this.cDF = (FrsPraiseView) view.findViewById(n.g.pb_item_praise_view);
        this.cDG = (ImageView) view.findViewById(n.g.pb_item_praise_bottomline);
        this.cDH = (PbGiftListView) view.findViewById(n.g.gift_list_view);
        this.cDV = (LinearLayout) view.findViewById(n.g.show_pic_bottom_layout);
        this.cDJ = (LinearLayout) view.findViewById(n.g.showpic_cardview_container_ll);
        this.cDW = (LinearLayout) view.findViewById(n.g.line_tv_line);
        this.cDL = (TextView) view.findViewById(n.g.picture_list_tv);
        this.cDK = (TextView) view.findViewById(n.g.join_vote_tv);
        this.cDM = (TextView) view.findViewById(n.g.look_all_tv);
        this.cDN = view.findViewById(n.g.line_view_left);
        this.cDO = view.findViewById(n.g.line_view_right);
        this.cDC.Gd();
        this.cDC.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.cDC.getPaddingLeft()) - this.cDC.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.e.ds60)), i);
        this.cDC.setMaxImageWidth(min);
        this.cDC.setMaxImageHeight((int) (min * 1.618f));
        this.cDC.setTextSize(TbConfig.getContentSize());
        this.cDC.g(z2, false);
        this.cDC.setVoiceViewRes(n.h.voice_play_btn);
    }
}
