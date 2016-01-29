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
    public View deo;
    public RelativeLayout dfb;
    public TextView dfc;
    public ImageView dfd;
    public ImageView dfe;
    public ViewGroup dff;
    public ImageView dfg;
    public TextView dfh;
    public TextView dfi;
    public LinearLayout dfj;
    public ImageView dfk;
    public View dfl;
    public int mSkinType;

    public k(View view) {
        super(view);
        this.mSkinType = 3;
        this.deo = null;
        this.dfb = null;
        this.dfc = null;
        this.dfd = null;
        this.dfe = null;
        this.deo = view.findViewById(t.g.top_divider);
        this.dfb = (RelativeLayout) view.findViewById(t.g.live_thread_item);
        this.dfc = (TextView) view.findViewById(t.g.live_thread_item_title);
        this.dfe = (ImageView) view.findViewById(t.g.live_thread_item_icon);
        this.dfd = (ImageView) view.findViewById(t.g.live_thread_item_arrow);
        this.dff = (ViewGroup) view.findViewById(t.g.live_mission_item);
        this.dfg = (ImageView) this.dff.findViewById(t.g.live_mission_icon);
        this.dfh = (TextView) this.dff.findViewById(t.g.live_mission_title);
        this.dfi = (TextView) this.dff.findViewById(t.g.live_mission_unlock);
        this.dfj = (LinearLayout) this.dff.findViewById(t.g.live_mission_profit_layout);
        this.dfk = (ImageView) this.dff.findViewById(t.g.live_mission_arrow);
        this.dfl = this.dff.findViewById(t.g.mission_divider);
    }
}
