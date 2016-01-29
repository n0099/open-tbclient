package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends x.a {
    public int ahU;
    public View biq;
    public ImageView ddU;
    public TextView ddV;
    public ImageView ddW;
    public View den;

    public h(View view) {
        super(view);
        this.ahU = 3;
        this.biq = view.findViewById(t.g.friendfeed_divider);
        this.ddU = (ImageView) view.findViewById(t.g.friend_feed_icon);
        this.ddV = (TextView) view.findViewById(t.g.friend_feed_title);
        this.ddW = (ImageView) view.findViewById(t.g.nav_indicator);
        this.den = view.findViewById(t.g.friendfeed_bottom_divider);
    }
}
