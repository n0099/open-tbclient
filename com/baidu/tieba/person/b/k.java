package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k extends y.a {
    public int aej;
    public View dBN;
    public LinearLayout dBP;
    public View dBV;
    public RelativeLayout dBW;
    public TextView dBX;
    public ImageView dBY;
    public TextView dBZ;
    public RelativeLayout dCA;
    public HeadImageView dCB;
    public TextView dCC;
    public TextView dCD;
    public RelativeLayout dCE;
    public HeadImageView dCF;
    public TextView dCG;
    public TextView dCH;
    public View dCa;
    public RelativeLayout dCr;
    public TextView dCs;
    public TextView dCt;
    public ImageView dCu;

    public k(View view) {
        super(view);
        this.dBV = null;
        this.dBW = null;
        this.dBX = null;
        this.dBY = null;
        this.dBZ = null;
        this.dCa = null;
        this.dCA = null;
        this.dCB = null;
        this.dCC = null;
        this.dCD = null;
        this.dBN = null;
        this.dCE = null;
        this.dCF = null;
        this.dCG = null;
        this.dCH = null;
        this.dCr = null;
        this.dCs = null;
        this.dCt = null;
        this.dCu = null;
        this.dBP = null;
        this.aej = 3;
        this.dBV = view.findViewById(t.g.top_divider);
        this.dCa = view.findViewById(t.g.head_divider);
        this.dBW = (RelativeLayout) view.findViewById(t.g.group_head);
        this.dBX = (TextView) this.dBW.findViewById(t.g.group_head_title);
        this.dBY = (ImageView) this.dBW.findViewById(t.g.group_head_arrow);
        this.dBZ = (TextView) this.dBW.findViewById(t.g.group_head_msg);
        this.dCA = (RelativeLayout) view.findViewById(t.g.first_group_line);
        this.dCB = (HeadImageView) this.dCA.findViewById(t.g.first_group_head);
        this.dCC = (TextView) this.dCA.findViewById(t.g.first_group_name);
        this.dCD = (TextView) this.dCA.findViewById(t.g.first_group_msg);
        this.dBN = view.findViewById(t.g.mid_divider);
        this.dCE = (RelativeLayout) view.findViewById(t.g.second_group_line);
        this.dCF = (HeadImageView) this.dCE.findViewById(t.g.second_group_head);
        this.dCG = (TextView) this.dCE.findViewById(t.g.second_group_name);
        this.dCH = (TextView) this.dCE.findViewById(t.g.second_group_msg);
        this.dCr = (RelativeLayout) view.findViewById(t.g.group_none);
        this.dCs = (TextView) this.dCr.findViewById(t.g.group_none_title);
        this.dCt = (TextView) this.dCr.findViewById(t.g.group_none_msg);
        this.dCu = (ImageView) this.dCr.findViewById(t.g.group_none_lock);
        this.dBP = (LinearLayout) view.findViewById(t.g.container);
    }
}
