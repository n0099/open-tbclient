package com.baidu.tieba.person.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class l extends y.a {
    public View euV;
    public RelativeLayout evI;
    public TextView evJ;
    public ImageView evK;
    public ImageView evL;
    public ViewGroup evM;
    public ImageView evN;
    public TextView evO;
    public TextView evP;
    public LinearLayout evQ;
    public ImageView evR;
    public View evS;
    public int mSkinType;

    public l(View view) {
        super(view);
        this.mSkinType = 3;
        this.euV = null;
        this.evI = null;
        this.evJ = null;
        this.evK = null;
        this.evL = null;
        this.euV = view.findViewById(u.g.top_divider);
        this.evI = (RelativeLayout) view.findViewById(u.g.live_thread_item);
        this.evJ = (TextView) view.findViewById(u.g.live_thread_item_title);
        this.evL = (ImageView) view.findViewById(u.g.live_thread_item_icon);
        this.evK = (ImageView) view.findViewById(u.g.live_thread_item_arrow);
        this.evM = (ViewGroup) view.findViewById(u.g.live_mission_item);
        this.evN = (ImageView) this.evM.findViewById(u.g.live_mission_icon);
        this.evO = (TextView) this.evM.findViewById(u.g.live_mission_title);
        this.evP = (TextView) this.evM.findViewById(u.g.live_mission_unlock);
        this.evQ = (LinearLayout) this.evM.findViewById(u.g.live_mission_profit_layout);
        this.evR = (ImageView) this.evM.findViewById(u.g.live_mission_arrow);
        this.evS = this.evM.findViewById(u.g.mission_divider);
    }
}
