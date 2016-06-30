package com.baidu.tieba.person.b;

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
    public int aeK;
    public TextView ekA;
    public ImageView ekB;
    public TextView ekC;
    public View ekD;
    public RelativeLayout ekU;
    public TextView ekV;
    public TextView ekW;
    public ImageView ekX;
    public View ekq;
    public LinearLayout eks;
    public View eky;
    public RelativeLayout ekz;
    public RelativeLayout eld;
    public HeadImageView ele;
    public TextView elf;
    public TextView elg;
    public RelativeLayout elh;
    public HeadImageView eli;
    public TextView elj;
    public TextView elk;

    public k(View view) {
        super(view);
        this.eky = null;
        this.ekz = null;
        this.ekA = null;
        this.ekB = null;
        this.ekC = null;
        this.ekD = null;
        this.eld = null;
        this.ele = null;
        this.elf = null;
        this.elg = null;
        this.ekq = null;
        this.elh = null;
        this.eli = null;
        this.elj = null;
        this.elk = null;
        this.ekU = null;
        this.ekV = null;
        this.ekW = null;
        this.ekX = null;
        this.eks = null;
        this.aeK = 3;
        this.eky = view.findViewById(u.g.top_divider);
        this.ekD = view.findViewById(u.g.head_divider);
        this.ekz = (RelativeLayout) view.findViewById(u.g.group_head);
        this.ekA = (TextView) this.ekz.findViewById(u.g.group_head_title);
        this.ekB = (ImageView) this.ekz.findViewById(u.g.group_head_arrow);
        this.ekC = (TextView) this.ekz.findViewById(u.g.group_head_msg);
        this.eld = (RelativeLayout) view.findViewById(u.g.first_group_line);
        this.ele = (HeadImageView) this.eld.findViewById(u.g.first_group_head);
        this.elf = (TextView) this.eld.findViewById(u.g.first_group_name);
        this.elg = (TextView) this.eld.findViewById(u.g.first_group_msg);
        this.ekq = view.findViewById(u.g.mid_divider);
        this.elh = (RelativeLayout) view.findViewById(u.g.second_group_line);
        this.eli = (HeadImageView) this.elh.findViewById(u.g.second_group_head);
        this.elj = (TextView) this.elh.findViewById(u.g.second_group_name);
        this.elk = (TextView) this.elh.findViewById(u.g.second_group_msg);
        this.ekU = (RelativeLayout) view.findViewById(u.g.group_none);
        this.ekV = (TextView) this.ekU.findViewById(u.g.group_none_title);
        this.ekW = (TextView) this.ekU.findViewById(u.g.group_none_msg);
        this.ekX = (ImageView) this.ekU.findViewById(u.g.group_none_lock);
        this.eks = (LinearLayout) view.findViewById(u.g.container);
    }
}
