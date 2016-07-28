package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class k extends y.a {
    public int afy;
    public View euN;
    public LinearLayout euP;
    public View euV;
    public RelativeLayout euW;
    public TextView euX;
    public ImageView euY;
    public TextView euZ;
    public RelativeLayout evA;
    public HeadImageView evB;
    public TextView evC;
    public TextView evD;
    public RelativeLayout evE;
    public HeadImageView evF;
    public TextView evG;
    public TextView evH;
    public View eva;
    public RelativeLayout evr;
    public TextView evs;
    public TextView evt;
    public ImageView evu;

    public k(View view) {
        super(view);
        this.euV = null;
        this.euW = null;
        this.euX = null;
        this.euY = null;
        this.euZ = null;
        this.eva = null;
        this.evA = null;
        this.evB = null;
        this.evC = null;
        this.evD = null;
        this.euN = null;
        this.evE = null;
        this.evF = null;
        this.evG = null;
        this.evH = null;
        this.evr = null;
        this.evs = null;
        this.evt = null;
        this.evu = null;
        this.euP = null;
        this.afy = 3;
        this.euV = view.findViewById(u.g.top_divider);
        this.eva = view.findViewById(u.g.head_divider);
        this.euW = (RelativeLayout) view.findViewById(u.g.group_head);
        this.euX = (TextView) this.euW.findViewById(u.g.group_head_title);
        this.euY = (ImageView) this.euW.findViewById(u.g.group_head_arrow);
        this.euZ = (TextView) this.euW.findViewById(u.g.group_head_msg);
        this.evA = (RelativeLayout) view.findViewById(u.g.first_group_line);
        this.evB = (HeadImageView) this.evA.findViewById(u.g.first_group_head);
        this.evC = (TextView) this.evA.findViewById(u.g.first_group_name);
        this.evD = (TextView) this.evA.findViewById(u.g.first_group_msg);
        this.euN = view.findViewById(u.g.mid_divider);
        this.evE = (RelativeLayout) view.findViewById(u.g.second_group_line);
        this.evF = (HeadImageView) this.evE.findViewById(u.g.second_group_head);
        this.evG = (TextView) this.evE.findViewById(u.g.second_group_name);
        this.evH = (TextView) this.evE.findViewById(u.g.second_group_msg);
        this.evr = (RelativeLayout) view.findViewById(u.g.group_none);
        this.evs = (TextView) this.evr.findViewById(u.g.group_none_title);
        this.evt = (TextView) this.evr.findViewById(u.g.group_none_msg);
        this.evu = (ImageView) this.evr.findViewById(u.g.group_none_lock);
        this.euP = (LinearLayout) view.findViewById(u.g.container);
    }
}
