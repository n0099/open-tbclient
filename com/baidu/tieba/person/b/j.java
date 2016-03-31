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
    public int aik;
    public View dyF;
    public LinearLayout dyH;
    public View dyN;
    public RelativeLayout dyO;
    public TextView dyP;
    public ImageView dyQ;
    public TextView dyR;
    public View dyS;
    public RelativeLayout dzj;
    public TextView dzk;
    public TextView dzl;
    public ImageView dzm;
    public RelativeLayout dzs;
    public HeadImageView dzt;
    public TextView dzu;
    public TextView dzv;
    public RelativeLayout dzw;
    public HeadImageView dzx;
    public TextView dzy;
    public TextView dzz;

    public j(View view) {
        super(view);
        this.dyN = null;
        this.dyO = null;
        this.dyP = null;
        this.dyQ = null;
        this.dyR = null;
        this.dyS = null;
        this.dzs = null;
        this.dzt = null;
        this.dzu = null;
        this.dzv = null;
        this.dyF = null;
        this.dzw = null;
        this.dzx = null;
        this.dzy = null;
        this.dzz = null;
        this.dzj = null;
        this.dzk = null;
        this.dzl = null;
        this.dzm = null;
        this.dyH = null;
        this.aik = 3;
        this.dyN = view.findViewById(t.g.top_divider);
        this.dyS = view.findViewById(t.g.head_divider);
        this.dyO = (RelativeLayout) view.findViewById(t.g.group_head);
        this.dyP = (TextView) this.dyO.findViewById(t.g.group_head_title);
        this.dyQ = (ImageView) this.dyO.findViewById(t.g.group_head_arrow);
        this.dyR = (TextView) this.dyO.findViewById(t.g.group_head_msg);
        this.dzs = (RelativeLayout) view.findViewById(t.g.first_group_line);
        this.dzt = (HeadImageView) this.dzs.findViewById(t.g.first_group_head);
        this.dzu = (TextView) this.dzs.findViewById(t.g.first_group_name);
        this.dzv = (TextView) this.dzs.findViewById(t.g.first_group_msg);
        this.dyF = view.findViewById(t.g.mid_divider);
        this.dzw = (RelativeLayout) view.findViewById(t.g.second_group_line);
        this.dzx = (HeadImageView) this.dzw.findViewById(t.g.second_group_head);
        this.dzy = (TextView) this.dzw.findViewById(t.g.second_group_name);
        this.dzz = (TextView) this.dzw.findViewById(t.g.second_group_msg);
        this.dzj = (RelativeLayout) view.findViewById(t.g.group_none);
        this.dzk = (TextView) this.dzj.findViewById(t.g.group_none_title);
        this.dzl = (TextView) this.dzj.findViewById(t.g.group_none_msg);
        this.dzm = (ImageView) this.dzj.findViewById(t.g.group_none_lock);
        this.dyH = (LinearLayout) view.findViewById(t.g.container);
    }
}
