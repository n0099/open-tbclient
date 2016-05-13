package com.baidu.tieba.pb.pb.a;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class q extends y.a {
    public View DM;
    public TbRichTextView dfT;
    public View dfU;
    public PbGiftListView dfV;
    public FrsPraiseView dfW;
    public ImageView dfX;
    public TextView dgd;
    public LinearLayout dgf;
    public TextView dgg;
    public TextView dgh;
    public TextView dgi;
    public View dgj;
    public View dgk;
    public SparseArray<com.baidu.tieba.pb.view.r> dgl;
    public View dgo;
    public LinearLayout dgp;
    public LinearLayout dgq;
    public com.baidu.tbadk.core.view.q mNoDataView;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [84=5] */
    public q(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.mSkinType = 3;
        this.dgo = view;
        this.dfT = (TbRichTextView) view.findViewById(t.g.richText);
        this.dgd = (TextView) view.findViewById(t.g.pb_act_btn);
        this.dfU = view.findViewById(t.g.pb_item_praise_topline);
        this.dfW = (FrsPraiseView) view.findViewById(t.g.pb_item_praise_view);
        this.dfX = (ImageView) view.findViewById(t.g.pb_item_praise_bottomline);
        this.dfV = (PbGiftListView) view.findViewById(t.g.gift_list_view);
        this.dgp = (LinearLayout) view.findViewById(t.g.show_pic_bottom_layout);
        this.dgf = (LinearLayout) view.findViewById(t.g.showpic_cardview_container_ll);
        this.dgq = (LinearLayout) view.findViewById(t.g.line_tv_line);
        this.dgh = (TextView) view.findViewById(t.g.picture_list_tv);
        this.dgg = (TextView) view.findViewById(t.g.join_vote_tv);
        this.dgi = (TextView) view.findViewById(t.g.look_all_tv);
        this.dgj = view.findViewById(t.g.line_view_left);
        this.dgk = view.findViewById(t.g.line_view_right);
        this.DM = view.findViewById(t.g.item_bottom_line_full);
        this.dfT.Hq();
        this.dfT.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.dfT.getPaddingLeft()) - this.dfT.getPaddingRight()) - ((int) TbadkCoreApplication.m11getInst().getResources().getDimension(t.e.ds60)), i);
        this.dfT.setMaxImageWidth(min);
        this.dfT.setMaxImageHeight((int) (min * 1.618f));
        this.dfT.setTextSize(TbConfig.getContentSize());
        this.dfT.h(z2, false);
        this.dfT.setVoiceViewRes(t.h.voice_play_btn);
    }
}
