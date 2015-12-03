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
public class g extends x.a {
    public int afY;
    public RelativeLayout cOM;
    public TextView cON;
    public TextView cOO;
    public ImageView cOP;
    public RelativeLayout cOR;
    public HeadImageView cOS;
    public TextView cOT;
    public TextView cOU;
    public RelativeLayout cOV;
    public HeadImageView cOW;
    public TextView cOX;
    public TextView cOY;
    public View cOi;
    public View cOj;
    public LinearLayout cOl;
    public View cOr;
    public RelativeLayout cOs;
    public TextView cOt;
    public ImageView cOu;
    public TextView cOv;

    public g(View view) {
        super(view);
        this.cOr = null;
        this.cOs = null;
        this.cOt = null;
        this.cOu = null;
        this.cOv = null;
        this.cOi = null;
        this.cOR = null;
        this.cOS = null;
        this.cOT = null;
        this.cOU = null;
        this.cOj = null;
        this.cOV = null;
        this.cOW = null;
        this.cOX = null;
        this.cOY = null;
        this.cOM = null;
        this.cON = null;
        this.cOO = null;
        this.cOP = null;
        this.cOl = null;
        this.afY = 3;
        this.cOr = view.findViewById(n.f.top_divider);
        this.cOi = view.findViewById(n.f.head_divider);
        this.cOs = (RelativeLayout) view.findViewById(n.f.group_head);
        this.cOt = (TextView) this.cOs.findViewById(n.f.group_head_title);
        this.cOu = (ImageView) this.cOs.findViewById(n.f.group_head_arrow);
        this.cOv = (TextView) this.cOs.findViewById(n.f.group_head_msg);
        this.cOR = (RelativeLayout) view.findViewById(n.f.first_group_line);
        this.cOS = (HeadImageView) this.cOR.findViewById(n.f.first_group_head);
        this.cOT = (TextView) this.cOR.findViewById(n.f.first_group_name);
        this.cOU = (TextView) this.cOR.findViewById(n.f.first_group_msg);
        this.cOj = view.findViewById(n.f.mid_divider);
        this.cOV = (RelativeLayout) view.findViewById(n.f.second_group_line);
        this.cOW = (HeadImageView) this.cOV.findViewById(n.f.second_group_head);
        this.cOX = (TextView) this.cOV.findViewById(n.f.second_group_name);
        this.cOY = (TextView) this.cOV.findViewById(n.f.second_group_msg);
        this.cOM = (RelativeLayout) view.findViewById(n.f.group_none);
        this.cON = (TextView) this.cOM.findViewById(n.f.group_none_title);
        this.cOO = (TextView) this.cOM.findViewById(n.f.group_none_msg);
        this.cOP = (ImageView) this.cOM.findViewById(n.f.group_none_lock);
        this.cOl = (LinearLayout) view.findViewById(n.f.container);
    }
}
