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
public class f extends x.a {
    public FrsPraiseView cAa;
    public ImageView cAb;
    public PbGiftListView cAc;
    public LinearLayout cAd;
    public LinearLayout cAe;
    public TextView cAf;
    public TextView cAg;
    public TextView cAh;
    public View cAi;
    public View cAj;
    public SparseArray<com.baidu.tieba.pb.view.f> cAk;
    public View czW;
    public TbRichTextView czX;
    public TextView czY;
    public View czZ;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [65=5] */
    public f(View view, boolean z, int i) {
        super(view);
        this.czW = view;
        this.czX = (TbRichTextView) view.findViewById(n.f.richText);
        this.czY = (TextView) view.findViewById(n.f.pb_act_btn);
        this.czZ = view.findViewById(n.f.pb_item_praise_topline);
        this.cAa = (FrsPraiseView) view.findViewById(n.f.pb_item_praise_view);
        this.cAb = (ImageView) view.findViewById(n.f.pb_item_praise_bottomline);
        this.cAc = (PbGiftListView) view.findViewById(n.f.gift_list_view);
        this.cAd = (LinearLayout) view.findViewById(n.f.lottery_bottom_layout);
        this.cAe = (LinearLayout) view.findViewById(n.f.showpic_cardview_container_ll);
        this.cAg = (TextView) view.findViewById(n.f.picture_list_tv);
        this.cAf = (TextView) view.findViewById(n.f.join_vote_tv);
        this.cAh = (TextView) view.findViewById(n.f.look_all_tv);
        this.cAi = view.findViewById(n.f.line_view_left);
        this.cAj = view.findViewById(n.f.line_view_right);
        this.czX.Go();
        this.czX.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.czX.getPaddingLeft()) - this.czX.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.d.ds60)), i);
        this.czX.setMaxImageWidth(min);
        this.czX.setMaxImageHeight((int) (min * 1.618f));
        this.czX.setTextSize(TbConfig.getContentSize());
        this.czX.f(z, false);
        this.czX.setVoiceViewRes(n.g.voice_play_btn);
    }
}
