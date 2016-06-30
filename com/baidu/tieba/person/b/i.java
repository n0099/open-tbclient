package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class i extends y.a {
    public int aeK;
    public View bLB;
    public View bni;
    public ImageView dpJ;
    public TextView ekg;
    public ImageView ekh;

    public i(View view) {
        super(view);
        this.aeK = 3;
        this.bLB = view.findViewById(u.g.friendfeed_divider);
        this.dpJ = (ImageView) view.findViewById(u.g.friend_feed_icon);
        this.ekg = (TextView) view.findViewById(u.g.friend_feed_title);
        this.ekh = (ImageView) view.findViewById(u.g.nav_indicator);
        this.bni = view.findViewById(u.g.friendfeed_bottom_divider);
    }
}
