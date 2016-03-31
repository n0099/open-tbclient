package com.baidu.tieba.person.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k extends x.a {
    public View dyN;
    public RelativeLayout dzA;
    public TextView dzB;
    public ImageView dzC;
    public ImageView dzD;
    public ViewGroup dzE;
    public ImageView dzF;
    public TextView dzG;
    public TextView dzH;
    public LinearLayout dzI;
    public ImageView dzJ;
    public View dzK;
    public int mSkinType;

    public k(View view) {
        super(view);
        this.mSkinType = 3;
        this.dyN = null;
        this.dzA = null;
        this.dzB = null;
        this.dzC = null;
        this.dzD = null;
        this.dyN = view.findViewById(t.g.top_divider);
        this.dzA = (RelativeLayout) view.findViewById(t.g.live_thread_item);
        this.dzB = (TextView) view.findViewById(t.g.live_thread_item_title);
        this.dzD = (ImageView) view.findViewById(t.g.live_thread_item_icon);
        this.dzC = (ImageView) view.findViewById(t.g.live_thread_item_arrow);
        this.dzE = (ViewGroup) view.findViewById(t.g.live_mission_item);
        this.dzF = (ImageView) this.dzE.findViewById(t.g.live_mission_icon);
        this.dzG = (TextView) this.dzE.findViewById(t.g.live_mission_title);
        this.dzH = (TextView) this.dzE.findViewById(t.g.live_mission_unlock);
        this.dzI = (LinearLayout) this.dzE.findViewById(t.g.live_mission_profit_layout);
        this.dzJ = (ImageView) this.dzE.findViewById(t.g.live_mission_arrow);
        this.dzK = this.dzE.findViewById(t.g.mission_divider);
    }
}
