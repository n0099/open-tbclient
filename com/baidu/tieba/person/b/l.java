package com.baidu.tieba.person.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l extends y.a {
    public View dBV;
    public RelativeLayout dCI;
    public TextView dCJ;
    public ImageView dCK;
    public ImageView dCL;
    public ViewGroup dCM;
    public ImageView dCN;
    public TextView dCO;
    public TextView dCP;
    public LinearLayout dCQ;
    public ImageView dCR;
    public View dCS;
    public int mSkinType;

    public l(View view) {
        super(view);
        this.mSkinType = 3;
        this.dBV = null;
        this.dCI = null;
        this.dCJ = null;
        this.dCK = null;
        this.dCL = null;
        this.dBV = view.findViewById(t.g.top_divider);
        this.dCI = (RelativeLayout) view.findViewById(t.g.live_thread_item);
        this.dCJ = (TextView) view.findViewById(t.g.live_thread_item_title);
        this.dCL = (ImageView) view.findViewById(t.g.live_thread_item_icon);
        this.dCK = (ImageView) view.findViewById(t.g.live_thread_item_arrow);
        this.dCM = (ViewGroup) view.findViewById(t.g.live_mission_item);
        this.dCN = (ImageView) this.dCM.findViewById(t.g.live_mission_icon);
        this.dCO = (TextView) this.dCM.findViewById(t.g.live_mission_title);
        this.dCP = (TextView) this.dCM.findViewById(t.g.live_mission_unlock);
        this.dCQ = (LinearLayout) this.dCM.findViewById(t.g.live_mission_profit_layout);
        this.dCR = (ImageView) this.dCM.findViewById(t.g.live_mission_arrow);
        this.dCS = this.dCM.findViewById(t.g.mission_divider);
    }
}
