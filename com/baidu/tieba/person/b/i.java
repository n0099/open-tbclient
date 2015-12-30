package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class i extends x.a {
    public int ahf;
    public View cSR;
    public View cSS;
    public LinearLayout cSU;
    public RelativeLayout cTB;
    public HeadImageView cTC;
    public TextView cTD;
    public TextView cTE;
    public RelativeLayout cTF;
    public HeadImageView cTG;
    public TextView cTH;
    public TextView cTI;
    public View cTb;
    public RelativeLayout cTc;
    public TextView cTd;
    public ImageView cTe;
    public TextView cTf;
    public RelativeLayout cTw;
    public TextView cTx;
    public TextView cTy;
    public ImageView cTz;

    public i(View view) {
        super(view);
        this.cTb = null;
        this.cTc = null;
        this.cTd = null;
        this.cTe = null;
        this.cTf = null;
        this.cSR = null;
        this.cTB = null;
        this.cTC = null;
        this.cTD = null;
        this.cTE = null;
        this.cSS = null;
        this.cTF = null;
        this.cTG = null;
        this.cTH = null;
        this.cTI = null;
        this.cTw = null;
        this.cTx = null;
        this.cTy = null;
        this.cTz = null;
        this.cSU = null;
        this.ahf = 3;
        this.cTb = view.findViewById(n.g.top_divider);
        this.cSR = view.findViewById(n.g.head_divider);
        this.cTc = (RelativeLayout) view.findViewById(n.g.group_head);
        this.cTd = (TextView) this.cTc.findViewById(n.g.group_head_title);
        this.cTe = (ImageView) this.cTc.findViewById(n.g.group_head_arrow);
        this.cTf = (TextView) this.cTc.findViewById(n.g.group_head_msg);
        this.cTB = (RelativeLayout) view.findViewById(n.g.first_group_line);
        this.cTC = (HeadImageView) this.cTB.findViewById(n.g.first_group_head);
        this.cTD = (TextView) this.cTB.findViewById(n.g.first_group_name);
        this.cTE = (TextView) this.cTB.findViewById(n.g.first_group_msg);
        this.cSS = view.findViewById(n.g.mid_divider);
        this.cTF = (RelativeLayout) view.findViewById(n.g.second_group_line);
        this.cTG = (HeadImageView) this.cTF.findViewById(n.g.second_group_head);
        this.cTH = (TextView) this.cTF.findViewById(n.g.second_group_name);
        this.cTI = (TextView) this.cTF.findViewById(n.g.second_group_msg);
        this.cTw = (RelativeLayout) view.findViewById(n.g.group_none);
        this.cTx = (TextView) this.cTw.findViewById(n.g.group_none_title);
        this.cTy = (TextView) this.cTw.findViewById(n.g.group_none_msg);
        this.cTz = (ImageView) this.cTw.findViewById(n.g.group_none_lock);
        this.cSU = (LinearLayout) view.findViewById(n.g.container);
    }
}
