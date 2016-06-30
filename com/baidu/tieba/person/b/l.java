package com.baidu.tieba.person.b;

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
    public View eky;
    public RelativeLayout ell;
    public TextView elm;
    public ImageView eln;
    public ImageView elo;
    public ViewGroup elp;
    public ImageView elq;
    public TextView elr;
    public TextView els;
    public LinearLayout elt;
    public ImageView elu;
    public View elv;
    public int mSkinType;

    public l(View view) {
        super(view);
        this.mSkinType = 3;
        this.eky = null;
        this.ell = null;
        this.elm = null;
        this.eln = null;
        this.elo = null;
        this.eky = view.findViewById(u.g.top_divider);
        this.ell = (RelativeLayout) view.findViewById(u.g.live_thread_item);
        this.elm = (TextView) view.findViewById(u.g.live_thread_item_title);
        this.elo = (ImageView) view.findViewById(u.g.live_thread_item_icon);
        this.eln = (ImageView) view.findViewById(u.g.live_thread_item_arrow);
        this.elp = (ViewGroup) view.findViewById(u.g.live_mission_item);
        this.elq = (ImageView) this.elp.findViewById(u.g.live_mission_icon);
        this.elr = (TextView) this.elp.findViewById(u.g.live_mission_title);
        this.els = (TextView) this.elp.findViewById(u.g.live_mission_unlock);
        this.elt = (LinearLayout) this.elp.findViewById(u.g.live_mission_profit_layout);
        this.elu = (ImageView) this.elp.findViewById(u.g.live_mission_arrow);
        this.elv = this.elp.findViewById(u.g.mission_divider);
    }
}
