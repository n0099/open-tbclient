package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends x.a {
    public int aik;
    public View bnb;
    public ImageView cJc;
    public TextView dyv;
    public ImageView dyw;

    public f(View view) {
        super(view);
        this.aik = 3;
        this.bnb = view.findViewById(t.g.friendfeed_divider);
        this.cJc = (ImageView) view.findViewById(t.g.forum_feed_icon);
        this.dyv = (TextView) view.findViewById(t.g.forum_feed_title);
        this.dyw = (ImageView) view.findViewById(t.g.nav_indicator);
    }
}
