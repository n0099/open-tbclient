package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j extends x.a {
    public int ahU;
    public RelativeLayout deK;
    public TextView deL;
    public TextView deM;
    public ImageView deN;
    public RelativeLayout deT;
    public HeadImageView deU;
    public TextView deV;
    public TextView deW;
    public RelativeLayout deX;
    public HeadImageView deY;
    public TextView deZ;
    public View def;
    public LinearLayout deh;
    public View deo;
    public RelativeLayout dep;
    public TextView deq;
    public ImageView der;
    public TextView des;
    public View det;
    public TextView dfa;

    public j(View view) {
        super(view);
        this.deo = null;
        this.dep = null;
        this.deq = null;
        this.der = null;
        this.des = null;
        this.det = null;
        this.deT = null;
        this.deU = null;
        this.deV = null;
        this.deW = null;
        this.def = null;
        this.deX = null;
        this.deY = null;
        this.deZ = null;
        this.dfa = null;
        this.deK = null;
        this.deL = null;
        this.deM = null;
        this.deN = null;
        this.deh = null;
        this.ahU = 3;
        this.deo = view.findViewById(t.g.top_divider);
        this.det = view.findViewById(t.g.head_divider);
        this.dep = (RelativeLayout) view.findViewById(t.g.group_head);
        this.deq = (TextView) this.dep.findViewById(t.g.group_head_title);
        this.der = (ImageView) this.dep.findViewById(t.g.group_head_arrow);
        this.des = (TextView) this.dep.findViewById(t.g.group_head_msg);
        this.deT = (RelativeLayout) view.findViewById(t.g.first_group_line);
        this.deU = (HeadImageView) this.deT.findViewById(t.g.first_group_head);
        this.deV = (TextView) this.deT.findViewById(t.g.first_group_name);
        this.deW = (TextView) this.deT.findViewById(t.g.first_group_msg);
        this.def = view.findViewById(t.g.mid_divider);
        this.deX = (RelativeLayout) view.findViewById(t.g.second_group_line);
        this.deY = (HeadImageView) this.deX.findViewById(t.g.second_group_head);
        this.deZ = (TextView) this.deX.findViewById(t.g.second_group_name);
        this.dfa = (TextView) this.deX.findViewById(t.g.second_group_msg);
        this.deK = (RelativeLayout) view.findViewById(t.g.group_none);
        this.deL = (TextView) this.deK.findViewById(t.g.group_none_title);
        this.deM = (TextView) this.deK.findViewById(t.g.group_none_msg);
        this.deN = (ImageView) this.deK.findViewById(t.g.group_none_lock);
        this.deh = (LinearLayout) view.findViewById(t.g.container);
    }
}
