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
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class m extends x.a {
    public TbRichTextView chB;
    public TextView chC;
    public View chD;
    public FrsPraiseView chE;
    public ImageView chF;
    public LinearLayout chH;
    public TextView chI;
    public TextView chJ;
    public TextView chK;
    public View chL;
    public View chM;
    public SparseArray<com.baidu.tieba.pb.view.e> chN;
    public View chS;
    public LinearLayout chT;
    public LinearLayout chU;
    public com.baidu.tbadk.core.view.m mNoDataView;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [76=5] */
    public m(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.chS = view;
        this.chB = (TbRichTextView) view.findViewById(i.f.richText);
        this.chC = (TextView) view.findViewById(i.f.pb_act_btn);
        this.chD = view.findViewById(i.f.pb_item_praise_topline);
        this.chE = (FrsPraiseView) view.findViewById(i.f.pb_item_praise_view);
        this.chF = (ImageView) view.findViewById(i.f.pb_item_praise_bottomline);
        this.chT = (LinearLayout) view.findViewById(i.f.show_pic_bottom_layout);
        this.chH = (LinearLayout) view.findViewById(i.f.showpic_cardview_container_ll);
        this.chU = (LinearLayout) view.findViewById(i.f.line_tv_line);
        this.chJ = (TextView) view.findViewById(i.f.picture_list_tv);
        this.chI = (TextView) view.findViewById(i.f.join_vote_tv);
        this.chK = (TextView) view.findViewById(i.f.look_all_tv);
        this.chL = view.findViewById(i.f.line_view_left);
        this.chM = view.findViewById(i.f.line_view_right);
        this.chB.Fj();
        this.chB.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.chB.getPaddingLeft()) - this.chB.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds60)), i);
        this.chB.setMaxImageWidth(min);
        this.chB.setMaxImageHeight((int) (min * 1.618f));
        this.chB.setTextSize(TbConfig.getContentSize());
        this.chB.f(z2, false);
        this.chB.setVoiceViewRes(i.g.voice_play_btn);
    }
}
